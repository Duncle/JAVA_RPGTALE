package Game.Actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dialog extends Action {
    HashMap<String, Object> dialogues = new HashMap<>();

    public Dialog(HashMap<String, Object> dialogues) {
        this.dialogues = dialogues;
    }

    public HashMap<String, Object> getDialogues() {
        return dialogues;
    }

    public void setDialogues(HashMap<String, Object> dialogues) {
        this.dialogues = dialogues;
    }
}
