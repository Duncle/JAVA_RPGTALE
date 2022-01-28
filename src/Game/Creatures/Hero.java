package Game.Creatures;

import Game.Map.Location;
import Game.Map.SubLocation;
import Game.Stuffs.StuffSubs.Equipments.Armor;
import Game.Stuffs.StuffSubs.Equipments.Weapon;

import java.util.Locale;

public class Hero extends Creature {
    private int strength;
    private int agility;
    private int intelligence;
    private Location location;
    private SubLocation subLocation;

    public Hero(int hitPoints, int manaPoints, int staminaPoints, int intelligence, int strength, int agility, Weapon weapon, Armor armor, Location location, SubLocation subLocation) {
        super(hitPoints, manaPoints, staminaPoints, weapon, armor);
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.location = location;
        this.subLocation = subLocation;
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
        this.setHitPoints(this.getHitPoints() - this.subLocation.getEnemy().getWeapon().getDamage());
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public SubLocation getSubLocation() {
        return subLocation;
    }

    public void setSubLocation(SubLocation subLocation) {
        this.subLocation = subLocation;
    }

}
