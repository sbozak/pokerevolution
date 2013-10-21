package test;

import enums.Rank;
import enums.Suit;
import game.Card;
import helpers.MonteCarloSimulator;

public class MonteCarloTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Card[] akHand = new Card[]{ new Card(Rank.ACE, Suit.CLUBS), new Card(Rank.TEN, Suit.SPADES) };
		
		Card[] flop = new Card[]{ new Card(Rank.NINE, Suit.SPADES), new Card(Rank.QUEEN, Suit.SPADES), new Card(Rank.THREE, Suit.HEARTS) };
		
		int n = 100;
		for(int i = 0; i < 20; ++i){
			long time = System.currentTimeMillis();
			System.out.println("n = " + n + " AK suited str: " + MonteCarloSimulator.getHandStrength(akHand, flop, n) + " took: "+ (System.currentTimeMillis()-time));
		}
		n = 500;
		for(int i = 0; i < 20; ++i){
			long time = System.currentTimeMillis();
			System.out.println("n = " + n + " AK suited str: " + MonteCarloSimulator.getHandStrength(akHand, flop, n) + " took: "+ (System.currentTimeMillis()-time));
		}
		n = 1000;
		for(int i = 0; i < 20; ++i){
			long time = System.currentTimeMillis();
			System.out.println("n = " + n + " AK suited str: " + MonteCarloSimulator.getHandStrength(akHand, flop, n) + " took: "+ (System.currentTimeMillis()-time));
		}
		
		n = 50000;
		long time = System.currentTimeMillis();
		System.out.println("n = " + n + " AK suited str: " + MonteCarloSimulator.getHandStrength(akHand, flop, n) + " took: "+ (System.currentTimeMillis()-time));

	}

}
