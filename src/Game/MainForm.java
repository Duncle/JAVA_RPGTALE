package Game;

import Game.Creatures.Hero;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Objects;

public class MainForm extends JFrame {

    private JPanel rootPanel = new JPanel();

    public MainForm(Hero hero) throws IOException {
        //Определение размеров окна и позиционирование по центру экрана
        Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(ScreenSize.width, ScreenSize.height);
        setLocationRelativeTo(null);
        rootPanel.setLayout(null);
        setContentPane(rootPanel);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Добавление PNG картинки
        ImageIcon mainScreenImg = new ImageIcon("dummy.png");
        JLabel mainScreenImgContainer = new JLabel("1");
        mainScreenImgContainer.setText("");
        mainScreenImgContainer.setIcon(mainScreenImg);
        mainScreenImgContainer.setBounds(1000,100, 639, 500);
        BasicStroke stroke = new BasicStroke(10);
        mainScreenImgContainer.setBorder(BorderFactory.createStrokeBorder(stroke, Color.YELLOW));
        rootPanel.add(mainScreenImgContainer);

        //Event Log Interface
        JLabel eventlogLabel = new JLabel("Event Log");
        JLabel eventlogBody = new JLabel("В данный момент нет сообщений для отображения");
        int eventlogArr[] = new int[10];



        //статы персонажа
        JLabel labelHitPoints = new JLabel(String.valueOf(hero.getHitPoints()));
        JLabel labelManaPoints = new JLabel(String.valueOf(hero.getManaPoints()));
        JLabel labelStaminaPoints = new JLabel(String.valueOf(hero.getStaminaPoints()));
        JLabel labelStrength = new JLabel(String.valueOf(hero.getStrength()));
        JLabel labelAgility = new JLabel(String.valueOf(hero.getAgility()));
        JLabel labelIntelligence = new JLabel(String.valueOf(hero.getIntelligence()));

        //кнопки
        JButton attackButton = new JButton("attack");
        JButton leftButton = new JButton("attack");
        JButton rightButton = new JButton("attack");
        JButton forwardButton = new JButton("attack");
        JButton backButton = new JButton("attack");

        //Combobox доступные локации для перемещения
        String[] description = new String[hero.getSubLocation().getRoots().length];
        DefaultComboBoxModel<String> cbModel = new DefaultComboBoxModel();
        for (int i = 0; i < description.length; i++) {

            if (hero.getSubLocation().getRoots()[i] != -1) {
                for (int j = 0; j < hero.getLocation().getSubLocation().length; j++) {
                    if (hero.getLocation().getSubLocation()[j].getId() == hero.getSubLocation().getRoots()[i]) {
                        cbModel.addElement((hero.getLocation().getSubLocation()[j].getDescription()));
                    }
                }
            }

        }


        JComboBox subLocationComboBox = new JComboBox(cbModel);



            subLocationComboBox.setRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(final JList list, Object value, final int index, final boolean isSelected,
                                                              final boolean cellHasFocus) {

                    if (index == -1) {
                        value = "Доступно для перемещения";
                    }

                    return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                }
            });
        //позиционирование и масштамирование элементов
        labelHitPoints.setBounds(44, 44, 140, 40);
        labelManaPoints.setBounds(44, 54, 40, 40);
        labelStaminaPoints.setBounds(44, 64, 40, 40);
        labelStrength.setBounds(44, 74, 40, 40);
        labelAgility.setBounds(44, 84, 40, 40);
        labelIntelligence.setBounds(44, 94, 40, 40);
        attackButton.setBounds(104, 104, 44, 44);
        subLocationComboBox.setBounds(200, 200, 300, 100);
        //шрифт
        setFont(new Font("Dialog", Font.PLAIN, 14));

        //добавление элементов на рут панель
        rootPanel.add(labelHitPoints);
        rootPanel.add(labelManaPoints);
        rootPanel.add(labelStaminaPoints);
        rootPanel.add(labelStrength);
        rootPanel.add(labelAgility);
        rootPanel.add(labelIntelligence);
        rootPanel.add(attackButton);
        rootPanel.add(subLocationComboBox);

        //реализация атака по нажатию кнопки плюс обновление лейбла хитпоинты
        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hero.toAttack();
                labelHitPoints.setText(String.valueOf(hero.getHitPoints()));
            }
        });

        subLocationComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                subLocationComboBox.setRenderer(new DefaultListCellRenderer() {
                    @Override
                    public Component getListCellRendererComponent(final JList list, Object value, final int index, final boolean isSelected,
                                                                  final boolean cellHasFocus) {

                        if (index == -1) {
                            value = "Доступно для перемещения";
                        }

                        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    }
                });


                String selectedLocation = subLocationComboBox.getSelectedItem().toString();
                for (int i = 0; i < description.length; i++) {
                    if (subLocationComboBox.getSelectedItem().toString().equals(hero.getLocation().getSubLocation()[i].getDescription())) {
                        labelHitPoints.setText(hero.getLocation().getSubLocation()[i].getDescription());
                        hero.setSubLocation(hero.getLocation().getSubLocation()[i]);
                        String[] description = new String[hero.getSubLocation().getRoots().length];

                    }
                }

                cbModel.removeAllElements();
                for (int i = 0; i < description.length; i++) {

                    if (hero.getSubLocation().getRoots()[i] != -1) {
                        for (int j = 0; j < hero.getLocation().getSubLocation().length; j++) {
                            if (hero.getLocation().getSubLocation()[j].getId() == hero.getSubLocation().getRoots()[i]) {
                                cbModel.addElement((hero.getLocation().getSubLocation()[j].getDescription()));
                            }
                        }
                    }

                }


                JComboBox subLocationComboBox = new JComboBox(cbModel);
            }
        });


    }

}

