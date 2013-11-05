package identifier_objects;

public class Pair extends Variable {
	
	Type fst;
	Type snd;
	
	public Pair(Type fst, Type snd) {
		super(Type.PAIR);
		fst = this.fst;
		snd = this.snd;
	}
}
