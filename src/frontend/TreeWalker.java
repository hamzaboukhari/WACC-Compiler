package frontend;

import identifier_objects.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import antlr.BasicParser;
import antlr.BasicParser.ExprContext;
import antlr.BasicParser.ProgContext;
import antlr.BasicParser.StatContext;
import antlr.BasicParserBaseVisitor;

public class TreeWalker extends BasicParserBaseVisitor<ParseTree>{
	
	private ProgContext tree;
	private SymbolTable st;

	public TreeWalker(ProgContext t){
		tree = t;
		st = new SymbolTable(null); 
	}
	
	public void validateSemantics(){
		visitProg(tree);
	}
	
	@Override public ParseTree visitProgram(@NotNull BasicParser.ProgramContext ctx) {
		st = new SymbolTable(st);
		
		//
		
		st = st.getParent();
		return visitChildren(ctx);
	}
	
	@Override public ParseTree visitFunc(@NotNull BasicParser.FuncContext ctx) {
		
		return visitChildren(ctx);
	}
	
	@Override public ParseTree visitStat(@NotNull BasicParser.StatContext ctx) {
		
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
		} else if (ctx.getChild(2).getText().equals("=")) {
			//found declaration
			String name = ctx.getChild(1).getText();
			Type obj = getType(ctx.getChild(0).getText());
			st.add(name, new Variable(obj));
		} else {
			return null;
		}
		
	}
	
	@Override public ParseTree visitExpr(@NotNull BasicParser.ExprContext ctx) {
		
		return null;
	}
	
	@Override public T visitParam(@NotNull BasicParser.ParamContext ctx) { 
		String name = ctx.getChild(1).getText();
		Type obj = getType(ctx.getChild(0).getText());
		st.add(name, new Variable(obj));	
	}
	

}
