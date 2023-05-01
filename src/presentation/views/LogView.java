package presentation.views;

import presentation.controllers.LogController;

import javax.swing.*;
import java.awt.*;

public class LogView extends JPanel {
    private JPanel jpButtons;
    private JPanel jpLog;
    private JPanel jpPanel;
    private JLabel jlName, jlEmail, jlPassword, jlTitle, jlRegister;
    private JTextField jtfName, jtfEmail, jtfPassword;
    private JButton jbSubmit, jbRegister;
    private JImagePanel jiPanel;
    public static final String REGISTER_COMMAND = "REGISTER_COMMAND";
    public static final String SUBMIT_COMMAND = "SUBMIT_COMMAND";

    public LogView(){
        setLayout(new BorderLayout());
        configWindow();
        configLayout();
    }
    private void configWindow() {
        setSize(900,650);
    }
    private void configLayout() {
        jpLog = new JPanel();
        jpPanel = new JPanel(new GridBagLayout());
        jpButtons = new JPanel(new GridLayout(0, 1, 0, 0));
        jiPanel = new JImagePanel("images/betweenUsLogin.jpg");
        jpPanel.setBackground(new Color (80, 100, 200));
        jpPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jpPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        this.add(jiPanel);

        jlRegister = new JLabel("If you don't have account yet, Sign up Here.");
        jlRegister.setHorizontalAlignment(JLabel.CENTER);
        jlTitle = new JLabel("LOG IN HERE!");
        jlTitle.setHorizontalAlignment(JLabel.CENTER);
        jlName = new JLabel("Enter Name:");
        jtfName = new JTextField(20);
        jlEmail = new JLabel("Enter Email:");
        jtfEmail = new JTextField(20);
        jlPassword = new JLabel("Enter Password:");
        jtfPassword = new JPasswordField(20);

        jbRegister = new JButton("Sign Up Here");
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
        jlRegister.setFont(text_font);

        jlTitle.setForeground(Color.WHITE);
        jlName.setForeground(Color.WHITE);
        jlEmail.setForeground(Color.WHITE);
        jlPassword.setForeground(Color.WHITE);
        jlRegister.setForeground(Color.WHITE);

        jpBoxes.add(jlTitle);
        jpBoxes.add(jlName);
        jpBoxes.add(jtfName);
        jpBoxes.add(jlEmail);
        jpBoxes.add(jtfEmail);
        jpBoxes.add(jlPassword);
        jpBoxes.add(jtfPassword);

        jpButtons.add(jbSubmit);
        jbSubmit.setAlignmentX(Component.CENTER_ALIGNMENT);
        jbSubmit.setPreferredSize(new Dimension(100, 30));
        jpButtons.add(jlRegister);
        jpButtons.setBackground(new Color (80, 100, 200));
        jpButtons.add(jbRegister);
        jbRegister.setAlignmentX(Component.CENTER_ALIGNMENT);
        jbRegister.setPreferredSize(new Dimension(100, 30));

        jpLog.setLayout(new BorderLayout(10,10));
        jpLog.setBackground(new Color (80, 100, 200));
        jpLog.add(jpBoxes, BorderLayout.CENTER);
        jpLog.add(jpButtons, BorderLayout.SOUTH);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        jpPanel.add(jpLog);

        jiPanel.setLayout(jpPanel.getLayout());
        jiPanel.add(jpPanel, gbc);

        jbRegister.setActionCommand(REGISTER_COMMAND);
        jbSubmit.setActionCommand(SUBMIT_COMMAND);
    }
    public void registController (LogController logController) {
        jbRegister.addActionListener(logController);
        jbSubmit.addActionListener(logController);
    }

    // Funcion General de todas las views.
    public void start() {
        setVisible(true);
    }
}
