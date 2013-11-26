package identifier_objects;

public class Pair extends Variable {
	
	Type fst;
	Type snd;
	
	public Pair(Type f, Type s) {
		super(Type.PAIR);
		fst = f;
		snd = s;
	}
	
	public Type getF(){
		return fst;
	}
	
	public Type getS(){
		return snd;
	}
}
