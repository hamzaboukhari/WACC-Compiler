package frontend;

import java.util.HashMap;
import java.util.Map;
import identifier_objects.Identifier;

public class Dictionary<T> {
	
	Map<String, T> dictionary;
	
	Dictionary() {
		dictionary = new HashMap<String, T>();
	}
	
	void add(String name, T obj) {
		dictionary.put(name, obj);
	}
	
	public T get(String name) {
		return dictionary.get(name);
	}
	
	public Map<String, T> getAll(){
		return dictionary;
	}
	
}
