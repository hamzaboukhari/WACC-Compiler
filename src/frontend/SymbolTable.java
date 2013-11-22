package frontend;

import java.util.ArrayList;
import java.util.List;

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
	
	public void update(String name, T obj) {
		SymbolTable<T> S = this;
		while (S != null) {
			if (S.lookupCurrLevelOnly(name) != null) {
				S.add(name, obj);
			}
			S = S.encSymTable;
		}
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
	
	public List<String> getAllSymbols(){
		List<String> symbols = new ArrayList<String>();
		SymbolTable<T> S = this;
		while (S != null) {
			symbols.addAll(S.getDict().getAll().keySet());
			S = S.encSymTable;
		}
		return symbols;
	}
	
	private Dictionary<T> getDict(){
		return dict;
	}
	
	public SymbolTable<T> getParent(){
		return encSymTable;
	}
	
}
