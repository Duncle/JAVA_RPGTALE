package Game.Stuffs;

import javax.swing.*;
import java.io.Serializable;

public abstract class Stuff implements Serializable {
    public int id;
    public String description;
    public int price;
    public ImageIcon texture;


    public Stuff(int id, String description, int price, ImageIcon texture) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.texture = texture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
