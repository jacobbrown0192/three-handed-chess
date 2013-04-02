package GUI_Interface;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import threePlayerChessa.Game;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WinGUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Game theGame;
	JLabel lblWin;
	
	/**
	 * Create the panel.
	 */
	public WinGUI(Game aGame) {
		theGame = aGame;
		setBorder(new EmptyBorder(30, 50, 30, 50));
		setLayout(new GridLayout(0, 1, 0, 30));
		
		lblWin = new JLabel("Win");
		lblWin.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblWin);
		
		JButton btnNewButton = new JButton("Finish");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				theGame.gameFrame.getContentPane().removeAll();
			    theGame.gameFrame.getContentPane().repaint();
				theGame.gameFrame.getContentPane().add(theGame.tBoardGUI,BorderLayout.NORTH);
				theGame.gameFrame.getContentPane().add(theGame.boardGUI);
				theGame.gameFrame.getContentPane().add(theGame.bBoardGUI,BorderLayout.SOUTH);
				theGame.gameFrame.setVisible(true);
				theGame.gameController.setInProgress(false);
			}
		});
		add(btnNewButton);

	}

	/**
	 * @return the lblWin
	 */
	public JLabel getLblWin() {
		return lblWin;
	}

	/**
	 * @param lblWin - used to set lblWin
	 */
	public void setLblWin(JLabel lblWin) {
		this.lblWin = lblWin;
	}
}
