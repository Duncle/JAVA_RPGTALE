package Game;

import Game.Actions.Dialog;
import Game.Creatures.Enemy;
import Game.Creatures.Hero;
import Game.Creatures.NPC;
import Game.Map.Location;
import Game.Map.SubLocation;
import Game.Quests.Quest;
import Game.Stuffs.StuffSubs.Equipments.Armor;
import Game.Stuffs.StuffSubs.Equipments.Weapon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {


        Weapon sword = new Weapon(1, 100, 10, 5, 0);
        Weapon rustySword = new Weapon(2, 50, 3, 2, 0);
        Weapon diamondSword = new Weapon(3, 50, 3, 20, 0);
        
        Armor ironPlate = new Armor(1, 1000, 50, 2, "Chestplate");

        List<Quest> heroQuests = new ArrayList<>();
        
        Quest firstQuest = new Quest(1, "InProgress", "First quest");
        Quest secondQuest = new Quest(2, "InProgress", "second quest");

        LinkedHashMap<String,Object> dialogForTarden = new LinkedHashMap<>();
        dialogForTarden.put("Привет", "Здравствуй");
        dialogForTarden.put("Что ты продаешь", "Ничего");
        dialogForTarden.put("Есть задание для меня", firstQuest);
        Dialog tardenDialog = new Dialog(dialogForTarden);

        LinkedHashMap<String,Object> dialogForJimdjar = new LinkedHashMap<>();
        dialogForJimdjar.put("Привествую", "Здравствуй");
        dialogForJimdjar.put("Где здесь можно выпить", "В таверне старый сыч");
        dialogForJimdjar.put("Есть задание для меня?", secondQuest);

        Dialog tardenJimdjar = new Dialog(dialogForJimdjar);

        NPC tarden = new NPC("Тарден", 32, 15, 24, sword, ironPlate, firstQuest, tardenDialog);
        NPC jimdjar = new NPC("Джимджар", 27, 2, 15, rustySword, ironPlate, secondQuest, tardenJimdjar);

        Enemy gnoll = new Enemy(10, 10, 10, sword, ironPlate, firstQuest);
        Enemy goblin = new Enemy(12, 12, 12, rustySword, ironPlate, firstQuest);
        Enemy pirate = new Enemy(12, 12, 12, diamondSword, ironPlate, firstQuest);

        SubLocation townGate = new SubLocation(1, gnoll, jimdjar, new int[]{-1, 2, 3, 4}, "Городские ворота");
        SubLocation tavernOldSych = new SubLocation(2, goblin, tarden, new int[]{-1, -1, -1, 1}, "Таверна старого сыча");
        SubLocation townFountain = new SubLocation(3, pirate, tarden, new int[]{-1, -1, 1, 4}, "Городской фонтан");
        SubLocation chemestry = new SubLocation(4, pirate, tarden, new int[]{-1, -1, 1, 3}, "Церковь");

        Location town = new Location(1, new SubLocation[]{townGate, tavernOldSych, townFountain, chemestry});

        Hero hero = new Hero(1, 0, 0,  sword, ironPlate, 10, 10, 10, town, chemestry,heroQuests);
        MainForm form = new MainForm(hero);


    }
}
