package threePlayerChessa;

public abstract class Piece {
	Team player;
	String name;
	Board theBoard;
	Tile currentTile;

	public Team getPlayer() {
		return player;
	}

	public Board getTheBoard() {
		return theBoard;
	}

	public void setTheBoard(Board theBoard) {
		this.theBoard = theBoard;
	}

	public void setPlayer(Team player) {
		this.player = player;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Tile getCurrentTile() {
		return currentTile;
	}

	public void setCurrentTile(Tile currentTile) {
		this.currentTile = currentTile;
	}

	public void move(Tile aStartTile, Tile aMoveTile){
		
	}

	public void remove(Piece nextPiece){
		this.currentTile.setPiece(nextPiece);
	}

	public Piece(Team player, String name, Board theBoard, Tile currentTile) {
		this.player = player;
		this.name = name;
		this.theBoard = theBoard;
		this.currentTile = currentTile;
	}


}