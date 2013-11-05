package identifier_objects;

import frontend.SymbolTable;

public class Function extends Identifier {
	
	SymbolTable symtab;
	Type returnType;
	Type[] params;
	
	public Function(Type rType){
		returnType = rType;
		params = new Type[0];
	}
	
	public void addST(SymbolTable st){
		symtab = st;
	}
	
	public void addParam(Type t) {
		Type[] tempParams = params;
		params = new Type[tempParams.length + 1];
		
		for(int i=0; i<tempParams.length; i++){
			params[i] = tempParams[i];
		}
		
		params[tempParams.length] = t;
	}
	
	public Type[] getParams() {
		return params;
	}
	
	public Type getReturnType() {
		return returnType;
	}

}
