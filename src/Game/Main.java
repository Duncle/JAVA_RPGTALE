package Game;

import Game.Actions.Dialog;
import Game.Creatures.Enemy;
import Game.Creatures.Hero;
import Game.Creatures.NPC;
import Game.Map.Location;
import Game.Map.SubLocation;
import Game.Quests.Quest;
import Game.Stuffs.StuffSubs.Equipments.Armor;
import Game.Stuffs.StuffSubs.Equipments.Weapon;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        Weapon sword = new Weapon(1, 100, 10, 5, 0);
        Weapon rustySword = new Weapon(2, 50, 3, 2, 0);
        Weapon diamondSword = new Weapon(3, 50, 3, 20, 0);
        Armor ironPlate = new Armor(1, 1000, 50, 2, "Chestplate");

        Quest firstQuest = new Quest(1, "InProgress", "First quest");
        String[][] dialogForTarden = new String[][]{{"1", "2"}, {"2"}};
        Dialog tardenDialog = new Dialog(dialogForTarden);
        NPC tarden = new NPC("Тарден",32, 15, 24, sword, ironPlate, firstQuest, tardenDialog);

        Enemy gnoll = new Enemy(10, 10, 10, sword, ironPlate, firstQuest);
        Enemy goblin = new Enemy(12, 12, 12, rustySword, ironPlate, firstQuest);
        Enemy pirate = new Enemy(12, 12, 12, diamondSword, ironPlate, firstQuest);

        SubLocation townGate = new SubLocation(1, gnoll,tarden, new int[]{-1, 2, 3, 4}, "Городские ворота");
        SubLocation tavernOldSych = new SubLocation(2, goblin,tarden, new int[]{-1, -1, -1, 1}, "Таверна старого сыча");
        SubLocation townFountain = new SubLocation(3, pirate,tarden, new int[]{-1, -1, 1, 4}, "Городской фонтан");
        SubLocation chemestry = new SubLocation(4, pirate,tarden, new int[]{-1, -1, 1, 3}, "Церковь");

        Location town = new Location(1, new SubLocation[]{townGate, tavernOldSych, townFountain, chemestry});

        Hero hero = new Hero(1, 0, 0, 0, 0, 0, sword, ironPlate, town, chemestry);
        MainForm form = new MainForm(hero);
        /*
        GUI_Test app = new GUI_Test();
        app.setVisible(true);
        */

    }
}
