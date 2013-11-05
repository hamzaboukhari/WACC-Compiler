package identifier_objects;

public class Variable extends Identifier {
	
	private Type type;
	
	public Variable (Type t) {
		type = t;
	}
	
	public Type getType(){
		return type;
	}

}
