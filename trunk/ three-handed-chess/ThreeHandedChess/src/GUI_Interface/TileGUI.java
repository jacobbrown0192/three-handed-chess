package GUI_Interface;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TileGUI
{
	private static final long serialVersionUID = 1L;
	public Polygon poly;
	public CoordinateGUI tileCenter;
	public int number;
	public String section;
	
	public int boardNumber;
	public int boardLetter;

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

	public void setTile(Polygon poly, String section, int number, CoordinateGUI tileCenter)
	{
		this.poly = poly;
		this.section = section;
		this.number = number;
		this.tileCenter = tileCenter;
	}
	
	public void convertCoordinateSystem(TileGUI tile)
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
}
