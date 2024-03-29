package threePlayerChessa;

/**  
 *The CallForStalemateMenu is the model portion of the menu which allows the user to 
 * call for a draw if they believe the game is going no where or just becuase they no longer wish to play
 * but don't wish to forfeit.
 * This class will be updated to allow for this
 */
public class CallForStalemateMenu {
	private boolean player0Yes; //the response from player 1
	private boolean player1Yes; //the response from player 2
	private boolean player2Yes; //the response from player 3
	private Board theBoard; //the board of the game
	private Game theGame; //the game its self which contains everything
	
	
	/**
	 * CallForStalemateMenu constructor
	 * @param theBoard - the board which the game is played on
	 * @param theGame - the game its self which contains everything
	 */
	public CallForStalemateMenu(Board theBoard,Game theGame) {
		super();
		this.player0Yes = false;
		this.player1Yes = false;
		this.player2Yes = false;
		this.theBoard = theBoard;
		this.theGame = theGame;
		
		
	}
	
	/**
	 * used to select yes for player and end if all players selected yes
	 */
	public void yes(){
		if(player0Yes == true && player1Yes == true && player2Yes == true){
			theBoard.reset();
			theGame.getGameController().setInProgress(false);
		}		
	}
	
	/**
	 * used to select no for player and resume if any player selects no
	 */
	public void no(){
		this.player0Yes = false;
		this.player1Yes = false;
		this.player2Yes = false;
		theGame.getGameFrame().getContentPane().removeAll();
	    theGame.getGameFrame().getContentPane().repaint();
		theGame.getGameFrame().getContentPane().add(theGame.getPauseMenuGUI());
		theGame.getGameFrame().setVisible(true);
	}
	
	
	
	
	
}