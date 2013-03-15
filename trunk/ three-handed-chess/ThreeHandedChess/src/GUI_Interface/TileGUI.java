package GUI_Interface;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/** 
 * 
 * 
 *
 */
public class TileGUI
{
	private static final long serialVersionUID = 1L;
	private Polygon poly;
	private int number;
	private String section;
	
	private int boardNumber;
	private int boardLetter;

	public static TileGUI[] tileSet(int size)
	{
		TileGUI[] array = new TileGUI[size];
		for(int i=0; i < size; i++)
		{
			array[i] = new TileGUI();
		}
		return array;
	}
	
	public String getSection()
	{
		return section;
	}

	public void setTile(Polygon poly, String section, int number)
	{
		this.poly = poly;
		this.section = section;
		this.number = number;
		this.boardNumber = setBoardNumberThroughConversion(this.section, this.number);
		this.boardLetter = setBoardLetterThroughConversion(this.section, this.number);
	}
	
	public int setBoardNumberThroughConversion(String section, int number)
	{
		int boardNumber = 100;
		
		switch (section)
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
	
	public int setBoardLetterThroughConversion(String section, int number)
	{
		int boardLetter = 100;
		switch (section)
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
	
	public void convertCoordinateToModelSystem(TileGUI tile)
	{
		switch (tile.section)
		{
			case "a":
				if(tile.number < 4)
				{
					tile.boardLetter = 12;
				}
				else if(tile.number < 8)
				{
					tile.boardLetter = 11;
				}
				else if(tile.number < 12)
				{
					tile.boardLetter = 10;
				}
				else if(tile.number < 16)
				{
					tile.boardLetter = 9;
				}
				
				if(tile.number%4 == 0)
				{
					tile.boardNumber = 8;
				}
				else if(tile.number%4 == 1)
				{
					tile.boardNumber = 7;
				}
				else if(tile.number%4 == 2)
				{
					tile.boardNumber = 6;
				}
				else if(tile.number%4 == 3)
				{
					tile.boardNumber = 5;
				}
				break;
			case "b":
				if(tile.number < 4)
				{
					tile.boardLetter = 12;
				}
				else if(tile.number < 8)
				{
					tile.boardLetter = 11;
				}
				else if(tile.number < 12)
				{
					tile.boardLetter = 10;
				}
				else if(tile.number < 16)
				{
					tile.boardLetter = 9;
				}
				
				if(tile.number%4 == 0)
				{
					tile.boardNumber = 9;
				}
				else if(tile.number%4 == 1)
				{
					tile.boardNumber = 10;
				}
				else if(tile.number%4 == 2)
				{
					tile.boardNumber = 11;
				}
				else if(tile.number%4 == 3)
				{
					tile.boardNumber = 12;
				}
				break;
			case "c":
				if(tile.number < 4)
				{
					tile.boardLetter = 5;
				}
				else if(tile.number < 8)
				{
					tile.boardLetter = 6;
				}
				else if(tile.number < 12)
				{
					tile.boardLetter = 7;
				}
				else if(tile.number < 16)
				{
					tile.boardLetter = 8;
				}
				
				if(tile.number%4 == 0)
				{
					tile.boardNumber = 9;
				}
				else if(tile.number%4 == 1)
				{
					tile.boardNumber = 10;
				}
				else if(tile.number%4 == 2)
				{
					tile.boardNumber = 11;
				}
				else if(tile.number%4 == 3)
				{
					tile.boardNumber = 12;
				}
				break;
			case "d":
				if(tile.number < 4)
				{
					tile.boardNumber = 4;
				}
				else if(tile.number < 8)
				{
					tile.boardNumber = 3;
				}
				else if(tile.number < 12)
				{
					tile.boardNumber = 2;
				}
				else if(tile.number < 16)
				{
					tile.boardNumber = 1;
				}
				
				if(tile.number%4 == 0)
				{
					tile.boardLetter = 5;
				}
				else if(tile.number%4 == 1)
				{
					tile.boardLetter = 6;
				}
				else if(tile.number%4 == 2)
				{
					tile.boardLetter = 7;
				}
				else if(tile.number%4 == 3)
				{
					tile.boardLetter = 8;
				}
				break;
			case "e":
				if(tile.number < 4)
				{
					tile.boardNumber = 4;
				}
				else if(tile.number < 8)
				{
					tile.boardNumber = 3;
				}
				else if(tile.number < 12)
				{
					tile.boardNumber = 2;
				}
				else if(tile.number < 16)
				{
					tile.boardNumber = 1;
				}
				
				if(tile.number%4 == 0)
				{
					tile.boardLetter = 1;
				}
				else if(tile.number%4 == 1)
				{
					tile.boardLetter = 2;
				}
				else if(tile.number%4 == 2)
				{
					tile.boardLetter = 3;
				}
				else if(tile.number%4 == 3)
				{
					tile.boardLetter = 4;
				}
				break;
			case "f":
				if(tile.number < 4)
				{
					tile.boardNumber = 8;
				}
				else if(tile.number < 8)
				{
					tile.boardNumber = 7;
				}
				else if(tile.number < 12)
				{
					tile.boardNumber = 6;
				}
				else if(tile.number < 16)
				{
					tile.boardNumber = 5;
				}
				
				if(tile.number%4 == 0)
				{
					tile.boardLetter = 1;
				}
				else if(tile.number%4 == 1)
				{
					tile.boardLetter = 2;
				}
				else if(tile.number%4 == 2)
				{
					tile.boardLetter = 3;
				}
				else if(tile.number%4 == 3)
				{
					tile.boardLetter = 4;
				}
				break;
		}
	}

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

	public int getBoardLetter()
	{
		return boardLetter;
	}

	public int getBoardNumber() 
	{
		return boardNumber;
	}
}
