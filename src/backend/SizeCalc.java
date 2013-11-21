package backend;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;

import antlr.BasicParser.FuncContext;
import antlr.BasicParser.StatContext;
import antlr.BasicParser.TypeContext;
import antlr.BasicParserBaseVisitor;
import antlr.BasicParser.ProgContext;

public class SizeCalc extends BasicParserBaseVisitor<Void> {
	
	int totalOffset;
	
	private final int SIZE_INT = 4;
	private final int SIZE_STRING = 4;
	private final int SIZE_BOOL = 1;
	private final int SIZE_CHAR = 1;
	
	public SizeCalc(){
		totalOffset = 0;
	}
	
	public int getSize(ParseTree tree) {
		visitChildren((RuleNode) tree);
		return totalOffset;
	}
	
	@Override
	public Void visitFunc(FuncContext ctx) {
		return null;
	}
	
	@Override
	public Void visitStat(StatContext ctx) {
		
		if(ctx.getChild(0).getText().equals("if")){
			return null;
		} else if(ctx.getChild(0).getText().equals("while")){
			return null;
		}else if(ctx.getChild(0).getText().equals("begin")){
			return null;
		}
		
		return visitChildren(ctx);
		
	}
	
	@Override
	public Void visitType(TypeContext ctx) {
		if (ctx.getText().equals("int")) {
			
			totalOffset += SIZE_INT;
				
		} else if (ctx.getText().equals("bool")) {
			
			totalOffset += SIZE_BOOL;
			
		} else if (ctx.getText().equals("char")) {
			
			totalOffset += SIZE_CHAR;
			
		} else if (ctx.getText().equals("string")) {
			
			totalOffset += SIZE_STRING;
	
		}
		
		return null;
	}

}
