/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.util.Observable;

/**
 *
 * @author rcox299
 */
public class GameModel extends Observable {

    public GameDatabase db;
    public GameData data;
    public String username;
    public String password;

    public GameModel() {
        this.db = new GameDatabase();
        this.db.dbSetup();
    }

    public void checkName(String username, String password) {
        this.username = username;
        this.password = password;
        this.data = this.db.checkPlayer(username, password);

        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void test() {
        double test = data.playerMoney;
        System.out.println(test);
    }
}
