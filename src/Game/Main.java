package Game;

import Game.Actions.Dialog;
import Game.Creatures.Enemy;
import Game.Creatures.Hero;
import Game.Creatures.NPC;
import Game.ItemStorages.Inventory;
import Game.Map.Location;
import Game.Map.SubLocation;
import Game.Quests.Quest;
import Game.Stuffs.Stuff;
import Game.Stuffs.StuffSubs.Equipments.Armor;
import Game.Stuffs.StuffSubs.Equipments.Weapon;
import Game.Trees.Node;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        EventQueue.invokeLater(() -> {

            //Оружие
            Weapon sword = new Weapon(1, "Меч", 100, new ImageIcon("src/res/img/Equipment/Sword.png"), 10, 5, 0);
            Weapon axe = new Weapon(2, "Топорор", 50, new ImageIcon("src/res/img/Equipment/Axe.png"), 3, 2, 0);
            Weapon doubleAxe = new Weapon(3, "Секира", 5000, new ImageIcon("src/res/img/Equipment/Double_Axe.png"), 3, 20, 0);
            Weapon warhammer = new Weapon(4, "Боевой топор", 150, new ImageIcon("src/res/img/Equipment/War_Hammer.png"), 3, 2, 0);


            //Броня
            Armor helmet = new Armor(1, "шлем", 50, new ImageIcon("src/res/img/Equipment/helmet.png"), 2, 5, "helmet");


            //Квесты
            List<Quest> heroQuests = new ArrayList<>();

            Quest firstQuest = new Quest(1, "InProgress", "Найти торговца");
            Quest secondQuest = new Quest(2, "InProgress", "second quest");

            //Ноды диалогов
            Node tardenDialogNode1_2_1_1 = new Node(6, "а я слышал что...", "мда...");

            Node tardenDialogNode1_2_1 = new Node(4, "почему", "я не торговец", Arrays.asList(tardenDialogNode1_2_1_1));
            Node tardenDialogNode1_2_2 = new Node(5, "Где найти торговца", "Хммм,это долгая история /n ты можешь найти его в хижине аутмара", firstQuest);

            Node tardenDialogNode1_1 = new Node(1, "Здравствуй", "Привет");
            Node tardenDialogNode1_2 = new Node(2, "Что ты продаешь", "ничего", Arrays.asList(tardenDialogNode1_2_1, tardenDialogNode1_2_2));
            Node tardenDialogNode1_3 = new Node(3, "Пока", "Я пошел");

            Node tardenDialogRootNode = new Node(0, "Подойти к дракону", "Кто тут", Arrays.asList(tardenDialogNode1_1, tardenDialogNode1_2, tardenDialogNode1_3));

            //Диалоги
            Dialog tardenDialog = new Dialog(tardenDialogRootNode);

            //NPC
            NPC tarden = new NPC("Тарден", 32, 15, 24, sword, helmet, firstQuest, tardenDialog);
            NPC jimdjar = new NPC("Джимджар", 27, 2, 15, axe, helmet, secondQuest, tardenDialog);

            //Enemy
            Enemy gnoll = new Enemy(10, 10, 10, sword, helmet, firstQuest);
            Enemy goblin = new Enemy(12, 12, 12, axe, helmet, firstQuest);
            Enemy pirate = new Enemy(12, 12, 12, doubleAxe, helmet, firstQuest);

            //Саблокации
            SubLocation townGate = new SubLocation(1, gnoll, jimdjar, new int[]{-1, 2, 3, 4}, "Городские ворота");
            SubLocation tavernOldSych = new SubLocation(2, goblin, tarden, new int[]{-1, -1, -1, 1}, "Таверна старого сыча");
            SubLocation townFountain = new SubLocation(3, pirate, tarden, new int[]{-1, -1, 1, 4}, "Городской фонтан");
            SubLocation chemestry = new SubLocation(4, pirate, tarden, new int[]{-1, -1, 1, 3}, "Церковь");

            //Локации
            Location town = new Location(1, new SubLocation[]{townGate, tavernOldSych, townFountain, chemestry});

            //инвентарь
            ArrayList<ArrayList<Stuff>> mainBackpack = new ArrayList<ArrayList<Stuff>>();
            ArrayList<Stuff> mainBackpackRow1 = new ArrayList<>();
            ArrayList<Stuff> mainBackpackRow2 = new ArrayList<>();
            ArrayList<Stuff> mainBackpackRow3 = new ArrayList<>();
            ArrayList<Stuff> mainBackpackRow4 = new ArrayList<>();
            mainBackpackRow1.add(sword);
            mainBackpackRow2.add(axe);
            mainBackpackRow3.add(helmet);
            mainBackpackRow4.add(doubleAxe);

            mainBackpack.add(mainBackpackRow1);
            mainBackpack.add(mainBackpackRow2);
            mainBackpack.add(mainBackpackRow3);
            mainBackpack.add(mainBackpackRow4);


            System.out.println(sword.getClass().getName());


            Inventory heroInventory = new Inventory(mainBackpack);

            //герой
            Hero hero = new Hero(1, 0, 0, sword, helmet, 10, 10, 10, town, chemestry, heroQuests, heroInventory);
            try {
                MainForm form = new MainForm(hero);
            } catch (IOException e) {
                e.printStackTrace();
            }


        });
    }
}
