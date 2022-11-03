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

    public GameModel() {
        this.db = new GameDatabase();
        this.db.dbSetup();
    }

    public void checkName(String username) {
        this.username = username;
        this.data = this.db.checkPlayer(username);

        this.setChanged();
        this.notifyObservers(this.data);
    }
}
