package threePlayerChessa;


/**  
 *The Knight class extends Piece. 
 *Its movement style is to move two spaces straight and one to the left or right.
 *The king holds a special purpose which is to see if it is in check or checkmate.
 *The king has a special move know as castling.
 *If the king hasn't moved and a rook has no pieces between it and the king and
 *	the rook has also not moved the king may move two spaces towards the rook and
 *	the rook is placed to the opposite side of the king
 *
 */
public class King extends Piece {
	boolean initialMove;
	
	/**  
	 * Knight constructor
	 * @param 	player - the player who owns this piece
	 * 			name - the name of the piece.
	 * 			theBoard - the board which the pieces belong
	 * 			currentTile - the tile the piece is currently occupying.
	 * @return	null
	 * 
	 */
	public King(Team player, String name, Board theBoard, Tile currentTile,PieceType type) {
		super(player, name, theBoard, currentTile,type);
		// TODO Auto-generated constructor stub
		initialMove = false;
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
		player.getTheGame().click1 = null;
		player.getTheGame().click2 = null;
		//check for valid move
		int snum = aStartTile.getNumber();
		int slet = aStartTile.getLetter();
		int fnum = aMoveTile.getNumber();
		int flet = aMoveTile.getLetter();
		
		if(flet == slet){
			if(fnum == (snum-1)){
				if(!player.check)
					validMove = true;
			}
			if(fnum == (snum +1)){
				if(!player.check)
					validMove = true;
			}
		}
		if(fnum == snum){
			if(flet == (slet-1)){
				if(!player.check)
					validMove = true;
			}
			if(flet == (slet +1)){
				if(!player.check)
					validMove = true;
			}
		}
		if(flet == (slet+1)){
			if(fnum == (snum-1)){
				if(!player.check)
					validMove = true;
			}
			if(fnum == (snum +1)){
				if(!player.check)
					validMove = true;
			}
		}
		if(flet == (slet-1)){
			if(fnum == (snum-1)){
				if(!player.check)
					validMove = true;
			}
			if(fnum == (snum +1)){
				if(!player.check)
					validMove = true;
			}
		}
		
		if(aStartTile.segment != aMoveTile.segment){
			
		}
		
		
		
		
		
		if (validMove){	//moves piece
			if(aMoveTile.getPiece() != null){	// sets pieces current tile on aMoveTile to null
				aMoveTile.getPiece().setCurrentTile(null);
			}
			if (initialMove = false){
				initialMove = true;
			}
			aMoveTile.setPiece(aStartTile.getPiece());
			aStartTile.setPiece(null);
			aMoveTile.getPiece().setCurrentTile(aMoveTile);
			player.getTheGame().boardGUI.setTileIcons();
			player.getTheGame().gameController.addToCounter(); //adds one to turn counter and starts the next players turn
		}
		else{	//if not a valid move returns for player to choose new tiles
			return;
		}
	}

}