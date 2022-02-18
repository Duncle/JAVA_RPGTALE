package Game.ItemStorages;

import Game.Stuffs.Stuff;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    ArrayList<ArrayList<Stuff>> mainBackpack = new ArrayList<ArrayList<Stuff>>( );


    public Inventory(ArrayList<ArrayList<Stuff>> mainBackpack) {

        this.mainBackpack = mainBackpack;
    }

    public ArrayList<ArrayList<Stuff>> getMainBackpack() {
        return mainBackpack;
    }

    public void setMainBackpack(ArrayList<ArrayList<Stuff>> mainBackpack) {
        this.mainBackpack = mainBackpack;
    }
}
