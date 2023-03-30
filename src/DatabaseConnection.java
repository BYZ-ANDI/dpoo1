import java.sql.Connection;

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
}
