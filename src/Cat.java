import javax.swing.JPanel;


import java.awt.*;
import java.awt.geom.*;

public class Cat {
	// drawing constants are private - noone needs to know what we're doing
	// pick a head dimension
	private static final int HEAD_DIMENSION = 100;
	// eyes will be about 1/4 from top of head and 1/4 from left
	private static final int EYE_Y = HEAD_DIMENSION/4;
	private static final int EYE_X = HEAD_DIMENSION/4;
	private static final int EYE_SEPARATION = HEAD_DIMENSION/2;
	// pick eye dimensions
	private static final int EYE_HEIGHT = 20;
	private static final int EYE_WIDTH = 15;
	// pick mouth height, width is based on head dimension
	private static final int MOUTH_HEIGHT = 30;
	private static final int MOUTH_WIDTH = HEAD_DIMENSION/4;
	// mouth starts about 40% from left edge of head
	private static final int MOUTH_X = HEAD_DIMENSION/5 * 2;
	private static final int MOUTH_Y = HEAD_DIMENSION/5 * 3;
	
	// draw will render the Cat on the Graphics object
	public void draw(Graphics g, int catX, int catY)
	{
		Graphics2D g2 = (Graphics2D) g;
		int x=catX;
		int y=catY;
		// Draw the head
		g2.setColor(Color.white);
		g2.fillOval(x, y, HEAD_DIMENSION, (int)(HEAD_DIMENSION/1.1));
		// Draw the eyes
		g2.setColor(Color.green);
		x = catX + EYE_X; 
		y = catY + EYE_Y;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		x += EYE_SEPARATION - EYE_WIDTH;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		// Draw the mouth
		g2.setColor(Color.pink);
		x = catX + MOUTH_X;
		y = catY + MOUTH_Y;
		g2.fillOval(x, y, MOUTH_WIDTH, MOUTH_HEIGHT);
		
		int[] triX = {HEAD_DIMENSION/2,2*HEAD_DIMENSION/3,HEAD_DIMENSION};
		int[] triY = {8*HEAD_DIMENSION/9,HEAD_DIMENSION/3,3*HEAD_DIMENSION/6};
		g2.setColor(Color.white);
		g2.fillPolygon(triX, triY, 3);
		
		triX[1] =85;
		for(int i  = 0; i < triX.length; i++)
			triX[i] += HEAD_DIMENSION/2;
		triY[0] = 3*HEAD_DIMENSION/6;
		triY[2]=8*HEAD_DIMENSION/9;
		g2.setColor(Color.white);
		g2.fillPolygon(triX, triY, 3);
		
		// Meow text appears below cat head, +10 places below 
		// so it doesn't overlap the drawing
		g2.drawString("Meow", catX, catY+HEAD_DIMENSION+10);	
	}
}
