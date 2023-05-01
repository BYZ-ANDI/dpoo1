package presentation.controllers;

import Business.UserManager;
import presentation.views.LogView;
import presentation.views.RegisterView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController implements ActionListener {
    private RegisterView registerView;
    public RegisterController(RegisterView registerView) {
        this.registerView = registerView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        UserManager userManager = new UserManager(registerView.getEmail(), registerView.getPassword(), registerView.getConfirmPassword());

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

        // Guardar la informacion del user en la database

        registerView.registerCorrect();

        // Pasar a la Partida Principal
    }
}
