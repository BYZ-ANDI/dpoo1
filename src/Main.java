public class Main {
    public static void main(String[] args) {
        DatabaseDAO databaseDAO = new DatabaseDAO();
        databaseDAO.createDatabase();
        databaseDAO.createTableJugador();
        databaseDAO.createTablePartida();
        databaseDAO.createTableJugada();


    }
}
