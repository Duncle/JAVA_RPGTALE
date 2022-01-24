package Game;

import javax.swing.*;

public class MainForm extends JFrame {

    private JPanel rootPanel;
    private JButton button1;

    public MainForm () {
        setContentPane(rootPanel);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
