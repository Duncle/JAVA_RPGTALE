package Game.Creatures;

import Game.Quests.Quest;
import Game.Stuffs.StuffSubs.Equipments.Armor;
import Game.Stuffs.StuffSubs.Equipments.Weapon;

public class NPC extends Creature {
private Quest quest;
    public NPC(int hitPoints, int manaPoints, int staminaPoints, Weapon weapon, Armor armor,Quest quest) {
        super(hitPoints, manaPoints, staminaPoints, weapon, armor);
        this.quest=quest;
    }
}
