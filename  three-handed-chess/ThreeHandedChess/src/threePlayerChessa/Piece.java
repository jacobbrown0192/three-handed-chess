package threePlayerChessa;

import java.util.Vector;

/**  
 *The Piece class is the super class for all the pieces going to be used in the game.
 *This class holds everything for the subclasses and the subclasses are only used for movement specification
 */
public abstract class Piece {
	Team player;
	String name;
	Board theBoard;
	Tile currentTile;
	PieceType type;
	Section section1;
	Section section2;
	boolean initialMove;
	public Vector<Tile> validTileMoves = new Vector<Tile>();
	
	/**  
	 *enumerated type used to tell what kind of piece is
	 * 
	 */
	public enum PieceType
	{
		PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING, NONE
	}
	
	
	/**
	 * @return the player
	 */
	public Team getPlayer() {
		return player;
	}

	/**
	 * @param player - used to set player
	 */
	public void setPlayer(Team player) {
		this.player = player;
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
	 * @return the theBoard
	 */
	public Board getTheBoard() {
		return theBoard;
	}

	/**
	 * @param theBoard - used to set theBoard
	 */
	public void setTheBoard(Board theBoard) {
		this.theBoard = theBoard;
	}

	/**
	 * @return the currentTile
	 */
	public Tile getCurrentTile() {
		return currentTile;
	}

	/**
	 * @param currentTile - used to set currentTile
	 */
	public void setCurrentTile(Tile currentTile) {
		this.currentTile = currentTile;
	}

	/**
	 * @return the type
	 */
	public PieceType getPieceType() {
		return type;
	}

	/**
	 * @param type - used to set type
	 */
	public void setPieceType(PieceType type) {
		this.type = type;
	}
	
	/**
	 * @return the section1
	 */
	public Section getSection1() {
		return section1;
	}

	/**
	 * @param section1 - used to set section1
	 */
	public void setSection1(Section section1) {
		this.section1 = section1;
	}

	/**
	 * @return the section2
	 */
	public Section getSection2() {
		return section2;
	}

	/**
	 * @param section2 - used to set section2
	 */
	public void setSection2(Section section2) {
		this.section2 = section2;
	}

	/**
	 * @return the initialMove
	 */
	public boolean isInitialMove() {
		return initialMove;
	}

	/**
	 * @param initialMove - used to set initialMove
	 */
	public void setInitialMove(boolean initialMove) {
		this.initialMove = initialMove;
	}

	/**  
	 * moves the piece from one tile to another
	 * @param	aStartTile - the tile initially selected 
	 * 			aMoveTile - the tile to where the player wishes to move the piece from the initial tile
	 * 			player - the current players thread
	 * 
	 */
	public void move(Tile aStartTile, Tile aMoveTile, Turn player){
		
	}

	
	public void possibleMoves(){
		
	}
	/**  
	 * removes the piece from the board
	 * @param	nextPiece - replaces current piece with this piece
	 * 
	 */
	public void remove(Piece nextPiece){
		this.currentTile.setPiece(nextPiece);
	}
	
	public void possibleMovesHighlight(){
		for(int i=0; i<validTileMoves.size();i++){
			if(validTileMoves.elementAt(i) != null){
				if(validTileMoves.elementAt(i).getPiece() == null){
					validTileMoves.elementAt(i).setAccessed(true);
				}
				else if(validTileMoves.elementAt(i).getPiece().player != this.player)
				{
					validTileMoves.elementAt(i).setAttacked(true);
				}
			}
			
		}
	}
	
	public void possibleMovesUnhighlight(){
		for(int i=0; i<validTileMoves.size();i++){
			if(validTileMoves.elementAt(i) != null){
				if(validTileMoves.elementAt(i).getPiece() == null){
					validTileMoves.elementAt(i).setAccessed(false);
				}
				else if(validTileMoves.elementAt(i).getPiece().player != this.player)
				{
					validTileMoves.elementAt(i).setAttacked(false);
				}
			}
		}
	}
		

	
	
	/**
	 * @param player - the player who owns this piece
	 * @param name - the name of the piece
	 * @param theBoard - the board which the game is played on
	 * @param currentTile - the tile the piece is currently occupying.
	 * @param type - the type of piece 
	 */
	public Piece(Team player, String name, Board theBoard, Tile currentTile,
			PieceType type) {
		this.player = player;
		this.name = name;
		this.theBoard = theBoard;
		this.currentTile = currentTile;
		this.type = type;
	}
}