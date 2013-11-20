package backend;

public class Variable {
	 
	private int offset;
	private String type;
	
	public Variable(String type, int offset) {
		this.type = type;
		this.offset = offset;
	}
	
	public int getOffset() {
		return offset;
	}

	public String getType() {
		return type;
	}
	
}
