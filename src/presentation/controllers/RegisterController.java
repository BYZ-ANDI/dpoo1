package presentation.controllers;

import Business.entities.User;
import Business.UserManager;
import presentation.model.MainModel;
import presentation.views.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController implements ActionListener {
    private RegisterView registerView;
    private MainModel mainModel;
    private UserManager userManager;
    public RegisterController(RegisterView registerView, MainModel mainModel, UserManager userManager) {
        this.registerView = registerView;
        this.mainModel = mainModel;
        this.userManager = userManager;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Guardar la informacion del user en la database i en RAM
        userManager.createUser(registerView.getName(), registerView.getEmail(), registerView.getPassword());
        if (!userManager.correctEmail()) {
            registerView.emailErrorMessage();
            return;
        }
        if (!userManager.correctPassword()) {
            registerView.passwordErrorMessage();
            return;
        }
        userManager.setConfirm_password(registerView.getConfirmPassword());
        if (!userManager.confirmPassword()) {
            registerView.confirmPasswordErrorMessage();
            return;
        }

        registerView.registerCorrect();

        // Pasar a la Partida Principal || de momento esta a LogView.
        mainModel.goToLogView();
    }
}
