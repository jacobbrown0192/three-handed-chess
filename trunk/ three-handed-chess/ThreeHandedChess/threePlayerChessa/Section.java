package threePlayerChessa;

import java.util.Vector;
import threePlayerChessa.Segment;

public class Section {
	private Segment _segment1;
	private Segment _segment2;
	private Team _colour;
	public Board _unnamed_Board_;
	public Vector<Segment> _unnamed_Segment_ = new Vector<Segment>();

	public Segment getSegment1() {
		return this._segment1;
	}

	public void setSegment1(Segment aSegment1) {
		this._segment1 = aSegment1;
	}

	public Segment getSegment2() {
		return this._segment2;
	}

	public void setSegment2(Segment aSegment2) {
		this._segment2 = aSegment2;
	}

	public Team getColour() {
		return this._colour;
	}

	public void setColour(Team aColour) {
		this._colour = aColour;
	}

	public Section(Segment aSeg1, Segement aSeg2) {
		throw new UnsupportedOperationException();
	}
}