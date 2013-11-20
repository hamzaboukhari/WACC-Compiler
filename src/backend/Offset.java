package backend;

public class Offset {
	
	private String key;
	private int val;
	
	public Offset(String key, int val) { 
		this.setKey(key); 
		this.setVal(val);
	}

	public String getKey() { 
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	} 
	
}
