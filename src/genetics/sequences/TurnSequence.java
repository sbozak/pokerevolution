package genetics.sequences;

import enums.Turn;

public class TurnSequence extends ConditionSequence<Turn>{

	public TurnSequence(Turn lower_, Turn upper_) {
		super(lower_, upper_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String transcribe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Turn min() {
		return Turn.PREFLOP;
	}

	@Override
	public Turn max() {
		return Turn.RIVER;
	}


	
	
	

}
