package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class SierpinskiTriangle extends JPanel {

    private int depth;

    public SierpinskiTriangle(int depth) {
        this.depth = depth;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        drawSierpinski(g2d, depth, width / 2, 0, 0, height, width, height);
    }

    private void drawSierpinski(Graphics2D g2d, int depth, int x1, int y1, int x2, int y2, int x3, int y3) {
    	int[] x = {x1, x2, x3};
        int[] y = {y1, y2, y3};
        
    	if (depth == 0) {
            g2d.fillPolygon(x, y, 3);
        } else {
        	int midx[] = {(x1 + x2) / 2, (x2 + x3) / 2, (x1 + x3) / 2};
        	int midy[] = {(y1 + y2) / 2, (y2 + y3) / 2, (y1 + y3) / 2};
            drawSierpinski(g2d, depth - 1, x[0], y[0], midx[0], midy[0], midx[2], midy[2]);
            drawSierpinski(g2d, depth - 1, midx[0], midy[0], x[1], y[1], midx[1], midy[1]);
            drawSierpinski(g2d, depth - 1, midx[2], midy[2], midx[1], midy[1], x[2], y[2]);
        }
    }

    public static void main(String[] args) {
        int depth = 1; // Puedes ajustar la profundidad del triángulo de Sierpinski aquí
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Triángulo de Sierpinski");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new SierpinskiTriangle(depth));
            frame.setSize(500, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
