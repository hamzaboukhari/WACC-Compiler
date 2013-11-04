package frontend;

public class SymbolTable {
	
	SymbolTable encSymTable;
	Dictionary dict;
	
	SymbolTable(SymbolTable st) {
		dict = new Dictionary();
		encSymTable = st;
	}
	
	void add(String name, Object obj) {
		dict.add(name, obj);
	}
	
	Object lookupCurrLevelOnly(String name) {
		return dict.get(name);
	}
	
	Object lookUpCurrLevelAndEnclosingLevels(String name) {
		SymbolTable S = this;
		while (S != null) {
			Object obj = S.lookupCurrLevelOnly(name);
			if (obj != null) {
				return obj;
			}
			S = S.encSymTable;
		}
		return null;
	}
}
