package game;

import enums.*;

public class Card {
	
	private final Rank _rank;
	private final Suit _suit;
	
	public Card(Rank rank_, Suit suit_)	{
		_rank = rank_;
		_suit = suit_;
	}
	
	public Rank getRank(){
		return _rank;
	}
	
	public Suit getSuit(){
		return _suit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_rank == null) ? 0 : _rank.hashCode());
		result = prime * result + ((_suit == null) ? 0 : _suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (_rank != other._rank)
			return false;
		if (_suit != other._suit)
			return false;
		return true;
	}
	
	
	
}
