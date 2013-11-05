package frontend;



import identifier_objects.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import antlr.BasicLexer;
import antlr.BasicParser;
import antlr.BasicParser.Assign_rhsContext;
import antlr.BasicParser.Binary_operContext;
import antlr.BasicParser.ExprContext;
import antlr.BasicParser.Param_listContext;
import antlr.BasicParser.ProgContext;
import antlr.BasicParser.StatContext;
import antlr.BasicParserBaseVisitor;


public class TreeWalker extends BasicParserBaseVisitor<Type>{

	private ProgContext tree;
	private SymbolTable st;
	private String currFunc;

	public TreeWalker(ProgContext t){
		tree = t;
		st = new SymbolTable(null); 
	}

	public void validateSemantics(){
		visitProg(tree);
	}
	
	private Identifier getIdent(String identName){
		Identifier ident = st.lookUpCurrLevelAndEnclosingLevels(identName);
		if(ident == null){
			System.err.println("Identifier Not Declared");
		    return new Variable(Type.ANY);
		}
		return ident;
	}

	private boolean typeMatch(Type t1, Type t2){
		if(t1 == Type.ANY || t2 == Type.ANY){
			return true;
		}
		if(t1 != t2){
			//Semantic Error: Types do not match
			System.err.println("Type Error");
			return false;
		}
		return true;

	}

	private Type getType(String type){
		if(token(type).equals(getToken(BasicLexer.INT))){
			return Type.INT;
		} if(token(type).equals(getToken(BasicLexer.BOOL))){
			return Type.BOOL;
		} if(token(type).equals(getToken(BasicLexer.CHAR))){
			return Type.CHAR;
		} if(token(type).equals(getToken(BasicLexer.STRING))){
			return Type.STRING;
		} 

		return null;
	}

	private String token(String str){
		return "'"+str+"'";
	}
	
	private String getToken(int token){
		return BasicLexer.tokenNames[token];
	}

	@Override public Type visitProgram(@NotNull BasicParser.ProgramContext ctx) {
		st = new SymbolTable(st);
		visitChildren(ctx);
		st = st.getParent();
		return null;
	}

	@Override public Type visitFunc(@NotNull BasicParser.FuncContext ctx) {

		Function func = new Function(getType(ctx.getChild(0).getText()));
		currFunc = ctx.getChild(1).getText();
		st.add(currFunc,func);

		st = new SymbolTable(st);
		int funcBody = 5;
		
		if(ctx.getChildCount() == 8){
			//Has Parameters
			visitParam_list((Param_listContext) ctx.getChild(3));
			funcBody = 6;
		}

		visitStat((StatContext) ctx.getChild(funcBody));

		func.addST(st);
		st = st.getParent();

		currFunc = "";

		return null;
	}

	@Override public Type visitParam(@NotNull BasicParser.ParamContext ctx) {

		Type type = getType(ctx.getChild(0).getText());
		((Function) st.lookupCurrLevelOnly(currFunc)).addParam(type);

		String name = ctx.getChild(1).getText();
		st.add(name, new Variable(type));

		return type;

	}

	@Override public Type visitStat(@NotNull BasicParser.StatContext ctx) {
		
		if(ctx.getChild(0) instanceof BasicParser.StatContext){
			return visitChildren(ctx);
		}
		
		if (ctx.getChild(0).getText().equals("return")){
			if(currFunc != ""){
				System.err.println("Return out of bounds");
			}
		} else if (ctx.getChild(0).getText().equals("while")) {
			st = new SymbolTable(st);
			visitExpr((ExprContext) ctx.getChild(1));
			visitStat((StatContext) ctx.getChild(3));			
			st = st.getParent();
		} else if (ctx.getChild(0).getText().equals("if")) {
			st = new SymbolTable(st);
			visitExpr((ExprContext) ctx.getChild(1));
			visitStat((StatContext) ctx.getChild(3));
			visitStat((StatContext) ctx.getChild(5));
			st = st.getParent();
		} else if (ctx.getChild(1).getText().equals("=")) {
			//found assignment
			ParseTree curr = ctx.getChild(0).getChild(0);//Curr = LHS first Child
			if(curr instanceof BasicParser.Pair_elemContext){
				//pair_elem
				curr = curr.getChild(1);//Get Pair_elem expr
			}
			while (!(curr instanceof BasicParser.IdentContext)) {
				curr = curr.getChild(0);
			}
			String varName = curr.getText();
			
			Variable var = ((Variable) getIdent(varName));
			Type type = var.getType();
			
			if(type == Type.PAIR){
				if(ctx.getChild(0).getChild(0).getChild(0).getText().equals("fst")){
					type = ((Pair) var).getF();
				} else {
					type = ((Pair) var).getS();
				}
			}
		
			typeMatch(type, visitAssign_rhs((Assign_rhsContext) ctx.getChild(2)));
		} else if (ctx.getChildCount() > 2 && ctx.getChild(2).getText().equals("=")) {
			//found declaration
			String name = ctx.getChild(1).getText();
			
			if(st.lookUpCurrLevelAndEnclosingLevels(name) != null){
				System.err.println("Redeclaration Error");
			}
			
			Type type = getType(ctx.getChild(0).getText());
			ParseTree rhs = ctx.getChild(3);
			if (type == Type.PAIR) {
				Type fst = getType(rhs.getChild(2).getText());
				Type snd = getType(rhs.getChild(4).getText());
				st.add(name, new Pair(fst, snd));
			} else if (rhs.getChild(0).getText() == "["){
				Array arr = new Array(type);
				for (int i = 1, j = 0 ; i < rhs.getChild(0).getChildCount() - 1 ; i += 2, j++) {
					Type[] elems = arr.getElems();
					elems[j] = getType(rhs.getChild(0).getChild(i).getText());
				}
				st.add(name, arr);
			} else {
				st.add(name, new Variable(type));
			}
			typeMatch(type, visitAssign_rhs((Assign_rhsContext) rhs));
		} else if (ctx.getChild(0).getText().equals("print") || ctx.getChild(0).getText().equals("println")) {
			return visitExpr((ExprContext) ctx.getChild(1));
		}
		return null;		
	}
	
	@Override public Type visitAssign_rhs(@NotNull BasicParser.Assign_rhsContext ctx) {
		ParseTree child = ctx.getChild(0);
		if (child.getText() == "newpair") {
			//Found newpair
			visitExpr((ExprContext) ctx.getChild(2));
			visitExpr((ExprContext) ctx.getChild(4));
			return Type.PAIR;
		} else if (child.getChild(0).getText() == "[") {
			//Found array_liter
			if (ctx.getChildCount() == 2) {
				return Type.ANY;
			} else if (ctx.getChildCount() == 3) {
				return visitExpr((ExprContext) ctx.getChild(1));
			} else {
				Type prevType;
				Type currType = null;
				for (int i = 2 ; i < ctx.getChildCount() - 1 ; i++) {
					prevType = visitExpr((ExprContext) ctx.getChild(i - 1));
					currType = visitExpr((ExprContext) ctx.getChild(i));
					typeMatch(currType, prevType);			
				}
				return currType;
			}
		} else if (child.getChild(0).getText() == "fst" || child.getChild(0).getText() == "snd") {
			//Found pair_elem
			visitExpr((ExprContext) ctx.getChild(1));
			return Type.PAIR;
		} else if (child.getText() == "call"){
			//Found call
			String func = ctx.getChild(1).getText();
			Function f = (Function) getIdent(func);
			if (f.getParams().length != ctx.getChild(3).getChildCount()) {
				System.err.println("Incorrect number of parameters in call");
	            return null;
			}
			Type[] params = f.getParams();
			for (int i = 0, j = 0 ; i < ctx.getChild(3).getChildCount() && j < params.length ; i += 2, j++) {
				Type currType = visitExpr((ExprContext) ctx.getChild(i));
				typeMatch(currType, params[j]);
			}
			return f.getReturnType();
		} else {
			//Found expr
			return visitExpr((ExprContext) child);
		}
	}

	@Override public Type visitExpr(@NotNull BasicParser.ExprContext ctx) {

		if(ctx.getChild(0) instanceof BasicParser.Int_literContext){
			return Type.INT;
		}

		if(ctx.getChild(0) instanceof BasicParser.Bool_literContext){
			return Type.BOOL;
		}

		if(ctx.getChild(0) instanceof BasicParser.Char_literContext){
			return Type.CHAR;
		}

		if(ctx.getChild(0) instanceof BasicParser.Str_literContext){
			return Type.STRING;
		}

		if(ctx.getChild(0) instanceof BasicParser.Pair_literContext){
			return Type.PAIR;
		}

		if(ctx.getChild(0) instanceof BasicParser.IdentContext){
			return ((Variable) getIdent(ctx.getText())).getType();
		}

		if (ctx.getChild(0) instanceof BasicParser.Unary_operContext) {			
			String token = token(ctx.getChild(0).getText());
			
			if (token == getToken(BasicLexer.NOT)) {
				if (visitExpr((ExprContext) ctx.getChild(1)) != Type.BOOL) {
					System.err.println("Type mismatch, must be of type bool");
					return null;
				} else {
					return Type.BOOL;
				}
			}
			else if (token == getToken(BasicLexer.MINUS)) {
				if (visitExpr((ExprContext) ctx.getChild(1)) != Type.INT) {
					System.err.println("Type mismatch, must be of type int");
					return null;
				} else {
					return Type.INT;
				}
			}
			else if (token == getToken(BasicLexer.LENGTH)) {
				if (checkArray(ctx.getChild(1).getText())) {
					return Type.INT;
				}
			}
			else if (token == getToken(BasicLexer.ORD)) {
				if (visitExpr((ExprContext) ctx.getChild(1)) != Type.INT) {
					System.err.println("Type mismatch, must be of type int");
					return null;
				} else {
					return Type.CHAR;
				}
			}
			else if (token == getToken(BasicLexer.TO_INT)) {
				if (visitExpr((ExprContext) ctx.getChild(1)) != Type.CHAR) {
					System.err.println("Type mismatch, must be of type char");
					return null;
				} else {
					return Type.INT;
				}
			}
		}
		else if (token(ctx.getChild(0).getText()) == getToken(BasicLexer.OPEN_PARENTHESES)) {
			return visitExpr((ExprContext) ctx.getChild(1));
		}

		if(ctx.getChild(1) instanceof BasicParser.Binary_operContext){

			//Check expr1 type = expr2 type
			Type e1 = visitExpr((ExprContext) ctx.getChild(0));
			Type e2 = visitExpr((ExprContext) ctx.getChild(2));

			if(typeMatch(e1,e2)){
				//Check binary_op type = lhs/rhs types
				Type opType = visitBinary_oper((Binary_operContext) ctx.getChild(1));
				typeMatch(e1,opType);
				//Return binary_op type
				return opType;
			}

		}

		if(token(ctx.getChild(1).getText()) == getToken(BasicLexer.OPEN_BRACKET)){
			//Check Array Pointer is an Integer
			typeMatch(Type.INT,visitExpr((ExprContext) ctx.getChild(2)));
			//Check first Expr, if an ident, is an Array
			if(ctx.getChild(0) instanceof BasicParser.IdentContext){
				checkArray(ctx.getChild(0).getText());
			}
			//Return First Expr Type
			return visitExpr((ExprContext) ctx.getChild(2));
		}

		return null;

	}

		public boolean checkArray(String ident) {
		if (getIdent(ident) instanceof identifier_objects.Array) {
			return true;
		} else {
			System.err.println("Type mismatch, must be an array");
			return false;
		}
	}

	@Override public Type visitBinary_oper(@NotNull BasicParser.Binary_operContext ctx) {

		String token = token(ctx.getText());
		
		if (token == getToken(BasicLexer.PLUS)
				|| token == getToken(BasicLexer.MINUS)
				|| token == getToken(BasicLexer.MULTIPLY)
				|| token == getToken(BasicLexer.DIVIDE)
				|| token == getToken(BasicLexer.MOD)
				|| token == getToken(BasicLexer.GREATER)
				|| token == getToken(BasicLexer.GREATER_EQUAL)
				|| token == getToken(BasicLexer.LESS)
				|| token == getToken(BasicLexer.LESS_EQUAL)){
			return Type.INT;

		}

		if(token == getToken(BasicLexer.EQUAL)
				|| token == getToken(BasicLexer.NOT_EQUAL)){
			return Type.ANY;
		}

		if(token == getToken(BasicLexer.AND)
				|| token == getToken(BasicLexer.OR)){
			return Type.BOOL;
		}

		return null;

	}

}