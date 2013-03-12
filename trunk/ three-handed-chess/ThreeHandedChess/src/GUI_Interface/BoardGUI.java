package GUI_Interface;

//public class Board 
//{
	
//}

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.GeneralPath;

import javax.swing.*;

import threePlayerChessa.Game;

public class BoardGUI extends JPanel implements MouseListener
{
	private static final long serialVersionUID = 1L;
	
	public CoordinateGUI[] a = CoordinateGUI.CoordinateSet(25);
	public CoordinateGUI[] b = CoordinateGUI.CoordinateSet(25);
	public CoordinateGUI[] c = CoordinateGUI.CoordinateSet(25);
	public CoordinateGUI[] d = CoordinateGUI.CoordinateSet(25);
	public CoordinateGUI[] e = CoordinateGUI.CoordinateSet(25);
	public CoordinateGUI[] f = CoordinateGUI.CoordinateSet(25);
	
	public TileGUI[] quadA = TileGUI.TileSet(16);
	public TileGUI[] quadB = TileGUI.TileSet(16);
	public TileGUI[] quadC = TileGUI.TileSet(16);
	public TileGUI[] quadD = TileGUI.TileSet(16);
	public TileGUI[] quadE = TileGUI.TileSet(16);
	public TileGUI[] quadF = TileGUI.TileSet(16);
	
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
    Game theGame;
	
	public BoardGUI(Game aGame)
	{
		theGame = aGame;
		addMouseListener(this);
	}
	
	public void paint(Graphics g)
	{
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		int w = getWidth();
		int h = (int)(getWidth()*Math.cos(Math.PI/6));
		
		g2.setPaintMode();
		
		g2.setColor(Color.white);
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.setPaint(Color.black);
		g2.setStroke(stroke);
		
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
		c[20].x = 7*w/8;		c[20].y = 3*h/4;
		c[24].x = w;			c[24].y = h/2;
		c[0].setSection(c);
		
		d[0].x = w/2;		d[0].y = h/2;
		d[4].x = 7*w/8;		d[4].y = 3*h/4;
		d[20].x = w/2;		d[20].y = h;
		d[24].x = 3*w/4;		d[24].y = h;
		d[0].setSection(d);
		
		e[0].x = w/8;		e[0].y = 3*h/4;
		e[4].x = w/2;		e[4].y = h/2;
		e[20].x = w/4;		e[20].y = h;
		e[24].x = w/2;		e[24].y = h;
		e[0].setSection(e);
		
		f[0].x = 0;				f[0].y = h/2;
		f[4].x = w/8;		f[4].y = h/4;
		f[20].x = w/8;		f[20].y = 3*h/4;
		f[24].x = w/2;		f[24].y = h/2;
		f[0].setSection(f);		

		// draw GeneralPath (polyline)
		
		paintSection(g, a, "a");
		paintSection(g, b, "b");
		paintSection(g, c, "c");
		paintSection(g, d, "d");
		paintSection(g, e, "e");
		paintSection(g, f, "f");
	}
	
	public void paintSection(Graphics g, CoordinateGUI[] sec, String sectionName)
	{
		for (int i = 0; i < 19; i++)
		{
			if (i != 4 && i != 9 && i != 14)
			{
				paintTile(g, sec, i, sectionName);
			}
		}
	}
	
	public void paintTile(Graphics g, CoordinateGUI[] sec, int uL, String sectionName)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		int xPoints[] = {(int)sec[uL].x, (int)sec[uL + 1].x, (int)sec[uL + 6].x, (int)sec[uL + 5].x}; //, (int)sec[uL].x};
		int yPoints[] = {(int)sec[uL].y, (int)sec[uL + 1].y, (int)sec[uL + 6].y, (int)sec[uL + 5].y}; //, (int)sec[uL].y};
		
		Polygon poly = new Polygon(xPoints, yPoints, xPoints.length);
		
		int tileNum = 100;
		
		if (uL < 4)
		{
			tileNum = uL;
		}
		else if (uL < 9)
		{
			tileNum = uL - 1;
		}
		else if (uL < 14)
		{
			tileNum = uL - 2;
		}
		else if (uL < 19)
		{
			tileNum = uL - 3;
		}
	
		switch(sectionName)
		{
			case "a":
				quadA[tileNum].setTile(poly, sectionName, tileNum);
				break;
			case "b":
				quadB[tileNum].setTile(poly, sectionName, tileNum);
				break;
			case "c":
				quadC[tileNum].setTile(poly, sectionName, tileNum);
				break;
			case "d":
				quadD[tileNum].setTile(poly, sectionName, tileNum);
				break;
			case "e":
				quadE[tileNum].setTile(poly, sectionName, tileNum);
				break;
			case "f":
				quadF[tileNum].setTile(poly, sectionName, tileNum);
				break;
		}
		
		g2.draw(poly);
	}
	
	private void searchForTile(MouseEvent e, TileGUI[] quad)
	{
		for (int i=0; i < 16; i++)
		{
			if (quad[i].checkIfContained(e))
			{
				System.out.println("Found Tile!");
				System.out.println(quad[i].getSection());
				System.out.println(i);
				break;
			}
		}
		
	}
	
	
	public static void main(String s[])
	{
		BoardGUI board = new BoardGUI(null);
		
		JFrame frame = new JFrame("ThreeHandedChessBoard");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(board);
        frame.setSize(500,600);
        frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		searchForTile(e, quadA);
		searchForTile(e, quadB);
		searchForTile(e, quadC);
		searchForTile(e, quadD);
		searchForTile(e, quadE);
		searchForTile(e, quadF);	
	}

	@Override
	public void mousePressed(MouseEvent e)
	{

		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		
	}
}