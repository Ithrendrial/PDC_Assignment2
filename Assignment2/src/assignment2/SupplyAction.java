package assignment2;

public class SupplyAction {

    Inventory userInventory;
    public static final String ANSI_RED = "\u001B[31m";

    //This class is all the supplier related actions that will be called in the GameCUI.
    //These are all the input checks to ensure the program is robust and returns true if the 
    //function was successful.
    public SupplyAction(Inventory inventory) {
        this.userInventory = inventory;
    }

    public boolean buyLight(int numOfLight) {
        if (numOfLight > 0) {
            boolean result = this.userInventory.addLight(numOfLight);
            return result;
        } else {
            System.out.println(ANSI_RED + "Please input a positive number.");
            return false;
        }
    }

    public boolean buyFertiliser(int numOfFertiliser) {
        if(numOfFertiliser > 0) {
            boolean result = this.userInventory.addFertiliser(numOfFertiliser);
            return result;
        }
        else {
            System.out.println(ANSI_RED + "Please input a positive number.");
            return false;
        }
        
    }

    public boolean useLight() {
        if (!userInventory.checkEmpty()) {
            if (this.userInventory.data.growLight > 0) {
                boolean result = this.userInventory.useLight();
                return result;
            } else {
                System.out.println(ANSI_RED + "You do not own enough grow lights to do this.");
                return false;
            }

        } else {
            System.out.println(ANSI_RED + "You have no plants to use the growlight on.");
            return false;
        }
    }

    public boolean useFertiliser() {
        if (!userInventory.checkEmpty()) {
            if (this.userInventory.data.fertiliser > 0) {
                boolean result = this.userInventory.useFertiliser();
                return result;
            } else {
                System.out.println(ANSI_RED + "You do not own enough bags of fertiliser to do this.");
                return false;
            }

        } else {
            System.out.println(ANSI_RED + "You have no plants to use the fertiliser on.");
            return false;
        }
    }
}
