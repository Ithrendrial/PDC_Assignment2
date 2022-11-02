package assignment2;

/**
 *
 * @author Davis Pike
 */
public class GameData 
{
    boolean loginFlag = false;
    public GameDatabase db;
    
    public GameData()
    {
        GameDatabase db = new GameDatabase();    
        db.dbSetup();
    }
    
    LeaderBoard player = new LeaderBoard();
    int playerSaveFile = player.getSaveFile();
    double playerMoney = player.getMoney();
    int playerPlants = player.getNumOfPlants();
    int playerWeeks = player.getNumOfWeeks();
    int playerGrowLight = player.getNumOfGrowLight();
    int playerFertiliser = player.getNumOfFertiliser();
    
    Plants plant = new Plants();
    int plantId = plant.getPlantId();
    String species = "Monstera Deliciosa";
    double priceWeight = 500;
    int tier1 = 1;
    int tier2 = 2;
    int tier3 = 3;
    int tier4 = 4;
    int tier5 = 5;
    int tier6 = 6;
    int tier7 = 7;
    int tier8 = 8;
    int tier9 = 9;
    int tier10 = 10;
}
