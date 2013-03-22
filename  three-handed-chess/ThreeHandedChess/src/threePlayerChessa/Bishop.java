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
		boolean validMove = false;
		player.getTheGame().click1 = null;
		player.getTheGame().click2 = null;

		for(int i=0; i<validTileMoves.size();i++){
			if(aMoveTile == validTileMoves.elementAt(i)){
				validMove = true;
			}
		}
		
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
		Tile tempPrevious = this.currentTile;
		
		//UPLEFT CHECK
		while (temp.upleft != null)
		{
			//Check that you're looking in the right direction
			if(tempPrevious == temp.upleft)
			{
				//Wrong direction
				//If piece belonging to you is there
				if(temp.downright.getPiece() != null )
				{
					if(temp.downright.getPiece().getPlayer() == this.getPlayer())
					{
						//Can't go any further in this direction: don't add and break
						break;
					}
				}
			}
			else
			{
				//If piece belonging to you is there
				if(temp.upleft.getPiece() != null )
				{
					if(temp.upleft.getPiece().getPlayer() == this.getPlayer())
					{
						//Can't go any further in this direction: don't add and break
						break;
					}
				}
			}
			
			//Check that the tile you're adding in this direction isn't the tile you added last
			if(tempPrevious == temp.upleft)
			{
				//Wrong direction
				this.validTileMoves.add(temp.downright);
				tempPrevious = temp;
				temp = temp.downright;			
			}
			else
			{
				//Right direction
				this.validTileMoves.add(temp.upleft);
				tempPrevious = temp;
				temp = temp.upleft;
			}
			
			//If piece belonging to enemy is there
			if(temp.getPiece() != null)
			{
				//We've added the tile, now break
				break;
			}
		}
		
		if(temp.getLetter() == 5 && temp.getNumber() == 4)
		{
			tempPrevious = temp;
			this.validTileMoves.add(temp.specialleft);
			temp = temp.specialleft;
			while (temp.upleft != null)
			{
				//If piece belonging to you is there
				if(temp.upleft.getPiece() != null )
				{
					if(temp.upleft.getPiece().getPlayer() == this.getPlayer())
					{
						//Can't go any further in this direction: don't add and break
						break;
					}
				}
				
				this.validTileMoves.add(temp.upleft);
				temp = temp.upleft;
				//If piece belonging to enemy is there
				if(temp.getPiece() != null)
				{
					//We've added the tile, now break
					break;
				}
			}
				
				temp = tempPrevious;
				this.validTileMoves.add(temp.specialup);
				temp = temp.specialup;
				while (temp.upleft != null)
				{
					//If piece belonging to you is there
					if(temp.upleft.getPiece() != null )
					{
						if(temp.upleft.getPiece().getPlayer() == this.getPlayer())
						{
							//Can't go any further in this direction: don't add and break
							break;
						}
					}
					
					this.validTileMoves.add(temp.upleft);
					temp = temp.upleft;
					//If piece belonging to enemy is there
					if(temp.getPiece() != null)
					{
						//We've added the tile, now break
						break;
					}
				
			}
			
		}
		
		//upleft CHECK
		temp = this.currentTile;
		tempPrevious = this.currentTile;
		while (temp.upright != null)
		{
			//Check that you're looking in the right direction
			if(tempPrevious == temp.upright)
			{
				//Wrong direction
				//If piece belonging to you is there
				if(temp.downleft.getPiece() != null )
				{
					if(temp.downleft.getPiece().getPlayer() == this.getPlayer())
					{
						//Can't go any further in this direction: don't add and break
						break;
					}
				}
			}
			else
			{
				if(temp.upright.getPiece() != null )
				{
					if(temp.upright.getPiece().getPlayer() == this.getPlayer())
					{
						//Can't go any further in this direction: don't add and break
						break;
					}
				}
				
			}
			
			//Check that the tile you're adding in this direction isn't the tile you added last
			if(tempPrevious == temp.upright)
			{
				//Wrong direction
				this.validTileMoves.add(temp.downleft);
				tempPrevious = temp;
				temp = temp.downleft;
			}
			else
			{
				//Right direction
				this.validTileMoves.add(temp.upright);
				tempPrevious = temp;
				temp = temp.upright;
			}
			
			//If piece belonging to enemy is there
			if(temp.getPiece() != null)
			{
				//We've added the tile, now break
				break;
			}
		}
		
		if(temp.getLetter() == 4 && temp.getNumber() == 4)
		{
			tempPrevious = temp;
			this.validTileMoves.add(temp.specialright);
			temp = temp.specialright;
			while (temp.upright != null)
			{
				//If piece belonging to you is there
				if(temp.upright.getPiece() != null )
				{
					if(temp.upright.getPiece().getPlayer() == this.getPlayer())
					{
						//Can't go any further in this direction: don't add and break
						break;
					}
				}
				
				this.validTileMoves.add(temp.upright);
				temp = temp.upright;
				//If piece belonging to enemy is there
				if(temp.getPiece() != null)
				{
					//We've added the tile, now break
					break;
				}
			}
				
				temp = tempPrevious;
				this.validTileMoves.add(temp.specialup);
				temp = temp.specialup;
				while (temp.upright != null)
				{
					//If piece belonging to you is there
					if(temp.upright.getPiece() != null )
					{
						if(temp.upright.getPiece().getPlayer() == this.getPlayer())
						{
							//Can't go any further in this direction: don't add and break
							break;
						}
					}
					
					this.validTileMoves.add(temp.upright);
					temp = temp.upright;
					//If piece belonging to enemy is there
					if(temp.getPiece() != null)
					{
						//We've added the tile, now break
						break;
					}
			
				}
			
		}
		
		
		
		
		//DOWNLEFT CHECK
		temp = this.currentTile;
		tempPrevious = this.currentTile;
		while (temp.downleft != null)
		{
			//Check that you're looking in the right direction
			if(tempPrevious == temp.downleft)
			{
				//Wrong direction
				//If piece belonging to you is there
				if(temp.upleft != null && temp.upleft.getPiece() != null )
				{
					if(temp.upleft.getPiece().getPlayer() == this.getPlayer())
					{
						//Can't go any further in this direction: don't add and break
						break;
					}
				}
			}
			else
			{
				if(temp.downleft.getPiece() != null )
				{
					if(temp.downleft.getPiece().getPlayer() == this.getPlayer())
					{
						//Can't go any further in this direction: don't add and break
						break;
					}
				}				
			}
			
			//Check that the tile you're adding in this direction isn't the tile you added last
			if(tempPrevious == temp.downleft)
			{
				//Wrong direction
				this.validTileMoves.add(temp.upleft);
				tempPrevious = temp;
				if(temp.upleft == null)
				{
					break;
				}
				temp = temp.upleft;
				
			}
			else
			{
				//Right direction
				this.validTileMoves.add(temp.downleft);
				tempPrevious = temp;
				temp = temp.downleft;
			}
			
			//If piece belonging to enemy is there
			if(temp.getPiece() != null)
			{
				//We've added the tile, now break
				break;
			}
		}
		
		
		if(temp.getLetter() == 5 && temp.getNumber() == 9)
		{
			tempPrevious = temp;
			this.validTileMoves.add(temp.specialdown);
			temp = temp.specialdown;
			while (temp.downleft != null)
			{
				//If piece belonging to you is there
				if(temp.downleft.getPiece() != null )
				{
					if(temp.downleft.getPiece().getPlayer() == this.getPlayer())
					{
						//Can't go any further in this direction: don't add and break
						break;
					}
				}
				
				this.validTileMoves.add(temp.downleft);
				temp = temp.downleft;
				//If piece belonging to enemy is there
				if(temp.getPiece() != null)
				{
					//We've added the tile, now break
					break;
				}
			}
				
				temp = tempPrevious;
				this.validTileMoves.add(temp.specialleft);
				temp = temp.specialleft;
				while (temp.upright != null)
				{
					//If piece belonging to you is there
					if(temp.upright.getPiece() != null )
					{
						if(temp.upright.getPiece().getPlayer() == this.getPlayer())
						{
							//Can't go any further in this direction: don't add and break
							break;
						}
					}
					
					this.validTileMoves.add(temp.upright);
					temp = temp.upright;
					//If piece belonging to enemy is there
					if(temp.getPiece() != null)
					{
						//We've added the tile, now break
						break;
					}
			
				}
			
		}
		
		if(temp.getLetter() == 9 && temp.getNumber() == 5)
		{
			tempPrevious = temp;
			this.validTileMoves.add(temp.specialdown);
			temp = temp.specialdown;
			while (temp.upright != null)
			{
				//If piece belonging to you is there
				if(temp.upright.getPiece() != null )
				{
					if(temp.upright.getPiece().getPlayer() == this.getPlayer())
					{
						//Can't go any further in this direction: don't add and break
						break;
					}
				}
				
				this.validTileMoves.add(temp.upright);
				temp = temp.upright;
				//If piece belonging to enemy is there
				if(temp.getPiece() != null)
				{
					//We've added the tile, now break
					break;
				}
			}
				
				temp = tempPrevious;
				this.validTileMoves.add(temp.specialleft);
				temp = temp.specialleft;
				while (temp.downleft != null)
				{
					//If piece belonging to you is there
					if(temp.downleft.getPiece() != null )
					{
						if(temp.downleft.getPiece().getPlayer() == this.getPlayer())
						{
							//Can't go any further in this direction: don't add and break
							break;
						}
					}
					
					this.validTileMoves.add(temp.downleft);
					temp = temp.downleft;
					//If piece belonging to enemy is there
					if(temp.getPiece() != null)
					{
						//We've added the tile, now break
						break;
					}
			
				}
			
		}
		
		
		//DOWNRIGHT CHECK
		temp = this.currentTile;
		tempPrevious = this.currentTile;
		while (temp.downright != null)
		{
			//Check that you're looking in the right direction
			if(tempPrevious == temp.downright)
			{
				//Wrong direction
				//If piece belonging to you is there
				if(temp.upleft != null && temp.upleft.getPiece() != null)
				{
					if(temp.upleft.getPiece().getPlayer() == this.getPlayer())
					{
						//Can't go any further in this direction: don't add and break
						break;
					}
				}
			}
			else
			{
				if(temp.downright.getPiece() != null )
				{
					if(temp.downright.getPiece().getPlayer() == this.getPlayer())
					{
						//Can't go any further in this direction: don't add and break
						break;
					}
				}
			}
			
			//Check that the tile you're adding in this direction isn't the tile you added last
			if(tempPrevious == temp.downright)
			{
				//Wrong direction
				this.validTileMoves.add(temp.upleft);
				tempPrevious = temp;
				if(temp.upleft == null)
				{
					break;
				}
				temp = temp.upleft;
			}
			else
			{
				//Right direction
				this.validTileMoves.add(temp.downright);
				tempPrevious = temp;
				temp = temp.downright;
			}
			
			//If piece belonging to enemy is there
			if(temp.getPiece() != null)
			{
				//We've added the tile, now break
				break;
			}
		}
		
		
		if(temp.getLetter() == 4 && temp.getNumber() == 5)
		{
			tempPrevious = temp;
			this.validTileMoves.add(temp.specialdown);
			temp = temp.specialdown;
			while (temp.downright != null)
			{
				//If piece belonging to you is there
				if(temp.downright.getPiece() != null )
				{
					if(temp.downright.getPiece().getPlayer() == this.getPlayer())
					{
						//Can't go any further in this direction: don't add and break
						break;
					}
				}
				
				this.validTileMoves.add(temp.downright);
				temp = temp.downright;
				//If piece belonging to enemy is there
				if(temp.getPiece() != null)
				{
					//We've added the tile, now break
					break;
				}
			}
				
				temp = tempPrevious;
				this.validTileMoves.add(temp.specialright);
				temp = temp.specialright;
				while (temp.upleft != null)
				{
					//If piece belonging to you is there
					if(temp.upleft.getPiece() != null )
					{
						if(temp.upleft.getPiece().getPlayer() == this.getPlayer())
						{
							//Can't go any further in this direction: don't add and break
							break;
						}
					}
					
					this.validTileMoves.add(temp.upleft);
					temp = temp.upleft;
					//If piece belonging to enemy is there
					if(temp.getPiece() != null)
					{
						//We've added the tile, now break
						break;
					}
			
				}
			
		}
		
		if(temp.getLetter() == 9 && temp.getNumber() == 9)
		{
			tempPrevious = temp;
			this.validTileMoves.add(temp.specialright);
			temp = temp.specialright;
			while (temp.downright != null)
			{
				//If piece belonging to you is there
				if(temp.downright.getPiece() != null )
				{
					if(temp.downright.getPiece().getPlayer() == this.getPlayer())
					{
						//Can't go any further in this direction: don't add and break
						break;
					}
				}
				
				this.validTileMoves.add(temp.downright);
				temp = temp.downright;
				//If piece belonging to enemy is there
				if(temp.getPiece() != null)
				{
					//We've added the tile, now break
					break;
				}
			}
				
				temp = tempPrevious;
				this.validTileMoves.add(temp.specialdown);
				temp = temp.specialdown;
				while (temp.upleft != null)
				{
					//If piece belonging to you is there
					if(temp.upleft.getPiece() != null )
					{
						if(temp.upleft.getPiece().getPlayer() == this.getPlayer())
						{
							//Can't go any further in this direction: don't add and break
							break;
						}
					}
					
					this.validTileMoves.add(temp.upleft);
					temp = temp.upleft;
					//If piece belonging to enemy is there
					if(temp.getPiece() != null)
					{
						//We've added the tile, now break
						break;
					}
			
				}
			
		}
		
		//SPECIAL UP CHECK (From tile 		
	}
}
















