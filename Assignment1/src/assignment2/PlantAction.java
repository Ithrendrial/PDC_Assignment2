package assignment2;

public class PlantAction {
    
    Inventory userInventory;
    public static final String ANSI_RED = "\u001B[31m";
    
    //This class is all the plant related actions that will be called in the GameCUI
    //These are all the input checks to ensure the program is robust and returns true if the 
    //function was successful.
    
    public PlantAction(Inventory inventory){
        userInventory = inventory;
    }
    
    public boolean buyPlant(int numberOfPlants) {
        if(numberOfPlants > 0) {
            boolean result = this.userInventory.buyPlant(numberOfPlants);
            return result;
            
        }
        else {
            System.out.println(ANSI_RED + "Please input a positive number.");
            return false;
        }
    }
    
    public boolean sellPlant() {
        if(!userInventory.checkEmpty()) {
            boolean result = this.userInventory.sellPlant();
            return result;
        }
        else {
            System.out.println(ANSI_RED + "You do not own any plants to sell.");
            return false;
        }
    }
    
    public boolean propagate() {
        if(!userInventory.checkEmpty()) {
            boolean result = this.userInventory.propagate();
            return result;
        }
        else {
            System.out.println(ANSI_RED + "You do not own any plants to propagate.");
            return false;
        }
    }
    
    public boolean timePassed(){
        boolean result = this.userInventory.timePassed();
        return result;
    }
}
