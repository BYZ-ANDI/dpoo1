package presentation.views;

import presentation.controllers.MainMenuController;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainMenuView extends JPanel {
    private JPanel jpMenu, jpPanel, jpLogout;
    private JLabel jlCreateNewGame, jlGame, jlSameGameTitle, jlSameGame, jlTitle;
    private JTextField jtfSameGame, jtfGame;
    private JButton jbCreateNewGame, jbCreateGame, jbGame, jbLogout, jbDelete, jbExistingGames, jbStats;
    private JImagePanel jiPanel;

    public static final String NEWGAME_COMMAND = "NEWGAME_COMMAND";
    public static final String GAME_COMMAND = "GAME_COMMAND";
    public static final String SAMEGAME_COMMAND = "SAME_COMMAND";
    public static final String LOGOUT_COMMAND = "LOGOUT_COMMAND";
    public static final String DELETE_COMMAND = "DELETE_COMMAND";
    public static final String EXISTING_COMMAND = "EXISTING_COMMAND";
    public static final String STATS_COMMAND = "STATS_COMMAND";

    public MainMenuView(){
        setLayout(new BorderLayout());
        configWindow();
        configLayout();
    }
    private void configWindow() {
        setSize(900,650);
    }
    private void configLayout() {
        jpMenu = new JPanel();
        jpLogout = new JPanel(new BorderLayout());
        jpPanel = new JPanel(new GridBagLayout());
        jiPanel = new JImagePanel("images/betweenUsRegister.jpg");
        jpPanel.setBackground(new Color (80, 100, 200));
        jpPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jpPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
                BorderFactory.createEmptyBorder(20, 80, 20, 10)
        ));

        this.add(jiPanel);

        jlTitle = new JLabel("GAME MENU!");
        jlTitle.setHorizontalAlignment(JLabel.CENTER);
        jlCreateNewGame = new JLabel("Create a new Game: ");
        jbCreateNewGame = new JButton("Create new Game");
        jlGame = new JLabel("Continue a Game: ");
        jtfGame = new JTextField();
        jbGame = new JButton("Continue a Game");
        jlSameGame = new JLabel("Create a new Game manteining settings or delete it");
        jbExistingGames = new JButton("Existing Games");
        jlSameGameTitle = new JLabel("Name of the Game to copy settings or to delete it:");
        jtfSameGame = new JTextField();
        jbCreateGame = new JButton("Create Game");
        jbLogout = new JButton("Logout");
        jbDelete = new JButton("Delete Game");
        jbStats = new JButton("Show player stats");

        JPanel jpBoxes = new JPanel(new GridLayout(0, 1, 0, 5));
        jpBoxes.setBackground(new Color (80, 100, 200));
        jpBoxes.setPreferredSize(new Dimension(400, 350));

        Font title_font = new Font("Roboto Slab", Font.BOLD + Font.ITALIC, 20);
        jlTitle.setFont(title_font);

        Font text_font = new Font("Oswald", Font.BOLD + Font.ITALIC, 12);
        jlCreateNewGame.setFont(text_font);
        jlGame.setFont(text_font);

        jlSameGame.setFont(text_font);

        jlTitle.setForeground(Color.WHITE);
        jlCreateNewGame.setForeground(Color.WHITE);
        jlGame.setForeground(Color.WHITE);
        jlSameGame.setForeground(Color.WHITE);
        jlSameGameTitle.setForeground(Color.WHITE);

        jpBoxes.add(jlTitle);
        jpBoxes.add(jlCreateNewGame);
        jpBoxes.add(jbCreateNewGame);
        jbCreateNewGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        jpBoxes.add(jlGame);
        jpBoxes.add(jtfGame);
        jpBoxes.add(jbGame);
        jbGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        jpBoxes.add(jlSameGame);
        jpBoxes.add(jbExistingGames);
        jbExistingGames.setAlignmentX(Component.CENTER_ALIGNMENT);
        jpBoxes.add(jlSameGameTitle);
        jpBoxes.add(jtfSameGame);
        jpBoxes.add(jbCreateGame);
        jbCreateGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        jpBoxes.add(jbDelete);
        jbDelete.setAlignmentX(Component.CENTER_ALIGNMENT);
        jpBoxes.add(jbStats);
        jbStats.setAlignmentX(Component.CENTER_ALIGNMENT);

        jpLogout.add(jbLogout, BorderLayout.EAST);

        jpMenu.setLayout(new BorderLayout(10,10));
        jpMenu.setBackground(new Color (80, 100, 200));
        jpMenu.add(jpBoxes, BorderLayout.CENTER);
        jpMenu.add(jpLogout, BorderLayout.NORTH);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        gbc2.weightx = 0;
        gbc2.weighty = 1;
        gbc2.anchor = GridBagConstraints.NORTHEAST;

        jpPanel.add(jpMenu, gbc);
        jpPanel.add(jpLogout, gbc2);

        jiPanel.setLayout(jpPanel.getLayout());
        jiPanel.add(jpPanel);

        jbCreateNewGame.setActionCommand(NEWGAME_COMMAND);
        jbGame.setActionCommand(GAME_COMMAND);
        jbCreateGame.setActionCommand(SAMEGAME_COMMAND);
        jbLogout.setActionCommand(LOGOUT_COMMAND);
        jbDelete.setActionCommand(DELETE_COMMAND);
        jbExistingGames.setActionCommand(EXISTING_COMMAND);
        jbStats.setActionCommand(STATS_COMMAND);
    }
    public void registController (MainMenuController mainMenuController) {
        jbCreateNewGame.addActionListener(mainMenuController);
        jbGame.addActionListener(mainMenuController);
        jbCreateGame.addActionListener(mainMenuController);
        jbLogout.addActionListener(mainMenuController);
        jbDelete.addActionListener(mainMenuController);
        jbExistingGames.addActionListener(mainMenuController);
        jbStats.addActionListener(mainMenuController);
    }

    public String getJtfSameGame() {
        return jtfSameGame.getText();
    }

    public void start() {
        setVisible(true);
    }
    public void GameDeletionErrorMessage() {
        JOptionPane.showMessageDialog(null, "El nom d'aquesta partida no existeix!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void GameDeletionSuccessMessage() {
        JOptionPane.showMessageDialog(null, "S'ha borrat la partida correctament!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    public void GameLoadErrorMessage() {
        JOptionPane.showMessageDialog(null, "El nom d'aquesta partida ja creada no existeix!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void GameLoadSuccessMessage() {
        JOptionPane.showMessageDialog(null, "S'ha creat la partida correctament!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    public void emptyNameSettingsGame() {
        JOptionPane.showMessageDialog(null, "No has introduït res al nom del joc ja creat!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void emptyNameDeleteGame() {
        JOptionPane.showMessageDialog(null, "No has introduït res al nom del joc per eliminar!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void existingGames(List<String> games) {
        JOptionPane.showMessageDialog(null, games.toString(), "Games", JOptionPane.INFORMATION_MESSAGE);
    }

}
