package game;

import enums.Turn;

public class TableState {
	
	private int _numPlayers;
	private int _dealerOffset;
	private int _potSize;
	private int _betSize;
	private Card[] _flopCards;
	private Card _turnCard;
	private Card _riverCard;
	private Turn _turn;
	
	public int get_numPlayers() {
		return _numPlayers;
	}
	public void set_numPlayers(int numPlayers_) {
		this._numPlayers = numPlayers_;
	}

	public int get_dealerOffset() {
		return _dealerOffset;
	}
	public void set_dealerOffset(int _dealerOffset) {
		this._dealerOffset = _dealerOffset;
	}
	
	public int get_potSize() {
		return _potSize;
	}
	public void set_potSize(int _potSize) {
		this._potSize = _potSize;
	}
	
	public int get_betSize() {
		return _betSize;
	}
	public void set_betSize(int _betSize) {
		this._betSize = _betSize;
	}
	
	public Card[] get_flopCards() {
		return _flopCards;
	}
	public void set_flopCards(Card[] _flopCards) {
		this._flopCards = _flopCards;
	}
	
	public Card get_riverCard() {
		return _riverCard;
	}
	public void set_riverCard(Card _riverCard) {
		this._riverCard = _riverCard;
	}
	
	public Turn get_turn() {
		return _turn;
	}
	public void set_turn(Turn _turn) {
		this._turn = _turn;
	}
	
	public Card get_turnCard() {
		return _turnCard;
	}
	public void set_turnCard(Card _turnCard) {
		this._turnCard = _turnCard;
	}
	
	
}
