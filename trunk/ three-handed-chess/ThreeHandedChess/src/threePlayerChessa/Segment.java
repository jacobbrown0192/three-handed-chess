package threePlayerChessa;

import java.util.Vector;
import threePlayerChessa.Tile;

public class Segment {
	private Tile[][] segment;
	public Section unnamed_Section_;
	public Vector<Tile> unnamed_Tile_ = new Vector<Tile>();

	public Segment(Tile[][] aTiles) {
		throw new UnsupportedOperationException();
	}

	public Tile[][] getSegment() {
		return this.segment;
	}

	public void setSegment(Tile[][] aSegment) {
		this.segment = aSegment;
	}
}