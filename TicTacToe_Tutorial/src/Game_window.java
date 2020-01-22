import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class Game_window extends JFrame{
	
	private JLabel currentPlayerLabel;
	private JLabel scoreLabel;

	//Constructor (Das "main Fenster" wird erstellt)
	public Game_window(int widht, int height) {
		setTitle("TicTacToe");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0, 0, widht, height);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());
		
		//Bindet Das "GamePanel (wo man alles drauf zeichnet)" in sich ein GamePanel ist eine weitere Class
		GamePanel gamePanel = new GamePanel();
		getContentPane().add(gamePanel, BorderLayout.CENTER);
		
		
		currentPlayerLabel = new JLabel("Laden");
		currentPlayerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(currentPlayerLabel, BorderLayout.EAST);
		/*currentPlayerLabel.setVerticalTextPosition(JLabel.TOP);
		currentPlayerLabel.setHorizontalTextPosition(JLabel.CENTER);*/
		currentPlayerLabel.setBounds(430, 210, 140, 100);
		
		scoreLabel = new JLabel("Punkte X: 0 Punkte O: 0" );
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(scoreLabel, BorderLayout.EAST);
		scoreLabel.setBounds(435, 200, 135, 100);
		
		setVisible(true);
	}
	
	
	public void setCurrentPlayerLabelTect(String s) {
		currentPlayerLabel.setText(s);
	}
	
	
	public void setScoreLabel(String s) {
		scoreLabel.setText(s);
	}
}



