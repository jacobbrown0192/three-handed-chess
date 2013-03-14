package GUI_Interface;

import java.awt.*;
import javax.swing.JLabel;

public class PieceGUI extends JLabel
{
	private static final long serialVersionUID = 1L;
	private Point tileCenter;
	
	public static PieceGUI[] pieceSet(int size)
	{
		PieceGUI[] array = new PieceGUI[size];
		for(int i=0; i<size; i++)
		{
			array[i] = new PieceGUI();
		}
		return array;
	}
	
	public void setTileCenter(Point tileCenter)
	{
		this.tileCenter = tileCenter;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.black);
		g.drawLine(0, 50, 50, 100);
	}
	
}