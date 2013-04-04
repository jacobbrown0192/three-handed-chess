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
 * <p>Contains buttons for "Resume", "Call for Stalemate", "End Game", and "Reset".
 * <p>Resume will return the flow to the game currently in progress
 * <p>Call for Stalemate will issue a query to all players asking if they agree to
 * a stalemate, which they will reply to in the CallForStalemateGUI page.
 * <p>End Game will terminate the current game and bring the user to the MainMenuGUI.
 * <p>Reset will start a new game with the current player configuration.
 */
public class PauseMenuGUI extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private Game theGame;
	
	/**
	 * Create the panel.
	 */
	public PauseMenuGUI( Game aGame)
	{
		this.theGame = aGame;
		setBorder(new EmptyBorder(30, 50, 30, 50));
		setLayout(new GridLayout(0, 1, 0, 30));
		
		JLabel lblPause = new JLabel("Pause");
		lblPause.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPause);
		
		JButton btnNewButton_3 = new JButton("Resume");
		btnNewButton_3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				theGame.getPauseMenu().resume();
			}
		});
		add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("Call For Stalemate");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				theGame.getPauseMenu().callForStalemate();
			}
		});
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("End Game");
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				theGame.getPauseMenu().endGame();
			}
		});
		add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				theGame.getPauseMenu().reset();
			}
		});
		add(btnNewButton);
	}

}
