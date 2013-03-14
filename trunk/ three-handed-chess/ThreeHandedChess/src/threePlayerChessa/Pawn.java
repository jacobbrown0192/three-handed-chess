package threePlayerChessa;


import GUI_Interface.PromotePawn;


/**  
 *The Pawn class extends Piece. 
 *Its movement style is to move straight one space however it takes pieces one space diagonally
 *The Pawn has three special movements: 
 *It can move two spaces ahead the first move
 *It can preform en passant
 *It can be promoted by reaching another players bench.   
 *
 *Pawns are also restricted to two segments. 
 *Once a pawn enters a second segment it is unable to move into the third
 *
 */
public class Pawn extends Piece {

	

	/**  
	 * Pawn constructor
	 * @param 	player - the player who owns this piece
	 * 			name - the name of the piece.
	 * 			theBoard - the board which the pieces belong
	 * 			currentTile - the tile the piece is currently occupying.
	 * @return	null
	 * 
	 */
	public Pawn(Team player, String name, Board theBoard, Tile currentTile,PieceType type) {
		super(player, name, theBoard, currentTile,type);
		// TODO Auto-generated constructor stub
	}

	
	/**  
	 * moves the piece from one tile to another
	 * @param	aStartTile - the tile initially selected 
	 * 			aMoveTile - the tile to where the player wishes to move the piece from the initial tile
	 * 			player - the current players thread
	 * @return null
	 * 
	 */
	public void move(Tile aStartTile, Tile aMoveTile, Turn player) {
		boolean validMove = false;
		//check for valid move
		if (validMove){
			aMoveTile.setPiece(aStartTile.getPiece());
			aStartTile.setPiece(null);
			player.getTheGame().gameController.addToCounter();
			if(aMoveTile.getNumber() == 1 || aMoveTile.getNumber() == 8 || aMoveTile.getNumber() == 12){
				PromotePawn selector = new PromotePawn(this,player);
				player.getTheGame().gameFrame.getContentPane().removeAll();
			    player.getTheGame().gameFrame.getContentPane().repaint();
				player.getTheGame().gameFrame.getContentPane().add(selector);
				player.getTheGame().gameFrame.setVisible(true);
			}
			player.getTheGame().boardGUI.setTileIcons();
			player.getTheGame().gameController.addToCounter();
		}
		else{
			return;
		}
	}
		
	/**  
	 * When a pawn reaches an opponents bench it is promoted to 
	 * one of 4 selectable pieces including this one the Queen
	 * 
	 * @param	aTile - the tile where the promoted piece is to be placed
	 * @return null
	 * 
	 */
	public void selectQueen(Tile aTile){
		aTile.getPiece().setCurrentTile(null);
		Queen temp = new Queen(aTile.getPiece().getPlayer(),"Promoted Piece",theBoard,aTile,aTile.getPiece().getPieceType());
		aTile.setPiece(temp);
	}

	/**  
	 * When a pawn reaches an opponents bench it is promoted to 
	 * one of 4 selectable pieces including this one the Bishop
	 * 
	 * @param	aTile - the tile where the promoted piece is to be placed
	 * @return null
	 * 
	 */
	public void selectBishop(Tile aTile){
		aTile.getPiece().setCurrentTile(null);
		Bishop temp = new Bishop(aTile.getPiece().getPlayer(),"Promoted Piece",theBoard,aTile,aTile.getPiece().getPieceType());
		aTile.setPiece(temp);
	}

	/**  
	 * When a pawn reaches an opponents bench it is promoted to 
	 * one of 4 selectable pieces including this one the Knight
	 * 
	 * @param	aTile - the tile where the promoted piece is to be placed
	 * @return null
	 * 
	 */
	public void selectKnight(Tile aTile){
		aTile.getPiece().setCurrentTile(null);
		Knight temp = new Knight(aTile.getPiece().getPlayer(),"Promoted Piece",theBoard,aTile,aTile.getPiece().getPieceType());
		aTile.setPiece(temp);
	}
	
	/**  
	 * When a pawn reaches an opponents bench it is promoted to 
	 * one of 4 selectable pieces including this one the Rook
	 * 
	 * @param	aTile - the tile where the promoted piece is to be placed
	 * @return null
	 * 
	 */
	public void selectRook(Tile aTile){
		aTile.getPiece().setCurrentTile(null);
		Rook temp = new Rook(aTile.getPiece().getPlayer(),"Promoted Piece",theBoard,aTile,aTile.getPiece().getPieceType());
		aTile.setPiece(temp);
	}
}