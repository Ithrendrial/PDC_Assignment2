package assignment2;

import java.util.List;

/**
 *
 * @author Davis Pike
 */
public class GameData {

    public GameDatabase dataBase;

    public GameData() {
        currentWeek = 0;
        money = 100;
    }

    //leader board entry
    LeaderBoard leaderBoard = new LeaderBoard();
    List<Integer> score = leaderBoard.score;
    List<String> name = leaderBoard.name;

    //items inventory
    Items defaultItemsNo = new Items();
    int growLight = defaultItemsNo.growLight;
    int fertiliser = defaultItemsNo.fertiliser;
    
    //default plantTier
    Plants plantTier = new Plants();
    
    //weekly
    int currentWeek;
    
    //starting money
    int money;
    
    //plant1 inventory entry
    String name1 = "Variegated Monstera";
    int price1 = 500;
    int tier1One = plantTier.defaultTier;
    int tier2One = plantTier.defaultTier;
    int tier3One = plantTier.defaultTier;
    int tier4One = plantTier.defaultTier;
    int tier5One = plantTier.defaultTier;
    
    //plant2 inventory entry
    String name2 = "Adiantum Fragrans";
    int price2 = 10;
    int tier1Two = plantTier.defaultTier;
    int tier2Two = plantTier.defaultTier;
    int tier3Two = plantTier.defaultTier;
    int tier4Two = plantTier.defaultTier;
    int tier5Two = plantTier.defaultTier;
    
    //plant3 inventory entry
    String name3 = "Alocasia Azlanii";
    int price3 = 300;
    int tier1Three = plantTier.defaultTier;
    int tier2Three = plantTier.defaultTier;
    int tier3Three = plantTier.defaultTier;
    int tier4Three = plantTier.defaultTier;
    int tier5Three = plantTier.defaultTier;
    
    //plant4 inventory entry
    String name4 = "Dracaena Trifasciata";
    int price4 = 5;
    int tier1Four = plantTier.defaultTier;
    int tier2Four = plantTier.defaultTier;
    int tier3Four = plantTier.defaultTier;
    int tier4Four = plantTier.defaultTier;
    int tier5Four = plantTier.defaultTier;
    
    //plant5 inventory entry
    String name5 = "Calathea Leitzei";
    int price5 = 100;
    int tier1Five = plantTier.defaultTier;
    int tier2Five = plantTier.defaultTier;
    int tier3Five = plantTier.defaultTier;
    int tier4Five = plantTier.defaultTier;
    int tier5Five = plantTier.defaultTier;
}
