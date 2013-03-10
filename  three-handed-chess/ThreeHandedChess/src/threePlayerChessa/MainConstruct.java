package threePlayerChessa;

import java.util.Vector;

import GUI_Interface.BoardGUI;
import GUI_Interface.CallForStalemateGUI;
import GUI_Interface.MainMenuGUI;
import GUI_Interface.PauseMenuGUI;
import GUI_Interface.PlayerConfigurationMenuGUI;

import threePlayerChessa.Team;
import threePlayerChessa.PauseMenu;

public class MainConstruct {
	public Board theBoard;
	public Vector<Team> gameTeams = new Vector<Team>();
	public Game theGame;
	public Menu mainMenu;
	public PauseMenu pauseMenu;
	public PlayerConfigurationMenu plyerConfig;
	public CallForStalemateMenu stalemate;
	public MainMenuGUI mainMenuGUI;
	public PauseMenuGUI pauseMenuGUI;
	public PlayerConfigurationMenuGUI playerConfigGUI;
	public CallForStalemateGUI stalemateGUI;
	public BoardGUI boardGUI;
	
	
	public MainConstruct() {
		super();
		Board temp = new Board(gameTeams);
		this.theBoard = temp;
		
		Vector<Piece> teamPieces = new Vector<Piece>();
		
		Pawn pawn1 = new Pawn(this.gameTeams.elementAt(0),"Pawn1",this.theBoard,null);
		Pawn pawn2 = new Pawn(this.gameTeams.elementAt(0),"Pawn2",this.theBoard,null);
		Pawn pawn3 = new Pawn(this.gameTeams.elementAt(0),"Pawn3",this.theBoard,null);
		Pawn pawn4 = new Pawn(this.gameTeams.elementAt(0),"Pawn4",this.theBoard,null);
		Pawn pawn5 = new Pawn(this.gameTeams.elementAt(0),"Pawn5",this.theBoard,null);
		Pawn pawn6 = new Pawn(this.gameTeams.elementAt(0),"Pawn6",this.theBoard,null);
		Pawn pawn7 = new Pawn(this.gameTeams.elementAt(0),"Pawn7",this.theBoard,null);
		Pawn pawn8 = new Pawn(this.gameTeams.elementAt(0),"Pawn8",this.theBoard,null);
		Rook rook1 = new Rook(this.gameTeams.elementAt(0),"Rook1",this.theBoard,null);
		Knight knight1 = new Knight(this.gameTeams.elementAt(0),"Knight1",this.theBoard,null);
		Bishop bishop1 = new Bishop(this.gameTeams.elementAt(0),"Bishop1",this.theBoard,null);
		King king = new King(this.gameTeams.elementAt(0),"King",this.theBoard,null);
		Queen queen1 = new Queen(this.gameTeams.elementAt(0),"Queen1",this.theBoard,null);
		Bishop bishop2 = new Bishop(this.gameTeams.elementAt(0),"Bishop2",this.theBoard,null);
		Knight knight2 = new Knight(this.gameTeams.elementAt(0),"Knight2",this.theBoard,null);
		Rook rook2 = new Rook(this.gameTeams.elementAt(0),"Rook2",this.theBoard,null);
		
		teamPieces.add(pawn1);
		teamPieces.add(pawn2);
		teamPieces.add(pawn3);
		teamPieces.add(pawn4);
		teamPieces.add(pawn5);
		teamPieces.add(pawn6);
		teamPieces.add(pawn7);
		teamPieces.add(pawn8);
		teamPieces.add(rook1);
		teamPieces.add(knight1);
		teamPieces.add(bishop1);
		teamPieces.add(king);
		teamPieces.add(queen1);
		teamPieces.add(bishop2);
		teamPieces.add(knight2);
		teamPieces.add(rook2);
		
		Human team1 = new Human(1,"Player 1",1,this.theBoard,teamPieces);
		
		pawn1.setPlayer(this.gameTeams.elementAt(1));
		pawn2.setPlayer(this.gameTeams.elementAt(1));
		pawn3.setPlayer(this.gameTeams.elementAt(1));
		pawn4.setPlayer(this.gameTeams.elementAt(1));
		pawn5.setPlayer(this.gameTeams.elementAt(1));
		pawn6.setPlayer(this.gameTeams.elementAt(1));
		pawn7.setPlayer(this.gameTeams.elementAt(1));
		pawn8.setPlayer(this.gameTeams.elementAt(1));
		rook1.setPlayer(this.gameTeams.elementAt(1));
		knight1.setPlayer(this.gameTeams.elementAt(1));
		bishop1.setPlayer(this.gameTeams.elementAt(1));
		king.setPlayer(this.gameTeams.elementAt(1));
		queen1.setPlayer(this.gameTeams.elementAt(1));
		bishop2.setPlayer(this.gameTeams.elementAt(1));
		knight2.setPlayer(this.gameTeams.elementAt(1));
		rook2.setPlayer(this.gameTeams.elementAt(1));
			
		Human team2 = new Human(2,"Player 2",2,this.theBoard,teamPieces);

		pawn1.setPlayer(this.gameTeams.elementAt(1));
		pawn2.setPlayer(this.gameTeams.elementAt(1));
		pawn3.setPlayer(this.gameTeams.elementAt(1));
		pawn4.setPlayer(this.gameTeams.elementAt(1));
		pawn5.setPlayer(this.gameTeams.elementAt(1));
		pawn6.setPlayer(this.gameTeams.elementAt(1));
		pawn7.setPlayer(this.gameTeams.elementAt(1));
		pawn8.setPlayer(this.gameTeams.elementAt(1));
		rook1.setPlayer(this.gameTeams.elementAt(1));
		knight1.setPlayer(this.gameTeams.elementAt(1));
		bishop1.setPlayer(this.gameTeams.elementAt(1));
		king.setPlayer(this.gameTeams.elementAt(1));
		queen1.setPlayer(this.gameTeams.elementAt(1));
		bishop2.setPlayer(this.gameTeams.elementAt(1));
		knight2.setPlayer(this.gameTeams.elementAt(1));
		rook2.setPlayer(this.gameTeams.elementAt(1));
			
		Human team3 = new Human(3,"Player 3",3,this.theBoard,teamPieces);
		
		this.gameTeams.add(team1);
		this.gameTeams.add(team2);
		this.gameTeams.add(team3);
		
		Menu tempMenu = new Menu(this.theBoard,this.gameTeams,this.theGame);
		this.mainMenu = tempMenu;
		
		PauseMenu tempPause = new PauseMenu(this.theBoard ,this.gameTeams);
		this.pauseMenu = tempPause;
		
		PlayerConfigurationMenu config = new PlayerConfigurationMenu(this.theBoard, this.gameTeams,this.theGame);
		this.plyerConfig = config;
		
		CallForStalemateMenu callStale = new CallForStalemateMenu(this.theBoard, this.theGame);		
		this.stalemate = callStale;
		
		MainMenuGUI MenuGUI = new MainMenuGUI(theGame);
		mainMenuGUI = MenuGUI;
		
		PauseMenuGUI pauseGUI = new PauseMenuGUI(theGame);
		pauseMenuGUI = pauseGUI;
		
		PlayerConfigurationMenuGUI configGUI = new PlayerConfigurationMenuGUI(theGame);
		playerConfigGUI = configGUI;
		
		CallForStalemateGUI staleGUI = new CallForStalemateGUI(theGame);
		stalemateGUI = staleGUI;
		
		BoardGUI aBoardGUI = new BoardGUI(theGame);
		
		public BoardGUI boardGUI;
		
		
		
		Game mainGame = new Game(this.gameTeams,this.theBoard,this.mainMenu,this.pauseMenu,this.plyerConfig,this.stalemate);
		this.theGame = mainGame;		
	}
	
	
	



}