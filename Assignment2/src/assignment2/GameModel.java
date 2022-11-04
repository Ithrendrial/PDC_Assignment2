package assignment2;

import java.util.Observable;

public class GameModel extends Observable{

    public GameDatabase db;
    public GameData data;
    public String username;

    public GameModel() {
        this.db = new GameDatabase();
        this.db.dbSetup();
    }
    
     public boolean addLight(int numberOfLight){
        if(this.data.money >= numberOfLight*10){
            this.data.growLight = this.data.growLight + numberOfLight;
            this.removeMoney((numberOfLight*10));
            return true;
        } 
        else {
            System.out.println("You do not have enough money to do this.");
            return false;
        }
    }
     
     public boolean addFertiliser(int numberOfFertiliser){ 
        if(this.data.money >= numberOfFertiliser*15){
            this.data.fertiliser = this.data.fertiliser + numberOfFertiliser;
            this.removeMoney((numberOfFertiliser*15));
            return true;
        } 
        else {
            System.out.println("You do not have enough money to do this.");
            return false;
        }
    }
    
    //Money increases by n
    public void addMoney(int money){
        this.data.money = this.data.money + money;
    }
    
    //Money decreases by n
    public void removeMoney(int money){
        this.data.money = this.data.money - money;
    }

    public void checkName(String username) {
        this.username = username;
        this.data = this.db.checkPlayer(username);

        this.setChanged();
        this.notifyObservers(this.data);
    }

    //Methods for buying, selling, and propagating plants
    public void buyPlant(String plantID) {
   
        switch (plantID) {
            case "Variegated Monstera":
                this.data.tier1One++;
                this.removeMoney(this.data.price1);
                break;
                
            case "Adiantum Fragrans":
                this.data.tier1Two++;
                this.removeMoney(this.data.price2);
                break;
                
            case "Alocasia Azlanii":
                this.data.tier1Three++;
                this.removeMoney(this.data.price3);
                break;
                
            case "Dracaena Trifasciata":
                this.data.tier1Four++;
                this.removeMoney(this.data.price4);
                break;
                
            case "Calathea Leitzei":
                this.data.tier1Five++;
                this.removeMoney(this.data.price5);
                break;
                
            default:
                break;
        }
    }
    
    public boolean sellPlant(String plantID) {
        switch (plantID) {
            case "Variegated Monstera":
                if (this.data.tier5One > 0) {
                    this.data.tier5One--;
                    this.addMoney(this.data.price1*5);
                    return true;
                } else if (this.data.tier4One > 0) {
                    this.data.tier4One--;
                    this.addMoney(this.data.price1*4);
                    return true;
                } else if (this.data.tier3One > 0) {
                    this.data.tier3One--;
                    this.addMoney(this.data.price1*3);
                    return true;
                } else if (this.data.tier2One > 0) {
                    this.data.tier2One--;
                    this.addMoney(this.data.price1*2);
                    return true;
                } else if (this.data.tier1One > 0) {
                    this.data.tier1One--;
                    this.addMoney(this.data.price1);
                    return true;
                }
                return false;
                
            case "Adiantum Fragrans":
                if (this.data.tier5Two > 0) {
                    this.data.tier5Two--;
                    this.addMoney(this.data.price2*5);
                    return true;
                } else if (this.data.tier4Two > 0) {
                    this.data.tier4Two--;
                    this.addMoney(this.data.price2*4);
                    return true;
                } else if (this.data.tier3Two > 0) {
                    this.data.tier3Two--;
                    this.addMoney(this.data.price2*3);
                    return true;
                } else if (this.data.tier2Two > 0) {
                    this.data.tier2Two--;
                    this.addMoney(this.data.price2*2);
                    return true;
                } else if (this.data.tier1Two > 0) {
                    this.data.tier1Two--;
                    this.addMoney(this.data.price2);
                    return true;
                }
                return false;
                
            case "Alocasia Azlanii":
                if (this.data.tier5Three > 0) {
                    this.data.tier5Three--;
                    this.addMoney(this.data.price3*5);
                    return true;
                } else if (this.data.tier4Three > 0) {
                    this.data.tier4Three--;
                    this.addMoney(this.data.price3*4);
                    return true;
                } else if (this.data.tier3Three > 0) {
                    this.data.tier3Two--;
                    this.addMoney(this.data.price3*3);
                    return true;
                } else if (this.data.tier2Three > 0) {
                    this.data.tier2Three--;
                    this.addMoney(this.data.price3*2);
                    return true;
                } else if (this.data.tier1Three > 0) {
                    this.data.tier1Three--;
                    this.addMoney(this.data.price3);
                    return true;
                }
                return false;
                
            case "Dracaena Trifasciata":
                if (this.data.tier5Four > 0) {
                    this.data.tier5Four--;
                    this.addMoney(this.data.price4*5);
                    return true;
                } else if (this.data.tier4Four > 0) {
                    this.data.tier4Four--;
                    this.addMoney(this.data.price4*4);
                    return true;
                } else if (this.data.tier3Four > 0) {
                    this.data.tier3Four--;
                    this.addMoney(this.data.price4*3);
                    return true;
                } else if (this.data.tier2Four > 0) {
                    this.data.tier2Four--;
                    this.addMoney(this.data.price4*2);
                    return true;
                } else if (this.data.tier1Four > 0) {
                    this.data.tier1Four--;
                    this.addMoney(this.data.price4);
                    return true;
                }
                return false;
                
            case "Calathea Leitzei":
                if (this.data.tier5Five > 0) {
                    this.data.tier5Five--;
                    this.addMoney(this.data.price5*5);
                    return true;
                } else if (this.data.tier4Five > 0) {
                    this.data.tier4Five--;
                    this.addMoney(this.data.price5*4);
                    return true;
                } else if (this.data.tier3Five > 0) {
                    this.data.tier3Five--;
                    this.addMoney(this.data.price5*3);
                    return true;
                } else if (this.data.tier2Five > 0) {
                    this.data.tier2Five--;
                    this.addMoney(this.data.price5*2);
                    return true;
                } else if (this.data.tier1Five > 0) {
                    this.data.tier1Five--;
                    this.addMoney(this.data.price5);
                    return true;
                }
                return false;
                
            default:
                return true;
        }
    }

    public int propagate(String plantID) {
        //Return 1 if successful, 0 if no plants, -1 if tier issue
        switch (plantID) {
            case "Variegated Monstera":
                if (this.data.tier5One > 0) {
                    this.data.tier5One--;
                    this.data.tier4One = this.data.tier4One + 2;
                    return 1;
                } else if (this.data.tier4One > 0) {
                    this.data.tier4One--;
                    this.data.tier3One = this.data.tier3One + 2;
                    return 1;
                } else if (this.data.tier3One > 0) {
                    this.data.tier3One--;
                    this.data.tier2One = this.data.tier2One + 2;
                    return 1;
                } else if (this.data.tier2One > 0) {
                    this.data.tier2One--;
                    this.data.tier1One = this.data.tier1One + 2;
                    return 1;
                }
                if(this.data.tier1One > 0)
                    return -1;
                return 0;
            case "Adiantum Fragrans":
                if (this.data.tier5Two > 0) {
                    this.data.tier5Two--;
                    this.data.tier4Two = this.data.tier4Two + 2;
                    return 1;
                } else if (this.data.tier4Two > 0) {
                    this.data.tier4Two--;
                    this.data.tier3Two = this.data.tier3Two + 2;
                    return 1;
                } else if (this.data.tier3Two > 0) {
                    this.data.tier3Two--;
                    this.data.tier2Two = this.data.tier2Two + 2;
                    return 1;
                } else if (this.data.tier2Two > 0) {
                    this.data.tier2Two--;
                    this.data.tier1Two = this.data.tier1Two + 2;
                    return 1;
                }
                if(this.data.tier1Two > 0)
                    return -1;
                return 0;
                
            case "Alocasia Azlanii":
                if (this.data.tier5Three > 0) {
                    this.data.tier5Three--;
                    this.data.tier4Three = this.data.tier4Three + 2;
                    return 1;
                } else if (this.data.tier4Three > 0) {
                    this.data.tier4Three--;
                    this.data.tier3Three = this.data.tier3Three + 2;
                    return 1;
                } else if (this.data.tier3Three > 0) {
                    this.data.tier3Two--;
                    this.data.tier2Three = this.data.tier2Three + 2;
                    return 1;
                } else if (this.data.tier2Three > 0) {
                    this.data.tier2Three--;
                    this.data.tier1Three = this.data.tier1Three + 2;
                    return 1;
                }
                if(this.data.tier1Three > 0)
                    return -1;
                return 0;
                
            case "Dracaena Trifasciata":
                if (this.data.tier5Four > 0) {
                    this.data.tier5Four--;
                    this.data.tier4Four = this.data.tier4Four + 2;
                    return 1;
                } else if (this.data.tier4Four > 0) {
                    this.data.tier4Four--;
                    this.data.tier3Four = this.data.tier3Four + 2;
                    return 1;
                } else if (this.data.tier3Four > 0) {
                    this.data.tier3Four--;
                    this.data.tier2Four = this.data.tier2Four + 2;
                    return 1;
                } else if (this.data.tier2Four > 0) {
                    this.data.tier2Four--;
                    this.data.tier1Four = this.data.tier1Four + 2;
                    return 1;
                }
                if(this.data.tier1Four > 0)
                    return -1;
                return 0;
                
            case "Calathea Leitzei":
                if (this.data.tier5Five > 0) {
                    this.data.tier5Five--;
                    this.data.tier4Five = this.data.tier4Five + 2;
                    return 1;
                } else if (this.data.tier4Five > 0) {
                    this.data.tier4Five--;
                    this.data.tier3Five = this.data.tier3Five + 2;
                    return 1;
                } else if (this.data.tier3Five > 0) {
                    this.data.tier3Five--;
                    this.data.tier2Five = this.data.tier2Five + 2;
                    return 1;
                } else if (this.data.tier2Five > 0) {
                    this.data.tier2Five--;
                    this.data.tier1Five = this.data.tier1Five + 2;
                    return 1;
                }
                if(this.data.tier1Five > 0)
                    return -1;
                return 0;
                
            default:
                return 1;
        }
    }

    public boolean timePassed() {
        this.data.currentWeek++;
        
        if(this.data.currentWeek >= 5) {
            return true;
        }
        
        return false;
    }

    public void buyLight() {
        this.data.growLight++;
        this.removeMoney(10);
    }

    public void buyFertiliser() {
        this.data.fertiliser++;
        this.removeMoney(15);
    }

    public int useLight(String plantID) {
        //Return 1 if successful, 0 if no plants, -1 if tier issue
        switch (plantID) {
            case "Variegated Monstera":
                if (this.data.tier4One > 0) {
                    this.data.tier4One--;
                    this.data.tier5One = this.data.tier5One + 1;
                    this.data.growLight--;
                    return 1;
                } else if (this.data.tier3One > 0) {
                    this.data.tier3One--;
                    this.data.tier4One = this.data.tier4One + 1;
                    this.data.growLight--;
                    return 1;
                } else if (this.data.tier2One > 0) {
                    this.data.tier2One--;
                    this.data.tier3One = this.data.tier3One + 1;
                    this.data.growLight--;
                    return 1;
                } else if (this.data.tier1One > 0) {
                    this.data.tier1One--;
                    this.data.tier2One = this.data.tier2One + 1;
                    this.data.growLight--;
                    return 1;
                }
                if(this.data.tier5One > 0)
                    return -1;
                return 0;
                
            case "Adiantum Fragrans":
                if (this.data.tier4Two > 0) {
                    this.data.tier4Two--;
                    this.data.tier5Two = this.data.tier5Two + 1;
                    this.data.growLight--;
                    return 1;
                } else if (this.data.tier3Two > 0) {
                    this.data.tier3Two--;
                    this.data.tier4Two = this.data.tier4Two + 1;
                    this.data.growLight--;
                    return 1;
                } else if (this.data.tier2Two > 0) {
                    this.data.tier2Two--;
                    this.data.tier3Two = this.data.tier3Two + 1;
                    this.data.growLight--;
                    return 1;
                } else if(this.data.tier1Two > 0) {
                    this.data.tier1Two--;
                    this.data.tier2Two = this.data.tier2Two + 1;
                    this.data.growLight--;
                    return 1;
                }
                if(this.data.tier5Two > 0)
                    return -1;
                return 0;
                
            case "Alocasia Azlanii":
                if (this.data.tier4Three > 0) {
                    this.data.tier4Three--;
                    this.data.tier5Three = this.data.tier5Three + 1;
                    this.data.growLight--;
                    return 1;
                } else if (this.data.tier3Three > 0) {
                    this.data.tier3Three--;
                    this.data.tier4Three = this.data.tier4Three + 1;
                    this.data.growLight--;
                    return 1;
                } else if (this.data.tier2Three > 0) {
                    this.data.tier2Three--;
                    this.data.tier3Three = this.data.tier3Three + 1;
                    this.data.growLight--;
                    return 1;
                } else if(this.data.tier1Three > 0) {
                    this.data.tier1Three--;
                    this.data.tier2Three = this.data.tier2Three + 1;
                    this.data.growLight--;
                    return 1;
                }
                if(this.data.tier5Three > 0)
                    return -1;
                return 0;
                
            case "Dracaena Trifasciata":
                if (this.data.tier4Four > 0) {
                    this.data.tier4Four--;
                    this.data.tier5Four = this.data.tier5Four + 1;
                    this.data.growLight--;
                    return 1;
                } else if (this.data.tier3Four > 0) {
                    this.data.tier3Four--;
                    this.data.tier4Four = this.data.tier4Four + 1;
                    this.data.growLight--;
                    return 1;
                } else if (this.data.tier2Four > 0) {
                    this.data.tier2Four--;
                    this.data.tier3Four = this.data.tier3Four + 1;
                    this.data.growLight--;
                    return 1;
                } else if(this.data.tier1Four > 0) {
                    this.data.tier1Four--;
                    this.data.tier2Four = this.data.tier2Four + 1;
                    this.data.growLight--;
                    return 1;
                }
                if(this.data.tier5Four > 0)
                    return -1;
                return 0;
                
            case "Calathea Leitzei":
                if (this.data.tier4Five > 0) {
                    this.data.tier4Five--;
                    this.data.tier5Five = this.data.tier5Five + 1;
                    this.data.growLight--;
                    return 1;
                } else if (this.data.tier3Five > 0) {
                    this.data.tier3Five--;
                    this.data.tier4Five = this.data.tier4Five + 1;
                    this.data.growLight--;
                    return 1;
                } else if (this.data.tier2Five > 0) {
                    this.data.tier2Five--;
                    this.data.tier3Five = this.data.tier3Five + 1;
                    this.data.growLight--;
                    return 1;
                } else if(this.data.tier1Five > 0) {
                    this.data.tier1Five--;
                    this.data.tier2Five = this.data.tier2Five + 1;
                    this.data.growLight--;
                    return 1;
                }
                if(this.data.tier5Five > 0)
                    return -1;
                return 0;
            default:
                return 1;
        }
    }
    
    public int useFertiliser(String plantID) {
        //Return 1 if successful, 0 if no plants, -1 if tier issue
        switch (plantID) {
            case "Variegated Monstera":
                if (this.data.tier3One > 0) {
                    this.data.tier3One--;
                    this.data.tier5One = this.data.tier5One + 1;
                    this.data.fertiliser--;
                    return 1;
                } else if (this.data.tier2One > 0) {
                    this.data.tier2One--;
                    this.data.tier4One = this.data.tier4One + 1;
                    this.data.fertiliser--;
                    return 1;
                } else if (this.data.tier1One > 0) {
                    this.data.tier1One--;
                    this.data.tier3One = this.data.tier3One + 1;
                    this.data.fertiliser--;
                    return 1;
                }
                if(this.data.tier4One > 0 || this.data.tier5One > 0)
                    return -1;
                return 0;
                
            case "Adiantum Fragrans":
                if (this.data.tier3Two > 0) {
                    this.data.tier3Two--;
                    this.data.tier5Two = this.data.tier5Two + 1;
                    this.data.fertiliser--;
                    return 1;
                } else if (this.data.tier2Two > 0) {
                    this.data.tier2Two--;
                    this.data.tier4Two = this.data.tier4Two + 1;
                    this.data.fertiliser--;
                    return 1;
                } else if(this.data.tier1Two > 0) {
                    this.data.tier1Two--;
                    this.data.tier3Two = this.data.tier3Two + 1;
                    this.data.fertiliser--;
                    return 1;
                }
                if(this.data.tier4Two > 0 || this.data.tier5Two > 0)
                    return -1;
                return 0;
                
            case "Alocasia Azlanii":
                if (this.data.tier3Three > 0) {
                    this.data.tier3Three--;
                    this.data.tier5Three = this.data.tier5Three + 1;
                    this.data.fertiliser--;
                    return 1;
                } else if (this.data.tier2Three > 0) {
                    this.data.tier2Three--;
                    this.data.tier4Three = this.data.tier4Three + 1;
                    this.data.fertiliser--;
                    return 1;
                } else if(this.data.tier1Three > 0) {
                    this.data.tier1Three--;
                    this.data.tier3Three = this.data.tier3Three + 1;
                    this.data.fertiliser--;
                    return 1;
                }
                if(this.data.tier4Three > 0 || this.data.tier5Three > 0)
                    return -1;
                return 0;
                
            case "Dracaena Trifasciata":
                if (this.data.tier3Four > 0) {
                    this.data.tier3Four--;
                    this.data.tier5Four = this.data.tier5Four + 1;
                    this.data.fertiliser--;
                    return 1;
                } else if (this.data.tier2Four > 0) {
                    this.data.tier2Four--;
                    this.data.tier4Four = this.data.tier4Four + 1;
                    this.data.fertiliser--;
                    return 1;
                } else if(this.data.tier1Four > 0) {
                    this.data.tier1Four--;
                    this.data.tier3Four = this.data.tier3Four + 1;
                    this.data.fertiliser--;
                    return 1;
                }
                if(this.data.tier4Four > 0 || this.data.tier5Four > 0)
                    return -1;
                return 0;
                
            case "Calathea Leitzei":
                if (this.data.tier3Five > 0) {
                    this.data.tier3Five--;
                    this.data.tier5Five = this.data.tier5Five + 1;
                    this.data.fertiliser--;
                    return 1;
                } else if (this.data.tier2Five > 0) {
                    this.data.tier2Five--;
                    this.data.tier4Five = this.data.tier4Five + 1;
                    this.data.fertiliser--;
                    return 1;
                } else if(this.data.tier1Five > 0) {
                    this.data.tier1Five--;
                    this.data.tier3Five = this.data.tier3Five + 1;
                    this.data.fertiliser--;
                    return 1;
                }
                if(this.data.tier4Five > 0 || this.data.tier5Five > 0)
                    return -1;
                return 0;
                
            default:
                return 1;
        }
    }
    
    public String[] getPreviousScores() {
        String[] scoresArray = {"","","","","","","","","","","","","","","","","","","",""};
        this.db.leaderBoard(this.data);
        
        for(int i = 0; i < data.score.size(); i = i + 2){
            scoresArray[i + 1] = String.valueOf(data.score.get(i));
            scoresArray[i] = data.name.get(i);
        }
        
        return scoresArray;
    }
}