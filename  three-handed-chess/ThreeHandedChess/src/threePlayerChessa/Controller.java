package threePlayerChessa;

public class Controller {
	Game theGame;
	int turnCount;
	boolean inProgress;
	
	
	public Controller(Game aGame){
		theGame = aGame;
		turnCount = 0;
	}


	public boolean isInProgress() {
		return inProgress;
	}
	public void setInProgress(boolean inProgress) {
		this.inProgress = inProgress;
	}
	
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
	
	public boolean inCheck(){
		
		return false;
		
	}
}