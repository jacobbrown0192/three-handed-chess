package threePlayerChessa;

import java.util.Vector;
import threePlayerChessa.Piece;

/**  
 *The Team class is the class that holds all the information for all players in the game.
 */
public class Team {
	private int colour; //piece colour 
	private String name; //name of the player
	private Vector<MoveList> moves = new Vector<MoveList>(); //list of moves made during game
	private int number; //the players number. used for play order
	public Vector<Piece> pieces = new Vector<Piece>(); //pieces belonging to this player
	public Board theBoard; //the board of the game
	public boolean evil; //determines wither the team is a computer
	public int AIDifficulty; //determines the difficulty of the team if it is a computer team

	
	/**
	 * Team constructor 
	 * @param colour - selects a colour of the teams pieces
	 * @param name - name of the player
	 * @param number - the players order number
	 * @param pieces - the pieces of the team
	 * @param theBoard - the board which the game is played on
	 */
	public Team(int colour, String name, int number, Board theBoard, Vector<Piece> pieces) {
		super();
		this.colour = colour;
		this.name = name;
		this.number = number;
		this.pieces = pieces;
		this.theBoard = theBoard;
		evil = false;
		AIDifficulty = 5;
	}	
	
	/**
	 * @return the colour
	 */
	public int getColour() {
		return colour;
	}
	/**
	 * @param colour - used to set colour
	 */
	public void setColour(int colour) {
		this.colour = colour;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name - used to set name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number - used to set number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the evil
	 */
	public boolean isEvil() {
		return evil;
	}

	/**
	 * @param evil - used to set evil
	 */
	public void setEvil(boolean evil) {
		this.evil = evil;
	}

	/**
	 * @return the AIDifficulty
	 */
	public int getAIDifficulty() {
		return AIDifficulty;
	}

	/**
	 * @param aIDifficulty - used to set AIDifficulty
	 */
	public void setAIDifficulty(int aIDifficulty) {
		AIDifficulty = aIDifficulty;
	}

	/**
	 * @param num - used to add a move to list
	 * @param let - used to add a move to list
	 */
	public void addToMoveList(int num, int let){
		MoveList temp = new MoveList(num,let);
		moves.add(temp);
	}
	
	/**
	 * @param addedPiece - used to add a Piece to pieces
	 */
	public void addToTeam(Piece addedPiece){
		pieces.add(addedPiece);
	}
	
	/**
	 * @param aBoard - used to set theBoard
	 */
	public void addboard(Board aBoard){
		theBoard = aBoard;
	}
	
	/**
	 * @param aPieces - used to set pieces
	 */
	public void addFullTeam(Vector<Piece> aPieces){
		pieces = aPieces;
	}
	
	
	/**
	 * used to add pieces to the board initially
	 */
	public void addPiecesToBoard(){
		int piece = 0;
		Section temp = null;
		Tile startTile = null;
		for (int i =0; i <3; i++){
			if(theBoard.sections.elementAt(i).getColour() == this){
				temp = theBoard.sections.elementAt(i);
			}
		}
		// adds player ones pieces to the board using start positions
		if (this.getNumber() == 1){
			for(int i = 0; i <4; i++){
				startTile =	temp.segments.elementAt(0).tiles.elementAt(i+4);
				startTile.setPiece(pieces.elementAt(piece));
				pieces.elementAt(piece).setCurrentTile(startTile);
				piece++;
			}
			for(int i = 0; i <4; i++){
				startTile =	temp.segments.elementAt(1).tiles.elementAt(i+4);
				startTile.setPiece(pieces.elementAt(piece));
				pieces.elementAt(piece).setCurrentTile(startTile);
				piece++;
			}
			for(int i = 0; i <4; i++){
				startTile =	temp.segments.elementAt(0).tiles.elementAt(i);
				startTile.setPiece(pieces.elementAt(piece));
				pieces.elementAt(piece).setCurrentTile(startTile);
				piece++;
			}
			for(int i = 0; i <4; i++){
				startTile =	temp.segments.elementAt(1).tiles.elementAt(i);
				startTile.setPiece(pieces.elementAt(piece));
				pieces.elementAt(piece).setCurrentTile(startTile);
				piece++;
			}
			
		}
		// adds player twos pieces to the board using start positions
		if(this.getNumber() == 2){
			for(int i = 0; i <4; i++){
				startTile =	temp.segments.elementAt(0).tiles.elementAt(11-i);
				startTile.setPiece(pieces.elementAt(piece));
				pieces.elementAt(piece).setCurrentTile(startTile);
				piece++;
			}
			for(int i = 0; i <4; i++){
				startTile =	temp.segments.elementAt(1).tiles.elementAt(11-i);
				startTile.setPiece(pieces.elementAt(piece));
				pieces.elementAt(piece).setCurrentTile(startTile);
				piece++;
			}
			for(int i = 0; i <4; i++){
				startTile =	temp.segments.elementAt(0).tiles.elementAt(15-i);
				startTile.setPiece(pieces.elementAt(piece));
				pieces.elementAt(piece).setCurrentTile(startTile);
				piece++;
			}
			for(int i = 0; i <4; i++){
				startTile =	temp.segments.elementAt(1).tiles.elementAt(15-i);
				startTile.setPiece(pieces.elementAt(piece));
				pieces.elementAt(piece).setCurrentTile(startTile);
				piece++;
			}
			
			
		}
		// adds player threes pieces to the board using start positions
		if(this.getNumber() == 3){
			for(int i = 0; i <4; i++){
				startTile =	temp.segments.elementAt(0).tiles.elementAt(11-i);
				startTile.setPiece(pieces.elementAt(piece));
				pieces.elementAt(piece).setCurrentTile(startTile);
				piece++;
			}
			for(int i = 0; i <4; i++){
				startTile =	temp.segments.elementAt(1).tiles.elementAt(8+i);
				startTile.setPiece(pieces.elementAt(piece));
				pieces.elementAt(piece).setCurrentTile(startTile);
				piece++;
			}
			for(int i = 0; i <4; i++){
				startTile =	temp.segments.elementAt(0).tiles.elementAt(15-i);
				startTile.setPiece(pieces.elementAt(piece));
				pieces.elementAt(piece).setCurrentTile(startTile);
				piece++;
			}
			for(int i = 0; i <4; i++){
				startTile =	temp.segments.elementAt(1).tiles.elementAt(12+i);
				startTile.setPiece(pieces.elementAt(piece));
				pieces.elementAt(piece).setCurrentTile(startTile);
				piece++;
			}
		}
		
	}
		
}