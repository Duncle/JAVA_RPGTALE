package Game.Map;
import Game.Map.SubLocation;
public class Location {
    private int id = 0;
    private SubLocation[] subLocation;

    public Location(int id, SubLocation[] subLocation) {
        this.id = id;
        this.subLocation = subLocation;
    }

    public Location(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SubLocation[] getSubLocation() {
        return subLocation;
    }

    public void setSubLocation(SubLocation[] subLocation) {
        this.subLocation = subLocation;
    }
}
