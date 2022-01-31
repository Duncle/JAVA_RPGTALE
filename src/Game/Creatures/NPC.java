package Game.Creatures;

import Game.Actions.Dialog;
import Game.Quests.Quest;
import Game.Stuffs.StuffSubs.Equipments.Armor;
import Game.Stuffs.StuffSubs.Equipments.Weapon;

public class NPC extends Creature {
    private String name;
    private Quest quest;
    private Dialog dialog;

    public NPC(String name, int hitPoints, int manaPoints, int staminaPoints, Weapon weapon, Armor armor, Quest quest, Dialog dialog) {
        super(hitPoints, manaPoints, staminaPoints, weapon, armor);
        this.name=name;
        this.quest = quest;
        this.dialog = dialog;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public Dialog getDialog() {
        return dialog;
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
