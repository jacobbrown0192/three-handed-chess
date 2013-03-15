package threePlayerChessa;


/**  
 *The turn class is an extension of thread implemented for each player.
 */
public class Turn extends Thread {
	private Game theGame; //the game its self which contains everything
	public Team gameTeam; //the player of which this thread belongs
	public boolean check; //tells if the player is in check
	
	
	/**
	 * Controller constructor
	 * @param aGame - the game itself which contains everything.
	 * @param aTeam - the player of which this thread belongs to.
	 */
	public Turn(Game aGame,Team aTeam){
		setTheGame(aGame);
		gameTeam = aTeam;
	}
	
	/**  
	 *runs the thread 
	 */
	@Override public void run(){
		while(getTheGame().gameController.isInProgress() == true){ // checks to see if the game is in progress
			boolean validClick = false;
			check = getTheGame().gameController.inCheck();
			if (check){ //checks for player in check. update to come.
				//check for checkamte
			}
			Tile select1 = null;
			Tile select2 = null;
			if((getTheGame().gameController.turnCount % 3) == (gameTeam.getNumber() - 1)){ //checks to see if its current players turn
				if(getTheGame().click1 != null){ //check for first click
					
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
					if(select1.getPiece() != null){					
						if( select1.getPiece().player == gameTeam){
							validClick = true;
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
					
					
					if(validClick){
						validClick = false;
						if(getTheGame().click2 != null){
							
							//finds the second clicked tile
							for(int i =0; i < 3; i++){
								for(int j =0; j<2;j++){
									for(int k=0; k<16;k++){
										if(getTheGame().theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getLetter() == getTheGame().click2.getLet() &&
											getTheGame().theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getNumber() == getTheGame().click2.getNum()){
											select2 = getTheGame().theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k);
										}
									}
								}
							}
					
							//checks if second click is valid
							if( select2.getPiece() == null){
								validClick = true;
							}
							else{
								if(select2.getPiece().player != gameTeam)
									validClick = true;
								else{
								getTheGame().click1 = getTheGame().click2;
								getTheGame().click2 = null;
								}
							}
								
							
							if(getTheGame().click1 == getTheGame().click2){
								getTheGame().click1 = null;
								getTheGame().click2 = null;
							}
							
							//moves if second clikc is valid
							if(validClick){
								select1.getPiece().move(select1, select2,this);								
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


}
