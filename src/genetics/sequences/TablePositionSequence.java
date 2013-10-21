package genetics.sequences;

public class TablePositionSequence extends ConditionSequence<Integer> {

	public TablePositionSequence(Integer lower_, Integer upper_) {
		super(lower_, upper_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String transcribe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer min() {
		return Integer.valueOf(0);
	}

	@Override
	public Integer max() {
		return Integer.valueOf(9);
	}

}
