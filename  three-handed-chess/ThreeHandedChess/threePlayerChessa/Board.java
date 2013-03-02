package threePlayerChessa;

import java.util.Vector;
import threePlayerChessa.Section;
import threePlayerChessa.Piece;

public class Board {
	private Section _section1;
	private Section _section2;
	private Section _section3;
	public Main _unnamed_Main_;
	public Menu _unnamed_Menu_;
	public Vector<Section> _sections = new Vector<Section>();
	public Vector<Piece> _unnamed_Piece_ = new Vector<Piece>();

	public Section getSection1() {
		return this._section1;
	}

	public void setSection1(Section aSection1) {
		this._section1 = aSection1;
	}

	public Section getSection2() {
		return this._section2;
	}

	public void setSection2(Section aSection2) {
		this._section2 = aSection2;
	}

	public Section getSection3() {
		return this._section3;
	}

	public void setSection3(Section aSection3) {
		this._section3 = aSection3;
	}

	public void update() {
		throw new UnsupportedOperationException();
	}

	public void reset() {
		throw new UnsupportedOperationException();
	}

	public Board() {
		throw new UnsupportedOperationException();
	}
}