package Game.Creatures;

import Game.Stuffs.StuffSubs.Equipments.Armor;
import Game.Stuffs.StuffSubs.Equipments.Weapon;

public class Creature {
    private int hitPoints;
    private int manaPoints;
    private int staminaPoints;
    private Weapon weapon;
    private Armor armor;

    public Creature(int hitPoints, int manaPoints, int staminaPoints, Weapon weapon, Armor armor) {
        this.hitPoints = hitPoints;
        this.manaPoints = manaPoints;
        this.staminaPoints = staminaPoints;
        this.weapon = weapon;
        this.armor = armor;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    public int getStaminaPoints() {
        return staminaPoints;
    }

    public void setStaminaPoints(int staminaPoints) {
        this.staminaPoints = staminaPoints;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

}
