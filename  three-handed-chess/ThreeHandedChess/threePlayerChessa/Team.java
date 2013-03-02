package threePlayerChessa;

import java.util.Vector;
import threePlayerChessa.Piece;

public class Team {
	private int _colour;
	private String _name;
	private move[] _moveList;
	private int _number;
	public Main _unnamed_Main_;
	public Menu _unnamed_Menu_;
	public Vector<Piece> _pieces = new Vector<Piece>();

	public int getColour() {
		return this._colour;
	}

	public void setColour(int aColour) {
		this._colour = aColour;
	}

	public String getName() {
		return this._name;
	}

	public void setName(String aName) {
		this._name = aName;
	}

	public Team() {
		throw new UnsupportedOperationException();
	}

	public int getNumber() {
		return this._number;
	}

	public void setNumber(int aNumber) {
		this._number = aNumber;
	}
}