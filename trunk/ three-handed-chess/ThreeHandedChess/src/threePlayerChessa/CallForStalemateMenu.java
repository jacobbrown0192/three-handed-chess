package threePlayerChessa;

public class CallForStalemateMenu {
	boolean player0Yes;
	boolean player1Yes;
	boolean player2Yes;
	Board theBoard;
	Game theGame;
	
	
	
	public CallForStalemateMenu(Board theBoard,Game theGame) {
		super();
		this.player0Yes = false;
		this.player1Yes = false;
		this.player2Yes = false;
		this.theBoard = theBoard;
		this.theGame = theGame;
		
		
	}
	
	public void yes(){
		
		if(player0Yes == true && player1Yes == true && player2Yes == true){
			theBoard.reset();
		}		
	}
	
	public void no(){
		theGame.gameFrame.getContentPane().removeAll();
	    theGame.gameFrame.getContentPane().repaint();
		theGame.gameFrame.getContentPane().add(theGame.pauseMenuGUI);
		theGame.gameFrame.setVisible(true);
	}
	
	
	
	
	
}