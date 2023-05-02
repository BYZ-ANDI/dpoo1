import Business.Entities.User;
import presentation.controllers.MainController;
import presentation.model.MainModel;
import presentation.views.MainView;

public class Main {
    public static void main(String[] args) {
        DatabaseDAO databaseDAO = new DatabaseDAO();
        databaseDAO.createDatabase();
        databaseDAO.createTableJugador();
        databaseDAO.createTablePartida();
        databaseDAO.createTableJugada();
        UserDAO userD = new UserDAO();

        User user = new User("jan", "jan@gmail.com", "jan123");

        userD.signupUser(user);
        if (userD.loginUser("jan","jan@gmail.com", "jan123")){
            System.out.println("Success");
        }
        userD.deleteUser(user,"jan");

        MainModel mainModel = new MainModel();
        MainView mainView = new MainView(mainModel);
        MainController mainController = new MainController(mainView, mainModel);
        mainView.start();
    }
}
