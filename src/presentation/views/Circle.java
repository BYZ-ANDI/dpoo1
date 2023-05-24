package presentation.views;

import javax.swing.*;
import java.awt.*;

public class Circle extends JPanel {
    private static final int WIDTH = 40;
    private static final int HEIGHT = 40;
    private Graphics2D g2d;


    public Circle(){
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);  // Set the color of the circle
        int radius = Math.min(getWidth(), getHeight()) / 2;  // Calculate the radius based on the component size
        int centerX = getWidth() / 2;  // Calculate the x-coordinate of the center
        int centerY = getHeight() / 2;  // Calculate the y-coordinate of the center
        g.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);  // Draw the filled circle
    }

    public void setColor(String color){//
        if (color.equals("vermell")) g2d.setColor(Color.RED);
        if (color.equals("blau")) g2d.setColor(Color.BLUE);
        if (color.equals("verd")) g2d.setColor(Color.GREEN);
        if (color.equals("rosa")) g2d.setColor(Color.PINK);
        if (color.equals("taronja")) g2d.setColor(Color.ORANGE);
        if (color.equals("groc")) g2d.setColor(Color.YELLOW);
        if (color.equals("negre")) g2d.setColor(Color.BLACK);
        if (color.equals("blanc")) g2d.setColor(Color.WHITE);
        if (color.equals("lila")) g2d.setColor(new Color(200, 162, 200));
        if (color.equals("marró")) g2d.setColor(new Color(139, 69, 19));
        if (color.equals("cian")) g2d.setColor(Color.CYAN);
        if (color.equals("llima")) g2d.setColor(new Color(50, 205, 50));
    }





    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }
}
