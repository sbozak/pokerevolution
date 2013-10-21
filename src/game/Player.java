package game;

import enums.Action;

public abstract class Player {
	
	private int _chips;
	private boolean _isInHand;
	protected Card[] _holeCards;
	protected TableState _tableState;	
	
	public Player(int startingChips_){
		_chips = startingChips_;
		_holeCards = new Card[2];
	}
		
	public void registerTable(TableState tableState_){
		_tableState = tableState_;
	}
	
	public void leaveTable(){
		_tableState = null;
	}
	
	public void startHand(Card[] holeCards_, int blindOrAnte_){
		_holeCards[0] = holeCards_[0];
		_holeCards[1] = holeCards_[1];
		_chips -= blindOrAnte_;
		_isInHand = true;
	}
	
	public abstract Action getAction();
		
	public Card[] showHand(){
		return _holeCards;
	}
	
	public void insertChipsToPot(int chips_){
		_chips -= chips_;
	}
	
	public boolean isInHand(){
		return _isInHand;
	}
	
	public void endHand(int chips_){
		_chips += chips_;
		_isInHand = false;
		_holeCards[0] = null;
		_holeCards[1] = null;
	}
	
	

}
