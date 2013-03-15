package GUI_Interface;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import threePlayerChessa.Piece.PieceType;

/** Extension of JLabel used to hold an icon for a board tile.
 * <p>One instance for each of the 96 tiles, all owned by the instance of BoardGUI
 * <p>ImageIcons are set  based on information retrieved by <code>setTileIcons</code>
 * from the model's instance of the board.
 * <p>Holds all the ImageIcon resources.
 */
public class PieceGUI extends JLabel
{
	private static final long serialVersionUID = 1L;
	
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
	
    /** Method to expedite the initialization of an array of PieceGUIs
     * 
     * @param size The number of elements of the array.
     * @return The initialized array of PieceGUIs.
     */
	public static PieceGUI[] pieceSet(int size)
	{
		PieceGUI[] array = new PieceGUI[size];
		for(int i=0; i<size; i++)
		{
			array[i] = new PieceGUI();
		}
		return array;
	}
	
	/** Method to change the icon of a piece label.
	 * 
	 * <p>Called in loop by <code>setTileIcons()</code>
	 * 
	 * @param type Type of piece being set to the PieceGUI
	 * @param teamNumber Owner of the piece.
	 */
	public void setPieceImage(PieceType type, int teamNumber)
	{
		switch (teamNumber)
		{
			case 1:
				switch(type)
				{
					case PAWN:
						this.setIcon(RPawn);
						break;
					case ROOK:
						this.setIcon(RRook);
						break;
					case KNIGHT:
						this.setIcon(RKnight);
						break;
					case BISHOP:
						this.setIcon(RBishop);
						break;
					case QUEEN:
						this.setIcon(RQueen);
						break;
					case KING:
						this.setIcon(RKing);
						break;
					case NONE:
						this.setIcon(FTile);
						break;
				}
				break;
			case 2:
				switch(type)
				{
					case PAWN:
						this.setIcon(BPawn);
						break;
					case ROOK:
						this.setIcon(BRook);
						break;
					case KNIGHT:
						this.setIcon(BKnight);
						break;
					case BISHOP:
						this.setIcon(BBishop);
						break;
					case QUEEN:
						this.setIcon(BQueen);
						break;
					case KING:
						this.setIcon(BKing);
						break;
					case NONE:
						this.setIcon(FTile);
						break;
				}
				break;
			case 3:
				switch(type)
				{
					case PAWN:
						this.setIcon(GPawn);
						break;
					case ROOK:
						this.setIcon(GRook);
						break;
					case KNIGHT:
						this.setIcon(GKnight);
						break;
					case BISHOP:
						this.setIcon(GBishop);
						break;
					case QUEEN:
						this.setIcon(GQueen);
						break;
					case KING:
						this.setIcon(GKing);
						break;
					case NONE:
						this.setIcon(FTile);
						break;
				}
				break;
			case 4:
				this.setIcon(FTile);
				break;
		}
	}
	
}