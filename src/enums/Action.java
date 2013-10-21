package enums;

public enum Action {
	
	FOLD_OR_CHECK(1),
	CHECK_OR_CALL(2),
	BET_OR_RAISE(3);
	
	Action(int n) { value = n; }        
	public final int value;

}
