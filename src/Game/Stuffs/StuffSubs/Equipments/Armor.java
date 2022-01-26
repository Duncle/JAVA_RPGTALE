package Game.Stuffs.StuffSubs.Equipments;

import Game.Stuffs.StuffSubs.Equipment;

public class Armor extends Equipment {
    private int armorClass;
    private int armorType;

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }
}