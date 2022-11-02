package assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


/**
 *
 * @author rcox2
 */
public class GameView extends JPanel implements Observer {
    //Main Menu parts
    private JButton play;
    private JButton howtoMain;
    private JButton leaderboard;
    private JLabel background;
    
    //Play parts
    private JComboBox<String> supplierCombobox;
    private JComboBox<String> stockCombobox;
    private JButton buy;
    private JButton select;
    private JLabel bank;
    private JButton howtoPlay;
    private JButton save;
    private JButton main;
    
    //Rules parts
    private JButton back;
    private JLabel text;
    private JLabel pots;
    
    //Leaderboard parts
    private JLabel scoresList;
    
    
    public GameView(){
        this.components();
        this.mainMenu();
    }
    
    //initiate components
    public void components(){ 
        //Instantiate Main Menu 
        play = new JButton("PLAY");
        howtoMain = new JButton("HOW TO PLAY");
        leaderboard = new JButton("LEADERBOARD");
        background = new JLabel();
        
        //Instantiate Play
        supplierCombobox = new JComboBox();
        supplierCombobox.addItem("Plant 1");
        supplierCombobox.addItem("Plant 2");
        supplierCombobox.addItem("Plant 3");
        supplierCombobox.addItem("Plant 4");
        supplierCombobox.addItem("Plant 5");
        supplierCombobox.addItem("Fertiliser");
        supplierCombobox.addItem("Growlight");
        
        stockCombobox = new JComboBox();
        stockCombobox.addItem("Plant 1");
        stockCombobox.addItem("Plant 2");
        stockCombobox.addItem("Plant 3");
        stockCombobox.addItem("Plant 4");
        stockCombobox.addItem("Plant 5");
        
        buy = new JButton("BUY");
        select = new JButton("SELECT");
        bank = new JLabel();
        bank.setText("Bank: $1,000,000");
        bank.setFont(new Font("Courier new", Font.BOLD, 14));
        main = new JButton("MAIN MENU");
        howtoPlay = new JButton("HOW TO PLAY");
        save = new JButton("SAVE");
        
        
        //Instantiate Rules
        back = new JButton("BACK");
        text = new JLabel();
        pots = new JLabel();
        
        //Instantiate Leaderboard
        scoresList = new JLabel();
    }
        
    public void mainMenu() {
        JPanel title;
        JPanel buttons;
        
        //Add Title Image//
        background.setIcon(new ImageIcon("resources\\title.jpg"));
        
        //Add Buttons//
        buttons = new JPanel();
        GridLayout layout = new GridLayout(1,3);
        layout.setHgap(20);

        buttons.setBorder(new EmptyBorder(5, 5, 5, 5));
        buttons.setLayout(layout);
        buttons.setBackground(Color.decode("#6eacdf"));
        
        buttons.add(play);
        //play.setEnabled(false); 
        buttons.add(howtoMain);
        buttons.add(leaderboard);
        
        //Frame Assembly//
        title = new JPanel();
        title.add(background);
        title.setBackground(Color.decode("#6eacdf"));
        
        super.removeAll();
        super.setBackground(Color.decode("#6eacdf"));
        super.add(title);
        super.add(buttons);
        super.revalidate();
        super.repaint();
    }
    
    public void play() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JPanel header;
        JPanel combos;
        JPanel actions;
        JPanel buttons;
        
        //Add image//
        header = new JPanel();
        pots.setIcon(new ImageIcon("resources\\pots.png"));
        header.add(pots);
        header.setPreferredSize(new Dimension(400,75));
        header.setBackground(Color.decode("#6eacdf"));
        
        //Combos
        GridLayout layoutCombo = new GridLayout(1,5);
        layoutCombo.setHgap(10);
        
        combos = new JPanel();
        combos.setBackground(Color.decode("#6eacdf"));
        combos.setPreferredSize(new Dimension(400,50));
        combos.setBorder(new EmptyBorder(10, 15, 15, 15));
        combos.setLayout(layoutCombo);
        
        combos.add(supplierCombobox);
        combos.add(buy);
        combos.add(new JLabel(""));  //Empty JLabel to act as an empty grid cell
        combos.add(stockCombobox);
        combos.add(select);
        
        //Actions
        actions = new JPanel();
        actions.setPreferredSize(new Dimension(400,360));
        
        //Buttons
        buttons = new JPanel();
        buttons.setBorder(new EmptyBorder(20, 150, 10, 10));
        GridLayout layout = new GridLayout(1,3);
        layout.setHgap(20);
        buttons.setLayout(layout);
        buttons.setBackground(Color.decode("#6eacdf"));
        
        buttons.add(main);
        buttons.add(howtoPlay);
        buttons.add(save);
        
        panel.add(header);
        panel.add(combos);
        panel.add(actions);
        panel.add(buttons);
        
        super.removeAll();
        super.setBackground(Color.decode("#6eacdf"));
        super.add(panel);
        super.revalidate();
        super.repaint();
    }
    
    public void rules() {
        JPanel bpanel;
        JPanel rules;
        
        //Add image//
        pots.setIcon(new ImageIcon("resources\\pots.png"));
        
        //Add Text//
        rules = new JPanel();
        rules.add(text);
        rules.setBackground(Color.decode("#6eacdf"));
        
        text.setBackground(Color.decode("#6eacdf"));
        text.setOpaque(true);
        text.setFont(new Font("Courier new", Font.BOLD, 14));
        text.setText("""
                    <html><b><center><u>HOW TO PLAY</u><br><br>
                    In this game you can buy various plant species from a supplier.<br>
                    When you buy a plant, it will be a tier 1 plant, meaning it has<br>
                    one leaf.<br><br>
                    
                    Each plant species has a value mulitiplier which determines the<br>
                    selling worth (e.g. if the multiplier is 30 and you sell a tier 2<br>
                    plant, you will earn 2 x 30 = $60).<br><br>
                     
                    Every week that passes, there is a 50% chance that one of your<br>
                    plants will increase by one tier.<br><br>
                     
                    If you use a growlight, which can also be bought from the<br>
                    supplier, then one of your highest tier plants (excluding those<br>
                    in the highest tier) will increase by one tier. The same rules<br>
                    apply to fertiliser, but it will increase by two tiers and<br>
                    excludes the two highest tiers.<br><br>
                    
                    If you propagate, one of your plants in the highest tier will be<br>
                    split into two plants of the previous tier.<br><br>
                     
                    Happy Plant Keeping!</html>""");
        
        //Add back button//
        bpanel = new JPanel();
        bpanel.setBorder(new EmptyBorder(20, 475, 20, 20));
        bpanel.setLayout(new GridLayout(1,1));
        bpanel.setBackground(Color.decode("#6eacdf"));
        bpanel.add(back);
        
        //Frame assembly//
        super.removeAll();
        super.add(pots,BorderLayout.NORTH);
        super.add(rules, BorderLayout.CENTER);
        super.add(bpanel, BorderLayout.SOUTH);
        super.revalidate();
        super.repaint();
    }
    
    public void leaderboard() {
        JPanel bpanel;
        JPanel scores;
        
        //Add image//
        pots.setIcon(new ImageIcon("resources\\pots.png"));
        
        //Add Text//
        scoresList.setBackground(Color.decode("#6eacdf"));
        scoresList.setOpaque(true);
        scoresList.setText("""
                           <html><b><center><u>LEADERBOARD</u></center><br><br>
                           1. Person 1, score<br><br>
                           2. Person 2, score<br><br>
                           3. Person 3, score<br><br>
                           4. Person 4, score<br><br>
                           5. Person 5, score<br><br>
                           6. Person 6, score<br><br>
                           7. Person 7, score<br><br>
                           8. Person 8, score<br><br>
                           9. Person 9, score<br><br>
                           10. Person 10, score <br></html>""");
        
        scoresList.setFont(new Font("Courier new", Font.BOLD, 14));
        
        //Add back button//
        bpanel = new JPanel();
        bpanel.setBorder(new EmptyBorder(20, 475, 20, 20));
        bpanel.setLayout(new GridLayout(1,1));
        bpanel.setBackground(Color.decode("#6eacdf"));
        
        bpanel.add(back);
        
        //Frame assembly//
        scores = new JPanel();
        
        scores.add(pots, BorderLayout.NORTH);
        scores.add(scoresList, BorderLayout.CENTER);
        scores.add(bpanel, BorderLayout.SOUTH);
        scores.setBackground(Color.decode("#6eacdf"));
        
        super.removeAll();
        super.add(pots,BorderLayout.NORTH);
        super.add(scores, BorderLayout.CENTER);
        super.add(bpanel, BorderLayout.SOUTH);
        super.revalidate();
        super.repaint();
        
    }
    
    public void addActionListener(ActionListener listener){
        //Main Menu Actions
        play.addActionListener(listener);
        howtoMain.addActionListener(listener);
        howtoMain.setActionCommand("mainRules");
        leaderboard.addActionListener(listener);
        
        //Rules/Leaderboard Actions
        back.addActionListener(listener);
        
        //Play Actions
        buy.addActionListener(listener);
        select.addActionListener(listener);
        main.addActionListener(listener);
        howtoPlay.addActionListener(listener);
        howtoPlay.setActionCommand("playRules");
        save.addActionListener(listener);
    }
    
    @Override
    public void update(Observable o, Object arg){}
    
}
