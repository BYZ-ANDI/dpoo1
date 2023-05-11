package presentation.controllers;

import Business.Entities.User;
import Business.UserManager;
import presentation.model.MainModel;
import presentation.views.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController implements ActionListener {
    private RegisterView registerView;
    private MainModel mainModel;
    public RegisterController(RegisterView registerView, MainModel mainModel) {
        this.registerView = registerView;
        this.mainModel = mainModel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        UserManager userManager = new UserManager(registerView.getName(), registerView.getEmail() ,registerView.getPassword(), registerView.getConfirmPassword());

        if (!userManager.correctEmail()) {
            registerView.emailErrorMessage();
            return;
        }
        if (!userManager.correctPassword()) {
            registerView.passwordErrorMessage();
            return;
        }
        if (!userManager.confirmPassword()) {
            registerView.confirmPasswordErrorMessage();
            return;
        }

        // Guardar la informacion del user en la database i en RAM
        userManager.createUser(registerView.getName(), registerView.getEmail(), registerView.getPassword());

        registerView.registerCorrect();

        // Pasar a la Partida Principal || de momento esta a LogView.
        mainModel.goToLogView();
    }
}
