package threePlayerChessa;

import java.util.Vector;
import threePlayerChessa.Segment;

public class Section {
	private Segment segment1;
	private Segment segment2;
	private Team colour;
	public Board unnamedBoard;
	public Vector<Segment> unnamedSegment = new Vector<Segment>();

	public Segment getSegment1() {
		return this.segment1;
	}

	public void setSegment1(Segment aSegment1) {
		this.segment1 = aSegment1;
	}

	public Segment getSegment2() {
		return this.segment2;
	}

	public void setSegment2(Segment aSegment2) {
		this.segment2 = aSegment2;
	}

	public Team getColour() {
		return this.colour;
	}

	public void setColour(Team aColour) {
		this.colour = aColour;
	}

	public Section(Segment aSeg1, Segment aSeg2) {
		
	}
}