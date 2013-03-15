package GUI_Interface;

/** Simple two integer class for handling points of the hexagonal board.
 * <p>Used by BoardGUI to set and access the points of the tile vertices.
 */
public class CoordinateGUI
{
	private static final long serialVersionUID = 1L;
	public double x;
	public double y;
	
	/** Default empty constructor.
	 */
	public CoordinateGUI() {}
	
	/** Constructor to create new CoordinateGUI.
	 * 
	 * @param x X value of coordinate
	 * @param y Y value of coordinate
	 */
    public CoordinateGUI(int x, int y)
    {
    	this.x = x;
    	this.y = y;
	}

    /** Method to expedite the initialization of an array of CoordinateGUIs
     * 
     * @param size The number of elements of the array.
     * @return The initialized array of CoordinateGUIs.
     */
	public static CoordinateGUI[] coordinateSet(int size)
    {
        CoordinateGUI[] array = new CoordinateGUI[size];
        for(int i=0; i<size; i++)
            array[i] = new CoordinateGUI();
        return array;
    }
    
	/** Method to set the x and y value of the coordinate at the center of
	 * two other coordinates.
	 * 
	 * <p>Determines the index of the coordinate be set by averaging <code>indexA</code>
	 * and <code>indexB</code>
	 * <p>Determines the x coordinate of the new coordinate by averaging A's and B's x coordinates.
	 * <p>Determines the y coordinate of the new coordinate by averaging A's and B's y coordinates.
	 * 
	 * @param array Array of coordinates being passed in.
	 * @param indexA Index of the first coordinate being used to set the new index coordinate.
	 * @param indexB Index of the second coordinate being used to set the new index coordinate.
	 */
    public void setLocation (CoordinateGUI[] array, int indexA, int indexB)
    {
    	int index = (indexA + indexB)/2;
    	array[index].x = (array[indexA].x + array[indexB].x)/2;
    	array[index].y = (array[indexA].y + array[indexB].y)/2;
    }
    
    /** Sets the coordinates of every tile vertex in a hexarant having previously
     * calculated the coordinates of the four corners of the hexarant.
     * 
     * <p>Sets the coordinates for the outer two columns of the hexarant.
     * <p>Next, it sets the coordinates for the inner three columns of the hexarant, row by row.
     * 
     * @param hexarant Segment of the board whose coordinates are being calculated.
     */
    public void setHexarant (CoordinateGUI[] hexarant)
    {
		hexarant[0].setLocation(hexarant, 0, 20);
		hexarant[0].setLocation(hexarant, 0, 10);
		hexarant[0].setLocation(hexarant, 10, 20);
		
		hexarant[0].setLocation(hexarant, 4, 24);
		hexarant[0].setLocation(hexarant, 4, 14);
		hexarant[0].setLocation(hexarant, 14, 24);
		
		hexarant[0].setLocation(hexarant, 0, 4);
		hexarant[0].setLocation(hexarant, 0, 2);
		hexarant[0].setLocation(hexarant, 2, 4);
		
		hexarant[0].setLocation(hexarant, 5, 9);
		hexarant[0].setLocation(hexarant, 5, 7);
		hexarant[0].setLocation(hexarant, 7, 9);
		
		hexarant[0].setLocation(hexarant, 10, 14);
		hexarant[0].setLocation(hexarant, 10, 12);
		hexarant[0].setLocation(hexarant, 12, 14);
		
		hexarant[0].setLocation(hexarant, 15, 19);
		hexarant[0].setLocation(hexarant, 15, 17);
		hexarant[0].setLocation(hexarant, 17, 19);
		
		hexarant[0].setLocation(hexarant, 20, 24);
		hexarant[0].setLocation(hexarant, 20, 22);
		hexarant[0].setLocation(hexarant, 22, 24);
    }
}