package threePlayerChessa;

import java.util.Vector;

public class PlayerConfigurationMenu {

	public Board theBoard;
	public Vector<Team> gameTeams = new Vector<Team>();
	public Game theGame;
	
	public PlayerConfigurationMenu(Board theBoard, Vector<Team> gameTeams,
			Game theGame) {
		super();
		this.theBoard = theBoard;
		this.gameTeams = gameTeams;
		this.theGame = theGame;
	}
	
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
	
	public void player0AISlider(){
		int slider = 10;
		gameTeams.elementAt(0).setAIDificulty(slider);
	}
	
	public void player1AISlider(){
		int slider = 10;
		gameTeams.elementAt(1).setAIDificulty(slider);
	}
	
	public void player2AISlider(){
		int slider = 10;
		gameTeams.elementAt(2).setAIDificulty(slider);
	}

	public void player0SetColour(){
		int aColour = 0;
		gameTeams.elementAt(0).setColour(aColour);
	}
	
	public void player1SetColour(){
		int aColour = 0;
		gameTeams.elementAt(1).setColour(aColour);
	}
	
	public void player2SetColour(){
		int aColour = 0;
		gameTeams.elementAt(2).setColour(aColour);
	}
	
	public void player0SetName(String aName) {
		gameTeams.elementAt(0).setName(aName);
	}
	
	public void player1SetName(String aName) {
		gameTeams.elementAt(1).setName(aName);
	}
	
	public void player2SetName(String aName) {
		gameTeams.elementAt(2).setName(aName);
	}
		
	public void close(){
		theGame.gameFrame.getContentPane().removeAll();
        theGame.gameFrame.getContentPane().repaint();
		theGame.gameFrame.getContentPane().add(theGame.mainMenuGUI);
		theGame.gameFrame.setVisible(true);		
	}

}
