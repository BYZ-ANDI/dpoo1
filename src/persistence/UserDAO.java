package persistence;

import Business.Entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDAO {
    public void signupUser (User user){
        List<String> users = new ArrayList<>();
        List<String> mails = new ArrayList<>();
        ResultSet resultSet0 = DatabaseConnection.getDatabaseConnection().select("SELECT nombre_jugador FROM Jugador;");
        ResultSet resultSet1 =  DatabaseConnection.getDatabaseConnection().select("SELECT correo FROM Jugador;");
        boolean verify = true;

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

        for (String player : users) {
            if (Objects.equals(player, user.getName())){
                verify = false;
                break;
            }
        }

        if (verify){
            for (String m : mails) {
                if (Objects.equals(m, user.getMail())){
                    verify = false;
                    break;
                }
            }
            if (verify){
                DatabaseConnection.getDatabaseConnection().insert("INSERT INTO Jugador(nombre_jugador, correo, contraseña, n_partidas_ganadas) VALUES ('" + user.getName() + "','" + user.getMail() + "','" + user.getPassword() + "','0');" );
            }
        }

    }

    public boolean loginUser (User user){
        List<String> users = new ArrayList<>();
        ResultSet resultSet = DatabaseConnection.getDatabaseConnection().select("SELECT nombre_jugador FROM Jugador;");

        try {
            while (resultSet.next()){
                users.add(resultSet.getString("nombre_jugador"));
            }
            for (int i = 0; i < users.size(); i++) {
                if(Objects.equals(user.getName(), users.get(i))){
                    ResultSet resultSet1 = DatabaseConnection.getDatabaseConnection().select("SELECT correo FROM Jugador WHERE nombre_jugador LIKE '" + user.getName() + "';");
                    resultSet1.next();
                    if (Objects.equals(resultSet1.getString("correo"), user.getMail())){
                        ResultSet resultSet2 = DatabaseConnection.getDatabaseConnection().select("SELECT contraseña FROM Jugador WHERE nombre_jugador LIKE '" + user.getName() + "';");
                        resultSet2.next();
                        if (Objects.equals(resultSet2.getString("contraseña"), user.getPassword())){
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

    public void deleteUser (User user, String name){
        DatabaseConnection.getDatabaseConnection().delete("DELETE FROM Jugador WHERE nombre_jugador LIKE '" + name +"';");
        user = null;
    }

    public void userLogout (UserDAO user){
        user = null;
    }


}

