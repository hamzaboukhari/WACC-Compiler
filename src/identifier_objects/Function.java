package identifier_objects;

import frontend.SymbolTable;

public class Function extends Identifier {
	
	SymbolTable symtab;
	Type returnType;
	Variable params[];
	
	public Function(Type rType){
		returnType = rType;
	}
	
	public void addST(SymbolTable st){
		symtab = st;
	}

}
