package threePlayerChessa;

public class King extends Piece {

	
	public King(Team player, String name, Board theBoard, Tile currentTile) {
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
		}
		else{
			return;
		}
	}


}