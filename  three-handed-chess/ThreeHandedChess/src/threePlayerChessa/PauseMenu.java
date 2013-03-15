package threePlayerChessa;

import java.awt.BorderLayout;
import java.util.Vector;

/**
 *The PauseMenu is the model portion of the menu which allows the user to 
 *reset the game, end the game, enter the call for stalemate menu, and resume the game
 */
public class PauseMenu {
	public Board theBoard; //the board of the game
	public Vector<Team> gameTeams = new Vector<Team>(); //teams playing the game
	public Game theGame; //the game its self which contains everything


	/**
	 * PauseMenu constructor
	 * @param theBoard - the board which the game is played on
	 * @param gameTeams - the players in the game
	 * @param theGame - the game its self which contains everything
	 */
	public PauseMenu(Board theBoard, Vector<Team> gameTeams, Game theGame) {
		super();
		this.theBoard = theBoard;
		this.gameTeams = gameTeams;
		this.theGame = theGame;
	}

	/**
	 * used to restart the game
	 */
	public void reset() {
		theBoard.reset();
		theGame.gameController.setInProgress(false);
		theGame.startGame();
	}

	/**
	 * used to end the game
	 */
	public void endGame() {
		theBoard.reset();
		theGame.gameFrame.getContentPane().removeAll();
	    theGame.gameFrame.getContentPane().repaint();
		theGame.gameFrame.getContentPane().add(theGame.mainMenuGUI);
		theGame.gameFrame.setVisible(true);
		theGame.gameController.setInProgress(false);
	}

	/**
	 * used to enter the stalemate menu 
	 */
	public void callForStalemate() {
		theGame.gameFrame.getContentPane().removeAll();
	    theGame.gameFrame.getContentPane().repaint();
		theGame.gameFrame.getContentPane().add(theGame.stalemateGUI);
		theGame.gameFrame.setVisible(true);
	}

	/**
	 * used to resume the game
	 */
	public void resume() {
		theGame.gameFrame.getContentPane().removeAll();
	    theGame.gameFrame.getContentPane().repaint();
		theGame.gameFrame.getContentPane().add(theGame.tBoardGUI,BorderLayout.NORTH);
		theGame.gameFrame.getContentPane().add(theGame.boardGUI);
		theGame.gameFrame.getContentPane().add(theGame.bBoardGUI,BorderLayout.SOUTH);
		theGame.gameFrame.setVisible(true);
	}
}