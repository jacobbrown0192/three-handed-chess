package threePlayerChessa;


/**  
 *The turn class is an extension of thread implemented for each player.
 */
public class Turn extends Thread {
	private Game theGame; //the game its self which contains everything
	public Team gameTeam; //the player of which this thread belongs
	private Team opponent1;
	private Team opponent2;
	private boolean check; //tells if the player is in check
	boolean validClick1;
	boolean validClick2;
	
	
	/**
	 * Controller constructor
	 * @param aGame - the game itself which contains everything.
	 * @param aTeam - the player of which this thread belongs to.
	 * @param opponent2 
	 * @param opponent1 
	 */
	public Turn(Game aGame,Team aTeam, Team opponent1, Team opponent2)
	{
		setTheGame(aGame);
		gameTeam = aTeam;
		this.opponent1 = opponent1;
		this.opponent2 = opponent2;
	}
	
	/**  
	 *runs the thread 
	 */
	@Override public void run(){
		while(getTheGame().gameController.isInProgress() == true){ // checks to see if the game is in progress
			validClick1 = false;
			validClick2 = false;			
			this.check = false;//getTheGame().gameController.inCheck(gameTeam, opponent1, opponent2);
			
			Tile select1 = null;
			Tile select2 = null;
			if((getTheGame().gameController.turnCount % 3) == (gameTeam.getNumber() - 1))//checks to see if its current players turn
			{ 
				theGame.tBoardGUI.getLblGameAndStuff().setText(gameTeam.getName());
				if(getTheGame().click1 != null)//check for first click
				{
					theGame.gameController.Checkmate(gameTeam,opponent1,opponent2, theGame.theBoard);
					if(gameTeam.checkMate){
						System.out.println("Holy Shit checkmate!");
						
					}
					
					//finds the tile clicked
					for(int i =0; i < 3; i++){
						for(int j =0; j<2;j++){
							for(int k=0; k<16;k++){
								if(getTheGame().theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getLetter() == getTheGame().click1.getLet() &&
									getTheGame().theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getNumber() == getTheGame().click1.getNum()){
									select1 = getTheGame().theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k);
								}
							}
						}
					} 
					
					//see if first click is valid
					if(select1.getPiece() != null)
					{					
						if( select1.getPiece().player == gameTeam)
						{
							validClick1 = true;
							select1.setSelected(true);
							theGame.boardGUI.setTileIcons();
						}
						else
						{
							getTheGame().click1 = null;
						}
					}
					else
					{
						getTheGame().click1 = null;
					}
					
					
					if(validClick1)
					{
						select1.getPiece().possibleMoves();
						select1.getPiece().possibleMovesHighlight();
						theGame.boardGUI.setTileIcons();
						if(getTheGame().click2 != null)
						{	
							//finds the second clicked tile
							for(int i =0; i < 3; i++)
							{
								for(int j =0; j<2;j++)
								{
									for(int k=0; k<16;k++)
									{
										if(getTheGame().theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getLetter() == getTheGame().click2.getLet() &&
											getTheGame().theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getNumber() == getTheGame().click2.getNum()){
											select2 = getTheGame().theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k);
										}
									}
								}
							}
					
							
							if(select1.getPiece() != null && select2.getPiece() != null && select1.getPiece() == select2.getPiece())
							{
								select1.setSelected(false);
								select2.setSelected(false);
								select1.getPiece().possibleMovesUnhighlight();
								theGame.boardGUI.setTileIcons();
								getTheGame().click1 = null;
								getTheGame().click2 = null;
							}
							else if(select2.getPiece() != null && select2.getPiece().player == gameTeam)
							{
								select1.setSelected(false);
								select2.setSelected(true);
								select1.getPiece().possibleMovesUnhighlight();
								theGame.boardGUI.setTileIcons();
								getTheGame().click1 = getTheGame().click2;
								getTheGame().click2 = null;
							}
							//moves if second click is valid
							else
							{
								select1.getPiece().possibleMovesUnhighlight();
								select1.setSelected(false);
								select2.setSelected(false);
								select1.getPiece().move(select1, select2,this);
								theGame.boardGUI.setTileIcons();
							}							
						}
						else{
							suspendMe();
						}
					}
					
					
					
				}
				else{
					suspendMe();
				}			
			}
			else{
				suspendMe();
			}
		}		
	}
	
	
	/**  
	 *used to suspend the thread
	 */
	synchronized void suspendMe(){
		try {
			Thread.currentThread().wait();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**  
	 *used to notify the thread
	 */
	synchronized void unsuspendMe(){
		Thread.currentThread().notify();
	}


	/**
	 * @return the theGame
	 */
	public Game getTheGame() {
		return theGame;
	}


	/**
	 * @param theGame - used to set theGame
	 */
	public void setTheGame(Game theGame) {
		this.theGame = theGame;
	}
	
	public Team getGameTeam()
	{
		return this.gameTeam;
	}

	public Team getOpponent1()
	{
		return this.opponent1;
	}

	public Team getOpponent2()
	{
		return this.opponent2;
	}
	
	public void setCheck(boolean check)
	{
		this.check = check;
	}
	
	public boolean getCheck()
	{
		return this.check;
	}
}
