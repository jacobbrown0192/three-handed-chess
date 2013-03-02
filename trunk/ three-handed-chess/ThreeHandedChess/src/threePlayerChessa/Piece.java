package threePlayerChessa;

public interface Piece {

	public Team getPlayer();

	public void setPlayer(Team aPlayer);

	public String getName();

	public void setName(String aName);

	public void move(Tile aStartTile, Tile aMoveTile);

	public void remove(Tile aCurrentTile);

	public void Piece(Tile aStartTile);
}