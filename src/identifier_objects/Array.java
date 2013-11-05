package identifier_objects;

public class Array extends Variable {
	
	private Type elements[];
	
	public Array(Type t) {
		super(t);
	}

	public Type[] getElems() {
		return elements;
	}

}
