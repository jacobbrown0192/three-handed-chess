package threePlayerChessa;

import java.util.Vector;
import threePlayerChessa.Tile;

/**  
 *The Segment class is the class which contains all the tiles. 
 *Splitting up the board makes it more manageable 
 */
public class Segment {
	private int maxNum;
	private int minNum;
	private int maxLet;
	private int minLet;
	private Section section;
	private Vector<Tile> tiles = new Vector<Tile>();

	
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
					Tile temp = new Tile(colour,i,j,null, this, false, false, false);
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
					Tile temp = new Tile(colour,i,j,null,this, false, false, false);
					if(maxNum == 12 && maxLet == 8){
					}
					if(maxNum == 8 && maxLet == 12){					
					}
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
	
	public Section getSection()
	{
		return this.section;
	}
	
	public int getMaxNum()
	{
		return this.maxNum;
	}
	
	public int getMaxLet()
	{
		return this.maxLet;
	}

	/**
	 * @return the minNum
	 */
	public int getMinNum() {
		return minNum;
	}

	/**
	 * @param minNum - used to set minNum
	 */
	public void setMinNum(int minNum) {
		this.minNum = minNum;
	}

	/**
	 * @return the minLet
	 */
	public int getMinLet() {
		return minLet;
	}

	/**
	 * @param minLet - used to set minLet
	 */
	public void setMinLet(int minLet) {
		this.minLet = minLet;
	}

	/**
	 * @return the tiles
	 */
	public Vector<Tile> getTiles() {
		return tiles;
	}

	/**
	 * @param tiles - used to set tiles
	 */
	public void setTiles(Vector<Tile> tiles) {
		this.tiles = tiles;
	}

	/**
	 * @param maxNum - used to set maxNum
	 */
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}

	/**
	 * @param maxLet - used to set maxLet
	 */
	public void setMaxLet(int maxLet) {
		this.maxLet = maxLet;
	}

	/**
	 * @param section - used to set section
	 */
	public void setSection(Section section) {
		this.section = section;
	}
	
	
	
}