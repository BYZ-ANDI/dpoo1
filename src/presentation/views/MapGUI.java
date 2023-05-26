package presentation.views;

import Business.entities.Room;
import persistence.MapsDAO;
import presentation.controllers.GameController;
import presentation.model.MainModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapGUI extends JPanel {
    private MainModel mainModel;
    private List<Room> rooms;
    private JPanel contentPanel;
    private JButton toggleVisionButton = new JButton("Toggle Vision");
    private JButton moveUpButton = new JButton("Up");
    private JButton moveDownButton = new JButton("Down");
    private JButton moveLeftButton = new JButton("Left");
    private JButton moveRightButton = new JButton("Right");
    private JButton logoutButton = new JButton("Logout");
    private Circle circle;
    private int XCirclePosition;
    private int impostorXPosition;
    private int impostorYPosition;
    private int YCirclePosition;
    private String userColor;
    private Room[][] roomsMatrix = new Room[4][4];
    private Map<String, Color> colorMap;
    private  JPanel[][] cells;
    private JLabel roomLabel;
    private int numImpostores = 0;
    private int numTripulantes = 0;
    private JLabel status = new JLabel();
    private GameController gameController;
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

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public void setNumImpostores(int numImpostores, int numTripulantes) {
        this.numImpostores = numImpostores;
        this.numTripulantes = numTripulantes-numImpostores;
    }

    private String fromColorToRGB(String color){
        if (color.equals("RED")){
            return "255,0,0";
        }
        if (color.equals("BLUE")){
            return "25,135,189";
        }
        if (color.equals("GRAY")){
            return "111,116,119";
        }
        if (color.equals("BLACK")){
            return "0,0,0";
        }
        if (color.equals("GREEN")){
            return "48,144,50";
        }
        if (color.equals("MAGENTA")){
            return "207,52,118";
        }
        if (color.equals("ORANGE")){
            return "255,165,0";
        }
        return null;
    }
    public MapGUI(MainModel mainModel) {
        this.mainModel = mainModel;
    }
    public void setColor(String color){
        this.userColor = color;
    }

    public void createMapGUI(){
        rooms = mainModel.getRooms();

        setSize(600, 600);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(5,5));
        mainPanel.setSize(600,600);

        contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(4, 4));
        colorMap = createColorMap();
        cells = new JPanel[4][4];

        setRoomMatrix(rooms);

        int iterador = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cells[i][j] = new JPanel();
                cells[i][j].setBorder(new LineBorder(Color.white,1));
                cells[i][j].setPreferredSize(new Dimension(150,150));
                String colorName = rooms.get(iterador).getColour();
                String colorRGB = fromColorToRGB(colorName);
                String[] colorNameParts = colorRGB.split(",");
                roomLabel = new JLabel(rooms.get(iterador).getId());
                roomLabel.setBorder(new LineBorder(Color.black,1));
                roomLabel.setBackground(new Color(Integer.parseInt(colorNameParts[0]),Integer.parseInt(colorNameParts[1]),Integer.parseInt(colorNameParts[2]), (int) (0.2f * 127)));
                cells[i][j].setBackground(new Color(Integer.parseInt(colorNameParts[0]),Integer.parseInt(colorNameParts[1]),Integer.parseInt(colorNameParts[2]), (int) (0.2f * 127)));
                roomLabel.setOpaque(false);
                roomLabel.setSize(150,150);
                contentPanel.add(cells[i][j]);
                iterador++;
            }
        }
        mainPanel.add(contentPanel,BorderLayout.NORTH);
        setVisible(true);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(toggleVisionButton);
        buttonPanel.add(moveUpButton);
        buttonPanel.add(moveDownButton);
        buttonPanel.add(moveLeftButton);
        buttonPanel.add(moveRightButton);
        buttonPanel.add(logoutButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);
        // Add player circles to the map
        //for (Player player : players) {
            //JLabel playerLabel = new JLabel();
            //playerLabel.setOpaque(true);
            //playerLabel.setBackground(player.getPlayerColor());
            //playerLabel.setBackground(Color.white);
            //playerLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            //playerLabel.setVerticalAlignment(SwingConstants.CENTER);
            //playerLabel.setText(player.getPlayerName());
            //playerLabel.setText("Tripulante");
            circle = new Circle(userColor);
            //circle.setColor(userColor);
            cells[0][0].add(circle);
            String colorName = roomsMatrix[0][0].getColour();
            Color color = colorMap.get(colorName);
            cells[0][0].setBackground(color);
            circle.add(status);
            YCirclePosition = 0;
            XCirclePosition = 0;
        for (int i = 0; i < numImpostores; i++) {
            Circle circle2 = new Circle("blau");
            cells[0][0].add(circle2);
            String colorName2 = roomsMatrix[0][0].getColour();
            Color color2 = colorMap.get(colorName2);
            cells[0][0].setBackground(color2);
            impostorXPosition = 0;
            impostorYPosition = 0;
            gameController.setFila(impostorYPosition);
            gameController.setColumna(impostorXPosition);
            //gameController.startImposterManager();
        }
        for (int i = 0; i < numTripulantes-1; i++) {
            Circle circle2 = new Circle("groc");
            cells[0][0].add(circle2);
            String colorName2 = roomsMatrix[0][0].getColour();
            Color color2 = colorMap.get(colorName2);
            cells[0][0].setBackground(color2);
            YCirclePosition = 0;
            XCirclePosition = 0;
        }
    }

    private void setRoomMatrix(List<Room> rooms) {
        int iterador = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                roomsMatrix[i][j] = rooms.get(iterador);
                iterador++;
            }
        }
    }
    public void MapGUIController(ActionListener listener){
        moveUpButton.addActionListener(listener);
        moveUpButton.setActionCommand("up");
        moveDownButton.addActionListener(listener);
        moveDownButton.setActionCommand("down");
        moveLeftButton.addActionListener(listener);
        moveLeftButton.setActionCommand("left");
        moveRightButton.addActionListener(listener);
        moveRightButton.setActionCommand("right");
        toggleVisionButton.addActionListener(listener);
        toggleVisionButton.setActionCommand("toggle");
        logoutButton.addActionListener(listener);
        logoutButton.setActionCommand("logout");
    }
    public int getYCirclePosition(){
        return YCirclePosition;
    }
    public int getXCirclePosition(){
        return XCirclePosition;
    }
    public void uptadeCirclePosition(int i, int j){
        cells[YCirclePosition][XCirclePosition].setBackground(new Color(255,0,0, (int) (0.2f * 127)));
        YCirclePosition = i;
        XCirclePosition = j;
        cells[i][j].add(circle);
        String colorName = roomsMatrix[i][j].getColour();
        Color color = colorMap.get(colorName);
        cells[i][j].setBackground(color);
        status.setText("X");
        repaint();

    }
    public List<Room> getRooms() {
        return rooms;
    }
    public void seeMap() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String colorName = roomsMatrix[i][j].getColour();
                Color color = colorMap.get(colorName);
                cells[i][j].setBackground(color);
            }
        }
    }
    public void hideMap(){
        int iterador = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String colorName = rooms.get(iterador).getColour();
                String colorRGB = fromColorToRGB(colorName);
                String[] colorNameParts = colorRGB.split(",");
                roomLabel.setBackground(new Color(Integer.parseInt(colorNameParts[0]),Integer.parseInt(colorNameParts[1]),Integer.parseInt(colorNameParts[2]), (int) (0.2f * 127)));
                roomLabel.setOpaque(false);
                cells[i][j].setBackground(new Color(Integer.parseInt(colorNameParts[0]),Integer.parseInt(colorNameParts[1]),Integer.parseInt(colorNameParts[2]), (int) (0.2f * 127)));
                iterador++;
            }
        }
    }

    /*public static void main(String[] args) {
        List<Room> rooms;
        MapsDAO mapDAO = new MapsDAO();
        rooms = mapDAO.loadRooms("src/persistence/maps.json");
        new MapGUI(rooms);
    }*/
}