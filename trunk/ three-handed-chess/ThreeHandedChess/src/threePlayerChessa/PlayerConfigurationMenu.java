package threePlayerChessa;

import java.util.Vector;

/**
 *The PlayerConfigurationMenu is the model portion of the menu which allows the user to 
 *configure player name, colour, computer or human, and AIDifficulty   
 *This class will be updated to allow for this
 */
public class PlayerConfigurationMenu {

	private Board theBoard; //the board of the game
	private Vector<Team> gameTeams = new Vector<Team>(); //teams playing the game
	private Game theGame; //the game its self which contains everything
	
	
	
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
	public void changePlayer0Allignment(boolean buttonPress){
		gameTeams.elementAt(0).setEvil(buttonPress);
		if(buttonPress){
			Computer temp = new Computer(gameTeams.elementAt(0).getColour(),gameTeams.elementAt(0).getName(),
					gameTeams.elementAt(0).getNumber(),theBoard, gameTeams.elementAt(0).getPieces());
			for(int x = 0; x < 16; x++){
				temp.getPieces().elementAt(x).setPlayer(temp);
			}
			gameTeams.remove(0);
			gameTeams.add(0, temp);
			theGame.getTheBoard().getSections().elementAt(0).setColour(temp);
/*			theGame.getPlayer1().setGameTeam(temp);
			theGame.getPlayer2().setOpponent1(temp);
			theGame.getPlayer3().setOpponent1(temp);*/
			
			for(int x = 0; x<3;x++)
			{
				if(x==0)
					theGame.getPlayers().elementAt(x).setGameTeam(temp);
				else
					theGame.getPlayers().elementAt(x).setOpponent1(temp);
			}
		}
		else{
			Human temp = new Human(gameTeams.elementAt(0).getColour(),gameTeams.elementAt(0).getName(),
					gameTeams.elementAt(0).getNumber(),theBoard,gameTeams.elementAt(0).getPieces());
			for(int x = 0; x < 16; x++){
				temp.getPieces().elementAt(x).setPlayer(temp);
			}
			gameTeams.remove(0);
			gameTeams.add(0, temp);	
			theGame.getTheBoard().getSections().elementAt(0).setColour(temp);
/*			theGame.getPlayer1().setGameTeam(temp);
			theGame.getPlayer2().setOpponent1(temp);
			theGame.getPlayer3().setOpponent1(temp);*/
			
			for(int x = 0; x<3;x++)
			{
				if(x==0)
					theGame.getPlayers().elementAt(x).setGameTeam(temp);
				else
					theGame.getPlayers().elementAt(x).setOpponent1(temp);
			}			
		}
	}
	
	/**
	 * used to change a human team to a computer team for player two
	 */
	public void changePlayer1Allignment(boolean buttonPress){
		if(buttonPress ){
			Computer temp = new Computer(gameTeams.elementAt(1).getColour(),gameTeams.elementAt(1).getName(),
					gameTeams.elementAt(1).getNumber(),theBoard,gameTeams.elementAt(1).getPieces());
			for(int x = 0; x < 16; x++){
				temp.getPieces().elementAt(x).setPlayer(temp);
			}
			gameTeams.remove(1);
			gameTeams.add(1, temp);
			theGame.getTheBoard().getSections().elementAt(1).setColour(temp);
/*			theGame.getPlayer1().setOpponent1(temp);
			theGame.getPlayer2().setGameTeam(temp);
			theGame.getPlayer3().setOpponent2(temp);*/
			
			for(int x = 0; x<3;x++)
			{
				if(x==1)
					theGame.getPlayers().elementAt(x).setGameTeam(temp);
				else
					theGame.getPlayers().elementAt(x).setOpponent1(temp);
			}	
		}
		else{
			Human temp = new Human(gameTeams.elementAt(1).getColour(),gameTeams.elementAt(1).getName(),
					gameTeams.elementAt(1).getNumber(),theBoard,gameTeams.elementAt(1).getPieces());
			for(int x = 0; x < 16; x++){
				temp.getPieces().elementAt(x).setPlayer(temp);
			}
			gameTeams.remove(1);
			gameTeams.add(1, temp);	
			theGame.getTheBoard().getSections().elementAt(1).setColour(temp);
/*			theGame.getPlayer1().setOpponent1(temp);
			theGame.getPlayer2().setGameTeam(temp);
			theGame.getPlayer3().setOpponent2(temp);*/
			
			for(int x = 0; x<3;x++)
			{
				if(x==1)
					theGame.getPlayers().elementAt(x).setGameTeam(temp);
				else
					theGame.getPlayers().elementAt(x).setOpponent1(temp);
			}		
		}
	}	
	
	/**
	 * used to change a human team to a computer team for player three
	 */
	public void changePlayer2Allignment(boolean buttonPress){
		if(buttonPress ){
			Computer temp = new Computer(gameTeams.elementAt(2).getColour(),gameTeams.elementAt(2).getName(),
					gameTeams.elementAt(2).getNumber(),theBoard,gameTeams.elementAt(2).getPieces());
			for(int x = 0; x < 16; x++){
				temp.getPieces().elementAt(x).setPlayer(temp);
			}
			gameTeams.remove(2);
			gameTeams.add(2, temp);
			theGame.getTheBoard().getSections().elementAt(2).setColour(temp);
/*			theGame.getPlayer1().setOpponent2(temp);
			theGame.getPlayer2().setOpponent2(temp);
			theGame.getPlayer3().setGameTeam(temp);*/
			
			for(int x = 0; x<3;x++)
			{
				if(x==2)
					theGame.getPlayers().elementAt(x).setGameTeam(temp);
				else
					theGame.getPlayers().elementAt(x).setOpponent1(temp);
			}	
		}
		else{
			Human temp = new Human(gameTeams.elementAt(2).getColour(),gameTeams.elementAt(2).getName(),
					gameTeams.elementAt(2).getNumber(),theBoard,gameTeams.elementAt(2).getPieces());
			for(int x = 0; x < 16; x++){
				temp.getPieces().elementAt(x).setPlayer(temp);
			}
			gameTeams.remove(2);
			gameTeams.add(2, temp);		
			theGame.getTheBoard().getSections().elementAt(2).setColour(temp);
/*			theGame.getPlayer1().setOpponent2(temp);
			theGame.getPlayer2().setOpponent2(temp);
			theGame.getPlayer3().setGameTeam(temp);*/
			
			for(int x = 0; x<3;x++)
			{
				if(x==2)
					theGame.getPlayers().elementAt(x).setGameTeam(temp);
				else
					theGame.getPlayers().elementAt(x).setOpponent1(temp);
			}		
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
		theGame.getGameFrame().getContentPane().removeAll();
        theGame.getGameFrame().getContentPane().repaint();
		theGame.getGameFrame().getContentPane().add(theGame.getMainMenuGUI());
		theGame.getGameFrame().setVisible(true);		
	}

}
