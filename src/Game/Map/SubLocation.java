package Game.Map;

import Game.Creatures.Enemy;

public class SubLocation extends Location {
    private Location location;
    String description;
    private Enemy enemy;
    private int roots[] = new int[4];

    public SubLocation(int id, Enemy enemy, int[] roots, String description) {
        super(id);
        this.description = description;
        this.enemy = enemy;
        this.roots = roots;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public int[] getRoots() {
        return roots;
    }

    public void setRoots(int[] roots) {
        this.roots = roots;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
