package threePlayerChessa;

import GUI_Interface.PromotePawn;


/**  
 *The Pawn class extends Piece. 
 *Its movement style is to move straight one space however it takes pieces one space diagonally
 *The Pawn has three special movements: 
 *it can move two spaces ahead the first move
 *it can preform en passant
 *it can be promoted by reaching another players bench.   
 *
 *
 */
public class Pawn extends Piece {

	


	public Pawn(Team player, String name, Board theBoard, Tile currentTile) {
		super(player, name, theBoard, currentTile);
		// TODO Auto-generated constructor stub
	}

	public void move(Tile aStartTile, Tile aMoveTile, Turn player) {
		boolean validMove = false;
		//check for valid move
		if (validMove){
			aMoveTile.setPiece(aStartTile.getPiece());
			aStartTile.setPiece(null);
			player.getTheGame().gameController.addToCounter();
			if(aMoveTile.getNumber() == 1 || aMoveTile.getNumber() == 8 || aMoveTile.getNumber() == 12){
				PromotePawn selector = new PromotePawn(this,player);
				player.getTheGame().gameFrame.getContentPane().removeAll();
			    player.getTheGame().gameFrame.getContentPane().repaint();
				player.getTheGame().gameFrame.getContentPane().add(selector);
				player.getTheGame().gameFrame.setVisible(true);
			}
		}
		else{
			return;
		}
	}
	
	public void selectQueen(Tile aTile){
		Queen temp = new Queen(aTile.getPiece().getPlayer(),"Promoted Piece",theBoard,aTile);
		aTile.setPiece(temp);
	}

	public void selectBishop(Tile aTile){
		Bishop temp = new Bishop(aTile.getPiece().getPlayer(),"Promoted Piece",theBoard,aTile);
		aTile.setPiece(temp);
	}
	
	public void selectKnight(Tile aTile){
		Knight temp = new Knight(aTile.getPiece().getPlayer(),"Promoted Piece",theBoard,aTile);
		aTile.setPiece(temp);
	}
	
	public void selectRook(Tile aTile){
		Rook temp = new Rook(aTile.getPiece().getPlayer(),"Promoted Piece",theBoard,aTile);
		aTile.setPiece(temp);
	}
}