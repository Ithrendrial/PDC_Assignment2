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
}