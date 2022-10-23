package assignment2;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public int time = 0; //Time starts at week 0
    public int growLight = 0;
    public int fertiliser = 0;
    public int money = 100;
    
    public List<Integer> plants;
    //Plant value tiers 0 to 8 
    // 0 = 5$ , 1 = 10$ , 2 = 15$ , 3 = 20$ , 4 = 25$ , 5 = 30$ , 6 = 35$ , 7 =40$ , 8 = 45$
    
    public Data(){
        plants = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            plants.add(0);
        }
    }
    
    public void testGit() {
        System.out.println("This is me testing git");
    }
    
    public void davisIsCool()
    {
        System.out.println("Rachel is cool but not PB");
    }
}
