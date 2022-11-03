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

    public void buyPlant(int plantID) {
        if(plantID == 1) {
            this.data.tier1One++;
        } else if (plantID == 2) {
            this.data.tier1Two++;
        } else if (plantID == 3) {
            this.data.tier1Three++;
        } else if (plantID == 4) {
            this.data.tier1Four++;
        } else if (plantID == 5) {
            this.data.tier1Five++;
        }
    }

    public void sellPlant(int plantID) {
        switch (plantID) {
            case 1:
                if(this.data.tier5One > 0)
                    this.data.tier5One--;
                else if(this.data.tier5Two > 0)
                    this.data.tier5Two--;
                else if(this.data.tier5Three > 0)
                    this.data.tier5Three--;
                else if(this.data.tier5Four > 0)
                    this.data.tier5Four--;
                else if(this.data.tier5Five > 0)
                    this.data.tier5Five--;
                break;
            case 2:
                if(this.data.tier4One > 0)
                    this.data.tier5One--;
                else if(this.data.tier4Two > 0)
                    this.data.tier5Two--;
                else if(this.data.tier4Three > 0)
                    this.data.tier5Three--;
                else if(this.data.tier4Four > 0)
                    this.data.tier5Four--;
                else if(this.data.tier4Five > 0)
                    this.data.tier5Five--;
                break;
            case 3:
                if(this.data.tier3One > 0)
                    this.data.tier5One--;
                else if(this.data.tier3Two > 0)
                    this.data.tier5Two--;
                else if(this.data.tier3Three > 0)
                    this.data.tier5Three--;
                else if(this.data.tier3Four > 0)
                    this.data.tier5Four--;
                else if(this.data.tier3Five > 0)
                    this.data.tier5Five--;
                break;
            case 4:
                if(this.data.tier2One > 0)
                    this.data.tier5One--;
                else if(this.data.tier2Two > 0)
                    this.data.tier5Two--;
                else if(this.data.tier2Three > 0)
                    this.data.tier5Three--;
                else if(this.data.tier2Four > 0)
                    this.data.tier5Four--;
                else if(this.data.tier2Five > 0)
                    this.data.tier5Five--;
                break;
            case 5:
                if(this.data.tier1One > 0)
                    this.data.tier5One--;
                else if(this.data.tier1Two > 0)
                    this.data.tier5Two--;
                else if(this.data.tier1Three > 0)
                    this.data.tier5Three--;
                else if(this.data.tier1Four > 0)
                    this.data.tier5Four--;
                else if(this.data.tier1Five > 0)
                    this.data.tier5Five--;
                break;
            default:
                break;
        }
    }

    public void propagate() {

    }

    public void timePassed() {

    }
}
