package presentation.model;

import Business.entities.Logs;
import Business.entities.Player;
import Business.entities.Room;
import persistence.MapsDAO;
import presentation.controllers.MainController;

import java.util.ArrayList;
import java.util.List;

public class MainModel {
    private MapsDAO mapsDAO;
    private List<Room> rooms;
    private List<Player> personajes;
    private List<Logs> logs;
    private  MainController mainController;
    public MainModel(List<Room> rooms, MapsDAO mapsDAO) {
        this.rooms = rooms;
        this.mapsDAO = mapsDAO;
    }
    public void goToLogView() {
        mainController.changeToLogView();
    }
    public void goToLogoutView() {
        mainController.changeToLogoutView();
    }
    public void goToRegisterView() {
        mainController.changeToRegisterView();
    }
    public void goToMainMenuView() {
        mainController.changeToMainMenuView();
    }
    public void goToCreationGameView() {
        mainController.changeToCreationGameView();
    }
    public void goToMapView(){
        mainController.changeToMapView();
    }
    public void goToGameTrackingView() {mainController.changeToGameTrackingView();}
    public void goToLogsView(){
        mainController.changeToLogsView();
    }
    public void setController(MainController mainController) {
        this.mainController = mainController;
    }
    public void loadDataFromJsonFile(String file) {
        rooms = mapsDAO.loadRooms("src/persistence/" + file);
    }
    public List<Room> getRooms(){
        return rooms;
    }
    public List<Player> getPers() {
        personajes = new ArrayList<>();
        personajes.add(new Player("RED", true, "Spawn", "Unknown"));
        personajes.add(new Player("BLUE", true, "Spawn", "Unknown"));
        personajes.add(new Player("ORANGE", true, "Spawn", "Unknown"));
        personajes.add(new Player("GREEN", true, "Spawn", "Unknown"));

        return personajes;
    }
    public List<Logs> getLogs() {
        logs = new ArrayList<>();

        return logs;
    }
}
