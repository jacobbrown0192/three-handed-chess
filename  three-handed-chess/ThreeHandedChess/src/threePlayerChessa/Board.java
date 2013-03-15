package threePlayerChessa;

import java.util.Vector;
import threePlayerChessa.Section;
import threePlayerChessa.Piece;


/**  
 *The Board class is the class which contains all the sections, segments, and tiles. 
 *It is also used to tell where everything goes
 */
public class Board {
	public Vector<Section> sections = new Vector<Section>();
	public Vector<Piece> pieces = new Vector<Piece>();
	public Vector<Team> gameTeams = new Vector<Team>();
	
	/**  
	 * @return Section at 0
	 */
	public Section getSection0() {
		return this.sections.elementAt(0);
	}

	/**  
	 * @param aSection0 - used to set sections
	 */
	public void setSection0(Section aSection0) {
		this.sections.remove(0);
		this.sections.add(aSection0);
	}

	/**  
	 * @return Section at 1
	 */
	public Section getSection1() {
		return this.sections.elementAt(1);
	}
	
	/**  
	 * @param aSection1 - used to set sections
	 */
	public void setSection1(Section aSection1) {
		this.sections.remove(1);
		this.sections.add(aSection1);
	}
	
	/**  
	 * @return Section at 2
	 */
	public Section getSection2() {
		return this.sections.elementAt(2);
	}

	/**  
	 * @param aSection2 - used to set sections
	 */
	public void setSection2(Section aSection2) {
		this.sections.remove(2);
		this.sections.add(aSection2);
	}

	//might not be necessary 
	public void addPiece(Piece aPiece){
		pieces.add(aPiece);
	}
	
/*	public void update() {
		throw new UnsupportedOperationException();
	}*/

	/**  
	 * Resets the board to blank(no pieces);
	 * @return	null
	 */
	public void reset() {
		pieces.clear();
		for( int i = 0; i<3; i++){
			for(int j = 0; j<2; j++){
				for(int k =0; k<16; k++){
					this.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).setPiece(null);
				}
			}
		}
	}

	/**  
	 * Board constructor
	 * @param 	gameTeams - the teams playing the game
	 * @return	null
	 * 
	 * Constructs each section clockwise
	 */
	public Board(Vector<Team> gameTeams) {
		this.gameTeams = gameTeams;
		Section temp1 = new Section(4,1,4,1,8,5,gameTeams.elementAt(0),this);// bottom section
		sections.add(0, temp1);
		Section temp2 = new Section(8,5,12,9,4,1,gameTeams.elementAt(1),this);// left section
		sections.add(1, temp2);
		Section temp3 = new Section(12,9,8,5,12,9,gameTeams.elementAt(2),this);// right section
		sections.add(2, temp3);
	}


}