package threePlayerChessa;

/**  
 *The MoveList class is used to tabulate all the moves made during the game
 *This class will be updated to allow for this
 */
public class MoveList {
	int number;	//the move number coordinate
	int letter; //the move letter coordiante 
	

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param number - used to set number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the letter
	 */
	public int getLetter() {
		return letter;
	}
	/**
	 * @param letter - used to set letter
	 */
	public void setLetter(int letter) {
		this.letter = letter;
	}


	/**
	 * MoveList constructor
	 * @param num - the number coordinate
	 * @param let - the letter coordinate
	 */
	public MoveList(int number, int letter) {
		this.number = number;
		this.letter = letter;
	}
	
}
