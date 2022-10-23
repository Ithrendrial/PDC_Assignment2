package Assignment1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static Assignment1.GameCui.ANSI_RED;

public class SaveGame {
    
    String s;
    Data data;
    
    public void 
        setData(Data data){
        this.data = data;
    }
    
    public void saveGame() {
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./resources/saveFile.txt"));
            
            for(int i = 0; i < 9; i++)
            {
                bw.write("" + this.data.plants.get(i));
                bw.newLine();
            }
            bw.write("" + this.data.time);
            bw.newLine();
            bw.write("" + this.data.growLight);
            bw.newLine();
            bw.write("" + this.data.fertiliser);
            bw.newLine();
            bw.write("" + this.data.money);
            
            bw.close();
        }
        catch (IOException e) {
            System.out.println(ANSI_RED + "Error reading from file");
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(ANSI_RED + "You have no current Save File");
        }
    }
    
    public void loadGame()
    {       
        this.data.plants.removeAll(this.data.plants);
        
        try
        {
           BufferedReader br = new BufferedReader(new FileReader("./resources/saveFile.txt"));
           
           
           for(int i = 0; i < 9; i++)
           {
               this.data.plants.add(Integer.parseInt(br.readLine()));
           }           
           this.data.time = Integer.parseInt(br.readLine());
           this.data.growLight = Integer.parseInt(br.readLine());
           this.data.fertiliser = Integer.parseInt(br.readLine());
           this.data.money = Integer.parseInt(br.readLine());
           
           br.close();
        }
        catch(NumberFormatException e) {
            System.out.println(ANSI_RED + "You have no current Save File");
            
            for(int i = 0; i < 9; i++){
                this.data.plants.add(0);
            }
        }
        catch (IOException e) {
            System.out.println(ANSI_RED + "Error reading from file");
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(ANSI_RED + "You have no current Save File");
        }
    }
    
    public void resetSave() {
        try
        {
            FileWriter file = new FileWriter("./resources/saveFile.txt");
            BufferedWriter bw = new BufferedWriter(file);
            
            bw.write("");
            bw.close();
        }
        
        catch(FileNotFoundException e)
        {
            System.out.println(ANSI_RED + "You have no current Save File");
        }
        catch (IOException e) {
            System.out.println(ANSI_RED + "Error reading from file");
        }
    }   
    
}
