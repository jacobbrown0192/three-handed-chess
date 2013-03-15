package threePlayerChessa;

import java.util.Vector;

/**
 *The PlayerConfigurationMenu is the model portion of the menu which allows the user to 
 *configure player name, colour, computer or human, and AIDifficulty   
 *This class will be updated to allow for this
 */
public class PlayerConfigurationMenu {

	public Board theBoard; //the board of the game
	public Vector<Team> gameTeams = new Vector<Team>(); //teams playing the game
	public Game theGame; //the game its self which contains everything
	
	
	
	/**
	 * PlayerConfigurationMenu constructor
	 * @param theBoard - the board which the game is played on
	 * @param gameTeams - the players in the game
	 * @param theGame - the game its self which contains everything
	 */
	public PlayerConfigurationMenu(Board theBoard, Vector<Team> gameTeams,
			Game theGame) {
		super();
		this.theBoard = theBoard;
		this.gameTeams = gameTeams;
		this.theGame = theGame;
	}
	
	/**
	 * used to change a human team to a computer team for player one
	 */
	public void changePlayer0Allignment(){
		boolean buttonPress = true;
		gameTeams.elementAt(0).setEvil(buttonPress);
		if(buttonPress){
			Computer temp = new Computer(gameTeams.elementAt(0).getColour(),gameTeams.elementAt(0).getName(),
					gameTeams.elementAt(0).getNumber(),gameTeams.elementAt(0).theBoard, gameTeams.elementAt(0).pieces);
			gameTeams.remove(0);
			gameTeams.add(0, temp);
		}
		else{
			Human temp = new Human(gameTeams.elementAt(0).getColour(),gameTeams.elementAt(0).getName(),
					gameTeams.elementAt(0).getNumber(),gameTeams.elementAt(0).theBoard,gameTeams.elementAt(0).pieces);
			gameTeams.remove(0);
			gameTeams.add(0, temp);				
		}
	}
	
	/**
	 * used to change a human team to a computer team for player two
	 */
	public void changePlayer1Allignment(){
		boolean buttonPress = true;
		if(buttonPress ){
			Computer temp = new Computer(gameTeams.elementAt(1).getColour(),gameTeams.elementAt(1).getName(),
					gameTeams.elementAt(1).getNumber(),gameTeams.elementAt(1).theBoard,gameTeams.elementAt(1).pieces);
			gameTeams.remove(1);
			gameTeams.add(1, temp);
		}
		else{
			Human temp = new Human(gameTeams.elementAt(1).getColour(),gameTeams.elementAt(1).getName(),
					gameTeams.elementAt(1).getNumber(),gameTeams.elementAt(1).theBoard,gameTeams.elementAt(1).pieces);
			gameTeams.remove(1);
			gameTeams.add(1, temp);				
		}
	}	
	
	/**
	 * used to change a human team to a computer team for player three
	 */
	public void changePlayer2Allignment(){
		boolean buttonPress = true;
		if(buttonPress ){
			Computer temp = new Computer(gameTeams.elementAt(2).getColour(),gameTeams.elementAt(2).getName(),
					gameTeams.elementAt(2).getNumber(),gameTeams.elementAt(2).theBoard,gameTeams.elementAt(2).pieces);
			gameTeams.remove(2);
			gameTeams.add(2, temp);
		}
		else{
			Human temp = new Human(gameTeams.elementAt(2).getColour(),gameTeams.elementAt(2).getName(),
					gameTeams.elementAt(2).getNumber(),gameTeams.elementAt(2).theBoard,gameTeams.elementAt(2).pieces);
			gameTeams.remove(2);
			gameTeams.add(2, temp);				
		}
	}
	
	/**
	 * used to change the difficulty of a computer team for player one if player one is a computer team
	 */
	public void player0AISlider(){
		int slider = 10;
		gameTeams.elementAt(0).setAIDifficulty(slider);
	}
	
	/**
	 * used to change the difficulty of a computer team for player two if player two is a computer team
	 */
	public void player1AISlider(){
		int slider = 10;
		gameTeams.elementAt(1).setAIDifficulty(slider);
	}
	
	/**
	 * used to change the difficulty of a computer team for player three if player three is a computer team
	 */
	public void player2AISlider(){
		int slider = 10;
		gameTeams.elementAt(2).setAIDifficulty(slider);
	}

	/**
	 * used to change the colour of team pieces for player one
	 */
	public void player0SetColour(){
		int aColour = 0;
		gameTeams.elementAt(0).setColour(aColour);
	}
	
	/**
	 * used to change the colour of team pieces for player two
	 */
	public void player1SetColour(){
		int aColour = 0;
		gameTeams.elementAt(1).setColour(aColour);
	}
	
	/**
	 * used to change the colour of team pieces for player three
	 */
	public void player2SetColour(){
		int aColour = 0;
		gameTeams.elementAt(2).setColour(aColour);
	}
	
	/**
	 * used to change the name of player one
	 */
	public void player0SetName(String aName) {
		gameTeams.elementAt(0).setName(aName);
	}
	
	/**
	 * used to change the name of player two
	 */
	public void player1SetName(String aName) {
		gameTeams.elementAt(1).setName(aName);
	}
	
	/**
	 * used to change the name of player three
	 */
	public void player2SetName(String aName) {
		gameTeams.elementAt(2).setName(aName);
	}
		
	/**
	 * used to return to the main menu
	 */
	public void close(){
		theGame.gameFrame.getContentPane().removeAll();
        theGame.gameFrame.getContentPane().repaint();
		theGame.gameFrame.getContentPane().add(theGame.mainMenuGUI);
		theGame.gameFrame.setVisible(true);		
	}

}
