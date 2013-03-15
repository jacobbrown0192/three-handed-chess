package GUI_Interface;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import threePlayerChessa.Game;

/** Graphics for the control panel above the hexagonal game board.
 * <p>An extension of <code>JPanel</code> containing a label.
 * <p>This panel will be updated to include game timers, and possibly a previous
 * move list.
 */
public class TopBoardGUI extends JPanel 
{
	private static final long serialVersionUID = 1L;
	Game theGame;
	
	
	/**
	 * Create the panel.
	 */
	public TopBoardGUI(Game aGame)
	{
		theGame = aGame;
		
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblGameAndStuff = new JLabel("Game N' Stuff");
		lblGameAndStuff.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblGameAndStuff);
	}
}
