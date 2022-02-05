package Game;

import Game.Creatures.Hero;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Set;

public class MainForm extends JFrame {

    private JLayeredPane mainPanel = new JLayeredPane();
    private JPanel pauseMenuPanel = new JPanel();


    public MainForm(Hero hero) throws IOException {
        /* Определение размеров окна и позиционирование по центру экрана */
        Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(ScreenSize.width, ScreenSize.height);
        setLocationRelativeTo(null);
        setUndecorated(true);
        mainPanel.setLayout(null);
        setContentPane(mainPanel);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        /* Добавление PNG картинки */
        ImageIcon mainScreenImg = new ImageIcon(ImageIO.read(new File("src/res/img/van.png")));
        JLabel mainScreenImgContainer = new JLabel("");
        mainScreenImgContainer.setBounds(0, 0, mainScreenImg.getIconWidth(), mainScreenImg.getIconHeight());
        mainScreenImgContainer.setIcon(mainScreenImg);

        mainPanel.add(mainScreenImgContainer, 1);

        /* Добавление Nav Bar */
        JButton menuButton = new JButton("Меню");
        JButton characterButton = new JButton("Персонаж");
        JButton questButton = new JButton("Квесты");
        JButton mapButton = new JButton("Карта");
        JButton settingsButton = new JButton("Настройки");
        int menuButtonsWidth = 384;
        int menuButtonsHeight = 40;
        menuButton.setBounds(0, 0, menuButtonsWidth, menuButtonsHeight);
        characterButton.setBounds(menuButtonsWidth, 0, menuButtonsWidth, menuButtonsHeight);
        questButton.setBounds(menuButtonsWidth * 2, 0, menuButtonsWidth, menuButtonsHeight);
        mapButton.setBounds(menuButtonsWidth * 3, 0, menuButtonsWidth, menuButtonsHeight);
        settingsButton.setBounds(menuButtonsWidth * 4, 0, menuButtonsWidth, menuButtonsHeight);
        mainPanel.add(menuButton, 2);
        mainPanel.add(characterButton, 2);
        mainPanel.add(questButton, 2);
        mainPanel.add(mapButton, 2);
        mainPanel.add(settingsButton, 2);

        setContentPane(mainPanel);
        mainPanel.setVisible(true);
        revalidate();
        repaint();

        /* Event Log Interface */
        DefaultListModel listModelForActionsOnLocation = new DefaultListModel();
        DefaultListModel listModelForActionsOnDialog = new DefaultListModel();

        JList<String> eventLog = new JList<String>();
        JList<String> actionsOnLocation = new JList<String>(listModelForActionsOnLocation);
        JList<String> actionsOnDialog = new JList<String>(listModelForActionsOnDialog);


        if (hero.getSubLocation().getNpc() != null) {
            listModelForActionsOnLocation.addElement("Поговорить с" + " " + hero.getSubLocation().getNpc().getName() + "ом");

        }

        //статы персонажа
        JLabel labelHitPoints = new JLabel(String.valueOf(hero.getHitPoints()));
        JLabel labelManaPoints = new JLabel(String.valueOf(hero.getManaPoints()));
        JLabel labelStaminaPoints = new JLabel(String.valueOf(hero.getStaminaPoints()));
        JLabel labelStrength = new JLabel(String.valueOf(hero.getStrength()));
        JLabel labelAgility = new JLabel(String.valueOf(hero.getAgility()));
        JLabel labelIntelligence = new JLabel(String.valueOf(hero.getIntelligence()));
        JLabel labeldialogWindowNpc = new JLabel(String.valueOf(hero.getIntelligence()));
        //кнопки
        JButton attackButton = new JButton("attack");


        //Combobox доступные локации для перемещения, если у локации id некоторого пути !=-1 то добавляем комбобокс, т.е. на эту локацию можно перейти
        DefaultComboBoxModel<String> cbModel = new DefaultComboBoxModel();

        JComboBox subLocationComboBox = new JComboBox(hero.avaliableSublocationtsToMove(hero, cbModel));


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
        //позиционирование и масштабирование элементов
        labelHitPoints.setBounds(44, 44, 140, 40);
        labelManaPoints.setBounds(44, 54, 40, 40);
        labelStaminaPoints.setBounds(44, 64, 40, 40);
        labelStrength.setBounds(44, 74, 40, 40);
        labelAgility.setBounds(44, 84, 40, 40);
        labelIntelligence.setBounds(44, 94, 40, 40);
        labeldialogWindowNpc.setBounds(1000, 750, 639, 50);
        attackButton.setBounds(104, 104, 44, 44);
        subLocationComboBox.setBounds(200, 200, 300, 100);
        actionsOnLocation.setBounds(200, 100, 400, 200);
        actionsOnDialog.setBounds(200, 100, 400, 200);
        //шрифт
        setFont(new Font("Dialog", Font.PLAIN, 14));

        /* Добавление элементов на main панель */
        mainPanel.add(labelHitPoints);
        mainPanel.add(labelManaPoints);
        mainPanel.add(labelStaminaPoints);
        mainPanel.add(labelStrength);
        mainPanel.add(labelAgility);
        mainPanel.add(labelIntelligence);
        mainPanel.add(labeldialogWindowNpc);
        mainPanel.add(attackButton);
        mainPanel.add(subLocationComboBox);
        mainPanel.add(actionsOnLocation);
        mainPanel.add(actionsOnDialog);

        actionsOnDialog.setVisible(false);

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
                hero.toMove(hero, subLocationComboBox);
                //чистим старые пути локации
                cbModel.removeAllElements();
                //герой изменил местоположение, просмотр у новой локации ее путей и добавление их в комбобокс
                //заполнение комбобокса
                JComboBox subLocationComboBox = new JComboBox(hero.avaliableSublocationtsToMove(hero, cbModel));
            }
        });

        actionsOnLocation.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (actionsOnLocation.getSelectedIndex() == 0) {
                    actionsOnLocation.setVisible(false);
                    actionsOnDialog.setVisible(true);
                    listModelForActionsOnDialog.removeAllElements();
                    Set<String> setKeys = hero.getSubLocation().getNpc().getDialog().getDialogues().keySet();
                    for (String k : setKeys) {
                        listModelForActionsOnDialog.addElement(k);
                    }
                }

            }
        });


        actionsOnDialog.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (actionsOnDialog.getSelectedValue() != null) {
                    labeldialogWindowNpc.setText(String.valueOf(hero.getSubLocation().getNpc().getDialog().getDialogues().get(actionsOnDialog.getSelectedValue())));
                    listModelForActionsOnDialog.removeElement(actionsOnDialog.getSelectedValue());
                    hero.getSubLocation().getNpc().getDialog().getDialogues().remove(actionsOnDialog.getSelectedValue());
                }
            }
        });

        revalidate();
        repaint();
    }

}

