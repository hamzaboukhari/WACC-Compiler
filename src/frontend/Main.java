package frontend;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.BasicLexer;
import antlr.BasicParser;
import antlr.BasicParser.ProgContext;

public class Main {
	
	public static void main(String[] args) throws IOException{
		// Get file name
		//String file = args[0];
		String file = "/homes/hb2212/wacc_examples/valid/expressions/charComparisonExpr.wacc";
		//System.out.println("File: " + file);
		
		// Read in file
		CharStream cs = new ANTLRFileStream(file);
		
		// Create lexer
		BasicLexer lexer = new BasicLexer(cs);
		
		// Generate token stream
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		// Create parser
		BasicParser parser = new BasicParser(tokens);
		
		// Create AST
		ProgContext tree = parser.prog();
		
		// Debug
		System.out.println(tree.toStringTree(parser));
		
		if(parser.getNumberOfSyntaxErrors() == 0){
			//Check Semantics
			TreeWalker walker = new TreeWalker(tree);
			walker.validateSemantics();
		} else {
			System.out.println("Syntax Errors: " + parser.getNumberOfSyntaxErrors());
		}
	}
	
}