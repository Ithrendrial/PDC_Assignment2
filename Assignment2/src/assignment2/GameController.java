package assignment2;

import static assignment2.PlantAction.ANSI_RED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author rcox299
 */
public class GameController implements ActionListener {

    public GameView view;
    public GameModel model;
    private JFrame frame;
    private boolean origin;
    Inventory userInventory;

    public GameController(GameView view, GameModel model, JFrame frame) {
        this.view = view;
        this.frame = frame;
        this.model = model;
        this.view.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "GO":
                String username = this.view.enterName.getText();
                this.model.checkName(username);
                view.mainMenu();
                break;
            case "PLAY":
                view.play();
                view.updateBank(model.data.money);
                view.updateWeek(model.data.currentWeek);
                view.updatePlantName(model.data.name1, model.data.name2, model.data.name3, model.data.name4, model.data.name5);
                break;
            case "mainRules":
                origin = true;
                view.rules();
                break;
            case "LEADERBOARD":
                view.leaderboard();
                origin = true;
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
            case "SAVE":
                break;
            default:
                break;
        }

    }
}
