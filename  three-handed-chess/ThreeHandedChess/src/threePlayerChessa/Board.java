package threePlayerChessa;

import java.util.Vector;

import threePlayerChessa.Section;
import threePlayerChessa.Piece;
import threePlayerChessa.Piece.PieceType;


/**  
 *The Board class is the class which contains all the sections, segments, and tiles. 
 *It is also used to tell where everything goes
 */
public class Board {
	public Vector<Section> sections = new Vector<Section>();
	public Vector<Piece> pieces = new Vector<Piece>();
	public Vector<Team> gameTeams = new Vector<Team>();
	public Vector<Piece> promotedPieces = new Vector<Piece>();
	
	
	public Vector<Section> getSections()
	{
		return this.sections;
	}
	
	/**  
	 * @return Section at 0
	 */
	public Section getSection0() {
		return this.sections.elementAt(0);
	}

	/**  
	 * @param aSection0 - used to set sections
	 */
	public void setSection0(Section aSection0) {
		this.sections.remove(0);
		this.sections.add(aSection0);
	}

	/**  
	 * @return Section at 1
	 */
	public Section getSection1() {
		return this.sections.elementAt(1);
	}
	
	/**  
	 * @param aSection1 - used to set sections
	 */
	public void setSection1(Section aSection1) {
		this.sections.remove(1);
		this.sections.add(aSection1);
	}
	
	/**  
	 * @return Section at 2
	 */
	public Section getSection2() {
		return this.sections.elementAt(2);
	}

	/**  
	 * @param aSection2 - used to set sections
	 */
	public void setSection2(Section aSection2) {
		this.sections.remove(2);
		this.sections.add(aSection2);
	}

	//might not be necessary 
	public void addPiece(Piece aPiece){
		pieces.add(aPiece);
	}
	
/*	public void update() {
		throw new UnsupportedOperationException();
	}*/

	/**  
	 * Resets the board to blank(no pieces);
	 * @return	null
	 */
	public void reset() {
		pieces.clear();
		for( int i = 0; i<3; i++){
			for(int j = 0; j<2; j++){
				for(int k =0; k<16; k++){
					this.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).setPiece(null);
					this.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).setAccessed(false);
					this.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).setAttacked(false);
					this.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).setSelected(false);
				}
			}
		}
	}
	
	/** Board copy constructor
	 * <p>Performs a deep copy of a Board.
	 * 
	 * @param board - the board being copied
	 */
	public Board(Board board)
	{
		Tile temp = null;
		Tile thisTemp = null;
		
        Vector<MoveList> move1 = new Vector<MoveList>(board.gameTeams.elementAt(0).getMoves());
        Vector<MoveList> move2 = new Vector<MoveList>(board.gameTeams.elementAt(1).getMoves());
        Vector<MoveList> move3 = new Vector<MoveList>(board.gameTeams.elementAt(2).getMoves());
        
        Human team1 = new Human(1,"Player 1",1,this,null);
        Human team2 = new Human(2,"Player 2",2,this,null);
        Human team3 = new Human(3,"Player 3",3,this,null);
        
        team1.setMoves(move1);
        team2.setMoves(move2);
        team3.setMoves(move3);
		
		this.gameTeams.add(team1);
		this.gameTeams.add(team2);
		this.gameTeams.add(team3);
		
		Section temp1 = new Section(4,1,4,1,8,5,gameTeams.elementAt(0),this);// bottom section
		sections.add(0, temp1);
		Section temp2 = new Section(8,5,12,9,4,1,gameTeams.elementAt(1),this);// left section
		sections.add(1, temp2);
		Section temp3 = new Section(12,9,8,5,12,9,gameTeams.elementAt(2),this);// right section
		sections.add(2, temp3);
		
		TileRelations tileRelations = new TileRelations();
		
		for(int relate = 1; relate<97;relate++)
		{
			for( int i = 0; i<3; i++)
			{
				for(int j = 0; j<2; j++)
				{
					for(int k =0; k<16; k++)
					{
						if(this.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getLetter() == tileRelations.relations[relate][0][2] &&
						   this.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getNumber() == tileRelations.relations[relate][0][1]){
								thisTemp = this.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k);
						}
					}
				}
			}
			
			for(int l =1; l<14; l++)
			{
				temp = null;						
				for(int x =0; x < 3; x++)
				{
					for(int y =0; y<2;y++)
					{
						for(int z=0; z<16;z++)
						{
							if(this.sections.elementAt(x).segments.elementAt(y).tiles.elementAt(z).getLetter() == tileRelations.relations[relate][l][2] &&
								this.sections.elementAt(x).segments.elementAt(y).tiles.elementAt(z).getNumber() == tileRelations.relations[relate][l][1]){
								temp = this.sections.elementAt(x).segments.elementAt(y).tiles.elementAt(z);
							}
						}
					}
				}
				
				if(l==1){
					thisTemp.up = temp;
				}
				else if(l==2){
					thisTemp.down = temp;
				}
				else if(l==3){
					thisTemp.left = temp;
				}
				else if(l==4){
					thisTemp.right = temp;
				}
				else if(l==5){
					thisTemp.downleft = temp;
				}
				else if(l==6){
					thisTemp.downright = temp;
				}
				else if(l==7){
					thisTemp.upleft = temp;
				}
				else if(l==8){
					thisTemp.upright = temp;
				}
				else if(l==9){
					thisTemp.hop = temp;
				}
				else if(l==10){
					thisTemp.specialup = temp;
				}
				else if(l==11){
					thisTemp.specialdown = temp;
				}
				else if(l==12){
					thisTemp.specialleft = temp;
				}
				else if(l==13){
					thisTemp.specialright = temp;
				}
			}
		}
				
		//adding pieces to teams
		Vector<Piece> teamPieces1 = new Vector<Piece>();
		Vector<Piece> teamPieces2 = new Vector<Piece>();
		Vector<Piece> teamPieces3 = new Vector<Piece>();
		
		this.promotedPieces = new Vector<Piece>(board.promotedPieces.size());
		for(int i = 0; i < board.promotedPieces.size(); i++)
		{
			if(board.promotedPieces.elementAt(i) != null && board.promotedPieces.elementAt(i).getPlayer() == board.gameTeams.elementAt(0))
			{
				if(board.promotedPieces.elementAt(i).getPieceType() == PieceType.BISHOP)
				{
					Bishop bishopPromoted = new Bishop(this.gameTeams.elementAt(0), "PromotedBishop", this, null, PieceType.BISHOP);
					teamPieces1.add(bishopPromoted);
					this.promotedPieces.add(bishopPromoted);
				}
				if(board.promotedPieces.elementAt(i).getPieceType() == PieceType.KNIGHT)
				{
					Knight knightPromoted = new Knight(this.gameTeams.elementAt(0), "PromotedKnight", this, null, PieceType.KNIGHT);
					teamPieces1.add(knightPromoted);
					this.promotedPieces.add(knightPromoted);
				}
				if(board.promotedPieces.elementAt(i).getPieceType() == PieceType.QUEEN)
				{
					Queen queenPromoted = new Queen(this.gameTeams.elementAt(0), "PromotedQueen", this, null, PieceType.QUEEN);
					teamPieces1.add(queenPromoted);
					this.promotedPieces.add(queenPromoted);
				}
				if(board.promotedPieces.elementAt(i).getPieceType() == PieceType.ROOK)
				{
					Rook rookPromoted = new Rook(this.gameTeams.elementAt(0), "PromotedRook", this, null, PieceType.ROOK);
					teamPieces1.add(rookPromoted);
					this.promotedPieces.add(rookPromoted);
				}
			}
			if(board.promotedPieces.elementAt(i) != null && board.promotedPieces.elementAt(i).getPlayer() == board.gameTeams.elementAt(1))
			{
				if(board.promotedPieces.elementAt(i).getPieceType() == PieceType.BISHOP)
				{
					Bishop bishopPromoted = new Bishop(this.gameTeams.elementAt(1), "PromotedBishop", this, null, PieceType.BISHOP);
					teamPieces2.add(bishopPromoted);
					this.promotedPieces.add(bishopPromoted);
				}
				if(board.promotedPieces.elementAt(i).getPieceType() == PieceType.KNIGHT)
				{
					Knight knightPromoted = new Knight(this.gameTeams.elementAt(1), "PromotedKnight", this, null, PieceType.KNIGHT);
					teamPieces2.add(knightPromoted);
					this.promotedPieces.add(knightPromoted);
				}
				if(board.promotedPieces.elementAt(i).getPieceType() == PieceType.QUEEN)
				{
					Queen queenPromoted = new Queen(this.gameTeams.elementAt(1), "PromotedQueen", this, null, PieceType.QUEEN);
					teamPieces2.add(queenPromoted);
					this.promotedPieces.add(queenPromoted);
				}
				if(board.promotedPieces.elementAt(i).getPieceType() == PieceType.ROOK)
				{
					Rook rookPromoted = new Rook(this.gameTeams.elementAt(1), "PromotedRook", this, null, PieceType.ROOK);
					teamPieces2.add(rookPromoted);
					this.promotedPieces.add(rookPromoted);
				}
			}
			if(board.promotedPieces.elementAt(i) != null && board.promotedPieces.elementAt(i).getPlayer() == board.gameTeams.elementAt(2))
			{
				if(board.promotedPieces.elementAt(i).getPieceType() == PieceType.BISHOP)
				{
					Bishop bishopPromoted = new Bishop(this.gameTeams.elementAt(2), "PromotedBishop", this, null, PieceType.BISHOP);
					teamPieces3.add(bishopPromoted);
					this.promotedPieces.add(bishopPromoted);
				}
				if(board.promotedPieces.elementAt(i).getPieceType() == PieceType.KNIGHT)
				{
					Knight knightPromoted = new Knight(this.gameTeams.elementAt(2), "PromotedKnight", this, null, PieceType.KNIGHT);
					teamPieces3.add(knightPromoted);
					this.promotedPieces.add(knightPromoted);
				}
				if(board.promotedPieces.elementAt(i).getPieceType() == PieceType.QUEEN)
				{
					Queen queenPromoted = new Queen(this.gameTeams.elementAt(2), "PromotedQueen", this, null, PieceType.QUEEN);
					teamPieces3.add(queenPromoted);
					this.promotedPieces.add(queenPromoted);
				}
				if(board.promotedPieces.elementAt(i).getPieceType() == PieceType.ROOK)
				{
					Rook rookPromoted = new Rook(this.gameTeams.elementAt(2), "PromotedRook", this, null, PieceType.ROOK);
					teamPieces3.add(rookPromoted);
					this.promotedPieces.add(rookPromoted);
				}
			}
		}
				
		Pawn pawn11 = new Pawn(this.gameTeams.elementAt(0),"Pawn1",this,null,PieceType.PAWN);
		Pawn pawn21 = new Pawn(this.gameTeams.elementAt(0),"Pawn2",this,null,PieceType.PAWN);
		Pawn pawn31 = new Pawn(this.gameTeams.elementAt(0),"Pawn3",this,null,PieceType.PAWN);
		Pawn pawn41 = new Pawn(this.gameTeams.elementAt(0),"Pawn4",this,null,PieceType.PAWN);
		Pawn pawn51 = new Pawn(this.gameTeams.elementAt(0),"Pawn5",this,null,PieceType.PAWN);
		Pawn pawn61 = new Pawn(this.gameTeams.elementAt(0),"Pawn6",this,null,PieceType.PAWN);
		Pawn pawn71 = new Pawn(this.gameTeams.elementAt(0),"Pawn7",this,null,PieceType.PAWN);
		Pawn pawn81 = new Pawn(this.gameTeams.elementAt(0),"Pawn8",this,null,PieceType.PAWN);
		Rook rook11 = new Rook(this.gameTeams.elementAt(0),"Rook1",this,null,PieceType.ROOK);
		Knight knight11 = new Knight(this.gameTeams.elementAt(0),"Knight1",this,null,PieceType.KNIGHT);
		Bishop bishop11 = new Bishop(this.gameTeams.elementAt(0),"Bishop1",this,null,PieceType.BISHOP);
		King king1 = new King(this.gameTeams.elementAt(0),"King",this,null,PieceType.KING);
		Queen queen11 = new Queen(this.gameTeams.elementAt(0),"Queen1",this,null,PieceType.QUEEN);
		Bishop bishop21 = new Bishop(this.gameTeams.elementAt(0),"Bishop2",this,null,PieceType.BISHOP);
		Knight knight21 = new Knight(this.gameTeams.elementAt(0),"Knight2",this,null,PieceType.KNIGHT);
		Rook rook21 = new Rook(this.gameTeams.elementAt(0),"Rook2",this,null,PieceType.ROOK);
		
		teamPieces1.add(pawn11);
		teamPieces1.add(pawn21);
		teamPieces1.add(pawn31);
		teamPieces1.add(pawn41);
		teamPieces1.add(pawn51);
		teamPieces1.add(pawn61);
		teamPieces1.add(pawn71);
		teamPieces1.add(pawn81);
		teamPieces1.add(rook11);
		teamPieces1.add(knight11);
		teamPieces1.add(bishop11);
		teamPieces1.add(king1);
		teamPieces1.add(queen11);
		teamPieces1.add(bishop21);
		teamPieces1.add(knight21);
		teamPieces1.add(rook21);
		
		team1.addFullTeam(teamPieces1);
				
		Pawn pawn12 = new Pawn(this.gameTeams.elementAt(1),"Pawn1",this,null,PieceType.PAWN);
		Pawn pawn22 = new Pawn(this.gameTeams.elementAt(1),"Pawn2",this,null,PieceType.PAWN);
		Pawn pawn32 = new Pawn(this.gameTeams.elementAt(1),"Pawn3",this,null,PieceType.PAWN);
		Pawn pawn42 = new Pawn(this.gameTeams.elementAt(1),"Pawn4",this,null,PieceType.PAWN);
		Pawn pawn52 = new Pawn(this.gameTeams.elementAt(1),"Pawn5",this,null,PieceType.PAWN);
		Pawn pawn62 = new Pawn(this.gameTeams.elementAt(1),"Pawn6",this,null,PieceType.PAWN);
		Pawn pawn72 = new Pawn(this.gameTeams.elementAt(1),"Pawn7",this,null,PieceType.PAWN);
		Pawn pawn82 = new Pawn(this.gameTeams.elementAt(1),"Pawn8",this,null,PieceType.PAWN);
		Rook rook12 = new Rook(this.gameTeams.elementAt(1),"Rook1",this,null,PieceType.ROOK);
		Knight knight12 = new Knight(this.gameTeams.elementAt(1),"Knight1",this,null,PieceType.KNIGHT);
		Bishop bishop12 = new Bishop(this.gameTeams.elementAt(1),"Bishop1",this,null,PieceType.BISHOP);
		King king2 = new King(this.gameTeams.elementAt(1),"King",this,null,PieceType.KING);
		Queen queen12 = new Queen(this.gameTeams.elementAt(1),"Queen1",this,null,PieceType.QUEEN);
		Bishop bishop22 = new Bishop(this.gameTeams.elementAt(1),"Bishop2",this,null,PieceType.BISHOP);
		Knight knight22 = new Knight(this.gameTeams.elementAt(1),"Knight2",this,null,PieceType.KNIGHT);
		Rook rook22 = new Rook(this.gameTeams.elementAt(1),"Rook2",this,null,PieceType.ROOK);
		
		teamPieces2.add(pawn12);
		teamPieces2.add(pawn22);
		teamPieces2.add(pawn32);
		teamPieces2.add(pawn42);
		teamPieces2.add(pawn52);
		teamPieces2.add(pawn62);
		teamPieces2.add(pawn72);
		teamPieces2.add(pawn82);
		teamPieces2.add(rook12);
		teamPieces2.add(knight12);
		teamPieces2.add(bishop12);
		teamPieces2.add(king2);
		teamPieces2.add(queen12);
		teamPieces2.add(bishop22);
		teamPieces2.add(knight22);
		teamPieces2.add(rook22);
			
		team2.addFullTeam(teamPieces2);

		Pawn pawn13 = new Pawn(this.gameTeams.elementAt(2),"Pawn1",this,null,PieceType.PAWN);
		Pawn pawn23 = new Pawn(this.gameTeams.elementAt(2),"Pawn2",this,null,PieceType.PAWN);
		Pawn pawn33 = new Pawn(this.gameTeams.elementAt(2),"Pawn3",this,null,PieceType.PAWN);
		Pawn pawn43 = new Pawn(this.gameTeams.elementAt(2),"Pawn4",this,null,PieceType.PAWN);
		Pawn pawn53 = new Pawn(this.gameTeams.elementAt(2),"Pawn5",this,null,PieceType.PAWN);
		Pawn pawn63 = new Pawn(this.gameTeams.elementAt(2),"Pawn6",this,null,PieceType.PAWN);
		Pawn pawn73 = new Pawn(this.gameTeams.elementAt(2),"Pawn7",this,null,PieceType.PAWN);
		Pawn pawn83 = new Pawn(this.gameTeams.elementAt(2),"Pawn8",this,null,PieceType.PAWN);
		Rook rook13 = new Rook(this.gameTeams.elementAt(2),"Rook1",this,null,PieceType.ROOK);
		Knight knight13 = new Knight(this.gameTeams.elementAt(2),"Knight1",this,null,PieceType.KNIGHT);
		Bishop bishop13 = new Bishop(this.gameTeams.elementAt(2),"Bishop1",this,null,PieceType.BISHOP);
		King king3 = new King(this.gameTeams.elementAt(2),"King",this,null,PieceType.KING);
		Queen queen13 = new Queen(this.gameTeams.elementAt(2),"Queen1",this,null,PieceType.QUEEN);
		Bishop bishop23 = new Bishop(this.gameTeams.elementAt(2),"Bishop2",this,null,PieceType.BISHOP);
		Knight knight23 = new Knight(this.gameTeams.elementAt(2),"Knight2",this,null,PieceType.KNIGHT);
		Rook rook23 = new Rook(this.gameTeams.elementAt(2),"Rook2",this,null,PieceType.ROOK);
		
		teamPieces3.add(pawn13);
		teamPieces3.add(pawn23);
		teamPieces3.add(pawn33);
		teamPieces3.add(pawn43);
		teamPieces3.add(pawn53);
		teamPieces3.add(pawn63);
		teamPieces3.add(pawn73);
		teamPieces3.add(pawn83);
		teamPieces3.add(rook13);
		teamPieces3.add(knight13);
		teamPieces3.add(bishop13);
		teamPieces3.add(king3);
		teamPieces3.add(queen13);
		teamPieces3.add(bishop23);
		teamPieces3.add(knight23);
		teamPieces3.add(rook23);
		
		team3.addFullTeam(teamPieces3);
			
		team1.addboard(this);
		team2.addboard(this);
		team3.addboard(this);
		
		//Add Pieces to new board based on piece positions of old board
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				for(int k = 0; k < 16; k++)
				{
					for(int l = 0; l < team1.pieces.size(); l++)
					{
						if(board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece() != null)
						{
							if(board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().getPlayer() == board.gameTeams.elementAt(0))
							{
								if(team1.pieces.elementAt(l) != null)
								{
									if(board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().getName() == team1.pieces.elementAt(l).getName())
									{
										this.gameTeams.elementAt(0).pieces.elementAt(l).setCurrentTile(this.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k));
										this.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).setPiece(this.gameTeams.elementAt(0).pieces.elementAt(l));
										if(this.gameTeams.elementAt(0).pieces.elementAt(l).getPieceType() == PieceType.PAWN)
										{
											this.gameTeams.elementAt(0).pieces.elementAt(l).twoTileIndex = board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().twoTileIndex;
											this.gameTeams.elementAt(0).pieces.elementAt(l).initialMove = board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().initialMove;
											this.gameTeams.elementAt(0).pieces.elementAt(l).tilesMoved = board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().tilesMoved;
										}
										if(this.gameTeams.elementAt(0).pieces.elementAt(l).getPieceType() == PieceType.KING || this.gameTeams.elementAt(0).pieces.elementAt(l).getPieceType() == PieceType.ROOK)
										{
											this.gameTeams.elementAt(0).pieces.elementAt(l).setInitialMove(board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().initialMove);
										}
									}
								}
							}
						}
					}
					for(int l = 0; l < team2.pieces.size(); l++)
					{
						if(board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece() != null)
						{
							if(board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().getPlayer() == board.gameTeams.elementAt(1))
							{
								if(team2.pieces.elementAt(l) != null)
								{
									if(board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().getName() == team2.pieces.elementAt(l).getName())
									{
										this.gameTeams.elementAt(1).pieces.elementAt(l).setCurrentTile(this.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k));
										this.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).setPiece(this.gameTeams.elementAt(1).pieces.elementAt(l));
										if(this.gameTeams.elementAt(1).pieces.elementAt(l).getPieceType() == PieceType.PAWN)
										{
											this.gameTeams.elementAt(1).pieces.elementAt(l).twoTileIndex = board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().twoTileIndex;
											this.gameTeams.elementAt(1).pieces.elementAt(l).initialMove = board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().initialMove;
											this.gameTeams.elementAt(1).pieces.elementAt(l).tilesMoved = board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().tilesMoved;
										}
										if(this.gameTeams.elementAt(1).pieces.elementAt(l).getPieceType() == PieceType.KING || this.gameTeams.elementAt(1).pieces.elementAt(l).getPieceType() == PieceType.ROOK)
										{
											this.gameTeams.elementAt(1).pieces.elementAt(l).setInitialMove(board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().initialMove);
										}
									}
								}
							}
						}
					}
					for(int l = 0; l < team3.pieces.size(); l++)
					{
						if(board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece() != null)
						{
							if(board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().getPlayer() == board.gameTeams.elementAt(2))
							{
								if(team3.pieces.elementAt(l) != null)
								{
									if(board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().getName() == team3.pieces.elementAt(l).getName())
									{
										this.gameTeams.elementAt(2).pieces.elementAt(l).setCurrentTile(this.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k));
										this.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).setPiece(this.gameTeams.elementAt(2).pieces.elementAt(l));
										if(this.gameTeams.elementAt(2).pieces.elementAt(l).getPieceType() == PieceType.PAWN)
										{
											this.gameTeams.elementAt(2).pieces.elementAt(l).twoTileIndex = board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().twoTileIndex;
											this.gameTeams.elementAt(2).pieces.elementAt(l).initialMove = board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().initialMove;
											this.gameTeams.elementAt(2).pieces.elementAt(l).tilesMoved = board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().tilesMoved;
										}
										if(this.gameTeams.elementAt(2).pieces.elementAt(l).getPieceType() == PieceType.KING || this.gameTeams.elementAt(2).pieces.elementAt(l).getPieceType() == PieceType.ROOK)
										{
											this.gameTeams.elementAt(2).pieces.elementAt(l).setInitialMove(board.getSections().elementAt(i).getSegments().elementAt(j).getTiles(k).getPiece().initialMove);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	/**  
	 * Board constructor
	 * @param 	gameTeams - the teams playing the game
	 * @return	null
	 * 
	 * Constructs each section clockwise
	 */
	public Board(Vector<Team> gameTeams)
	{
		Tile temp = null;
		Tile thisTemp = null;
		this.gameTeams = gameTeams;
		Section temp1 = new Section(4,1,4,1,8,5,gameTeams.elementAt(0),this);// bottom section
		sections.add(0, temp1);
		Section temp2 = new Section(8,5,12,9,4,1,gameTeams.elementAt(1),this);// left section
		sections.add(1, temp2);
		Section temp3 = new Section(12,9,8,5,12,9,gameTeams.elementAt(2),this);// right section
		sections.add(2, temp3);
		
		TileRelations tileRelations = new TileRelations();
		
		for(int relate = 1; relate<97;relate++)
		{
			for( int i = 0; i<3; i++)
			{
				for(int j = 0; j<2; j++)
				{
					for(int k =0; k<16; k++)
					{
						if(this.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getLetter() == tileRelations.relations[relate][0][2] &&
						   this.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getNumber() == tileRelations.relations[relate][0][1]){
								thisTemp = this.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k);
						}
					}
				}
			}
			
			for(int l =1; l<14; l++)
			{
				temp = null;						
				for(int x =0; x < 3; x++)
				{
					for(int y =0; y<2;y++)
					{
						for(int z=0; z<16;z++)
						{
							if(this.sections.elementAt(x).segments.elementAt(y).tiles.elementAt(z).getLetter() == tileRelations.relations[relate][l][2] &&
								this.sections.elementAt(x).segments.elementAt(y).tiles.elementAt(z).getNumber() == tileRelations.relations[relate][l][1]){
								temp = this.sections.elementAt(x).segments.elementAt(y).tiles.elementAt(z);
							}
						}
					}
				}
				
				if(l==1){
					thisTemp.up = temp;
				}
				else if(l==2){
					thisTemp.down = temp;
				}
				else if(l==3){
					thisTemp.left = temp;
				}
				else if(l==4){
					thisTemp.right = temp;
				}
				else if(l==5){
					thisTemp.downleft = temp;
				}
				else if(l==6){
					thisTemp.downright = temp;
				}
				else if(l==7){
					thisTemp.upleft = temp;
				}
				else if(l==8){
					thisTemp.upright = temp;
				}
				else if(l==9){
					thisTemp.hop = temp;
				}
				else if(l==10){
					thisTemp.specialup = temp;
				}
				else if(l==11){
					thisTemp.specialdown = temp;
				}
				else if(l==12){
					thisTemp.specialleft = temp;
				}
				else if(l==13){
					thisTemp.specialright = temp;
				}
			}
		}
	}
}