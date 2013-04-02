package threePlayerChessa;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;

import GUI_Interface.*;

/**  
 *The Game class is the class which contains everything used in the game
 */
public class Game {
	public Vector<Team> gameTeams = new Vector<Team>(); //teams playing the game
	public Board theBoard; //the board of the game
	public Menu mainMenu; //the model of main menu 
	public PauseMenu pauseMenu; //the model of the pause menu 
	public PlayerConfigurationMenu plyerConfig; //the model of the player configuration menu 
	public CallForStalemateMenu stalemate; //the model of the call for stalemate menu 
	public MainMenuGUI mainMenuGUI; //the GUI of the main menu 
	public PauseMenuGUI pauseMenuGUI; //the GUI of the pause menu 
	public PlayerConfigurationMenuGUI playerConfigGUI; //the GUI of the player configuration menu 
	public CallForStalemateGUI stalemateGUI; //the GUI of the call for stalemate menu 
	public BoardGUI boardGUI;  //the GUI of the board 
	public BottomBoardGUI bBoardGUI;  //the GUI of the bottom panel of the board 
	public TopBoardGUI tBoardGUI; //the GUI of the top panel of the board 
	public JFrame gameFrame; //the frame which all panels are put 
	public Controller gameController; //the game controller
	public Click click1; //the first click
	public Click click2; //the second click
	public Turn player1; //the player one's thread
	public Turn player2; //the player two's thread
	public Turn player3; //the player three's thread

	
	public Game() {

	}
	


	
	/**
	 * @return the gameTeams
	 */
	public Vector<Team> getGameTeams() {
		return gameTeams;
	}




	/**
	 * @param gameTeams - used to set gameTeams
	 */
	public void setGameTeams(Vector<Team> gameTeams) {
		this.gameTeams = gameTeams;
	}




	/**
	 * @return the theBoard
	 */
	public Board getTheBoard() {
		return theBoard;
	}




	/**
	 * @param theBoard - used to set theBoard
	 */
	public void setTheBoard(Board theBoard) {
		this.theBoard = theBoard;
	}




	/**
	 * @return the mainMenu
	 */
	public Menu getMainMenu() {
		return mainMenu;
	}




	/**
	 * @param mainMenu - used to set mainMenu
	 */
	public void setMainMenu(Menu mainMenu) {
		this.mainMenu = mainMenu;
	}




	/**
	 * @return the pauseMenu
	 */
	public PauseMenu getPauseMenu() {
		return pauseMenu;
	}




	/**
	 * @param pauseMenu - used to set pauseMenu
	 */
	public void setPauseMenu(PauseMenu pauseMenu) {
		this.pauseMenu = pauseMenu;
	}




	/**
	 * @return the plyerConfig
	 */
	public PlayerConfigurationMenu getPlyerConfig() {
		return plyerConfig;
	}




	/**
	 * @param plyerConfig - used to set plyerConfig
	 */
	public void setPlyerConfig(PlayerConfigurationMenu plyerConfig) {
		this.plyerConfig = plyerConfig;
	}




	/**
	 * @return the stalemate
	 */
	public CallForStalemateMenu getStalemate() {
		return stalemate;
	}




	/**
	 * @param stalemate - used to set stalemate
	 */
	public void setStalemate(CallForStalemateMenu stalemate) {
		this.stalemate = stalemate;
	}




	/**
	 * @return the mainMenuGUI
	 */
	public MainMenuGUI getMainMenuGUI() {
		return mainMenuGUI;
	}




	/**
	 * @param mainMenuGUI - used to set mainMenuGUI
	 */
	public void setMainMenuGUI(MainMenuGUI mainMenuGUI) {
		this.mainMenuGUI = mainMenuGUI;
	}




	/**
	 * @return the pauseMenuGUI
	 */
	public PauseMenuGUI getPauseMenuGUI() {
		return pauseMenuGUI;
	}




	/**
	 * @param pauseMenuGUI - used to set pauseMenuGUI
	 */
	public void setPauseMenuGUI(PauseMenuGUI pauseMenuGUI) {
		this.pauseMenuGUI = pauseMenuGUI;
	}




	/**
	 * @return the playerConfigGUI
	 */
	public PlayerConfigurationMenuGUI getPlayerConfigGUI() {
		return playerConfigGUI;
	}




	/**
	 * @param playerConfigGUI - used to set playerConfigGUI
	 */
	public void setPlayerConfigGUI(PlayerConfigurationMenuGUI playerConfigGUI) {
		this.playerConfigGUI = playerConfigGUI;
	}




	/**
	 * @return the stalemateGUI
	 */
	public CallForStalemateGUI getStalemateGUI() {
		return stalemateGUI;
	}




	/**
	 * @param stalemateGUI - used to set stalemateGUI
	 */
	public void setStalemateGUI(CallForStalemateGUI stalemateGUI) {
		this.stalemateGUI = stalemateGUI;
	}




	/**
	 * @return the boardGUI
	 */
	public BoardGUI getBoardGUI() {
		return boardGUI;
	}




	/**
	 * @param boardGUI - used to set boardGUI
	 */
	public void setBoardGUI(BoardGUI boardGUI) {
		this.boardGUI = boardGUI;
	}




	/**
	 * @return the bBoardGUI
	 */
	public BottomBoardGUI getbBoardGUI() {
		return bBoardGUI;
	}




	/**
	 * @param bBoardGUI - used to set bBoardGUI
	 */
	public void setbBoardGUI(BottomBoardGUI bBoardGUI) {
		this.bBoardGUI = bBoardGUI;
	}




	/**
	 * @return the tBoardGUI
	 */
	public TopBoardGUI gettBoardGUI() {
		return tBoardGUI;
	}




	/**
	 * @param tBoardGUI - used to set tBoardGUI
	 */
	public void settBoardGUI(TopBoardGUI tBoardGUI) {
		this.tBoardGUI = tBoardGUI;
	}




	/**
	 * @return the gameFrame
	 */
	public JFrame getGameFrame() {
		return gameFrame;
	}




	/**
	 * @param gameFrame - used to set gameFrame
	 */
	public void setGameFrame(JFrame gameFrame) {
		this.gameFrame = gameFrame;
	}




	/**
	 * @return the gameController
	 */
	public Controller getGameController() {
		return gameController;
	}




	/**
	 * @param gameController - used to set gameController
	 */
	public void setGameController(Controller gameController) {
		this.gameController = gameController;
	}




	/**
	 * @return the click1
	 */
	public Click getClick1() {
		return click1;
	}




	/**
	 * @param click1 - used to set click1
	 */
	public void setClick1(Click click1) {
		this.click1 = click1;
	}




	/**
	 * @return the click2
	 */
	public Click getClick2() {
		return click2;
	}




	/**
	 * @param click2 - used to set click2
	 */
	public void setClick2(Click click2) {
		this.click2 = click2;
	}




	/**
	 * @return the player1
	 */
	public Turn getPlayer1() {
		return player1;
	}




	/**
	 * @param player1 - used to set player1
	 */
	public void setPlayer1(Turn player1) {
		this.player1 = player1;
	}




	/**
	 * @return the player2
	 */
	public Turn getPlayer2() {
		return player2;
	}




	/**
	 * @param player2 - used to set player2
	 */
	public void setPlayer2(Turn player2) {
		this.player2 = player2;
	}




	/**
	 * @return the player3
	 */
	public Turn getPlayer3() {
		return player3;
	}




	/**
	 * @param player3 - used to set player3
	 */
	public void setPlayer3(Turn player3) {
		this.player3 = player3;
	}



	/**
	 * used to set the in coming the clicks to the game
	 * @param aClick - used to set the click
	 */
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

	/**
	 * starts the game by clearing and adding pieces to the board
	 */
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
		
		gameTeams.elementAt(0).setCheckMate(false);
		gameTeams.elementAt(1).setCheckMate(false);
		gameTeams.elementAt(2).setCheckMate(false);
		
		//starts the player threads
		if(!player1.isAlive())
			player1.start();
		if(!player2.isAlive())
			player2.start();
		if(!player3.isAlive())
			player3.start();	
			

	}
}