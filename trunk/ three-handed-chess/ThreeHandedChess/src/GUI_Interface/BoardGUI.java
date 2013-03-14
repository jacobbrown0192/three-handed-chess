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

public class BoardGUI extends JLayeredPane implements MouseListener
{
	private static final long serialVersionUID = 1L;
	
	private CoordinateGUI[] a = CoordinateGUI.coordinateSet(25);
	private CoordinateGUI[] b = CoordinateGUI.coordinateSet(25);
	private CoordinateGUI[] c = CoordinateGUI.coordinateSet(25);
	private CoordinateGUI[] d = CoordinateGUI.coordinateSet(25);
	private CoordinateGUI[] e = CoordinateGUI.coordinateSet(25);
	private CoordinateGUI[] f = CoordinateGUI.coordinateSet(25);
	
	private TileGUI[] quadATiles = TileGUI.tileSet(16);
	private TileGUI[] quadBTiles = TileGUI.tileSet(16);
	private TileGUI[] quadCTiles = TileGUI.tileSet(16);
	private TileGUI[] quadDTiles = TileGUI.tileSet(16);
	private TileGUI[] quadETiles = TileGUI.tileSet(16);
	private TileGUI[] quadFTiles = TileGUI.tileSet(16);
	
	private PieceGUI[] quadAPieces = PieceGUI.pieceSet(16);
	private PieceGUI[] quadBPieces = PieceGUI.pieceSet(16);
	private PieceGUI[] quadCPieces = PieceGUI.pieceSet(16);
	private PieceGUI[] quadDPieces = PieceGUI.pieceSet(16);
	private PieceGUI[] quadEPieces = PieceGUI.pieceSet(16);
	private PieceGUI[] quadFPieces = PieceGUI.pieceSet(16);
	
	private ImageIcon GKing = new ImageIcon("/Users/christopherhowse/Pictures/ChessImages/Green King.png");
	private ImageIcon GQueen = new ImageIcon("/Users/christopherhowse/Pictures/ChessImages/Green Queen.png");
	private ImageIcon GBishop = new ImageIcon();
	private ImageIcon GRook = new ImageIcon();
	private ImageIcon GKnight = new ImageIcon();
	private ImageIcon GPawn = new ImageIcon();
	
	private ImageIcon BKing = new ImageIcon();
	private ImageIcon BQueen = new ImageIcon();
	private ImageIcon BBishop = new ImageIcon();
	private ImageIcon BRook = new ImageIcon();
	private ImageIcon BKnight = new ImageIcon();
	private ImageIcon BPawn = new ImageIcon();
	
	private ImageIcon RKing = new ImageIcon();
	private ImageIcon RQueen = new ImageIcon();
	private ImageIcon RBishop = new ImageIcon();
	private ImageIcon RRook = new ImageIcon();
	private ImageIcon RKnight = new ImageIcon();
	private ImageIcon RPawn = new ImageIcon();
	
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
    //JPanel chessBoard;
	
	public BoardGUI(Game aGame)
	{
		theGame = aGame;
		addMouseListener(this);
		
		/*
		chessBoard = new JPanel();
		chessBoard.setBounds(0, 0, getWidth(), getHeight());
		this.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
		chessBoard.add(quadAPieces[0], JLayeredPane.PALETTE_LAYER);
		*/
	}
	
	@Override
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
		
		int xPoints[] = {(int)sec[uL].x, (int)sec[uL + 1].x, (int)sec[uL + 6].x, (int)sec[uL + 5].x};
		int yPoints[] = {(int)sec[uL].y, (int)sec[uL + 1].y, (int)sec[uL + 6].y, (int)sec[uL + 5].y};
		
		Polygon poly = new Polygon(xPoints, yPoints, xPoints.length);
		
		int xAvg = (int)((sec[uL].x + sec[uL + 1].x + sec[uL + 6].x + sec[uL + 5].x)/4);
		int yAvg = (int)((sec[uL].y + sec[uL + 1].y + sec[uL + 6].y + sec[uL + 5].y)/4);
		CoordinateGUI tileCenter = new CoordinateGUI(xAvg, yAvg);
		Point tileCenterPoint = new Point(xAvg, yAvg);
		
		
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
				quadATiles[tileNum].setTile(poly, sectionName, tileNum, tileCenter);
				quadAPieces[tileNum].setLocation(tileCenterPoint);
				if(tileNum == 0)
				{
					quadAPieces[0].setIcon(GKing);
					quadAPieces[0].setBounds(xAvg, yAvg, 28, 50);
					quadAPieces[0].setVisible(true);
				}
				break;
			case "b":
				quadBTiles[tileNum].setTile(poly, sectionName, tileNum, tileCenter);
				quadBPieces[tileNum].setLocation(tileCenterPoint);
				break;
			case "c":
				quadCTiles[tileNum].setTile(poly, sectionName, tileNum, tileCenter);
				quadCPieces[tileNum].setLocation(tileCenterPoint);
				break;
			case "d":
				quadDTiles[tileNum].setTile(poly, sectionName, tileNum, tileCenter);
				quadDPieces[tileNum].setLocation(tileCenterPoint);
				break;
			case "e":
				quadETiles[tileNum].setTile(poly, sectionName, tileNum, tileCenter);
				quadEPieces[tileNum].setLocation(tileCenterPoint);
				break;
			case "f":
				quadFTiles[tileNum].setTile(poly, sectionName, tileNum, tileCenter);
				quadFPieces[tileNum].setLocation(tileCenterPoint);
				break;
		}
		
		g2.setColor(Color.BLACK);
		g2.draw(poly);
		
		if(sectionName == "a" || sectionName == "b" || sectionName == "c")
		{
			if(tileNum == 0 || tileNum == 2 || tileNum == 5 || tileNum == 7 || tileNum == 8 || tileNum == 10 || tileNum == 13 || tileNum == 15)
			{
				g2.setColor(new Color(0xCC, 0x99, 0x66));
			}
			else g2.setColor(new Color(0xFF, 0xCC, 0x99));
		}
		else
		{
			if(tileNum == 0 || tileNum == 2 || tileNum == 5 || tileNum == 7 || tileNum == 8 || tileNum == 10 || tileNum == 13 || tileNum == 15)
			{
				g2.setColor(new Color(0xFF, 0xCC, 0x99));
			}
			else g2.setColor(new Color(0xCC, 0x99, 0x66));
		}
		
		g2.fillPolygon(poly);
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
		searchForTile(e, quadATiles);
		searchForTile(e, quadBTiles);
		searchForTile(e, quadCTiles);
		searchForTile(e, quadDTiles);
		searchForTile(e, quadETiles);
		searchForTile(e, quadFTiles);	
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