package Game;

import Game.Creatures.Enemy;
import Game.Creatures.Hero;
import Game.Map.Location;
import Game.Map.SubLocation;
import Game.Quests.Quest;
import Game.Stuffs.StuffSubs.Equipments.Armor;
import Game.Stuffs.StuffSubs.Equipments.Weapon;

public class Main {

    public static void main(String[] args) {


        Weapon sword = new Weapon(1, 100, 10, 5, 0);
        Weapon rustySword = new Weapon(2, 50, 3, 2, 0);
        Weapon diamondSword = new Weapon(3, 50, 3, 20, 0);
        Armor ironPlate = new Armor(1, 1000, 50, 2, "Chestplate");

        Quest quest = new Quest(1, "InProgress", "FirstQuest");

        Enemy gnoll = new Enemy(10, 10, 10, sword, ironPlate, quest);
        Enemy goblin = new Enemy(12, 12, 12, rustySword, ironPlate, quest);
        Enemy pirate = new Enemy(12, 12, 12, diamondSword, ironPlate, quest);

        SubLocation townGate = new SubLocation(1, gnoll, new int[]      {-1, 2, 3, 4}, "Городские ворота");
        SubLocation tavernOldSych = new SubLocation(2, goblin, new int[]{-1, -1, -1, 1}, "Таверна старого сыча");
        SubLocation townFountain = new SubLocation(3, pirate, new int[] {-1, -1, 1, 4}, "Городской фонтан");
        SubLocation chemestry = new SubLocation(4, pirate, new int[]    {-1, -1, 1, 3}, "Церковь");

        Location town = new Location(1, new SubLocation[]{townGate, tavernOldSych, townFountain, chemestry});

        Hero hero = new Hero(1, 0, 0, 0, 0, 0, sword, ironPlate, town, chemestry);
        MainForm form = new MainForm(hero);

    }
}
