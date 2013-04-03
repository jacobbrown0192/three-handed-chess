package threePlayerChessa;


/**  
 *The Queen class extends Piece. 
 *Its movement style is to move straight or diagonally.
 *
 */
public class Queen extends Piece {


	/**  
	 * Queen constructor
	 * @param 	player - the player who owns this piece
	 * 			name - the name of the piece.
	 * 			theBoard - the board which the pieces belong
	 * 			currentTile - the tile the piece is currently occupying.
	 * @return	null
	 * 
	 */
	public Queen(Team player, String name, Board theBoard, Tile currentTile,PieceType type) {
		super(player, name, theBoard, currentTile,type);
		// TODO Auto-generated constructor stub
		this.jumpTwo = false;
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
		player.getTheGame().click2 = null;

		for( int i=0; i<validTileMoves.size();i++){
			if(aMoveTile == validTileMoves.elementAt(i)){
				validMove = true;
				player.getTheGame().click1 = null;
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
				this.player.addToMoveList(aMoveTile, this);	
				return true;
			}
		}
		//if not a valid move returns for player to choose new tiles
		return false;
	}
	
	/** Finds all the possible moves that this queen can perform and adds them to the <code>validMoveList</code>.
	 */
	public void possibleMoves(){
		this.validTileMoves.clear(); //Flush previously held possible moves
		Tile temp = this.currentTile;
		Tile tempPrevious = this.currentTile;
		
		//UPLEFT CHECK
		if(temp != null){
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
			if(temp.specialleft.getPiece() != null){
				if(temp.specialleft.getPiece().getPlayer() != this.getPlayer()){
					this.validTileMoves.add(temp.specialleft);
				}				
			}
			else{
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
			}
				
				temp = tempPrevious;
				if(temp.specialup.getPiece() != null){
					if(temp.specialup.getPiece().getPlayer() != this.getPlayer()){
						this.validTileMoves.add(temp.specialup);
					}				
				}
				else{
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
			if(temp.specialright.getPiece() != null){
				if(temp.specialright.getPiece().getPlayer() != this.getPlayer()){
					this.validTileMoves.add(temp.specialright);
				}				
			}
			else{
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
			}
				
				temp = tempPrevious;
				if(temp.specialup.getPiece() != null){
					if(temp.specialup.getPiece().getPlayer() != this.getPlayer()){
						this.validTileMoves.add(temp.specialup);
					}				
				}
				else{
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
				this.validTileMoves.add(temp.upright);
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
			if(temp.specialdown.getPiece() != null){
				if(temp.specialdown.getPiece().getPlayer() != this.getPlayer()){
					this.validTileMoves.add(temp.specialdown);
				}				
			}
			else{
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
			}
				
				temp = tempPrevious;
				if(temp.specialleft.getPiece() != null){
					if(temp.specialleft.getPiece().getPlayer() != this.getPlayer()){
						this.validTileMoves.add(temp.specialleft);
					}				
				}
				else{
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
		}
		
		if(temp.getLetter() == 9 && temp.getNumber() == 5)
		{
			tempPrevious = temp;
			if(temp.specialdown.getPiece() != null){
				if(temp.specialdown.getPiece().getPlayer() != this.getPlayer()){
					this.validTileMoves.add(temp.specialdown);
				}				
			}
			else{
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
			}
				
				temp = tempPrevious;
				if(temp.specialleft.getPiece() != null){
					if(temp.specialleft.getPiece().getPlayer() != this.getPlayer()){
						this.validTileMoves.add(temp.specialleft);
					}				
				}
				else{
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
			if(temp.specialdown.getPiece() != null){
				if(temp.specialdown.getPiece().getPlayer() != this.getPlayer()){
					this.validTileMoves.add(temp.specialdown);
				}				
			}
			else{
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
			}
				
				temp = tempPrevious;
				if(temp.specialright.getPiece() != null){
					if(temp.specialright.getPiece().getPlayer() != this.getPlayer()){
						this.validTileMoves.add(temp.specialright);
					}				
				}
				else{
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
			
		}
		
		if(temp.getLetter() == 9 && temp.getNumber() == 9)
		{
			tempPrevious = temp;
			if(temp.specialright.getPiece() != null){
				if(temp.specialright.getPiece().getPlayer() != this.getPlayer()){
					this.validTileMoves.add(temp.specialright);
				}				
			}
			else{
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
			}
				
				temp = tempPrevious;
				if(temp.specialdown.getPiece() != null){
					if(temp.specialdown.getPiece().getPlayer() != this.getPlayer()){
						this.validTileMoves.add(temp.specialdown);
					}				
				}
				else{
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
			
		}
		

		temp = this.currentTile;
		tempPrevious = this.currentTile;
		while (temp.up != null)
		{

			if(tempPrevious == temp.up)
			{
				//If piece belonging to you is there
				if(temp.down.getPiece() == null )
				{

				}
				else if(temp.down.getPiece().getPlayer() == this.getPlayer()){
					//Can't go any further in this direction: don't add and break
					break;
				}
			}
			else
			{
				if(temp.up.getPiece() == null )
				{

				}
				else if(temp.up.getPiece().getPlayer() == this.getPlayer()){
					//Can't go any further in this direction: don't add and break
					break;
				}
				
			}
			
			//Check that the tile you're adding in this direction isn't the tile you added last
			if(tempPrevious == temp.up)
			{
				this.validTileMoves.add(temp.down);
				tempPrevious = temp;
				temp = temp.down;

				
			}
			else
			{
				this.validTileMoves.add(temp.up);
				tempPrevious = temp;
				temp = temp.up;
			}
			
			//If piece belonging to enemy is there
			if(temp.getPiece() != null)
			{
				//We've added the tile, now break
				break;
			}
		}
		
		
		temp = this.currentTile;
		tempPrevious = this.currentTile;
		//Upper Left Check
		while (temp.down != null)
		{
			if(tempPrevious == temp.down)
			{
				if(temp.up != null){
					//If piece belonging to you is there
					if(temp.up.getPiece() == null )
					{

					}
					else if(temp.up.getPiece().getPlayer() == this.getPlayer()){
						//Can't go any further in this direction: don't add and break
						break;
					}
				}
				else
				{
					break;
				}
			}
			else
			{
				if(temp.down.getPiece() == null )
				{

				}
				else if(temp.down.getPiece().getPlayer() == this.getPlayer()){
					//Can't go any further in this direction: don't add and break
					break;
				}
			}
				
			
			//Check that the tile you're adding in this direction isn't the tile you added last
			if(tempPrevious == temp.down)
			{
				this.validTileMoves.add(temp.up);
				if(temp.up == null){
					break;
				}
				tempPrevious = temp;
				temp = temp.up;					
			}
			else
			{
				this.validTileMoves.add(temp.down);
				tempPrevious = temp;
				temp = temp.down;
			}
			
			//If piece belonging to enemy is there
			if(temp.getPiece() != null)
			{
				//We've added the tile, now break
				break;
			}
		}
			
			
		temp = this.currentTile;
		tempPrevious = this.currentTile;
		//Upper Left Check
		while (temp.left != null)
		{
			if(tempPrevious == temp.left)
			{
				//If piece belonging to you is there
				if(temp.right.getPiece() == null )
				{

				}
				else if(temp.right.getPiece().getPlayer() == this.getPlayer()){
					//Can't go any further in this direction: don't add and break
					break;
				}
			}
			else
			{
				if(temp.left.getPiece() == null )
				{

				}
				else if(temp.left.getPiece().getPlayer() == this.getPlayer()){
					//Can't go any further in this direction: don't add and break
					break;
				}
			}
				
			
			//Check that the tile you're adding in this direction isn't the tile you added last
			if(tempPrevious == temp.left)
			{
				this.validTileMoves.add(temp.right);
				tempPrevious = temp;
				temp = temp.right;
				
			}
			else
			{
				this.validTileMoves.add(temp.left);
				tempPrevious = temp;
				temp = temp.left;
			}
			
			//If piece belonging to enemy is there
			if(temp.getPiece() != null)
			{
				//We've added the tile, now break
				break;
			}
		}
		
		
		temp = this.currentTile;
		tempPrevious = this.currentTile;
		//Upper Left Check
		while (temp.right != null)
		{
			if(tempPrevious == temp.right)
			{
				//If piece belonging to you is there
				if(temp.left.getPiece() == null )
				{

				}
				else if(temp.left.getPiece().getPlayer() == this.getPlayer()){
					//Can't go any further in this direction: don't add and break
					break;
				}
			}
			else
			{
				if(temp.right.getPiece() == null )
				{

				}
				else if(temp.right.getPiece().getPlayer() == this.getPlayer()){
					//Can't go any further in this direction: don't add and break
					break;
				}
				
			}
			
			//Check that the tile you're adding in this direction isn't the tile you added last
			if(tempPrevious == temp.right)
			{
				this.validTileMoves.add(temp.left);
				tempPrevious = temp;
				temp = temp.left;
				
			}
			else
			{
				this.validTileMoves.add(temp.right);
				tempPrevious = temp;
				temp = temp.right;
			}
			
			//If piece belonging to enemy is there
			if(temp.getPiece() != null)
			{
				//We've added the tile, now break
				break;
			}
		}
	
		temp = this.currentTile;
		tempPrevious = this.currentTile;
		if(temp.hop != null){
			this.validTileMoves.add(temp.hop);
			temp = temp.hop;
			if(temp.getPiece() == null){
			if(temp.getPiece() == null )
			{

			}
			else if(temp.getPiece().getPlayer() == this.getPlayer()){
				//Can't go any further in this direction: don't add and break
				return;
			}
			
			while (temp.up != null && temp.up.getSegment() == temp.getSegment())
			{


					if(temp.up.getPiece() == null )
					{

					}
					else if(temp.up.getPiece().getPlayer() == this.getPlayer()){
						//Can't go any further in this direction: don't add and break
						break;
					}

				
				//Check that the tile you're adding in this direction isn't the tile you added last

					this.validTileMoves.add(temp.up);
					tempPrevious = temp;
					temp = temp.up;
				
				//If piece belonging to enemy is there
				if(temp.getPiece() != null)
				{
					//We've added the tile, now break
					break;
				}
			}
			
			
			temp = this.currentTile.hop;
			//Upper Left Check
			while (temp.down != null && temp.down.getSegment() == temp.getSegment())
			{

					if(temp.down.getPiece() == null )
					{

					}
					else if(temp.down.getPiece().getPlayer() == this.getPlayer()){
						//Can't go any further in this direction: don't add and break
						break;
					}

				
				//Check that the tile you're adding in this direction isn't the tile you added last

					this.validTileMoves.add(temp.down);
					temp = temp.down;

				
				//If piece belonging to enemy is there
				if(temp.getPiece() != null)
				{
					//We've added the tile, now break
					break;
				}
			}
				
				
			temp = this.currentTile.hop;
			//Upper Left Check
			while (temp.left != null && temp.left.getSegment() == temp.getSegment())
			{
					if(temp.left.getPiece() == null )
					{

					}
					else if(temp.left.getPiece().getPlayer() == this.getPlayer()){
						//Can't go any further in this direction: don't add and break
						break;
					}

					
				
				//Check that the tile you're adding in this direction isn't the tile you added last

					this.validTileMoves.add(temp.left);
					temp = temp.left;
				
				//If piece belonging to enemy is there
				if(temp.getPiece() != null)
				{
					//We've added the tile, now break
					break;
				}
			}
			
			temp = this.currentTile.hop;
			//Upper Left Check
			while (temp.right != null && temp.right.getSegment() == temp.getSegment())
			{

					if(temp.right.getPiece() == null )
					{

					}
					else if(temp.right.getPiece().getPlayer() == this.getPlayer()){
						//Can't go any further in this direction: don't add and break
						break;
					}

				
				//Check that the tile you're adding in this direction isn't the tile you added last

					this.validTileMoves.add(temp.right);
					temp = temp.right;

				//If piece belonging to enemy is there
				if(temp.getPiece() != null)
				{
					//We've added the tile, now break
					break;
				}
			}
			
		}
	}
		
		
}
	}


	
	

}