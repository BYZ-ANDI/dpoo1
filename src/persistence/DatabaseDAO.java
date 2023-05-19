package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDAO {
    private String url;
    private String userName;
    private String password;
    private Connection connection = null;
    private Statement statement = null;
    private Configuration configuration;
    private ReadConfigJSON readConfigJSON = new ReadConfigJSON();

    public void createDatabase(){
        configuration = readConfigJSON.readJSON();
        url = "jdbc:mysql://"+configuration.getServer()+":"+configuration.getPort();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Making connection");
            userName = configuration.getUser();
            password = configuration.getPassword();
            connection = DriverManager.getConnection(url,userName,password);
            statement = connection.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS Between_Us";
            statement.executeUpdate(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (statement!=null){
                    statement.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                if(connection!=null){
                    connection.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void createTableJugador(){
        configuration = readConfigJSON.readJSON();
        url = "jdbc:mysql://"+configuration.getServer()+":"+configuration.getPort()+"/Between_Us";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            userName = configuration.getUser();
            password = configuration.getPassword();
            connection = DriverManager.getConnection(url,userName,password);
            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Jugador" +
                    "(nombre_jugador VARCHAR(25) NOT NULL," +
                    "correo VARCHAR(25) NOT NULL," +
                    "contraseña VARCHAR(25) NOT NULL," +
                    "n_partidas_ganadas INTEGER(255) NOT NULL," +
                    "PRIMARY KEY (nombre_jugador))";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (statement!=null){
                    statement.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                if(connection!=null){
                    connection.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void createTablePartida(){
        configuration = readConfigJSON.readJSON();
        url = "jdbc:mysql://"+configuration.getServer()+":"+configuration.getPort()+"/Between_Us";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            userName = configuration.getUser();
            password = configuration.getPassword();
            connection = DriverManager.getConnection(url,userName,password);
            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Partida" +
                    "(nombre_partida VARCHAR(25) NOT NULL," +
                    "n_personajes INTEGER(255) NOT NULL," +
                    "n_impostores INTEGER(255) NOT NULL," +
                    "mapa VARCHAR(25) NOT NULL," +
                    "PRIMARY KEY (nombre_partida))";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (statement!=null){
                    statement.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                if(connection!=null){
                    connection.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void createTableJugada(){
        configuration = readConfigJSON.readJSON();
        url = "jdbc:mysql://"+configuration.getServer()+":"+configuration.getPort()+"/Between_Us";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            userName = configuration.getUser();
            password = configuration.getPassword();
            connection = DriverManager.getConnection(url,userName,password);
            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Jugada" +
                    "(nombre_jugador VARCHAR(25) NOT NULL," +
                    "nombre_partida VARCHAR(25) NOT NULL," +
                    "color_personaje VARCHAR(25) NOT NULL," +
                    "FOREIGN KEY (nombre_jugador) REFERENCES Jugador (nombre_jugador)," +
                    "FOREIGN KEY (nombre_partida) REFERENCES Partida (nombre_partida))";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (statement!=null){
                    statement.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                if(connection!=null){
                    connection.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
