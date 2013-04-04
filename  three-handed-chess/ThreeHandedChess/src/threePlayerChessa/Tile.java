package threePlayerChessa;

/**
 * <p>The Tile class is the smallest component class of the board.
 * <p>Tiles can contain a piece, belong to a segment, have a number, have a letter,
 * and have a colour.
 * <p>colour decides whether the tile is the darker or lighter brown
 * <p>number holds the number file of the tile
 * <p>letter holds the letter file of the tile
 * <p>piece is the chess piece on the tile, null if empty
 * <p>segment is the segment to which this tile belongs
 * <p>selected is true if the player whose turn it is has clicked this tile
 * <p>attacked is true if this tile is being attacked by the selected piece
 * <p>accessed is true if this tile is a possible move for the selected piece
 * 
 * <p>Tile also contains the tiles which it is adjacent to for determining possible moves.
 */
public class Tile {
	private boolean colour;
	private int number;
	private int letter;
	private Piece piece;
	private Segment segment;
	private boolean selected;
	private boolean attacked;
	private boolean accessed;
	
	Tile up,down,left,right,downleft,downright,upleft,upright,hop,specialup,specialdown,specialleft,specialright;

	/**
	 * Tile constructor
	 * @param aColour - colour of tile
	 * @param aNum - number file
	 * @param aLet - letter file
	 * @param aPiece - piece on this tile
	 * @param seg - segment which owns this tile
	 * @param selected - if this tile is selected
	 * @param attacked - if this tile is attacked
	 * @param accessed - if this tile is accessed
	 */
	public Tile(boolean aColour, int aNum, int aLet, Piece aPiece, Segment seg, boolean selected, boolean attacked, boolean accessed)
	{
		setColour(aColour);
		setNumber(aNum);
		setLetter(aLet);
		setPiece(aPiece);
		setSelected(selected);
		setAttacked(attacked);
		setAccessed(accessed);
		setSegment(seg);
	}	
	
	/**
	 * @return the colour of this tile
	 */
	public boolean getColour() {
		return this.colour;
	}

	/**
	 * @param aColour - colour being set to this tile
	 */
	public void setColour(boolean aColour) {
		this.colour = aColour;
	}

	/**
	 * @return the number of this tile
	 */
	public int getNumber() {
		return this.number;
	}

	/**
	 * @param aNumber - number being set to this tile
	 */
	public void setNumber(int aNumber) {
		this.number = aNumber;
	}

	/**
	 * @return the letter of this tile
	 */
	public int getLetter() {
		return this.letter;
	} 

	/**
	 * @param aLetter - letter being set to this tile
	 */
	public void setLetter(int aLetter) {
		this.letter = aLetter;
	}

	/**
	 * @return the piece of this tile
	 */
	public Piece getPiece() {
		return this.piece;
	}

	/**
	 * @param aPiece - piece being set to this tile
	 */
	public void setPiece(Piece aPiece) {
		this.piece = aPiece;
	}
	
	/**
	 * @return if this tile is selected
	 */
	public boolean getSelected()
	{
		return this.selected;
	}
	
	/**
	 * @param selected - if this tile is selected
	 */
	public void setSelected(boolean selected)
	{
		this.selected = selected;
	}
	
	/**
	 * @return if this tile is attacked
	 */
	public boolean getAttacked()
	{
		return this.attacked;
	}
	
	/**
	 * @param attacked - if this tile is attacked
	 */
	public void setAttacked(boolean attacked)
	{
		this.attacked = attacked;
	}
	
	/**
	 * @return if this tile is accessed
	 */
	public boolean getAccessed()
	{
		return this.accessed;
	}
	
	/**
	 * @param accessed - if this tile is accessed
	 */
	public void setAccessed(boolean accessed)
	{
		this.accessed = accessed;
	}
	
	/**
	 * @return the segment
	 */
	public Segment getSegment() {
		return segment;
	}
	/**
	 * @param segment - used to set segment
	 */
	public void setSegment(Segment segment) {
		this.segment = segment;
	}
}