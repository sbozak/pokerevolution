package genetics.sequences;

public abstract class SequenceBase<T extends Comparable> {
	
	public abstract String transcribe();
	
	public abstract T min();
	public abstract T max();

}
