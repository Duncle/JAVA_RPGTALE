package Game.Stuffs.StuffSubs.Equipments;

import Game.Stuffs.StuffSubs.Equipment;

public class Armor extends Equipment {
    private int armorClass;
    private String armorType;

    public Armor(int id, int price, int durability, int armorClass, String armorType) {
        this.id = id;
        this.price = price;
        this.durability = durability;
        this.armorClass = armorClass;
        this.armorType = armorType;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public String getArmorType() {
        return armorType;
    }

    public void setArmorType(String armorType) {
        this.armorType = armorType;
    }
}