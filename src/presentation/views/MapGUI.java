package presentation.views;

import Business.entities.Room;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

import persistence.MapsDAO;

public class MapGUI extends JFrame {
    private JPanel contentPanel;

    private java.util.Map<String, Color> createColorMap() {
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

    public MapGUI(List<Room> rooms) {
        // Set the title and size of the window
        setTitle("Map View");
        setSize(600, 400);

        // Create a content panel and set its layout
        contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(4, 4));

        Map<String, Color> colorMap = createColorMap();

        // Create a cell for each room
        for (Room room : rooms) {
            String colorName = room.getColour();
            Color color = colorMap.get(colorName);

            JLabel room1Label = new JLabel(room.getId());
            room1Label.setBackground(color); // set background color
            room1Label.setOpaque(true); // make the label opaque
            contentPanel.add(room1Label);
        }

        add(contentPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        List<Room> rooms;

        MapsDAO mapDAO = new MapsDAO();
        rooms = mapDAO.loadRooms("src/persistence/maps.json");
        new MapGUI(rooms);
    }
}
