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
	
	private CoordinateGUI[][] boardPoints = CoordinateGUI.coordinateSet(6, 25);
	private TileGUI[][] boardTiles = TileGUI.tileSet(6, 16);
	private PieceGUI[][] boardPieces = PieceGUI.pieceSet(6, 16);

    final static BasicStroke stroke = new BasicStroke(1.0f);

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
		
		addPieceLabels(layeredPane, boardPieces);
		
		this.add(layeredPane);
	}
	
	/** Adds a hexarant (16) of PieceGUIs to the layered pane.
	 * 
	 * @param pane
	 * @param hexarant
	 */	
	private void addPieceLabels(JLayeredPane pane, PieceGUI[][] pieces)
	{
		for (int j=15; j>=0; j--)
		{
			pane.add(pieces[3][j]);
		}
		
		for (int j=15; j>=0; j--)
		{
			pane.add(pieces[4][j]);
		}
		
		//Add 2
		pane.add(pieces[2][12]);
		pane.add(pieces[2][8]);
		pane.add(pieces[2][13]);
		pane.add(pieces[2][4]);
		pane.add(pieces[2][9]);
		pane.add(pieces[2][14]);
		pane.add(pieces[2][0]);
		pane.add(pieces[2][5]);
		pane.add(pieces[2][10]);
		pane.add(pieces[2][15]);
		pane.add(pieces[2][1]);
		pane.add(pieces[2][6]);
		pane.add(pieces[2][11]);
		pane.add(pieces[2][2]);
		pane.add(pieces[2][7]);
		pane.add(pieces[2][3]);
		
		//Add 5
		pane.add(pieces[5][12]);
		pane.add(pieces[5][8]);
		pane.add(pieces[5][13]);
		pane.add(pieces[5][4]);
		pane.add(pieces[5][9]);
		pane.add(pieces[5][14]);
		pane.add(pieces[5][0]);
		pane.add(pieces[5][5]);
		pane.add(pieces[5][10]);
		pane.add(pieces[5][15]);
		pane.add(pieces[5][1]);
		pane.add(pieces[5][6]);
		pane.add(pieces[5][11]);
		pane.add(pieces[5][2]);
		pane.add(pieces[5][7]);
		pane.add(pieces[5][3]);

		
		for (int j=15; j>=0; j--)
		{
			pane.add(pieces[0][j]);
		}
		
		for (int j=15; j>=0; j--)
		{
			pane.add(pieces[1][j]);
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
		
		boardPoints[0][0].x = w/4;		boardPoints[0][0].y = 0;
		boardPoints[0][4].x = w/2;		boardPoints[0][4].y = 0;
		boardPoints[0][20].x = w/8;		boardPoints[0][20].y = h/4;
		boardPoints[0][24].x = w/2;		boardPoints[0][24].y = h/2;
		
		boardPoints[1][0].x = w/2;		boardPoints[1][0].y = 0;
		boardPoints[1][4].x = 3*w/4;	boardPoints[1][4].y = 0;
		boardPoints[1][20].x = w/2;		boardPoints[1][20].y = h/2;
		boardPoints[1][24].x = 7*w/8;	boardPoints[1][24].y = h/4;
		
		boardPoints[2][0].x = w/2;		boardPoints[2][0].y = h/2;
		boardPoints[2][4].x = 7*w/8;	boardPoints[2][4].y = h/4;
		boardPoints[2][20].x = 7*w/8;	boardPoints[2][20].y = 3*h/4;
		boardPoints[2][24].x = w;		boardPoints[2][24].y = h/2;
		
		boardPoints[3][0].x = w/2;		boardPoints[3][0].y = h/2;
		boardPoints[3][4].x = 7*w/8;	boardPoints[3][4].y = 3*h/4;
		boardPoints[3][20].x = w/2;		boardPoints[3][20].y = h;
		boardPoints[3][24].x = 3*w/4;	boardPoints[3][24].y = h;
		
		boardPoints[4][0].x = w/8;		boardPoints[4][0].y = 3*h/4;
		boardPoints[4][4].x = w/2;		boardPoints[4][4].y = h/2;
		boardPoints[4][20].x = w/4;		boardPoints[4][20].y = h;
		boardPoints[4][24].x = w/2;		boardPoints[4][24].y = h;
		
		boardPoints[5][0].x = 0;		boardPoints[5][0].y = h/2;
		boardPoints[5][4].x = w/8;		boardPoints[5][4].y = h/4;
		boardPoints[5][20].x = w/8;		boardPoints[5][20].y = 3*h/4;
		boardPoints[5][24].x = w/2;		boardPoints[5][24].y = h/2;
		boardPoints[0][0].setPoints(boardPoints);		
		
		paintBoard(g);
	}
	
	/** Loops through the painting of each tile in a hexarant.
	 * 
	 * @param g <code>Graphics</code> object.
	 * @param hexarant Array of coordinates of the segment being painted.
	 * @param hexarantName String of segment name passed for the naming of tiles.
	 */	
	public void paintBoard(Graphics g)
	{
		for (int i=0; i<6; i++)
		{
			for (int j=0; j<19; j++)
			{
				if (j != 4 && j != 9 && j != 14)
				{
					paintTile(g, i, j);
				}
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
	private void paintTile(Graphics g, int i, int uL) 
	{
		Graphics2D g2 = (Graphics2D) g;
		
		int xPoints[] = {(int)boardPoints[i][uL].x, (int)boardPoints[i][uL + 1].x, (int)boardPoints[i][uL + 6].x, (int)boardPoints[i][uL + 5].x};
		int yPoints[] = {(int)boardPoints[i][uL].y + yOffset, (int)boardPoints[i][uL + 1].y + yOffset, (int)boardPoints[i][uL + 6].y + yOffset, (int)boardPoints[i][uL + 5].y + yOffset};
	
		Polygon poly = new Polygon(xPoints, yPoints, xPoints.length);
		
		int xAvg = (int)((boardPoints[i][uL].x + boardPoints[i][uL + 1].x + boardPoints[i][uL + 6].x + boardPoints[i][uL + 5].x)/4);
		int yAvg = (int)((boardPoints[i][uL].y + boardPoints[i][uL + 1].y + boardPoints[i][uL + 6].y + boardPoints[i][uL + 5].y)/4);
		yAvg += yOffset;
		
		setTileIcons();
		
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
		
		boardTiles[i][tileNum].setTile(poly, i, tileNum);
		boardPieces[i][tileNum].setBounds(xAvg - 16, yAvg - 45, 32, 45);
		
		if(i == 0 || i == 1 || i == 2)
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
		g2.setColor(Color.BLACK);
		g2.draw(poly);
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
				if(boardTiles[4][j].getBoardLetter() == modelBoardLetter && boardTiles[4][j].getBoardNumber() == modelBoardNumber)
				{
					//Check if tile is selected
					boolean selected = theGame.getTheBoard().getSection0().getSegment0().getTiles(i).getSelected();
					
					if(theGame.getTheBoard().getSection0().getSegment0().getTiles(i).getPiece() != null)
					{
						PieceType type = theGame.getTheBoard().getSection0().getSegment0().getTiles(i).getPiece().getPieceType();
						int teamNumber = theGame.getTheBoard().getSection0().getSegment0().getTiles(i).getPiece().getPlayer().getNumber();
						boardPieces[4][j].setPieceImage(type, teamNumber, selected);

					}
					else
					{
						int teamNumber = 4;
						boardPieces[4][j].setPieceImage(null, teamNumber, selected);
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
				if(boardTiles[3][j].getBoardLetter() == modelBoardLetter && boardTiles[3][j].getBoardNumber() == modelBoardNumber)
				{
					//Check if tile is selected
					boolean selected = theGame.getTheBoard().getSection0().getSegment1().getTiles(i).getSelected();
					
					if(theGame.getTheBoard().getSection0().getSegment1().getTiles(i).getPiece() != null)
					{
						PieceType type = theGame.getTheBoard().getSection0().getSegment1().getTiles(i).getPiece().getPieceType();
						int teamNumber = theGame.getTheBoard().getSection0().getSegment1().getTiles(i).getPiece().getPlayer().getNumber();
						boardPieces[3][j].setPieceImage(type, teamNumber, selected);
					}
					else
					{
						int teamNumber = 4;
						boardPieces[3][j].setPieceImage(null, teamNumber, selected);
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
				if(boardTiles[0][j].getBoardLetter() == modelBoardLetter && boardTiles[0][j].getBoardNumber() == modelBoardNumber)
				{
					//Check if tile is selected
					boolean selected = theGame.getTheBoard().getSection1().getSegment0().getTiles(i).getSelected();
					
					if(theGame.getTheBoard().getSection1().getSegment0().getTiles(i).getPiece() != null)
					{
						PieceType type = theGame.getTheBoard().getSection1().getSegment0().getTiles(i).getPiece().getPieceType();
						int teamNumber = theGame.getTheBoard().getSection1().getSegment0().getTiles(i).getPiece().getPlayer().getNumber();
						boardPieces[0][j].setPieceImage(type, teamNumber, selected);
					}
					else
					{
						int teamNumber = 4;
						boardPieces[0][j].setPieceImage(null, teamNumber, selected);
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
				if(boardTiles[5][j].getBoardLetter() == modelBoardLetter && boardTiles[5][j].getBoardNumber() == modelBoardNumber)
				{
					//Check if tile is selected
					boolean selected = theGame.getTheBoard().getSection1().getSegment1().getTiles(i).getSelected();
					
					if(theGame.getTheBoard().getSection1().getSegment1().getTiles(i).getPiece() != null)
					{
						PieceType type = theGame.getTheBoard().getSection1().getSegment1().getTiles(i).getPiece().getPieceType();
						int teamNumber = theGame.getTheBoard().getSection1().getSegment1().getTiles(i).getPiece().getPlayer().getNumber();
						boardPieces[5][j].setPieceImage(type, teamNumber, selected);
					}
					else
					{
						int teamNumber = 4;
						boardPieces[5][j].setPieceImage(null, teamNumber, selected);
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
				if(boardTiles[2][j].getBoardLetter() == modelBoardLetter && boardTiles[2][j].getBoardNumber() == modelBoardNumber)
				{
					//Check if tile is selected
					boolean selected = theGame.getTheBoard().getSection2().getSegment0().getTiles(i).getSelected();
					
					if(theGame.getTheBoard().getSection2().getSegment0().getTiles(i).getPiece() != null)
					{
						PieceType type = theGame.getTheBoard().getSection2().getSegment0().getTiles(i).getPiece().getPieceType();
						int teamNumber = theGame.getTheBoard().getSection2().getSegment0().getTiles(i).getPiece().getPlayer().getNumber();
						boardPieces[2][j].setPieceImage(type, teamNumber, selected);
					}
					else
					{
						int teamNumber = 4;
						boardPieces[2][j].setPieceImage(null, teamNumber, selected);
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
				if(boardTiles[1][j].getBoardLetter() == modelBoardLetter && boardTiles[1][j].getBoardNumber() == modelBoardNumber)
				{
					//Check if the tile is selected
					boolean selected = theGame.getTheBoard().getSection2().getSegment1().getTiles(i).getSelected();
					
					if(theGame.getTheBoard().getSection2().getSegment1().getTiles(i).getPiece() != null)
					{
						PieceType type = theGame.getTheBoard().getSection2().getSegment1().getTiles(i).getPiece().getPieceType();
						int teamNumber = theGame.getTheBoard().getSection2().getSegment1().getTiles(i).getPiece().getPlayer().getNumber();
						boardPieces[1][j].setPieceImage(type, teamNumber, selected);
					}
					else
					{
						int teamNumber = 4;
						boardPieces[1][j].setPieceImage(null, teamNumber, selected);
					}
					break;
				}
			}
		}
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
		for (int i=0; i<6; i++)
		{
			for (int j=0; j<16; j++)
			{
				if(boardTiles[i][j].checkIfContained(e))
				{
					Click tileClicked = new Click(boardTiles[i][j].getBoardNumber(), boardTiles[i][j].getBoardLetter());
					theGame.getClick(tileClicked);
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