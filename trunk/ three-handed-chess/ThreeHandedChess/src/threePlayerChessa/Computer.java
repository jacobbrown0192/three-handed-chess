package threePlayerChessa;

import java.util.Vector;

/**  
 *The Human class is a subclass of the Team class.
 *It is one of two subclasses this one is controlled by a computer player.
 */
public class Computer extends Team {
	
	/**
	 * Computer constructor
	 * @param colour - selects a colour of the teams pieces
	 * @param name - name of the player
	 * @param number - the players order number
	 * @param pieces - the pieces of the team
	 * @param theBoard - the board which the game is played on
	 */
	public Computer(int colour, String name, int number,
			Board theBoard, Vector<Piece> pieces ) {
		super(colour, name, number, theBoard, pieces);
		// TODO Auto-generated constructor stub
		evil = true;
	}


}