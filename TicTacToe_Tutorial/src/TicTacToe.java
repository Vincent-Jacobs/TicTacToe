import java.util.ArrayList;

public class TicTacToe {
	
	public Field_Value currentPlayer;
	private ArrayList<Field_Rectangle> fields;
	private int[] winningConstellations = new int[] {
		//Zeilen	
		0, 1, 2,
		3, 4, 5,
		6, 7, 8,
		//Spalten
		0, 3, 6,
		1, 4, 7,
		2, 5, 8,
		//Diagonalen
		0, 4, 8,
		2, 4, 6
	};
		
	
	public Game_window window;
	
	public static TicTacToe instance;
	
	
	
	public static void main(String[] args) {
		instance = new TicTacToe();
	}
	
	
	public TicTacToe() {
		window = new Game_window(580, 460);
		initGame();
	}
	
	
	public void initGame() {
		//Game Objekte
		//Player
		
		currentPlayer = Field_Value.X;
		nextPlayerTurn();
		//Fields
		int fieldsMarginLeft = 15;
		int fieldsMarginTop = 5;
		int fieldWidth = 411/3;
		int fieldHeight = 411/3;
		
		//Spielfeld Raster
		fields = new ArrayList<Field_Rectangle>();
		fields.add(new Field_Rectangle(fieldsMarginLeft + 0, 			  fieldsMarginTop + 0, 				 fieldWidth, fieldHeight));
		fields.add(new Field_Rectangle(fieldsMarginLeft + 1 * fieldWidth, fieldsMarginTop + 0,				 fieldWidth, fieldHeight));
		fields.add(new Field_Rectangle(fieldsMarginLeft + 2 * fieldWidth, fieldsMarginTop + 0, 				 fieldWidth, fieldHeight));
		
		fields.add(new Field_Rectangle(fieldsMarginLeft + 0, 			  fieldsMarginTop + 1 * fieldHeight, fieldWidth, fieldHeight));
		fields.add(new Field_Rectangle(fieldsMarginLeft + 1 * fieldWidth, fieldsMarginTop + 1 * fieldHeight, fieldWidth, fieldHeight));
		fields.add(new Field_Rectangle(fieldsMarginLeft + 2 * fieldWidth, fieldsMarginTop + 1 * fieldHeight, fieldWidth, fieldHeight));
		
		fields.add(new Field_Rectangle(fieldsMarginLeft + 0, 			  fieldsMarginTop + 2 * fieldHeight, fieldWidth, fieldHeight));
		fields.add(new Field_Rectangle(fieldsMarginLeft + 1 * fieldWidth, fieldsMarginTop + 2 * fieldHeight, fieldWidth, fieldHeight));
		fields.add(new Field_Rectangle(fieldsMarginLeft + 2 * fieldWidth, fieldsMarginTop + 2 * fieldHeight, fieldWidth, fieldHeight));
	}
	
	
	public void nextPlayerTurn() {
		window.setCurrentPlayerLabelTect("Aktueller Spieler: " + currentPlayer.name());
		if(currentPlayer == Field_Value.X) {
			currentPlayer = Field_Value.O;
		} else {
			currentPlayer = Field_Value.X;
		}
	}
	
	
	public Field_Value getCurrentPlayer() {
		return currentPlayer;
	}
	
	
	public ArrayList<Field_Rectangle> getFields() {
		return fields;
	}
	
	
	public WinResult getWinResult() {
		//Alle Konstellationen untersuchen
		for (int i = 0; i < winningConstellations.length; i = i+3) {
			
			int a = winningConstellations[i];
			int b = winningConstellations[i+1];
			int c = winningConstellations[i+2];
			
			if (Math.abs(fields.get(a).getValue().getValue() + fields.get(b).getValue().getValue() + fields.get(c).getValue().getValue()) == 3) {
				return new WinResult(true, fields.get(a), fields.get(c));		
			}
		}
		return new WinResult(false, null, null);
	}
	
	
	public boolean isDraw() {
		for (Field_Rectangle field : this.getFields()) {
			if (field.getValue() == Field_Value.EMPTY) {
				return false;
			}
		}
		return !getWinResult().isWon();
	}
}
