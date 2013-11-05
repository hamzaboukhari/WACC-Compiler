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
	
	private void typeMatch(Type t1, Type t2){
		if(t1 != t2){
			//Semantic Error: Types do not match
			System.err.println("Type Error");
			errorCount++;
		}
	}
	
	private void checkDec(String varName){
		if(st.lookUpCurrLevelAndEnclosingLevels(varName) == null){
			//Semantic Error: Variable not declared
			System.err.println("Variable " + varName + " not declared");
			errorCount++;
		}
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
			typeMatch(((Variable) st.lookUpCurrLevelAndEnclosingLevels(varName)).getType(),visitAssign_rhs((Assign_rhsContext) ctx.getChild(3)));
		} else if (ctx.getChild(2).getText().equals("=")) {
			//found declaration
			String name = ctx.getChild(1).getText();
			Type type = getType(ctx.getChild(0).getText());
			st.add(name, new Variable(type));
			typeMatch(type,visitAssign_rhs((Assign_rhsContext) ctx.getChild(3)));
		}
		
		return null;
		
	}
	
	@Override public Type visitAssign_rhs(@NotNull BasicParser.Assign_rhsContext ctx) {
		System.out.println("ARHS"+ctx.getChild(0));
		return null;
	}
	
	@Override public Type visitExpr(@NotNull BasicParser.ExprContext ctx) {
		//System.out.println(ctx.getText());
		return null;
	}
	
	@Override public Type visitParam(@NotNull BasicParser.ParamContext ctx) { 
		String name = ctx.getChild(1).getText();
		Type type = getType(ctx.getChild(0).getText());
		st.add(name, new Variable(type));
		
		return type;
	}
	

}