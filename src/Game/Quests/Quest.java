package Game.Quests;

public class Quest {
    private int id;
    private String state;
    private String questDescription;

    public Quest(int id, String state, String questDescription) {
        this.id = id;
        this.state = state;
        this.questDescription = questDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getQuestDescription() {
        return questDescription;
    }

    public void setQuestDescription(String questDescription) {
        this.questDescription = questDescription;
    }
}
