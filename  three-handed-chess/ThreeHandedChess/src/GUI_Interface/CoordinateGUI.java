package GUI_Interface;

/** Simple two integer class for handling points of the hexagonal board.
 * <p>Used by BoardGUI to set and access the points of the tile vertices.
 */
public class CoordinateGUI
{
	private static final long serialVersionUID = 1L;
	public double x; //Intentionally left public
	public double y; //Intentionally left public
	
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
	public static CoordinateGUI[][] coordinateSet(int widthSize, int depthSize)
	{
		CoordinateGUI[][] array = new CoordinateGUI[widthSize][depthSize];
		for(int i=0; i < widthSize; i++)
		{
			for(int j=0; j < depthSize; j++)
			{
				array[i][j] = new CoordinateGUI();
			}
		}
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
	private void setLocationNew(CoordinateGUI[][] array, int i, int indexA, int indexB)
	{
		int index = (indexA + indexB)/2;
		array[i][index].x = (array[i][indexA].x + array[i][indexB].x)/2;
		array[i][index].y = (array[i][indexA].y + array[i][indexB].y)/2;
	}
    
    /** Sets the coordinates of every tile vertex in a hexarant having previously
     * calculated the coordinates of the four corners of the hexarant.
     * 
     * <p>Sets the coordinates for the outer two columns of the hexarant.
     * <p>Next, it sets the coordinates for the inner three columns of the hexarant, row by row.
     * 
     * @param hexarant Segment of the board whose coordinates are being calculated.
     */
	public void setPoints(CoordinateGUI[][] boardPoints) 
	{
		for (int i=0; i<6; i++)
		{
			boardPoints[0][0].setLocationNew(boardPoints, i, 0, 20);
			boardPoints[0][0].setLocationNew(boardPoints, i, 0, 10);
			boardPoints[0][0].setLocationNew(boardPoints, i, 10, 20);
			
			boardPoints[0][0].setLocationNew(boardPoints, i, 4, 24);
			boardPoints[0][0].setLocationNew(boardPoints, i, 4, 14);
			boardPoints[0][0].setLocationNew(boardPoints, i, 14, 24);
			
			boardPoints[0][0].setLocationNew(boardPoints, i, 0, 4);
			boardPoints[0][0].setLocationNew(boardPoints, i, 0, 2);
			boardPoints[0][0].setLocationNew(boardPoints, i, 2, 4);
			
			boardPoints[0][0].setLocationNew(boardPoints, i, 5, 9);
			boardPoints[0][0].setLocationNew(boardPoints, i, 5, 7);
			boardPoints[0][0].setLocationNew(boardPoints, i, 7, 9);
			
			boardPoints[0][0].setLocationNew(boardPoints, i, 10, 14);
			boardPoints[0][0].setLocationNew(boardPoints, i, 10, 12);
			boardPoints[0][0].setLocationNew(boardPoints, i, 12, 14);
			
			boardPoints[0][0].setLocationNew(boardPoints, i, 15, 19);
			boardPoints[0][0].setLocationNew(boardPoints, i, 15, 17);
			boardPoints[0][0].setLocationNew(boardPoints, i, 17, 19);
			
			boardPoints[0][0].setLocationNew(boardPoints, i, 20, 24);
			boardPoints[0][0].setLocationNew(boardPoints, i, 20, 22);
			boardPoints[0][0].setLocationNew(boardPoints, i, 22, 24);
		}
	}	
}