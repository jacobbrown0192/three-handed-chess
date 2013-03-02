package threePlayerChessa;

public class Tile {
	private boolean _colour;
	private int _number;
	private Alphabet _letter;
	private Piece _piece;
	public Segment _unnamed_Segment_;
	public Piece _unnamed_Piece_;

	public boolean getColour() {
		return this._colour;
	}

	public void setColour(boolean aColour) {
		this._colour = aColour;
	}

	public int getNumber() {
		return this._number;
	}

	public void setNumber(int aNumber) {
		this._number = aNumber;
	}

	public Alphabet getLetter() {
		return this._letter;
	}

	public void setLetter(Alphabet aLetter) {
		this._letter = aLetter;
	}

	public Piece getPiece() {
		return this._piece;
	}

	public void setPiece(Piece aPiece) {
		this._piece = aPiece;
	}

	public Tile(boolean aColour, int aNum, Alphabet aLet, Piece aPiece) {
		throw new UnsupportedOperationException();
	}
}