package game;

import java.util.ArrayList;

import enums.Action;
import enums.Rank;
import enums.Suit;

public class Table {
	private ArrayList<Player> _players;
	private Deck _deck;
	private TableState _tableState;
	private int _smallBlindSize;	
	
	public Table(int smallBlindSize_){
		_players = new ArrayList<Player>();
		_deck = new Deck();
		_tableState = new TableState();
		_smallBlindSize = smallBlindSize_;
	}
	
	
	public void AddPlayer(Player player_){
		_players.add(player_);
		player_.registerTable(_tableState);

	}
	
	private Player nextPlayer(Player player_, boolean onlyPlayersInHand_){
		int index = _players.indexOf(player_);
		
		Player p;
		
		do{
			if(++index == _players.size()) {
				index = 0;
			}
			p = _players.get(index);
			
		} while(!onlyPlayersInHand_ || p.isInHand());
		
		return p;
		
	}
	
	private void processPlayerAction(Player player_, Action action_){
		if(action_ == action_.FOLD_OR_CHECK){
			if(_tableState.get_betSize() == 0){
				//check
			}
			else{
				player_.endHand(0);
			}
			
		}
		else if(action_ == action_.CHECK_OR_CALL){
			if(_tableState.get_betSize() == 0){
				//check
			}
			else{
				player_.insertChipsToPot(_smallBlindSize * 2);
			}
		}
		else if(action_ == action_.BET_OR_RAISE){
			if(_tableState.get_betSize() == 0){
				//bet
				player_.insertChipsToPot(_smallBlindSize * 2);
			}
			else{
				player_.insertChipsToPot(_smallBlindSize * 2);
			}
		}
	}
	
	private void dealCards(){
		_deck.shuffle();
		_deck.shuffle();
		_deck.shuffle();
		
		Player currentPlayer = _players.get(_tableState.get_dealerOffset());					
		
		for(int i = 0; i < _tableState.get_numPlayers(); i++){			
			int bet;
			switch(i){
			    case 0:
				  bet = _smallBlindSize;
				  break;
			    case 1:
				  bet = _smallBlindSize * 2;
				  break;
				default:
				  bet = 0;					
			}
						
			currentPlayer = nextPlayer(currentPlayer, false);	
			
			currentPlayer.startHand(new Card[]{_deck.dealCard(), _deck.dealCard()}, bet);
		}
		
	}
	
	private void runTurn() {
		
	}
	
	
	

}
