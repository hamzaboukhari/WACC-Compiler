package backend;

public class Message {
	private String key;
	private String val;
	
	public Message(String key, String val) {
		this.setKey(key);
		this.setVal(val);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
	
	public void addLabel(int n) {
		val += "msg_" + n + ":\n";
	}
	
	public void addLine(String s) {
		val += "\t" + s + "\n";
	}
}
