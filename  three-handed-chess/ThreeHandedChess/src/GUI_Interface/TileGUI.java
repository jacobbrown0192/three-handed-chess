package GUI_Interface;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/** Class for the containment of the polygon, and indexing systems
 * (Graphical and Model) a tile
 */
public class TileGUI
{
	private static final long serialVersionUID = 1L;
	private Polygon poly;
	private int number;
	private String hexarant;
	private int boardNumber;
	private int boardLetter;
	
	public String getHexarant()
	{
		return hexarant;
	}
	
	public int getBoardLetter()
	{
		return boardLetter;
	}

	public int getBoardNumber() 
	{
		return boardNumber;
	}
	
    /** Method to expedite the initialization of an array of TileGUIs
     * 
     * @param size The number of elements of the array.
     * @return The initialized array of TileGUIs.
     */
	public static TileGUI[] tileSet(int size)
	{
		TileGUI[] array = new TileGUI[size];
		for(int i=0; i < size; i++)
		{
			array[i] = new TileGUI();
		}
		return array;
	}

	/** Method to set the polygon, hexarant, number, boardNumber, and boardLetter of the tile.
	 * 
	 * <p>boardNumber is the number file of the tile as referenced by the model.
	 * <p>boardLetter is an int from 1 to 12 used to represent A to L respectively
	 * which gives the letter file of the tile as referenced by the model.
	 * <p>The difference of indexing systems is due to the simplicity of breaking
	 * the board into 6 4x4 "Hexarants" for graphical purposes, but the convention
	 * of number and letter files being used to call and record game moves in chess.
	 * 
	 * @param poly The polygon which defines the limits of the tile.
	 * @param hexarant A string which indicates which 4x4 tile grid the tile belongs to.
	 * Named for the hexagonal equivalent of a quadrilaterals "quadrants".
	 * @param number An integer whose value is the index of the tile inside it's hexarant.
	 */
	public void setTile(Polygon poly, String hexarant, int number)
	{
		this.poly = poly;
		this.hexarant = hexarant;
		this.number = number;
		this.boardNumber = setBoardNumberThroughConversion(this.hexarant, this.number);
		this.boardLetter = setBoardLetterThroughConversion(this.hexarant, this.number);
	}
	
	/** Method to convert the graphical tile indexing system into the model tile indexing system.
	 * 
	 * @param hexarant A string which indicates which 4x4 tile grid the tile belongs to.
	 * @param number An integer whose value is the index of the tile inside it's hexarant.
	 * @return The number file of the tile.
	 */
	public int setBoardNumberThroughConversion(String hexarant, int number)
	{
		int boardNumber = 100;
		
		switch (hexarant)
		{
			case "a":				
				if(number%4 == 0)
				{
					boardNumber = 8;
				}
				else if(number%4 == 1)
				{
					boardNumber = 7;
				}
				else if(number%4 == 2)
				{
					boardNumber = 6;
				}
				else if(number%4 == 3)
				{
					boardNumber = 5;
				}
				break;
			case "b":
				if(number%4 == 0)
				{
					boardNumber = 9;
				}
				else if(number%4 == 1)
				{
					boardNumber = 10;
				}
				else if(number%4 == 2)
				{
					boardNumber = 11;
				}
				else if(number%4 == 3)
				{
					boardNumber = 12;
				}
				break;
			case "c":
				if(number%4 == 0)
				{
					boardNumber = 9;
				}
				else if(number%4 == 1)
				{
					boardNumber = 10;
				}
				else if(number%4 == 2)
				{
					boardNumber = 11;
				}
				else if(number%4 == 3)
				{
					boardNumber = 12;
				}
				break;
			case "d":
				if(number < 4)
				{
					boardNumber = 4;
				}
				else if(number < 8)
				{
					boardNumber = 3;
				}
				else if(number < 12)
				{
					boardNumber = 2;
				}
				else if(number < 16)
				{
					boardNumber = 1;
				}
				break;
			case "e":
				if(number < 4)
				{
					boardNumber = 4;
				}
				else if(number < 8)
				{
					boardNumber = 3;
				}
				else if(number < 12)
				{
					boardNumber = 2;
				}
				else if(number < 16)
				{
					boardNumber = 1;
				}
				break;
			case "f":
				if(number < 4)
				{
					boardNumber = 8;
				}
				else if(number < 8)
				{
					boardNumber = 7;
				}
				else if(number < 12)
				{
					boardNumber = 6;
				}
				else if(number < 16)
				{
					boardNumber = 5;
				}
				break;
		}
		return boardNumber;
	}
	
	/** Method to convert the graphical tile indexing system into the model tile indexing system.
	 * 
	 * @param hexarant A string which indicates which 4x4 tile grid the tile belongs to.
	 * @param number An integer whose value is the index of the tile inside it's hexarant.
	 * @return The letter file of the tile.
	 */
	public int setBoardLetterThroughConversion(String hexarant, int number)
	{
		int boardLetter = 100;
		switch (hexarant)
		{
			case "a":
				if(number < 4)
				{
					boardLetter = 12;
				}
				else if(number < 8)
				{
					boardLetter = 11;
				}
				else if(number < 12)
				{
					boardLetter = 10;
				}
				else if(number < 16)
				{
					boardLetter = 9;
				}
				break;
			case "b":
				if(number < 4)
				{
					boardLetter = 12;
				}
				else if(number < 8)
				{
					boardLetter = 11;
				}
				else if(number < 12)
				{
					boardLetter = 10;
				}
				else if(number < 16)
				{
					boardLetter = 9;
				}
				break;
			case "c":
				if(number < 4)
				{
					boardLetter = 5;
				}
				else if(number < 8)
				{
					boardLetter = 6;
				}
				else if(number < 12)
				{
					boardLetter = 7;
				}
				else if(number < 16)
				{
					boardLetter = 8;
				}
				break;
			case "d":				
				if(number%4 == 0)
				{
					boardLetter = 5;
				}
				else if(number%4 == 1)
				{
					boardLetter = 6;
				}
				else if(number%4 == 2)
				{
					boardLetter = 7;
				}
				else if(number%4 == 3)
				{
					boardLetter = 8;
				}
				break;
			case "e":				
				if(number%4 == 0)
				{
					boardLetter = 1;
				}
				else if(number%4 == 1)
				{
					boardLetter = 2;
				}
				else if(number%4 == 2)
				{
					boardLetter = 3;
				}
				else if(number%4 == 3)
				{
					boardLetter = 4;
				}
				break;
			case "f":				
				if(number%4 == 0)
				{
					boardLetter = 1;
				}
				else if(number%4 == 1)
				{
					boardLetter = 2;
				}
				else if(number%4 == 2)
				{
					boardLetter = 3;
				}
				else if(number%4 == 3)
				{
					boardLetter = 4;
				}
				break;
		}
		return boardLetter;
	}

	/** Checks if the click was inside the polygon whose boundaries define this tile.
	 * 
	 * @param e Mouse event for the click.
	 * @return <code>true</code> if inside polygon,
	 * <code>false</code> otherwise.
	 */
	public boolean checkIfContained(MouseEvent e) 
	{
		if(poly.contains(e.getPoint()))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
}
