import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Field_Rectangle extends Rectangle{
	
	private Field_Value value;
	
	public Field_Rectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
		value = Field_Value.EMPTY;
	}
	
	public void draw(Graphics2D g2d) {
		//Rahmen Zeichnen
		g2d.setColor(Color.BLACK);
		g2d.drawRect(x, y, width, height);
		
		//Symbol
		//Kreis
		if (value == Field_Value.O) {
			g2d.setColor(Color.BLUE);
			g2d.drawOval(x + 5, y + 5, width - 10, height - 10);
		//Kreuz
		} else if (value == Field_Value.X) {
			g2d.setColor(Color.RED);
			g2d.drawLine(x + 5, y + 5, x + width - 5, y + height - 5);
			g2d.drawLine(x + width - 5, y + 5, x + 5, y + height - 5);
		}
	}
	
	
	
	public Field_Value getValue() {
		return value;
	}

	public void setValue(Field_Value value) {
		this.value = value;
	}
	
	
	
}
