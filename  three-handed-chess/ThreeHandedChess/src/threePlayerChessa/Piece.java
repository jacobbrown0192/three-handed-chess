package threePlayerChessa;

/**  
 *The Piece class is the super class for all the pieces going to be used in the game.
 *This class holds everything for the subclasses and the subclasses are only used for movement specification
 * 
 */
public abstract class Piece {
	Team player;
	String name;
	Board theBoard;
	Tile currentTile;
	PieceType type;

	/**  
	 *enumerated type used to tell what kind of piece is
	 * 
	 */
	public enum PieceType
	{
		PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING
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
	 * moves the piece from one tile to another
	 * @param	aStartTile - the tile initially selected 
	 * 			aMoveTile - the tile to where the player wishes to move the piece from the initial tile
	 * 			player - the current players thread
	 * @return null
	 * 
	 */
	public void move(Tile aStartTile, Tile aMoveTile, Turn player){
		
	}

	/**  
	 * removes the piece from the board
	 * @param	nextPiece - replaces current piece with this piece
	 * @return null
	 * 
	 */
	public void remove(Piece nextPiece){
		this.currentTile.setPiece(nextPiece);
	}
	
	/**
	 * @param player - the player who owns this piece
	 * @param name - the name of the piece
	 * @param theBoard - the board which the pieces belong
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