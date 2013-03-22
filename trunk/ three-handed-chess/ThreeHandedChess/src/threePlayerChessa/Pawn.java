package threePlayerChessa;


import GUI_Interface.PromotePawn;


/**  
 *The Pawn class extends Piece. 
 *Its movement style is to move straight one space however it takes pieces one space diagonally
 *The Pawn has three special movements: 
 *It can move two spaces ahead the first move
 *It can perform en passant
 *It can be promoted by reaching another players bench.   
 *
 *Pawns are also restricted to two segments. 
 *Once a pawn enters a second segment it is unable to move into the third
 *
 */
public class Pawn extends Piece {
	Section section1;
	Section section2;
	boolean initialMove;
	int tilesMoved;
	int twoTileIndex;
	

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
		section2 = null;
		initialMove = false;
		tilesMoved = 0;
		twoTileIndex = -1;
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
		player.getTheGame().click2 = null;
		
		for(int i=0; i<validTileMoves.size();i++)
		{
			if(aMoveTile == validTileMoves.elementAt(i))
			{
				validMove = true;
				if(i == twoTileIndex)
				{
					tilesMoved += 2;
					twoTileIndex = -1;
				}
				else tilesMoved++;
				player.getTheGame().click1 = null;
			}
		}	
		
		//check for valid move
		if (validMove){
			aMoveTile.setPiece(aStartTile.getPiece());
			aStartTile.setPiece(null); 
			
			aMoveTile.getPiece().setCurrentTile(aMoveTile);
			if (this.initialMove == false){
				this.initialMove = true;
			}
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
	
	public void possibleMoves()
	{
		this.validTileMoves.clear(); //Flush previously held possible moves
		Tile temp = this.currentTile;
		int team = this.player.getNumber();
		
		switch(team)
		{
			//Player 1: you can only go up
			case 1:
				//Can you move forward one?
				if(temp.up != null && temp.up.getPiece() == null)
				{
					this.validTileMoves.add(temp.up);
				}
				//Can you move forward two?
				if(this.initialMove == false && temp.up.getPiece() == null && temp.up.up.getPiece() == null)
				{
					this.validTileMoves.add(temp.up.up);
					twoTileIndex = this.validTileMoves.size() - 1; 
				}
				//Can you hop?
				if(this.tilesMoved < 3 && temp.hop != null && (temp.hop.getPiece() == null || temp.hop.getPiece().getPlayer() != this.getPlayer()))
				{
					this.validTileMoves.add(temp.hop);
				}
				//Can you take upleft?
				if(temp.upleft != null && temp.upleft.getPiece() != null && temp.upleft.getPiece().getPlayer() != this.getPlayer())
				{
					this.validTileMoves.add(temp.upleft);
				}
				//Can you take upright?
				if(temp.upright != null && temp.upright.getPiece() != null && temp.upright.getPiece().getPlayer() != this.getPlayer())
				{
					this.validTileMoves.add(temp.upright);
				}
				//Can you take special up?
				if(temp.specialup != null && temp.specialup.getPiece() != null && temp.specialup.getPiece().getPlayer() != this.getPlayer())
				{
					this.validTileMoves.add(temp.specialup);
				}
				//Can you take special right?
				if(temp.specialright != null && temp.specialright.getPiece() != null && temp.specialright.getPiece().getPlayer() != this.getPlayer())
				{
					this.validTileMoves.add(temp.specialright);
				}
				//Can you take special left?
				if(temp.specialleft != null && temp.specialleft.getPiece() != null && temp.specialleft.getPiece().getPlayer() != this.getPlayer())
				{
					this.validTileMoves.add(temp.specialleft);
				}
				break;
			//Player 2: you can go down 2 then up for segment 0 and down for segment 1
			case 2:
			case 3:
				//Have you moved this pawn three tiles?
				if(tilesMoved >= 3)
				{
					//In another player's section
					//Check which segment were're in to set our new forward
					int segNumId = this.currentTile.getSegment().getMaxNum();
					int segLetId = this.currentTile.getSegment().getMaxLet();
					
					if((segNumId == 4 && segLetId == 4) || (segNumId == 4 && segLetId == 8))
					{
						//We're in section 0: new forward is down
						//Can you move forward one?
						if(temp.down != null && temp.down.getPiece() == null)
						{
							this.validTileMoves.add(temp.down);
						}
						//Can you take left?
						if(temp.downleft != null && temp.downleft.getPiece() != null && temp.downleft.getPiece().getPlayer() != this.getPlayer())
						{
							this.validTileMoves.add(temp.downleft);
						}
						//Can you take right?
						if(temp.downright != null && temp.downright.getPiece() != null && temp.downright.getPiece().getPlayer() != this.getPlayer())
						{
							this.validTileMoves.add(temp.downright);
						}
					}
					else if ((segNumId == 8 && segLetId == 4) || (segNumId == 8 && segLetId == 12) || (segNumId == 12 && segLetId == 12) || (segNumId == 12 && segLetId == 8))
					{
						//We're in section 1 or 2: new forward is up
						//Can you move forward one?
						if(temp.up != null && temp.up.getPiece() == null)
						{
							this.validTileMoves.add(temp.up);
						}
						//Can you take left?
						if(temp.upleft != null && temp.upleft.getPiece() != null && temp.upleft.getPiece().getPlayer() != this.getPlayer())
						{
							this.validTileMoves.add(temp.upleft);
						}
						//Can you take left?
						if(temp.upright != null && temp.upright.getPiece() != null && temp.upright.getPiece().getPlayer() != this.getPlayer())
						{
							this.validTileMoves.add(temp.upright);
						}
					}
				}
				else //Still in our own section
				{
					//Can you move forward one?
					if(temp.down != null && temp.down.getPiece() == null)
					{
						this.validTileMoves.add(temp.down);
					}
					//Can you move forward two?
					if(this.initialMove == false && temp.down.getPiece() == null && temp.down.down.getPiece() == null)
					{
						this.validTileMoves.add(temp.down.down);
						twoTileIndex = this.validTileMoves.size() - 1; 
					}
					//Can you hop?
					if(temp.hop != null && (temp.hop.getPiece() == null || temp.hop.getPiece().getPlayer() != this.getPlayer()))
					{
						this.validTileMoves.add(temp.hop);
					}
					//Can you take left?
					if(temp.downleft != null && temp.downleft.getPiece() != null && temp.downleft.getPiece().getPlayer() != this.getPlayer())
					{
						this.validTileMoves.add(temp.downleft);
					}
					//Can you take right?
					if(temp.downright != null && temp.downright.getPiece() != null && temp.downright.getPiece().getPlayer() != this.getPlayer())
					{
						this.validTileMoves.add(temp.downright);
					}
					//Can you take special down?
					if(temp.specialdown != null && temp.specialdown.getPiece() != null && temp.specialdown.getPiece().getPlayer() != this.getPlayer())
					{
						this.validTileMoves.add(temp.specialdown);
					}
					//Can you take special right?
					if(temp.specialright != null && temp.specialright.getPiece() != null && temp.specialright.getPiece().getPlayer() != this.getPlayer())
					{
						this.validTileMoves.add(temp.specialright);
					}
					//Can you take special left?
					if(temp.specialleft != null && temp.specialleft.getPiece() != null && temp.specialleft.getPiece().getPlayer() != this.getPlayer())
					{
						this.validTileMoves.add(temp.specialleft);
					}
				}
				break;
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
		Queen temp = new Queen(aTile.getPiece().getPlayer(),"Promoted Piece",theBoard,aTile,PieceType.QUEEN);
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
		Bishop temp = new Bishop(aTile.getPiece().getPlayer(),"Promoted Piece",theBoard,aTile,PieceType.BISHOP);
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
		Knight temp = new Knight(aTile.getPiece().getPlayer(),"Promoted Piece",theBoard,aTile,PieceType.KNIGHT);
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
		Rook temp = new Rook(aTile.getPiece().getPlayer(),"Promoted Piece",theBoard,aTile,PieceType.ROOK);
		aTile.setPiece(temp);
	}

}