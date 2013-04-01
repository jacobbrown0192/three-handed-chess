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
		synchronized (theGame.player1){
			theGame.player1.notify();
		}
		synchronized (theGame.player2){
			theGame.player2.notify();
		}
		synchronized (theGame.player3){
			theGame.player3.notify();
		}
	}
	
	/**
	 * @return the whether in check
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
		
		//Find everywhere you can go and add them to a vector
		myMoves.addAll(allPossibleMoves(me, board));
		
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
		
		//If in check, check to see if in checkmate
		//To be done...
		kingPosition.elementAt(0).getPiece().possibleMoves();
		if(result == true && kingPosition.elementAt(0).getPiece().validTileMoves.size() == 0)
		{
			
		}
		
		
		
		
		return result;
	}

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
	
	public boolean putIntoCheck(Tile aStartTile, Tile aMoveTile){
		
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
			check = theGame.gameController.inCheck(checkBoard.gameTeams.elementAt(0), checkBoard.gameTeams.elementAt(1), checkBoard.gameTeams.elementAt(2), checkBoard);
		}
		else if(myTeamNum == 2)
		{
			check = theGame.gameController.inCheck(checkBoard.gameTeams.elementAt(1), checkBoard.gameTeams.elementAt(0), checkBoard.gameTeams.elementAt(2), checkBoard);
		}
		else if(myTeamNum == 3)
		{
			check = theGame.gameController.inCheck(checkBoard.gameTeams.elementAt(2), checkBoard.gameTeams.elementAt(1), checkBoard.gameTeams.elementAt(0), checkBoard);
		}
		
		if (check)
		{
			System.out.println("Holy Shit it actually worked!");
		}
		return check;
		
	}
	
}


























