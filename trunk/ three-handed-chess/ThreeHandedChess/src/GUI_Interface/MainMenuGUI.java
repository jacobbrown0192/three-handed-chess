package GUI_Interface;

import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import threePlayerChessa.Game;

public class MainMenuGUI extends JPanel {

	Game theGame;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int buttonPress;
	
	/**
	 * Create the panel.
	 */
	public MainMenuGUI(Game aGame) {
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
	
	public void makeVisable(){
		
	}
	
	
	
	
}





