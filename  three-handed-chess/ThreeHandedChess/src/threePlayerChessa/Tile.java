package threePlayerChessa;

public class Tile {
	private boolean colour;
	private int number;
	private int letter;
	private int num2;
	private int let2;
	private Piece piece;
	public Segment segment;
	private boolean selected;

	Tile up,down,left,right,downleft,downright,upleft,upright,hop,specialup,specialdown,specialleft,specialright;
	
	

	private boolean attacked;
	private boolean accessed;


	public boolean getColour() {
		return this.colour;
	}

	public void setColour(boolean aColour) {
		this.colour = aColour;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int aNumber) {
		this.number = aNumber;
	}

	public int getLetter() {
		return this.letter;
	} 

	public void setLetter(int aLetter) {
		this.letter = aLetter;
	}

	public Piece getPiece() {
		return this.piece;
	}

	public void setPiece(Piece aPiece) {
		this.piece = aPiece;
	}
	
	public boolean getSelected()
	{
		return this.selected;
	}
	
	public void setSelected(boolean selected)
	{
		this.selected = selected;
	}

	/**
	 * @return the num2
	 */
	public int getNum2() {
		return num2;
	}

	/**
	 * @param num2 - used to set num2
	 */
	public void setNum2(int num2) {
		this.num2 = num2;
	}

	/**
	 * @return the let2
	 */
	public int getLet2() {
		return let2;
	}

	/**
	 * @param let2 - used to set let2
	 */
	public void setLet2(int let2) {
		this.let2 = let2;
	}

	
	public boolean getAttacked()
	{
		return this.attacked;
	}
	
	public void setAttacked(boolean attacked)
	{
		this.attacked = attacked;
	}
	
	public boolean getAccessed()
	{
		return this.accessed;
	}
	
	public void setAccessed(boolean accessed)
	{
		this.accessed = accessed;
	}
	


	public Tile(boolean aColour, int aNum, int aLet, Piece aPiece, boolean selected, boolean attacked, boolean accessed) {
		setColour(aColour);
		setNumber(aNum);
		setLetter(aLet);
		setPiece(aPiece);
		setSelected(selected);
		setAttacked(attacked);
		setAccessed(accessed);
	}
}