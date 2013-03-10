package threePlayerChessa;

import java.util.Vector;
import threePlayerChessa.Tile;

public class Segment {
	int maxNum;
	int minNum;
	int maxLet;
	int minLet;
	Section section;
	public Vector<Tile> tiles = new Vector<Tile>();

	public Segment(int maxNum, int minNum, int maxLet, int minLet,
			Section section) {
		super();
		this.maxNum = maxNum;
		this.minNum = minNum;
		this.maxLet = maxLet;
		this.minLet = minLet;
		this.section = section;
		boolean colour = true;
		if(maxNum == 12 && maxLet == 12){
		colour = !colour;
			for( int i = minNum; i<=maxNum; i++){
				colour = !colour;
				for(int j = minLet; j<=maxLet; j++){
					Tile temp = new Tile(colour,i,j,null);
					this.tiles.add(temp);
					colour = !colour;
				}
			}
		}
		else{
			for( int i = minNum; i<=maxNum; i++){
				colour = !colour;
				for(int j = minLet; j<=maxLet; j++){
					Tile temp = new Tile(colour,i,j,null);
					this.tiles.add(temp);
					colour = !colour;
				}
			}
		}
	}

	public Tile getTiles(int num) {
		return this.tiles.elementAt(num);
	}

	public void setSegment(Tile aTile) {
		//this.tiles.remove(aTile);
		this.tiles.add(aTile);
	}
}