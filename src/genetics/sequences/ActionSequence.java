package genetics.sequences;

import enums.Action;

public class ActionSequence extends SequenceBase<Action> {

	private final Action _action;
	
	public ActionSequence(Action a_){
		 _action = a_;
	}
	
	public Action getAction(){
		return _action;
	}
	
	@Override
	public String transcribe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Action min() {
		return Action.FOLD_OR_CHECK;
	}

	@Override
	public Action max() {
		return Action.BET_OR_RAISE;
	}

}
