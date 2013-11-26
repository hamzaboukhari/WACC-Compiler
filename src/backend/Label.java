package backend;

public class Label {
	
	private Label nextLabel;
	private String name;
	
	public Label(String n){
		name = n;
	}
	
	public Label getNext(){
		return nextLabel;
	}
	
	public String getName(){
		return name;
	}
	
	public void setNext(Label l){
		nextLabel = l;
	}
	
}
