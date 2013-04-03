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
		theGame.getGameController().setInProgress(false);
		theGame.startGame();
	}

	/**
	 * used to end the game
	 */
	public void endGame() {
		theBoard.reset();
		theGame.getGameFrame().getContentPane().removeAll();
	    theGame.getGameFrame().getContentPane().repaint();
		theGame.getGameFrame().getContentPane().add(theGame.getMainMenuGUI());
		theGame.getGameFrame().setVisible(true);
		theGame.getGameController().setInProgress(false);
	}

	/**
	 * used to enter the stalemate menu 
	 */
	public void callForStalemate() {
		theGame.getGameFrame().getContentPane().removeAll();
	    theGame.getGameFrame().getContentPane().repaint();
		theGame.getGameFrame().getContentPane().add(theGame.getStalemateGUI());
		theGame.getGameFrame().setVisible(true);
	}

	/**
	 * used to resume the game
	 */
	public void resume() {
		theGame.getGameFrame().getContentPane().removeAll();
	    theGame.getGameFrame().getContentPane().repaint();
		theGame.getGameFrame().getContentPane().add(theGame.gettBoardGUI(),BorderLayout.NORTH);
		theGame.getGameFrame().getContentPane().add(theGame.getBoardGUI());
		theGame.getGameFrame().getContentPane().add(theGame.getbBoardGUI(),BorderLayout.SOUTH);
		theGame.getGameFrame().setVisible(true);
	}
}