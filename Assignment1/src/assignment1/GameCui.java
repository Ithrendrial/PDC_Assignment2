package Assignment1;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameCui {

    PlantAction plantAction;
    SupplyAction supplyAction;
    Inventory inventory;
    SaveGame saveAction;
    Data data;
    Ledger ledger;

    //Text colours
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    //main game
    public GameCui() {
        this.data = new Data();
        this.ledger = new Ledger();
        this.inventory = new Inventory(this.data, this.ledger);
        this.plantAction = new PlantAction(this.inventory);
        this.supplyAction = new SupplyAction(this.inventory);
        this.saveAction = new SaveGame();
        this.saveAction.setData(this.data);
    }

    public void start() throws IOException {
        Scanner scan = new Scanner(System.in);
        boolean running = true;
        char response;
        boolean success;

        System.out.println(ANSI_GREEN + "    |                             ,");
        System.out.println(ANSI_GREEN + "  .'|'.                          /|\\");
        System.out.println(ANSI_GREEN + " / /|\\ \\                        / | \\");
        System.out.println(ANSI_GREEN + "| / | \\ |   " + ANSI_RESET + "The Plant Shop" + ANSI_GREEN + "     / \\|/ \\");
        System.out.println(ANSI_GREEN + " \\ /|\\ /   " + ANSI_RESET + "=================" + ANSI_GREEN + "  | \\ | / |");
        System.out.println(ANSI_GREEN + "  \\ | /                        \\ \\|/ /");
        System.out.println(ANSI_GREEN + "   \\|/                          `.|.`");
        System.out.println(ANSI_GREEN + "    '                             |\n");

        System.out.println(ANSI_GREEN + "Tutorial:\n" + ANSI_GREEN + "~~~~~~~~~");
        System.out.println("In this game you can buy plant stock from a supplier worth $5.");
        System.out.println("Plants will change in value proportionally to how many leaves they");
        System.out.println("have. The max a plant can be worth is $45. \n");

        System.out.println("Every week that passes, there is a 50% chance one of your plants");
        System.out.println("will increase in value by $5. \n");

        System.out.println("If you use a growlight, which can be bought from the supplier,");
        System.out.println("then one of your most valuable plants (excluding those in the");
        System.out.println("$45 tier) will increase in value by $5. The same rules apply to");
        System.out.println("fertiliser, but it will increase the value by $10 and exclude");
        System.out.println("the $40 and $45 tiers.\n");

        System.out.println("If you propagate, one of your most valuable plants will be split");
        System.out.println("into two plants in the previous tier, e.g. one plant worth $45");
        System.out.println("will become two plants each worth $40.\n");
        System.out.println("Happy plant keeping!");

        while (running) {
            System.out.println(ANSI_GREEN + "___________________________________________________________________\n");
            System.out.println(ANSI_GREEN + "Week " + this.data.time + ":\n");

            if(this.plantAction.timePassed()) {
                System.out.println("\nCongrats! One your plants grew a leaf over the week.\n");
            }
            System.out.println("You have $" + this.data.money);

            int value = 5;
            for (int i = 0; i < 9; i++) {
                if (data.plants.get(i) > 0) {
                    System.out.println("You own " + this.data.plants.get(i) + " $" + value + " plant(s).");
                }
                value = value + 5;
            }
            if (this.inventory.checkEmpty()) {
                System.out.println("You own no plants.");
            }

            System.out.println("You have " + this.data.growLight + " growlights and " + this.data.fertiliser + " bags of fertiliser.\n");

            System.out.println("What would you like to do? (Choose one action per week)\n");
            System.out.println("1) Buy one or more plants.");
            System.out.println("2) Sell your most valuable plant.");
            System.out.println("3) Propagate.");
            System.out.println("4) Buy or use growlights.");
            System.out.println("5) Buy or use fertiliser.");
            System.out.println("Press 's' to open save/load options");
            System.out.println("Press 'x' to exit without saving.");

            response = scan.next().charAt(0);

            if (response != 'x') {

                switch (response) {
                    case '1':
                        System.out.println("How many plants do you want to buy?");
                        try {
                            String number = scan.next();

                            try {
                                int num = Integer.parseInt(number);
                                success = this.plantAction.buyPlant(num);
                                if (success) {
                                    inventory.newWeek();
                                }
                            } catch (NumberFormatException e) {
                                if (number.equals("x")) {
                                    System.out.println("Thanks for playing! You finished the game with $" + this.data.money);
                                    System.out.println("\nPrinting ledger...\n");
                                    this.ledger.readLedger();
                                    running = false;
                                } 
                                else {
                                    System.out.println(ANSI_RED + "Invalid input, please try again.\n");
                                }
                            }
                        } 
                        catch (InputMismatchException e) {
                            System.out.println(ANSI_RED + "Invalid input, please try again.\n");
                        }
                        break;

                    case '2':
                        success = this.plantAction.sellPlant();
                        if (success) {
                            inventory.newWeek();
                        }
                        break;

                    case '3':
                        success = this.plantAction.propagate();
                        if (success) {
                            inventory.newWeek();
                        }
                        break;

                    case '4':
                        System.out.println("Do you want to 1)buy or 2)use a grow light?");

                        try {
                            char input = scan.next().charAt(0);

                            switch (input) {
                                case '1':
                                    System.out.println("How many grow lights do you want to buy?");
                                    
                                    try {
                                        String number = scan.next();
                                        
                                        try {
                                            int num = Integer.parseInt(number);
                                            success = this.supplyAction.buyLight(num);
                                            if (success) {
                                                inventory.newWeek();
                                            }
                                        }
                                        catch (NumberFormatException e) {
                                            if(number.equals("x")) {
                                                System.out.println("Thanks for playing! You finished the game with $" + this.data.money);
                                                System.out.println("\nPrinting ledger...\n");
                                                this.ledger.readLedger();
                                                running = false; 
                                            }
                                            else {
                                              System.out.println(ANSI_RED + "Invalid input, please try again.\n");  
                                            }
                                        }
                                    }
                                    catch (InputMismatchException e) {
                                        System.out.println(ANSI_RED + "Invalid input, please try again.\n");
                                    }
                                    
                                    break;

                                case '2':
                                    success = this.supplyAction.useLight();
                                    if (success) {
                                        inventory.newWeek();
                                    }
                                    break;
                                    
                                case 'x':
                                    System.out.println("Thanks for playing! You finished the game with $" + this.data.money);
                                    System.out.println("\nPrinting ledger...\n");
                                    this.ledger.readLedger();
                                    running = false;
                                    break;
                                    
                                default:
                                    System.out.println(ANSI_RED + "Invalid input, please try again.\n" + ANSI_RESET);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println(ANSI_RED + "Invalid input, please try again.\n" + ANSI_RESET);
                        }
                        break;

                    case '5':
                        System.out.println("Do you want to 1)buy or 2)use fertiliser?");

                        try {
                            char input = scan.next().charAt(0);

                            switch (input) {
                                case '1':
                                    System.out.println("How many bags of fertiliser do you want to buy?");
                                    
                                    try {
                                        String number = scan.next();
                                        
                                        try {
                                            int num = Integer.parseInt(number);
                                            success = this.supplyAction.buyFertiliser(num);
                                            if (success) {
                                                inventory.newWeek();
                                            }
                                        }
                                        catch (NumberFormatException e) {
                                            if(number.equals("x")) {
                                                System.out.println("Thanks for playing! You finished the game with $" + this.data.money);
                                                System.out.println("\nPrinting ledger...\n");
                                                this.ledger.readLedger();
                                                running = false; 
                                            }
                                            else {
                                              System.out.println(ANSI_RED + "Invalid input, please try again.\n");  
                                            }
                                        }
                                    }
                                    catch (InputMismatchException e) {
                                        System.out.println(ANSI_RED + "Invalid input, please try again.\n");
                                    }
                                    
                                    break;

                                case '2':
                                    success = this.supplyAction.useFertiliser();
                                    if (success) {
                                        inventory.newWeek();
                                    }
                                    break;
                                    
                                case 'x':
                                    System.out.println("Thanks for playing! You finished the game with $" + this.data.money);
                                    System.out.println("\nPrinting ledger...\n");
                                    this.ledger.readLedger();
                                    running = false;
                                    break;
                                    
                                default:
                                    System.out.println(ANSI_RED + "Invalid input, please try again.\n" + ANSI_RESET);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println(ANSI_RED + "Invalid input, please try again.\n" + ANSI_RESET);
                        }
                        break;

                    case 's':
                        System.out.println("Do you want to:");
                        System.out.println("1)Save game");
                        System.out.println("2)Load a game");
                        System.out.println("3)Reset your save");

                        try {
                            char input = scan.next().charAt(0);

                            switch (input) {
                                case '1':
                                    this.saveAction.saveGame();
                                    break;
                                    
                                case '2':
                                    this.saveAction.loadGame();
                                    break;
                                    
                                case '3':
                                    this.saveAction.resetSave();
                                    break;
                                    
                                case 'x':
                                    System.out.println("Thanks for playing! You finished the game with $" + this.data.money);
                                    System.out.println("\nPrinting ledger...\n");
                                    this.ledger.readLedger();
                                    running = false;
                                    break;

                                default:
                                    System.out.println(ANSI_RED + "Invalid input, please try again.\n");
                                    break;
                            }
                        } 
                        catch (InputMismatchException e) {
                            System.out.println(ANSI_RED + "Invalid input, please try again.\n");
                        }
                        break;

                    default:
                        System.out.println(ANSI_RED + "Invalid input, please try again.\n");
                }
            } else {
                System.out.println("Thanks for playing! You finished the game with $" + this.data.money);
                System.out.println("\nPrinting ledger...\n");
                this.ledger.readLedger();
                running = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        GameCui gameCui = new GameCui();

        gameCui.start();
    }
}
