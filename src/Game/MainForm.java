package Game;

import Game.Creatures.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainForm extends JFrame {

    private JPanel rootPanel = new JPanel();

    public MainForm(Hero hero) {
        setSize(400, 400);
        rootPanel.setLayout(null);
        setContentPane(rootPanel);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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

        //Combobox доступные локации для перемещения, если у локации id некоторого пути !=-1 то добавляем комбобокс, т.е. на эту локацию можно перейти
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

//заполнение комбобокса
        JComboBox subLocationComboBox = new JComboBox(cbModel);

// getListCellRendererComponent- визуальное оформление комбобокса заменяем заголовок на свой -доступно для перемещения
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
         //реализация перехода между локациями привыборе пунктов из выпадающего
        // меню циклом проходимся по новой путям новой локации,


        subLocationComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                //если название выбранной саблокации совпадает с названии саблокации в масиве локация.саблокация , то герой негрой на нее переходит
                for (int i = 0; i < description.length; i++) {
                    if (subLocationComboBox.getSelectedItem().toString().equals(hero.getLocation().getSubLocation()[i].getDescription())) {
                        labelHitPoints.setText(hero.getLocation().getSubLocation()[i].getDescription());
                        hero.setSubLocation(hero.getLocation().getSubLocation()[i]);
                        String[] description = new String[hero.getSubLocation().getRoots().length];

                    }
                }
                //чистим старые пути локации
                cbModel.removeAllElements();
                //герой изменил местоположение, просмотр у новой локации ее путей и добавление их в комбобокс
                for (int i = 0; i < description.length; i++) {

                    if (hero.getSubLocation().getRoots()[i] != -1) {
                        for (int j = 0; j < hero.getLocation().getSubLocation().length; j++) {
                            if (hero.getLocation().getSubLocation()[j].getId() == hero.getSubLocation().getRoots()[i]) {
                                cbModel.addElement((hero.getLocation().getSubLocation()[j].getDescription()));
                            }
                        }
                    }

                }
               //заполнение комбобокса
                JComboBox subLocationComboBox = new JComboBox(cbModel);
            }
        });


    }

}

