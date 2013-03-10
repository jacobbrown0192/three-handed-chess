package threePlayerChessa;


import java.util.Vector;


//not sure if game is necessary here.
public class Menu {
	public Board theBoard;
	public Vector<Team> gameTeams = new Vector<Team>();
	public Game theGame;

	
	public Menu(Board theBoard, Vector<Team> gameTeams, Game theGame) {
		super();
		this.theBoard = theBoard;
		this.gameTeams = gameTeams;
		this.theGame = theGame;
	}
	
	public void playerConfig() {
		//open PlayerConfigurationMenu
	}


	public void Start() {
		theGame.startGame();
	}

	public void Close() {
		System.exit(0);
	}
}