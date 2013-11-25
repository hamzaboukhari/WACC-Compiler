package backend;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;

import antlr.BasicParser.Array_literContext;
import antlr.BasicParser.Bool_literContext;
import antlr.BasicParser.Char_literContext;
import antlr.BasicParser.FuncContext;
import antlr.BasicParser.Int_literContext;
import antlr.BasicParser.ParamContext;
import antlr.BasicParser.StatContext;
import antlr.BasicParser.Str_literContext;
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
	public Void visitParam(ParamContext ctx) {
		
		String type = ctx.getChild(0).getText();
		
		if (type.equals("int")) {
			
			totalOffset += SIZE_INT;
				
		} else if (type.equals("bool")) {
			
			totalOffset += SIZE_BOOL;
			
		} else if (type.equals("char")) {
			
			totalOffset += SIZE_CHAR;
			
		} else if (type.equals("string")) {
			
			totalOffset += SIZE_STRING;
	
		}
		
		return null;
	}
	
	@Override
	public Void visitFunc(FuncContext ctx) {
		// Prevents iteration through child scopes
		return null;
	}
	
	@Override
	public Void visitStat(StatContext ctx) {
		// Prevents iteration through child scopes
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
	
	@Override
	public Void visitArray_liter(Array_literContext ctx) {

		if (ctx.getChildCount() > 2) {
		
			for (int i = 1 ; i < ctx.getChildCount() - 1 ; i += 2) {

				if (ctx.getChild(i).getChild(0) instanceof Int_literContext) {
	
					totalOffset += SIZE_INT;
					
				} else if (ctx.getChild(i).getChild(0) instanceof Bool_literContext) {
					
					totalOffset += SIZE_BOOL;
					
				} else if (ctx.getChild(i).getChild(0) instanceof Char_literContext) {
					
					totalOffset += SIZE_CHAR;
					
				} else if (ctx.getChild(i).getChild(0) instanceof Str_literContext) {
					
					totalOffset += SIZE_STRING;
				
				}
			
			}
			
			
			// Length
			
			totalOffset += 2 * SIZE_INT;
	
		}
		
		if (ctx.getParent().getParent().getChildCount() == 3) {
			
			// Assignment
			
			totalOffset -= SIZE_INT;
		
		}
	
		return null;
	
	}

}
