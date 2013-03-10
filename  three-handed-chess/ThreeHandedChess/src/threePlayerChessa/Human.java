package threePlayerChessa;

import java.util.Vector;

public class Human extends Team {

	public Human(int colour, String name, int number,
			Board theBoard, Vector<Piece> pieces) {
		super(colour, name, number, theBoard, pieces);
		// TODO Auto-generated constructor stub
		evil = false; //probably
	}

}
