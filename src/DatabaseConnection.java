import java.sql.*;

public class DatabaseConnection {

    private static String nameUser;
    private static String password;
    private static int port;
    private String url;

    private Connection connection;
    private static DatabaseConnection databaseConnection = null;
    private static String server;

    private DatabaseConnection(String nameUser, String password, String ip, int port, String databaseName) {
        this.nameUser = nameUser;
        this.password = password;
        this.url = "jdbc:mysql://"+ip+":"+port+"/"+databaseName;
    }
    public void inicialitzeJSON(Configuration configuration){
        nameUser = configuration.getUser();
        password = configuration.getPassword();
        port = configuration.getPort();
        server = configuration.getServer();
    }
    public void connection(){
        try {
            connection = DriverManager.getConnection(url,nameUser,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static DatabaseConnection getDatabaseConnection (){
        if(databaseConnection == null){
            databaseConnection = new DatabaseConnection(nameUser,password,server,port,"BetweenUs");
            databaseConnection.connection();
        }
        return databaseConnection;
    }

    public void insert(String sqlQuery){
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet select(String sqlSelect){
        ResultSet resultSet=null;
        try{
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlSelect);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
    public void connect(String sqlConnect){
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlConnect);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update(String sqlUpdate){
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlUpdate);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(String sqlDelete){
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlDelete);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
