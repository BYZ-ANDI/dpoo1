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
    public Game startGame(String name_game, String new_game_name, Game game){

        try{
            ResultSet resultSet1 = DatabaseConnection.getDatabaseConnection().select("SELECT n_personajes FROM Partida WHERE nombre_partida LIKE '"+name_game+"';");
            ResultSet resultSet2 = DatabaseConnection.getDatabaseConnection().select("SELECT n_impostores FROM Partida WHERE nombre_partida LIKE '"+name_game+"';");
            ResultSet resultSet3 = DatabaseConnection.getDatabaseConnection().select("SELECT mapa FROM Partida WHERE nombre_partida LIKE'"+name_game+"';");
            game.setName(new_game_name);
            resultSet1.next();
            game.setN_persponajes(resultSet1.getInt("n_personajes"));
            resultSet2.next();
            game.setN_impostores(resultSet2.getInt("n_impostores"));
            resultSet3.next();
            game.setMapa(resultSet3.getString("mapa"));
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }


        return game;
    }
    public String getGameColor(String name_game){
        String color = null;
        List<String> games = new ArrayList<>();
        ResultSet resultSet = DatabaseConnection.getDatabaseConnection().select("SELECT nombre_partida FROM Partida;");

        try{
            ResultSet resultSet1 = DatabaseConnection.getDatabaseConnection().select("SELECT color_personaje FROM Jugada WHERE nombre_partida LIKE '" + name_game + "';");
            resultSet1.next();
            color = resultSet1.getString("color_personaje");
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return color;
    }
    public boolean findGame(String name_game){
        List<String> games_name = new ArrayList<>();
        ResultSet resultSet = DatabaseConnection.getDatabaseConnection().select("SELECT nombre_partida FROM Partida;");

        try{
            while (resultSet.next()){
                games_name.add(resultSet.getString("nombre_partida"));
            }
            for(int i = 0; i < games_name.size(); i++){
                if(Objects.equals(name_game, games_name.get(i))){
                    return true;
                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return false;
    }
    public boolean deleteGame(String name){
        List<String> games = new ArrayList<>();
        ResultSet resultSet = DatabaseConnection.getDatabaseConnection().select("SELECT nombre_partida FROM Partida;");

        try {
            while (resultSet.next()){
                games.add(resultSet.getString("nombre_partida"));
            }
            for (int i = 0; i < games.size(); i++) {
                if(Objects.equals(name, games.get(i))){
                    DatabaseConnection.getDatabaseConnection().delete("DELETE FROM Jugada WHERE nombre_partida LIKE '" + name + "'");
                    DatabaseConnection.getDatabaseConnection().delete("DELETE FROM Partida WHERE nombre_partida LIKE '" + name + "'");
                    return true;
                }
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return false;
    }
    public void saveGame(String partidaName, int n_personajes, int n_impostores, String mapa){
        String query = "UPDATE 'partida' SET 'n_personajes'='"+n_personajes+"','n_impostores'='"+n_impostores+"' WHERE 'nombre_partida'='"+partidaName+"'";
        DatabaseConnection.getDatabaseConnection().update(query);
    }
    public void existingGames(List<String> games){
        ResultSet resultSet = DatabaseConnection.getDatabaseConnection().select("SELECT nombre_partida FROM Partida;");

        try {
            while (resultSet.next()){
                games.add(resultSet.getString("nombre_partida"));
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

    }
    public String getExistingGameColor(String name_game){
        String color = null;
        ResultSet resultSet = DatabaseConnection.getDatabaseConnection().select("SELECT color_personaje FROM Jugada WHERE nombre_partida LIKE '" + name_game + "';");
        try{
            resultSet.next();
            color = resultSet.getString("color_personaje");
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        return color;
    }
    public Integer getExistingNumImp(String name_game){
        Integer n_IMP = 0;
        ResultSet resultSet = DatabaseConnection.getDatabaseConnection().select("SELECT n_impostores FROM Partida WHERE nombre_partida LIKE '" + name_game + "';");
        try{
            resultSet.next();
            n_IMP = resultSet.getInt("n_impostores");
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        return n_IMP;
    }
    public Integer getExistingNumPers(String name_game){
        Integer n_PERS = 0;
        ResultSet resultSet = DatabaseConnection.getDatabaseConnection().select("SELECT n_personajes FROM Partida WHERE nombre_partida LIKE '" + name_game + "';");
        try{
            resultSet.next();
            n_PERS = resultSet.getInt("n_personajes");
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        return n_PERS;
    }
    public String getExistingGameMap(String name_game){
        String mapa = null;
        ResultSet resultSet = DatabaseConnection.getDatabaseConnection().select("SELECT mapa FROM Partida WHERE nombre_partida LIKE '" + name_game + "';");
        try{
            resultSet.next();
            mapa = resultSet.getString("mapa");
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        return mapa;
    }
}