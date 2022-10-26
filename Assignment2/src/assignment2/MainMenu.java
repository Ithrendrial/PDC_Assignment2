package assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author rcox2
 */
public class MainMenu extends JFrame implements ActionListener {
   
    private JFrame main;
    private JButton play;
    private JButton howto;
    private JButton leaderboard;
    private JLabel img;
    
    public MainMenu() {
        
        //Add Title Image//
        img = new JLabel();
        img.setIcon(new ImageIcon("resources\\title.jpg"));
        
        //Add Buttons//
        JPanel buttons = new JPanel();
        GridLayout layout = new GridLayout(1,3);
        layout.setHgap(20);
        Border margin = new EmptyBorder(20, 20, 20, 20);
        
        buttons.setBorder(margin);
        buttons.setLayout(layout);
        buttons.setBackground(Color.decode("#6eacdf"));
        
        play = new JButton("PLAY");
        howto = new JButton("HOW TO PLAY");
        leaderboard = new JButton("LEADERBOARD");
        
        buttons.add(play);
        play.addActionListener(this);
        buttons.add(howto);
        howto.addActionListener(this);
        buttons.add(leaderboard);
        leaderboard.addActionListener(this);
        
        //Frame Assembly//
        main = new JFrame("Main Menu");
        
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(600,520);
        main.setVisible(true);
        main.setResizable(false);
        main.setLocationRelativeTo(null);
        
        main.add(img, BorderLayout.NORTH);
        main.add(buttons);
    }
    
    public static void main(String[] args) {
        new MainMenu();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() ==  this.howto) {
            main.dispose();
            new Rules();
        }
    }
}
