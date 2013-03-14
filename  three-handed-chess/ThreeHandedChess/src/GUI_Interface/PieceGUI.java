package GUI_Interface;

import javax.swing.JLabel;

public class PieceGUI extends JLabel
{
	private static final long serialVersionUID = 1L;
	
	public static PieceGUI[] pieceSet(int size)
	{
		PieceGUI[] array = new PieceGUI[size];
		for(int i=0; i<size; i++)
		{
			array[i] = new PieceGUI();
		}
		return array;
	}
}