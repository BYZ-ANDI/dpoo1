package presentation.views;

import Business.entities.Player;
import Business.entities.Room;
import presentation.controllers.GameTrackingController;
import presentation.controllers.MainMenuController;
import presentation.model.MainModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class GameTrackingView extends JPanel {
    private JPanel jpUnknown, jpPers, jpSus, jpNoSus, jpMain;
    private JLabel jlUnknown, jlSus, jlNoSus, jlTitle;
    private MainModel mainModel;
    private List<Player> personajes;
    private GameTrackingController gameTrackingController;
    private JButton jbLeft, jbRight;
    public static final String LEFT_COMMAND = "LEFT_COMMAND";
    public static final String RIGHT_COMMAND = "RIGHT_COMMAND";

    public GameTrackingView(MainModel mainmodel, GameTrackingController gameTrackingController){
        this.mainModel = mainmodel;
        this.gameTrackingController = gameTrackingController;
    }
    private void configWindow() {
        setSize(900,650);
    }
    public void configLayout() {
        personajes = mainModel.getPers();
        configWindow();

        jpMain = new JPanel(new GridLayout(2, 3));

        jlUnknown = new JLabel("Unknown");
        jlSus = new JLabel("Suspicious");
        jlNoSus = new JLabel("No suspicious");

        jpUnknown = new JPanel();
        jpUnknown.setLayout(new BoxLayout(jpUnknown, BoxLayout.Y_AXIS));

        jpSus = new JPanel();
        jpSus.setLayout(new BoxLayout(jpSus, BoxLayout.Y_AXIS));

        jpNoSus = new JPanel();
        jpNoSus.setLayout(new BoxLayout(jpNoSus, BoxLayout.Y_AXIS));

        this.add(jpMain);
        jpMain.add(jlUnknown);
        jpMain.add(jlSus);
        jpMain.add(jlNoSus);

        jpMain.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jpMain.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
                BorderFactory.createEmptyBorder(20, 80, 20, 10)
        ));

        configAll();

        jpMain.add(jpUnknown);
        jpMain.add(jpSus);
        jpMain.add(jpNoSus);
    }
    public void actualizarVista() {
        jpUnknown.removeAll();
        jpSus.removeAll();
        jpNoSus.removeAll();

        configAll();

        revalidate();
        repaint();
    }
    public void start() {
        setVisible(true);
    }
    private Map<String, Color> createColorMap() {
        Map<String, Color> colorMap = new java.util.HashMap<>();
        colorMap.put("RED", Color.RED);
        colorMap.put("GRAY", Color.GRAY);
        colorMap.put("BLUE", Color.BLUE);
        colorMap.put("BLACK", Color.BLACK);
        colorMap.put("GREEN", Color.GREEN);
        colorMap.put("MAGENTA", Color.MAGENTA);
        colorMap.put("ORANGE", Color.ORANGE);
        return colorMap;
    }
    private void configAll() {
        for (Player personaje : personajes) {
            jpPers = new JPanel();
            jpPers.setBackground(createColorMap().get(personaje.getColor()));
            jpPers.setLayout(new BorderLayout());

            jlTitle = new JLabel(personaje.getColor());
            jlTitle.setBackground(createColorMap().get(personaje.getColor()));
            jlTitle.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            jbLeft = new JButton("<");
            jbLeft.putClientProperty("personaje", personaje);
            jbLeft.addActionListener(gameTrackingController);

            jbRight = new JButton(">");
            jbRight.putClientProperty("personaje", personaje);
            jbRight.addActionListener(gameTrackingController);

            jpPers.add(jlTitle, BorderLayout.CENTER);
            jpPers.add(jbLeft, BorderLayout.WEST);
            jpPers.add(jbRight, BorderLayout.EAST);

            if (personaje.getClasified().equals("Unknown")) {
                jpUnknown.add(jpPers);
            } else if (personaje.getClasified().equals("Suspicious")) {
                jpSus.add(jpPers);
            } else if (personaje.getClasified().equals("No suspicious")) {
                jpNoSus.add(jpPers);
            }
        }
    }
}


