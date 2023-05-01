import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDAO {
    String name;
    String mail;
    String password;

    public UserDAO(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }

    public void signinUser (String name, String mail, String password){
        List<String> users = new ArrayList<>();
        List<String> mails = new ArrayList<>();
        ResultSet resultSet0 = DatabaseConnection.getDatabaseConnection().select("SELECT nombre_jugador FROM Jugador");
        ResultSet resultSet1 =  DatabaseConnection.getDatabaseConnection().select("SELECT correo FROM Jugador");
        boolean verify = false;

        try {
            while (resultSet0.next()){
                users.add(resultSet0.getString("nombre_jugador"));
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

        try {
            while (resultSet1.next()){
                mails.add(resultSet1.getString("correo"));
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

        for (String user : users) {
            if (!Objects.equals(user, name)){
                verify = true;
                break;
            }
        }

        if (verify){
            for (String m : mails) {
                if (!Objects.equals(m, mail)){
                    verify = true;
                    break;
                }else {
                    verify = false;
                }
            }
            if (verify){
                DatabaseConnection.getDatabaseConnection().insert("INSERT INTO Jugador(nombre_jugador, correo, contraseña) VALUES '" + name + "','" + mail + "','" + password + "';" );
            }
        }

    }

    public boolean loginUser (String name, String mail, String password){
        List<String> users = new ArrayList<>();
        ResultSet resultSet = DatabaseConnection.getDatabaseConnection().select("SELECT nombre_jugador FROM Jugador;");

        try {
            while (resultSet.next()){
                users.add(resultSet.getString("nombre_jugador"));
            }
            for (int i = 0; i < users.size(); i++) {
                if(Objects.equals(name, users.get(i))){
                    ResultSet resultSet1 = DatabaseConnection.getDatabaseConnection().select("SELECT correo FROM Jugador WHERE nombre_jugador = "+ name + ";");
                    if (Objects.equals(resultSet1.getString("correo"), mail)){
                        ResultSet resultSet2 = DatabaseConnection.getDatabaseConnection().select("SELECT contraseña FROM Jugador WHERE nombre_jugador = "+ name + ";");
                        if (Objects.equals(resultSet2.getString("contraseña"), password)){
                            return true;
                        }
                    }
                }
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return false;
    }

    //public void deleteUser ();

}
