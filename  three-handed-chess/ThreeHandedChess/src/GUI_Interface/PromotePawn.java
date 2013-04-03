package GUI_Interface;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import threePlayerChessa.Pawn;
import threePlayerChessa.Turn;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/** Graphics for the control of the promote pawn clause of a pawn's operation.
 * <p>If a pawn reaches the last row of an opposing team's side of the board
 * it can promote either to a Queen, Rook, Bishop or Knight.
 * <p>This screen will prompt the player to decide which piece they would like
 * to promote their pawn to with four buttons: Queen, Rook, Bishop, Knight.
 */
public class PromotePawn extends JPanel
{
	private static final long serialVersionUID = 1L;
	Pawn thePawn;
	Turn thePlayer;
	
	/**
	 * Create the panel.
	 */
	public PromotePawn(Pawn aPawn, Turn player)
	{
		thePawn = aPawn;
		thePlayer = player;
		setBorder(new EmptyBorder(0, 50, 30, 50));
		setLayout(new GridLayout(0, 1, 0, 30));
		
		JLabel lblNewLabel = new JLabel("Select a Piece ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		JButton QueenButton = new JButton("Queen");
		QueenButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				thePawn.selectQueen(thePawn.getCurrentTile());
				thePlayer.getTheGame().getGameFrame().getContentPane().removeAll();
			    thePlayer.getTheGame().getGameFrame().getContentPane().repaint();
				thePlayer.getTheGame().getGameFrame().getContentPane().add(thePlayer.getTheGame().gettBoardGUI(),BorderLayout.NORTH);
				thePlayer.getTheGame().getGameFrame().getContentPane().add(thePlayer.getTheGame().getBoardGUI());
				thePlayer.getTheGame().getGameFrame().getContentPane().add(thePlayer.getTheGame().getbBoardGUI(),BorderLayout.SOUTH);
				thePlayer.getTheGame().getGameFrame().setVisible(true);
			}
		});
		add(QueenButton);
		
		JButton BishopButton = new JButton("Bishop");
		BishopButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				thePawn.selectBishop(thePawn.getCurrentTile());
				thePlayer.getTheGame().getGameFrame().getContentPane().removeAll();
			    thePlayer.getTheGame().getGameFrame().getContentPane().repaint();
				thePlayer.getTheGame().getGameFrame().getContentPane().add(thePlayer.getTheGame().gettBoardGUI(),BorderLayout.NORTH);
				thePlayer.getTheGame().getGameFrame().getContentPane().add(thePlayer.getTheGame().getBoardGUI());
				thePlayer.getTheGame().getGameFrame().getContentPane().add(thePlayer.getTheGame().getbBoardGUI(),BorderLayout.SOUTH);
				thePlayer.getTheGame().getGameFrame().setVisible(true);
			}
		});
		add(BishopButton);
		
		JButton KnightButton = new JButton("Knight");
		KnightButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				thePawn.selectKnight(thePawn.getCurrentTile());
				thePlayer.getTheGame().getGameFrame().getContentPane().removeAll();
			    thePlayer.getTheGame().getGameFrame().getContentPane().repaint();
				thePlayer.getTheGame().getGameFrame().getContentPane().add(thePlayer.getTheGame().gettBoardGUI(),BorderLayout.NORTH);
				thePlayer.getTheGame().getGameFrame().getContentPane().add(thePlayer.getTheGame().getBoardGUI());
				thePlayer.getTheGame().getGameFrame().getContentPane().add(thePlayer.getTheGame().getbBoardGUI(),BorderLayout.SOUTH);
				thePlayer.getTheGame().getGameFrame().setVisible(true);
			}
		});
		add(KnightButton);
		
		JButton RookButton = new JButton("Rook");
		RookButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				thePawn.selectRook(thePawn.getCurrentTile());
				thePlayer.getTheGame().getGameFrame().getContentPane().removeAll();
			    thePlayer.getTheGame().getGameFrame().getContentPane().repaint();
				thePlayer.getTheGame().getGameFrame().getContentPane().add(thePlayer.getTheGame().gettBoardGUI(),BorderLayout.NORTH);
				thePlayer.getTheGame().getGameFrame().getContentPane().add(thePlayer.getTheGame().getBoardGUI());
				thePlayer.getTheGame().getGameFrame().getContentPane().add(thePlayer.getTheGame().getbBoardGUI(),BorderLayout.SOUTH);
				thePlayer.getTheGame().getGameFrame().setVisible(true);
			}
		});
		add(RookButton);
	}
}
