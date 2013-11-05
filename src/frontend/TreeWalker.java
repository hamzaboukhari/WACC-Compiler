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
import antlr.BasicParser.ExprContext;
import antlr.BasicParser.Param_listContext;
import antlr.BasicParser.ProgContext;
import antlr.BasicParser.StatContext;
import antlr.BasicParserBaseVisitor;

public class TreeWalker extends BasicParserBaseVisitor<Type>{
	
	private ProgContext tree;
	private SymbolTable st;
	private int errorCount;

	public TreeWalker(ProgContext t){
		tree = t;
		st = new SymbolTable(null); 
	}
	
	public void validateSemantics(){
		visitProg(tree);
	}
	
	private boolean typeMatch(Type t1, Type t2){
		if(t1 != t2){
			//Semantic Error: Types do not match
			System.err.println("Type Error");
			errorCount++;
			return false;
		}
		return true;
	}
	
	private boolean checkDec(String varName){
		if(st.lookUpCurrLevelAndEnclosingLevels(varName) == null){
			//Semantic Error: Variable not declared
			System.err.println("Variable " + varName + " not declared");
			errorCount++;
			return false;
		}
		return true;
	}
	
	private Type getType(String type){
		if(type == getToken(BasicLexer.INT)){
			return Type.INT;
		} if(type == getToken(BasicLexer.BOOL)){
			return Type.BOOL;
		} if(type == getToken(BasicLexer.CHAR)){
			return Type.CHAR;
		} if(type == getToken(BasicLexer.STRING)){
			return Type.STRING;
		} 
		return null;
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
		
		Function func = new Function( getType(ctx.getChild(0).getText()));
		
		st.add(ctx.getChild(1).getText(),func);
		
		st = new SymbolTable(st);
		
		int funcBody = 5;
		
		if(ctx.getChildCount() == 8){
			//Has Parameters
			//TODO: Add param types to function variable Params
			visitParam_list((Param_listContext) ctx.getChild(3));
			funcBody = 6;
		}
		
		visitStat((StatContext) ctx.getChild(funcBody));
		
		func.addST(st);
		st = st.getParent();
		
		return null;
	}
	
@Override public Type visitStat(@NotNull BasicParser.StatContext ctx) {
		
		if (ctx.getChild(0).getText() == "while") {
			st = new SymbolTable(st);
			
			visitExpr((ExprContext) ctx.getChild(1));
			
			visitStat((StatContext) ctx.getChild(3));
			
			st = st.getParent();
		} else if (ctx.getChild(0).getText() == "if") {
			st = new SymbolTable(st);
			
			visitExpr((ExprContext) ctx.getChild(1));
			
			visitStat((StatContext) ctx.getChild(3));
			
			visitStat((StatContext) ctx.getChild(5));
			
			st = st.getParent();
		} else if (ctx.getChild(1).getText().equals("=")) {
			//found assignment
			//First check variable is declared
			String varName = ctx.getChild(0).getText();
			checkDec(varName);
			typeMatch(((Variable) st.lookUpCurrLevelAndEnclosingLevels(varName)).getType(), visitAssign_rhs((Assign_rhsContext) ctx.getChild(3)));
		} else if (ctx.getChild(2).getText().equals("=")) {
			//found declaration
			String name = ctx.getChild(1).getText();
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
			Function f = (Function) st.lookUpCurrLevelAndEnclosingLevels(func);
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
			visitExpr((ExprContext) child);
		}
		return null;
	}
	
	@Override
	public Type visitExpr(@NotNull BasicParser.ExprContext ctx) {
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
			return ((Variable) st.lookUpCurrLevelAndEnclosingLevels(ctx.getText())).getType();
		}
		
		if (ctx.getChild(0) instanceof BasicParser.Unary_operContext) {			
			String token = ctx.getChild(0).getText();
			
			if (token == getToken(BasicLexer.NOT)) {
				if (visitExpr((ExprContext) ctx.getChild(1)) != Type.BOOL) {
					System.err.println("Type mismatch, must be of type bool");
					errorCount++;
					return null;
				} else {
					return Type.BOOL;
				}
			}
			else if (token == getToken(BasicLexer.MINUS)) {
				if (visitExpr((ExprContext) ctx.getChild(1)) != Type.INT) {
					System.err.println("Type mismatch, must be of type int");
					errorCount++;
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
					errorCount++;
					return null;
				} else {
					return Type.CHAR;
				}
			}
			else if (token == getToken(BasicLexer.TO_INT)) {
				if (visitExpr((ExprContext) ctx.getChild(1)) != Type.CHAR) {
					System.err.println("Type mismatch, must be of type char");
					errorCount++;
					return null;
				} else {
					return Type.INT;
				}
			}
		}
		else if (ctx.getChild(0).getText() == getToken(BasicLexer.OPEN_PARENTHESES)) {
			return visitExpr((ExprContext) ctx.getChild(1));
		}
		
		if(ctx.getChild(1) instanceof BasicParser.Binary_operContext){
			//Check expr1 type = expr2 type
			Type e1 = visitExpr((ExprContext) ctx.getChild(0));
			Type e2 = visitExpr((ExprContext) ctx.getChild(2));
			typeMatch(e1,e2);
			//Check binary_op type = lhs/rhs types
			
			//Return binary_op type
			
		}
		
		return null;
	}
	
	public boolean checkArray(String ident) {
		if (st.lookUpCurrLevelAndEnclosingLevels(ident) instanceof identifier_objects.Array) {
			return true;
		} else {
			System.err.println("Type mismatch, must be an array");
			errorCount++;
			return false;
		}
	}
	
	@Override
	public Type visitUnary_oper(BasicParser.Unary_operContext ctx) {
				
		
		return null;
	}
	
	
	@Override
	public Type visitParam(@NotNull BasicParser.ParamContext ctx) { 
		String name = ctx.getChild(1).getText();
		Type type = getType(ctx.getChild(0).getText());
		st.add(name, new Variable(type));
		
		return type;
	}
	

}