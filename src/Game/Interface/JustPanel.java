package Game.Interface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JustPanel extends JPanel {

    public JustPanel() {
        JPanel JustPanel = new JPanel();
        JustPanel.setLayout(null);
        setBounds(0, 0, 1920, 1080);
        JustPanel.setBackground(Color.BLACK);

        //setOpaque(false);
        JLabel btn = new JLabel("Кнопка");

        setBounds(10, 10, 1400, 400);
        add(btn);

        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }
        });
    }



}