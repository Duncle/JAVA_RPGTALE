package Game;

import Game.Creatures.Hero;
import Game.Trees.Node;

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
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setLocationRelativeTo(null);
        setUndecorated(true);
        mainPanel.setLayout(null);
        setContentPane(mainPanel);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        /* Импорт изображений */
        ImageIcon mainScreenImg = new ImageIcon(ImageIO.read(new File("src/res/img/van.png")));
        ImageIcon heroImg = new ImageIcon(ImageIO.read(new File("src/res/img/NegrTest.png")));
        ImageIcon minimapImg = new ImageIcon(ImageIO.read(new File("src/res/img/minimap.png")));
        ImageIcon characterImg = new ImageIcon(ImageIO.read(new File("src/res/img/charImgTest.png")));

        /* Гравитационная постоянная */
        int pauseButtonWidth = screenSize.width / 5;
        int pauseButtonHeight = screenSize.height / 20;

        int menuButtonsWidth = screenSize.width / 5;
        int menuButtonsHeight = 40;

        int heroNameWidth = 300;
        int heroNameHeight = 32;

        int subLocationComboBoxWidth = menuButtonsWidth;
        int subLocationComboBoxHeight = menuButtonsHeight;

        int characterNameWidth = 300;
        int characterNameHeight = 32;

        int eventlogNametWidth = 200;
        int eventlogNameHeight = 40;
        int eventlogTextWidth = screenSize.width / 3;
        int eventlogTextHeight = screenSize.height / 3;

        /* Добавление PNG картинки */

        JLabel mainScreenImgContainer = new JLabel("");
        mainScreenImgContainer.setBounds(0, 0, mainScreenImg.getIconWidth(), mainScreenImg.getIconHeight());
        mainScreenImgContainer.setIcon(mainScreenImg);

        //mainPanel.add(mainScreenImgContainer, 0);

        /* Добавление Nav Bar */
        JButton menuButton = new JButton("Меню");
        JButton characterButton = new JButton("Персонаж");
        JButton questButton = new JButton("Квесты");
        JButton mapButton = new JButton("Карта");
        JButton settingsButton = new JButton("Настройки");

        menuButton.setBounds(0, 0, menuButtonsWidth, menuButtonsHeight);
        characterButton.setBounds(menuButtonsWidth, 0, menuButtonsWidth, menuButtonsHeight);
        questButton.setBounds(menuButtonsWidth * 2, 0, menuButtonsWidth, menuButtonsHeight);
        mapButton.setBounds(menuButtonsWidth * 3, 0, menuButtonsWidth, menuButtonsHeight);
        settingsButton.setBounds(menuButtonsWidth * 4, 0, menuButtonsWidth, menuButtonsHeight);
        mainPanel.add(menuButton, 0);
        mainPanel.add(characterButton, 0);
        mainPanel.add(questButton, 0);
        mainPanel.add(mapButton, 0);
        mainPanel.add(settingsButton, 0);

        setContentPane(mainPanel);
        mainPanel.setVisible(true);
        revalidate();
        repaint();

        /* Добавление PauseMenu */
        // Темный фон для улучшения видимости меню паузы
//        JLabel blackout = new JLabel("Ало");
//        blackout.setBounds(0, 0, screenSize.width, screenSize.height);
//        blackout.setBackground(Color.BLACK);
        // Кнопки "Продолжить" и "Выход"
        JButton continueButton = new JButton("Продолжить");
        JButton exitButton = new JButton("Выйти");


        continueButton.setBounds(screenSize.width / 2 - (pauseButtonWidth) / 2, screenSize.height / 2 - 30, pauseButtonWidth, pauseButtonHeight);
        exitButton.setBounds(screenSize.width / 2 - (pauseButtonWidth) / 2, screenSize.height / 2 + 30, pauseButtonWidth, pauseButtonHeight);

        mainPanel.add(continueButton, 0);
        mainPanel.add(exitButton, 0);

        continueButton.setVisible(false);
        exitButton.setVisible(false);

        //mainPanel.add(blackout, 3);

        // Интерактивные действия кнопок


        /* Hero Panel Interface */
        JLabel heroName = new JLabel("Hero Display");

        JLabel heroImgContainer = new JLabel("");
        heroName.setFont(new Font("Monaco", Font.PLAIN, 32));

        heroImgContainer.setBounds(0, 0, 50, 50);
        heroImgContainer.setIcon(heroImg);

        //mainPanel.add(mainScreenImgContainer, 0);

        heroName.setForeground(Color.BLACK);

        int heroImgContainerWidth = heroImg.getIconWidth();
        int heroImgContainerHeight = heroImg.getIconHeight();

        heroName.setBounds(0, menuButtonsHeight + 30, characterNameWidth, characterNameHeight);
        heroImgContainer.setBounds(0, menuButtonsHeight + heroNameHeight + 20, heroImgContainerWidth, heroImgContainerHeight);

        mainPanel.add(heroName);
        mainPanel.add(heroImgContainer);

        /* Location Picker Interface */
        //Combobox доступные локации для перемещения, если у локации id некоторого пути !=-1 то добавляем комбобокс, т.е. на эту локацию можно перейти
        DefaultComboBoxModel<String> cbModel = new DefaultComboBoxModel();

        JComboBox subLocationComboBox = new JComboBox(hero.avaliableSublocationtsToMove(hero, cbModel));





        subLocationComboBox.setBounds(0, screenSize.height - minimapImg.getIconHeight() - subLocationComboBoxHeight - 20, subLocationComboBoxWidth, subLocationComboBoxHeight);

        mainPanel.add(subLocationComboBox, 0);

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




        /* Minimap Interface */

        JLabel minimapImgContainer = new JLabel("");

        minimapImgContainer.setBounds(0, screenSize.height - 200, 200, 200);
        minimapImgContainer.setIcon(minimapImg);

        mainPanel.add(minimapImgContainer, 0);

        /* Character Display Interface */
        JLabel characterName = new JLabel("Character Display");

        JLabel characterImgContainer = new JLabel("");
        characterName.setFont(new Font("Monaco", Font.PLAIN, 32));

        characterImgContainer.setBounds(0, 0, 50, 50);
        characterImgContainer.setIcon(characterImg);

        //mainPanel.add(mainScreenImgContainer, 0);

        characterName.setForeground(Color.BLACK);

        int characterImgContainerWidth = characterImg.getIconWidth();
        int characterImgContainerHeight = characterImg.getIconHeight();

        characterName.setBounds(screenSize.width - characterNameWidth - 100, menuButtonsHeight + 30, characterNameWidth, characterNameHeight);
        characterImgContainer.setBounds(screenSize.width - characterNameWidth - 100 + characterNameWidth / 2 - characterImgContainerWidth / 2, menuButtonsHeight + 100, characterImgContainerWidth, characterImgContainerHeight);

        mainPanel.add(characterName);
        mainPanel.add(characterImgContainer);

        /* Event Log Interface */
        JLabel eventlogName = new JLabel("Event Log");
        JTextArea eventlogText = new JTextArea("Чел");
        eventlogName.setFont(new Font("Monaco", Font.PLAIN, 32));
        eventlogText.setFont(new Font("Monaco", Font.PLAIN, 20));

        eventlogName.setForeground(Color.WHITE);
        eventlogText.setForeground(Color.WHITE);
        eventlogText.setBackground(Color.BLACK);
        eventlogText.setMargin(new Insets(70, 20, 10, 10));

        eventlogName.setBounds(screenSize.width - eventlogTextWidth / 2 - 50, screenSize.height - eventlogTextHeight - 45, eventlogNametWidth, eventlogNameHeight);
        eventlogText.setBounds(screenSize.width - eventlogTextWidth, screenSize.height - eventlogTextHeight - 50, eventlogTextWidth, eventlogTextHeight);

        String[] eventlogEvents = {"Событие 1", "Событие 2 (текст)", "Василий Дмитрич"};

        String textBuffer = "";
        for (int i = 0; i < eventlogEvents.length; i++) {
            textBuffer += eventlogEvents[i] + "\n\n\n";
        }
        eventlogText.setText(textBuffer);
        System.out.println(textBuffer);

        mainPanel.add(eventlogName);
        mainPanel.add(eventlogText);

        /* Sweat experiment area */
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
        JLabel labelDialogWindowNpc = new JLabel(String.valueOf(hero.getIntelligence()));
        //кнопки
        JButton attackButton = new JButton("attack");


        //позиционирование и масштабирование элементов
        labelHitPoints.setBounds(344, 144, 140, 40);
        labelManaPoints.setBounds(344, 154, 40, 40);
        labelStaminaPoints.setBounds(344, 164, 40, 40);
        labelStrength.setBounds(344, 174, 40, 40);
        labelAgility.setBounds(344, 184, 40, 40);
        labelIntelligence.setBounds(344, 194, 40, 40);
        labelDialogWindowNpc.setBounds(1000, 750, 639, 50);

        attackButton.setBounds(404, 104, 44, 44);

        actionsOnLocation.setBounds(600, 100, 400, 200);
        actionsOnDialog.setBounds(600, 100, 400, 200);
        //шрифт
        setFont(new Font("Dialog", Font.PLAIN, 14));

        /* Добавление элементов на main панель */
        mainPanel.add(labelHitPoints, 0);
        mainPanel.add(labelManaPoints, 0);
        mainPanel.add(labelStaminaPoints, 0);
        mainPanel.add(labelStrength, 0);
        mainPanel.add(labelAgility, 0);
        mainPanel.add(labelIntelligence, 0);
        mainPanel.add(labelDialogWindowNpc, 0);
        mainPanel.add(attackButton, 0);

        mainPanel.add(actionsOnLocation, 0);
        mainPanel.add(actionsOnDialog, 0);

        actionsOnDialog.setVisible(false);

        subLocationComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //если название выбранной саблокации совпадает с названии саблокации в масиве локация.саблокация , то герой негрой на нее переходит
                hero.toMove(hero, subLocationComboBox);
                //чистим старые пути локации
                listModelForActionsOnLocation.removeAllElements();
                cbModel.removeAllElements();
                //герой изменил местоположение, просмотр у новой локации ее путей и добавление их в комбобокс
                //заполнение комбобокса
                JComboBox subLocationComboBox = new JComboBox(hero.avaliableSublocationtsToMove(hero, cbModel));
                //обновление имени нпс в комбобоксе действий на локации, после создания всего интерфейса надо создать метод, который ьбудет обновлять все элементы при переходе с локации на локацию
                if (hero.getSubLocation().getNpc() != null) {
                    listModelForActionsOnLocation.addElement("Поговорить с" + " " + hero.getSubLocation().getNpc().getName() + "ом");

                }
                actionsOnLocation.setVisible(true);
                actionsOnDialog.setVisible(false);
            }
        });

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


        actionsOnLocation.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (actionsOnLocation.getSelectedIndex() == 0) {
                    actionsOnLocation.setVisible(false);
                    actionsOnDialog.setVisible(true);
                    listModelForActionsOnDialog.removeAllElements();

                    for (Node k : hero.getSubLocation().getNpc().getDialog().getCurrentNode().getNextNodes()) {

                        listModelForActionsOnDialog.addElement(k.getKey());
                    }


                }
            }
        });

        actionsOnDialog.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                for (Node i : hero.getSubLocation().getNpc().getDialog().getCurrentNode().getNextNodes()) {

                    if (actionsOnDialog.getSelectedValue().equals(String.valueOf(i.getKey()))) {

                        hero.getSubLocation().getNpc().getDialog().setCurrentNode(i);
                        listModelForActionsOnDialog.removeAllElements();
                        break;

                    }
                }

                if (hero.getSubLocation().getNpc().getDialog().getCurrentNode().getNextNodes() == null) {

                    hero.getSubLocation().getNpc().getDialog().setCurrentNode(hero.getSubLocation().getNpc().getDialog().getRootNode());

                }

                if (hero.getSubLocation().getNpc().getDialog().getCurrentNode().getNextNodes() != null) {
                    for (Node k : hero.getSubLocation().getNpc().getDialog().getCurrentNode().getNextNodes()) {

                        listModelForActionsOnDialog.addElement(k.getKey());
                    }
                }
                repaint();
                revalidate();
            }
        });

        menuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                continueButton.setVisible(true);
                exitButton.setVisible(true);
                revalidate();
                repaint();
            }
        });

        continueButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                continueButton.setVisible(false);
                exitButton.setVisible(false);
                revalidate();
                repaint();
            }
        });

        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                System.exit(0);
            }
        });

    }
}