package agents;

import enums.Action;
import game.Player;
import game.TableState;
import genetics.Genome;

public class GeneticPlayer extends Player {
	
	private Genome _genome;
	private TableState _tableState;

	public GeneticPlayer(Genome genome_, int chips_){
		super(chips_);
		_genome = genome_;
	}
	
	@Override
	public Action getAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerTable(TableState tableState_) {
		_tableState = tableState_;
		
	}

}
