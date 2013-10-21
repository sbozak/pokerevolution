package game;

import enums.Rank;
import enums.Suit;

public class Deck {
	
	private static Card[] _standard52Deck;
	
	static {
	    _standard52Deck = new Card[52];
	    int cardCt = 0;
        for(Rank r : Rank.values()){
			for(Suit s : Suit.values()){
				_standard52Deck[cardCt++] = new Card(r, s);
			}
		}
	}
	
    private Card[] _deck;   //An array of Card objects
    private int _cardsUsed;
    
    public Deck() {
    	_deck = new Card[52];
    	for(int i = 0; i<_standard52Deck.length; ++i){
    		_deck[i] = _standard52Deck[i];
    	}
       _cardsUsed = 0;
    }

    public void shuffle() {
          // Put all the used cards back into the deck, and shuffles it
        for ( int i = 51; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = _deck[i];
            _deck[i] = _deck[rand];
            _deck[rand] = temp;
        }
        
        _cardsUsed = 0;
    }

    public int cardsLeft() {
        return 52 - _cardsUsed;
    }

    public Card dealCard() {
        if (_cardsUsed == 52)
           shuffle();
        _cardsUsed++;
        return _deck[_cardsUsed - 1];
    }
    
    public boolean removeCard(Card card_) {
    	for(int i = _cardsUsed; i < 52; ++i){
    		if(_deck[i] == card_){
    			Card temp;
    			temp = _deck[_cardsUsed];
    			_deck[_cardsUsed] = _deck[i];
    			_deck[i] = temp;    
    			++_cardsUsed;
    			return true;	
    		}    		
    	}
    	return false;
        
    }

}

