import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;


public class Main {
	
	public static void main(String[] args) throws IOException{
		
		String file = args[0];
		System.out.println("File: "+file);
		CharStream cs = new ANTLRFileStream(file);
		//CharStream cs = new ANTLRInputStream(System.in);
		
		BasicLexer lexer = new BasicLexer(cs);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		BasicParser parser = new BasicParser(tokens);
		
		System.out.println(parser.prog().toStringTree(parser));
		//System.out.println(parser.character().toStringTree(parser));
		
		System.out.println("Syntax Errors: "+parser.getNumberOfSyntaxErrors());
		
		
	}

}
