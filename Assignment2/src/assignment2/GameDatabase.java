package assignment2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Davis Pike
 */
public class GameDatabase 
{
    Connection conn = null;
    String url = "jdbc:derby:ThePlantShop;create=true";
    String USER_NAME = "";
    String PASSWORD = "";
    
    public void dbSetup()
    {
        try
        {
            conn = DriverManager.getConnection(url, USER_NAME, PASSWORD);
            Statement statement = conn.createStatement();
            String tableName = "Plants";
            if(!checkTableExisting(tableName))
            {
                statement.executeUpdate("CREATE TABLE" + tableName + " (PLAND_ID INTEGER NOT NULL, SPECIES CHAR(100) NOT NULL, PRICEWEIGHT INTEGER NOT NULL, TIER1 INTEGER NOT NULL, TIER2 INTEGER NOT NULL, TIER3 INTEGER NOT NULL, TIER4 INTEGER NOT NULL, TIER5 INTEGER NOT NULL, TIER6 INTEGER NOT NULL, TIER7 INTEGER NOT NULL, TIER8 INTEGER NOT NULL, TIER9 INTEGER NOT NULL, TIER10 INTEGER NOT NULL, PRIMARY KEY (PLAND_ID)");
            }
            statement.close();
        }
        
        catch(Throwable e)
        {
            System.out.println("Error -Please ensure that the Derby Jars are in Libraries.");
        }
    }
}