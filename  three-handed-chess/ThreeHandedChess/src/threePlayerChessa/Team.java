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
	public boolean evil;
	public int AIDificulty;
	
	public Team(int colour, String name, int number, Board theBoard, Vector<Piece> pieces) {
		super();
		this.colour = colour;
		this.name = name;
		this.number = number;
		this.pieces = pieces;
		this.theBoard = theBoard;
	}	
	
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
		
	public boolean isEvil() {
		return evil;
	}

	public void setEvil(boolean evil) {
		this.evil = evil;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int aNumber) {
		this.number = aNumber;
	}
	
	public int getAIDificulty() {
		return AIDificulty;
	}

	public void setAIDificulty(int aIDificulty) {
		AIDificulty = aIDificulty;
	}

	public void addToMoveList(int num, int let){
		MoveList temp = new MoveList(num,let);
		moves.add(temp);
	}
	
	public void addToTeam(Piece addedPiece){
		pieces.add(addedPiece);
	}
	
	public void addPiecesToBoard(){
		int piece = 0;
		Section temp = null;
		for (int i =0; i <3; i++){
			if(theBoard.sections.elementAt(i).getColour() == this){
				temp = theBoard.sections.elementAt(i);
			}
		}
		if (this.getNumber() == 1){
			for(int i = 0; i <4; i++){
				temp.segments.elementAt(0).tiles.elementAt(i+4).setPiece(pieces.elementAt(piece));
				piece++;
			}
			for(int i = 0; i <4; i++){
				temp.segments.elementAt(1).tiles.elementAt(i+4).setPiece(pieces.elementAt(piece));
				piece++;
			}
			for(int i = 0; i <4; i++){
				temp.segments.elementAt(0).tiles.elementAt(i).setPiece(pieces.elementAt(piece));
				piece++;
			}
			for(int i = 0; i <4; i++){
				temp.segments.elementAt(1).tiles.elementAt(i).setPiece(pieces.elementAt(piece));
				piece++;
			}
			
		}
		if(this.getNumber() == 2){
			for(int i = 0; i <4; i++){
				temp.segments.elementAt(0).tiles.elementAt(11-i).setPiece(pieces.elementAt(piece));
				piece++;
			}
			for(int i = 0; i <4; i++){
				temp.segments.elementAt(1).tiles.elementAt(11-i).setPiece(pieces.elementAt(piece));
				piece++;
			}
			for(int i = 0; i <4; i++){
				temp.segments.elementAt(0).tiles.elementAt(15-i).setPiece(pieces.elementAt(piece));
				piece++;
			}
			for(int i = 0; i <4; i++){
				temp.segments.elementAt(1).tiles.elementAt(15-i).setPiece(pieces.elementAt(piece));
				piece++;
			}
			
			
		}
		if(this.getNumber() == 3){
			for(int i = 0; i <4; i++){
				temp.segments.elementAt(0).tiles.elementAt(11-i).setPiece(pieces.elementAt(piece));
				piece++;
			}
			for(int i = 0; i <4; i++){
				temp.segments.elementAt(1).tiles.elementAt(8+i).setPiece(pieces.elementAt(piece));
				piece++;
			}
			for(int i = 0; i <4; i++){
				temp.segments.elementAt(0).tiles.elementAt(15-i).setPiece(pieces.elementAt(piece));
				piece++;
			}
			for(int i = 0; i <4; i++){
				temp.segments.elementAt(1).tiles.elementAt(12+i).setPiece(pieces.elementAt(piece));
				piece++;
			}
		}
		
	}
		
}