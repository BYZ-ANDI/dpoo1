import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    String name;
    String mail;

    public UserDAO(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    public void loginUser(String name, String mail){
        List<String> users = new ArrayList<>();
        ResultSet resultSet = DatabaseConnection.getDatabaseConnection().select("SELECT nombre_jugador FROM Jugador");

        try {
            while (resultSet.next()){
                users.add(resultSet.getString("nombre_jugador"));
            }

        }catch(SQLException throwables){
            throwables.printStackTrace();
        }

    }


}
