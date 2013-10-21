package genetics.sequences;

public abstract class ConditionSequence<T extends Comparable> extends SequenceBase<T> {
	
	protected final T _lower;
	protected final T _upper;
	
	public ConditionSequence(T lower_, T upper_)	{
		_lower = lower_;
		_upper = upper_;
	}
		
	
	public boolean matches(T t_)
	{				
		return t_.compareTo(_lower) >= 0 && t_.compareTo(_upper) <= 0;
	}
	
		
	

}
