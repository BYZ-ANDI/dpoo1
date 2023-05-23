package Business.entities;

import java.awt.Color;

public class Player {
    private String color;
    private boolean alive;
    private String room;

    public Player(String color, boolean alive, String room) {
        this.color = color;
        this.alive = alive;
        this.room = room;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isAlive() {
        return alive;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {
        this.room = room;
    }
}