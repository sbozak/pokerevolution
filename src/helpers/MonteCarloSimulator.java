package helpers;

import game.Card;
import game.Hand;
import game.Deck;

public class MonteCarloSimulator {
	
	//returns a value from 0 to 1 representing hand strength
	public static double getHandStrength(Card[] holeCards, Card[] tableCards, int simulations){
		if(holeCards.length < 2 || tableCards.length < 3)
		{
			return -1; //not supported for preflop
		}
		double winsOrTies = 0;
		for(int i = 0; i < simulations; ++i){
			Simulation s = new Simulation(holeCards, tableCards);
			int result = s.run(1);
			if(result == 0 || result == 1){
				++winsOrTies;
			}									
		}

		return winsOrTies / simulations;
	}
	
	static class Simulation{
		
		Deck d;
		Card[] _holeCards;
		Card[] _tableCards;
		
		Simulation(Card[] holeCards_, Card[] tableCards_){
			d = new Deck();
			d.shuffle();
			_holeCards = holeCards_;
			_tableCards = new Card[5];
			
			for(Card c : holeCards_){
				d.removeCard(c);
			}
			for(int i = 0; i < tableCards_.length; ++i){
				d.removeCard(tableCards_[i]);
				_tableCards[i] = tableCards_[i];
			}

			
		}
		int run(int numOpponents){
			
			for(int i = 0; i < 5; ++i){
				if(_tableCards[i] == null){
					_tableCards[i] = d.dealCard();
				}
			}
			
			Hand myHand = Hand.getBest7Hand(new Card[]{ 
					_holeCards[0], 
					_holeCards[1], 
					_tableCards[0],
					_tableCards[1],
					_tableCards[2],
					_tableCards[3],
					_tableCards[4]
				});
			
			
			Hand[] opponentHands = new Hand[numOpponents+1];
			Hand bestOpponentHand = null;
			for(Hand h : opponentHands){
				h = Hand.getBest7Hand(new Card[]{ 
													d.dealCard(), 
													d.dealCard(), 
													_tableCards[0],
													_tableCards[1],
													_tableCards[2],
													_tableCards[3],
													_tableCards[4]
												});
				if(bestOpponentHand == null || h.compareTo(bestOpponentHand) == 1){
					bestOpponentHand = h;
				}
			}
			
			
			
			
			int winner = myHand.compareTo(bestOpponentHand);

			return winner;
		}
		
		
		
	}
	

}
