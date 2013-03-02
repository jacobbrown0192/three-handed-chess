package threePlayerChessa;

public abstract class Piece {
	Team player;
	String name;
	Board theBoard;
	Tile currentTile;

	public Team getPlayer() {
		return player;
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

	public void move(Tile aStartTile, Tile aMoveTile){
		
	}

	public void remove(Piece nextPiece){
		this.currentTile.setPiece(nextPiece);
	}

	public Piece(Tile startTile){
		currentTile = startTile;		
	}
}