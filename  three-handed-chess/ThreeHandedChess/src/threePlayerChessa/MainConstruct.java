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

/**  
 *The MainConstruct class is used to either directly or indirectly construct everything to be used in the game
 */
public class MainConstruct {
	private Board theBoard; //the board of the game
	private Vector<Team> gameTeams = new Vector<Team>(); //teams playing the game
	private Game theGame; //the game its self which contains everything
	private Menu mainMenu; //the model of main menu 
	private PauseMenu pauseMenu; //the model of the pause menu 
	private PlayerConfigurationMenu plyerConfig; //the model of the player configuration menu 
	private CallForStalemateMenu stalemate; //the model of the call for stalemate menu 
	private MainMenuGUI mainMenuGUI; //the GUI of the main menu 
	private PauseMenuGUI pauseMenuGUI; //the GUI of the pause menu 
	private PlayerConfigurationMenuGUI playerConfigGUI; //the GUI of the player configuration menu 
	private CallForStalemateGUI stalemateGUI; //the GUI of the call for stalemate menu 
	private BoardGUI boardGUI;  //the GUI of the board 
	private BottomBoardGUI bBoardGUI;  //the GUI of the bottom panel of the board 
	private TopBoardGUI tBoardGUI; //the GUI of the top panel of the board 
	private JFrame gameFrame; //the frame which all panels are put 
	private Controller gameController; //the game controller
	private Turn player1; //the player one's thread
	private Turn player2; //the player two's thread
	private Turn player3; //the player three's thread
	
	/**
	 * MainConstruct constructor
	 */
	public MainConstruct() {
		super();
		
		//game construction
		Game mainGame = new Game();
		this.theGame = mainGame;		
		
		//team construction
		Human team1 = new Human(1,"Player 1",1,null,null);
		Human team2 = new Human(2,"Player 2",2,null,null);
		Human team3 = new Human(3,"Player 3",3,null,null);
		
		this.gameTeams.add(team1);
		this.gameTeams.add(team2);
		this.gameTeams.add(team3);
		
		//board being constructed
		Board temp = new Board(gameTeams);
		this.theBoard = temp;
		
		//adding pieces to teams
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
		teamPieces1.add(queen11);
		teamPieces1.add(king1);
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
		teamPieces2.add(queen12);
		teamPieces2.add(king2);
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
		teamPieces3.add(queen13);
		teamPieces3.add(king3);
		teamPieces3.add(bishop23);
		teamPieces3.add(knight23);
		teamPieces3.add(rook23);
		
		team3.addFullTeam(teamPieces3);
			
		team1.addboard(theBoard);
		team2.addboard(theBoard);
		team3.addboard(theBoard);
		
		//main menu construction
		Menu tempMenu = new Menu(this.theBoard,this.gameTeams,this.theGame);
		this.mainMenu = tempMenu;
		
		//pause menu construction
		PauseMenu tempPause = new PauseMenu(this.theBoard ,this.gameTeams, this.theGame);
		this.pauseMenu = tempPause;
		
		//palyer configuration menu construction
		PlayerConfigurationMenu config = new PlayerConfigurationMenu(this.theBoard, this.gameTeams,this.theGame);
		this.plyerConfig = config;
		
		//call for stalemate menu construction
		CallForStalemateMenu callStale = new CallForStalemateMenu(this.theBoard, this.theGame);		
		this.stalemate = callStale;
	
		//controller construction
		Controller aGameController = new Controller(theGame);
		gameController = aGameController;		
				
		//player thread construction
		Turn aplayer1 = new Turn(theGame, this.gameTeams.elementAt(0), this.gameTeams.elementAt(1), this.gameTeams.elementAt(2));
		Turn aplayer2 = new Turn(theGame, this.gameTeams.elementAt(1), this.gameTeams.elementAt(0), this.gameTeams.elementAt(2));
		Turn aplayer3 = new Turn(theGame, this.gameTeams.elementAt(2), this.gameTeams.elementAt(0), this.gameTeams.elementAt(1));		
		player1 = aplayer1;
		player2 = aplayer2;
		player3 = aplayer3;
		
		//frame construction
		JFrame aGameFrame = new JFrame();		
		gameFrame = aGameFrame;
		gameFrame.setLayout(new BorderLayout(0, 0));
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//GUI construction
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
		
		
		//adding menuGUI to frame
		gameFrame.add(MenuGUI);			
			
		//add everything to a game
		theGame.setBoardGUI(boardGUI);
		theGame.setGameFrame(gameFrame);
		theGame.setMainMenuGUI(mainMenuGUI);
		theGame.setPauseMenuGUI(pauseMenuGUI);
		theGame.setPlayerConfigGUI(playerConfigGUI);
		theGame.setStalemateGUI(stalemateGUI);
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
	
	//makes the game frame and makes the main menu visible
	public static void main(String s[])
	{
		MainConstruct maker  = new MainConstruct();
        maker.gameFrame.setSize(500,600);
		maker.gameFrame.setVisible(true);
		maker.gameFrame.setResizable(false);
	}	
}