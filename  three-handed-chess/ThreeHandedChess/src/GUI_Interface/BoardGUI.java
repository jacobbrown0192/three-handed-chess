package GUI_Interface;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import threePlayerChessa.Click;
import threePlayerChessa.Piece.PieceType;
import javax.swing.*;
import threePlayerChessa.Game;

/** Graphics for the Hexagonal Board
 * <p>An extension of <code>JPanel</code> containing a <code>JLayeredPane</code>.
 * <p>Needed to possess all of the <code>TileGUI</code> and <code>PiecesGUI</code>
 * due to the limitations of swing in setting non-rectangular bounds of components.
 * <p>Interprets clicks and checks coordinate against tile polygons
 * in order to circumvent this limitation.
 */
public class BoardGUI extends JPanel implements MouseListener
{
	private static final long serialVersionUID = 1L;
	private JLayeredPane layeredPane;
	
	private int yOffset = 25;
	private Dimension boardSize;
	
	private CoordinateGUI[] a = CoordinateGUI.coordinateSet(25);
	private CoordinateGUI[] b = CoordinateGUI.coordinateSet(25);
	private CoordinateGUI[] c = CoordinateGUI.coordinateSet(25);
	private CoordinateGUI[] d = CoordinateGUI.coordinateSet(25);
	private CoordinateGUI[] e = CoordinateGUI.coordinateSet(25);
	private CoordinateGUI[] f = CoordinateGUI.coordinateSet(25);
	
	private TileGUI[] hexarantATiles = TileGUI.tileSet(16);
	private TileGUI[] hexarantBTiles = TileGUI.tileSet(16);
	private TileGUI[] hexarantCTiles = TileGUI.tileSet(16);
	private TileGUI[] hexarantDTiles = TileGUI.tileSet(16);
	private TileGUI[] hexarantETiles = TileGUI.tileSet(16);
	private TileGUI[] hexarantFTiles = TileGUI.tileSet(16);
	
	private PieceGUI[] hexarantAPieces = PieceGUI.pieceSet(16);
	private PieceGUI[] hexarantBPieces = PieceGUI.pieceSet(16);
	private PieceGUI[] hexarantCPieces = PieceGUI.pieceSet(16);
	private PieceGUI[] hexarantDPieces = PieceGUI.pieceSet(16);
	private PieceGUI[] hexarantEPieces = PieceGUI.pieceSet(16);
	private PieceGUI[] hexarantFPieces = PieceGUI.pieceSet(16);

    final static BasicStroke stroke = new BasicStroke(2.0f);

    Game theGame;
	
    /** Constructor for BoardGUI providing the <code>theGame</code> connection to
     * the model and the dimension of the board.
     * 
     * <p>Creates a new <code>JLayeredPane</code> to which the <code>PieceGUI</code>
     * are added.
     * <p>The layered pane is then added to the board.
     * 
     * @param aGame Connection to the model
     * @param boardSize The size of the BoardGUI and layered pane
     */
	public BoardGUI(Game aGame, Dimension boardSize)
	{	
		theGame = aGame;
		addMouseListener(this);
		
		this.boardSize = boardSize;
		this.layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(this.boardSize);
		
		addPieceLabels(layeredPane, hexarantAPieces);
		addPieceLabels(layeredPane, hexarantBPieces);
		addPieceLabels(layeredPane, hexarantCPieces);
		addPieceLabels(layeredPane, hexarantDPieces);
		addPieceLabels(layeredPane, hexarantEPieces);
		addPieceLabels(layeredPane, hexarantFPieces);
		
		this.add(layeredPane);
	}
	
	/** Adds a hexarant (16) of PieceGUIs to the layered pane.
	 * 
	 * @param pane
	 * @param hexarant
	 */
	private void addPieceLabels(JLayeredPane pane, PieceGUI[] hexarant) 
	{
		for (int i=0; i<16; i++)
		{
			pane.add(hexarant[i], 50);
		}
	}

	/** Override of JPanel's paintComponent.
	 * 
	 * <p>Creates coordinates for the corners of every tile.
	 * <p>Paints each individual hexarant.
	 * 
	 * @param g <code>Graphics</code> object
	 */
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
		a[0].setHexarant(a);
		
		b[0].x = w/2;		b[0].y = 0;
		b[4].x = 3*w/4;		b[4].y = 0;
		b[20].x = w/2;		b[20].y = h/2;
		b[24].x = 7*w/8;	b[24].y = h/4;
		b[0].setHexarant(b);
		
		c[0].x = w/2;		c[0].y = h/2;
		c[4].x = 7*w/8;		c[4].y = h/4;
		c[20].x = 7*w/8;		c[20].y = 3*h/4;
		c[24].x = w;			c[24].y = h/2;
		c[0].setHexarant(c);
		
		d[0].x = w/2;		d[0].y = h/2;
		d[4].x = 7*w/8;		d[4].y = 3*h/4;
		d[20].x = w/2;		d[20].y = h;
		d[24].x = 3*w/4;		d[24].y = h;
		d[0].setHexarant(d);
		
		e[0].x = w/8;		e[0].y = 3*h/4;
		e[4].x = w/2;		e[4].y = h/2;
		e[20].x = w/4;		e[20].y = h;
		e[24].x = w/2;		e[24].y = h;
		e[0].setHexarant(e);
		
		f[0].x = 0;				f[0].y = h/2;
		f[4].x = w/8;		f[4].y = h/4;
		f[20].x = w/8;		f[20].y = 3*h/4;
		f[24].x = w/2;		f[24].y = h/2;
		f[0].setHexarant(f);		
		
		paintHexarant(g, a, "a");
		paintHexarant(g, b, "b");
		paintHexarant(g, c, "c");
		paintHexarant(g, d, "d");
		paintHexarant(g, e, "e");
		paintHexarant(g, f, "f");
	}
	
	/** Loops through the painting of each tile in a hexarant.
	 * 
	 * @param g <code>Graphics</code> object.
	 * @param hexarant Array of coordinates of the segment being painted.
	 * @param hexarantName String of segment name passed for the naming of tiles.
	 */
	public void paintHexarant(Graphics g, CoordinateGUI[] hexarant, String hexarantName)
	{
		for (int i = 0; i < 19; i++)
		{
			if (i != 4 && i != 9 && i != 14)
			{
				paintTile(g, hexarant, i, hexarantName);
			}
		}
	}
	
	/** Paints the polygon of tile
	 * 
	 * <p>Saves the polygon into a <code>TileGUI</code> object for reference from clicks.
	 * <p>Saves the center of each tile into a <code>PieceGUI</code> object for the
	 * painting of the pieces.
	 * 
	 * @param g <code>Graphics</code> object.
	 * @param hexarant Array of coordinates of the segment being painted.
	 * @param uL Upper left coordinate index of the tile.
	 * @param hexarantName Name of the hexarant that the tile belongs to.
	 */
	public void paintTile(Graphics g, CoordinateGUI[] hexarant, int uL, String hexarantName)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		int xPoints[] = {(int)hexarant[uL].x, (int)hexarant[uL + 1].x, (int)hexarant[uL + 6].x, (int)hexarant[uL + 5].x};
		int yPoints[] = {(int)hexarant[uL].y + yOffset, (int)hexarant[uL + 1].y + yOffset, (int)hexarant[uL + 6].y + yOffset, (int)hexarant[uL + 5].y + yOffset};
		
		Polygon poly = new Polygon(xPoints, yPoints, xPoints.length);
		
		int xAvg = (int)((hexarant[uL].x + hexarant[uL + 1].x + hexarant[uL + 6].x + hexarant[uL + 5].x)/4);
		int yAvg = (int)((hexarant[uL].y + hexarant[uL + 1].y + hexarant[uL + 6].y + hexarant[uL + 5].y)/4);
		yAvg += yOffset;
		
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
	
		switch(hexarantName)
		{
			case "a":
				hexarantATiles[tileNum].setTile(poly, hexarantName, tileNum);
				hexarantAPieces[tileNum].setBounds(xAvg-14, yAvg-40, 28, 40);
				break;
			case "b":
				hexarantBTiles[tileNum].setTile(poly, hexarantName, tileNum);
				hexarantBPieces[tileNum].setBounds(xAvg-14, yAvg-40, 28, 40);
				break;
			case "c":
				hexarantCTiles[tileNum].setTile(poly, hexarantName, tileNum);
				hexarantCPieces[tileNum].setBounds(xAvg-14, yAvg-40, 28, 40);
				break;
			case "d":
				hexarantDTiles[tileNum].setTile(poly, hexarantName, tileNum);
				hexarantDPieces[tileNum].setBounds(xAvg-14, yAvg-40, 28, 40);
				break;
			case "e":
				hexarantETiles[tileNum].setTile(poly, hexarantName, tileNum);
				hexarantEPieces[tileNum].setBounds(xAvg-14, yAvg-40, 28, 40);
				break;
			case "f":
				hexarantFTiles[tileNum].setTile(poly, hexarantName, tileNum);
				hexarantFPieces[tileNum].setBounds(xAvg-14, yAvg-40, 28, 40);
				break;
		}
		
		g2.setColor(Color.BLACK);
		g2.draw(poly);
		
		if(hexarantName == "a" || hexarantName == "b" || hexarantName == "c")
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
		
		setTileIcons();
	}
	
	
	/** Method called by the model to set the icons of each tile.
	 * 
	 * <p>Called upon start, reset, and after a move.
	 */
	public void setTileIcons()
	{
		//Section 0 Segment 0 or Red Left or hexarant E
		for (int i = 0; i<16; i++)
		{
			int modelBoardLetter = theGame.getTheBoard().getSection0().getSegment0().getTiles(i).getLetter();
			int modelBoardNumber = theGame.getTheBoard().getSection0().getSegment0().getTiles(i).getNumber();
			for (int j = 0; j < 16; j++)
			{
				if(hexarantETiles[j].getBoardLetter() == modelBoardLetter && hexarantETiles[j].getBoardNumber() == modelBoardNumber)
				{
					if(theGame.getTheBoard().getSection0().getSegment0().getTiles(i).getPiece() != null)
					{
						PieceType type = theGame.getTheBoard().getSection0().getSegment0().getTiles(i).getPiece().getPieceType();
						int teamNumber = theGame.getTheBoard().getSection0().getSegment0().getTiles(i).getPiece().getPlayer().getNumber();
						hexarantEPieces[j].setPieceImage(type, teamNumber);
					}
					else
					{
						int teamNumber = 4;
						hexarantEPieces[j].setPieceImage(null, teamNumber);
					}
					break;
				}
			}
		}
		//Section 0 Segment 1 or Red Right or hexarant D
		for (int i = 0; i<16; i++)
		{
			int modelBoardLetter = theGame.getTheBoard().getSection0().getSegment1().getTiles(i).getLetter();
			int modelBoardNumber = theGame.getTheBoard().getSection0().getSegment1().getTiles(i).getNumber();
			for (int j = 0; j < 16; j++)
			{
				if(hexarantDTiles[j].getBoardLetter() == modelBoardLetter && hexarantDTiles[j].getBoardNumber() == modelBoardNumber)
				{
					if(theGame.getTheBoard().getSection0().getSegment1().getTiles(i).getPiece() != null)
					{
						PieceType type = theGame.getTheBoard().getSection0().getSegment1().getTiles(i).getPiece().getPieceType();
						int teamNumber = theGame.getTheBoard().getSection0().getSegment1().getTiles(i).getPiece().getPlayer().getNumber();
						hexarantDPieces[j].setPieceImage(type, teamNumber);
					}
					else
					{
						int teamNumber = 4;
						hexarantDPieces[j].setPieceImage(null, teamNumber);
					}
					break;
				}
			}
		}
		//Section 1 Segment 0 or Blue Left or hexarant A
		for (int i = 0; i<16; i++)
		{
			int modelBoardLetter = theGame.getTheBoard().getSection1().getSegment0().getTiles(i).getLetter();
			int modelBoardNumber = theGame.getTheBoard().getSection1().getSegment0().getTiles(i).getNumber();
			for (int j = 0; j < 16; j++)
			{
				if(hexarantATiles[j].getBoardLetter() == modelBoardLetter && hexarantATiles[j].getBoardNumber() == modelBoardNumber)
				{
					if(theGame.getTheBoard().getSection1().getSegment0().getTiles(i).getPiece() != null)
					{
						PieceType type = theGame.getTheBoard().getSection1().getSegment0().getTiles(i).getPiece().getPieceType();
						int teamNumber = theGame.getTheBoard().getSection1().getSegment0().getTiles(i).getPiece().getPlayer().getNumber();
						hexarantAPieces[j].setPieceImage(type, teamNumber);
					}
					else
					{
						int teamNumber = 4;
						hexarantAPieces[j].setPieceImage(null, teamNumber);
					}
					break;
				}
			}
		}
		//Section 1 Segment 1 or Blue Right or hexarant F
		for (int i = 0; i<16; i++)
		{
			int modelBoardLetter = theGame.getTheBoard().getSection1().getSegment1().getTiles(i).getLetter();
			int modelBoardNumber = theGame.getTheBoard().getSection1().getSegment1().getTiles(i).getNumber();
			for (int j = 0; j < 16; j++)
			{
				if(hexarantFTiles[j].getBoardLetter() == modelBoardLetter && hexarantFTiles[j].getBoardNumber() == modelBoardNumber)
				{
					if(theGame.getTheBoard().getSection1().getSegment1().getTiles(i).getPiece() != null)
					{
						PieceType type = theGame.getTheBoard().getSection1().getSegment1().getTiles(i).getPiece().getPieceType();
						int teamNumber = theGame.getTheBoard().getSection1().getSegment1().getTiles(i).getPiece().getPlayer().getNumber();
						hexarantFPieces[j].setPieceImage(type, teamNumber);
					}
					else
					{
						int teamNumber = 4;
						hexarantFPieces[j].setPieceImage(null, teamNumber);
					}
					break;
				}
			}
		}
		//Section 2 Segment 0 or Green Left or hexarant C
		for (int i = 0; i<16; i++)
		{
			int modelBoardLetter = theGame.getTheBoard().getSection2().getSegment0().getTiles(i).getLetter();
			int modelBoardNumber = theGame.getTheBoard().getSection2().getSegment0().getTiles(i).getNumber();
			for (int j = 0; j < 16; j++)
			{
				if(hexarantCTiles[j].getBoardLetter() == modelBoardLetter && hexarantCTiles[j].getBoardNumber() == modelBoardNumber)
				{
					if(theGame.getTheBoard().getSection2().getSegment0().getTiles(i).getPiece() != null)
					{
						PieceType type = theGame.getTheBoard().getSection2().getSegment0().getTiles(i).getPiece().getPieceType();
						int teamNumber = theGame.getTheBoard().getSection2().getSegment0().getTiles(i).getPiece().getPlayer().getNumber();
						hexarantCPieces[j].setPieceImage(type, teamNumber);
					}
					else
					{
						int teamNumber = 4;
						hexarantCPieces[j].setPieceImage(null, teamNumber);
					}
					break;
				}
			}
		}
		//Section 2 Segment 1 or Green Right or hexarant B
		for (int i = 0; i<16; i++)
		{
			int modelBoardLetter = theGame.getTheBoard().getSection2().getSegment1().getTiles(i).getLetter();
			int modelBoardNumber = theGame.getTheBoard().getSection2().getSegment1().getTiles(i).getNumber();
			for (int j = 0; j < 16; j++)
			{
				if(hexarantBTiles[j].getBoardLetter() == modelBoardLetter && hexarantBTiles[j].getBoardNumber() == modelBoardNumber)
				{
					if(theGame.getTheBoard().getSection2().getSegment1().getTiles(i).getPiece() != null)
					{
						PieceType type = theGame.getTheBoard().getSection2().getSegment1().getTiles(i).getPiece().getPieceType();
						int teamNumber = theGame.getTheBoard().getSection2().getSegment1().getTiles(i).getPiece().getPlayer().getNumber();
						hexarantBPieces[j].setPieceImage(type, teamNumber);
					}
					else
					{
						int teamNumber = 4;
						hexarantBPieces[j].setPieceImage(null, teamNumber);
					}
					break;
				}
			}
		}
	}
	
	
	/** Checks if the click was inside a tile of the hexarant.
	 * 
	 * <p>If so, sends a <code>getClick</code> message to the model.
	 * 
	 * @param e Mouse Event
	 * @param hexarant
	 */
	private boolean searchForTile(MouseEvent e, TileGUI[] hexarant)
	{
		for (int i=0; i < 16; i++)
		{
			if (hexarant[i].checkIfContained(e))
			{
				//System.out.println("Found Tile!");
				Click tileClicked = new Click(hexarant[i].getBoardNumber(), hexarant[i].getBoardLetter());
				theGame.getClick(tileClicked);
				//System.out.println(hexarant[i].getBoardNumber());
				//System.out.println(hexarant[i].getBoardLetter());
				return true;
			}
		}
		return false;
	}

	
	//Mouse Listener
	/** Mouse clicks are checked against the polygons of every hexarant
	 * until a match is found.
	 * 
	 * <p>Checks for containment are carried out by <code>searchForTile</code>
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
		if(!searchForTile(e, hexarantATiles))
		{
			if(!searchForTile(e, hexarantBTiles))
			{
				if(!searchForTile(e, hexarantCTiles))
				{
					if(!searchForTile(e, hexarantDTiles))
					{
						if(!searchForTile(e, hexarantETiles))
						{
							searchForTile(e, hexarantFTiles);
						}
					}
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e){}

	@Override
	public void mouseReleased(MouseEvent e){}

	@Override
	public void mouseEntered(MouseEvent e){}

	@Override
	public void mouseExited(MouseEvent e) {}
}