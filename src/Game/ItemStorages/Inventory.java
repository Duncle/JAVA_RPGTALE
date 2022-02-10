package Game.ItemStorages;

import Game.Stuffs.Stuff;

import java.util.List;

public class Inventory {
    private List<Stuff> items;

    public List<Stuff> getItems() {
        return items;
    }

    public void setItems(List<Stuff> items) {
        this.items = items;
    }
}
