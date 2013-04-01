package threePlayerChessa;

/**  
 *The MoveList class is used to tabulate all the moves made during the game
 *This class will be updated to allow for this
 */
public class MoveList {
	private Tile tile;//the move letter coordiante 
	private Piece piece; //the piece moved
	



	/**
	 * @return the tile
	 */
	public Tile getTile() {
		return tile;
	}
	/**
	 * @param tile - used to set tile
	 */
	public void setTile(Tile tile) {
		this.tile = tile;
	}
	/**
	 * @return the piece
	 */
	public Piece getPiece() {
		return piece;
	}
	/**
	 * @param piece - used to set piece
	 */
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	/**
	 * MoveList constructor
	 * @param num - the number coordinate
	 * @param let - the letter coordinate
	 */
	public MoveList(Tile tile, Piece piece) {
		this.tile = tile;
		this.piece = piece;
	}
	
}
