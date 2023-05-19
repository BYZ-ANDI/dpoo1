package Business.entities;

import java.awt.Color;

public class Player {
    private String name;
    private int totalCharacters;
    private int imposters;
    private Color color;
    private String mapFilePath;

    public Player(String name, int totalCharacters, int imposters, Color color, String mapFilePath) {
        this.name = name;
        this.totalCharacters = totalCharacters;
        this.imposters = imposters;
        this.color = color;
        this.mapFilePath = mapFilePath;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalCharacters() {
        return totalCharacters;
    }

    public void setTotalCharacters(int totalCharacters) {
        this.totalCharacters = totalCharacters;
    }

    public int getImposters() {
        return imposters;
    }

    public void setImposters(int imposters) {
        this.imposters = imposters;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getMapFilePath() {
        return mapFilePath;
    }

    public void setMapFilePath(String mapFilePath) {
        this.mapFilePath = mapFilePath;
    }
}