package threePlayerChessa;

/**  
 *The Click class is used to transmit the information about which tile the user
 *has clicked from the view to the model.
 */
public class Click {
	private int num; //the number coordinate of the click
	private int let; //the letter coordinate of the click
		
	/**
	 * Click constructor
	 * @param num - the number coordinate
	 * @param let - the letter coordinate
	 */
	public Click(int num, int let) {
		super();
		this.num = num;
		this.let = let;
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}
	/**
	 * @param num - used to set num
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * @return the let
	 */
	public int getLet() {
		return let;
	}
	/**
	 * @param let - used to set let
	 */
	public void setLet(int let) {
		this.let = let;
	}
}
