package agents;

import enums.Action;
import game.Player;

public class LoosePassivePlayer extends Player {

	public LoosePassivePlayer(int startingChips_) {
		super(startingChips_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Action getAction() {
		return Action.CHECK_OR_CALL;
	}

}
