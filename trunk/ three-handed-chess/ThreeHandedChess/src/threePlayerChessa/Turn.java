package threePlayerChessa;


import java.util.Vector;

import GUI_Interface.WinGUI;


/**  
 *The turn class is an extension of thread implemented for each player.
 */
public class Turn extends Thread {
	private Game theGame; //the game its self which contains everything
	private Team gameTeam; //the player of which this thread belongs
	private Team opponent1;
	private Team opponent2;
	private boolean check; //tells if the player is in check
	private boolean validClick1;
	private boolean validClick2;
	
	
	/**
	 * Controller constructor
	 * @param aGame - the game itself which contains everything.
	 * @param aTeam - the player of which this thread belongs to.
	 * @param opponent2 
	 * @param opponent1 
	 */
	public Turn(Game aGame,Team aTeam, Team opponent1, Team opponent2)
	{
		setTheGame(aGame);
		gameTeam = aTeam;
		this.opponent1 = opponent1;
		this.opponent2 = opponent2;
	}
	
	/**  
	 *runs the thread 
	 */
	@Override public void run()
	{

		if(gameTeam.isEvil() == true)//If you're a computer player
		{
			while(getTheGame().getGameController().isInProgress() == true)
			{
				if((getTheGame().getGameController().getTurnCount() % 3) == (gameTeam.getNumber() - 1))//checks to see if its current players turn
				{
					Team winner = theGame.getGameController().Checkmate(gameTeam,opponent1,opponent2, theGame.getTheBoard());
					if(gameTeam.isCheckMate()){
						WinGUI Win = new WinGUI(theGame);
						Win.getLblWin().setText(winner.getName() + " Wins!");
						theGame.getGameFrame().getContentPane().removeAll();
					    theGame.getGameFrame().getContentPane().repaint();
						theGame.getGameFrame().getContentPane().add(Win);
						theGame.getGameFrame().setVisible(true);
					}
					try {
					    Thread.sleep(100);
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
					Tile select1 = null;
					Tile select2 = null;
					
					//Pick a random piece on your team
					//If the piece has valid moves, pick a random move
					//Else pick a random piece on your team and try again
					//If move is successful, then we're fine
					//Else pick a random piece on your team and try again
					
					
					Vector <Piece> teamPieces = new Vector <Piece>(gameTeam.getPieces());
					for(int i = 0; i<theGame.getTheBoard().getPromotedPieces().size();i++){
						if(theGame.getTheBoard().getPromotedPieces().elementAt(i).getPlayer() == gameTeam){
							teamPieces.add(theGame.getTheBoard().getPromotedPieces().elementAt(i));
						}
					}
					int numPieces = teamPieces.size();
					int pieceIndex = (int) (Math.random()*numPieces);
					int moveIndex = -1;
					boolean successfulMove = false;
					
					while(!successfulMove)
					{
						if(teamPieces.elementAt(pieceIndex).getCurrentTile() != null)
						{
							teamPieces.elementAt(pieceIndex).possibleMoves();
							if(!teamPieces.elementAt(pieceIndex).getValidMoves().isEmpty())
							{
								select1 = teamPieces.elementAt(pieceIndex).getCurrentTile();
								moveIndex = (int) (Math.random()*teamPieces.elementAt(pieceIndex).getValidMoves().size());
								select2 = teamPieces.elementAt(pieceIndex).getValidMoves().elementAt(moveIndex);
								
								if(select1.getPiece().move(select1, select2, this))
								{
									successfulMove = true;
								}
								else
								{
									pieceIndex = (int) (Math.random()*numPieces);
								}
							}
							else
							{
								pieceIndex = (int) (Math.random()*numPieces);
							}
						}
						else
						{
							pieceIndex = (int) (Math.random()*numPieces);
						}
					}
				}
				else
				{
					suspendMe();
				}
			}
		}
		
		else
		{
			while(getTheGame().getGameController().isInProgress() == true){ // checks to see if the game is in progress
				validClick1 = false;
				validClick2 = false;			
				this.check = false;//getTheGame().gameController.inCheck(gameTeam, opponent1, opponent2);
				
				Tile select1 = null;
				Tile select2 = null;
				Team winner = theGame.getGameController().Checkmate(gameTeam,opponent1,opponent2, theGame.getTheBoard());
				
				if((getTheGame().getGameController().getTurnCount() % 3) == (gameTeam.getNumber() - 1))//checks to see if its current players turn
				{ 
					if(gameTeam.isCheckMate())
					{
						WinGUI Win = new WinGUI(theGame);
						Win.getLblWin().setText(winner.getName() + " Wins!");
						theGame.getGameFrame().getContentPane().removeAll();
					    theGame.getGameFrame().getContentPane().repaint();
						theGame.getGameFrame().getContentPane().add(Win);
						theGame.getGameFrame().setVisible(true);
					}
					
					theGame.gettBoardGUI().getLblGameAndStuff().setText(gameTeam.getName());
					boolean printTime = false;
					printTime = theGame.getGameController().inCheck(gameTeam, opponent1, opponent2, theGame.getTheBoard());
					
					if (printTime)
					{
						theGame.getbBoardGUI().getLblCheckLabel().setText("You are in check");
					}
	
					
					if(getTheGame().getClick1() != null)//check for first click
					{
	
						
						//finds the tile clicked
						for(int i =0; i < 3; i++){
							for(int j =0; j<2;j++){
								for(int k=0; k<16;k++){
									if(getTheGame().getTheBoard().getSections().elementAt(i).getSegments().elementAt(j).getTiles().elementAt(k).getLetter() == getTheGame().getClick1().getLet() &&
										getTheGame().getTheBoard().getSections().elementAt(i).getSegments().elementAt(j).getTiles().elementAt(k).getNumber() == getTheGame().getClick1().getNum()){
										select1 = getTheGame().getTheBoard().getSections().elementAt(i).getSegments().elementAt(j).getTiles().elementAt(k);
									}
								}
							}
						} 
						
						//see if first click is valid
						if(select1.getPiece() != null)
						{					
							if( select1.getPiece().getPlayer() == gameTeam)
							{
								validClick1 = true;
								select1.setSelected(true);
								theGame.getBoardGUI().setTileIcons();
								theGame.getbBoardGUI().getLblCheckLabel().setText("");
							}
							else
							{
								getTheGame().setClick1(null);
								theGame.getbBoardGUI().getLblCheckLabel().setText("That's not your piece");
							}
						}
						else
						{
							getTheGame().setClick1(null);
							theGame.getbBoardGUI().getLblCheckLabel().setText("That Tile is empty");
						}
						
						
						if(validClick1)
						{
							select1.getPiece().possibleMoves();
							select1.getPiece().possibleMovesHighlight();
							theGame.getBoardGUI().setTileIcons();
							if(getTheGame().getClick2() != null)
							{	
								//finds the second clicked tile
								for(int i =0; i < 3; i++)
								{
									for(int j =0; j<2;j++)
									{
										for(int k=0; k<16;k++)
										{
											if(getTheGame().getTheBoard().getSections().elementAt(i).getSegments().elementAt(j).getTiles().elementAt(k).getLetter() == getTheGame().getClick2().getLet() &&
												getTheGame().getTheBoard().getSections().elementAt(i).getSegments().elementAt(j).getTiles().elementAt(k).getNumber() == getTheGame().getClick2().getNum()){
												select2 = getTheGame().getTheBoard().getSections().elementAt(i).getSegments().elementAt(j).getTiles().elementAt(k);
											}
										}
									}
								}
						
								
								if(select1.getPiece() != null && select2.getPiece() != null && select1.getPiece() == select2.getPiece())
								{
									select1.setSelected(false);
									select2.setSelected(false);
									select1.getPiece().possibleMovesUnhighlight();
									theGame.getBoardGUI().setTileIcons();
									getTheGame().setClick1(null);
									getTheGame().setClick2(null);
								}
								else if(select2.getPiece() != null && select2.getPiece().getPlayer() == gameTeam)
								{
									select1.setSelected(false);
									select2.setSelected(true);
									select1.getPiece().possibleMovesUnhighlight();
									theGame.getBoardGUI().setTileIcons();
									getTheGame().setClick1(getTheGame().getClick2());
									getTheGame().setClick2(null);
								}
								//moves if second click is valid
								else
								{
									select1.getPiece().possibleMovesUnhighlight();
									select1.setSelected(false);
									select2.setSelected(false);
									select1.getPiece().move(select1, select2,this);
									theGame.getBoardGUI().setTileIcons();
								}							
							}
							else{
								suspendMe();
							}
						}
					}
					else{
						suspendMe();
					}			
				}
				else{
					suspendMe();
				}
			}
		}
	}

	
	
	/**  
	 *used to suspend the thread
	 */
	synchronized void suspendMe(){
		try {
			Thread.currentThread().wait();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * @return the theGame
	 */
	public Game getTheGame() {
		return theGame;
	}


	/**
	 * @param theGame - used to set theGame
	 */
	public void setTheGame(Game theGame) {
		this.theGame = theGame;
	}
	
	public Team getGameTeam()
	{
		return this.gameTeam;
	}

	public Team getOpponent1()
	{
		return this.opponent1;
	}

	public Team getOpponent2()
	{
		return this.opponent2;
	}
	
	public void setCheck(boolean check)
	{
		this.check = check;
	}
	
	public boolean getCheck()
	{
		return this.check;
	}

	/**
	 * @param gameTeam - used to set gameTeam
	 */
	public void setGameTeam(Team gameTeam) {
		this.gameTeam = gameTeam;
	}

	/**
	 * @param opponent1 - used to set opponent1
	 */
	public void setOpponent1(Team opponent1) {
		this.opponent1 = opponent1;
	}

	/**
	 * @param opponent2 - used to set opponent2
	 */
	public void setOpponent2(Team opponent2) {
		this.opponent2 = opponent2;
	}
	
	
	
}
