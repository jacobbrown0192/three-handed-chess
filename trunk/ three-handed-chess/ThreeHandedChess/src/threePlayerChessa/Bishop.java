package threePlayerChessa;



/**  
 *The Bishop class extends Piece. 
 *Its movement style is to move diagonally.
 *
 */
public class Bishop extends Piece {
	
	
	/**  
	 * Bishop constructor
	 * @param 	player - the player who owns this piece
	 * 			name - the name of the piece.
	 * 			theBoard - the board which the pieces belong
	 * 			currentTile - the tile the piece is currently occupying.
	 * @return	null
	 * 
	 */
	public Bishop(Team player, String name, Board theBoard, Tile currentTile,PieceType type) {
		super(player, name, theBoard, currentTile,type);
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
	public void move(Tile aStartTile, Tile aMoveTile, Turn player) 
	{
		boolean validMove = true;
		player.getTheGame().click1 = null;
		player.getTheGame().click2 = null;
		//check for valid move
		if (validMove){	//moves piece
			if(aMoveTile.getPiece() != null){	// sets pieces current tile on aMoveTile to null
				aMoveTile.getPiece().setCurrentTile(null);
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

	public void possibleMoves()
	{
		this.validTileMoves.clear(); //Flush previously held possible moves
		Tile temp = this.currentTile;
		
		//Upper Left Check
		while (temp.upleft != null)
		{
			//Check that you're looking in the right direction
			if(this.validTileMoves.get(this.validTileMoves.size() - 2) == temp.upleft)
			{
				//Wrong direction
				//If piece belonging to you is there
				if(temp.downright.getPiece() != null && temp.downright.getPiece().getPlayer() == this.getPlayer())
				{
					//Can't go any further in this direction: don't add and break
					break;
				}
			}
			else
			{
				//Right direction
				//If piece belonging to you is there
				if(temp.upleft.getPiece() != null && temp.upleft.getPiece().getPlayer() == this.getPlayer())
				{
					//Can't go any further in this direction: don't add and break
					break;
				}
			}
			
			//Check that the tile you're adding in this direction isn't the tile you added last
			if(this.validTileMoves.get(this.validTileMoves.size() - 2) == temp.upleft)
			{
				//Wrong direction
				this.validTileMoves.add(temp.downright);
				temp = temp.downright;
				
			}
			else
			{
				//Right direction
				this.validTileMoves.add(temp.upleft);
				temp = temp.upleft;
			}
			
			//If piece belonging to enemy is there
			if(temp.getPiece() != null)
			{
				//We've added the tile, now break
				break;
			}
		}
		
		temp = this.currentTile;
		//Upper Right Check
		while (temp.upright != null)
		{
			//Check that you're looking in the right direction
			if(this.validTileMoves.get(this.validTileMoves.size() - 2) == temp.upright)
			{
				//Wrong direction
				//If piece belonging to you is there
				if(temp.downright.getPiece() != null && temp.downright.getPiece().getPlayer() == this.getPlayer())
				{
					//Can't go any further in this direction: don't add and break
					break;
				}
			}
			else
			{
				//Right direction
				//If piece belonging to you is there
				if(temp.upright.getPiece() != null && temp.upright.getPiece().getPlayer() == this.getPlayer())
				{
					//Can't go any further in this direction: don't add and break
					break;
				}
			}
			
			//Check that the tile you're adding in this direction isn't the tile you added last
			if(this.validTileMoves.get(this.validTileMoves.size() - 2) == temp.upright)
			{
				//Wrong direction
				this.validTileMoves.add(temp.downright);
				temp = temp.downright;
				
			}
			else
			{
				//Right direction
				this.validTileMoves.add(temp.upright);
				temp = temp.upright;
			}
			
			//If piece belonging to enemy is there
			if(temp.getPiece() != null)
			{
				//We've added the tile, now break
				break;
			}
		}
		
		temp = this.currentTile;
		//Lower Left Check
		while (temp.downleft != null)
		{
			//Check that you're looking in the right direction
			if(this.validTileMoves.get(this.validTileMoves.size() - 2) == temp.downleft)
			{
				//Wrong direction
				//If piece belonging to you is there
				if(temp.upright.getPiece() != null && temp.upright.getPiece().getPlayer() == this.getPlayer())
				{
					//Can't go any further in this direction: don't add and break
					break;
				}
			}
			else
			{
				//Right direction
				//If piece belonging to you is there
				if(temp.downleft.getPiece() != null && temp.downleft.getPiece().getPlayer() == this.getPlayer())
				{
					//Can't go any further in this direction: don't add and break
					break;
				}
			}
			
			//Check that the tile you're adding in this direction isn't the tile you added last
			if(this.validTileMoves.get(this.validTileMoves.size() - 2) == temp.downleft)
			{
				//Wrong direction
				this.validTileMoves.add(temp.upright);
				temp = temp.upright;
				
			}
			else
			{
				//Right direction
				this.validTileMoves.add(temp.downleft);
				temp = temp.downleft;
			}
			
			//If piece belonging to enemy is there
			if(temp.getPiece() != null)
			{
				//We've added the tile, now break
				break;
			}
		}
		
		temp = this.currentTile;
		//Lower Right Check
		while (temp.downright != null)
		{
			//Check that you're looking in the right direction
			if(this.validTileMoves.get(this.validTileMoves.size() - 2) == temp.downright)
			{
				//Wrong direction
				//If piece belonging to you is there
				if(temp.upleft.getPiece() != null && temp.upleft.getPiece().getPlayer() == this.getPlayer())
				{
					//Can't go any further in this direction: don't add and break
					break;
				}
			}
			else
			{
				//Right direction
				//If piece belonging to you is there
				if(temp.downright.getPiece() != null && temp.downright.getPiece().getPlayer() == this.getPlayer())
				{
					//Can't go any further in this direction: don't add and break
					break;
				}
			}
			
			//Check that the tile you're adding in this direction isn't the tile you added last
			if(this.validTileMoves.get(this.validTileMoves.size() - 2) == temp.downright)
			{
				//Wrong direction
				this.validTileMoves.add(temp.upleft);
				temp = temp.upleft;
				
			}
			else
			{
				//Right direction
				this.validTileMoves.add(temp.downright);
				temp = temp.downright;
			}
			
			//If piece belonging to enemy is there
			if(temp.getPiece() != null)
			{
				//We've added the tile, now break
				break;
			}
		}
	}
}
















