package Game.Stuffs.StuffSubs;

import Game.Stuffs.Stuff;

public class Equipment extends Stuff {
    public int durability;
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
