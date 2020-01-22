
public class WinResult {
	private boolean isWon;
	private Field_Rectangle field1;
	private Field_Rectangle field2;
	
	public WinResult(boolean isWon, Field_Rectangle field1, Field_Rectangle field2) {
		this.isWon = isWon;
		this.field1 = field1;
		this.field2 = field2;
	}


	public boolean isWon() {
		return isWon;
	}
	
	
	public void setWon(boolean isWon) {
		this.isWon = isWon;
	}
	
	
	public Field_Rectangle getField1() {
		return field1;
	}
	
	
	public void setField1(Field_Rectangle field1) {
		this.field1 = field1;
	}
	
	
	public Field_Rectangle getField2() {
		return field2;
	}
	
	
	public void setField2(Field_Rectangle field2) {
		this.field2 = field2;
	}
}
