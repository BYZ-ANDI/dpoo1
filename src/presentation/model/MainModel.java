package presentation.model;

import Business.entities.Room;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import persistence.MapsDAO;
import presentation.controllers.MainController;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MainModel {
    private MapsDAO mapsDAO;
    private List<Room> rooms;
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
    public void goToMapView(){mainController.changeToMapView();}
    public void setController(MainController mainController) {
        this.mainController = mainController;
    }
    public void loadDataFromJsonFile(String file) {
        rooms = mapsDAO.loadRooms("/src/persistence/" + file);
    }
}
