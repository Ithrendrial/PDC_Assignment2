package assignment2;

/**
 *
 * @author Davis
 */
public class LeaderBoard 
{
    int saveFile;
    double money;
    int numOfPlants;
    int numOfWeeks;
    int numOfGrowLight;
    int numOfFertiliser;
    
    public LeaderBoard()
    {
        saveFile = 0;
        money = 100.00;
        numOfPlants = 0;
        numOfWeeks = 0;
        numOfGrowLight = 0;
        numOfFertiliser = 0;
    }

    public int getSaveFile() {
        return saveFile;
    }

    public double getMoney() {
        return money;
    }

    public int getNumOfPlants() {
        return numOfPlants;
    }

    public int getNumOfWeeks() {
        return numOfWeeks;
    }

    public int getNumOfGrowLight() {
        return numOfGrowLight;
    }

    public int getNumOfFertiliser() {
        return numOfFertiliser;
    }
}
