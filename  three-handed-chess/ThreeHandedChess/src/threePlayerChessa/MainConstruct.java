package threePlayerChessa;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Vector;
import javax.swing.JFrame;

import GUI_Interface.BoardGUI;
import GUI_Interface.CallForStalemateGUI;
import GUI_Interface.MainMenuGUI;
import GUI_Interface.PauseMenuGUI;
import GUI_Interface.PlayerConfigurationMenuGUI;
import GUI_Interface.BottomBoardGUI;
import GUI_Interface.TopBoardGUI;

import threePlayerChessa.Piece.PieceType;
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
	public BottomBoardGUI bBoardGUI;
	public TopBoardGUI tBoardGUI;
	public JFrame gameFrame;
	public Controller gameController;
	public Turn player1;
	public Turn player2;	
	public Turn player3;
	
	/**
	 * 
	 */
	public MainConstruct() {
		super();
		
		Game mainGame = new Game();
		this.theGame = mainGame;		
		
		Human team1 = new Human(1,"Player 1",1,null,null);
		Human team2 = new Human(2,"Player 2",2,null,null);
		Human team3 = new Human(3,"Player 3",3,null,null);
		
		this.gameTeams.add(team1);
		this.gameTeams.add(team2);
		this.gameTeams.add(team3);
		
		Board temp = new Board(gameTeams);
		this.theBoard = temp;
		
		Vector<Piece> teamPieces1 = new Vector<Piece>();
		Vector<Piece> teamPieces2 = new Vector<Piece>();
		Vector<Piece> teamPieces3 = new Vector<Piece>();
		
		Pawn pawn11 = new Pawn(this.gameTeams.elementAt(0),"Pawn1",this.theBoard,null,PieceType.PAWN);
		Pawn pawn21 = new Pawn(this.gameTeams.elementAt(0),"Pawn2",this.theBoard,null,PieceType.PAWN);
		Pawn pawn31 = new Pawn(this.gameTeams.elementAt(0),"Pawn3",this.theBoard,null,PieceType.PAWN);
		Pawn pawn41 = new Pawn(this.gameTeams.elementAt(0),"Pawn4",this.theBoard,null,PieceType.PAWN);
		Pawn pawn51 = new Pawn(this.gameTeams.elementAt(0),"Pawn5",this.theBoard,null,PieceType.PAWN);
		Pawn pawn61 = new Pawn(this.gameTeams.elementAt(0),"Pawn6",this.theBoard,null,PieceType.PAWN);
		Pawn pawn71 = new Pawn(this.gameTeams.elementAt(0),"Pawn7",this.theBoard,null,PieceType.PAWN);
		Pawn pawn81 = new Pawn(this.gameTeams.elementAt(0),"Pawn8",this.theBoard,null,PieceType.PAWN);
		Rook rook11 = new Rook(this.gameTeams.elementAt(0),"Rook1",this.theBoard,null,PieceType.ROOK);
		Knight knight11 = new Knight(this.gameTeams.elementAt(0),"Knight1",this.theBoard,null,PieceType.KNIGHT);
		Bishop bishop11 = new Bishop(this.gameTeams.elementAt(0),"Bishop1",this.theBoard,null,PieceType.BISHOP);
		King king1 = new King(this.gameTeams.elementAt(0),"King",this.theBoard,null,PieceType.KING);
		Queen queen11 = new Queen(this.gameTeams.elementAt(0),"Queen1",this.theBoard,null,PieceType.QUEEN);
		Bishop bishop21 = new Bishop(this.gameTeams.elementAt(0),"Bishop2",this.theBoard,null,PieceType.BISHOP);
		Knight knight21 = new Knight(this.gameTeams.elementAt(0),"Knight2",this.theBoard,null,PieceType.KNIGHT);
		Rook rook21 = new Rook(this.gameTeams.elementAt(0),"Rook2",this.theBoard,null,PieceType.ROOK);
		
		teamPieces1.add(pawn11);
		teamPieces1.add(pawn21);
		teamPieces1.add(pawn31);
		teamPieces1.add(pawn41);
		teamPieces1.add(pawn51);
		teamPieces1.add(pawn61);
		teamPieces1.add(pawn71);
		teamPieces1.add(pawn81);
		teamPieces1.add(rook11);
		teamPieces1.add(knight11);
		teamPieces1.add(bishop11);
		teamPieces1.add(king1);
		teamPieces1.add(queen11);
		teamPieces1.add(bishop21);
		teamPieces1.add(knight21);
		teamPieces1.add(rook21);
		
		team1.addFullTeam(teamPieces1);
				
		Pawn pawn12 = new Pawn(this.gameTeams.elementAt(1),"Pawn1",this.theBoard,null,PieceType.PAWN);
		Pawn pawn22 = new Pawn(this.gameTeams.elementAt(1),"Pawn2",this.theBoard,null,PieceType.PAWN);
		Pawn pawn32 = new Pawn(this.gameTeams.elementAt(1),"Pawn3",this.theBoard,null,PieceType.PAWN);
		Pawn pawn42 = new Pawn(this.gameTeams.elementAt(1),"Pawn4",this.theBoard,null,PieceType.PAWN);
		Pawn pawn52 = new Pawn(this.gameTeams.elementAt(1),"Pawn5",this.theBoard,null,PieceType.PAWN);
		Pawn pawn62 = new Pawn(this.gameTeams.elementAt(1),"Pawn6",this.theBoard,null,PieceType.PAWN);
		Pawn pawn72 = new Pawn(this.gameTeams.elementAt(1),"Pawn7",this.theBoard,null,PieceType.PAWN);
		Pawn pawn82 = new Pawn(this.gameTeams.elementAt(1),"Pawn8",this.theBoard,null,PieceType.PAWN);
		Rook rook12 = new Rook(this.gameTeams.elementAt(1),"Rook1",this.theBoard,null,PieceType.ROOK);
		Knight knight12 = new Knight(this.gameTeams.elementAt(1),"Knight1",this.theBoard,null,PieceType.KNIGHT);
		Bishop bishop12 = new Bishop(this.gameTeams.elementAt(1),"Bishop1",this.theBoard,null,PieceType.BISHOP);
		King king2 = new King(this.gameTeams.elementAt(1),"King",this.theBoard,null,PieceType.KING);
		Queen queen12 = new Queen(this.gameTeams.elementAt(1),"Queen1",this.theBoard,null,PieceType.QUEEN);
		Bishop bishop22 = new Bishop(this.gameTeams.elementAt(1),"Bishop2",this.theBoard,null,PieceType.BISHOP);
		Knight knight22 = new Knight(this.gameTeams.elementAt(1),"Knight2",this.theBoard,null,PieceType.KNIGHT);
		Rook rook22 = new Rook(this.gameTeams.elementAt(1),"Rook2",this.theBoard,null,PieceType.ROOK);
		

		
		teamPieces2.add(pawn12);
		teamPieces2.add(pawn22);
		teamPieces2.add(pawn32);
		teamPieces2.add(pawn42);
		teamPieces2.add(pawn52);
		teamPieces2.add(pawn62);
		teamPieces2.add(pawn72);
		teamPieces2.add(pawn82);
		teamPieces2.add(rook12);
		teamPieces2.add(knight12);
		teamPieces2.add(bishop12);
		teamPieces2.add(king2);
		teamPieces2.add(queen12);
		teamPieces2.add(bishop22);
		teamPieces2.add(knight22);
		teamPieces2.add(rook22);
		
			
		team2.addFullTeam(teamPieces2);

		Pawn pawn13 = new Pawn(this.gameTeams.elementAt(2),"Pawn1",this.theBoard,null,PieceType.PAWN);
		Pawn pawn23 = new Pawn(this.gameTeams.elementAt(2),"Pawn2",this.theBoard,null,PieceType.PAWN);
		Pawn pawn33 = new Pawn(this.gameTeams.elementAt(2),"Pawn3",this.theBoard,null,PieceType.PAWN);
		Pawn pawn43 = new Pawn(this.gameTeams.elementAt(2),"Pawn4",this.theBoard,null,PieceType.PAWN);
		Pawn pawn53 = new Pawn(this.gameTeams.elementAt(2),"Pawn5",this.theBoard,null,PieceType.PAWN);
		Pawn pawn63 = new Pawn(this.gameTeams.elementAt(2),"Pawn6",this.theBoard,null,PieceType.PAWN);
		Pawn pawn73 = new Pawn(this.gameTeams.elementAt(2),"Pawn7",this.theBoard,null,PieceType.PAWN);
		Pawn pawn83 = new Pawn(this.gameTeams.elementAt(2),"Pawn8",this.theBoard,null,PieceType.PAWN);
		Rook rook13 = new Rook(this.gameTeams.elementAt(2),"Rook1",this.theBoard,null,PieceType.ROOK);
		Knight knight13 = new Knight(this.gameTeams.elementAt(2),"Knight1",this.theBoard,null,PieceType.KNIGHT);
		Bishop bishop13 = new Bishop(this.gameTeams.elementAt(2),"Bishop1",this.theBoard,null,PieceType.BISHOP);
		King king3 = new King(this.gameTeams.elementAt(2),"King",this.theBoard,null,PieceType.KING);
		Queen queen13 = new Queen(this.gameTeams.elementAt(2),"Queen1",this.theBoard,null,PieceType.QUEEN);
		Bishop bishop23 = new Bishop(this.gameTeams.elementAt(2),"Bishop2",this.theBoard,null,PieceType.BISHOP);
		Knight knight23 = new Knight(this.gameTeams.elementAt(2),"Knight2",this.theBoard,null,PieceType.KNIGHT);
		Rook rook23 = new Rook(this.gameTeams.elementAt(2),"Rook2",this.theBoard,null,PieceType.ROOK);
		

		
		teamPieces3.add(pawn13);
		teamPieces3.add(pawn23);
		teamPieces3.add(pawn33);
		teamPieces3.add(pawn43);
		teamPieces3.add(pawn53);
		teamPieces3.add(pawn63);
		teamPieces3.add(pawn73);
		teamPieces3.add(pawn83);
		teamPieces3.add(rook13);
		teamPieces3.add(knight13);
		teamPieces3.add(bishop13);
		teamPieces3.add(king3);
		teamPieces3.add(queen13);
		teamPieces3.add(bishop23);
		teamPieces3.add(knight23);
		teamPieces3.add(rook23);
		
		team3.addFullTeam(teamPieces3);
			
		team1.addboard(theBoard);
		team2.addboard(theBoard);
		team3.addboard(theBoard);
		
		Menu tempMenu = new Menu(this.theBoard,this.gameTeams,this.theGame);
		this.mainMenu = tempMenu;
		
		PauseMenu tempPause = new PauseMenu(this.theBoard ,this.gameTeams, this.theGame);
		this.pauseMenu = tempPause;
		
		PlayerConfigurationMenu config = new PlayerConfigurationMenu(this.theBoard, this.gameTeams,this.theGame);
		this.plyerConfig = config;
		
		CallForStalemateMenu callStale = new CallForStalemateMenu(this.theBoard, this.theGame);		
		this.stalemate = callStale;
	
		Controller aGameController = new Controller(theGame);
		gameController = aGameController;		
				
		Turn aplayer1 = new Turn(theGame,gameTeams.elementAt(0));
		Turn aplayer2 = new Turn(theGame,gameTeams.elementAt(1));
		Turn aplayer3 = new Turn(theGame,gameTeams.elementAt(2));		
		player1 = aplayer1;
		player2 = aplayer2;
		player3 = aplayer3;
		
		JFrame aGameFrame = new JFrame();		
		gameFrame = aGameFrame;
		gameFrame.setLayout(new BorderLayout(0, 0));
		
		MainMenuGUI MenuGUI = new MainMenuGUI(theGame);
		mainMenuGUI = MenuGUI;
		
		PauseMenuGUI pauseGUI = new PauseMenuGUI(theGame);
		pauseMenuGUI = pauseGUI;
		
		PlayerConfigurationMenuGUI configGUI = new PlayerConfigurationMenuGUI(theGame);
		playerConfigGUI = configGUI;
		
		CallForStalemateGUI staleGUI = new CallForStalemateGUI(theGame);
		stalemateGUI = staleGUI;
		
		Dimension boardSize = new Dimension (500,500);
		BoardGUI aBoardGUI = new BoardGUI(theGame, boardSize);
		boardGUI = aBoardGUI;
		
		BottomBoardGUI bboardGUI = new BottomBoardGUI(theGame);
		bboardGUI.setSize(600, 100);
		bBoardGUI = bboardGUI;
		
		TopBoardGUI tboardGUI = new TopBoardGUI(theGame);
		boardGUI.setSize(600, 100);
		tBoardGUI = tboardGUI;		
		
		
		
		gameFrame.add(MenuGUI);			
			
		
		theGame.setBoardGUI(boardGUI);
		theGame.setGameFrame(gameFrame);
		theGame.setMainMenuGUI(mainMenuGUI);
		theGame.setPauseMenuGUI(pauseMenuGUI);
		theGame.setPlayerConfigGUI(playerConfigGUI);
		theGame.setStalmateGUI(stalemateGUI);
		theGame.setTheBoard(theBoard);
		theGame.setGameTeams(gameTeams);
		theGame.setMainMenu(mainMenu);
		theGame.setPauseMenu(pauseMenu);
		theGame.setPlyerConfig(plyerConfig);
		theGame.setStalemate(stalemate);
		theGame.setbBoardGUI(bBoardGUI);
		theGame.settBoardGUI(tBoardGUI);
		theGame.setGameController(gameController);
		theGame.setPlayer1(player1);
		theGame.setPlayer2(player2);
		theGame.setPlayer3(player3);
		
		
		
	}
	
	public static void main(String s[])
	{
		MainConstruct maker  = new MainConstruct();
        maker.gameFrame.setSize(500,600);
		maker.gameFrame.setVisible(true);
		maker.gameFrame.setResizable(false);
	}	
}