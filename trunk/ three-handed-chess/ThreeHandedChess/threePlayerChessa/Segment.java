package threePlayerChessa;

import java.util.Vector;
import threePlayerChessa.Tile;

public class Segment {
	private Tile[][] _segment;
	public Section _unnamed_Section_;
	public Vector<Tile> _unnamed_Tile_ = new Vector<Tile>();

	public Segment(Tile[][] aTiles) {
		throw new UnsupportedOperationException();
	}

	public Tile[][] getSegment() {
		return this._segment;
	}

	public void setSegment(Tile[][] aSegment) {
		this._segment = aSegment;
	}
}