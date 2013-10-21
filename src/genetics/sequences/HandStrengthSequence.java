package genetics.sequences;

import enums.Rank;
import enums.Suit;
import game.Card;

public class HandStrengthSequence extends ConditionSequence<Integer> {

	public HandStrengthSequence(int lower_, int upper_) {
		super(lower_, upper_);
		
	}

	@Override
	public String transcribe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer min() {
		return Integer.valueOf(1);
	}

	@Override
	public Integer max() {
		return Integer.valueOf(100);
	}
	
	

}
