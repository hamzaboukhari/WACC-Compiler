package backend;

import frontend.SymbolTable;
import identifier_objects.Type;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.BasicParser.Bool_literContext;
import antlr.BasicParser.Char_literContext;
import antlr.BasicParser.ExprContext;
import antlr.BasicParser.IdentContext;
import antlr.BasicParser.Int_literContext;
import antlr.BasicParser.Pair_literContext;
import antlr.BasicParser.Str_literContext;
import antlr.BasicLexer;
import antlr.BasicParser;
import antlr.BasicParser.Unary_operContext;
import antlr.BasicParserBaseVisitor;

public class GetType extends BasicParserBaseVisitor<Type> {
	
	private SymbolTable<backend.Variable> st;
	
	public GetType(SymbolTable<backend.Variable> symtab) {
		
		st = symtab;
		
	} 
	
	public Type getType(ParseTree tree) {
		return visit(tree);
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
	
	public String getIdentType(String var) {
		return getVariable(var).getType();
	}
	
	private backend.Variable getVariable(String varName){
		return st.lookUpCurrLevelAndEnclosingLevels(varName);
	}
	
	@Override
	public Type visitIdent(IdentContext ctx) {
		
		return getType(getIdentType(ctx.getText()));
		
	}	
	
	@Override
	public Type visitPair_liter(Pair_literContext ctx) {
		return Type.PAIR;
	}

	@Override
	public Type visitUnary_oper(Unary_operContext ctx) {
		String token = token(ctx.getChild(0).getText());
		
		if (token.equals(getToken(BasicLexer.NOT))) {
			if (visitExpr((ExprContext) ctx.getChild(1)) != Type.BOOL) {
				System.err.println("Type mismatch, must be of type bool");
				return null;
			} else {
				return Type.BOOL;
			}
		}
		else if (token.equals(getToken(BasicLexer.MINUS))) {
			if (visitExpr((ExprContext) ctx.getChild(1)) != Type.INT) {
				System.err.println("Type mismatch, must be of type int");
				return null;
			} else {
				return Type.INT;
			}
		}
		else if (token.equals(getToken(BasicLexer.LENGTH))) {
				return Type.INT;
		}
		else if (token.equals(getToken(BasicLexer.ORD))) {
			if (visitExpr((ExprContext) ctx.getChild(1)) != Type.INT) {
				System.err.println("Type mismatch, must be of type int");
				return null;
			} else {
				return Type.CHAR;
			}
		}
		else if (token.equals(getToken(BasicLexer.TO_INT))) {
			if (visitExpr((ExprContext) ctx.getChild(1)) != Type.CHAR) {
				System.err.println("Type mismatch, must be of type char");
				return null;
			} else {
				return Type.INT;
			}
		}
		
		return null;
	}

	@Override
	public Type visitStr_liter(Str_literContext ctx) {
		return Type.STRING;
	}

	@Override
	public Type visitBool_liter(Bool_literContext ctx) {
		return Type.BOOL;
	}

	@Override
	public Type visitChar_liter(Char_literContext ctx) {
		return Type.CHAR;
	}

	@Override
	public Type visitInt_liter(Int_literContext ctx) {
		return Type.INT;
	}
	
	@Override public Type visitBinary_oper(@NotNull BasicParser.Binary_operContext ctx) {

		String token = token(ctx.getText());
		
		if (token.equals(getToken(BasicLexer.PLUS))
				|| token.equals(getToken(BasicLexer.MINUS))
				|| token.equals(getToken(BasicLexer.MULTIPLY))
				|| token.equals(getToken(BasicLexer.DIVIDE))
				|| token.equals(getToken(BasicLexer.MOD))){
			return Type.INT;
		}
		
		if (token.equals(getToken(BasicLexer.GREATER))
				|| token.equals(getToken(BasicLexer.GREATER_EQUAL))
				|| token.equals(getToken(BasicLexer.LESS))
				|| token.equals(getToken(BasicLexer.LESS_EQUAL))
				|| token.equals(getToken(BasicLexer.EQUAL))
				|| token.equals(getToken(BasicLexer.NOT_EQUAL))
			    || token.equals(getToken(BasicLexer.AND))
				|| token.equals(getToken(BasicLexer.OR))){
			return Type.BOOL;
		}

		return null;

	}
	
}
