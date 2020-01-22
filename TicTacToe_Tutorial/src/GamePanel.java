import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements MouseListener{
	
	private WinResult winResult = null;
	public int points_X = 0;
	public int points_O = 0;
	public GamePanel() {
		setBackground(Color.GREEN);
		requestFocus();
		addMouseListener(this);
		
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Eigene Zeichnugen
		
		//Felder Zeichenen 
		Graphics2D g2d = (Graphics2D) g;
		for (Field_Rectangle field : TicTacToe.instance.getFields()) {
			field.draw(g2d);
		}
		//ggf. Gewinnlinie
		if(winResult!= null) {
		g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(10));
		g2d.drawLine((int) (winResult.getField1().getX() + winResult.getField1().getWidth()/2), 
					 (int) (winResult.getField1().getY() + winResult.getField1().getWidth()/2),
					 (int) (winResult.getField2().getX() + winResult.getField2().getWidth()/2),
					 (int) (winResult.getField2().getY() + winResult.getField2().getWidth()/2));
		winResult = null;
		}
	}

	
	private void checkField(int x, int y) {
		Rectangle cursorHitbox = new Rectangle(x, y, 1, 1);            
		for (Field_Rectangle field : TicTacToe.instance.getFields()) {
			if (cursorHitbox.intersects(field)) {                             //Schaut ob die Maus irgendwo gedrückt hat
				if (field.getValue() == Field_Value.EMPTY) {
					TicTacToe.instance.nextPlayerTurn();					
					field.setValue(TicTacToe.instance.getCurrentPlayer());
					repaint();
				}
				break;
			}
		}
	}
	
	
	public void checkWin() {
		WinResult tempResult = TicTacToe.instance.getWinResult();
		
		if (tempResult.isWon()) {
			winResult = tempResult;
			repaint();
			JOptionPane.showMessageDialog(this, "Spieler " + TicTacToe.instance.getCurrentPlayer().name() + " hat gewonnen!", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
			
			if(TicTacToe.instance.currentPlayer == Field_Value.X) {
				points_X++;
			} else if(TicTacToe.instance.currentPlayer == Field_Value.O){
				points_O++;
			}
			TicTacToe.instance.window.setScoreLabel("Punkte X: " + points_X + " Punkte O: " + points_O);
			
			TicTacToe.instance.initGame();
			repaint();
		} else if (TicTacToe.instance.isDraw()) {
			JOptionPane.showMessageDialog(this, "Unendschieden!", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
			TicTacToe.instance.initGame();
			repaint();
		}
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		checkField(e.getX(), e.getY());
		checkWin();
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}
