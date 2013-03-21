package threePlayerChessa;



/**  
 *The Knight class extends Piece. 
 *Its movement style is to move two spaces straight and one to the left or right.
 *
 */
public class Knight extends Piece {

	
	/**  
	 * Knight constructor
	 * @param 	player - the player who owns this piece
	 * 			name - the name of the piece.
	 * 			theBoard - the board which the pieces belong
	 * 			currentTile - the tile the piece is currently occupying.
	 * @return	null
	 * 
	 */
	public Knight(Team player, String name, Board theBoard, Tile currentTile,PieceType type) {
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
	public void move(Tile aStartTile, Tile aMoveTile, Turn player) {
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
		
		//Up 2 Left 1
		//Check if there is a tile up from us
		if(temp.up != null)
		{
			//If there is we go on to check the tile up from that
			//Check that there's a tile up from us
			if(temp.up.up != null)
			{
				//If there is: check that it's not where we are now
				if(temp.up.up == temp)
				{
					//If it is: go up then down then right, so check if up.down has a tile there
					if(temp.up.down != null)
					{
						//If there is: check that up.down.right has a tile there
						if(temp.up.down.right != null)
						{
							//If there is: check if there's nobody there or if the piece belongs to the enemy
							if(temp.up.down.right.getPiece() == null || temp.up.down.right.getPiece().getPlayer() != this.getPlayer())
							{
								this.validTileMoves.add(temp.up.down.right);
							}
						}
					}
					else if(temp.up.up.left != null)
					{
						if(temp.up.up.left.getPiece() == null || temp.up.up.left.getPiece().getPlayer() != this.getPlayer())
						{
							this.validTileMoves.add(temp.up.up.left);
						}
					}
				}
			}
		}
		
		//Up 2 Right 1
		//Check if there is a tile up from us
		if(temp.up != null)
		{
			//If there is we go on to check the tile up from that
			if(temp.up.up != null)
			{
				//If there is: check that it's not where we are now
				if(temp.up.up == temp)
				{
					//If it is: go up then down then left, so check if up.down and up.down.left have tiles
					if(temp.up.down != null && temp.up.down.left != null)
					{
						//If they do: check if there's nobody there or if the piece belongs to the enemy
						if(temp.up.down.left.getPiece() == null || temp.up.down.left.getPiece().getPlayer() != this.getPlayer())
						{
							this.validTileMoves.add(temp.up.down.left);
						}
					}
					else if(temp.up.up.right != null)
					{
						if(temp.up.up.right.getPiece() == null || temp.up.up.right.getPiece().getPlayer() != this.getPlayer())
						{
							this.validTileMoves.add(temp.up.up.right);
						}
					}
				}
			}
		}
		
		//Up 1 Left 2
		if(temp.left != null)
		{
			if(temp.left.left != null)
			{
				if(temp.left.left.up != null)
				{
					if(temp.left.left.up.getPiece() == null || temp.left.left.up.getPiece().getPlayer() != this.getPlayer())
					{
						this.validTileMoves.add(temp.left.left.up);
					}
				}
			}
		}
		
		//Up 1 Right 2
		if(temp.right != null)
		{
			if(temp.right.right != null)
			{
				if(temp.right.right.up != null)
				{
					if(temp.right.right.up.getPiece() == null || temp.right.right.up.getPiece().getPlayer() != this.getPlayer())
					{
						this.validTileMoves.add(temp.right.right.up);
					}
				}
			}
		}
		
		//Down 2 Left 1
		//Check if there is a tile down from us
		if(temp.down != null)
		{
			//If there is we go on to check the tile down from that
			if(temp.down.down != null)
			{
				//If there is: check that it's not where we are now
				if(temp.down.down == temp)
				{
					//If it is: go down then up then right, so check if down.up and down.up.right have tiles
					if(temp.down.up != null && temp.down.up.right != null)
					{
						//If they do: check if there's nobody there or if the piece belongs to the enemy
						if(temp.down.up.right.getPiece() == null || temp.down.up.right.getPiece().getPlayer() != this.getPlayer())
						{
							this.validTileMoves.add(temp.down.up.right);
						}
					}
					else if(temp.down.down.left != null)
					{
						if(temp.down.down.left.getPiece() == null || temp.down.down.left.getPiece().getPlayer() != this.getPlayer())
						{
							this.validTileMoves.add(temp.down.down.left);
						}
					}
				}
			}
		}
		
		//Down 2 Right 1
		//Check if there is a tile down from us
		if(temp.down != null)
		{
			//If there is we go on to check the tile down from that
			if(temp.down.down != null)
			{
				//If there is: check that it's not where we are now
				if(temp.down.down == temp)
				{
					//If it is: go down then up then left, so check if down.up and down.up.left have tiles
					if(temp.down.up != null && temp.down.up.left != null)
					{
						//If they do: check if there's nobody there or if the piece belongs to the enemy
						if(temp.down.up.left.getPiece() == null || temp.down.up.left.getPiece().getPlayer() != this.getPlayer())
						{
							this.validTileMoves.add(temp.down.up.left);
						}
					}
					else if(temp.down.down.right != null)
					{
						if(temp.down.down.right.getPiece() == null || temp.down.down.right.getPiece().getPlayer() != this.getPlayer())
						{
							this.validTileMoves.add(temp.down.down.right);
						}
					}
				}
			}
		}
		
		//Down 1 Left 2
		if(temp.left != null)
		{
			if(temp.left.left != null)
			{
				if(temp.left.left.down != null)
				{
					if(temp.left.left.down.getPiece() == null || temp.left.left.down.getPiece().getPlayer() != this.getPlayer())
					{
						this.validTileMoves.add(temp.left.left.down);
					}
				}
			}
		}
		
		//Down 1 Right 2
		if(temp.right != null)
		{
			if(temp.right.right != null)
			{
				if(temp.right.right.down != null)
				{
					if(temp.right.right.down.getPiece() == null || temp.right.right.down.getPiece().getPlayer() != this.getPlayer())
					{
						this.validTileMoves.add(temp.right.right.down);
					}
				}
			}
		}
	}

}