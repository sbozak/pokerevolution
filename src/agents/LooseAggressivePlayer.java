package agents;

import enums.Action;
import game.Player;

public class LooseAggressivePlayer extends Player {

	public LooseAggressivePlayer(int startingChips_) {
		super(startingChips_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Action getAction() {
		return Action.BET_OR_RAISE;
	}

}
