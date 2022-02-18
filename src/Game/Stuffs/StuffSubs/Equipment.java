package Game.Stuffs.StuffSubs;

import Game.Stuffs.Stuff;

import javax.swing.*;

public class Equipment extends Stuff {
    public int durability;


    public Equipment(int id, String description, int price, ImageIcon texture, int durability) {
        super(id, description, price, texture);
        this.durability = durability;
    }

    public void toRepair(int durability) {

    }
    public void toBreak(int durability) {

    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}
