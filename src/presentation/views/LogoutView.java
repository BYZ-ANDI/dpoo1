package presentation.views;

import presentation.controllers.LogController;
import presentation.controllers.LogoutController;

import javax.swing.*;
import java.awt.*;

public class LogoutView extends JPanel {
    private JPanel jpPanel, jpLogout;
    private JLabel jlLogout, jlTitle, jlDelete;
    private JButton jbLogout, jbDelete;
    private JImagePanel jiPanel;
    public static final String LOGOUT_COMMAND = "LOGOUT_COMMAND";
    public static final String DELETE_COMMAND = "DELETE_COMMAND";
    public LogoutView(){
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
        jpLogout = new JPanel();
        jpPanel = new JPanel(new GridBagLayout());
        jiPanel = new JImagePanel("images/betweenUsLogout.jpg");
        jpPanel.setBackground(new Color (80, 100, 200));
        jpPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jpPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        this.add(jiPanel);

        jlTitle = new JLabel("LOGOUT HERE!");
        jlTitle.setHorizontalAlignment(JLabel.CENTER);
        jlLogout = new JLabel("Enter Name:");
        jlDelete = new JLabel("Enter Email:");

        jbLogout = new JButton("Logout your account");
        jbDelete = new JButton("Delete your account");

        JPanel jpBoxes = new JPanel(new GridLayout(0, 1, 0, 0));
        jpBoxes.setBackground(new Color (80, 100, 200));
        jpBoxes.setPreferredSize(new Dimension(350, 150));

        Font title_font = new Font("Roboto Slab", Font.BOLD + Font.ITALIC, 20);
        jlTitle.setFont(title_font);

        Font text_font = new Font("Oswald", Font.BOLD + Font.ITALIC, 12);
        jlLogout.setFont(text_font);
        jlDelete.setFont(text_font);

        jlTitle.setForeground(Color.WHITE);
        jlLogout.setForeground(Color.WHITE);
        jlDelete.setForeground(Color.WHITE);

        jpBoxes.add(jlTitle);
        jpBoxes.add(jlLogout);
        jpBoxes.add(jbLogout);
        jpBoxes.add(jlDelete);
        jpBoxes.add(jbDelete);

        jbLogout.setAlignmentX(Component.CENTER_ALIGNMENT);
        jbLogout.setPreferredSize(new Dimension(100, 30));
        jbDelete.setAlignmentX(Component.CENTER_ALIGNMENT);
        jbDelete.setPreferredSize(new Dimension(100, 30));

        jpLogout.setLayout(new BorderLayout(10,10));
        jpLogout.setBackground(new Color (80, 100, 200));
        jpLogout.add(jpBoxes, BorderLayout.CENTER);

        jpPanel.add(jpLogout);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        jiPanel.setLayout(jpPanel.getLayout());
        jiPanel.add(jpPanel, gbc);

        jbLogout.setActionCommand(LOGOUT_COMMAND);
        jbDelete.setActionCommand(DELETE_COMMAND);
    }
    public void registController (LogoutController logoutController) {
        jbLogout.addActionListener(logoutController);
        jbDelete.addActionListener(logoutController);
    }
    // Funcion General de todas las views.
    public void start() {
        setVisible(true);
    }
}
