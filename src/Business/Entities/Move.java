package Business.Entities;

public class Move {

    String Name;
    String Player;
    String Color_Character;

    public Move(String Name, String Player, String Color_Character) {
        this.Name = Name;
        this.Player = Player;
        this.Color_Character = Color_Character;
    }

    public String getName(){return this.Name;}
    public void setName(String name){this.Name = name;}
    public String getPlayer(){return this.Player;}
    public void setPlayer(String player){this.Player = player;}
    public String getColor_Character(){return this.Color_Character;}
    public void setColor_Character(String color_Character){this.Color_Character = color_Character;}

}
