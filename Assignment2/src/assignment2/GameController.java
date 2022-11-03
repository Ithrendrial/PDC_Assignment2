package assignment2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author rcox299
 */
public class GameController implements ActionListener{
    public GameView view;
    public GameModel model;
    private JFrame frame;
    private boolean origin;
    
        public GameController(GameView view, GameModel model, JFrame frame){
        this.view = view;
        this.frame = frame;
        this.model = model;
        
        this.view.addActionListener(this);
        
        this.view.addActionListener(this);
    }
        
    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        
        switch(command){
            case "GO":
                view.mainMenu();
                break;
            case "PLAY":
                view.play();
                //model.test();
                break;
            case "mainRules":
                origin = true;
                view.rules();
                break;
            case "LEADERBOARD":
                view.leaderboard();
                break;
            case "BACK":
                if (origin)
                    view.mainMenu();
                else
                    view.play();
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
