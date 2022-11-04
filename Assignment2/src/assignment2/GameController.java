package assignment2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class GameController implements ActionListener {

    public GameView view;
    public GameModel model;
    private JFrame frame;
    private boolean origin;
    private String displayedPlant = "______";

    public GameController(GameView view, GameModel model, JFrame frame) {
        this.view = view;
        this.frame = frame;
        this.model = model;
        this.view.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        boolean checkPlantBoolean;
        int checkPlantInt;
        boolean checkWeek;

        switch (command) {
            case "GO":
                String username = this.view.enterName.getText();
                this.model.checkName(username);
                this.model.data.userName = username;
                view.mainMenu();
                break;

            case "PLAY":
                view.play();
                view.updateBank(model.data.money);
                view.updateWeek(model.data.currentWeek);
                view.updateItemInfo(model.data.fertiliser, model.data.growLight);
                view.updatePlantNameCombo(model.data.name1, model.data.name2,
                        model.data.name3, model.data.name4, model.data.name5);
                break;

            case "mainRules":
                origin = true;
                view.rules();
                break;

            case "PREVIOUS GAMES":
                view.leaderboard();
                origin = true;
                String[] scores = model.getPreviousScores();
                view.displayScores(scores);
                break;

            case "BACK":
                if (origin) {
                    view.mainMenu();
                } else {
                    view.play();
                }
                break;

            case "playRules":
                origin = false;
                view.rules();
                break;

            case "MAIN MENU":
                view.mainMenu();
                break;

            case "BUY":
                String supplierName = (String) view.getSupplierValue();
                if (!(supplierName.contentEquals("Fertiliser")) && !(supplierName.contentEquals("Growlight"))) {
                    displayedPlant = supplierName;
                }

                if (supplierName.contentEquals(model.data.name1)) {
                    if (model.data.price1 > model.data.money) {
                        view.noMoney();
                    } else {
                        model.buyPlant(model.data.name1);
                        view.clearWarnings();
                        checkWeek = model.timePassed();
                        if (checkWeek) {
                            endGame();
                        }
                        update(model.data.name1);
                    }
                }
                if (supplierName.contentEquals(model.data.name2)) {
                    if (model.data.price2 > model.data.money) {
                        view.noMoney();
                    } else {
                        model.buyPlant(model.data.name2);
                        view.clearWarnings();
                        checkWeek = model.timePassed();
                        if (checkWeek) {
                            endGame();
                        }
                        update(model.data.name2);
                    }
                }
                if (supplierName.contentEquals(model.data.name3)) {
                    if (model.data.price3 > model.data.money) {
                        view.noMoney();
                    } else {
                        model.buyPlant(model.data.name3);
                        view.clearWarnings();
                        checkWeek = model.timePassed();
                        if (checkWeek) {
                            endGame();
                        }
                        update(model.data.name3);
                    }
                }
                if (supplierName.contentEquals(model.data.name4)) {
                    if (model.data.price4 > model.data.money) {
                        view.noMoney();
                    } else {
                        model.buyPlant(model.data.name4);
                        view.clearWarnings();
                        checkWeek = model.timePassed();
                        if (checkWeek) {
                            endGame();
                        }
                        update(model.data.name4);
                    }
                }
                if (supplierName.contentEquals(model.data.name5)) {
                    if (model.data.price5 > model.data.money) {
                        view.noMoney();
                    } else {
                        model.buyPlant(model.data.name5);
                        view.clearWarnings();
                        checkWeek = model.timePassed();
                        if (checkWeek) {
                            endGame();
                        }
                        update(model.data.name5);
                    }
                }
                if (supplierName.contentEquals("Fertiliser")) {
                    model.buyFertiliser();
                    view.clearWarnings();
                    checkWeek = model.timePassed();
                    if (checkWeek) {
                        endGame();
                    }
                    view.updateBank(model.data.money);
                    view.updateWeek(model.data.currentWeek);
                    view.updateItemInfo(model.data.fertiliser, model.data.growLight);

                }
                if (supplierName.contentEquals("Growlight")) {
                    model.buyLight();
                    view.clearWarnings();
                    checkWeek = model.timePassed();
                    if (checkWeek) {
                        endGame();
                    }
                    view.updateBank(model.data.money);
                    view.updateWeek(model.data.currentWeek);
                    view.updateItemInfo(model.data.fertiliser, model.data.growLight);
                }
                
                this.model.db.saveDB(this.model.data.tier1One, this.model.data.tier2One, this.model.data.tier3One, this.model.data.tier4One, this.model.data.tier5One,
                        this.model.data.tier1Two, this.model.data.tier2Two, this.model.data.tier3Two, this.model.data.tier4Two, this.model.data.tier5Two,
                        this.model.data.tier1Three, this.model.data.tier2Three, this.model.data.tier3Three, this.model.data.tier4Three, this.model.data.tier5Three,
                        this.model.data.tier1Four, this.model.data.tier2Four, this.model.data.tier3Four, this.model.data.tier4Four, this.model.data.tier5Four,
                        this.model.data.tier1Five, this.model.data.tier2Five, this.model.data.tier3Five, this.model.data.tier4Five, this.model.data.tier5Five,
                        this.model.data.growLight, this.model.data.fertiliser, this.model.data.currentWeek, this.model.data.money, this.model.data.userName);
                break;

            case "SELECT":
                String stockName = (String) view.getStockValue();
                displayedPlant = stockName;

                if (stockName.contentEquals(model.data.name1)) {
                    update(model.data.name1);
                }
                if (stockName.contentEquals(model.data.name2)) {
                    update(model.data.name2);
                }
                if (stockName.contentEquals(model.data.name3)) {
                    update(model.data.name3);
                }
                if (stockName.contentEquals(model.data.name4)) {
                    update(model.data.name4);
                }
                if (stockName.contentEquals(model.data.name5)) {
                    update(model.data.name5);
                }
                break;

            case "SELL":
                if (displayedPlant.contentEquals(model.data.name1)) {
                    checkPlantBoolean = model.sellPlant(model.data.name1);
                    if (checkPlantBoolean) {
                        view.clearWarnings();
                        checkWeek = model.timePassed();
                        if (checkWeek) {
                            endGame();
                        }
                        update(model.data.name1);
                    } else {
                        view.noPlant();
                    }
                }
                if (displayedPlant.contentEquals(model.data.name2)) {
                    checkPlantBoolean = model.sellPlant(model.data.name2);
                    if (checkPlantBoolean) {
                        view.clearWarnings();
                        checkWeek = model.timePassed();
                        if (checkWeek) {
                            endGame();
                        }
                        update(model.data.name2);
                    } else {
                        view.noPlant();
                    }
                }
                if (displayedPlant.contentEquals(model.data.name3)) {
                    checkPlantBoolean = model.sellPlant(model.data.name3);
                    if (checkPlantBoolean) {
                        checkWeek = model.timePassed();
                        if (checkWeek) {
                            endGame();
                        }
                        update(model.data.name3);
                    } else {
                        view.noPlant();
                    }
                }
                if (displayedPlant.contentEquals(model.data.name4)) {
                    checkPlantBoolean = model.sellPlant(model.data.name4);
                    if (checkPlantBoolean) {
                        checkWeek = model.timePassed();
                        if (checkWeek) {
                            endGame();
                        }
                        update(model.data.name4);
                    } else {
                        view.noPlant();
                    }
                }
                if (displayedPlant.contentEquals(model.data.name5)) {
                    checkPlantBoolean = model.sellPlant(model.data.name5);
                    if (checkPlantBoolean) {
                        checkWeek = model.timePassed();
                        if (checkWeek) {
                            endGame();
                        }
                        update(model.data.name5);
                    } else {
                        view.noPlant();
                    }
                }
                this.model.db.saveDB(this.model.data.tier1One, this.model.data.tier2One, this.model.data.tier3One, this.model.data.tier4One, this.model.data.tier5One,
                        this.model.data.tier1Two, this.model.data.tier2Two, this.model.data.tier3Two, this.model.data.tier4Two, this.model.data.tier5Two,
                        this.model.data.tier1Three, this.model.data.tier2Three, this.model.data.tier3Three, this.model.data.tier4Three, this.model.data.tier5Three,
                        this.model.data.tier1Four, this.model.data.tier2Four, this.model.data.tier3Four, this.model.data.tier4Four, this.model.data.tier5Four,
                        this.model.data.tier1Five, this.model.data.tier2Five, this.model.data.tier3Five, this.model.data.tier4Five, this.model.data.tier5Five,
                        this.model.data.growLight, this.model.data.fertiliser, this.model.data.currentWeek, this.model.data.money, this.model.data.userName);
                break;

            case "PROPAGATE":
                if (displayedPlant.contentEquals(model.data.name1)) {
                    checkPlantInt = model.propagate(model.data.name1);
                    if (checkPlantInt == 1) {
                        view.clearWarnings();
                        checkWeek = model.timePassed();
                        if (checkWeek) {
                            endGame();
                        }
                        update(model.data.name1);
                    } else if (checkPlantInt == 0) {
                        view.noPlant();
                    } else if (checkPlantInt == -1) {
                        view.tooLow();
                    }
                }
                if (displayedPlant.contentEquals(model.data.name2)) {
                    checkPlantInt = model.propagate(model.data.name2);
                    if (checkPlantInt == 1) {
                        view.clearWarnings();
                        checkWeek = model.timePassed();
                        if (checkWeek) {
                            endGame();
                        }
                        update(model.data.name2);
                    } else if (checkPlantInt == 0) {
                        view.noPlant();
                    } else if (checkPlantInt == -1) {
                        view.tooLow();
                    }
                }
                if (displayedPlant.contentEquals(model.data.name3)) {
                    checkPlantInt = model.propagate(model.data.name3);
                    if (checkPlantInt == 1) {
                        checkWeek = model.timePassed();
                        if (checkWeek) {
                            endGame();
                        }
                        update(model.data.name3);
                    } else if (checkPlantInt == 0) {
                        view.noPlant();
                    } else if (checkPlantInt == -1) {
                        view.tooLow();
                    }
                }
                if (displayedPlant.contentEquals(model.data.name4)) {
                    checkPlantInt = model.propagate(model.data.name4);
                    if (checkPlantInt == 1) {
                        checkWeek = model.timePassed();
                        if (checkWeek) {
                            endGame();
                        }
                        update(model.data.name4);
                    } else if (checkPlantInt == 0) {
                        view.noPlant();
                    } else if (checkPlantInt == -1) {
                        view.tooLow();
                    }
                }
                if (displayedPlant.contentEquals(model.data.name5)) {
                    checkPlantInt = model.propagate(model.data.name5);
                    if (checkPlantInt == 1) {
                        checkWeek = model.timePassed();
                        if (checkWeek) {
                            endGame();
                        }
                        update(model.data.name5);
                    } else if (checkPlantInt == 0) {
                        view.noPlant();
                    } else if (checkPlantInt == -1) {
                        view.tooLow();
                    }
                }
                this.model.db.saveDB(this.model.data.tier1One, this.model.data.tier2One, this.model.data.tier3One, this.model.data.tier4One, this.model.data.tier5One,
                        this.model.data.tier1Two, this.model.data.tier2Two, this.model.data.tier3Two, this.model.data.tier4Two, this.model.data.tier5Two,
                        this.model.data.tier1Three, this.model.data.tier2Three, this.model.data.tier3Three, this.model.data.tier4Three, this.model.data.tier5Three,
                        this.model.data.tier1Four, this.model.data.tier2Four, this.model.data.tier3Four, this.model.data.tier4Four, this.model.data.tier5Four,
                        this.model.data.tier1Five, this.model.data.tier2Five, this.model.data.tier3Five, this.model.data.tier4Five, this.model.data.tier5Five,
                        this.model.data.growLight, this.model.data.fertiliser, this.model.data.currentWeek, this.model.data.money, this.model.data.userName);
                break;

            case "FERTILISE":
                if (displayedPlant.contentEquals(model.data.name1)) {
                    if (model.data.fertiliser < 1) {
                        view.noItem();
                    } else {
                        checkPlantInt = model.useFertiliser(model.data.name1);
                        if (checkPlantInt == 1) {
                            view.clearWarnings();
                            checkWeek = model.timePassed();
                            if (checkWeek) {
                                endGame();
                            }
                            update(model.data.name1);
                        } else if (checkPlantInt == 0) {
                            view.noPlant();
                        } else if (checkPlantInt == -1) {
                            view.tooHigh();
                        }
                    }
                }
                if (displayedPlant.contentEquals(model.data.name2)) {
                    if (model.data.fertiliser < 1) {
                        view.noItem();
                    } else {
                        checkPlantInt = model.useFertiliser(model.data.name2);
                        if (checkPlantInt == 1) {
                            view.clearWarnings();
                            checkWeek = model.timePassed();
                            if (checkWeek) {
                                endGame();
                            }
                            update(model.data.name2);
                        } else if (checkPlantInt == 0) {
                            view.noPlant();
                        } else if (checkPlantInt == -1) {
                            view.tooHigh();
                        }
                    }
                }
                if (displayedPlant.contentEquals(model.data.name3)) {
                    if (model.data.fertiliser < 1) {
                        view.noItem();
                    } else {
                        checkPlantInt = model.useFertiliser(model.data.name3);
                        if (checkPlantInt == 1) {
                            view.clearWarnings();
                            checkWeek = model.timePassed();
                            if (checkWeek) {
                                endGame();
                            }
                            update(model.data.name3);
                        } else if (checkPlantInt == 0) {
                            view.noPlant();
                        } else if (checkPlantInt == -1) {
                            view.tooHigh();
                        }
                    }
                }
                if (displayedPlant.contentEquals(model.data.name4)) {
                    if (model.data.fertiliser < 1) {
                        view.noItem();
                    } else {
                        checkPlantInt = model.useFertiliser(model.data.name4);
                        if (checkPlantInt == 1) {
                            view.clearWarnings();
                            checkWeek = model.timePassed();
                            if (checkWeek) {
                                endGame();
                            }
                            update(model.data.name4);
                        } else if (checkPlantInt == 0) {
                            view.noPlant();
                        } else if (checkPlantInt == -1) {
                            view.tooHigh();
                        }
                    }
                }
                if (displayedPlant.contentEquals(model.data.name5)) {
                    if (model.data.fertiliser < 1) {
                        view.noItem();
                    } else {
                        checkPlantInt = model.useFertiliser(model.data.name5);
                        if (checkPlantInt == 1) {
                            view.clearWarnings();
                            checkWeek = model.timePassed();
                            if (checkWeek) {
                                endGame();
                            }
                            update(model.data.name5);
                        } else if (checkPlantInt == 0) {
                            view.noPlant();
                        } else if (checkPlantInt == -1) {
                            view.tooHigh();
                        }
                    }
                }
                this.model.db.saveDB(this.model.data.tier1One, this.model.data.tier2One, this.model.data.tier3One, this.model.data.tier4One, this.model.data.tier5One,
                        this.model.data.tier1Two, this.model.data.tier2Two, this.model.data.tier3Two, this.model.data.tier4Two, this.model.data.tier5Two,
                        this.model.data.tier1Three, this.model.data.tier2Three, this.model.data.tier3Three, this.model.data.tier4Three, this.model.data.tier5Three,
                        this.model.data.tier1Four, this.model.data.tier2Four, this.model.data.tier3Four, this.model.data.tier4Four, this.model.data.tier5Four,
                        this.model.data.tier1Five, this.model.data.tier2Five, this.model.data.tier3Five, this.model.data.tier4Five, this.model.data.tier5Five,
                        this.model.data.growLight, this.model.data.fertiliser, this.model.data.currentWeek, this.model.data.money, this.model.data.userName);
                break;

            case "GIVE LIGHT":
                if (displayedPlant.contentEquals(model.data.name1)) {
                    if (model.data.growLight < 1) {
                        view.noItem();
                    } else {
                        checkPlantInt = model.useLight(model.data.name1);
                        if (checkPlantInt == 1) {
                            view.clearWarnings();
                            checkWeek = model.timePassed();
                            if (checkWeek) {
                                endGame();
                            }
                            update(model.data.name1);
                        } else if (checkPlantInt == 0) {
                            view.noPlant();
                        } else if (checkPlantInt == -1) {
                            view.tooHigh();
                        }
                    }
                }
                if (displayedPlant.contentEquals(model.data.name2)) {
                    if (model.data.growLight < 1) {
                        view.noItem();
                    } else {
                        checkPlantInt = model.useLight(model.data.name2);
                        if (checkPlantInt == 1) {
                            view.clearWarnings();
                            checkWeek = model.timePassed();
                            if (checkWeek) {
                                endGame();
                            }
                            update(model.data.name2);
                        } else if (checkPlantInt == 0) {
                            view.noPlant();
                        } else if (checkPlantInt == -1) {
                            view.tooHigh();
                        }
                    }
                }
                if (displayedPlant.contentEquals(model.data.name3)) {
                    if (model.data.growLight < 1) {
                        view.noItem();
                    } else {
                        checkPlantInt = model.useLight(model.data.name3);
                        if (checkPlantInt == 1) {
                            view.clearWarnings();
                            checkWeek = model.timePassed();
                            if (checkWeek) {
                                endGame();
                            }
                            update(model.data.name3);
                        } else if (checkPlantInt == 0) {
                            view.noPlant();
                        } else if (checkPlantInt == -1) {
                            view.tooHigh();
                        }
                    }
                }
                if (displayedPlant.contentEquals(model.data.name4)) {
                    if (model.data.growLight < 1) {
                        view.noItem();
                    } else {
                        checkPlantInt = model.useLight(model.data.name4);
                        if (checkPlantInt == 1) {
                            view.clearWarnings();
                            checkWeek = model.timePassed();
                            if (checkWeek) {
                                endGame();
                            }
                            update(model.data.name4);
                        } else if (checkPlantInt == 0) {
                            view.noPlant();
                        } else if (checkPlantInt == -1) {
                            view.tooHigh();
                        }
                    }
                }
                if (displayedPlant.contentEquals(model.data.name5)) {
                    if (model.data.growLight < 1) {
                        view.noItem();
                    } else {
                        checkPlantInt = model.useLight(model.data.name5);
                        if (checkPlantInt == 1) {
                            view.clearWarnings();
                            checkWeek = model.timePassed();
                            if (checkWeek) {
                                endGame();
                            }
                            update(model.data.name5);
                        } else if (checkPlantInt == 0) {
                            view.noPlant();
                        } else if (checkPlantInt == -1) {
                            view.tooHigh();
                        }
                    }
                }
                this.model.db.saveDB(this.model.data.tier1One, this.model.data.tier2One, this.model.data.tier3One, this.model.data.tier4One, this.model.data.tier5One,
                        this.model.data.tier1Two, this.model.data.tier2Two, this.model.data.tier3Two, this.model.data.tier4Two, this.model.data.tier5Two,
                        this.model.data.tier1Three, this.model.data.tier2Three, this.model.data.tier3Three, this.model.data.tier4Three, this.model.data.tier5Three,
                        this.model.data.tier1Four, this.model.data.tier2Four, this.model.data.tier3Four, this.model.data.tier4Four, this.model.data.tier5Four,
                        this.model.data.tier1Five, this.model.data.tier2Five, this.model.data.tier3Five, this.model.data.tier4Five, this.model.data.tier5Five,
                        this.model.data.growLight, this.model.data.fertiliser, this.model.data.currentWeek, this.model.data.money, this.model.data.userName);
                break;

            default:
                break;
        }
    }

    private void endGame() {
        view.endScreen();
        view.getScore(model.data.money);

        //Add to leaderboard table
        model.db.addLeaderBoard(model.data.money, model.data.userName);
    }

    private void update(String plantID) {
        int[] tierInfo = getTierInfo(plantID);

        view.updateBank(model.data.money);
        view.updateWeek(model.data.currentWeek);
        view.updatePlantName(plantID);
        view.updatePlantInfo(plantID, tierInfo[0], tierInfo[1], tierInfo[2], tierInfo[3], tierInfo[4]);
        view.updateItemInfo(model.data.fertiliser, model.data.growLight);
    }

    public int[] getTierInfo(String plantID) {
        int[] tierInfo;

        switch (plantID) {
            case "Variegated Monstera" -> {
                tierInfo = new int[]{model.data.tier1One, model.data.tier2One, model.data.tier3One, model.data.tier4One, model.data.tier5One};
                return tierInfo;
            }
            case "Adiantum Fragrans" -> {
                tierInfo = new int[]{model.data.tier1Two, model.data.tier2Two, model.data.tier3Two, model.data.tier4Two, model.data.tier5Two};
                return tierInfo;
            }
            case "Alocasia Azlanii" -> {
                tierInfo = new int[]{model.data.tier1Three, model.data.tier2Three, model.data.tier3Three, model.data.tier4Three, model.data.tier5Three};
                return tierInfo;
            }
            case "Dracaena Trifasciata" -> {
                tierInfo = new int[]{model.data.tier1Four, model.data.tier2Four, model.data.tier3Four, model.data.tier4Four, model.data.tier5Four};
                return tierInfo;
            }
            case "Calathea Leitzei" -> {
                tierInfo = new int[]{model.data.tier1Five, model.data.tier2Five, model.data.tier3Five, model.data.tier4Five, model.data.tier5Five};
                return tierInfo;
            }
            default -> {
                tierInfo = new int[]{0, 0, 0, 0, 0}; //This data should never be reached
                return tierInfo;
            }
        }
    }
}
