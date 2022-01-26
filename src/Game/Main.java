package Game;

import Game.Creatures.Hero;

public class Main {

    public static void main(String[] args) {
        Hero hero = new Hero(1, 0, 0, 0, 0, 0);
        MainForm form = new MainForm(hero);

    }
}
