package GUI_Interface;

//public class Board 
//{
	
//}

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import threePlayerChessa.Click;
import threePlayerChessa.Piece.PieceType;

import javax.swing.*;


import threePlayerChessa.Game;

public class BoardGUI extends JPanel implements MouseListener
{
	private static final long serialVersionUID = 1L;
	private JLayeredPane layeredPane;
	//private JLabel imageContainer = new JLabel(new ImageIcon("/Users/christopherhowse/Pictures/ChessImages/Green King.png"));
	
	private int yOffset = 25;
	private Dimension boardSize;
	
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
	
	private ImageIcon FTile = new ImageIcon(getClass().getResource("/resources/Free Tile.png"));
	
	private ImageIcon GKing = new ImageIcon(getClass().getResource("/resources/Green King.png"));
	private ImageIcon GQueen  = new ImageIcon(getClass().getResource("/resources/Green Queen.png"));
	private ImageIcon GBishop = new ImageIcon(getClass().getResource("/resources/Green Bishop.png"));
	private ImageIcon GRook = new ImageIcon(getClass().getResource("/resources/Green Rook.png"));
	private ImageIcon GKnight = new ImageIcon(getClass().getResource("/resources/Green Knight.png"));
	private ImageIcon GPawn = new ImageIcon(getClass().getResource("/resources/Green Pawn.png"));
	
	private ImageIcon BKing = new ImageIcon(getClass().getResource("/resources/Blue King.png"));
	private ImageIcon BQueen = new ImageIcon(getClass().getResource("/resources/Blue Queen.png"));
	private ImageIcon BBishop = new ImageIcon(getClass().getResource("/resources/Blue Bishop.png"));
	private ImageIcon BRook = new ImageIcon(getClass().getResource("/resources/Blue Rook.png"));
	private ImageIcon BKnight = new ImageIcon(getClass().getResource("/resources/Blue Knight.png"));
	private ImageIcon BPawn = new ImageIcon(getClass().getResource("/resources/Blue Pawn.png"));
	
	private ImageIcon RKing = new ImageIcon(getClass().getResource("/resources/Red King.png"));
	private ImageIcon RQueen = new ImageIcon(getClass().getResource("/resources/Red Queen.png"));
	private ImageIcon RBishop = new ImageIcon(getClass().getResource("/resources/Red Bishop.png"));
	private ImageIcon RRook = new ImageIcon(getClass().getResource("/resources/Red Rook.png"));
	private ImageIcon RKnight = new ImageIcon(getClass().getResource("/resources/Red Knight.png"));
	private ImageIcon RPawn = new ImageIcon(getClass().getResource("/resources/Red Pawn.png"));
	
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
	
	public BoardGUI(Game aGame, Dimension boardSize)
	{	
		theGame = aGame;
		addMouseListener(this);
		
		this.boardSize = boardSize;
		this.layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(this.boardSize);
		
		addPieceLabels(layeredPane, quadAPieces);
		addPieceLabels(layeredPane, quadBPieces);
		addPieceLabels(layeredPane, quadCPieces);
		addPieceLabels(layeredPane, quadDPieces);
		addPieceLabels(layeredPane, quadEPieces);
		addPieceLabels(layeredPane, quadFPieces);
		
		this.add(layeredPane);
	}
	
	private void addPieceLabels(JLayeredPane pane, PieceGUI[] quad) 
	{
		for (int i=0; i<16; i++)
		{
			pane.add(quad[i], 50);
		}
	}

	@Override
	public void paintComponent(Graphics g)
	{
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		int w = getWidth();
		int h = (int)(getWidth()*Math.cos(Math.PI/6));
		
		g2.setPaintMode();
		
		g2.setColor(new Color(0x66, 0x66, 0x66));
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
		int yPoints[] = {(int)sec[uL].y + yOffset, (int)sec[uL + 1].y + yOffset, (int)sec[uL + 6].y + yOffset, (int)sec[uL + 5].y + yOffset};
		
		Polygon poly = new Polygon(xPoints, yPoints, xPoints.length);
		
		int xAvg = (int)((sec[uL].x + sec[uL + 1].x + sec[uL + 6].x + sec[uL + 5].x)/4);
		int yAvg = (int)((sec[uL].y + sec[uL + 1].y + sec[uL + 6].y + sec[uL + 5].y)/4);
		yAvg += yOffset;
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
				quadAPieces[tileNum].setTileCenter(tileCenterPoint);
				//quadAPieces[tileNum].setIcon(GQueen);
				quadAPieces[tileNum].setBounds(xAvg-14, yAvg-40, 28, 40);
				break;
			case "b":
				quadBTiles[tileNum].setTile(poly, sectionName, tileNum, tileCenter);
				quadBPieces[tileNum].setTileCenter(tileCenterPoint);
				//quadBPieces[tileNum].setIcon(RQueen);
				quadBPieces[tileNum].setBounds(xAvg-14, yAvg-40, 28, 40);
				break;
			case "c":
				quadCTiles[tileNum].setTile(poly, sectionName, tileNum, tileCenter);
				quadCPieces[tileNum].setTileCenter(tileCenterPoint);
				//quadCPieces[tileNum].setIcon(BQueen);
				quadCPieces[tileNum].setBounds(xAvg-14, yAvg-40, 28, 40);
				break;
			case "d":
				quadDTiles[tileNum].setTile(poly, sectionName, tileNum, tileCenter);
				quadDPieces[tileNum].setTileCenter(tileCenterPoint);
				//quadDPieces[tileNum].setIcon(GKing);
				quadDPieces[tileNum].setBounds(xAvg-14, yAvg-40, 28, 40);
				break;
			case "e":
				quadETiles[tileNum].setTile(poly, sectionName, tileNum, tileCenter);
				quadEPieces[tileNum].setTileCenter(tileCenterPoint);
				//quadEPieces[tileNum].setIcon(RKing);
				quadEPieces[tileNum].setBounds(xAvg-14, yAvg-40, 28, 40);
				break;
			case "f":
				quadFTiles[tileNum].setTile(poly, sectionName, tileNum, tileCenter);
				quadFPieces[tileNum].setTileCenter(tileCenterPoint);
				//quadFPieces[tileNum].setIcon(FTile);
				quadFPieces[tileNum].setBounds(xAvg-14, yAvg-40, 28, 40);
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
	
	public void newGameSetup()
	{
		//Red Team
		//for (int i=0; i < 8; i++)
		{
		//	quad
		}
	}
	
	public void setTileIcons()
	{
		for (int i = 0; i<16; i++)
		{
			int modelBoardLetter = theGame.getTheBoard().getSection0().getSegment0().getTiles(i).getLetter();
			int modelBoardNumber = theGame.getTheBoard().getSection0().getSegment0().getTiles(i).getNumber();
			for (int j = 0; j < 16; j++)
			{
				if(quadATiles[j].getBoardLetter() == modelBoardLetter && quadATiles[j].getBoardNumber() == modelBoardNumber)
				{
					PieceType type = theGame.getTheBoard().getSection0().getSegment0().getTiles(i).getPiece().getPieceType();
					setPieceImage(type, quadAPieces[j]);
				}
			}
		}
	}
	
	public void setPieceImage(PieceType type, PieceGUI piece)
	{
		//piece.setIcon(icon)
	}
	
	private void searchForTile(MouseEvent e, TileGUI[] quad)
	{
		for (int i=0; i < 16; i++)
		{
			if (quad[i].checkIfContained(e))
			{
				System.out.println("Found Tile!");
				quad[i].convertCoordinateToModelSystem(quad[i]);
				Click tileClicked = new Click(quad[i].getBoardNumber(), quad[i].getBoardLetter());
				System.out.println(quad[i].getBoardNumber());
				System.out.println(quad[i].getBoardLetter());
				break;
			}
		}
		
	}
		
	public static void main(String s[])
	{
		Dimension boardSize = new Dimension (500,500);
	
		BoardGUI board = new BoardGUI(null, boardSize);
		
		JFrame frame = new JFrame("ThreeHandedChessBoard");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(board);
        frame.setSize(boardSize);
        frame.setResizable(false);
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