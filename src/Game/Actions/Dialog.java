package Game.Actions;

import java.util.HashMap;

public class Dialog extends Action {

    String dialogues[][];

    public Dialog(String[][] dialogues) {
        this.dialogues = dialogues;
    }

    public String[][] getDialogues() {
        return dialogues;
    }

    public void setDialogues(String[][] dialogues) {
        this.dialogues = dialogues;
    }
}
