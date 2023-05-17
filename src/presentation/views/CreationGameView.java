package presentation.views;

import presentation.controllers.CreationGameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreationGameView extends JPanel {
    private JPanel jpButtons, jpPanel, jpGame, jpLogout;
    private JLabel jlGameName, jlNumPers, jlTitle, jlNumImpos, jlColor;
    private JTextField jtfGameName;
    private JButton jbSubmit, jbMap, jbLogout;
    private JComboBox<String> jcbNumPers, jcbNumImpos, jcbColor;
    private JImagePanel jiPanel;
    public static final String NUMPERS_COMMAND = "NUMPERS_COMMAND";
    public static final String NUMIMP_COMMAND = "NUMIMP_COMMAND";
    public static final String COLORS_COMMAND = "COLORS_COMMAND";
    public static final String MAP_COMMAND = "MAP_COMMAND";
    public static final String SUBMIT_COMMAND = "SUBMIT_COMMAND";
    public static final String LOGOUT_COMMAND = "LOGOUT_COMMAND";
    public static final String[] num_players = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    public static final String[] num_impostor = {"1", "2", "3"};
    public static final String[] colors = {"vermell", "blau", "verd", "rosa", "taronja", "groc", "negre", "blanc", "lila", "marró", "cian", "llima"};

    public CreationGameView(){
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
        jpGame = new JPanel();
        jpLogout = new JPanel(new BorderLayout());
        jpPanel = new JPanel(new GridBagLayout());
        jpButtons = new JPanel(new GridLayout(0, 1, 0, 5));
        jiPanel = new JImagePanel("images/betweenUsRegister.jpg");
        jpPanel.setBackground(new Color (80, 100, 200));
        jpPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jpPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
                BorderFactory.createEmptyBorder(20, 80, 20, 10)
        ));

        this.add(jiPanel);

        jlTitle = new JLabel("GAME CREATION!");
        jlTitle.setHorizontalAlignment(JLabel.CENTER);
        jlGameName = new JLabel("Enter Game Name:");
        jtfGameName = new JTextField(20);
        jlNumPers = new JLabel("Select Number of players:");
        jcbNumPers = new JComboBox<>(num_players);
        jcbNumPers.setSelectedIndex(0);
        jlNumImpos = new JLabel("Select Number of impostors:");
        jcbNumImpos = new JComboBox<>(num_impostor);
        jcbNumImpos.setSelectedIndex(0);
        jlColor = new JLabel("Select your colour:");
        jcbColor = new JComboBox<>(colors);
        jcbColor.setSelectedIndex(0);
        jbMap = new JButton("Choose Map");
        jbSubmit = new JButton("Submit");
        jbLogout = new JButton("Logout");

        JPanel jpBoxes = new JPanel(new GridLayout(0, 1, 0, 5));
        jpBoxes.setBackground(new Color (80, 100, 200));
        jpBoxes.setPreferredSize(new Dimension(400, 250));

        Font title_font = new Font("Roboto Slab", Font.BOLD + Font.ITALIC, 20);
        jlTitle.setFont(title_font);

        Font text_font = new Font("Oswald", Font.BOLD + Font.ITALIC, 12);
        jlGameName.setFont(text_font);
        jlNumPers.setFont(text_font);
        jlNumImpos.setFont(text_font);

        jlTitle.setForeground(Color.WHITE);
        jlGameName.setForeground(Color.WHITE);
        jlNumPers.setForeground(Color.WHITE);
        jlNumImpos.setForeground(Color.WHITE);
        jlColor.setForeground(Color.WHITE);

        jpBoxes.add(jlTitle);
        jpBoxes.add(jlGameName);
        jpBoxes.add(jtfGameName);
        jpBoxes.add(jlNumPers);
        jpBoxes.add(jcbNumPers);
        jpBoxes.add(jlNumImpos);
        jpBoxes.add(jcbNumPers);
        jpBoxes.add(jlNumImpos);
        jpBoxes.add(jcbNumImpos);
        jpBoxes.add(jlColor);
        jpBoxes.add(jcbColor);

        jpButtons.setBackground(new Color (80, 100, 200));
        jpButtons.add(jbMap);
        jbMap.setAlignmentX(Component.CENTER_ALIGNMENT);
        jbMap.setPreferredSize(new Dimension(100, 25));
        jpButtons.add(jbSubmit);
        jbSubmit.setAlignmentX(Component.CENTER_ALIGNMENT);
        jbSubmit.setPreferredSize(new Dimension(100, 25));
        jpLogout.add(jbLogout, BorderLayout.EAST);

        jpGame.setLayout(new BorderLayout(10,10));
        jpGame.setBackground(new Color (80, 100, 200));
        jpGame.add(jpBoxes, BorderLayout.CENTER);
        jpGame.add(jpButtons, BorderLayout.SOUTH);
        jpGame.add(jpLogout, BorderLayout.NORTH);

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

        jpPanel.add(jpGame, gbc);
        jpPanel.add(jpLogout, gbc2);

        jiPanel.setLayout(jpPanel.getLayout());
        jiPanel.add(jpPanel);

        jbMap.setActionCommand(MAP_COMMAND);
        jbSubmit.setActionCommand(SUBMIT_COMMAND);
        jcbNumPers.setName(NUMPERS_COMMAND);
        jcbNumImpos.setName(NUMIMP_COMMAND);
        jcbColor.setName(COLORS_COMMAND);
        jbLogout.setActionCommand(LOGOUT_COMMAND);
    }
    public void start() {
        setVisible(true);
    }
    public void registController(CreationGameController creationGameController) {
        jbMap.addActionListener(creationGameController);
        jbSubmit.addActionListener(creationGameController);
        jbLogout.addActionListener(creationGameController);
        jcbNumPers.addMouseWheelListener(creationGameController);
        jcbNumImpos.addMouseWheelListener(creationGameController);
        jcbColor.addMouseWheelListener(creationGameController);
    }
    public String getGameName() {
        return jtfGameName.getText();
    }
    public int getNumPers() {
        return Integer.parseInt((String) jcbNumPers.getSelectedItem());
    }
    public int getNumImpos() {
        return Integer.parseInt((String) jcbNumImpos.getSelectedItem());
    }
    public String getColor() {
        return (String) jcbColor.getSelectedItem();
    }
    public void setColor(int selectedItem) {
        jcbColor.setSelectedIndex(selectedItem);
    }
    public void setNumPers(int selectedItem) {
        jcbNumPers.setSelectedIndex(selectedItem);
    }
    public void setNumImpos(int selectedItem) {
        jcbNumImpos.setSelectedIndex(selectedItem);
    }
    public void PersAndImposErrorMessage() {
        JOptionPane.showMessageDialog(null, "La relació entre personatges i impostors es incorrecte!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void createCorrect() {
        JOptionPane.showMessageDialog(null, "Has creat correctement la partida!", "Correcte", JOptionPane.INFORMATION_MESSAGE);
    }
    public void emptyName() {
        JOptionPane.showMessageDialog(null, "No has introduït res al nom!", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
