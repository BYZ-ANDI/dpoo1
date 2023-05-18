package presentation.views;

import Business.entities.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import persistence.MapsDAO;

public class MapGUI extends JPanel {
    private JPanel contentPanel;
    private JButton toggleVisionButton;
    private JButton moveUpButton;
    private JButton moveDownButton;
    private JButton moveLeftButton;
    private JButton moveRightButton;


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

    public MapGUI(List<Room> rooms) {
        // Set the title and size of the window
        setSize(600, 400);

        // Create a content panel and set its layout
        contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(4, 4));

        Map<String, Color> colorMap = createColorMap();

        // Create a cell for each room
        for (Room room : rooms) {
            String colorName = room.getColour();
            Color color = colorMap.get(colorName);

            JLabel room1Label = new JLabel("");
            room1Label.setBackground(color); // set background color
            room1Label.setOpaque(true); // make the label opaque
            contentPanel.add(room1Label);
        }

        add(contentPanel);
        setVisible(true);

        toggleVisionButton = new JButton("Toggle Vision");
        moveUpButton = new JButton("Up");
        moveDownButton = new JButton("Down");
        moveLeftButton = new JButton("Left");
        moveRightButton = new JButton("Right");

        toggleVisionButton.addActionListener(new ToggleVisionListener());
        moveUpButton.addActionListener(new MoveUpListener());
        moveDownButton.addActionListener(new MoveDownListener());
        moveLeftButton.addActionListener(new MoveLeftListener());
        moveRightButton.addActionListener(new MoveRightListener());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(toggleVisionButton);
        buttonPanel.add(moveUpButton);
        buttonPanel.add(moveDownButton);
        buttonPanel.add(moveLeftButton);
        buttonPanel.add(moveRightButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }
    private class ToggleVisionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            boolean isGlobalView = !moveUpButton.isVisible();
            Map<String, Color> colorMap = createColorMap();
            updateView(isGlobalView, colorMap);

            toggleVisionButton.setText(isGlobalView ? "Limited Vision" : "Global Vision");
            moveUpButton.setVisible(!isGlobalView);
            moveDownButton.setVisible(!isGlobalView);
            moveLeftButton.setVisible(!isGlobalView);
            moveRightButton.setVisible(!isGlobalView);
        }
    }
    private class MoveUpListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // TODO: Implement the logic to move up
        }
    }

    private class MoveDownListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // TODO: Implement the logic to move down
        }
    }

    private class MoveLeftListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // TODO: Implement the logic to move left
        }
    }

    private class MoveRightListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // TODO: Implement the logic to move right
        }
    }

    /*public static void main(String[] args) {
        List<Room> rooms;
        MapsDAO mapDAO = new MapsDAO();
        rooms = mapDAO.loadRooms("src/persistence/maps.json");
        new MapGUI(rooms);
    }*/
}
