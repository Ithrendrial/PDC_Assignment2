package assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


/**
 *
 * @author rcox2
 */
public class GameView extends JPanel implements Observer {
    //Main Menu parts
    private JButton play;
    private JButton howto;
    private JButton leaderboard;
    private JLabel background;
    
    //Rules parts
    private JButton back;
    private JLabel text;
    private JLabel pots;
    
    
    public GameView(){
        this.components();
        this.mainMenu();
    }
    
    //initiate components
    public void components(){ 
        //Instantiate Main Menu 
        play = new JButton("PLAY");
        howto = new JButton("HOW TO PLAY");
        leaderboard = new JButton("LEADERBOARD");
        background = new JLabel();
        
        //Instantiate Rules
        back = new JButton("BACK");
        text = new JLabel();
        pots = new JLabel();
    }
        
    public void mainMenu() {
        JPanel main;
        JPanel buttons;
        
        //Add Title Image//
        background.setIcon(new ImageIcon("resources\\title.jpg"));
        
        //Add Buttons//
        buttons = new JPanel();
        GridLayout layout = new GridLayout(1,3);
        layout.setHgap(20);
        Border margin = new EmptyBorder(5, 5, 5, 5);
        
        buttons.setBorder(margin);
        buttons.setLayout(layout);
        buttons.setBackground(Color.decode("#6eacdf"));
        
        buttons.add(play);
        buttons.add(howto);
        buttons.add(leaderboard);
        
        //Frame Assembly//
        main = new JPanel();
        main.add(background);
        main.setBackground(Color.decode("#6eacdf"));
        
        super.removeAll();
        super.setBackground(Color.decode("#6eacdf"));
        super.add(main);
        super.add(buttons);
        super.revalidate();
        super.repaint();
    }
    
    public void rules() {
        JPanel bpanel;
        JPanel rules;
        //Add image//
        pots.setIcon(new ImageIcon("resources\\pots.png"));
        pots.setBackground(Color.decode("#6eacdf"));
        
        //Add Text//
        text.setBackground(Color.decode("#6eacdf"));
        text.setOpaque(true);

        text.setText("<html><b><center><u>HOW TO PLAY</u><br><br>"
                + "In this game you can buy various plant species from a supplier.<br> "
                + "When you buy a plant, it will be a tier 1 plant, meaning it has<br>one leaf."
                + "<br><br>Each plant species has a value mulitiplier which determines the<br>selling worth "
                + "(e.g. if the multiplier is 30 and you sell a tier 2<br>plant, you will earn 2 x 30 = $60)."
                + "<br><br>Every week that passes, there is a 50% chance that one of your<br>plants will increase by one tier. "
                + "<br><br> If you use a growlight, which can also be bought from the<br>supplier, then one of your highest "
                + "tier plants (excluding those<br>in the highest tier) will increase by one tier. The same rules<br>apply to fertiliser,"
                + " but it will increase by two tiers and<br>excludes the two highest tiers. <br><br>If you propagate, one of your plants"
                + " in the highest tier will be<br>split into two plants of the previous tier.<br><br>Happy Plant Keeping!</html>");
        
        text.setHorizontalTextPosition(JLabel.CENTER);
        text.setForeground(Color.decode("#223845"));
        text.setFont(new Font("Courier new", Font.BOLD, 14));
        
        //Add back button//
        bpanel = new JPanel();
        GridLayout layout = new GridLayout(1,1);
        Border margin = new EmptyBorder(20, 475, 20, 20);
        
        bpanel.setBorder(margin);
        bpanel.setLayout(layout);
        bpanel.setBackground(Color.decode("#6eacdf"));
        
        bpanel.add(back);
        
        //Frame assembly//
        rules = new JPanel();
        
        rules.add(pots, BorderLayout.NORTH);
        rules.add(text, BorderLayout.CENTER);
        rules.add(bpanel, BorderLayout.SOUTH);
        rules.setBackground(Color.decode("#6eacdf"));
        
        super.removeAll();
        super.setBackground(Color.decode("#6eacdf"));
        super.add(pots,BorderLayout.NORTH);
        super.add(rules, BorderLayout.CENTER);
        super.add(bpanel, BorderLayout.SOUTH);
        super.revalidate();
        super.repaint();
    }
    
    public void addActionListener(ActionListener listener){
        play.addActionListener(listener);
        howto.addActionListener(listener);
        leaderboard.addActionListener(listener);
        back.addActionListener(listener);
    }
    
    @Override
    public void update(Observable o, Object arg){}
    
}
