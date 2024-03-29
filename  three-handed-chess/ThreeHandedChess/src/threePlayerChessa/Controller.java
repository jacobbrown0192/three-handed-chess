package threePlayerChessa;

import java.util.Vector;



import threePlayerChessa.Piece.PieceType;

/** 
 *The Controller class controls the turn counter, whether the game is in progress
 *and whether someone is in check. Checking for check has yet to be implemented.
 */
public class Controller {
	private Game theGame; //the game its self which contains everything
	private int turnCount; //counter for the number of turns so far
	private boolean inProgress; //determines if the game is in progress
	
	/**
	 * Controller constructor
	 * @param aGame - the game its self which contains everything
	 */
	public Controller(Game aGame){
		theGame = aGame;
		turnCount = 0;
	}

	/**
	 * @return the inProgress
	 */
	public boolean isInProgress() {
		return inProgress;
	}
	/**
	 * @param inProgress - used to set inProgress
	 */
	public void setInProgress(boolean inProgress) {
		this.inProgress = inProgress;
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

	/**
	 * @return the turnCount
	 */
	public int getTurnCount() {
		return turnCount;
	}

	/**
	 * @param turnCount - used to set turnCount
	 */
	public void setTurnCount(int turnCount) {
		this.turnCount = turnCount;
	}

	/**
	 * used to add one to the counter and notify all the players
	 */
	public synchronized void addToCounter(){
		turnCount ++;
		
		for(int x = 0; x<3;x++)
		{
			synchronized (theGame.getPlayers().elementAt(x)){
				theGame.getPlayers().elementAt(x).notify();
			}
		}
		
/*		synchronized (theGame.getPlayer1()){
			theGame.getPlayer1().notify();
		}
		synchronized (theGame.getPlayer2()){
			theGame.getPlayer2().notify();
		}
		synchronized (theGame.getPlayer3()){
			theGame.getPlayer3().notify();
		}*/
	}
	
	/** Looks to see if you're in check
	 * @param me - The team who's is check to see if they are in check.
	 * @param opponent1 - One of the other team whose moves must be analyzed to see if the me team is in check.
	 * @param opponent2 - One of the other team whose moves must be analyzed to see if the me team is in check.
	 * @return whether in check or not
	 */
	public boolean inCheck(Team me, Team opponent1, Team opponent2, Board board)
	{
		boolean result = false;
		Vector<Tile> opponentMoves =  new Vector<Tile>();
		Vector<Tile> kingPosition = new Vector<Tile>();
		Vector<Tile> myMoves = new Vector<Tile>();
		//Find everywhere your opponents can go and add them to a vector
		opponentMoves.addAll(allPossibleMoves(opponent1, board));
		opponentMoves.addAll(allPossibleMoves(opponent2, board));
		for(int x = 0; x<theGame.getTheBoard().getPromotedPieces().size();x++){
			if(theGame.getTheBoard().getPromotedPieces().elementAt(x).getPlayer() == opponent1 || theGame.getTheBoard().getPromotedPieces().elementAt(x).getPlayer() == opponent2){
				opponentMoves.addAll(theGame.getTheBoard().getPromotedPieces().elementAt(x).getValidMoves());
			}
		}
		
		//Find where your king is
		kingPosition.addAll(findKingPosition(me, board));
		
		//Check to see if an opponent is attacking your king
		for (int i = 0; i < opponentMoves.size(); i++)
		{
			if (opponentMoves.elementAt(i) != null && opponentMoves.elementAt(i) != null)
			{
				if (opponentMoves.elementAt(i).getLetter() == kingPosition.elementAt(0).getLetter() && opponentMoves.elementAt(i).getNumber() == kingPosition.elementAt(0).getNumber())
				{
					result = true;
					break;
				}
			}
		}	
		return result;
	}
	
	public Team Checkmate(Team me, Team opponent1, Team opponent2, Board board){
		Vector<Tile> kingPosition = new Vector<Tile>();
		Vector<Tile> myMoves = new Vector<Tile>();
		
		//Find everywhere you can go and add them to a vector
		myMoves.addAll(allPossibleMoves(me, board));
		
		//Find where your king is
		kingPosition.addAll(findKingPosition(me, board));
		
		boolean check = inCheck(me,opponent1,opponent2,board);
		
		//If in check, check to see if in checkmate
		Tile tempStart = null;
		Team winner = null;
		if(check == true)
		{ 
		me.setCheckMate(true);
		boolean checkMateTemp = false;
			for(int i = 0; i<16; i++){
				tempStart = me.getPieces().elementAt(i).getCurrentTile();
				if(tempStart != null){
					for(int j = 0; j<me.getPieces().elementAt(i).getValidMoves().size();j++){
						checkMateTemp = putIntoCheck(tempStart,me.getPieces().elementAt(i).getValidMoves().elementAt(j));
						if(!checkMateTemp){
						 	me.setCheckMate(false);						
						}
					}
				}
			}	
			
			for(int x = 0; x<theGame.getTheBoard().getPromotedPieces().size();x++){
				tempStart = theGame.getTheBoard().getPromotedPieces().elementAt(x).getCurrentTile();
				if(theGame.getTheBoard().getPromotedPieces().elementAt(x).getPlayer() == me){
					if(tempStart != null){
						for(int y = 0; y<theGame.getTheBoard().getPromotedPieces().elementAt(x).getValidMoves().size();y++){
							checkMateTemp = putIntoCheck(tempStart,theGame.getTheBoard().getPromotedPieces().elementAt(x).getValidMoves().elementAt(y));
							if(!checkMateTemp){
							 	me.setCheckMate(false);					
							}
						}
					}
				}
			}
			
			
			for(int k = 0; k<16; k++){
				for(int l = 0; l<opponent1.getPieces().elementAt(k).getValidMoves().size();l++){
					if(opponent1.getPieces().elementAt(k).getValidMoves().elementAt(l) != null){
						if (opponent1.getPieces().elementAt(k).getValidMoves().elementAt(l).getLetter() == kingPosition.elementAt(0).getLetter() && opponent1.getPieces().elementAt(k).getValidMoves().elementAt(l).getNumber() == kingPosition.elementAt(0).getNumber())
						{
							winner = opponent1;
							break;
						}
					}
				}				
			}
			
			for(int m = 0; m<16; m++){
				for(int n = 0; n<opponent2.getPieces().elementAt(m).getValidMoves().size();n++){
					if(opponent2.getPieces().elementAt(m).getValidMoves().elementAt(n) != null){
						if (opponent2.getPieces().elementAt(m).getValidMoves().elementAt(n).getLetter() == kingPosition.elementAt(0).getLetter() && opponent2.getPieces().elementAt(m).getValidMoves().elementAt(n).getNumber() == kingPosition.elementAt(0).getNumber())
						{
							winner = opponent2;
							break;
						}
					}
				}				
			}
			
/*
 			for(int x = 0; x<theGame.getTheBoard().getPromotedPieces().size();x++){
				tempStart = theGame.getTheBoard().getPromotedPieces().elementAt(x).getCurrentTile();
				if(theGame.getTheBoard().getPromotedPieces().elementAt(x).getPlayer() == opponent1 || theGame.getTheBoard().getPromotedPieces().elementAt(x).getPlayer() == opponent2){
					if(tempStart != null){
						for(int y = 0; y<theGame.getTheBoard().getPromotedPieces().elementAt(x).getValidMoves().size();y++){
							if (theGame.getTheBoard().getPromotedPieces().elementAt(x).getValidMoves().elementAt(y).getLetter() == kingPosition.elementAt(0).getLetter() && theGame.getTheBoard().getPromotedPieces().elementAt(x).getValidMoves().elementAt(y).getNumber() == kingPosition.elementAt(0).getNumber())
							{
								winner = opponent2;
								break;
							}
						}
					}
				}
			}
*/
			
			
			
		}
		return winner;
	}
	
	

	/** Finds the position of the king
	 * @param team - Team that is looking for their king
	 * @param board - board on which the king is being looked for on
	 * @return vector containing one tile which has the king's position
	 */
	private Vector<Tile> findKingPosition(Team team, Board board)
	{
		Vector<Tile> moves = new Vector<Tile>();
		
		for(int i = 0; i<3; i++)
		{
			for(int j = 0; j<2; j++)
			{
				for(int k =0; k<16; k++)
				{
					if (board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece() != null)
					{
						if (board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().getPlayer() == team
								&& board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().getPieceType() == PieceType.KING)
						{
							moves.add(board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k));
							return moves;
						}
					}
				}
			}
		}
		return null;
	}

	/** Finds all moves that a team can make
	 * @param team - Team that's looking for their possible moves
	 * @param board - board that is being searched for possible moves
	 * @return vector containing all possible moves the team can make
	 */
	private Vector<Tile> allPossibleMoves(Team team, Board board)
	{
		Vector<Tile> moves = new Vector<Tile>();
		
		for(int i = 0; i<3; i++)
		{
			for(int j = 0; j<2; j++)
			{
				for(int k =0; k<16; k++)
				{
					if (board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece() != null)
					{
						if (board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().getPlayer() == team)
						{
							board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().possibleMoves();
							moves.addAll(board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().getValidMoves());
						}
					}
				}
			}
		}
		
		return moves;
	}
	
	public boolean putIntoCheck(Tile aStartTile, Tile aMoveTile)
	{
		if (aMoveTile == null) return false;
		//First check to see if the move will put you into check on a copy constructed board
		Board checkBoard = new Board(theGame.getTheBoard());
		int moveSection = -1, moveSegment = -1, moveTile = -1;
		int startSection = -1, startSegment = -1, startTile = -1;
		
		//Search for tiles
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				for(int k = 0; k < 16; k++)
				{
					if(checkBoard.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getNumber() == aMoveTile.getNumber()
					&& checkBoard.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getLetter() == aMoveTile.getLetter())
					{
						moveSection = i;
						moveSegment = j;
						moveTile = k;
					}
					
					if(checkBoard.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getNumber() == aStartTile.getNumber()
					&& checkBoard.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getLetter() == aStartTile.getLetter())
					{
						startSection = i;
						startSegment = j;
						startTile = k;
					}
				}
			}
		}
		
		if(checkBoard.getSections().elementAt(moveSection).getSegments().elementAt(moveSegment).getTiles(moveTile).getPiece() != null)
		{
			checkBoard.getSections().elementAt(moveSection).getSegments().elementAt(moveSegment).getTiles(moveTile).getPiece().setCurrentTile(null);
		}

		checkBoard.getSections().elementAt(moveSection).getSegments().elementAt(moveSegment).getTiles(moveTile).setPiece(checkBoard.getSections().elementAt(startSection).getSegments().elementAt(startSegment).getTiles(startTile).getPiece());
		checkBoard.getSections().elementAt(startSection).getSegments().elementAt(startSegment).getTiles(startTile).setPiece(null);
		checkBoard.getSections().elementAt(moveSection).getSegments().elementAt(moveSegment).getTiles(moveTile).getPiece().setCurrentTile(checkBoard.getSections().elementAt(moveSection).getSegments().elementAt(moveSegment).getTiles(moveTile));
		
		int myTeamNum = checkBoard.getSections().elementAt(moveSection).getSegments().elementAt(moveSegment).getTiles(moveTile).getPiece().getPlayer().getNumber();
		boolean check = false;
		
		if(myTeamNum == 1)
		{
			check = theGame.getGameController().inCheck(checkBoard.getGameTeams().elementAt(0), checkBoard.getGameTeams().elementAt(1), checkBoard.getGameTeams().elementAt(2), checkBoard);
		}
		else if(myTeamNum == 2)
		{
			check = theGame.getGameController().inCheck(checkBoard.getGameTeams().elementAt(1), checkBoard.getGameTeams().elementAt(0), checkBoard.getGameTeams().elementAt(2), checkBoard);
		}
		else if(myTeamNum == 3)
		{
			check = theGame.getGameController().inCheck(checkBoard.getGameTeams().elementAt(2), checkBoard.getGameTeams().elementAt(1), checkBoard.getGameTeams().elementAt(0), checkBoard);
		}
		return check;	
	}
	
}