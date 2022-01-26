package Game.Creatures;

public class Hero {

    private int hitPoints;
    private int manaPoints;
    private int staminaPoints;
    private int strength;
    private int agility;
    private int intelligence;

    public Hero(int HitPoints, int ManaPoints, int StaminaPoints, int Strength, int Agility, int Intelligence) {
        hitPoints = HitPoints;
        manaPoints = ManaPoints;
        staminaPoints = StaminaPoints;
        strength = Strength;
        agility = Agility;
        intelligence = Intelligence;
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

    }
}
