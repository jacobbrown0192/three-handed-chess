package threePlayerChessa;

import java.util.Vector;

public class Computer extends Team {
	
	public Computer(int colour, String name, int number,
			Board theBoard, Vector<Piece> pieces ) {
		super(colour, name, number, theBoard, pieces);
		// TODO Auto-generated constructor stub
		evil = true;
	}


}