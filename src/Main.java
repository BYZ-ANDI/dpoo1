import Business.GameManager;
import Business.UserManager;
import Business.entities.User;
import persistence.DatabaseDAO;
import persistence.GameDAO;
import persistence.UserDAO;
import presentation.controllers.*;
import presentation.model.MainModel;
import presentation.views.*;

public class Main {
    public static void main(String[] args) {
        DatabaseDAO databaseDAO = new DatabaseDAO();
        databaseDAO.createDatabase();
        databaseDAO.createTableJugador();
        databaseDAO.createTablePartida();
        databaseDAO.createTableJugada();
        UserDAO userDAO = new UserDAO();
        GameDAO gameDAO = new GameDAO();
        User user = new User(null, null, null);

        LogView logView = new LogView();
        LogoutView logoutView = new LogoutView();
        RegisterView registerView = new RegisterView();
        MainMenuView mainMenuView = new MainMenuView();
        CreationGameView creationGameView = new CreationGameView();
        MainModel mainModel = new MainModel();
        MainView mainView = new MainView(mainModel, logView, logoutView, registerView, mainMenuView, creationGameView);

        UserManager userManager = new UserManager(user, userDAO);
        //GameManager gameManager = new GameManager();

        LogController logController = new LogController(logView, mainModel, userManager);
        logView.registController(logController);
        LogoutController logoutController = new LogoutController(logoutView, mainModel);
        logoutView.registController(logoutController);
        RegisterController registerController = new RegisterController(registerView, mainModel, userManager);
        registerView.registController(registerController);
        MainMenuController mainMenuController = new MainMenuController(mainMenuView, mainModel);
        mainMenuView.registController(mainMenuController);
        CreationGameController creationGameController = new CreationGameController(creationGameView, mainModel);
        creationGameView.registController(creationGameController);

        //User user = new User("jan", "jan@gmail.com", "jan123");

        //userD.signupUser(user);
        //if (userD.loginUser("jan","jan@gmail.com", "jan123")){
        //    System.out.println("Success");
        //}
        //userD.deleteUser(user,"jan");

        MainController mainController = new MainController(mainView, mainModel);
        mainView.start();
    }
}
