package threePlayerChessa;

import java.util.Vector;

import GUI_Interface.*;

public class Game {
	public Vector<Team> gameTeams = new Vector<Team>();
	Board theBoard;
	public Menu mainMenu;
	public PauseMenu pauseMenu;
	public PlayerConfigurationMenu plyerConfig;
	public CallForStalemateMenu stalemate;
	public MainMenuGUI mainMenuGUI;
	public PauseMenuGUI pauseMenuGUI;
	public PlayerConfigurationMenuGUI playerConfigGUI;
	public CallForStalemateGUI stalmateGUI;
	public BoardGUI boardGUI;
	



	public Game(Vector<Team> gameTeams, Board theBoard, Menu mainMenu,
			PauseMenu pauseMenu, PlayerConfigurationMenu plyerConfig,
			CallForStalemateMenu stalemate, MainMenuGUI mainMenuGUI,
			PauseMenuGUI pauseMenuGUI, PlayerConfigurationMenuGUI playerConfigGUI,
			CallForStalemateGUI stalmateGUI, BoardGUI boardGUI) {
		super();
		this.gameTeams = gameTeams;
		this.theBoard = theBoard;
		this.mainMenu = mainMenu;
		this.pauseMenu = pauseMenu;
		this.plyerConfig = plyerConfig;
		this.stalemate = stalemate;
		this.mainMenuGUI = mainMenuGUI;
		this.pauseMenuGUI = pauseMenuGUI;
		this.playerConfigGUI = playerConfigGUI;
		this.stalmateGUI = stalmateGUI;
		this.boardGUI = boardGUI;
	}

	
	public void startGame(){
		
	}

	
}
