package threePlayerChessa;

import java.util.Vector;
import threePlayerChessa.Section;
import threePlayerChessa.Piece;

public class Board {
	private Section section1;
	private Section section2;
	private Section section3;
	public Main unnamed_Main_;
	public Menu unnamed_Menu_;
	public Vector<Section> sections = new Vector<Section>();
	public Vector<Piece> unnamed_Piece_ = new Vector<Piece>();

	public Section getSection1() {
		return this.section1;
	}

	public void setSection1(Section aSection1) {
		this.section1 = aSection1;
	}

	public Section getSection2() {
		return this.section2;
	}

	public void setSection2(Section aSection2) {
		this.section2 = aSection2;
	}

	public Section getSection3() {
		return this.section3;
	}

	public void setSection3(Section aSection3) {
		this.section3 = aSection3;
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