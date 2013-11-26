package frontend;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import backend.CodeGenerator;

import antlr.BasicLexer;
import antlr.BasicParser;
import antlr.BasicParser.ProgContext;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		// Get file name
		String file = args[0];
		
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
		
		//Check Syntax
		if(parser.getNumberOfSyntaxErrors() == 0){
			//Check Semantics
			TreeWalker semanticCheck = new TreeWalker(tree);
			semanticCheck.validateSemantics();
			
			if(!semanticCheck.semanticError()){
				//Generate ARM Code
				CodeGenerator codeGen = new CodeGenerator(tree);
				codeGen.start();
				codeGen.printOutput();
				errorStatus(0);
			} else {
				errorStatus(100);
			}
		} else {
			System.out.println("Syntax Errors: " + parser.getNumberOfSyntaxErrors());
			errorStatus(200);
		}
	}
	
	private static void errorStatus(int x){
		System.out.println("\n\n________________________\n");
		System.out.println("ERROR STATUS "+x);
	}
	
}