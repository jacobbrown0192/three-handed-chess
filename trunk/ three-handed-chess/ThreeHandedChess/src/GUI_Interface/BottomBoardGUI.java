package GUI_Interface;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import threePlayerChessa.Game;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/** Graphics for the control panel underneath the hexagonal game board.
 * <p>An extension of <code>JPanel</code> containing a pause button.
 * <p>This panel may be updated to include a chat window.
 */
public class BottomBoardGUI extends JPanel
{
	private static final long serialVersionUID = 1L;
	Game theGame;
	
	/**
	 * Create the panel.
	 */
	public BottomBoardGUI(Game aGame)
	{
		theGame = aGame;
		
		setBorder(new EmptyBorder(30, 30, 30, 30));
		setLayout(new GridLayout(1, 0, 30, 30));
		
		JButton btnNewButton = new JButton("Pause");
		
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				theGame.getGameFrame().getContentPane().removeAll();
			    theGame.getGameFrame().getContentPane().repaint();
				theGame.getGameFrame().getContentPane().add(theGame.getPauseMenuGUI());
				theGame.getGameFrame().setVisible(true);
			}
		});
		
		add(btnNewButton);
		
		JLabel label = new JLabel("");
		add(label);
		
		JLabel label_1 = new JLabel("");
		add(label_1);
	}
}
