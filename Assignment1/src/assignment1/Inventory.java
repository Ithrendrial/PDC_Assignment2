package Assignment1;

import static Assignment1.GameCui.ANSI_RED;
import java.util.Random;

public class Inventory {
    
    Data data;
    Ledger ledger;
    
    public Inventory(Data data, Ledger ledger){
        this.data = data;
        this.ledger = ledger;
    }
    
    //Increases the week by one
    public void newWeek() {
        this.data.time++;
    }
    
    //Checks if the player owns no plants
    public boolean checkEmpty() {
        for(int i = 0; i < 9; i++)
        {
            if(data.plants.get(i) > 0) return false; //check if the player owns no plants to increase
        }
        return true;
    }
    
    //Function to increase timePassed when a new week starts
    //and to increase the tier of a random plant 50% of the time
    public boolean timePassed(){
        
        Random rand = new Random();
        int randPlant = rand.nextInt(9);
        
        if(checkEmpty() == false && rand.nextBoolean() == true){
            while (true){
                if(data.plants.get(randPlant) > 0) {
                    data.plants.set(randPlant, (data.plants.get(randPlant) - 1));
                    data.plants.set((randPlant + 1), data.plants.get(randPlant + 1) + 1);
                    return true;  //returns if successful plant value increase
                }
                else {
                    randPlant = rand.nextInt(9); //if the randomly picked tier is empty, generate a new tier
                }
            }
        }
        return false; //No plant's value increased
    }
    
    //Function to take the user's highest tier plant and reduce it to two plants in the previous tier
    public boolean propagate(){
        for(int i = 8; i > 0; i--){
            if(data.plants.get(i)> 0){
                data.plants.set(i, (data.plants.get(i) - 1));
                data.plants.set((i - 1), data.plants.get(i - 1) + 2);
                return true; //Returns true if propagation was successful
            }
        } 
        return false;  //Returns false if the user has no plants to propagate
    }
    
    //Player buys n number of lights from supplier
    public boolean addLight(int numberOfLight){
        if(this.data.money >= numberOfLight*10){
            this.data.growLight = this.data.growLight + numberOfLight;
            this.removeMoney((numberOfLight*10));
            this.ledger.transaction(-(numberOfLight*10));
            return true;
        } 
        else {
            System.out.println(ANSI_RED + "You do not have enough money to do this.");
            return false;
        }
    }
    
    //Player buys n number of fertilier bags from supplier
    public boolean addFertiliser(int numberOfFertiliser){ 
        if(this.data.money >= numberOfFertiliser*15){
            this.data.fertiliser = this.data.fertiliser + numberOfFertiliser;
            this.removeMoney((numberOfFertiliser*15));
            this.ledger.transaction(-(numberOfFertiliser*15));
            return true;
        } 
        else {
            System.out.println(ANSI_RED + "You do not have enough money to do this.");
            return false;
        }
    }
    
    //Money increases by n
    public void addMoney(int money){
        this.data.money = this.data.money + money;
    }
    
    //Money decreases by n
    public void removeMoney(int money){
        this.data.money = this.data.money - money;
    }
    
    //Player buys n lowest tier plants from supplier
    public boolean buyPlant(int numberOfPlant){
        if(this.data.money >= numberOfPlant*5){
            this.data.plants.set(0, (this.data.plants.get(0) + numberOfPlant));
            this.removeMoney((numberOfPlant*5));
            this.ledger.transaction(-(numberOfPlant*5));
            return true;
        } 
        else {
            System.out.println(ANSI_RED + "You do not have enough money to do this.");
            return false;
        }
    }
    
    //Player sells their most valuable plant
    public boolean sellPlant(){
        for(int i = 8; i > -1; i--){
            if(this.data.plants.get(i)> 0){
                this.data.plants.set(i, (this.data.plants.get(i) - 1));
                this.addMoney((i+1)*5);
                this.ledger.transaction((i+1)*5);
                return true;
            }
        } 
        return false;
    }
    
    //Player increases their most valuable plant by 1 tier (excluding tier 9 plants)
    public boolean useLight(){
        for(int i = 7; i > -1; i--){
            if(this.data.plants.get(i)> 0){
                this.data.plants.set(i, (this.data.plants.get(i) - 1));
                this.data.plants.set((i + 1), this.data.plants.get(i + 1) + 1);
                this.data.growLight--;
                return true;
            }
        } 
        return false;
    }
    
    //Player increases their most valuable plant by 2 tiers (exclusing tier 8 and 9 plants)
    public boolean useFertiliser(){
        for(int i = 6; i > -1; i--){
            if(this.data.plants.get(i)> 0){
                this.data.plants.set(i, (this.data.plants.get(i) - 1));
                this.data.plants.set((i + 2), this.data.plants.get(i + 2) + 1);
                this.data.fertiliser--;
                return true;
            }
        } 
        return false;
    }
}
