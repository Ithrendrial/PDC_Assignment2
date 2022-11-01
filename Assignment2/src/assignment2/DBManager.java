package assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Davis Pike
 */
public final class DBManager 
{
    private static final String USER_NAME = "";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:derby:ThePlantShop;create=true";
    
    Connection conn;
    
    public DBManager()
    {
        establishConnection();
    }
    
    public static void main(String[] args) 
    {
        DBManager dbManager = new DBManager();
        System.out.println(dbManager.getConnection());
    }
    
    public Connection getConnection() 
    {
        return this.conn;
    }
    
    public void establishConnection() 
    {
        if (this.conn == null) 
        {
            try 
            {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + " Get Connected Successfully ....");
            } 
            catch (SQLException ex) 
            {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public void closeConnections() 
    {
        if (conn != null) 
        {
            try 
            {
                conn.close();
            } 
            
            catch (SQLException ex) 
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}
