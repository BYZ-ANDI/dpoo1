package persistence;

import Business.entities.Game;
import Business.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameDAO {

    public void gameRecord(Game game, User user, String color){
        List<String> games = new ArrayList<>();
        ResultSet resultSet = DatabaseConnection.getDatabaseConnection().select("SELECT nombre_partida FROM Partida;");
        boolean verify = true;

        try {
            while (resultSet.next()){
                games.add(resultSet.getString("nombre_partida"));
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

        for(String partida : games){
            if (Objects.equals(partida, game.getName())){
                verify = false;
                break;
            }
        }

        if (verify){
            DatabaseConnection.getDatabaseConnection().insert("INSERT INTO Partida(nombre_partida, n_personajes, n_impostores, mapa) VALUES ('" + game.getName() + "','" + game.getN_persponajes() + "','" + game.getN_impostores() + "','" + game.getMapa() + "');");
            DatabaseConnection.getDatabaseConnection().insert("INSERT INTO Jugada(nombre_jugador, nombre_partida, color_personaje) VALUES ('" + user.getName() + "','" + game.getName() + "','" + color + "');");
        }
    }

    public boolean startGame(Game game){
        List<String> games = new ArrayList<>();
        ResultSet resultSet = DatabaseConnection.getDatabaseConnection().select("SELECT nombre_partida FROM Partida;");

        try{
            while (resultSet.next()){
                games.add(resultSet.getString("nombre_partida"));
            }
            for(int i = 0; i < games.size(); i++){
                if(Objects.equals(game.getName(), games.get(i))){
                    return true;
                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return false;
    }
    /*
    public void deleteGame(Game game, String name){
        DatabaseConnection.getDatabaseConnection().delete("DELETE FROM Partida WHERE nombre_partida LIKE '" + name + "'");
        game = null;
    }*/

    public void saveGame(String partidaName, int n_personajes, int n_impostores, String mapa){
        String query = "UPDATE 'partida' SET 'n_personajes'='"+n_personajes+"','n_impostores'='"+n_impostores+"' WHERE 'nombre_partida'='"+partidaName+"'";
        DatabaseConnection.getDatabaseConnection().update(query);
    }
}