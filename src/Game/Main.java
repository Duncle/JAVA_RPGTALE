package Game;

import Game.Creatures.Hero;
import Game.Stuffs.StuffSubs.Equipments.Weapon;

public class Main {

    public static void main(String[] args) {

        Weapon sword = new Weapon(1,100,10,5,0);
        Hero hero = new Hero(1, 0, 0, 0, 0, 0,sword);

        MainForm form = new MainForm(hero);

    }
}
