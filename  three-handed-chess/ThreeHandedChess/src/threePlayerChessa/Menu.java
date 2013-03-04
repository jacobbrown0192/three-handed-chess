package threePlayerChessa;

import java.util.Vector;
import threePlayerChessa.Computer;

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

	public void setName(Team aPlayer, String aName) {
		aPlayer.setName(aName);
	}

	public String getName(Team aPlayer) {
		return aPlayer.getName();
	}
	
	
	public void setColour(Team aPlayer, int aColour) {
		aPlayer.setColour(aColour);
	}

	public int getColour(Team aPlayer){
		return aPlayer.getColour();
	}
	
	public void playerConfig() {
		boolean buttonPress = false;
		int slider = 10;
		if(true/*action event*/){
			gameTeams.elementAt(0).setEvil(buttonPress);
			if(buttonPress){
				Computer temp = new Computer(gameTeams.elementAt(0).getColour(),gameTeams.elementAt(0).getName(),gameTeams.elementAt(0).getNumber(),gameTeams.elementAt(0).pieces,gameTeams.elementAt(0).theBoard);
				gameTeams.remove(0);
				gameTeams.add(0, temp);
			}
			else{
				Human temp = new Human(gameTeams.elementAt(0).getColour(),gameTeams.elementAt(0).getName(),gameTeams.elementAt(0).getNumber(),gameTeams.elementAt(0).pieces,gameTeams.elementAt(0).theBoard);
				gameTeams.remove(0);
				gameTeams.add(0, temp);				
			}
		}
		if(true/*action event*/){
			gameTeams.elementAt(1).setEvil(buttonPress);
			if(buttonPress){
				Computer temp = new Computer(gameTeams.elementAt(1).getColour(),gameTeams.elementAt(1).getName(),gameTeams.elementAt(1).getNumber(),gameTeams.elementAt(1).pieces,gameTeams.elementAt(1).theBoard);
				gameTeams.remove(1);
				gameTeams.add(1, temp);
			}
			else{
				Human temp = new Human(gameTeams.elementAt(1).getColour(),gameTeams.elementAt(1).getName(),gameTeams.elementAt(1).getNumber(),gameTeams.elementAt(1).pieces,gameTeams.elementAt(1).theBoard);
				gameTeams.remove(1);
				gameTeams.add(1, temp);				
			}
		}
		if(true/*action event*/){
			gameTeams.elementAt(2).setEvil(buttonPress);
			if(buttonPress){
				Computer temp = new Computer(gameTeams.elementAt(2).getColour(),gameTeams.elementAt(2).getName(),gameTeams.elementAt(2).getNumber(),gameTeams.elementAt(2).pieces,gameTeams.elementAt(2).theBoard);
				gameTeams.remove(2);
				gameTeams.add(2, temp);
			}
			else{
				Human temp = new Human(gameTeams.elementAt(2).getColour(),gameTeams.elementAt(2).getName(),gameTeams.elementAt(2).getNumber(),gameTeams.elementAt(2).pieces,gameTeams.elementAt(2).theBoard);
				gameTeams.remove(2);
				gameTeams.add(2, temp);				
			}
		}
		if(true/*action event*/ && gameTeams.elementAt(0).isEvil()==true){
			gameTeams.elementAt(0).setAIDificulty(slider);
		}
		if(true/*action event*/ && gameTeams.elementAt(0).isEvil()==true){
			gameTeams.elementAt(1).setAIDificulty(slider);
		}
		if(true/*action event*/ && gameTeams.elementAt(0).isEvil()==true){
			gameTeams.elementAt(2).setAIDificulty(slider);
		}
	}


	public void Start() {
		theGame.startGame();
	}

	public void Close() {
		System.exit(0);
	}
}