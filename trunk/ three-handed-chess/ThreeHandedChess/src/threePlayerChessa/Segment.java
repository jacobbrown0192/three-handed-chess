package threePlayerChessa;

import java.util.Vector;
import threePlayerChessa.Tile;

/**  
 *The Segment class is the class which contains all the tiles. 
 *Splitting up the board makes it more manageable 
 */
public class Segment {
	int maxNum;
	int minNum;
	int maxLet;
	int minLet;
	Section section;
	public Vector<Tile> tiles = new Vector<Tile>();

	
	/**
	 * Segment constructor
	 * @param maxNum - Maximum identifier number 
	 * @param minNum - Minimum identifier number
	 * @param maxLet - Maximum identifier number
	 * @param minLet - Minimum identifier number
	 * @param section - the board which this section belongs too
	 */
	public Segment(int maxNum, int minNum, int maxLet, int minLet,
			Section section) {
		super();
		this.maxNum = maxNum;
		this.minNum = minNum;
		this.maxLet = maxLet;
		this.minLet = minLet;
		this.section = section;
		boolean colour = true;
		//all segments are created by starting at the lowest number and letter 
		//and increasing letters then numbers
		//for one segment it is set up differently and starts on a white space
		if(maxNum == 12 && maxLet == 12){
		colour = !colour;
			for( int i = minNum; i<=maxNum; i++){
				colour = !colour;
				for(int j = minLet; j<=maxLet; j++){
					Tile temp = new Tile(colour,i,j,null, false, false, false);
					this.tiles.add(temp);
					colour = !colour;
				}
			}
		}
		//all other segments start on a black space
		else{
			for( int i = minNum; i<=maxNum; i++){
				colour = !colour;
				for(int j = minLet; j<=maxLet; j++){
					Tile temp = new Tile(colour,i,j,null, false, false, false);
					this.tiles.add(temp);
					colour = !colour;
				}
			}
		}
	}

	/**
	 * @return the tile chosen
	 */
	public Tile getTiles(int num) {
		return this.tiles.elementAt(num);
	}
}