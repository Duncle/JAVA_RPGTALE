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

        Armor ironPlate = new Armor();
        Quest quest = new Quest();
        Enemy Gnoll = new Enemy(10, 10, 10, sword, ironPlate, quest);
        Enemy Goblin = new Enemy(12, 12, 12, rustySword, ironPlate, quest);

        SubLocation townGate = new SubLocation(1, Gnoll, new int[]{-1, -1, 2, 3}, "Городские ворота");
        SubLocation tavernOldSych = new SubLocation(2, Goblin, new int[]{-1, -1, 1, 2}, "Таверна старого сыча");
        SubLocation townFountain = new SubLocation(3, Goblin, new int[]{-1, -1, 2, 3}, "Городской фонтан");

        Location town = new Location(1, new SubLocation[]{townGate, tavernOldSych, townFountain});

        Hero hero = new Hero(1, 0, 0, 0, 0, 0, sword, ironPlate, town, townGate);
        MainForm form = new MainForm(hero);

    }
}
