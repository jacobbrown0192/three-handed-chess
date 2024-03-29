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
	public boolean move(Tile aStartTile, Tile aMoveTile, Turn player) 
	{
		boolean validMove = false;

		player.getTheGame().setClick2(null);

		for(int i=0; i<getValidMoves().size();i++){
			if(aMoveTile == getValidMoves().elementAt(i)){
				validMove = true;
				player.getTheGame().setClick1(null);
			}
		}
		
		if (validMove && aMoveTile != null && aStartTile != null)
		{	
			//Consider if the move will put you into check
			boolean check = player.getTheGame().getGameController().putIntoCheck(aStartTile, aMoveTile);
			
			if(check)
			{
				player.getTheGame().getbBoardGUI().getLblCheckLabel().setText("That move will put into check.");
			}
			//If it doesn't, move the piece on the game board
			if(!check)
			{
				if(aMoveTile.getPiece() != null){	// sets pieces current tile on aMoveTile to null
					aMoveTile.getPiece().setCurrentTile(null);
				}
				aMoveTile.setPiece(aStartTile.getPiece());
				aStartTile.setPiece(null);
				aMoveTile.getPiece().setCurrentTile(aMoveTile);
				player.getTheGame().getBoardGUI().setTileIcons();
				player.getTheGame().getGameController().addToCounter(); //adds one to turn counter and starts the next players turn
				this.getPlayer().addToMoveList(aMoveTile, this);
				return true;
			}
		}
		//if not a valid move returns for player to choose new tiles
		return false;
	}

	/** Finds all the possible moves that this bishop can perform and adds them to the <code>validMoveList</code>.
	 */
	public void possibleMoves()
	{
		this.getValidMoves().clear(); //Flush previously held possible moves
		Tile temp = this.getCurrentTile();
		Tile tempPrevious = this.getCurrentTile();
		
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
				this.getValidMoves().add(temp.downright);
				tempPrevious = temp;
				temp = temp.downright;			
			}
			else
			{
				//Right direction
				this.getValidMoves().add(temp.upleft);
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
			if(temp.specialleft.getPiece() != null){
				if(temp.specialleft.getPiece().getPlayer() != this.getPlayer()){
					this.getValidMoves().add(temp.specialleft);
				}				
			}
			else{
				this.getValidMoves().add(temp.specialleft);
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
					
					this.getValidMoves().add(temp.upleft);
					temp = temp.upleft;
					//If piece belonging to enemy is there
					if(temp.getPiece() != null)
					{
						//We've added the tile, now break
						break;
					}
				}
			}
				
				temp = tempPrevious;
				if(temp.specialup.getPiece() != null){
					if(temp.specialup.getPiece().getPlayer() != this.getPlayer()){
						this.getValidMoves().add(temp.specialup);
					}				
				}
				else{
					this.getValidMoves().add(temp.specialup);
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
						
						this.getValidMoves().add(temp.upleft);
						temp = temp.upleft;
						//If piece belonging to enemy is there
						if(temp.getPiece() != null)
						{
							//We've added the tile, now break
							break;
						}
					}
				}			
		}
		
		//upleft CHECK
		temp = this.getCurrentTile();
		tempPrevious = this.getCurrentTile();
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
				this.getValidMoves().add(temp.downleft);
				tempPrevious = temp;
				temp = temp.downleft;
			}
			else
			{
				//Right direction
				this.getValidMoves().add(temp.upright);
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
			if(temp.specialright.getPiece() != null){
				if(temp.specialright.getPiece().getPlayer() != this.getPlayer()){
					this.getValidMoves().add(temp.specialright);
				}				
			}
			else{
				this.getValidMoves().add(temp.specialright);
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
					
					this.getValidMoves().add(temp.upright);
					temp = temp.upright;
					//If piece belonging to enemy is there
					if(temp.getPiece() != null)
					{
						//We've added the tile, now break
						break;
					}
				}
			}
				
				temp = tempPrevious;
				if(temp.specialup.getPiece() != null){
					if(temp.specialup.getPiece().getPlayer() != this.getPlayer()){
						this.getValidMoves().add(temp.specialup);
					}				
				}
				else{
					this.getValidMoves().add(temp.specialup);
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
						
						this.getValidMoves().add(temp.upright);
						temp = temp.upright;
						//If piece belonging to enemy is there
						if(temp.getPiece() != null)
						{
							//We've added the tile, now break
							break;
						}
					}
				}
			
		}
		
		
		
		
		//DOWNLEFT CHECK
		temp = this.getCurrentTile();
		tempPrevious = this.getCurrentTile();
		while (temp.downleft != null)
		{
			//Check that you're looking in the right direction
			if(tempPrevious == temp.downleft)
			{
				//Wrong direction
				//If piece belonging to you is there
				if(temp.upright != null && temp.upright.getPiece() != null )
				{
					if(temp.upright.getPiece().getPlayer() == this.getPlayer())
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
				this.getValidMoves().add(temp.upright);
				tempPrevious = temp;
				if(temp.upright == null)
				{
					break;
				}
				temp = temp.upright;
				
			}
			else
			{
				//Right direction
				this.getValidMoves().add(temp.downleft);
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
			if(temp.specialdown.getPiece() != null){
				if(temp.specialdown.getPiece().getPlayer() != this.getPlayer()){
					this.getValidMoves().add(temp.specialdown);
				}				
			}
			else{
				this.getValidMoves().add(temp.specialdown);
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
					
					this.getValidMoves().add(temp.downleft);
					temp = temp.downleft;
					//If piece belonging to enemy is there
					if(temp.getPiece() != null)
					{
						//We've added the tile, now break
						break;
					}
				}
			}
				
				temp = tempPrevious;
				if(temp.specialleft.getPiece() != null){
					if(temp.specialleft.getPiece().getPlayer() != this.getPlayer()){
						this.getValidMoves().add(temp.specialleft);
					}				
				}
				else{
					this.getValidMoves().add(temp.specialleft);
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
						
						this.getValidMoves().add(temp.upright);
						temp = temp.upright;
						//If piece belonging to enemy is there
						if(temp.getPiece() != null)
						{
							//We've added the tile, now break
							break;
						}
					}
				}
		}
		
		if(temp.getLetter() == 9 && temp.getNumber() == 5)
		{
			tempPrevious = temp;
			if(temp.specialdown.getPiece() != null){
				if(temp.specialdown.getPiece().getPlayer() != this.getPlayer()){
					this.getValidMoves().add(temp.specialdown);
				}				
			}
			else{
				this.getValidMoves().add(temp.specialdown);
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
					
					this.getValidMoves().add(temp.upright);
					temp = temp.upright;
					//If piece belonging to enemy is there
					if(temp.getPiece() != null)
					{
						//We've added the tile, now break
						break;
					}
				}
			}
				
				temp = tempPrevious;
				if(temp.specialleft.getPiece() != null){
					if(temp.specialleft.getPiece().getPlayer() != this.getPlayer()){
						this.getValidMoves().add(temp.specialleft);
					}				
				}
				else{
					this.getValidMoves().add(temp.specialleft);
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
						
						this.getValidMoves().add(temp.downleft);
						temp = temp.downleft;
						//If piece belonging to enemy is there
						if(temp.getPiece() != null)
						{
							//We've added the tile, now break
							break;
						}
					}
				}
			
		}
		
		
		//DOWNRIGHT CHECK
		temp = this.getCurrentTile();
		tempPrevious = this.getCurrentTile();
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
				this.getValidMoves().add(temp.upleft);
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
				this.getValidMoves().add(temp.downright);
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
			if(temp.specialdown.getPiece() != null){
				if(temp.specialdown.getPiece().getPlayer() != this.getPlayer()){
					this.getValidMoves().add(temp.specialdown);
				}				
			}
			else{
				this.getValidMoves().add(temp.specialdown);
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
					
					this.getValidMoves().add(temp.downright);
					temp = temp.downright;
					//If piece belonging to enemy is there
					if(temp.getPiece() != null)
					{
						//We've added the tile, now break
						break;
					}
				}
			}
				
				temp = tempPrevious;
				if(temp.specialright.getPiece() != null){
					if(temp.specialright.getPiece().getPlayer() != this.getPlayer()){
						this.getValidMoves().add(temp.specialright);
					}				
				}
				else{
					this.getValidMoves().add(temp.specialright);
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
						
						this.getValidMoves().add(temp.upleft);
						temp = temp.upleft;
						//If piece belonging to enemy is there
						if(temp.getPiece() != null)
						{
							//We've added the tile, now break
							break;
						}
					}
				}
			
		}
		
		if(temp.getLetter() == 9 && temp.getNumber() == 9)
		{
			tempPrevious = temp;
			if(temp.specialright.getPiece() != null){
				if(temp.specialright.getPiece().getPlayer() != this.getPlayer()){
					this.getValidMoves().add(temp.specialright);
				}				
			}
			else{
				this.getValidMoves().add(temp.specialright);
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
					
					this.getValidMoves().add(temp.downright);
					temp = temp.downright;
					//If piece belonging to enemy is there
					if(temp.getPiece() != null)
					{
						//We've added the tile, now break
						break;
					}
				}
			}
				
				temp = tempPrevious;
				if(temp.specialdown.getPiece() != null){
					if(temp.specialdown.getPiece().getPlayer() != this.getPlayer()){
						this.getValidMoves().add(temp.specialdown);
					}				
				}
				else{
					this.getValidMoves().add(temp.specialdown);
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
						
						this.getValidMoves().add(temp.upleft);
						temp = temp.upleft;
						//If piece belonging to enemy is there
						if(temp.getPiece() != null)
						{
							//We've added the tile, now break
							break;
						}
					}
				}
			
		}
		
		//SPECIAL UP CHECK (From tile 		
	}
}
















