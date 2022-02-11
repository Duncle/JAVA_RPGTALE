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

    private JLayeredPane rootPanel = getLayeredPane();

    public MainForm(Hero hero) throws IOException {
        /* Определение размеров окна и позиционирование по центру экрана */
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setLocationRelativeTo(null);
        setUndecorated(true);
        rootPanel.setLayout(null);
        //setContentPane(mainPanel);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        /* Создание основных панелей */
        JPanel bgPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        JPanel navbarPanel = new JPanel();
        JPanel pauseMenuPanel = new JPanel();
        JPanel characterPanel = new JPanel();
        JPanel questPanel = new JPanel();
        JPanel mapPanel = new JPanel();
        JPanel settingsPanel = new JPanel();
        JPanel blackoutPanel = new JPanel();

        bgPanel.setLayout(null);
        mainPanel.setLayout(null);
        navbarPanel.setLayout(null);
        pauseMenuPanel.setLayout(null);
        characterPanel.setLayout(null);
        questPanel.setLayout(null);
        mapPanel.setLayout(null);
        settingsPanel.setLayout(null);
        blackoutPanel.setLayout(null);

        mainPanel.setBounds(0, 0, screenSize.width, screenSize.height);
        bgPanel.setBounds(0, 0, screenSize.width, screenSize.height);
        navbarPanel.setBounds(0, 0, screenSize.width, 40);
        pauseMenuPanel.setBounds(0, 0, screenSize.width, screenSize.height);
        characterPanel.setBounds(0, 0, screenSize.width, screenSize.height);
        questPanel.setBounds(0, 0, screenSize.width, screenSize.height);
        mapPanel.setBounds(0, 0, screenSize.width, screenSize.height);
        settingsPanel.setBounds(0, 0, screenSize.width, screenSize.height);
        blackoutPanel.setBounds(0, 0, screenSize.width, screenSize.height);

        mainPanel.setOpaque(false);
        bgPanel.setOpaque(false);
        navbarPanel.setOpaque(false);
        pauseMenuPanel.setOpaque(false);
        characterPanel.setOpaque(false);
        questPanel.setOpaque(false);
        mapPanel.setOpaque(false);
        settingsPanel.setOpaque(false);
        blackoutPanel.setOpaque(false);
        rootPanel.setOpaque(false);

        pauseMenuPanel.setVisible(false);
        characterPanel.setVisible(false);
        questPanel.setVisible(false);
        mapPanel.setVisible(false);
        settingsPanel.setVisible(false);
        blackoutPanel.setVisible(false);

        rootPanel.add(mainPanel, new Integer(5));
        rootPanel.add(bgPanel, new Integer(1));
        rootPanel.add(navbarPanel, new Integer(10));
        rootPanel.add(pauseMenuPanel, new Integer(7));
        rootPanel.add(characterPanel, new Integer(10));
        rootPanel.add(questPanel, new Integer(10));
        rootPanel.add(mapPanel, new Integer(10));
        rootPanel.add(settingsPanel, new Integer(10));
        rootPanel.add(blackoutPanel, new Integer(3));

        /* Импорт изображений */
        ImageIcon mainScreenBG = new ImageIcon(ImageIO.read(new File("src/res/img/van.png")));
        ImageIcon heroImg = new ImageIcon(ImageIO.read(new File("src/res/img/NegrTest.png")));
        ImageIcon minimapImg = new ImageIcon(ImageIO.read(new File("src/res/img/minimap.png")));
        ImageIcon characterImg = new ImageIcon(ImageIO.read(new File("src/res/img/charImgTest.png")));
        ImageIcon characterPanelBG = new ImageIcon(ImageIO.read(new File("src/res/img/characterList.png")));
        ImageIcon questPanelBG = new ImageIcon(ImageIO.read(new File("src/res/img/questBG.jpg")));
        ImageIcon mapPanelBG = new ImageIcon(ImageIO.read(new File("src/res/img/mapBG.jpg")));
        ImageIcon settingsPanelBG = new ImageIcon(ImageIO.read(new File("src/res/img/settingsBG.png")));
        ImageIcon blackoutBG = new ImageIcon(ImageIO.read(new File("src/res/img/blackoutBG90.png")));

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
        mainScreenImgContainer.setBounds(0, 0, mainScreenBG.getIconWidth(), mainScreenBG.getIconHeight());
        mainScreenImgContainer.setIcon(mainScreenBG);

        /* Добавление blackout */
        JLabel blackoutContainer = new JLabel("");
        blackoutContainer.setBounds(0, 0, blackoutBG.getIconWidth(), blackoutBG.getIconHeight());
        blackoutContainer.setIcon(blackoutBG);

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

        /* Добавление кнопки возвращения к игре */
        JButton backButton = new JButton("Вернуться в игру");

        backButton.setBounds(screenSize.width - menuButtonsWidth, screenSize.height - menuButtonsHeight, menuButtonsWidth, menuButtonsHeight);

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

        /* Location Picker Interface */
        //Combobox доступные локации для перемещения, если у локации id некоторого пути !=-1 то добавляем комбобокс, т.е. на эту локацию можно перейти
        DefaultComboBoxModel<String> cbModel = new DefaultComboBoxModel();

        JComboBox subLocationComboBox = new JComboBox(hero.avaliableSublocationtsToMove(hero, cbModel));

        subLocationComboBox.setBounds(0, screenSize.height - minimapImg.getIconHeight() - subLocationComboBoxHeight - 20, subLocationComboBoxWidth, subLocationComboBoxHeight);

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

        /* Character Display Interface */
        JLabel characterName = new JLabel("Character Display");

        JLabel characterImgContainer = new JLabel("");
        characterName.setFont(new Font("Monaco", Font.PLAIN, 32));

        characterImgContainer.setBounds(0, 0, 50, 50);
        characterImgContainer.setIcon(characterImg);

        characterName.setForeground(Color.BLACK);

        int characterImgContainerWidth = characterImg.getIconWidth();
        int characterImgContainerHeight = characterImg.getIconHeight();

        characterName.setBounds(screenSize.width - characterNameWidth - 100, menuButtonsHeight + 30, characterNameWidth, characterNameHeight);
        characterImgContainer.setBounds(screenSize.width - characterNameWidth - 100 + characterNameWidth / 2 - characterImgContainerWidth / 2, menuButtonsHeight + 100, characterImgContainerWidth, characterImgContainerHeight);

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

//        JLayeredPane.putLayer(mainScreenImgContainer, 1);
//        JLayeredPane.putLayer(menuButton, 2);
//        JLayeredPane.putLayer(characterButton, 2);
//        JLayeredPane.putLayer(questButton, 2);
//        JLayeredPane.putLayer(mapButton, 2);
//        JLayeredPane.putLayer(settingsButton, 2);

        bgPanel.add(mainScreenImgContainer);
        blackoutPanel.add(blackoutContainer);

        navbarPanel.add(menuButton);
        navbarPanel.add(characterButton);
        navbarPanel.add(questButton);
        navbarPanel.add(mapButton);
        navbarPanel.add(settingsButton);

        pauseMenuPanel.add(continueButton);
        pauseMenuPanel.add(exitButton);

        mainPanel.add(subLocationComboBox);
        mainPanel.add(minimapImgContainer);
        mainPanel.add(characterName);
        mainPanel.add(characterImgContainer);
        mainPanel.add(eventlogName);
        mainPanel.add(eventlogText);

        mainPanel.add(heroName);
        mainPanel.add(heroImgContainer);

        mainPanel.add(labelHitPoints);
        mainPanel.add(labelManaPoints);
        mainPanel.add(labelStaminaPoints);
        mainPanel.add(labelStrength);
        mainPanel.add(labelAgility);
        mainPanel.add(labelIntelligence);
        mainPanel.add(labelDialogWindowNpc);
        mainPanel.add(attackButton);

        mainPanel.add(actionsOnLocation);
        mainPanel.add(actionsOnDialog);

        rootPanel.add(backButton, new Integer(15));

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
            }
        });

        /* Обработчики кнопок навигационного меню */
        menuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                pauseMenuPanel.setVisible(true);
                blackoutPanel.setVisible(true);
                //revalidate();
                //repaint();
            }
        });

        characterButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                mainPanel.setVisible(false);
                mainScreenImgContainer.setIcon(characterPanelBG);
                characterPanel.setVisible(true);
                pauseMenuPanel.setVisible(false);
                blackoutPanel.setVisible(false);
                //revalidate();
                //repaint();
            }
        });

        questButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                mainPanel.setVisible(false);
                mainScreenImgContainer.setIcon(questPanelBG);
                questPanel.setVisible(true);
                pauseMenuPanel.setVisible(false);
                blackoutPanel.setVisible(false);
                //revalidate();
                //repaint();
            }
        });

        mapButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                mainPanel.setVisible(false);
                mainScreenImgContainer.setIcon(mapPanelBG);
                mapPanel.setVisible(true);
                pauseMenuPanel.setVisible(false);
                blackoutPanel.setVisible(false);
                //revalidate();
                //repaint();
            }
        });

        settingsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                mainPanel.setVisible(false);
                mainScreenImgContainer.setIcon(settingsPanelBG);
                settingsPanel.setVisible(true);
                pauseMenuPanel.setVisible(false);
                blackoutPanel.setVisible(false);
                //revalidate();
                //repaint();
            }
        });

        /* Обработчики кнопок меню паузы */
        continueButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                pauseMenuPanel.setVisible(false);
                blackoutPanel.setVisible(false);
                //revalidate();
                //repaint();
            }
        });

        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                System.exit(0);
            }
        });

        /* Обработчики кнопки возвращения к игре */
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                mainPanel.setVisible(true);
                mainScreenImgContainer.setIcon(mainScreenBG);
                characterPanel.setVisible(false);
                questPanel.setVisible(false);
                mapPanel.setVisible(false);
                settingsPanel.setVisible(false);
                blackoutPanel.setVisible(false);
                //revalidate();
                //repaint();
            }
        });

        repaint();
        revalidate();
    }
}