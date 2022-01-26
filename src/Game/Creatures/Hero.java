package Game.Creatures;

import Game.Stuffs.StuffSubs.Equipments.Weapon;

public class Hero {

    private int hitPoints;
    private int manaPoints;
    private int staminaPoints;
    private int strength;
    private int agility;
    private int intelligence;
    private Weapon weapon;

    public Hero(int hitPoints, int manaPoints, int staminaPoints, int strength, int agility, int intelligence, Weapon weapon) {
        this.hitPoints = hitPoints;
        this.manaPoints = manaPoints;
        this.staminaPoints = staminaPoints;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.weapon = weapon;
        
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

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void toAttack() {
        this.hitPoints = this.hitPoints - this.weapon.getDamage();
    }
}
