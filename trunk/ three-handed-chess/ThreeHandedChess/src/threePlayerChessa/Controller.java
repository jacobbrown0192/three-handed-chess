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
}


























