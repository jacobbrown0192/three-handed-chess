package GUI_Interface;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import threePlayerChessa.Game;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/** Graphics for the control of the <code>PauseMenu</code>.
 * <p>
 * 
 *
 *
 */
public class PauseMenuGUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Game theGame;
	/**
	 * Create the panel.
	 */
	public PauseMenuGUI( Game aGame) {
		this.theGame = aGame;
		setBorder(new EmptyBorder(30, 50, 30, 50));
		setLayout(new GridLayout(0, 1, 0, 30));
		
		JLabel lblPause = new JLabel("Pause");
		lblPause.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPause);
		
		JButton btnNewButton_3 = new JButton("Resume");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theGame.pauseMenu.resume();
			}
		});
		add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("Call For Stalemate");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theGame.pauseMenu.callForStalemate();
			}
		});
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("End Game");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theGame.pauseMenu.endGame();
			}
		});
		add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theGame.pauseMenu.reset();
			}
		});
		add(btnNewButton);
	}

}
