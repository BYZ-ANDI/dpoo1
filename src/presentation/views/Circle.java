package presentation.views;

import javax.swing.*;
import java.awt.*;

public class Circle extends JPanel {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;
    private Graphics2D g2d;
    private Color color;


    public Circle(String color){
        setOpaque(true);
        if (color.equals("vermell")){
            this.color = Color.RED;
            repaint();
        }
        if (color.equals("blau")){
            this.color = Color.BLUE;
            repaint();
        }
        if (color.equals("verd")){
            this.color = Color.GREEN;
            repaint();
        }
        if (color.equals("rosa")){
            this.color = Color.PINK;
            repaint();
        }
        if (color.equals("taronja")){
            this.color = Color.ORANGE;
            repaint();
        }
        if (color.equals("groc")){
            this.color = Color.YELLOW;
            repaint();
        }
        if (color.equals("negre")){
            this.color = Color.BLACK;
            repaint();
        }
        if (color.equals("blanc")){
            this.color = Color.WHITE;
            repaint();
        }
        if (color.equals("lila")){
            this.color = new Color(200, 162, 200);
            repaint();
        }
        if (color.equals("marró")){
            this.color = new Color(139, 69, 19);
            repaint();
        }
        if (color.equals("cian")){
            this.color = Color.CYAN;
            repaint();
        }
        if (color.equals("llima")){
            this.color = new Color(50, 205, 50);
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int centerX = getWidth() / 2;
        int centerY = getWidth() / 2;
        int radius = Math.min(getWidth(), getHeight()) / 2;
        g.setColor(this.color);
        g.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);  // Draw the filled circle
        g.setColor(Color.BLACK);
        g.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);  // Draw the filled circle
    }

    public void setColor(String color){//
        if (color.equals("vermell")){
            this.color = Color.RED;
            repaint();
        }
        if (color.equals("blau")){
            this.color = Color.BLUE;
            repaint();
        }
        if (color.equals("verd")){
            this.color = Color.GREEN;
            repaint();
        }
        if (color.equals("rosa")){
            this.color = Color.PINK;
            repaint();
        }
        if (color.equals("taronja")){
            this.color = Color.ORANGE;
            repaint();
        }
        if (color.equals("groc")){
            this.color = Color.YELLOW;
            repaint();
        }
        if (color.equals("negre")){
            this.color = Color.BLACK;
            repaint();
        }
        if (color.equals("blanc")){
            this.color = Color.WHITE;
            repaint();
        }
        if (color.equals("lila")){
            this.color = new Color(200, 162, 200);
            repaint();
        }
        if (color.equals("marró")){
            this.color = new Color(139, 69, 19);
            repaint();
        }
        if (color.equals("cian")){
            this.color = Color.CYAN;
            repaint();
        }
        if (color.equals("llima")){
            this.color = new Color(50, 205, 50);
            repaint();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }
}
