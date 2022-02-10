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

        File file = new File("src/img/dummy.png");
        Image image = ImageIO.read(file);
        ImageIcon mainScreenImg = new ImageIcon(image);
        JLabel mainScreenImgContainer = new JLabel("1");
        mainScreenImgContainer.setText("");
        mainScreenImgContainer.setIcon(mainScreenImg);

        BasicStroke stroke = new BasicStroke(10);
        mainScreenImgContainer.setBorder(BorderFactory.createStrokeBorder(stroke, Color.YELLOW));
        rootPanel.add(mainScreenImgContainer);

        //Event Log Interface
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

        //позиционирование и масштабирование элементов
        labelHitPoints.setBounds(44, 44, 140, 40);
        labelManaPoints.setBounds(44, 54, 40, 40);
        labelStaminaPoints.setBounds(44, 64, 40, 40);
        labelStrength.setBounds(44, 74, 40, 40);
        labelAgility.setBounds(44, 84, 640, 40);
        labelIntelligence.setBounds(44, 94, 250, 40);
        labeldialogWindowNpc.setBounds(1000, 750, 639, 50);
        attackButton.setBounds(74, 154, 44, 44);
        subLocationComboBox.setBounds(200, 200, 300, 100);
        mainScreenImgContainer.setBounds(1000, 100, 639, 500);
        actionsOnLocation.setBounds(200, 150, 400, 200);
        actionsOnDialog.setBounds(200, 150, 400, 200);
        //шрифт
        setFont(new Font("Dialog", Font.PLAIN, 14));

        //добавление элементов на рут панель
        rootPanel.add(labelHitPoints);
        rootPanel.add(labelManaPoints);
        rootPanel.add(labelStaminaPoints);
        rootPanel.add(labelStrength);
        rootPanel.add(labelAgility);
        rootPanel.add(labelIntelligence);
        rootPanel.add(labeldialogWindowNpc);
        rootPanel.add(attackButton);
        rootPanel.add(subLocationComboBox);
        rootPanel.add(actionsOnLocation);
        rootPanel.add(actionsOnDialog);

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
//Клик в диалоге
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

    }

}

