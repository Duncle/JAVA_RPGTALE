package Game.Creatures;

import Game.Quests.Quest;
import Game.Stuffs.StuffSubs.Equipments.Armor;
import Game.Stuffs.StuffSubs.Equipments.Weapon;

public class Enemy extends Creature {
    public Enemy(int hitPoints, int manaPoints, int staminaPoints, Weapon weapon, Armor armor, Quest quest) {
                super(hitPoints, manaPoints, staminaPoints, weapon, armor);

    }
}
