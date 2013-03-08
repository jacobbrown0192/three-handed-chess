package GUI_Interface;

//public class Board 
//{
	
//}

import java.awt.*;
import java.awt.geom.GeneralPath;

import javax.swing.*;

public class Board extends JPanel
{
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
	
	public Board()
	{
		
	}
	
	public void paint(Graphics g)
	{
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		double x1, y1, x2, y2;
		int w = getWidth();
		int h = (int)(getWidth()*Math.cos(Math.PI/6));
		
		g2.setPaintMode();
		
		g2.setColor(Color.white);
		g2.fillRect(0, 0, getWidth(), getHeight());
		
		Coordinate[] a = Coordinate.CoordinateSet(25);
		Coordinate[] b = Coordinate.CoordinateSet(25);
		Coordinate[] c = Coordinate.CoordinateSet(25);
		Coordinate[] d = Coordinate.CoordinateSet(25);
		Coordinate[] e = Coordinate.CoordinateSet(25);
		Coordinate[] f = Coordinate.CoordinateSet(25);
	
//		a[0].setX((1/4)*((double)w));
		double test;
		test = (w/4);
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
		g2.setPaint(Color.black);
		g2.setStroke(stroke);
		
		//Draw A
		int x2Points[] = {(int)a[0].x, (int)a[4].x, (int)a[24].x, (int)a[20].x, (int)a[0].x};
		int y2Points[] = {(int)a[0].y, (int)a[4].y, (int)a[24].y, (int)a[20].y, (int)a[0].y};
		GeneralPath polyline1 = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x2Points.length);
		polyline1.moveTo (x2Points[0], y2Points[0]);
		for (int i = 1; i < x2Points.length; i++)
		{
		         polyline1.lineTo(x2Points[i], y2Points[i]);
		}
		g2.draw(polyline1);
		
		//Draw B
		GeneralPath polyline2 = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x2Points.length);
		for (int i = 0; i < x2Points.length; i++)
		{
			switch(i)
			{
			case 0:
				x2Points[i] = (int)b[0].x;
				y2Points[i] = (int)b[0].y;
				break;
			case 1:
				x2Points[i] = (int)b[4].x;
				y2Points[i] = (int)b[4].y;
				break;
			case 2:
				x2Points[i] = (int)b[24].x;
				y2Points[i] = (int)b[24].y;
				break;
			case 3:
				x2Points[i] = (int)b[20].x;
				y2Points[i] = (int)b[20].y;
				break;
			case 4:
				x2Points[i] = (int)b[0].x;
				y2Points[i] = (int)b[0].y;
				break;
			}
		}
		polyline2.moveTo (x2Points[0], y2Points[0]);
		for (int index = 1; index < x2Points.length; index++) {
		         polyline2.lineTo(x2Points[index], y2Points[index]);
		}
		g2.draw(polyline2);
		
		//Draw C
		GeneralPath polyline3 = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x2Points.length);
		for (int i = 0; i < x2Points.length; i++)
		{
			switch(i)
			{
			case 0:
				x2Points[i] = (int)c[0].x;
				y2Points[i] = (int)c[0].y;
				break;
			case 1:
				x2Points[i] = (int)c[4].x;
				y2Points[i] = (int)c[4].y;
				break;
			case 2:
				x2Points[i] = (int)c[24].x;
				y2Points[i] = (int)c[24].y;
				break;
			case 3:
				x2Points[i] = (int)c[20].x;
				y2Points[i] = (int)c[20].y;
				break;
			case 4:
				x2Points[i] = (int)c[0].x;
				y2Points[i] = (int)c[0].y;
				break;
			}
		}
		polyline3.moveTo (x2Points[0], y2Points[0]);
		for (int index = 1; index < x2Points.length; index++) {
		         polyline3.lineTo(x2Points[index], y2Points[index]);
		}
		g2.draw(polyline3);
		
		//Draw D
		GeneralPath polyline4 = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x2Points.length);
		for (int i = 0; i < x2Points.length; i++)
		{
			switch(i)
			{
			case 0:
				x2Points[i] = (int)d[0].x;
				y2Points[i] = (int)d[0].y;
				break;
			case 1:
				x2Points[i] = (int)d[4].x;
				y2Points[i] = (int)d[4].y;
				break;
			case 2:
				x2Points[i] = (int)d[24].x;
				y2Points[i] = (int)d[24].y;
				break;
			case 3:
				x2Points[i] = (int)d[20].x;
				y2Points[i] = (int)d[20].y;
				break;
			case 4:
				x2Points[i] = (int)d[0].x;
				y2Points[i] = (int)d[0].y;
				break;
			}
		}
		polyline4.moveTo (x2Points[0], y2Points[0]);
		for (int index = 1; index < x2Points.length; index++) {
		         polyline4.lineTo(x2Points[index], y2Points[index]);
		}
		g2.draw(polyline4);
		
		//Draw E
		GeneralPath polyline5 = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x2Points.length);
		for (int i = 0; i < x2Points.length; i++)
		{
			switch(i)
			{
			case 0:
				x2Points[i] = (int)e[0].x;
				y2Points[i] = (int)e[0].y;
				break;
			case 1:
				x2Points[i] = (int)e[4].x;
				y2Points[i] = (int)e[4].y;
				break;
			case 2:
				x2Points[i] = (int)e[24].x;
				y2Points[i] = (int)e[24].y;
				break;
			case 3:
				x2Points[i] = (int)e[20].x;
				y2Points[i] = (int)e[20].y;
				break;
			case 4:
				x2Points[i] = (int)e[0].x;
				y2Points[i] = (int)e[0].y;
				break;
			}
		}
		polyline5.moveTo (x2Points[0], y2Points[0]);
		for (int index = 1; index < x2Points.length; index++) {
		         polyline5.lineTo(x2Points[index], y2Points[index]);
		}
		g2.draw(polyline5);
		
		//Draw F
		GeneralPath polyline6 = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x2Points.length);
		for (int i = 0; i < x2Points.length; i++)
		{
			switch(i)
			{
			case 0:
				x2Points[i] = (int)f[0].x;
				y2Points[i] = (int)f[0].y;
				break;
			case 1:
				x2Points[i] = (int)f[4].x;
				y2Points[i] = (int)f[4].y;
				break;
			case 2:
				x2Points[i] = (int)f[24].x;
				y2Points[i] = (int)f[24].y;
				break;
			case 3:
				x2Points[i] = (int)f[20].x;
				y2Points[i] = (int)f[20].y;
				break;
			case 4:
				x2Points[i] = (int)f[0].x;
				y2Points[i] = (int)f[0].y;
				break;
			}
		}
		polyline6.moveTo (x2Points[0], y2Points[0]);
		for (int index = 1; index < x2Points.length; index++) {
		         polyline6.lineTo(x2Points[index], y2Points[index]);
		}
		g2.draw(polyline6);	
	}
	
	public static void main(String s[])
	{
		Board board = new Board();
		
		JFrame frame = new JFrame("ThreeHandedChessBoard");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(board);
        frame.setSize(500,600);
        frame.setVisible(true);
	}
}