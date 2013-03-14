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
	
	public void addToCounter(){
		turnCount ++;
		notifyAll();
	}
	
	public boolean inCheck(){
		
		return false;
		
	}
}