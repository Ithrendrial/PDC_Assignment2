package Assignment1;

import static Assignment1.GameCui.ANSI_RED;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ledger {

    private List<Integer> ledger = new ArrayList<>();
    private int transactions = 0;
    private int total = 0;

    //Adds purchase or sale to ledger
    public void transaction(int t) {
        ledger.add(t);
        transactions++;
        if (transactions == 4) {
            this.addToLedger();
        }
    }

    private void addToLedger() {
        for (int i = 0; i < ledger.size(); i++) {
            total = total + ledger.get(i);
        }

        try {
            FileWriter file = new FileWriter("./resources/ledger.txt", true);
            BufferedWriter bw = new BufferedWriter(file);

            bw.write(String.valueOf(total));
            bw.newLine();
            bw.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println(ANSI_RED + "File not found.");
        } 
        catch (IOException e) {
            System.out.println(ANSI_RED + "Error reading from file");
        }

        this.total = 0;
        this.ledger.clear();
        this.transactions = 0;
    }

    private void clearLedger() {
        try {
            FileWriter file = new FileWriter("./resources/ledger.txt");
            BufferedWriter bw = new BufferedWriter(file);

            bw.write("");
            bw.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(ANSI_RED + "File not found.");
        } 
        catch (IOException e) {
            System.out.println(ANSI_RED + "Error reading from file");
        }
        

    }

    public void readLedger() {
        try {
            
            FileReader file = new FileReader("./resources/ledger.txt");
            BufferedReader br = new BufferedReader(file);
            String line;
            Boolean fileEmpty = true;
            int month = 1;
            int netValue = 0;

            System.out.println("Ledger: Each line represents monthly cash flow");
            while ((line = br.readLine()) != null) {
                System.out.println("Month " + month + ": $" + line);
                month++;
                netValue = netValue + Integer.parseInt(line);
                fileEmpty = false;
            }
            br.close();
            clearLedger();
            
            if(fileEmpty) System.out.println(ANSI_RED + "First month incomplete. No Records.");
            
            if (netValue > 0) {
                System.out.println("\nYou made a profit!");
            } 
            else if (netValue < 0) {
                System.out.println("\nYou made a loss :(");
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println(ANSI_RED + "File not found.");
        } 
        catch (IOException e) {
            System.out.println(ANSI_RED + "Error reading from file");
        }
    }
}
