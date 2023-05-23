package presentation.views;

import javax.swing.*;
import java.awt.*;

public class Circle extends JPanel {
    private static final int WIDTH = 40;
    private static final int HEIGHT = 40;

    public Circle(){
        setOpaque(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);  // Set the color of the circle
        int radius = Math.min(getWidth(), getHeight()) / 2;  // Calculate the radius based on the component size
        int centerX = getWidth() / 2;  // Calculate the x-coordinate of the center
        int centerY = getHeight() / 2;  // Calculate the y-coordinate of the center
        g.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);  // Draw the filled circle
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }
}
