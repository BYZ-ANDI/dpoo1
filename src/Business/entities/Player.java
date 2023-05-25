package Business.entities;

import java.awt.Color;

public class Player {
    private String color;
    private boolean alive;
    private String room;
    private String clasified;

    public Player(String color, boolean alive, String room, String clasified) {
        this.color = color;
        this.alive = alive;
        this.room = room;
        this.clasified = clasified;
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

    public String getClasified() {
        return clasified;
    }

    public void setClasified(String clasified) {
        this.clasified = clasified;
    }
}