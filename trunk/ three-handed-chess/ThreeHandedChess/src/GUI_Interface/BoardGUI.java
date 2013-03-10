package GUI_Interface;

//public class Board 
//{
	
//}

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.GeneralPath;
import javax.swing.*;
import threePlayerChessa.Game;

public class BoardGUI extends JFrame implements MouseListener
{
	JLayeredPane layeredPane;
	JFrame chessBoard;
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
		this.theGame = aGame;
		initComponents();
		/*
		Dimension boardSize = new Dimension(600, 600);
		
		//Use Layered Pane
		
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(boardSize);
		layeredPane.addMouseListener(this);
		getContentPane().add(layeredPane);
		
		//Add a chess board to the Layered Pane
		
		chessBoard = new JPanel();
		chessBoard.setLayout(null);
		chessBoard.setPreferredSize(boardSize);
		chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
		
		layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
		
		//Build the Chess Board Squares
		Tile t1 = new Tile("a0");
		*/
	}

	private void initComponents()
	{
		chessBoard = new JFrame();
		chessBoard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int w = getWidth();
		int h = (int)(getWidth()*Math.cos(Math.PI/6));
		
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
		
		paintSection(a);
		paintSection(b);
		paintSection(c);
		paintSection(d);
		paintSection(e);
		paintSection(f);
	}
	
	public void paint(Graphics g)
	{
		/*
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		int w = getWidth();
		int h = (int)(getWidth()*Math.cos(Math.PI/6));
		
		g2.setPaintMode();
		
		g2.setColor(Color.white);
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.setPaint(Color.black);
		g2.setStroke(stroke);
		
		Coordinate[] a = Coordinate.CoordinateSet(25);
		Coordinate[] b = Coordinate.CoordinateSet(25);
		Coordinate[] c = Coordinate.CoordinateSet(25);
		Coordinate[] d = Coordinate.CoordinateSet(25);
		Coordinate[] e = Coordinate.CoordinateSet(25);
		Coordinate[] f = Coordinate.CoordinateSet(25);
		
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
		
		paintSection(g, a);
		paintSection(g, b);
		paintSection(g, c);
		paintSection(g, d);
		paintSection(g, e);
		paintSection(g, f);
		*/
	}
	
	public void paintSection(CoordinateGUI[] sec)
	{
		for (int i = 0; i < 19; i++)
		{
			if (i != 4 && i != 9 && i != 14)
			{
				paintTile(sec, i);
			}
		}
	}
	
	public void paintTile(CoordinateGUI[] sec, int uL)
	{
		
		int yOffset = 50;
		int xPoints[] = {(int)sec[uL].x, (int)sec[uL + 1].x, (int)sec[uL + 6].x, (int)sec[uL + 5].x, (int)sec[uL].x};
		int yPoints[] = {(int)sec[uL].y, (int)sec[uL + 1].y, (int)sec[uL + 6].y, (int)sec[uL + 5].y, (int)sec[uL].y};
		
		final Polygon poly = new Polygon(xPoints, yPoints, xPoints.length);
		
		JPanel p = new JPanel()
		{
			@Override
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.setColor(Color.black);
				g.drawPolygon(poly);
			}
			
			@Override
			public Dimension getPreferredSize()
			{
				return new Dimension(600,600);
			}
		};
		
		
		
/*
		GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xPoints.length);
		polyline.moveTo (xPoints[0], yPoints[0] + yOffset);
		
		for (int i = 1; i < xPoints.length; i++)
		{
		         polyline.lineTo(xPoints[i], yPoints[i] + yOffset);
		}
		g2.draw(polyline);
*/
	}
	
	public static void main(String s[])
	{
		JFrame frame = new BoardGUI(null);
		//Board board = new Board();
		
		//JFrame frame = new JFrame("Three Handed Chess");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//frame.add(board);
        frame.setSize(600,600);
        frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
