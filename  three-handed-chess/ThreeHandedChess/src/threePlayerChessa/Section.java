package threePlayerChessa;

import java.util.Vector;
import threePlayerChessa.Segment;

public class Section {
	int maxNum;
	int minNum;
	int maxLet1;
	int minLet1;
	int maxLet2;
	int minLet2;	
	private Team colour;
	public Board theBoard;	
	public Vector<Segment> segments = new Vector<Segment>();

	public Segment getSection1() {
		return this.segments.elementAt(0);
	}

	public void setSection1(Segment aSegment1) {
		this.segments.remove(0);
		this.segments.add(aSegment1);
	}

	public Segment getSection2() {
		return this.segments.elementAt(1);
	}

	public void setSection2(Segment aSegment2) {
		this.segments.remove(1);
		this.segments.add(aSegment2);
	}

	public Team getColour() {
		return this.colour;
	}

	public void setColour(Team aColour) {
		this.colour = aColour;
	}

	public Section(int maxNum, int minNum, int maxLet1, int minLet1,
			int maxLet2, int minLet2, Team colour, Board theBoard) {
		super();
		this.maxNum = maxNum;
		this.minNum = minNum;
		this.maxLet1 = maxLet1;
		this.minLet1 = minLet1;
		this.maxLet2 = maxLet2;
		this.minLet2 = minLet2;
		this.colour = colour;
		this.theBoard = theBoard;
		Segment temp1 = new Segment(maxNum,minNum,maxLet1,minLet1,this); //Left segment
		segments.add(0, temp1);
		Segment temp2 = new Segment(maxNum,minNum,maxLet2,minLet2,this); //right segment
		segments.add(1, temp2);
	}


	
}