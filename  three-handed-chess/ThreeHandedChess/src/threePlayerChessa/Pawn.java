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
		this.setSection2(null);
		this.setInitialMove(false);
		this.setTilesMoved(0);
		this.setTwoTileIndex(-1);
		this.setJumpTwo(false);
	}
	
	/**  
	 * moves the piece from one tile to another
	 * @param	aStartTile - the tile initially selected 
	 * 			aMoveTile - the tile to where the player wishes to move the piece from the initial tile
	 * 			player - the current players thread
	 * @return null
	 * 
	 */
	public boolean move(Tile aStartTile, Tile aMoveTile, Turn player) {
		boolean validMove = false;
		player.getTheGame().setClick2(null);
		int tempTwoTileIndex = -1;
		
		for(int i=0; i<getValidMoves().size();i++)
		{
			if(aMoveTile == getValidMoves().elementAt(i))
			{
				validMove = true;
				tempTwoTileIndex = i;
				player.getTheGame().setClick1(null);
			}
		}	
		
		//check for valid move
		if (validMove)
		{
			boolean check = player.getTheGame().getGameController().putIntoCheck(aStartTile, aMoveTile);
			
			if(check)
			{
				player.getTheGame().getbBoardGUI().getLblCheckLabel().setText("That move will put into check.");
			}
			if(!check)
			{
				if(tempTwoTileIndex == this.getTwoTileIndex())
				{
					this.setTilesMoved(this.getTilesMoved() + 2);
					this.setTwoTileIndex(-1);
				}
				else this.setTilesMoved(this.getTilesMoved() + 1);
				
				if(aMoveTile.getPiece() != null){	// sets pieces current tile on aMoveTile to null
					aMoveTile.getPiece().setCurrentTile(null);
				}
				if (isInitialMove() == false){
					setInitialMove(true);
				}
				if(aMoveTile == aStartTile.upright || aMoveTile == aStartTile.downright){
					if(aMoveTile.getPiece() == null){
						aStartTile.right.getPiece().setCurrentTile(null);
						aStartTile.right.setPiece(null);
					}
				}
				
				if(aMoveTile == aStartTile.upleft || aMoveTile == aStartTile.downleft){
					if(aMoveTile.getPiece() == null){
						aStartTile.left.getPiece().setCurrentTile(null);
						aStartTile.left.setPiece(null);
					}
				}
				
				if(aMoveTile.getPiece() != null){	// sets pieces current tile on aMoveTile to null
					aMoveTile.getPiece().setCurrentTile(null);
				}
				aMoveTile.setPiece(aStartTile.getPiece());
				aStartTile.setPiece(null);
				aMoveTile.getPiece().setCurrentTile(aMoveTile);
				
				if(aMoveTile.getNumber() == 1 || aMoveTile.getNumber() == 8 || aMoveTile.getNumber() == 12){
					if(this.getPlayer().isEvil() == true){
						this.selectQueen(getCurrentTile());
					}
					else{
					PromotePawn selector = new PromotePawn(this,player);
					player.getTheGame().getGameFrame().getContentPane().removeAll();
				    player.getTheGame().getGameFrame().getContentPane().repaint();
					player.getTheGame().getGameFrame().getContentPane().add(selector);
					player.getTheGame().getGameFrame().setVisible(true);
					}
				}
				player.getTheGame().getBoardGUI().setTileIcons();
				player.getTheGame().getGameController().addToCounter();
				this.getPlayer().addToMoveList(aMoveTile, this);
				
				return true;
			}
		}
		return false;
	}
	
	public void possibleMoves()
	{
		this.getValidMoves().clear(); //Flush previously held possible moves
		Tile temp = this.getCurrentTile();
		int team = this.getPlayer().getNumber();
		
		switch(team)
		{
			//Player 1: you can only go up
			case 1:
				if(getTilesMoved() >= 3)
				{
					//Can you move forward one?
					if(temp.up != null && temp.up.getPiece() == null)
					{
						this.getValidMoves().add(temp.up);
					}
					//Can you take upleft?
					if(temp.upleft != null && temp.upleft.getPiece() != null && temp.upleft.getPiece().getPlayer() != this.getPlayer())
					{
						this.getValidMoves().add(temp.upleft);
					}
					//Can you take upright?
					if(temp.upright != null && temp.upright.getPiece() != null && temp.upright.getPiece().getPlayer() != this.getPlayer())
					{
						this.getValidMoves().add(temp.upright);
					}
					if(this.getCurrentTile().getNumber() == 5 || this.getCurrentTile().getNumber() == 9 || this.getCurrentTile().getNumber() == 4){
						if(temp.right != null && temp.right.getPiece() != null && temp.right.getPiece().getPlayer() != this.getPlayer() && temp.upright.getPiece() == null){
							if(temp.right.getPiece().getPlayer().getMoves().lastElement().getPiece() == temp.right.getPiece() && temp.right.getPiece().isJumpTwo() == true){
								this.getValidMoves().add(temp.upright);
							}
						}
					}
					if(this.getCurrentTile().getNumber() == 5 || this.getCurrentTile().getNumber() == 9 || this.getCurrentTile().getNumber() == 4){
						if(temp.left != null && temp.left.getPiece() != null && temp.left.getPiece().getPlayer() != this.getPlayer() && temp.upleft.getPiece() == null){
							if(temp.left.getPiece().getPlayer().getMoves().lastElement().getPiece() == temp.left.getPiece() && temp.left.getPiece().isJumpTwo() == true){
								this.getValidMoves().add(temp.upleft);
							}
						}
					}
				}
				else
				{
					//Can you move forward one?
					if(temp.up != null && temp.up.getPiece() == null)
					{
						this.getValidMoves().add(temp.up);
					}
					//Can you move forward two?
					if(this.isInitialMove() == false && temp.up.getPiece() == null && temp.up.up.getPiece() == null)
					{
						this.getValidMoves().add(temp.up.up);
						setTwoTileIndex(this.getValidMoves().size() - 1); 
						this.setJumpTwo(true);
					}
					//Can you hop?
					if(this.getTilesMoved() < 3 && temp.hop != null && (temp.hop.getPiece() == null)) // || temp.hop.getPiece().getPlayer() != this.getPlayer()))
					{
						this.getValidMoves().add(temp.hop);
					}
					//Can you take upleft?
					if(temp.upleft != null && temp.upleft.getPiece() != null && temp.upleft.getPiece().getPlayer() != this.getPlayer())
					{
						this.getValidMoves().add(temp.upleft);
					}
					//Can you take upright?
					if(temp.upright != null && temp.upright.getPiece() != null && temp.upright.getPiece().getPlayer() != this.getPlayer())
					{
						this.getValidMoves().add(temp.upright);
					}
					//Can you take special up?
					if(temp.specialup != null && temp.specialup.getPiece() != null && temp.specialup.getPiece().getPlayer() != this.getPlayer())
					{
						this.getValidMoves().add(temp.specialup);
					}
					//Can you take special right?
					if(temp.specialright != null && temp.specialright.getPiece() != null && temp.specialright.getPiece().getPlayer() != this.getPlayer())
					{
						this.getValidMoves().add(temp.specialright);
					}
					//Can you take special left?
					if(temp.specialleft != null && temp.specialleft.getPiece() != null && temp.specialleft.getPiece().getPlayer() != this.getPlayer())
					{
						this.getValidMoves().add(temp.specialleft);
					}
				}
				break;
			//Player 2: you can go down 2 then up for segment 0 and down for segment 1
			case 2:
			case 3:
				//Have you moved this pawn three tiles?
				if(getTilesMoved() >= 3)
				{
					//In another player's section
					//Check which segment were're in to set our new forward
					int segNumId = this.getCurrentTile().getSegment().getMaxNum();
					int segLetId = this.getCurrentTile().getSegment().getMaxLet();
					
					if((segNumId == 4 && segLetId == 4) || (segNumId == 4 && segLetId == 8))
					{
						//We're in section 0: new forward is down
						//Can you move forward one?
						if(temp.down != null && temp.down.getPiece() == null)
						{
							this.getValidMoves().add(temp.down);
						}
						//Can you take left?
						if(temp.downleft != null && temp.downleft.getPiece() != null && temp.downleft.getPiece().getPlayer() != this.getPlayer())
						{
							this.getValidMoves().add(temp.downleft);
						}
						//Can you take right?
						if(temp.downright != null && temp.downright.getPiece() != null && temp.downright.getPiece().getPlayer() != this.getPlayer())
						{
							this.getValidMoves().add(temp.downright);
						}
						if(this.getCurrentTile().getNumber() == 5 || this.getCurrentTile().getNumber() == 9 || this.getCurrentTile().getNumber() == 4){
							if(temp.right != null && temp.right.getPiece() != null && temp.right.getPiece().getPlayer() != this.getPlayer() && temp.downright.getPiece() == null){
								if(temp.right.getPiece().getPlayer().getMoves().lastElement().getPiece() == temp.right.getPiece() && temp.right.getPiece().isJumpTwo() == true){
									this.getValidMoves().add(temp.downright);
								}
							}
						}
						if(this.getCurrentTile().getNumber() == 5 || this.getCurrentTile().getNumber() == 9 || this.getCurrentTile().getNumber() == 4){
							if(temp.left != null && temp.left.getPiece() != null && temp.left.getPiece().getPlayer() != this.getPlayer() && temp.downleft.getPiece() == null){
								if(temp.left.getPiece().getPlayer().getMoves().lastElement().getPiece() == temp.left.getPiece() && temp.left.getPiece().isJumpTwo() == true){
									this.getValidMoves().add(temp.downleft);
								}
							}
						}
					}
					else if ((segNumId == 8 && segLetId == 4) || (segNumId == 8 && segLetId == 12) || (segNumId == 12 && segLetId == 12) || (segNumId == 12 && segLetId == 8))
					{
						//We're in section 1 or 2: new forward is up
						//Can you move forward one?
						if(temp.up != null && temp.up.getPiece() == null)
						{
							this.getValidMoves().add(temp.up);
						}
						//Can you take left?
						if(temp.upleft != null && temp.upleft.getPiece() != null && temp.upleft.getPiece().getPlayer() != this.getPlayer())
						{
							this.getValidMoves().add(temp.upleft);
						}
						//Can you take left?
						if(temp.upright != null && temp.upright.getPiece() != null && temp.upright.getPiece().getPlayer() != this.getPlayer())
						{
							this.getValidMoves().add(temp.upright);
						}
						if(temp.right != null && temp.right.getPiece() != null && temp.right.getPiece().getPlayer() != this.getPlayer() && temp.upright.getPiece() == null){
							if(temp.right.getPiece().getPlayer().getMoves().lastElement().getPiece() == temp.right.getPiece() && temp.right.getPiece().isJumpTwo() == true){
								this.getValidMoves().add(temp.upright);
							}
						}
						if(temp.left != null && temp.left.getPiece() != null && temp.left.getPiece().getPlayer() != this.getPlayer() && temp.upleft.getPiece() == null){
							if(temp.left.getPiece().getPlayer().getMoves().lastElement().getPiece() == temp.left.getPiece() && temp.left.getPiece().isJumpTwo() == true){
								this.getValidMoves().add(temp.upleft);
							}
						}
					}
				}
				else //Still in our own section
				{
					//Can you move forward one?
					if(temp.down != null && temp.down.getPiece() == null)
					{
						this.getValidMoves().add(temp.down);
					}
					//Can you move forward two?
					if(this.isInitialMove() == false && temp.down.getPiece() == null && temp.down.down.getPiece() == null)
					{
						this.getValidMoves().add(temp.down.down);
						this.setTwoTileIndex(this.getValidMoves().size() - 1);
						this.setJumpTwo(true);
					}
					//Can you hop?
					if(temp.hop != null && (temp.hop.getPiece() == null)) // || temp.hop.getPiece().getPlayer() != this.getPlayer()))
					{
						this.getValidMoves().add(temp.hop);
					}
					//Can you take left?
					if(temp.downleft != null && temp.downleft.getPiece() != null && temp.downleft.getPiece().getPlayer() != this.getPlayer())
					{
						this.getValidMoves().add(temp.downleft);
					}
					//Can you take right?
					if(temp.downright != null && temp.downright.getPiece() != null && temp.downright.getPiece().getPlayer() != this.getPlayer())
					{
						this.getValidMoves().add(temp.downright);
					}
					//Can you take special down?
					if(temp.specialdown != null && temp.specialdown.getPiece() != null && temp.specialdown.getPiece().getPlayer() != this.getPlayer())
					{
						this.getValidMoves().add(temp.specialdown);
					}
					//Can you take special right?
					if(temp.specialright != null && temp.specialright.getPiece() != null && temp.specialright.getPiece().getPlayer() != this.getPlayer())
					{
						this.getValidMoves().add(temp.specialright);
					}
					//Can you take special left?
					if(temp.specialleft != null && temp.specialleft.getPiece() != null && temp.specialleft.getPiece().getPlayer() != this.getPlayer())
					{
						this.getValidMoves().add(temp.specialleft);
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
		Queen temp = new Queen(aTile.getPiece().getPlayer(),"PromotedQueen",getTheBoard(),aTile,PieceType.QUEEN);
		aTile.setPiece(temp);
		getTheBoard().getPromotedPieces().add(temp);
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
		Bishop temp = new Bishop(aTile.getPiece().getPlayer(),"PromotedBishop",getTheBoard(),aTile,PieceType.BISHOP);
		aTile.setPiece(temp);
		getTheBoard().getPromotedPieces().add(temp);
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
		Knight temp = new Knight(aTile.getPiece().getPlayer(),"PromotedKnight",getTheBoard(),aTile,PieceType.KNIGHT);
		aTile.setPiece(temp);
		getTheBoard().getPromotedPieces().add(temp);
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
		Rook temp = new Rook(aTile.getPiece().getPlayer(),"PromotedRook",getTheBoard(),aTile,PieceType.ROOK);
		aTile.setPiece(temp);
		getTheBoard().getPromotedPieces().add(temp);
	}

}