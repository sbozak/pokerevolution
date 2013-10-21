package agents;

import enums.Action;
import game.Player;
import java.util.Random;

public class RandomPlayer extends Player {

	public RandomPlayer(int startingChips_) {
		super(startingChips_);
		// TODO Auto-generated constructor stub
	}

	Random r = new Random();
	
	@Override
	public Action getAction() {
		return Action.values()[r.nextInt(Action.values().length-1)];
	}

	

}
