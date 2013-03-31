package threePlayerChessa;

import java.util.Vector;
import threePlayerChessa.Segment;


/**  
 *The Section class is the class which contains all the segments, and tiles. 
 *It is also used to help with pawn movement
 * 
 */
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

	public Vector<Segment> getSegments()
	{
		return this.segments;
	}
	
	
	/**  
	 * @return Segment at 0
	 */
	public Segment getSegment0() {
		return this.segments.elementAt(0);
	}

	/**  
	 * @param aSegment0 - used to set segments
	 */
	public void setSegment0(Segment aSegment0) {
		this.segments.remove(0);
		this.segments.add(aSegment0);
	}

	/**  
	 * @return Segment at 1
	 */
	public Segment getSegment1() {
		return this.segments.elementAt(1);
	}
	
	/**  
	 * @param aSegment1 - used to set segments
	 */
	public void setSegment1(Segment aSegment1) {
		this.segments.remove(1);
		this.segments.add(aSegment1);
	}
	
	/**
	 * @return the colour
	 */
	public Team getColour() {
		return colour;
	}

	/**
	 * @param colour - used to set colour
	 */
	public void setColour(Team colour) {
		this.colour = colour;
	}
	
	
	/**
	 * Section constructor
	 * @param maxNum - Maximum identifier number 
	 * @param minNum - Minimum identifier number
	 * @param maxLet1 - Maximum identifier number for left segment
	 * @param minLet1 - Minimum identifier number for left segment
	 * @param maxLet2 - Maximum identifier number for right segment
	 * @param minLet2 - Minimum identifier number for right segment
	 * @param colour - the team which starts off in this section. Used for pawn movement.
	 * @param theBoard - the board which this section belongs too
	 */
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