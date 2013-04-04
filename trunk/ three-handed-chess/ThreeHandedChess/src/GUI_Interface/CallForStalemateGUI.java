package GUI_Interface;

import javax.swing.JPanel;

import threePlayerChessa.Game;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/** Graphics for the control of a request for stalemate.
 * <p>This screen will be brought up for every player if the player whose turn it is
 * requests a stalemate.
 * <p>The screen prompts users, asking if they agree to a stalemate.
 * <p>Responses will notify waiting threads and the game will either continue or 
 * end in a draw.
 */
public class CallForStalemateGUI extends JPanel
{
	private static final long serialVersionUID = 1L;
	private Game theGame;
	
	/**
	 * Create the panel.
	 */
	public CallForStalemateGUI(Game aGame) 
	{
		theGame = aGame;
		setBorder(new EmptyBorder(30, 30, 30, 30));
		
		JButton btnNewButton = new JButton("Yes");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				theGame.getStalemate().yes();
			}
		});
		
		setLayout(new GridLayout(0, 3, 0, 30));
		
		JLabel label = new JLabel("");
		add(label);
		
		JLabel lblNewLabel = new JLabel("Someone has called for a draw");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		add(label_1);
		
		JLabel label_2 = new JLabel("");
		add(label_2);
		
		JLabel lblWouldYouLike = new JLabel("would you like to accept?");
		lblWouldYouLike.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblWouldYouLike);
		
		JLabel label_4 = new JLabel("");
		add(label_4);
		
		JButton btnNewButton_1 = new JButton("No");
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				theGame.getStalemate().no();
			}
		});
		add(btnNewButton_1);
		
		JLabel label_8 = new JLabel("");
		add(label_8);
		add(btnNewButton);
		theGame = aGame;		
	}
}
