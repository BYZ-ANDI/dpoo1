import presentation.views.MainView;

public class Main {
    public static void main(String[] args) {
        DatabaseDAO databaseDAO = new DatabaseDAO();
        databaseDAO.createDatabase();
        databaseDAO.createTableJugador();
        databaseDAO.createTablePartida();
        databaseDAO.createTableJugada();

        UserDAO user = new UserDAO("jan", "jan@gmail.com", "jan123");
        user.signupUser("jan", "jan@gmail.com", "jan123");
        if (user.loginUser("jan","jan@gmail.com", "jan123")){
            System.out.println("Success");
        }
        user.deleteUser(user,"jan");
        //MainView mainView = new MainView();
        //MainController mainController = new MainController(mainView);
        //mainView.start();
    }
}
