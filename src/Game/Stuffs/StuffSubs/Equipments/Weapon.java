package Game.Stuffs.StuffSubs.Equipments;

import Game.Stuffs.StuffSubs.Equipment;

import javax.swing.*;

public class Weapon extends Equipment {
    private int damage;
    private int staminaRequirement;


    public Weapon(int id, String description, int price, ImageIcon texture, int durability, int damage, int staminaRequirement) {
        super(id, description, price, texture, durability);
        this.damage = damage;
        this.staminaRequirement = staminaRequirement;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getStaminaRequirement() {
        return staminaRequirement;
    }

    public void setStaminaRequirement(int staminaRequirement) {
        this.staminaRequirement = staminaRequirement;
    }
}
