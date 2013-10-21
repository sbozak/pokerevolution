package enums;

public enum Suit {
	
	HEARTS(1),
	CLUBS(2),
	DIAMONDS(3),	
	SPADES(4);
	
	Suit(int n) { value = n; }        
	public final int value;

}
