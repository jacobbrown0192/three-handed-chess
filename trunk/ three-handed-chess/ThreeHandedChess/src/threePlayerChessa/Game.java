package threePlayerChessa;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;

import GUI_Interface.*;

public class Game {
	public Vector<Team> gameTeams = new Vector<Team>();
	public Board theBoard;
	public Menu mainMenu;
	public PauseMenu pauseMenu;
	public PlayerConfigurationMenu plyerConfig;
	public CallForStalemateMenu stalemate;
	public MainMenuGUI mainMenuGUI;
	public PauseMenuGUI pauseMenuGUI;
	public PlayerConfigurationMenuGUI playerConfigGUI;
	public CallForStalemateGUI stalmateGUI;
	public BoardGUI boardGUI;
	public BottomBoardGUI bBoardGUI;
	public TopBoardGUI tBoardGUI;
	public JFrame gameFrame;
	public Controller gameController;
	public Click click1;
	public Click click2;
	public Turn player1;
	public Turn player2;	
	public Turn player3;

	
	public Game() {

	}
	

	public MainMenuGUI getMainMenuGUI() {
		return mainMenuGUI;
	}
	public void setMainMenuGUI(MainMenuGUI mainMenuGUI) {
		this.mainMenuGUI = mainMenuGUI;
	}

	public PauseMenuGUI getPauseMenuGUI() {
		return pauseMenuGUI;
	}
	public void setPauseMenuGUI(PauseMenuGUI pauseMenuGUI) {
		this.pauseMenuGUI = pauseMenuGUI;
	}

	public PlayerConfigurationMenuGUI getPlayerConfigGUI() {
		return playerConfigGUI;
	}
	public void setPlayerConfigGUI(PlayerConfigurationMenuGUI playerConfigGUI) {
		this.playerConfigGUI = playerConfigGUI;
	}

	public CallForStalemateGUI getStalmateGUI() {
		return stalmateGUI;
	}
	public void setStalmateGUI(CallForStalemateGUI stalmateGUI) {
		this.stalmateGUI = stalmateGUI;
	}

	public BoardGUI getBoardGUI() {
		return boardGUI;
	}
	public void setBoardGUI(BoardGUI boardGUI) {
		this.boardGUI = boardGUI;
	}
	
	public JFrame getGameFrame() {
		return gameFrame;
	}
	public void setGameFrame(JFrame gameFrame) {
		this.gameFrame = gameFrame;
	}
	
	public Vector<Team> getGameTeams() {
		return gameTeams;
	}
	public void setGameTeams(Vector<Team> gameTeams) {
		this.gameTeams = gameTeams;
	}

	public Board getTheBoard() {
		return theBoard;
	}
	public void setTheBoard(Board theBoard) {
		this.theBoard = theBoard;
	}

	public Menu getMainMenu() {
		return mainMenu;
	}
	public void setMainMenu(Menu mainMenu) {
		this.mainMenu = mainMenu;
	}

	public PauseMenu getPauseMenu() {
		return pauseMenu;
	}
	public void setPauseMenu(PauseMenu pauseMenu) {
		this.pauseMenu = pauseMenu;
	}

	public PlayerConfigurationMenu getPlyerConfig() {
		return plyerConfig;
	}
	public void setPlyerConfig(PlayerConfigurationMenu plyerConfig) {
		this.plyerConfig = plyerConfig;
	}

	public CallForStalemateMenu getStalemate() {
		return stalemate;
	}
	public void setStalemate(CallForStalemateMenu stalemate) {
		this.stalemate = stalemate;
	}
	
	public BottomBoardGUI getbBoardGUI() {
		return bBoardGUI;
	}
	public void setbBoardGUI(BottomBoardGUI bBoardGUI) {
		this.bBoardGUI = bBoardGUI;
	}

	public TopBoardGUI gettBoardGUI() {
		return tBoardGUI;
	}
	public void settBoardGUI(TopBoardGUI tBoardGUI) {
		this.tBoardGUI = tBoardGUI;
	}

	public Controller getGameController() {
		return gameController;
	}
	public void setGameController(Controller gameController) {
		this.gameController = gameController;
	}

	public Turn getPlayer1() {
		return player1;
	}
	public void setPlayer1(Turn player1) {
		this.player1 = player1;
	}

	public Turn getPlayer2() {
		return player2;
	}
	public void setPlayer2(Turn player2) {
		this.player2 = player2;
	}

	public Turn getPlayer3() {
		return player3;
	}
	public void setPlayer3(Turn player3) {
		this.player3 = player3;
	}
	
	public synchronized void getClick(Click aClick){
		if(click1 == null)
		{
			click1 = aClick;
		}
		else{
			click2 = aClick;
		}
		notifyAll();
		synchronized (player1){
			player1.notify();
		}
		synchronized (player2){
			player2.notify();
		}
		synchronized (player3){
			player3.notify();
		}
	}


	public void startGame(){
		gameFrame.getContentPane().removeAll();
	    gameFrame.getContentPane().repaint();
		gameFrame.getContentPane().add(tBoardGUI,BorderLayout.NORTH);
		gameFrame.getContentPane().add(boardGUI);
		gameFrame.getContentPane().add(bBoardGUI,BorderLayout.SOUTH);
		
		theBoard.reset();
		gameTeams.elementAt(0).addPiecesToBoard();
		gameTeams.elementAt(1).addPiecesToBoard();
		gameTeams.elementAt(2).addPiecesToBoard();
		boardGUI.setTileIcons();
		gameFrame.setVisible(true);
		gameController.setInProgress(true);
		gameController.turnCount = 0;
		click1 = null;
		click2 = null;		
		
		
		if(!player1.isAlive())
			player1.start();
		if(!player2.isAlive())
			player2.start();
		if(!player3.isAlive())
			player3.start();	
			
		boardGUI.setTileIcons();
	}
}
	
	/*public void playgame(){
		boolean check = false;
		
		while( gameController.isInProgress() == true){
			boolean validClick = false;

			check =  gameController.inCheck();
			if (check){
				//check for checkamte
			}
			Tile select1 = null;
			Tile select2 = null;
			if((( gameController.turnCount%3) + 1) == gameTeams.elementAt(0).getNumber()){
				if( click1 != null){
					
					for(int i =0; i < 3; i++){
						for(int j =0; j<2;j++){
							for(int k=0; k<16;k++){
								if( theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getLetter() ==  click1.getLet() &&
									 theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getNumber() ==  click1.getNum()){
									select1 =  theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k);
								}
							}
						}
					}
					
					if(select1.getPiece() != null){					
						if( select1.getPiece().player == gameTeams.elementAt(0)){
							validClick = true;
						}
						else
						{
							
						}
					}
					else
					{
						 click1 = null;
					}
					
					
					//check valid click
					if(validClick){
						validClick = false;
						if( click2 != null){
							
							for(int i =0; i < 3; i++){
								for(int j =0; j<2;j++){
									for(int k=0; k<16;k++){
										if( theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getLetter() ==  click2.getLet() &&
											 theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getNumber() ==  click2.getNum()){
											select2 =  theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k);
										}
									}
								}
							}
					
							
							if( select2.getPiece() == null){
								validClick = true;
							}
							else{
								if(select2.getPiece().player != gameTeams.elementAt(0))
									validClick = true;
								else{
								 click1 =  click2;
								 click2 = null;
								}
							}
								
							
							if( click1 ==  click2){
								 click1 = null;
								 click2 = null;
							}
							

							if(validClick){
								select1.getPiece().move(select1, select2,player1);								
							}							
						}
					}
					
				}
		
			}
			if((( gameController.turnCount%3) + 1) == gameTeams.elementAt(1).getNumber()){
				if( click1 != null){
					
					for(int i =0; i < 3; i++){
						for(int j =0; j<2;j++){
							for(int k=0; k<16;k++){
								if( theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getLetter() ==  click1.getLet() &&
									 theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getNumber() ==  click1.getNum()){
									select1 =  theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k);
								}
							}
						}
					}
					
					if(select1.getPiece() != null){					
						if( select1.getPiece().player == gameTeams.elementAt(1)){
							validClick = true;
						}
						else
						{
							
						}
					}
					else
					{
						 click1 = null;
					}
					
					
					//check valid click
					if(validClick){
						validClick = false;
						if( click2 != null){
							
							for(int i =0; i < 3; i++){
								for(int j =0; j<2;j++){
									for(int k=0; k<16;k++){
										if( theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getLetter() ==  click2.getLet() &&
											 theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getNumber() ==  click2.getNum()){
											select2 =  theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k);
										}
									}
								}
							}
					
							
							if( select2.getPiece() == null){
								validClick = true;
							}
							else{
								if(select2.getPiece().player != gameTeams.elementAt(1))
									validClick = true;
								else{
								 click1 =  click2;
								 click2 = null;
								}
							}
								
							
							if( click1 ==  click2){
								 click1 = null;
								 click2 = null;
							}
							

							if(validClick){
								select1.getPiece().move(select1, select2,player1);								
							}							
						}
					}
					
				}
		
			}
			if((( gameController.turnCount%3) + 1) == gameTeams.elementAt(2).getNumber()){
				if( click1 != null){
					
					for(int i =0; i < 3; i++){
						for(int j =0; j<2;j++){
							for(int k=0; k<16;k++){
								if( theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getLetter() ==  click1.getLet() &&
									 theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getNumber() ==  click1.getNum()){
									select1 =  theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k);
								}
							}
						}
					}
					
					if(select1.getPiece() != null){					
						if( select1.getPiece().player == gameTeams.elementAt(2)){
							validClick = true;
						}
						else
						{
							
						}
					}
					else
					{
						 click1 = null;
					}
					
					
					//check valid click
					if(validClick){
						validClick = false;
						if( click2 != null){
							
							for(int i =0; i < 3; i++){
								for(int j =0; j<2;j++){
									for(int k=0; k<16;k++){
										if( theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getLetter() ==  click2.getLet() &&
											 theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getNumber() ==  click2.getNum()){
											select2 =  theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k);
										}
									}
								}
							}
					
							
							if( select2.getPiece() == null){
								validClick = true;
							}
							else{
								if(select2.getPiece().player != gameTeams.elementAt(2))
									validClick = true;
								else{
								 click1 =  click2;
								 click2 = null;
								}
							}
								
							
							if( click1 ==  click2){
								 click1 = null;
								 click2 = null;
							}
							

							if(validClick){
								select1.getPiece().move(select1, select2,player1);								
							}							
						}
					}
					
				}
		
			}

		}	
	}
}
*/