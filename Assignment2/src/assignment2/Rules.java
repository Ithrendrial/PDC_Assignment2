package assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
public class Rules extends JFrame implements ActionListener{
    
    JFrame rules;
    JPanel bpanel;
    JButton back;
    JLabel text;
    JLabel img;
    
    public Rules() {
        
        //Add image//
        img = new JLabel();
        img.setIcon(new ImageIcon("resources\\pots.png"));
        
        //Add Text//
        text = new JLabel();
        text.setBackground(Color.decode("#6eacdf"));
        text.setOpaque(true);

        text.setText("<html><b><center><u>HOW TO PLAY</u><br><br>"
                + "In this game you can buy various plant species from a supplier. "
                + "When you buy a plant, it will be a tier 1 plant, meaning it has one leaf."
                + "<br><br>Each plant species has a value mulitiplier which determines the selling worth "
                + "(e.g. if the multiplier is 30 and you sell a tier 2 plant, you will earn 2 x 30 = $60)."
                + "<br><br>Every week that passes, there is a 50% chance that one of your plants will increase by one tier. "
                + "<br><br> If you use a growlight, which can also be bought from the supplier, then one of your highest "
                + "tier plants (excluding those in the highest tier) will increase by one tier. The same rules apply to fertiliser,"
                + " but it will increase by two tiers and excludes the two highest tiers. <br><br>If you propagate, one of your plants"
                + " in the highest tier will be split into two plants of the previous tier.<br><br>Happy Plant Keeping!</html>");
        
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
        
        back = new JButton("BACK");
        bpanel.add(back);
        back.addActionListener(this);
        
        //Frame assembly//
        rules = new JFrame("How to Play");
        
        rules.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rules.setVisible(true);
        rules.setResizable(false);
        rules.setSize(600,600);
        rules.setBackground(Color.decode("#6eacdf"));
        rules.setLocationRelativeTo(null);
        
        rules.add(img, BorderLayout.NORTH);
        rules.add(text, BorderLayout.CENTER);
        rules.add(bpanel, BorderLayout.SOUTH);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() ==  this.back) {
            rules.dispose();
            new MainMenu();
        }
    }
}
