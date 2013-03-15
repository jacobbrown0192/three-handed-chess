package threePlayerChessa;

/** 
 *The Controller class controls the turn counter, whether the game is in progress
 *and whether someone is in check. Checking for check has yet to be implemented.
 */
public class Controller {
	Game theGame; //the game its self which contains everything
	int turnCount; //counter for the number of turns so far
	boolean inProgress; //determines if the game is in progress
	
	/**
	 * Controller constructor
	 * @param aGame - the game its self which contains everything
	 */
	public Controller(Game aGame){
		theGame = aGame;
		turnCount = 0;
	}

	/**
	 * @return the inProgress
	 */
	public boolean isInProgress() {
		return inProgress;
	}
	/**
	 * @param inProgress - used to set inProgress
	 */
	public void setInProgress(boolean inProgress) {
		this.inProgress = inProgress;
	}

	/**
	 * used to add one to the counter and notify all the players
	 */
	public synchronized void addToCounter(){
		turnCount ++;
		synchronized (theGame.player1){
			theGame.player1.notify();
		}
		synchronized (theGame.player2){
			theGame.player2.notify();
		}
		synchronized (theGame.player3){
			theGame.player3.notify();
		}
	}
	
	/**
	 * @return the wither in check
	 */
	public boolean inCheck(){
			return false;
	}
}