package assignment2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Davis Pike
 */
public class GameDatabase 
{
    Connection conn = null;
    String url = "jdbc:derby:ThePlantShop;create=true";
    String USER_NAME = "pdc";
    String PASSWORD = "pdc";
    
    public void dbSetup()
    {
        try
        {
            conn = DriverManager.getConnection(url, USER_NAME, PASSWORD);
            Statement statement = conn.createStatement();
            String tableName = "Plants";
            if(!checkTable(tableName))
            {
                statement.executeUpdate("CREATE TABLE" + tableName + " (PLAND_ID INTEGER NOT NULL, SPECIES CHAR(100) NOT NULL, PRICEWEIGHT INTEGER NOT NULL, TIER1 INTEGER NOT NULL, TIER2 INTEGER NOT NULL, TIER3 INTEGER NOT NULL, TIER4 INTEGER NOT NULL, TIER5 INTEGER NOT NULL, TIER6 INTEGER NOT NULL, TIER7 INTEGER NOT NULL, TIER8 INTEGER NOT NULL, TIER9 INTEGER NOT NULL, TIER10 INTEGER NOT NULL, PRIMARY KEY (PLAND_ID)");
            }
            statement.close();
        }
        
        catch(Throwable e)
        {
            System.out.println("Error -Please ensure that the Derby Jars are in Libraries.");
        }
        
        try
        {
            conn = DriverManager.getConnection(url, USER_NAME, PASSWORD);
            Statement statement = conn.createStatement();
            String tableName = "LeaderBoard";
            if(!checkTable(tableName))
            {
                statement.executeUpdate("CREATE TABLE" + tableName + " (SAVE_FILE INTEGER NOT NULL, NUM_OF_PLANTS INTEGER NOT NULL, NUM_OF_WEEKS INTEGER NOT NULL, NUM_OF_GROWLIGHT INTEGER NOT NULL, NUM_OF_FERTILISER INTEGER NOT NULL, MONEY DOUBLE NOT NULL, PRIMARY KEY (SAVE_FILE)");
            }
            statement.close();
        }
        
        catch(Throwable e)
        {
            System.out.println("Error -Please ensure that the Derby Jars are in Libraries.");
        }
    }
    
    public GameData checkPlayer(String username, String password)
    {
        GameData data = new GameData();
        try
        {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM LeaderBoard " + "WHERE saveFile = '" + username + "'");
            if(rs.next())
            {
                String pass = rs.getString("password");
                System.out.println("***" + pass);
                System.out.println("found user");
                
                if(password.compareTo(pass) == 0)
                {
                    data.playerMoney = rs.getInt("money");
                    data.playerPlants = rs.getInt("plants");
                    data.playerWeeks = rs.getInt("weeks");
                    data.playerGrowLight = rs.getInt("grow light");
                    data.playerFertiliser = rs.getInt("Fertiliser");
                    data.loginFlag = true;
                }
                else
                {
                    data.loginFlag = false;
                }
            }
            else
            {
                System.out.println("User created and added to DB");
                statement.executeUpdate("INSERT INTO GameProfile " + "VALUES('" + username + "', '" + password + "', 1, 1, 1, 0)");
                data.loginFlag = true;
            }
        }
        
        catch (SQLException ex)
        {
            Logger.getLogger(GameDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    private boolean checkTable(String newTable)
    {
        boolean flag = false;
        
        try
        {
            System.out.println("check existing tables.... ");
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);
            while (rsDBMeta.next())
            {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTable) == 0) 
                {
                    System.out.println(tableName + " exists in your Database");
                    flag = true;
                }
            }
            if(rsDBMeta != null)
            {
                rsDBMeta.close();
            }
        }
        catch(SQLException ex)
        {
            
        }
        return flag;
    }
    
    public void saveDB(int saveFile, double money, int numOfPlants, int numOfWeeks, int numOfGrowLight, int numOfFertiliser)
    {
        Statement statement;
        try
        {
            statement = conn.createStatement();
            statement.executeUpdate("UPDATE LeaderBoard SET money=" + money + "WHERE saveFile = '" + saveFile + "'");
            statement.executeUpdate("UPDATE LeaderBoard SET numOfPlants=" + numOfPlants + "WHERE saveFile = '" + saveFile + "'");
            statement.executeUpdate("UPDATE LeaderBoard SET numOfWeeks=" + numOfWeeks + "WHERE saveFile = '" + saveFile + "'");
            statement.executeUpdate("UPDATE LeaderBoard SET numOfGrowLight=" + numOfGrowLight + "WHERE saveFile = '" + saveFile + "'");
            statement.executeUpdate("UPDATE LeaderBoard SET numOfFertiliser=" + numOfFertiliser + "WHERE saveFile = '" + saveFile + "'");
        }
        
        catch(SQLException ex)
        {
            System.out.println("Update not successful");
        }
    }
}