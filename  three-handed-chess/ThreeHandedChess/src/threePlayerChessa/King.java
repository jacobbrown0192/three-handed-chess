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
	public void move(Tile aStartTile, Tile aMoveTile, Turn player) {
		boolean validMove = false;
		player.getTheGame().click2 = null;
		
		//check for valid move		
		for(int i=0; i<validTileMoves.size();i++){
			if(aMoveTile == validTileMoves.elementAt(i)){
				validMove = true;
				player.getTheGame().click1 = null;
			}
		}
		
		if (validMove)
		{	//moves piece
			boolean check = player.getTheGame().getGameController().putIntoCheck(aStartTile, aMoveTile);
			
			if(!check)
			{
				if(aMoveTile.getPiece() != null){	// sets pieces current tile on aMoveTile to null
					aMoveTile.getPiece().setCurrentTile(null);
				}
				if (initialMove = false){
					setInitialMove(true);// = true;
				}
				
				//castling move check so the rook is also moved
				if(aStartTile.right.right == aMoveTile){
					Piece temp = null;
					if(aMoveTile.right.getPiece() != null){
						if(aMoveTile.right.getPiece().getPieceType() == PieceType.ROOK){
							temp = aMoveTile.right.getPiece();
							temp.currentTile.setPiece(null);
							temp.setCurrentTile(aMoveTile.left);
							aMoveTile.left.setPiece(temp);
						}
					}
					if(aMoveTile.right.right != null &&	aMoveTile.right.right.getPiece() != null){
						if(aMoveTile.right.right.getPiece().getPieceType() == PieceType.ROOK){
							temp = aMoveTile.right.right.getPiece();
							temp.currentTile.setPiece(null);
							temp.setCurrentTile(aMoveTile.left);
							aMoveTile.left.setPiece(temp);
						}
					}
				}
				if(aStartTile.left.left == aMoveTile){
					Piece temp = null;
					if(aMoveTile.left.getPiece() != null){
						if(aMoveTile.left.getPiece().getPieceType() == PieceType.ROOK){
							temp = aMoveTile.left.getPiece();
							temp.currentTile.setPiece(null);
							temp.setCurrentTile(aMoveTile.right);
							aMoveTile.right.setPiece(temp);
						}
					}
					if(aMoveTile.left.left != null && aMoveTile.left.left.getPiece() != null){
						if(aMoveTile.left.left.getPiece().getPieceType() == PieceType.ROOK){
							temp = aMoveTile.left.left.getPiece();
							temp.currentTile.setPiece(null);
							temp.setCurrentTile(aMoveTile.right);
							aMoveTile.right.setPiece(temp);
						}
					}
				}
				aMoveTile.setPiece(aStartTile.getPiece());
				aStartTile.setPiece(null);
				aMoveTile.getPiece().setCurrentTile(aMoveTile);
				player.getTheGame().getBoardGUI().setTileIcons();
				player.getTheGame().getGameController().addToCounter(); //adds one to turn counter and starts the next players turn
				this.player.addToMoveList(aMoveTile, this);
			}
		}
		else
		{	//if not a valid move returns for player to choose new tiles
			return;
		}
	}
	
	public void possibleMoves()
	{
		this.validTileMoves.clear();
		Tile temp = this.currentTile;
		
		//Up Check
		//Check if there's a tile up
		if(temp.up != null)
		{
			//Check if there's nobody there or if the piece there belongs to the enemy
			if(temp.up.getPiece() == null || temp.up.getPiece().getPlayer() != this.getPlayer())
			{
				this.validTileMoves.add(temp.up);
			}
		}
		
		//Down Check
		//Check if there's a tile down
		if(temp.down != null)
		{
			//Check if there's nobody there or if the piece there belongs to the enemy
			if(temp.down.getPiece() == null || temp.down.getPiece().getPlayer() != this.getPlayer())
			{
				this.validTileMoves.add(temp.down);
			}
		}
		
		//Left Check
		//Check if there's a tile left
		if(temp.left != null)
		{
			//Check if there's nobody there or if the piece there belongs to the enemy
			if(temp.left.getPiece() == null || temp.left.getPiece().getPlayer() != this.getPlayer())
			{
				this.validTileMoves.add(temp.left);
			}
		}
		
		//Right Check
		//Check if there's a tile right
		if(temp.right != null)
		{
			//Check if there's nobody there or if the piece there belongs to the enemy
			if(temp.right.getPiece() == null || temp.right.getPiece().getPlayer() != this.getPlayer())
			{
				this.validTileMoves.add(temp.right);
			}
		}
		
		//Downleft Check
		//Check if there's a tile down left
		if(temp.downleft != null)
		{
			//Check if there's nobody there or if the piece there belongs to the enemy
			if(temp.downleft.getPiece() == null || temp.downleft.getPiece().getPlayer() != this.getPlayer())
			{
				this.validTileMoves.add(temp.downleft);
			}
		}
		
		//Downright Check
		//Check if there's a tile down right
		if(temp.downright != null)
		{
			//Check if there's nobody there or if the piece there belongs to the enemy
			if(temp.downright.getPiece() == null || temp.downright.getPiece().getPlayer() != this.getPlayer())
			{
				this.validTileMoves.add(temp.downright);
			}
		}
		
		//Upleft Check
		//Check if there's a tile up left
		if(temp.upleft != null)
		{
			//Check if there's nobody there or if the piece there belongs to the enemy
			if(temp.upleft.getPiece() == null || temp.upleft.getPiece().getPlayer() != this.getPlayer())
			{
				this.validTileMoves.add(temp.upleft);
			}
		}
		
		//Upright Check
		//Check if there's a tile up right
		if(temp.upright != null)
		{
			//Check if there's nobody there or if the piece there belongs to the enemy
			if(temp.upright.getPiece() == null || temp.upright.getPiece().getPlayer() != this.getPlayer())
			{
				this.validTileMoves.add(temp.upright);
			}
		}
		
		//Hop Check
		//Check if there's a tile hop
		if(temp.hop != null)
		{
			//Check if there's nobody there or if the piece there belongs to the enemy
			if(temp.hop.getPiece() == null || temp.hop.getPiece().getPlayer() != this.getPlayer())
			{
				this.validTileMoves.add(temp.hop);
			}
		}
		
		//Special Up Check
		//Check if there's a tile special up
		if(temp.specialup != null)
		{
			//Check if there's nobody there or if the piece there belongs to the enemy
			if(temp.specialup.getPiece() == null || temp.specialup.getPiece().getPlayer() != this.getPlayer())
			{
				this.validTileMoves.add(temp.specialup);
			}
		}
		
		//Special Down Check
		//Check if there's a tile special down
		if(temp.specialdown != null)
		{
			//Check if there's nobody there or if the piece there belongs to the enemy
			if(temp.specialdown.getPiece() == null || temp.specialdown.getPiece().getPlayer() != this.getPlayer())
			{
				this.validTileMoves.add(temp.specialdown);
			}
		}
		
		//Special Left Check
		//Check if there's a tile special left
		if(temp.specialleft != null)
		{
			//Check if there's nobody there or if the piece there belongs to the enemy
			if(temp.specialleft.getPiece() == null || temp.specialleft.getPiece().getPlayer() != this.getPlayer())
			{
				this.validTileMoves.add(temp.specialleft);
			}
		}
		
		//Special Right Check
		//Check if there's a tile special right
		if(temp.specialright != null)
		{
			//Check if there's nobody there or if the piece there belongs to the enemy
			if(temp.specialright.getPiece() == null || temp.specialright.getPiece().getPlayer() != this.getPlayer())
			{
				this.validTileMoves.add(temp.specialright);
			}
		}
		//castling
		if(initialMove == false){
			temp = this.currentTile;
			
			int team = this.getPlayer().getNumber();
			//int team = this.player.getNumber();
			
			switch(team)
			{
				//Player 1
				case 1:
					if(temp.left != null && temp.left.left != null && temp.left.left.left != null && temp.left.left.left.left != null && temp.left.getPiece() == null && temp.left.left.getPiece() == null && temp.left.left.left.getPiece() == null && temp.left.left.left.left.getPiece() != null)
					{
						if(temp.left.left.left.left.getPiece().getPieceType() == PieceType.ROOK && temp.left.left.left.left.getPiece().isInitialMove() == false)
						{
							this.validTileMoves.add(this.currentTile.left.left);
						}
					}
					
					if(temp.right != null && temp.right.right != null && temp.right.right.right != null && temp.right.getPiece() == null && temp.right.right.getPiece() == null && temp.right.right.right.getPiece() != null)
					{
						if(temp.right.right.right.getPiece().getPieceType() == PieceType.ROOK && temp.right.right.right.getPiece().isInitialMove() == false)
						{
							this.validTileMoves.add(this.currentTile.right.right);
						}
					}
					break;
				//Player 2 and 3
				case 2:
				case 3:
					if(temp.left != null && temp.left.left != null && temp.left.left.left != null && temp.left.getPiece() == null && temp.left.left.getPiece() == null && temp.left.left.left.getPiece() != null)
					{
						if(temp.left.left.left.getPiece().getPieceType() == PieceType.ROOK && temp.left.left.left.getPiece().isInitialMove() == false)
						{
							this.validTileMoves.add(this.currentTile.left.left);
						}
					}
					
					if(temp.right != null && temp.right.right != null && temp.right.right.right != null && temp.right.right.right.right != null && temp.right.getPiece() == null && temp.right.right.getPiece() == null && temp.right.right.right.getPiece() == null && temp.right.right.right.right.getPiece() != null)
					{
						if(temp.right.right.right.right.getPiece().getPieceType() == PieceType.ROOK && temp.right.right.right.right.getPiece().isInitialMove() == false)
						{
							this.validTileMoves.add(this.currentTile.right.right);
						}
					}
					break;
			}		
			/*temp = this.currentTile;
			while(temp.left != null)
			{
				temp = temp.left;
				if(temp.getPiece() != null){
					if(temp.getPiece().getPieceType() == PieceType.ROOK && temp.getPiece().isInitialMove() == false){
						this.validTileMoves.add(this.currentTile.left.left);
					}
				}
			}
			temp = this.currentTile;
			while(temp.right != null)
			{
				temp = temp.right;
				if(temp.getPiece() != null){
					if(temp.getPiece().getPieceType() == PieceType.ROOK && temp.getPiece().isInitialMove() == false){
						this.validTileMoves.add(this.currentTile.right.right);
					}
				}
			}*/			
		}	
	}
}










