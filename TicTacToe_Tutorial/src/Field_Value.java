
public enum Field_Value {
	
	X(1), O(-1), EMPTY(0);
	
	int value;
	
	private Field_Value(int val) {
		value = val;
	}
	
	
	int getValue() {
		return value;
	}
}
