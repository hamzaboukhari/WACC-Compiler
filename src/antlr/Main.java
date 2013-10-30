import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
	
	public static void main(String[] args) throws IOException{
		// Get file name
		String file = "/wacc_examples/valid/if/ifBasic.wacc";
		System.out.println("File: " + file);
		
		// Read in file
		CharStream cs = new ANTLRFileStream(file);
		
		// Create lexer
		BasicLexer lexer = new BasicLexer(cs);
		
		// Generate token stream
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		// Create parser
		BasicParser parser = new BasicParser(tokens);
		
		// Create AST
		System.out.println(parser.prog().toStringTree(parser));
		
		// Get syntax errors
		System.out.println("Syntax Errors: " + parser.getNumberOfSyntaxErrors());
	}
}
