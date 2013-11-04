package frontend;

import java.util.HashMap;
import java.util.Map;
import identifier_objects.Identifier;

public class Dictionary {
	
	Map<String, Identifier> dictionary;
	
	Dictionary() {
		dictionary = new HashMap<String, Identifier>();
	}
	
	void add(String name, Identifier obj) {
		dictionary.put(name, obj);
	}
	
	Identifier get(String name) {
		return dictionary.get(name);
	}
	
}
