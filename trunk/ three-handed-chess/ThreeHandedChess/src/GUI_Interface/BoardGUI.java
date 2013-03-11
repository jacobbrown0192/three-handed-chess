package GUI_Interface;

//public class Board 
//{
	
//}

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.GeneralPath;
import javax.swing.*;
import threePlayerChessa.Game;

public class BoardGUI extends JPanel
{
	JLayeredPane layeredPane;
	JPanel chessBoard;
	JLabel ChessPiece;
	Game theGame;
	
	private static final long serialVersionUID = 1L;
	
    final static Color bg = Color.white;
    final static Color fg = Color.black;
    final static Color red = Color.red;
    final static Color white = Color.white;

    final static BasicStroke stroke = new BasicStroke(2.0f);
    final static BasicStroke wideStroke = new BasicStroke(8.0f);

    final static float dash1[] = {10.0f};
    final static BasicStroke dashed = new BasicStroke(1.0f, 
                                                      BasicStroke.CAP_BUTT, 
                                                      BasicStroke.JOIN_MITER, 
                                                      10.0f, dash1, 0.0f);
	
	public BoardGUI(Game aGame)
	{
		int w = super.getWidth();
		this.theGame = aGame;
		initComponents();
	}

	private void initComponents()
	{		
		int w = 600; //(int)super.getWidth();
		int h = 600; //(int)(super.getWidth()*Math.cos(Math.PI/6));
		
		CoordinateGUI[] a = CoordinateGUI.CoordinateSet(25);
		CoordinateGUI[] b = CoordinateGUI.CoordinateSet(25);
		CoordinateGUI[] c = CoordinateGUI.CoordinateSet(25);
		CoordinateGUI[] d = CoordinateGUI.CoordinateSet(25);
		CoordinateGUI[] e = CoordinateGUI.CoordinateSet(25);
		CoordinateGUI[] f = CoordinateGUI.CoordinateSet(25);
		
		a[0].x = w/4; 		a[0].y = 0; 
		a[4].x = w/2;		a[4].y = 0;
		a[20].x = w/8;		a[20].y = h/4;
		a[24].x = w/2;		a[24].y = h/2;
		a[0].setSection(a);
		
		b[0].x = w/2;		b[0].y = 0;
		b[4].x = 3*w/4;		b[4].y = 0;
		b[20].x = w/2;		b[20].y = h/2;
		b[24].x = 7*w/8;	b[24].y = h/4;
		b[0].setSection(b);
		
		c[0].x = w/2;		c[0].y = h/2;
		c[4].x = 7*w/8;		c[4].y = h/4;
		c[20].x = 7*w/8;	c[20].y = 3*h/4;
		c[24].x = w;		c[24].y = h/2;
		c[0].setSection(c);
		
		d[0].x = w/2;		d[0].y = h/2;
		d[4].x = 7*w/8;		d[4].y = 3*h/4;
		d[20].x = w/2;		d[20].y = h;
		d[24].x = 3*w/4;	d[24].y = h;
		d[0].setSection(d);
		
		e[0].x = w/8;		e[0].y = 3*h/4;
		e[4].x = w/2;		e[4].y = h/2;
		e[20].x = w/4;		e[20].y = h;
		e[24].x = w/2;		e[24].y = h;
		e[0].setSection(e);
		
		f[0].x = 0;			f[0].y = h/2;
		f[4].x = w/8;		f[4].y = h/4;
		f[20].x = w/8;		f[20].y = 3*h/4;
		f[24].x = w/2;		f[24].y = h/2;
		f[0].setSection(f);		

		// draw GeneralPath (polyline)
		
		createSection(a, "a");
		createSection(b, "b");
		createSection(c, "c");
		createSection(d, "d");
		createSection(e, "e");
		createSection(f, "f");
	}
	
	//public void paint(Graphics g){}
	
	public void createSection(CoordinateGUI[] sec, String section)
	{
		for (int i = 0; i < 19; i++)
		{
			if (i != 4 && i != 9 && i != 14)
			{
				createTile(sec, 0, section);
			}
		}
	}
	
	public void createTile(CoordinateGUI[] sec, int uL, String section)
	{
		
		int yOffset = 0;
		int xPoints[] = {(int)sec[uL].x, (int)sec[uL + 1].x, (int)sec[uL + 6].x, (int)sec[uL + 5].x};
		int yPoints[] = {(int)sec[uL].y, (int)sec[uL + 1].y, (int)sec[uL + 6].y, (int)sec[uL + 5].y, (int)sec[uL].y};
		
		Polygon poly = new Polygon(xPoints, yPoints, xPoints.length);
		
		TileGUI tile = new TileGUI (poly, section, uL);
		tile.setBounds(getBounds());
		tile.setBackground(getBackground());
		
		this.add(tile);
		/*
		GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xPoints.length);
		polyline.moveTo (xPoints[0], yPoints[0] + yOffset);

		
		for (int i = 1; i < xPoints.length; i++)
		{
		         polyline.lineTo(xPoints[i], yPoints[i] + yOffset);
		}
		polyline.closePath();
		g2.draw(polyline);
		*/
	}
	
	public static void main(String s[])
	{
		JFrame frame = new JFrame("Foo");
		JPanel board = new JPanel();
		
		frame.setContentPane(board);
		board.setPreferredSize(new Dimension(600,600));
		board.setBackground(Color.white);
	
		int xPoints[] = {20, 50, 30, 20};
		int yPoints[] = {20, 20, 40, 40};
		
		Polygon poly = new Polygon(xPoints, yPoints, xPoints.length);
		
		final TileGUI tile = new TileGUI(poly, "a", 2);
		
		tile.setBounds(poly.getBounds());
		//tile.setBounds(0, 0, 300, 300);
		tile.setBackground(Color.white);
		board.add(tile);
/*		
		int xPoints2[] = {50, 60, 40, 30};
		int yPoints2[] = {20, 20, 40, 40};
		
		Polygon poly2 = new Polygon(xPoints2, yPoints2, xPoints2.length);
		
		final TileGUI tile2 = new TileGUI(poly, "a", 3);
		tile.setBounds(poly.getBounds());
		board.add(tile2);
*/		
		frame.pack();
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		/*
		BoardGUI board = new BoardGUI(null);
		board.setVisible(true);
		
		
		JFrame frame = new JFrame("Three Handed Chess");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(board);
        frame.setSize(600,600);
        frame.setVisible(true);
        */
	}
}
