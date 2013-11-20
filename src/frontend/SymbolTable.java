package frontend;

public class SymbolTable<T> {
	
	private SymbolTable<T> encSymTable;
	private Dictionary<T> dict;
	
	public SymbolTable(SymbolTable<T> st) {
		dict = new Dictionary<T>();
		encSymTable = st;
	}
	
	public void add(String name, T obj) {
		dict.add(name, obj);
	}
	
	public T lookupCurrLevelOnly(String name) {
		return dict.get(name);
	}
	
	public T lookUpCurrLevelAndEnclosingLevels(String name) {
		SymbolTable<T> S = this;
		while (S != null) {
			T obj = S.lookupCurrLevelOnly(name);
			if (obj != null) {
				return obj;
			}
			S = S.encSymTable;
		}
		return null;
	}
	
	public SymbolTable<T> getParent(){
		return encSymTable;
	}
	
}
