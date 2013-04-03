package threePlayerChessa;


import java.util.Vector;


/**
 *The Menu is the model portion of the menu which allows the user to 
 *close the game, start the game, or enter the configuration menu
 */
public class Menu {
	public Board theBoard; //the board of the game
	public Vector<Team> gameTeams = new Vector<Team>(); //teams playing the game
	public Game theGame; //the game its self which contains everything

	/**
	 * Menu constructor
	 * @param theBoard - the board which the game is played on
	 * @param gameTeams - the players in the game
	 * @param theGame - the game its self which contains everything
	 */
	public Menu(Board theBoard, Vector<Team> gameTeams, Game theGame) {
		super();
		this.theBoard = theBoard;
		this.gameTeams = gameTeams;
		this.theGame = theGame;
	}
	
	
	/**
	 * used to enter the player configuration menu
	 */
	public void playerConfig() {
		theGame.getGameFrame().getContentPane().removeAll();
	    theGame.getGameFrame().getContentPane().repaint();
		theGame.getGameFrame().getContentPane().add(theGame.getPlayerConfigGUI());
		theGame.getGameFrame().setVisible(true);
	}

	/**
	 * used to start the game from the Game class
	 */
	public void Start() {
		theGame.startGame();
	}
	
	/**
	 * used to close the program
	 */
	public void Close() {
		System.exit(0);
	}
}