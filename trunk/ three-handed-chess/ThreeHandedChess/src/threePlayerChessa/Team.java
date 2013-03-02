package threePlayerChessa;

import java.util.Vector;
import threePlayerChessa.Piece;

public class Team {
	private int colour;
	private String name;
	private Vector<MoveList> moves = new Vector<MoveList>();
	private int number;
	public Vector<Piece> pieces = new Vector<Piece>();
	public Board theBoard;
	
	public int getColour() {
		return this.colour;
	}

	public void setColour(int aColour) {
		this.colour = aColour;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String aName) {
		this.name = aName;
	}
	
	public Team(int colour, String name, int number, Vector<Piece> pieces, Board theBoard) {
		super();
		this.colour = colour;
		this.name = name;
		this.number = number;
		this.pieces = pieces;
		this.theBoard = theBoard;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int aNumber) {
		this.number = aNumber;
	}
	
	public void addToMoveList(int num, int let){
		MoveList temp = new MoveList(num,let);
		moves.add(temp);
	}
	
	public void addToTeam(Piece addedPiece){
		pieces.add(addedPiece);
	}
	
	public void addPiecesToBoard(){
		
	}
	
	public void resetBoard(){
		this.resetBoard();
		this.addPiecesToBoard();		
	}
	
	
	
}