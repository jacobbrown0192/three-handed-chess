package threePlayerChessa;

import java.util.Vector;
import threePlayerChessa.Piece;

public class Team {
	private int colour;
	private String name;
	private move[] moveList;
	private int number;
	public Main unnamedMain;
	public Menu unnamedMenu;
	public Vector<Piece> pieces = new Vector<Piece>();

	public int getColour() {
		return this.colour;
	}

	public void setColour(int aColour) {
		this.colour = aColour;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String aName) {
		this.name = aName;
	}

	public Team() {
		throw new UnsupportedOperationException();
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int aNumber) {
		this.number = aNumber;
	}
}