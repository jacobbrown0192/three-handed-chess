package threePlayerChessa;

public class Tile {
	private boolean colour;
	private int number;
	private int letter;
	private Piece piece;
	public Segment segment;

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

	public Tile(boolean aColour, int aNum, int aLet, Piece aPiece) {
		setColour(aColour);
		setNumber(aNum);
		setLetter(aLet);
		setPiece(aPiece);
	}
}