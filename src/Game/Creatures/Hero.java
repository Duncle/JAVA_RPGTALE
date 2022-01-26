package Game.Creatures;

import Game.Stuffs.StuffSubs.Equipments.Armor;
import Game.Stuffs.StuffSubs.Equipments.Weapon;

public class Hero extends Creature {
    private int strength;
    private int agility;
    private int intelligence;


    public Hero(int hitPoints, int manaPoints, int staminaPoints, int intelligence, int strength, int agility, Weapon weapon, Armor armor) {
        super(hitPoints, manaPoints, staminaPoints, weapon, armor);
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;


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
        this.setHitPoints(this.getHitPoints()-this.getWeapon().getDamage());
    }
}
