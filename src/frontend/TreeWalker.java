package frontend;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import antlr.BasicParser;
import antlr.BasicParser.ProgContext;
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
		return visitChildren(ctx);
	}
	
	@Override public ParseTree visitExpr(@NotNull BasicParser.ExprContext ctx) {
		
		return visitChildren(ctx);
	}
	
	

}
