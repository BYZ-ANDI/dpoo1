package presentation.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import presentation.controllers.MainController;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MainModel {
    private List<Data> dataList;
    private  MainController mainController;
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
    public void setController(MainController mainController) {
        this.mainController = mainController;
    }
    public void loadDataFromJsonFile(File file) {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(file)) {
            dataList = gson.fromJson(reader, new TypeToken<List<Data>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Data> getMapa() {
        return dataList;
    }
}
