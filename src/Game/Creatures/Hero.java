package Game.Creatures;

import Game.ItemStorages.Inventory;
import Game.Map.Location;
import Game.Map.SubLocation;
import Game.Quests.Quest;
import Game.Stuffs.StuffSubs.Equipments.Armor;
import Game.Stuffs.StuffSubs.Equipments.Weapon;

import javax.swing.*;
import java.util.List;
import java.util.Locale;

public class Hero extends Creature {
    private int strength;
    private int agility;
    private int intelligence;
    private Location location;
    private SubLocation subLocation;
    private List<Quest> quests;
    private Inventory playerInventory;

    public Hero(int hitPoints, int manaPoints, int staminaPoints, Weapon weapon, Armor armor, int strength,
                int agility, int intelligence, Location location, SubLocation subLocation, List<Quest> quests,Inventory playerInventory) {
        super(hitPoints, manaPoints, staminaPoints, weapon, armor);
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.location = location;
        this.subLocation = subLocation;
        this.quests = quests;
        this.playerInventory = playerInventory;
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

    public List<Quest> getQuests() {
        return quests;
    }

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }

    public Inventory getPlayerInventory() {
        return playerInventory;
    }

    public void setPlayerInventory(Inventory playerInventory) {
        this.playerInventory = playerInventory;
    }

    public DefaultComboBoxModel<String> avaliableSublocationtsToMove(Hero hero, DefaultComboBoxModel cbModel) {
        //Combobox доступные локации для перемещения, если у локации id некоторого пути !=-1 то добавляем комбобокс, т.е. на эту локацию можно перейти
        String[] description = new String[hero.getSubLocation().getRoots().length];

        for (int i = 0; i < description.length; i++) {

            if (hero.getSubLocation().getRoots()[i] != -1) {
                for (int j = 0; j < hero.getLocation().getSubLocation().length; j++) {
                    if (hero.getLocation().getSubLocation()[j].getId() == hero.getSubLocation().getRoots()[i]) {
                        cbModel.addElement((hero.getLocation().getSubLocation()[j].getDescription()));
                    }
                }
            }

        }

        //заполнение комбобокса

        return cbModel;
    }

    public void toMove(Hero hero, JComboBox subLocationComboBox) {
        for (int i = 0; i < hero.getSubLocation().getRoots().length; i++) {
            if (subLocationComboBox.getSelectedItem().toString().equals(hero.getLocation().getSubLocation()[i].getDescription())) {
                hero.setSubLocation(hero.getLocation().getSubLocation()[i]);
            }
        }
    }

}
