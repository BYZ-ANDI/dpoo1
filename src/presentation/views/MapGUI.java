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
    private Circle circle;
    private int XCirclePosition;
    private int YCirclePosition;
    private String userColor;
    //--------------Creación matriz mapa--------------

    private  JPanel[][] cells;

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

    private void updateView(boolean isGlobalView, Map<String, Color> colorMap) {
        for (Component component : contentPanel.getComponents()) {
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                String colorName = label.getBackground().getRed() + "," + label.getBackground().getGreen() + "," + label.getBackground().getBlue();

                if (isGlobalView || label.getText().equals("Spawn")) {
                    // Global view or player's room, keep the color unchanged
                    label.setBackground(colorMap.get(colorName));
                } else {
                    // Limited view, darken the color of other rooms
                    label.setBackground(Color.DARK_GRAY);
                }
            }
        }
    }

    public MapGUI(MainModel mainModel) {
        this.mainModel = mainModel;
    }
    public void setColor(String color){
        this.userColor = color;
    }

    public void createMapGUI(){
        rooms = mainModel.getRooms();

        setSize(600, 400);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(5,5));
        mainPanel.setSize(600,600);

        contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(4, 4));

        Map<String, Color> colorMap = createColorMap();

        /*for (Room room : rooms) {
            String colorName = room.getColour();
            Color color = colorMap.get(colorName);

            JLabel roomLabel = new JLabel(room.getId());
            roomLabel.setBorder(new LineBorder(Color.black,1));
            roomLabel.setBackground(color);
            roomLabel.setOpaque(true);
            contentPanel.add(roomLabel);
        }*/
        cells = new JPanel[4][4];
        int iterador = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cells[i][j] = new JPanel();
                cells[i][j].setBorder(new LineBorder(Color.black,1));
                cells[i][j].setPreferredSize(new Dimension(150,150));
                String colorName = rooms.get(iterador).getColour();
                Color color = colorMap.get(colorName);
                JLabel roomLabel = new JLabel(rooms.get(iterador).getId());
                roomLabel.setBorder(new LineBorder(Color.black,1));
                roomLabel.setBackground(color);
                cells[i][j].setBackground(color);
                roomLabel.setOpaque(true);
                roomLabel.setSize(150,150);
                cells[i][j].add(roomLabel);
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
            circle = new Circle();
            //circle.setColor(userColor);
            cells[0][0].add(circle);
            YCirclePosition = 0;
            XCirclePosition = 0;
        //}
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
    }
    public int getYCirclePosition(){
        return YCirclePosition;
    }
    public int getXCirclePosition(){
        return XCirclePosition;
    }
    public void uptadeCirclePosition(int i, int j){
        YCirclePosition = i;
        XCirclePosition = j;
        cells[i][j].add(circle);
        repaint();
    }

    public List<Room> getRooms() {
        return rooms;
    }

    private class ToggleVisionListener implements ActionListener {
        private boolean isGlobalView = true;

        public void actionPerformed(ActionEvent e) {
            isGlobalView = !isGlobalView;
            Map<String, Color> colorMap = createColorMap();
            updateView(isGlobalView, colorMap);

            toggleVisionButton.setText(isGlobalView ? "Limited Vision" : "Global Vision");
            moveUpButton.setVisible(true);
            moveDownButton.setVisible(true);
            moveLeftButton.setVisible(true);
            moveRightButton.setVisible(true);
        }
    }
    /*public static void main(String[] args) {
        List<Room> rooms;
        MapsDAO mapDAO = new MapsDAO();
        rooms = mapDAO.loadRooms("src/persistence/maps.json");
        new MapGUI(rooms);
    }*/
}