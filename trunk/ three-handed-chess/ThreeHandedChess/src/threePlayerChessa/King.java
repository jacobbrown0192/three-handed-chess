package threePlayerChessa;

/**  
 *The Knight class extends Piece. 
 *Its movement style is to move two spaces straight and one to the left or right.
 *The king holds a special purpose which is to see if it is in check or checkmate.
 *The king has a special move know as castling.
 *If the king hasn't moved and a rook has no pieces between it and the king and
 *	the rook has also not moved the king may move two spaces towards 
 *
 */
public class King extends Piece {

	/**  
	 * Knight constructor
	 * @param 	player - one of three possible teams.
	 * 			name - the name of the piece.
	 * 			theBoard - the board being used for the game.
	 * 			currentTile - the tile the piece is currently occupying.
	 * @return	null
	 * 
	 */
	public King(Team player, String name, Board theBoard, Tile currentTile) {
		super(player, name, theBoard, currentTile);
		// TODO Auto-generated constructor stub
	}

	/**  
	 * moves the piece from one tile to another
	 * @param	aStartTile - the tile initially selected 
	 * 			aMoveTile - the tile to where the player wishes to move the piece from the inital tile
	 * 			player - the current players thread
	 * @return null
	 * 
	 */
	public void move(Tile aStartTile, Tile aMoveTile, Turn player) {
		boolean validMove = false;
		//check for valid move
		if (validMove){	//moves piece
			if(aMoveTile.getPiece() != null){	// sets pieces current tile on aMoveTile to null
				aMoveTile.getPiece().setCurrentTile(null);
			}
			aMoveTile.setPiece(aStartTile.getPiece());
			aStartTile.setPiece(null);
			player.getTheGame().gameController.addToCounter(); //adds one to turn counter and starts the next players turn
		}
		else{	//if not a valid move returns for player to choose new tiles
			return;
		}
	}


}