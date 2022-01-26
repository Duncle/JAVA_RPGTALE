package Game;

import Game.Creatures.Hero;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {

    private JPanel rootPanel = new JPanel();


    public MainForm(Hero hero) {
        setSize(400, 400);
        rootPanel.setLayout(null);
        setContentPane(rootPanel);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel labelHitPoints = new JLabel(String.valueOf(hero.getHitPoints()));
        JLabel labelManaPoints = new JLabel(String.valueOf(hero.getManaPoints()));
        JLabel labelStaminaPoints = new JLabel(String.valueOf(hero.getStaminaPoints()));
        JLabel labelStrength = new JLabel(String.valueOf(hero.getStrength()));
        JLabel labelAgility = new JLabel(String.valueOf(hero.getAgility()));
        JLabel labelIntelligence = new JLabel(String.valueOf(hero.getIntelligence()));

        labelHitPoints.setBounds(44, 44, 40, 40);
        labelManaPoints.setBounds(44, 54, 40, 40);
        labelStaminaPoints.setBounds(44, 64, 40, 40);
        labelStrength.setBounds(44, 74, 40, 40);
        labelAgility.setBounds(44, 84, 40, 40);
        labelIntelligence.setBounds(44, 94, 40, 40);

        setFont(new Font("Dialog", Font.PLAIN, 14));

        rootPanel.add(labelHitPoints);
        rootPanel.add(labelManaPoints);
        rootPanel.add(labelStaminaPoints);
        rootPanel.add(labelStrength);
        rootPanel.add(labelAgility);
        rootPanel.add(labelIntelligence);


    }


}
