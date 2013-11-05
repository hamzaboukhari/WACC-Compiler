package frontend;

import identifier_objects.Identifier;

public class SymbolTable {
	
	private SymbolTable encSymTable;
	private Dictionary dict;
	
	public SymbolTable(SymbolTable st) {
		dict = new Dictionary();
		encSymTable = st;
	}
	
	public void add(String name, Identifier obj) {
		dict.add(name, obj);
	}
	
	public Identifier lookupCurrLevelOnly(String name) {
		return dict.get(name);
	}
	
	public Identifier lookUpCurrLevelAndEnclosingLevels(String name) {
		SymbolTable S = this;
		while (S != null) {
			Identifier obj = S.lookupCurrLevelOnly(name);
			if (obj != null) {
				return obj;
			}
			S = S.encSymTable;
		}
		System.err.println("Variable " + name + " not declared");
		return null;
	}
	
	public SymbolTable getParent(){
		return encSymTable;
	}
	
}
