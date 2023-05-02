package presentation.views;

import presentation.controllers.RegisterController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterView extends JPanel {
    private JPanel jpSubmit;
    private JPanel jpRegister;
    private JPanel jpPanel;
    private JLabel jlName, jlEmail, jlPassword, jlPassword_confirm, jlTitle;
    private JTextField jtfName, jtfEmail, jtfPassword, jtfPassword_confirm;
    private JButton jbSubmit;
    private JImagePanel jiPanel;

    public RegisterView(){
        setLayout(new BorderLayout());
        configWindow();
        configLayout();
    }
    private void configWindow() {
        setSize(900,650);
        //setTitle("Between Us");
        //setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void configLayout() {
        jpRegister = new JPanel();
        jpPanel = new JPanel(new GridBagLayout());
        jpSubmit = new JPanel(new GridLayout());
        jiPanel = new JImagePanel("images/betweenUsRegister.jpg");
        jpPanel.setBackground(new Color (80, 100, 200));
        jpPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jpPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        this.add(jiPanel);

        jlTitle = new JLabel("SIGN UP HERE!");
        jlTitle.setHorizontalAlignment(JLabel.CENTER);
        jlName = new JLabel("Enter Name:");
        jtfName = new JTextField(20);
        jlEmail = new JLabel("Enter Email:");
        jtfEmail = new JTextField(20);
        jlPassword = new JLabel("Enter Password:");
        jtfPassword = new JPasswordField(20);
        jlPassword_confirm = new JLabel("Confirm Password:");
        jtfPassword_confirm = new JPasswordField(20);

        jbSubmit = new JButton("Submit");

        JPanel jpBoxes = new JPanel(new GridLayout(0, 1, 0, 5));
        jpBoxes.setBackground(new Color (80, 100, 200));
        jpBoxes.setPreferredSize(new Dimension(400, 200));

        Font title_font = new Font("Roboto Slab", Font.BOLD + Font.ITALIC, 20);
        jlTitle.setFont(title_font);

        Font text_font = new Font("Oswald", Font.BOLD + Font.ITALIC, 12);
        jlName.setFont(text_font);
        jlEmail.setFont(text_font);
        jlPassword.setFont(text_font);
        jlPassword_confirm.setFont(text_font);

        jlTitle.setForeground(Color.WHITE);
        jlName.setForeground(Color.WHITE);
        jlEmail.setForeground(Color.WHITE);
        jlPassword.setForeground(Color.WHITE);
        jlPassword_confirm.setForeground(Color.WHITE);

        jpBoxes.add(jlTitle);
        jpBoxes.add(jlName);
        jpBoxes.add(jtfName);
        jpBoxes.add(jlEmail);
        jpBoxes.add(jtfEmail);
        jpBoxes.add(jlPassword);
        jpBoxes.add(jtfPassword);
        jpBoxes.add(jlPassword_confirm);
        jpBoxes.add(jtfPassword_confirm);

        jpSubmit.add(jbSubmit);
        jbSubmit.setAlignmentX(Component.CENTER_ALIGNMENT);
        jbSubmit.setPreferredSize(new Dimension(100, 30));

        jpRegister.setLayout(new BorderLayout(10,10));
        jpRegister.setBackground(new Color (80, 100, 200));
        jpRegister.add(jpBoxes, BorderLayout.CENTER);
        jpRegister.add(jpSubmit, BorderLayout.SOUTH);


        jpPanel.add(jpRegister);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        jiPanel.setLayout(jpPanel.getLayout());
        jiPanel.add(jpPanel, gbc);
    }
    public String getName() {
        return jtfName.getText();
    }
    public String getEmail() {
        return jtfEmail.getText();
    }
    public String getPassword() {
        return jtfPassword.getText();
    }
    public String getConfirmPassword() {
        return jtfPassword_confirm.getText();
    }
    public void registController (RegisterController registerController) {
        jbSubmit.addActionListener(registerController);
    }
    // Funcion General de todas las views.
    public void start() {
        setVisible(true);
    }
    public void emailErrorMessage() {
        JOptionPane.showMessageDialog(null, "Email no vàlid!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void passwordErrorMessage() {
        JOptionPane.showMessageDialog(null, "Password no vàlida!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void confirmPasswordErrorMessage() {
        JOptionPane.showMessageDialog(null, "La password no concorda!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void registerCorrect() {
        JOptionPane.showMessageDialog(null, "Has sigut registrat correctament!", "Correcte", JOptionPane.INFORMATION_MESSAGE);
    }
}
