package GUI_Interface;

import javax.swing.JPanel;


import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import threePlayerChessa.Game;

/** Graphics for the control of the <code>MainMenu</code> upon startup of the program.
 * <p>Contains buttons for "Start", "Player Configuration", and "Close".
 * <p>Start will begin a game with the settings defined in the player configuration.
 * <p>Player Configuration will bring up the Player Configuration Menu.
 * <p>Close will end the program.
 * <p>The Main Menu is also returned to upon ending a game or exiting the player
 * configuration.
 */
public class MainMenuGUI extends JPanel {

	Game theGame;
	private static final long serialVersionUID = 1L;
	int buttonPress;
	
	/**
	 * Create the panel.
	 */
	public MainMenuGUI(Game aGame)
	{
		theGame = aGame;
		setBorder(new EmptyBorder(30, 50, 30, 50));
		setLayout(new GridLayout(4, 1, 0, 30));
		
		JLabel lblThreehandedChess = new JLabel("Three-Handed Chess");
		lblThreehandedChess.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblThreehandedChess);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					theGame.mainMenu.Start();
			}
		});
		add(btnStart);
		
		JButton btnPlayerConfiguration = new JButton("Player Configuration");
		btnPlayerConfiguration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theGame.mainMenu.playerConfig();
				
			}
		});
		add(btnPlayerConfiguration);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theGame.mainMenu.Close();
			}
		});
		add(btnClose);
	}
	
	public void makeVisable(){}	
}





