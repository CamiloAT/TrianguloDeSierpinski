package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class TrianglePanel extends JPanel{

	private int level;
	
	public TrianglePanel(int level) {
		this.level = level;
	}
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        this.drawSierpinski(g2d, this.level, 450 / 2, 0, 0, 450, 450, 450);
    }

    private void drawSierpinski(Graphics2D g2d, int depth, int x1, int y1, int x2, int y2, int x3, int y3) {
    	int[] x = {x1, x2, x3};
        int[] y = {y1, y2, y3};
    	if (depth == 0) {
    		g2d.setColor(new Color(255, 151, 71));
            g2d.fillPolygon(x, y, 3);
        } else {
        	int midx[] = {(x1 + x2) / 2, (x2 + x3) / 2, (x1 + x3) / 2};
        	int midy[] = {(y1 + y2) / 2, (y2 + y3) / 2, (y1 + y3) / 2};
            drawSierpinski(g2d, depth - 1, x[0], y[0], midx[0], midy[0], midx[2], midy[2]);
            drawSierpinski(g2d, depth - 1, midx[0], midy[0], x[1], y[1], midx[1], midy[1]);
            drawSierpinski(g2d, depth - 1, midx[2], midy[2], midx[1], midy[1], x[2], y[2]);
        }
    }
}
