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
	private ImageIcon ATile = new ImageIcon(getClass().getResource("/resources/Accessed Tile.png"));
	
	private ImageIcon GKing = new ImageIcon(getClass().getResource("/resources/Green King.png"));
	private ImageIcon GQueen  = new ImageIcon(getClass().getResource("/resources/Green Queen.png"));
	private ImageIcon GBishop = new ImageIcon(getClass().getResource("/resources/Green Bishop.png"));
	private ImageIcon GRook = new ImageIcon(getClass().getResource("/resources/Green Rook.png"));
	private ImageIcon GKnight = new ImageIcon(getClass().getResource("/resources/Green Knight.png"));
	private ImageIcon GPawn = new ImageIcon(getClass().getResource("/resources/Green Pawn.png"));
	private ImageIcon GKingSel = new ImageIcon(getClass().getResource("/resources/Green King Selected.png"));
	private ImageIcon GQueenSel  = new ImageIcon(getClass().getResource("/resources/Green Queen Selected.png"));
	private ImageIcon GBishopSel = new ImageIcon(getClass().getResource("/resources/Green Bishop Selected.png"));
	private ImageIcon GRookSel = new ImageIcon(getClass().getResource("/resources/Green Rook Selected.png"));
	private ImageIcon GKnightSel = new ImageIcon(getClass().getResource("/resources/Green Knight Selected.png"));
	private ImageIcon GPawnSel = new ImageIcon(getClass().getResource("/resources/Green Pawn Selected.png"));
	private ImageIcon GKingAtt = new ImageIcon(getClass().getResource("/resources/Green King Attacked.png"));
	private ImageIcon GQueenAtt  = new ImageIcon(getClass().getResource("/resources/Green Queen Attacked.png"));
	private ImageIcon GBishopAtt = new ImageIcon(getClass().getResource("/resources/Green Bishop Attacked.png"));
	private ImageIcon GRookAtt = new ImageIcon(getClass().getResource("/resources/Green Rook Attacked.png"));
	private ImageIcon GKnightAtt = new ImageIcon(getClass().getResource("/resources/Green Knight Attacked.png"));
	private ImageIcon GPawnAtt = new ImageIcon(getClass().getResource("/resources/Green Pawn Attacked.png"));
	
	private ImageIcon BKing = new ImageIcon(getClass().getResource("/resources/Blue King.png"));
	private ImageIcon BQueen = new ImageIcon(getClass().getResource("/resources/Blue Queen.png"));
	private ImageIcon BBishop = new ImageIcon(getClass().getResource("/resources/Blue Bishop.png"));
	private ImageIcon BRook = new ImageIcon(getClass().getResource("/resources/Blue Rook.png"));
	private ImageIcon BKnight = new ImageIcon(getClass().getResource("/resources/Blue Knight.png"));
	private ImageIcon BPawn = new ImageIcon(getClass().getResource("/resources/Blue Pawn.png"));
	private ImageIcon BKingSel = new ImageIcon(getClass().getResource("/resources/Blue King Selected.png"));
	private ImageIcon BQueenSel = new ImageIcon(getClass().getResource("/resources/Blue Queen Selected.png"));
	private ImageIcon BBishopSel = new ImageIcon(getClass().getResource("/resources/Blue Bishop Selected.png"));
	private ImageIcon BRookSel = new ImageIcon(getClass().getResource("/resources/Blue Rook Selected.png"));
	private ImageIcon BKnightSel = new ImageIcon(getClass().getResource("/resources/Blue Knight Selected.png"));
	private ImageIcon BPawnSel = new ImageIcon(getClass().getResource("/resources/Blue Pawn Selected.png"));
	private ImageIcon BKingAtt = new ImageIcon(getClass().getResource("/resources/Blue King Attacked.png"));
	private ImageIcon BQueenAtt = new ImageIcon(getClass().getResource("/resources/Blue Queen Attacked.png"));
	private ImageIcon BBishopAtt = new ImageIcon(getClass().getResource("/resources/Blue Bishop Attacked.png"));
	private ImageIcon BRookAtt = new ImageIcon(getClass().getResource("/resources/Blue Rook Attacked.png"));
	private ImageIcon BKnightAtt = new ImageIcon(getClass().getResource("/resources/Blue Knight Attacked.png"));
	private ImageIcon BPawnAtt = new ImageIcon(getClass().getResource("/resources/Blue Pawn Attacked.png"));
	
	private ImageIcon RKing = new ImageIcon(getClass().getResource("/resources/Red King.png"));
	private ImageIcon RQueen = new ImageIcon(getClass().getResource("/resources/Red Queen.png"));
	private ImageIcon RBishop = new ImageIcon(getClass().getResource("/resources/Red Bishop.png"));
	private ImageIcon RRook = new ImageIcon(getClass().getResource("/resources/Red Rook.png"));
	private ImageIcon RKnight = new ImageIcon(getClass().getResource("/resources/Red Knight.png"));
	private ImageIcon RPawn = new ImageIcon(getClass().getResource("/resources/Red Pawn.png"));
	private ImageIcon RKingSel = new ImageIcon(getClass().getResource("/resources/Red King Selected.png"));
	private ImageIcon RQueenSel = new ImageIcon(getClass().getResource("/resources/Red Queen Selected.png"));
	private ImageIcon RBishopSel = new ImageIcon(getClass().getResource("/resources/Red Bishop Selected.png"));
	private ImageIcon RRookSel = new ImageIcon(getClass().getResource("/resources/Red Rook Selected.png"));
	private ImageIcon RKnightSel = new ImageIcon(getClass().getResource("/resources/Red Knight Selected.png"));
	private ImageIcon RPawnSel = new ImageIcon(getClass().getResource("/resources/Red Pawn Selected.png"));
	private ImageIcon RKingAtt = new ImageIcon(getClass().getResource("/resources/Red King Attacked.png"));
	private ImageIcon RQueenAtt = new ImageIcon(getClass().getResource("/resources/Red Queen Attacked.png"));
	private ImageIcon RBishopAtt = new ImageIcon(getClass().getResource("/resources/Red Bishop Attacked.png"));
	private ImageIcon RRookAtt = new ImageIcon(getClass().getResource("/resources/Red Rook Attacked.png"));
	private ImageIcon RKnightAtt = new ImageIcon(getClass().getResource("/resources/Red Knight Attacked.png"));
	private ImageIcon RPawnAtt = new ImageIcon(getClass().getResource("/resources/Red Pawn Attacked.png"));
	
    /** Method to expedite the initialization of an array of PieceGUIs
     * 
     * @param size The number of elements of the array.
     * @return The initialized array of PieceGUIs.
     */
	public static PieceGUI[][] pieceSet(int widthSize, int depthSize)
	{
		PieceGUI[][] array = new PieceGUI[widthSize][depthSize];
		for(int i=0; i < widthSize; i++)
		{
			for(int j=0; j < depthSize; j++)
			{
				array[i][j] = new PieceGUI();
			}
		}
		return array;
	}
	
	/** Method to change the icon of a piece label.
	 * 
	 * <p>Called in loop by <code>setTileIcons()</code>
	 * 
	 * @param type Type of piece being set to the PieceGUI
	 * @param teamNumber Owner of the piece.
	 * @param selected 
	 */
	public void setPieceImage(PieceType type, int teamNumber, boolean selected, boolean attacked, boolean accessed)
	{
		switch (teamNumber)
		{
			case 1:
				switch(type)
				{
					case PAWN:
						if(selected)
						{
							this.setIcon(RPawnSel);
						} else if(attacked)
						{
							this.setIcon(RPawnAtt);
						} else
						{
							this.setIcon(RPawn);
						}
						break;
					case ROOK:
						if(selected)
						{
							this.setIcon(RRookSel);
						} else if(attacked)
						{
							this.setIcon(RRookAtt);
						} else
						{
							this.setIcon(RRook);
						}
						break;
					case KNIGHT:
						if(selected)
						{
							this.setIcon(RKnightSel);
						} else if(attacked)
						{
							this.setIcon(RKnightAtt);
						} else
						{
							this.setIcon(RKnight);
						}
						break;
					case BISHOP:
						if(selected)
						{
							this.setIcon(RBishopSel);
						} else if(attacked)
						{
							this.setIcon(RBishopAtt);
						} else
						{
							this.setIcon(RBishop);
						}
						break;
					case QUEEN:
						if(selected)
						{
							this.setIcon(RQueenSel);
						} else if(attacked)
						{
							this.setIcon(RQueenAtt);
						} else
						{
							this.setIcon(RQueen);
						}
						break;
					case KING:
						if(selected)
						{
							this.setIcon(RKingSel);
						} else if(attacked)
						{
							this.setIcon(RKingAtt);
						} 
						else
						{
							this.setIcon(RKing);
						}
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
					if(selected)
					{
						this.setIcon(BPawnSel);
					} else if(attacked)
					{
						this.setIcon(BPawnAtt);
					} else
					{
						this.setIcon(BPawn);
					}
					break;
				case ROOK:
					if(selected)
					{
						this.setIcon(BRookSel);
					} else if(attacked)
					{
						this.setIcon(BRookAtt);
					} else
					{
						this.setIcon(BRook);
					}
					break;
				case KNIGHT:
					if(selected)
					{
						this.setIcon(BKnightSel);
					} else if(attacked)
					{
						this.setIcon(BKnightAtt);
					} else
					{
						this.setIcon(BKnight);
					}
					break;
				case BISHOP:
					if(selected)
					{
						this.setIcon(BBishopSel);
					} else if(attacked)
					{
						this.setIcon(BBishopAtt);
					} else
					{
						this.setIcon(BBishop);
					}
					break;
				case QUEEN:
					if(selected)
					{
						this.setIcon(BQueenSel);
					} else if(attacked)
					{
						this.setIcon(BQueenAtt);
					} else
					{
						this.setIcon(BQueen);
					}
					break;
				case KING:
					if(selected)
					{
						this.setIcon(BKingSel);
					} else if(attacked)
					{
						this.setIcon(BKingAtt);
					} else
					{
						this.setIcon(BKing);
					}
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
					if(selected)
					{
						this.setIcon(GPawnSel);
					} else if(attacked)
					{
						this.setIcon(GPawnAtt);
					} else
					{
						this.setIcon(GPawn);
					}
					break;
				case ROOK:
					if(selected)
					{
						this.setIcon(GRookSel);
					} else if(attacked)
					{
						this.setIcon(GRookAtt);
					} else
					{
						this.setIcon(GRook);
					}
					break;
				case KNIGHT:
					if(selected)
					{
						this.setIcon(GKnightSel);
					} else if(attacked)
					{
						this.setIcon(GKnightAtt);
					} else
					{
						this.setIcon(GKnight);
					}
					break;
				case BISHOP:
					if(selected)
					{
						this.setIcon(GBishopSel);
					} else if(attacked)
					{
						this.setIcon(GBishopAtt);
					} else
					{
						this.setIcon(GBishop);
					}
					break;
				case QUEEN:
					if(selected)
					{
						this.setIcon(GQueenSel);
					} else if(attacked)
					{
						this.setIcon(GQueenAtt);
					} else
					{
						this.setIcon(GQueen);
					}
					break;
				case KING:
					if(selected)
					{
						this.setIcon(GKingSel);
					} else if(attacked)
					{
						this.setIcon(GKingAtt);
					} else
					{
						this.setIcon(GKing);
					}
					break;
				case NONE:
					this.setIcon(FTile);
					break;
				}
				break;
			case 4:
				if (accessed)
				{
					this.setIcon(ATile);
				} else
				{
					this.setIcon(FTile);
				}
				break;
		}
	}
	
}