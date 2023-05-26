package Business.entities;

import java.time.LocalDateTime;

public class Logs {
    private Player character;
    private Room room;
    private LocalDateTime timestamp;

    public Logs(Player character, Room room, LocalDateTime timestamp) {
        this.character = character;
        this.room = room;
        this.timestamp = timestamp;
    }

    public Player getCharacter() {
        return character;
    }

    public void setCharacter(Player character) {
        this.character = character;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
