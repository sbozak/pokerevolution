package enums;

public enum Turn {

	PREFLOP(1),
	FLOP(2),
	TURN(3),
	RIVER(4);
	
	Turn(int n) { value = n; }        
	public final int value;
	
}
