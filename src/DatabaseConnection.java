import java.sql.*;

public class DatabaseConnection {

    private String nameUser;
    private String password;
    private int port;
    private String url;

    private Connection connection;
    private DatabaseConnection databaseConnection = null;
    private String server;

    private DatabaseConnection(String nameUser, String password, String ip, int port, String databaseName) {
        this.nameUser = nameUser;
        this.password = password;
        this.url = "jdbc:mysql://"+ip+":"+port+"/"+databaseName;
    }
    private void inicialitzeJSON(Configuration configuration){
        nameUser = configuration.getUser();
        password = configuration.getPassword();
        port = configuration.getPort();
        server = configuration.getServer();
    }
    private void connection(){
        try {
            connection = DriverManager.getConnection(url,nameUser,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private DatabaseConnection getDatabaseConnection (){
        if(databaseConnection == null){
            databaseConnection = new DatabaseConnection(nameUser,password,server,port,"BetweenUs");
            databaseConnection.connection();
        }
        return databaseConnection;
    }

    private void insert(String sqlQuery){
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private ResultSet select(String sqlSelect){
        ResultSet resultSet=null;
        try{
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlSelect);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
    private void connect(String sqlConnect){
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlConnect);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void update(String sqlUpdate){
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlUpdate);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void delete(String sqlUpdate){
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlUpdate);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
