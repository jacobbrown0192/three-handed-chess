package threePlayerChessa;

import java.util.Vector;



import threePlayerChessa.Piece.PieceType;

/** 
 *The Controller class controls the turn counter, whether the game is in progress
 *and whether someone is in check. Checking for check has yet to be implemented.
 */
public class Controller {
	Game theGame; //the game its self which contains everything
	int turnCount; //counter for the number of turns so far
	boolean inProgress; //determines if the game is in progress
	
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
	 * used to add one to the counter and notify all the players
	 */
	public synchronized void addToCounter(){
		turnCount ++;
		synchronized (theGame.getPlayer1()){
			theGame.getPlayer1().notify();
		}
		synchronized (theGame.getPlayer2()){
			theGame.getPlayer2().notify();
		}
		synchronized (theGame.getPlayer3()){
			theGame.getPlayer3().notify();
		}
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
		me.checkMate = true;
		boolean checkMateTemp = false;
			for(int i = 0; i<16; i++){
				tempStart = me.pieces.elementAt(i).currentTile;
				if(tempStart != null){
					for(int j = 0; j<me.pieces.elementAt(i).validTileMoves.size();j++){
						checkMateTemp = putIntoCheck(tempStart,me.pieces.elementAt(i).validTileMoves.elementAt(j));
						if(!checkMateTemp){
						 	me.checkMate = false;						
						}
					}
				}
			}	
			
			for(int x = 0; x<theGame.getTheBoard().promotedPieces.size();x++){
				tempStart = theGame.getTheBoard().promotedPieces.elementAt(x).getCurrentTile();
				if(theGame.getTheBoard().promotedPieces.elementAt(x).getPlayer() == me){
					if(tempStart != null){
						for(int y = 0; y<theGame.getTheBoard().promotedPieces.elementAt(x).validTileMoves.size();y++){
							checkMateTemp = putIntoCheck(tempStart,theGame.getTheBoard().promotedPieces.elementAt(x).validTileMoves.elementAt(y));
							if(!checkMateTemp){
							 	me.checkMate = false;						
							}
						}
					}
				}
			}
			
			
			for(int k = 0; k<16; k++){
				for(int l = 0; l<opponent1.pieces.elementAt(k).validTileMoves.size();l++){
					if(opponent1.pieces.elementAt(k).validTileMoves.elementAt(l) != null){
						if (opponent1.pieces.elementAt(k).validTileMoves.elementAt(l).getLetter() == kingPosition.elementAt(0).getLetter() && opponent1.pieces.elementAt(k).validTileMoves.elementAt(l).getNumber() == kingPosition.elementAt(0).getNumber())
						{
							winner = opponent1;
							break;
						}
					}
				}				
			}
			
			for(int m = 0; m<16; m++){
				for(int n = 0; n<opponent2.pieces.elementAt(m).validTileMoves.size();n++){
					if(opponent2.pieces.elementAt(m).validTileMoves.elementAt(n) != null){
						if (opponent2.pieces.elementAt(m).validTileMoves.elementAt(n).getLetter() == kingPosition.elementAt(0).getLetter() && opponent2.pieces.elementAt(m).validTileMoves.elementAt(n).getNumber() == kingPosition.elementAt(0).getNumber())
						{
							winner = opponent2;
							break;
						}
					}
				}				
			}
			
			for(int x = 0; x<theGame.getTheBoard().promotedPieces.size();x++){
				tempStart = theGame.getTheBoard().promotedPieces.elementAt(x).getCurrentTile();
				if(theGame.getTheBoard().promotedPieces.elementAt(x).getPlayer() == opponent1 || theGame.getTheBoard().promotedPieces.elementAt(x).getPlayer() == opponent2){
					if(tempStart != null){
						for(int y = 0; y<theGame.getTheBoard().promotedPieces.elementAt(x).validTileMoves.size();y++){
							if (theGame.getTheBoard().promotedPieces.elementAt(x).validTileMoves.elementAt(y).getLetter() == kingPosition.elementAt(0).getLetter() && theGame.getTheBoard().promotedPieces.elementAt(x).validTileMoves.elementAt(y).getNumber() == kingPosition.elementAt(0).getNumber())
							{
								winner = opponent2;
								break;
							}
						}
					}
				}
			}
			
			
			
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
			check = theGame.getGameController().inCheck(checkBoard.gameTeams.elementAt(0), checkBoard.gameTeams.elementAt(1), checkBoard.gameTeams.elementAt(2), checkBoard);
		}
		else if(myTeamNum == 2)
		{
			check = theGame.getGameController().inCheck(checkBoard.gameTeams.elementAt(1), checkBoard.gameTeams.elementAt(0), checkBoard.gameTeams.elementAt(2), checkBoard);
		}
		else if(myTeamNum == 3)
		{
			check = theGame.getGameController().inCheck(checkBoard.gameTeams.elementAt(2), checkBoard.gameTeams.elementAt(1), checkBoard.gameTeams.elementAt(0), checkBoard);
		}
		return check;	
	}
	
}