package Game.Stuffs.StuffSubs.Equipments;

import Game.Stuffs.StuffSubs.Equipment;

public class Weapon extends Equipment {
    private int damage;
    private int staminaRequirement;
    public Weapon(int id, int price, int durability, int damage, int staminaRequirement) {
        this.id = id;
        this.price = price;
        this.durability = durability;
        this.damage = damage;
        this.staminaRequirement = staminaRequirement;
    }
}
