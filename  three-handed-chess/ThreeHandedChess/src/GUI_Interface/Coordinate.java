package GUI_Interface;


public class Coordinate
{
	public double x;
	public double y;
	
    public static Coordinate[] CoordinateSet(int size)
    {
        Coordinate[] array = new Coordinate[size];
        for(int i=0; i<size; i++)
            array[i] = new Coordinate();
        return array;
    }
    
    public void setX (double x)
    {
    	this.x = x;
    }
    
    public void setLocation (Coordinate[] array, int indexA, int indexB)
    {
    	int index = (indexA + indexB)/2;
    	array[index].x = (array[indexA].x + array[indexB].x)/2;
    	array[index].y = (array[indexA].y + array[indexB].y)/2;
    }
    
    public void setSection (Coordinate[] section)
    {
		section[0].setLocation(section, 0, 20);
		section[0].setLocation(section, 0, 10);
		section[0].setLocation(section, 10, 20);
		
		section[0].setLocation(section, 4, 24);
		section[0].setLocation(section, 4, 14);
		section[0].setLocation(section, 14, 24);
		
		section[0].setLocation(section, 0, 4);
		section[0].setLocation(section, 0, 2);
		section[0].setLocation(section, 2, 4);
		
		section[0].setLocation(section, 5, 9);
		section[0].setLocation(section, 5, 7);
		section[0].setLocation(section, 7, 9);
		
		section[0].setLocation(section, 10, 14);
		section[0].setLocation(section, 10, 12);
		section[0].setLocation(section, 12, 14);
		
		section[0].setLocation(section, 15, 19);
		section[0].setLocation(section, 15, 17);
		section[0].setLocation(section, 17, 19);
		
		section[0].setLocation(section, 20, 24);
		section[0].setLocation(section, 20, 22);
		section[0].setLocation(section, 22, 24);
    }
}