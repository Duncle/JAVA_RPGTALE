package Game;

import javax.swing.*;

public class MainForm extends JFrame{
    private JButton button1;
    private JPanel rootPanel;

    public MainForm() {
        setContentPane(rootPanel);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
