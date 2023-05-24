import Business.GameManager;
import Business.UserManager;
import Business.entities.Game;
import Business.entities.Map;
import Business.entities.Room;
import Business.entities.User;
import persistence.DatabaseDAO;
import persistence.GameDAO;
import persistence.MapsDAO;
import persistence.UserDAO;
import presentation.controllers.*;
import presentation.model.MainModel;
import presentation.views.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseDAO databaseDAO = new DatabaseDAO();
        databaseDAO.createDatabase();
        databaseDAO.createTableJugador();
        databaseDAO.createTablePartida();
        databaseDAO.createTableJugada();
        UserDAO userDAO = new UserDAO();
        GameDAO gameDAO = new GameDAO();
        MapsDAO mapDAO = new MapsDAO();
        User user = new User(null, null, null);
        Game game = new Game(null, 0, 0, null);
        Map mapa = new Map();

        LogView logView = new LogView();
        LogoutView logoutView = new LogoutView();
        RegisterView registerView = new RegisterView();
        MainMenuView mainMenuView = new MainMenuView();
        List<Room> rooms = new ArrayList<>();
        MainModel mainModel = new MainModel(rooms, mapDAO);
        MapGUI mapGUI = new MapGUI(mainModel);
        GameManager gameManager = new GameManager(game,gameDAO,user);
        GameController gameController = new GameController(gameManager,mapGUI);
        mapGUI.MapGUIController(gameController);
        CreationGameView creationGameView = new CreationGameView();
        MainView mainView = new MainView(mainModel, logView, logoutView, registerView, mainMenuView, creationGameView,mapGUI);

        UserManager userManager = new UserManager(user, userDAO);

        LogController logController = new LogController(logView, mainModel, userManager);
        logView.registController(logController);
        LogoutController logoutController = new LogoutController(logoutView, mainModel,userManager,user );
        logoutView.registController(logoutController);
        RegisterController registerController = new RegisterController(registerView, mainModel, userManager);
        registerView.registController(registerController);
        MainMenuController mainMenuController = new MainMenuController(mainMenuView, mainModel, gameManager);
        mainMenuView.registController(mainMenuController);
        CreationGameController creationGameController = new CreationGameController(creationGameView, mainModel, gameManager, null, mapGUI);
        creationGameView.registController(creationGameController);

        MainController mainController = new MainController(mainView, mainModel);
        mainView.start();
    }
}
