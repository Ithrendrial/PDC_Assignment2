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
    Inventory userInventory;

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

    //Methods for buying, selling, and propagating plants
    public void buyPlant(int plantID) {
        if (plantID == 1) {
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
                if (this.data.tier5One > 0) {
                    this.data.tier5One--;
                } else if (this.data.tier4One > 0) {
                    this.data.tier4One--;
                } else if (this.data.tier3One > 0) {
                    this.data.tier3One--;
                } else if (this.data.tier2One > 0) {
                    this.data.tier2One--;
                } else if (this.data.tier1One > 0) {
                    this.data.tier1One--;
                }
                break;
            case 2:
                if (this.data.tier5Two > 0) {
                    this.data.tier5Two--;
                } else if (this.data.tier4Two > 0) {
                    this.data.tier4Two--;
                } else if (this.data.tier3Two > 0) {
                    this.data.tier3Two--;
                } else if (this.data.tier2Two > 0) {
                    this.data.tier2Two--;
                } else if (this.data.tier1Two > 0) {
                    this.data.tier1Two--;
                }
                break;
            case 3:
                if (this.data.tier5Three > 0) {
                    this.data.tier5Three--;
                } else if (this.data.tier4Three > 0) {
                    this.data.tier4Three--;
                } else if (this.data.tier3Three > 0) {
                    this.data.tier3Two--;
                } else if (this.data.tier2Three > 0) {
                    this.data.tier2Three--;
                } else if (this.data.tier1Three > 0) {
                    this.data.tier1Three--;
                }
                break;
            case 4:
                if (this.data.tier5Four > 0) {
                    this.data.tier5Four--;
                } else if (this.data.tier4Four > 0) {
                    this.data.tier4Four--;
                } else if (this.data.tier3Four > 0) {
                    this.data.tier3Four--;
                } else if (this.data.tier2Four > 0) {
                    this.data.tier2Four--;
                } else if (this.data.tier1Four > 0) {
                    this.data.tier1Four--;
                }
                break;
            case 5:
                if (this.data.tier5Five > 0) {
                    this.data.tier5Five--;
                } else if (this.data.tier4Five > 0) {
                    this.data.tier4Five--;
                } else if (this.data.tier3Five > 0) {
                    this.data.tier3Five--;
                } else if (this.data.tier2Five > 0) {
                    this.data.tier2Five--;
                } else if (this.data.tier1Five > 0) {
                    this.data.tier1Five--;
                }
                break;
            default:
                break;
        }
    }

    public void propagate(int plantID) {
        switch (plantID) {
            case 1:
                if (this.data.tier5One > 0) {
                    this.data.tier5One--;
                    this.data.tier4One = this.data.tier4One + 2;
                } else if (this.data.tier4One > 0) {
                    this.data.tier4One--;
                    this.data.tier3One = this.data.tier3One + 2;
                } else if (this.data.tier3One > 0) {
                    this.data.tier3One--;
                    this.data.tier2One = this.data.tier2One + 2;
                } else if (this.data.tier2One > 0) {
                    this.data.tier2One--;
                    this.data.tier1One = this.data.tier1One + 2;
                }
                break;
            case 2:
                if (this.data.tier5Two > 0) {
                    this.data.tier5Two--;
                    this.data.tier4Two = this.data.tier4Two = 2;
                } else if (this.data.tier4Two > 0) {
                    this.data.tier4Two--;
                    this.data.tier3Two = this.data.tier3Two = 2;
                } else if (this.data.tier3Two > 0) {
                    this.data.tier3Two--;
                    this.data.tier2Two = this.data.tier2Two = 2;
                } else if (this.data.tier2Two > 0) {
                    this.data.tier2Two--;
                    this.data.tier1Two = this.data.tier1Two = 2;
                }
                break;
            case 3:
                if (this.data.tier5Three > 0) {
                    this.data.tier5Three--;
                    this.data.tier4Three = this.data.tier4Three = 2;
                } else if (this.data.tier4Three > 0) {
                    this.data.tier4Three--;
                    this.data.tier3Three = this.data.tier3Three = 2;
                } else if (this.data.tier3Three > 0) {
                    this.data.tier3Two--;
                    this.data.tier2Three = this.data.tier2Three = 2;
                } else if (this.data.tier2Three > 0) {
                    this.data.tier2Three--;
                    this.data.tier1Three = this.data.tier1Three = 2;
                }
                break;
            case 4:
                if (this.data.tier5Four > 0) {
                    this.data.tier5Four--;
                    this.data.tier4Four = this.data.tier4Four + 2;
                } else if (this.data.tier4Four > 0) {
                    this.data.tier4Four--;
                    this.data.tier3Four = this.data.tier3Four + 2;
                } else if (this.data.tier3Four > 0) {
                    this.data.tier3Four--;
                    this.data.tier2Four = this.data.tier2Four + 2;
                } else if (this.data.tier2Four > 0) {
                    this.data.tier2Four--;
                    this.data.tier1Four = this.data.tier1Four + 2;
                }
                break;
            case 5:
                if (this.data.tier5Five > 0) {
                    this.data.tier5Five--;
                    this.data.tier4Five = this.data.tier4Five = 2;
                } else if (this.data.tier4Five > 0) {
                    this.data.tier4Five--;
                    this.data.tier3Five = this.data.tier3Five = 2;
                } else if (this.data.tier3Five > 0) {
                    this.data.tier3Five--;
                    this.data.tier2Five = this.data.tier2Five = 2;
                } else if (this.data.tier2Five > 0) {
                    this.data.tier2Five--;
                    this.data.tier1Five = this.data.tier1Five = 2;
                }
                break;
            default:
                break;
        }
    }

    public void timePassed() {
        this.data.currentWeek++;
    }

    public void buyLight() {
        this.data.growLight++;
    }

    public void buyFertiliser() {
        this.data.fertiliser++;
    }

    public void useLight() {
        if (this.data.growLight > 0) {
            this.data.growLight--;
            System.out.println("You used a grow light on your plant");
        } else {
            System.out.println("You do not own enough grow lights to do this.");
        }
    }
    
    public void useFertiliser() {
        if (this.data.fertiliser > 0) {
            this.data.fertiliser--;
            System.out.println("You used fertiliser on your plant");
        } else {
            System.out.println("You do not own enough fertiliser to do this.");
        }
    }
}
