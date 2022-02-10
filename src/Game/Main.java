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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Inventory playerInventory = new Inventory();
        Weapon sword = new Weapon(1, 100, 10, 5, 0);
        Weapon rustySword = new Weapon(2, 50, 3, 2, 0);
        Weapon diamondSword = new Weapon(3, 50, 3, 20, 0);

        Armor ironPlate = new Armor(1, 1000, 50, 2, "Chestplate");

        List<Quest> heroQuests = new ArrayList<>();

        Quest firstQuest = new Quest(1, "InProgress", "First quest");
        Quest secondQuest = new Quest(2, "InProgress", "second quest");

        Node tardenDialogNode1_2_1_1 = new Node(6, "а я слышал что...", "мда...");

        Node tardenDialogNode1_2_1 = new Node(4, "почему", "я не торговец",  Arrays.asList(tardenDialogNode1_2_1_1));
        Node tardenDialogNode1_2_2 = new Node(5, "Где найти торговца", "на площади");

        Node tardenDialogNode1_1 = new Node(1, "Здравствуй", "Привет");
        Node tardenDialogNode1_2 = new Node(2, "Что ты продаешь", "ничего", Arrays.asList(tardenDialogNode1_2_1, tardenDialogNode1_2_2));
        Node tardenDialogNode1_3 = new Node(3, "Пока", "Я пошел");

        Node tardenDialogRootNode = new Node(0, "Подойти к дракону", "Кто тут", Arrays.asList(tardenDialogNode1_1, tardenDialogNode1_2, tardenDialogNode1_3));


        Dialog tardenDialog = new Dialog(tardenDialogRootNode);


//        Dialog  JimdjarDialog = new Dialog(dialogForJimdjar);

        NPC tarden = new NPC("Тарден", 32, 15, 24, sword, ironPlate, firstQuest, tardenDialog);
        NPC jimdjar = new NPC("Джимджар", 27, 2, 15, rustySword, ironPlate, secondQuest, tardenDialog);

        Enemy gnoll = new Enemy(10, 10, 10, sword, ironPlate, firstQuest);
        Enemy goblin = new Enemy(12, 12, 12, rustySword, ironPlate, firstQuest);
        Enemy pirate = new Enemy(12, 12, 12, diamondSword, ironPlate, firstQuest);

        SubLocation townGate = new SubLocation(1, gnoll, jimdjar, new int[]{-1, 2, 3, 4}, "Городские ворота");
        SubLocation tavernOldSych = new SubLocation(2, goblin, tarden, new int[]{-1, -1, -1, 1}, "Таверна старого сыча");
        SubLocation townFountain = new SubLocation(3, pirate, tarden, new int[]{-1, -1, 1, 4}, "Городской фонтан");
        SubLocation chemestry = new SubLocation(4, pirate, tarden, new int[]{-1, -1, 1, 3}, "Церковь");

        Location town = new Location(1, new SubLocation[]{townGate, tavernOldSych, townFountain, chemestry});

        Hero hero = new Hero(1, 0, 0, sword, ironPlate, 10, 10, 10, town, chemestry, heroQuests,playerInventory);
        MainForm form = new MainForm(hero);


    }
}
