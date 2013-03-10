package threePlayerChessa;

import java.util.Vector;

public class PauseMenu {
	public Board theBoard;
	public Vector<Team> gameTeams = new Vector<Team>();
	public Game theGame;



	public PauseMenu(Board theBoard, Vector<Team> gameTeams, Game theGame) {
		super();
		this.theBoard = theBoard;
		this.gameTeams = gameTeams;
		this.theGame = theGame;
	}

	public void reset() {
		theBoard.reset();
		gameTeams.elementAt(0).addPiecesToBoard();
		gameTeams.elementAt(1).addPiecesToBoard();
		gameTeams.elementAt(2).addPiecesToBoard();
		theGame.gameFrame.getContentPane().removeAll();
	    theGame.gameFrame.getContentPane().repaint();
		theGame.gameFrame.getContentPane().add(theGame.boardGUI);
		theGame.gameFrame.setVisible(true);
	}

	public void endGame() {
		theBoard.reset();
		theGame.gameFrame.getContentPane().removeAll();
	    theGame.gameFrame.getContentPane().repaint();
		theGame.gameFrame.getContentPane().add(theGame.mainMenuGUI);
		theGame.gameFrame.setVisible(true);
	}

	public void callForStalemate() {
		theGame.gameFrame.getContentPane().removeAll();
	    theGame.gameFrame.getContentPane().repaint();
		theGame.gameFrame.getContentPane().add(theGame.stalmateGUI);
		theGame.gameFrame.setVisible(true);
	}

	public void resume() {
		theGame.gameFrame.getContentPane().removeAll();
	    theGame.gameFrame.getContentPane().repaint();
		theGame.gameFrame.getContentPane().add(theGame.boardGUI);
		theGame.gameFrame.setVisible(true);
	}
}