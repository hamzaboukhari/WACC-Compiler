package identifier_objects;

public class Array extends Variable {
	
	private Type elements[];
	
	public Array(Type t) {
		super(t);
		elements = new Type[0];
	}

	public Type[] getElems() {
		return elements;
	}
	
	public void addElement(Type t) {
		Type[] tempElements = elements;
		elements = new Type[tempElements.length + 1];
		
		for(int i=0; i<tempElements.length; i++){
			elements[i] = tempElements[i];
		}
		
		elements[tempElements.length] = t;
	}

}
