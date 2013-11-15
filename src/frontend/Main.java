package frontend;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import backend.CodeGenerator;

import antlr.BasicLexer;
import antlr.BasicParser;
import antlr.BasicParser.ProgContext;

public class Main {
	
	public static void main(String[] args) throws IOException{
		// Get file name
		//String file = args[0];
		String file = "../wacc_examples/valid/if/ifTrue.wacc";
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
		//System.out.println(tree.toStringTree(parser));
		
		if(parser.getNumberOfSyntaxErrors() == 0){
			//Check Semantics
			TreeWalker walker = new TreeWalker(tree);
			walker.validateSemantics();
			
			CodeGenerator codeGen = new CodeGenerator(tree);
			codeGen.start();
			codeGen.printOutput();
		} else {
			System.out.println("Syntax Errors: " + parser.getNumberOfSyntaxErrors());
		}
	}
	
}