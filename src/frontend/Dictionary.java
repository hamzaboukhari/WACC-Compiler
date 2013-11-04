package frontend;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
	
	Map<String, Object> dictionary;
	
	Dictionary() {
		dictionary = new HashMap<String, Object>();
	}
	
	void add(String name, Object obj) {
		dictionary.put(name, obj);
	}
	
	Object get(String name) {
		return dictionary.get(name);
	}
	
}
