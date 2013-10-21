package genetics;

import enums.Action;
import game.Card;
import genetics.sequences.*;

public class Gene {
	
	private ActionSequence _actionSequence;	
	private HandStrengthSequence _handStrength;	
	private TurnSequence _turnSequence;
	private TablePositionSequence _tablePositionSequence;
	private PotRatioSequence _potRatioSequence;
	
	
	public Gene(ActionSequence actionSequence_){
		_actionSequence = actionSequence_;
	}
	
	public Action getAction(){
		return _actionSequence.getAction();
	}
	
	
	

}
