package threePlayerChessa;

import java.util.Vector;

public class PauseMenu {
	public Board theBoard;
	public Vector<Team> gameTeams = new Vector<Team>();



	public PauseMenu(Board theBoard, Vector<Team> gameTeams) {
		super();
		this.theBoard = theBoard;
		this.gameTeams = gameTeams;
	}

	public void reset() {
		theBoard.reset();
		gameTeams.elementAt(0).addPiecesToBoard();
		gameTeams.elementAt(1).addPiecesToBoard();
		gameTeams.elementAt(2).addPiecesToBoard();
	}

	public void endGame() {
		theBoard.reset();
	}

	public void callForStalemate() {
		/*
		 * open callforstalemate menu
		 */
	}

	public void resume() {
		//something about remove GUI from screen im not really sure
	}
}