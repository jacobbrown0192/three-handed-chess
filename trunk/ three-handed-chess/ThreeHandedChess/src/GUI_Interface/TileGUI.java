package GUI_Interface;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TileGUI
{
	private static final long serialVersionUID = 1L;
	public Polygon poly;
	public int number;
	public String section;

	public static TileGUI[] TileSet(int size)
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
