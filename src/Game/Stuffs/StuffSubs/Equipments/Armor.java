package Game.Stuffs.StuffSubs.Equipments;

import Game.Stuffs.StuffSubs.Equipment;

import javax.swing.*;

public class Armor extends Equipment {
    private int armorClass;
    private String armorType;


    public Armor(int id, String description, int price, ImageIcon texture, int durability, int armorClass, String armorType) {
        super(id, description, price, texture, durability);
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