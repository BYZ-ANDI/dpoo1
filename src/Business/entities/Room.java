package Business.entities;

public class Room {
    private String id;
    private String colour;
    private String direction1;
    private String direction1Name;
    private String direction2;
    private String direction2Name;
    private String direction3;
    private String direction3Name;
    private String ventDirection;

    public Room(String id, String colour, String direction1, String direction1Name, String direction2, String direction2Name, String direction3, String direction3Name, String ventDirection) {
        this.id = id;
        this.colour = colour;
        this.direction1 = direction1;
        this.direction1Name = direction1Name;
        this.direction2 = direction2;
        this.direction2Name = direction2Name;
        this.direction3 = direction3;
        this.direction3Name = direction3Name;
        this.ventDirection = ventDirection;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getDirection1() {
        return direction1;
    }

    public void setDirection1(String direction1) {
        this.direction1 = direction1;
    }

    public String getDirection1Name() {
        return direction1Name;
    }

    public void setDirection1Name(String direction1Name) {
        this.direction1Name = direction1Name;
    }

    public String getDirection2() {
        return direction2;
    }

    public void setDirection2(String direction2) {
        this.direction2 = direction2;
    }

    public String getDirection2Name() {
        return direction2Name;
    }

    public void setDirection2Name(String direction2Name) {
        this.direction2Name = direction2Name;
    }

    public String getDirection3() {
        return direction3;
    }

    public void setDirection3(String direction3) {
        this.direction3 = direction3;
    }

    public String getDirection3Name() {
        return direction3Name;
    }

    public void setDirection3Name(String direction3Name) {
        this.direction3Name = direction3Name;
    }

    public String getVentDirection() {
        return ventDirection;
    }

    public void setVentDirection(String ventDirection) {
        this.ventDirection = ventDirection;
    }
}
