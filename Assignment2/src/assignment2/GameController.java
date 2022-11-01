/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
        public GameController(GameView view, GameModel model, JFrame frame){
        this.view = view;
        this.frame = frame;
        
        this.view.addActionListener(this);
    }
        
    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        Object source = e.getSource();
        
        switch(command){
            case "PLAY":
                break;
            case "HOW TO PLAY":
                view.rules();
                break;
            case "LEADERBOARD":
                break;
            case "BACK":
                view.mainMenu();
                break;
            default:
                break;
        }
        
    }
}
