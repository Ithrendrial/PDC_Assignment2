package assignment2;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Davis Pike (Pb - fixed)
 */
public class GameDatabase {

    Connection conn = null;
    String url = "jdbc:derby:ThePlantShop;create=true";
    //1.dont use the same password / username as me c:
    String user_name = "pdc";
    String password = "pdc";

    //1.removed redundant code
    //2.in statement.executeUpdate(); missing bracket was added
    //3.rearranged the entire database structure please have a read through (database only use to save non-static data, eg: player save data, eg for not good in database: plant price)
    public void dbSetup() {
        try {
            conn = DriverManager.getConnection(url, user_name, password);
            Statement statement = conn.createStatement();
            String plantTableName = "PlantsInventory";
            if (!checkTable(plantTableName)) {
                statement.executeUpdate("CREATE TABLE " + plantTableName + " (plantID INT, t1 INT, t2 INT, t3 INT, t4 INT, t5 INT, username VARCHAR(12))");
            }
            statement.close();

            statement = conn.createStatement();
            String itemTableName = "ItemsInventory";
            if (!checkTable(itemTableName)) {
                statement.executeUpdate("CREATE TABLE " + itemTableName + " (growLight INT, fertiliser INT, username VARCHAR(12))");
            }
            statement.close();
            
            statement = conn.createStatement();
            String leaderBoardTableName = "LeaderBoard";
            if (!checkTable(leaderBoardTableName)) {
                statement.executeUpdate("CREATE TABLE " + leaderBoardTableName + " (score INT, username VARCHAR(12))");
            }
            statement.close();
            
        } catch (Throwable e) {
            System.out.println("Error -Please ensure that the Derby Jars are in Libraries.");
        }
    }

    public GameData checkPlayer(String username) {
        GameData data = new GameData();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM PlantsInventory WHERE username = '" + username + "' AND plantID = 1");
            if (rs.next()) {
                System.out.println("found user");
                data.tier1One = rs.getInt("t1");
                data.tier2One = rs.getInt("t2");
                data.tier3One = rs.getInt("t3");
                data.tier4One = rs.getInt("t4");
                data.tier5One = rs.getInt("t5");
            }
            
            rs = statement.executeQuery("SELECT * FROM PlantsInventory WHERE username = '" + username + "' AND plantID = 2");
            if(rs.next()){
                
                data.tier1Two = rs.getInt("t1");
                data.tier2Two = rs.getInt("t2");
                data.tier3Two = rs.getInt("t3");
                data.tier4Two = rs.getInt("t4");
                data.tier5Two = rs.getInt("t5");
            }
            
            rs = statement.executeQuery("SELECT * FROM PlantsInventory WHERE username = '" + username + "' AND plantID = 3");
            if(rs.next()){
                
                data.tier1Three = rs.getInt("t1");
                data.tier2Three = rs.getInt("t2");
                data.tier3Three = rs.getInt("t3");
                data.tier4Three = rs.getInt("t4");
                data.tier5Three = rs.getInt("t5");
            }
            
            rs = statement.executeQuery("SELECT * FROM PlantsInventory WHERE username = '" + username + "' AND plantID = 4");
            if(rs.next()){
                data.tier1Four = rs.getInt("t1");
                data.tier2Four = rs.getInt("t2");
                data.tier3Four = rs.getInt("t3");
                data.tier4Four = rs.getInt("t4");
                data.tier5Four = rs.getInt("t5");
            }
            
            rs = statement.executeQuery("SELECT * FROM PlantsInventory WHERE username = '" + username + "' AND plantID = 5");
            if(rs.next()){
                
                data.tier1Five = rs.getInt("t1");
                data.tier2Five = rs.getInt("t2");
                data.tier3Five = rs.getInt("t3");
                data.tier4Five = rs.getInt("t4");
                data.tier5Five = rs.getInt("t5");
            }
            
            rs = statement.executeQuery("SELECT * FROM ItemsInventory WHERE username = '" + username + "'");
            if(rs.next()){
                
                data.fertiliser = rs.getInt("fertiliser");
                data.growLight = rs.getInt("growLight");

            } else {
                System.out.println("User created and added to DB");

                statement.executeUpdate("INSERT INTO PlantsInventory " + "VALUES(1, 0, 0, 0, 0, 0, '" + username + "')");
                statement.executeUpdate("INSERT INTO PlantsInventory " + "VALUES(2, 0, 0, 0, 0, 0, '" + username + "')");
                statement.executeUpdate("INSERT INTO PlantsInventory " + "VALUES(3, 0, 0, 0, 0, 0, '" + username + "')");
                statement.executeUpdate("INSERT INTO PlantsInventory " + "VALUES(4, 0, 0, 0, 0, 0, '" + username + "')");
                statement.executeUpdate("INSERT INTO PlantsInventory " + "VALUES(5, 0, 0, 0, 0, 0, '" + username + "')");
                statement.executeUpdate("INSERT INTO ItemsInventory " + "VALUES(0, 0, '" + username + "')");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GameDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    private boolean checkTable(String newTable) {
        boolean flag = false;

        try {
            System.out.println("check existing tables.... ");
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);
            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTable) == 0) {
                    System.out.println(tableName + " exists in your Database");
                    flag = true;
                }
            }
            if (rsDBMeta != null) {
                rsDBMeta.close();
            }
        } catch (SQLException ex) {

        }
        return flag;
    }

    public void saveDB(int t1One, int t2One, int t3One, int t4One, int t5One,
            int t1Two, int t2Two, int t3Two, int t4Two, int t5Two,
            int t1Three, int t2Three, int t3Three, int t4Three, int t5Three,
            int t1Four, int t2Four, int t3Four, int t4Four, int t5Four,
            int t1Five, int t2Five, int t3Five, int t4Five, int t5Five,
            int growLight, int fertiliser,
            String username) {
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("UPDATE PlantsInventory SET t1 =" + t1One + "WHERE username = '" + username + "' AND plantID = '1'");
            statement.executeUpdate("UPDATE PlantsInventory SET t2 =" + t2One + "WHERE username = '" + username + "' AND plantID = '1'");
            statement.executeUpdate("UPDATE PlantsInventory SET t3 =" + t3One + "WHERE username = '" + username + "' AND plantID = '1'");
            statement.executeUpdate("UPDATE PlantsInventory SET t4 =" + t4One + "WHERE username = '" + username + "' AND plantID = '1'");
            statement.executeUpdate("UPDATE PlantsInventory SET t5 =" + t5One + "WHERE username = '" + username + "' AND plantID = '1'");

            statement.executeUpdate("UPDATE PlantsInventory SET t1 =" + t1Two + "WHERE username = '" + username + "' AND plantID = '2'");
            statement.executeUpdate("UPDATE PlantsInventory SET t2 =" + t2Two + "WHERE username = '" + username + "' AND plantID = '2'");
            statement.executeUpdate("UPDATE PlantsInventory SET t3 =" + t3Two + "WHERE username = '" + username + "' AND plantID = '2'");
            statement.executeUpdate("UPDATE PlantsInventory SET t4 =" + t4Two + "WHERE username = '" + username + "' AND plantID = '2'");
            statement.executeUpdate("UPDATE PlantsInventory SET t5 =" + t5Two + "WHERE username = '" + username + "' AND plantID = '2'");

            statement.executeUpdate("UPDATE PlantsInventory SET t1 =" + t1Three + "WHERE username = '" + username + "' AND plantID = '3'");
            statement.executeUpdate("UPDATE PlantsInventory SET t2 =" + t2Three + "WHERE username = '" + username + "' AND plantID = '3'");
            statement.executeUpdate("UPDATE PlantsInventory SET t3 =" + t3Three + "WHERE username = '" + username + "' AND plantID = '3'");
            statement.executeUpdate("UPDATE PlantsInventory SET t4 =" + t4Three + "WHERE username = '" + username + "' AND plantID = '3'");
            statement.executeUpdate("UPDATE PlantsInventory SET t5 =" + t5Three + "WHERE username = '" + username + "' AND plantID = '3'");

            statement.executeUpdate("UPDATE PlantsInventory SET t1 =" + t1Four + "WHERE username = '" + username + "' AND plantID = '4'");
            statement.executeUpdate("UPDATE PlantsInventory SET t2 =" + t2Four + "WHERE username = '" + username + "' AND plantID = '4'");
            statement.executeUpdate("UPDATE PlantsInventory SET t3 =" + t3Four + "WHERE username = '" + username + "' AND plantID = '4'");
            statement.executeUpdate("UPDATE PlantsInventory SET t4 =" + t4Four + "WHERE username = '" + username + "' AND plantID = '4'");
            statement.executeUpdate("UPDATE PlantsInventory SET t5 =" + t5Four + "WHERE username = '" + username + "' AND plantID = '4'");

            statement.executeUpdate("UPDATE PlantsInventory SET t1 =" + t1Five + "WHERE username = '" + username + "' AND plantID = '5'");
            statement.executeUpdate("UPDATE PlantsInventory SET t2 =" + t2Five + "WHERE username = '" + username + "' AND plantID = '5'");
            statement.executeUpdate("UPDATE PlantsInventory SET t3 =" + t3Five + "WHERE username = '" + username + "' AND plantID = '5'");
            statement.executeUpdate("UPDATE PlantsInventory SET t4 =" + t4Five + "WHERE username = '" + username + "' AND plantID = '5'");
            statement.executeUpdate("UPDATE PlantsInventory SET t5 =" + t5Five + "WHERE username = '" + username + "' AND plantID = '5'");

            statement.executeUpdate("UPDATE ItemsInventory SET growLight =" + growLight + "WHERE username = '" + username + "'");
            statement.executeUpdate("UPDATE ItemsInventory SET growLight =" + fertiliser + "WHERE username = '" + username + "'");
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Update not successful");
        }
    }

    public void addLeaderBoard(int score, String username) {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO LeaderBoard VALUES('" + score + "','" + username + "')");
            statement.close();

        } catch (SQLException ex) {
            System.out.println("LeaderBoard entry not successful");
        }
    }

    public GameData leaderBoard(GameData data) {
        GameData leaderBoardData = data;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT score FROM LeaderBoard");
            
            while(rs.next())
            {
                leaderBoardData.score.add(rs.getInt("score"));
                leaderBoardData.name.add(rs.getString("username"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(GameDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
