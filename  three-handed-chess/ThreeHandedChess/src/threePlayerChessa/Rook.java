package threePlayerChessa;




/**  
 *The Rook class extends Piece. 
 *Its movement style is to move straight.
 *
 */
public class Rook extends Piece {

	/**  
	 * Rook constructor
	 * @param 	player - the player who owns this piece
	 * 			name - the name of the piece.
	 * 			theBoard - the board which the pieces belong
	 * 			currentTile - the tile the piece is currently occupying.
	 * @return	null
	 * 
	 */
	public Rook(Team player, String name, Board theBoard, Tile currentTile,PieceType type) {
		super(player, name, theBoard, currentTile,type);
		// TODO Auto-generated constructor stub
		initialMove = false;
		this.jumpTwo = false;
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
		player.getTheGame().click2 = null;
		
		
		for( int i=0; i<validTileMoves.size();i++)
		{
			if(aMoveTile == validTileMoves.elementAt(i))
			{
				validMove = true;
				player.getTheGame().click1 = null;
			}
		}
		
		if (validMove)
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
				if (initialMove == false)
				{
					initialMove = true;
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
		return false;
	}

	/** Finds all the possible moves that this rook can perform and adds them to the <code>validMoveList</code>.
	 */
	public void possibleMoves(){
		validTileMoves.clear();
		Tile temp = this.currentTile;
		Tile tempPrevious = this.currentTile;
		
		
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