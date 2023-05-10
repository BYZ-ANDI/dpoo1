package presentation.views;

import presentation.controllers.MainMenuController;

import javax.swing.*;
import java.awt.*;

public class MainMenuView extends JPanel {
    private JPanel jpMenu, jpPanel;
    private JLabel jlCreateNewGame, jlGame, jlSameGame, jlTitle;
    private JTextField jtfSameGame;
    private JButton jbCreateNewGame, jbCreateGame, jbGame;
    private JImagePanel jiPanel;

    public static final String NEWGAME_COMMAND = "NEWGAME_COMMAND";
    public static final String GAME_COMMAND = "GAME_COMMAND";
    public static final String SAMEGAME_COMMAND = "SAME_COMMAND";

    public MainMenuView(){
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
        jpMenu = new JPanel();
        jpPanel = new JPanel(new GridBagLayout());
        jiPanel = new JImagePanel("images/betweenUsRegister.jpg");
        jpPanel.setBackground(new Color (80, 100, 200));
        jpPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jpPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        this.add(jiPanel);

        jlTitle = new JLabel("GAME MENU!");
        jlTitle.setHorizontalAlignment(JLabel.CENTER);
        jlCreateNewGame = new JLabel("Create a new Game: ");
        jbCreateNewGame = new JButton("Create new Game");
        jlGame = new JLabel("Continue a Game: ");
        jbGame = new JButton("Continue a Game");
        jlSameGame = new JLabel("Create a new Game manteining settings: ");
        jtfSameGame = new JTextField("Enter Name of Game in progress...", 20);
        jbCreateGame = new JButton("Create a Game");

        JPanel jpBoxes = new JPanel(new GridLayout(0, 1, 0, 5));
        jpBoxes.setBackground(new Color (80, 100, 200));
        jpBoxes.setPreferredSize(new Dimension(400, 250));

        Font title_font = new Font("Roboto Slab", Font.BOLD + Font.ITALIC, 20);
        jlTitle.setFont(title_font);

        Font text_font = new Font("Oswald", Font.BOLD + Font.ITALIC, 12);
        jlCreateNewGame.setFont(text_font);
        jlGame.setFont(text_font);
        jlSameGame.setFont(text_font);

        jtfSameGame.setFont(new Font("Oswald", Font.BOLD + Font.ITALIC, 10));

        jlTitle.setForeground(Color.WHITE);
        jlCreateNewGame.setForeground(Color.WHITE);
        jlGame.setForeground(Color.WHITE);
        jlSameGame.setForeground(Color.WHITE);

        jpBoxes.add(jlTitle);
        jpBoxes.add(jlCreateNewGame);
        jpBoxes.add(jbCreateNewGame);
        jbCreateNewGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        jpBoxes.add(jlGame);
        jpBoxes.add(jbGame);
        jbGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        jpBoxes.add(jlSameGame);
        jpBoxes.add(jtfSameGame);
        jpBoxes.add(jbCreateGame);
        jbCreateGame.setAlignmentX(Component.CENTER_ALIGNMENT);

        jpMenu.setLayout(new BorderLayout(10,10));
        jpMenu.setBackground(new Color (80, 100, 200));
        jpMenu.add(jpBoxes, BorderLayout.CENTER);

        jpPanel.add(jpMenu);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        jiPanel.setLayout(jpPanel.getLayout());
        jiPanel.add(jpPanel, gbc);

        jbCreateNewGame.setActionCommand(NEWGAME_COMMAND);
        jbGame.setActionCommand(GAME_COMMAND);
        jbCreateGame.setActionCommand(SAMEGAME_COMMAND);
    }
    public void registController (MainMenuController mainMenuController) {
        jbCreateNewGame.addActionListener(mainMenuController);
        jbGame.addActionListener(mainMenuController);
        jbCreateGame.addActionListener(mainMenuController);
        jtfSameGame.addFocusListener(mainMenuController);
    }
    public void start() {
        setVisible(true);
    }
}
