package GUI_Interface;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TileGUI extends JPanel
{
	public Polygon poly;
	public int number;
	public String section;
	public MouseAdapter ma;
	
    final static BasicStroke stroke = new BasicStroke(2.0f);
	
	public TileGUI(final Polygon poly, String section, int number)
	{
		this.number = number;
		this.section = section;
		this.poly = poly;
		this.ma = createMouseListener(number, section);
		
		this.addMouseListener(ma);
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaintMode();
		g2.setPaint(Color.black);
		g2.setStroke(stroke);
		
		g2.drawPolygon(poly);
	}
	
	public MouseAdapter createMouseListener (final int num, final String sec)
	{
		MouseAdapter ma = new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{	
				if(poly.contains(e.getPoint()))
				{
					System.out.println("Mouse Clicked");
					System.out.print("Letter: ");
					System.out.println(sec);
					System.out.print("Number: ");
					System.out.println(num);
				}
			}
		};
		
		return ma;
	}
}
