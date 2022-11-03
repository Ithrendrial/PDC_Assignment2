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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GameView extends JPanel implements Observer {

    //Login Screen Components
    private JLabel name;
    public JTextField enterName;
    private JButton login;

    //Main Menu Components
    private Font font;
    
    private JButton play;
    private JButton howtoMain;
    private JButton leaderboard;
    
    private JLabel background;

    //Play Screen Components
    private JComboBox<String> supplierCombobox;
    private JComboBox<String> stockCombobox;
    
    private JButton buy;
    private JButton select;
    private JButton sell;
    private JButton prop;
    private JButton fertilise;
    private JButton giveLight;
    private JButton howtoPlay;
    private JButton main;
    
    private JLabel bank;
    private JLabel week;
    private JLabel plantName;
    private JLabel tiers;
    private JLabel ferts;
    private JLabel lights;

    //Rules Screen Components
    private JButton back;
    private JLabel text;
    private JLabel pots;

    //Leaderboard Components
    private JLabel scoresList;

    
    //Constructor
    public GameView() {
        this.components();
        this.enterName();
    }

    //Instantiate Components
    public void components() {
        //Instantiate Login Screen
        login = new JButton("GO");
        name = new JLabel("Enter your name: ");
        enterName = new JTextField();

        //Instantiate Main Menu 
        font = new Font("Courier new", Font.BOLD, 14);
        
        play = new JButton("PLAY");
        howtoMain = new JButton("HOW TO PLAY");
        leaderboard = new JButton("LEADERBOARD");
        
        background = new JLabel();

        //Instantiate Play Screen
        supplierCombobox = new JComboBox();
        stockCombobox = new JComboBox();
        
        buy = new JButton("BUY");
        select = new JButton("SELECT");
        sell = new JButton("SELL");
        prop = new JButton("PROPAGATE");
        fertilise = new JButton("FERTILISE");
        giveLight = new JButton("GIVE LIGHT");
        main = new JButton("MAIN MENU");
        howtoPlay = new JButton("HOW TO PLAY");
        
        bank = new JLabel();
        week = new JLabel();
        bank.setText("Bank: $");
        bank.setFont(font);
        week.setText("Week: ");
        week.setFont(font);
        plantName = new JLabel("<html><u>You have selected:</u><b> Plant Name");
        plantName.setFont(font);
        tiers = new JLabel("""
                           <html><br><br>You have:<br>
                           n plants in tier 1,<br> 
                           n plants in tier 2, <br> 
                           n plants in tier 3, <br> 
                           n plants in tier 4, <br> 
                           n plants in tier 5, <br> 
                           n plants in tier 6, <br> 
                           n plants in tier 7, <br> 
                           n plants in tier 8, <br> 
                           n plants in tier 9, <br> 
                           and n plants in tier 10<br><br></html>""");
        tiers.setFont(font);
        ferts = new JLabel("You have n bag(s) of fertiliser.");
        ferts.setFont(font);
        lights = new JLabel("You have n growlights.");
        lights.setFont(font);

        //Instantiate Rules Screen
        back = new JButton("BACK");
        text = new JLabel();
        pots = new JLabel();

        //Instantiate Leaderboard
        scoresList = new JLabel();
    }

    //Login Screen Formation
    public void enterName() {
        JPanel entrName;

        //Layout
        entrName = new JPanel();
        GridLayout layout = new GridLayout(1, 3);
        layout.setHgap(20);
        entrName.setBorder(new EmptyBorder(250, 5, 5, 5));
        entrName.setLayout(layout);
        entrName.setBackground(Color.decode("#6eacdf"));
        
        //Add Components
        entrName.add(name);
        entrName.add(enterName);
        entrName.add(login);

        //Add to window
        super.setBackground(Color.decode("#6eacdf"));
        super.add(entrName);
    }

    //Main Menu Formation
    public void mainMenu() {
        JPanel title;
        JPanel buttons;

        //Add Title Image//
        background.setIcon(new ImageIcon("resources\\title.jpg"));

        //Add Buttons//
        buttons = new JPanel();
        GridLayout layout = new GridLayout(1, 3);
        layout.setHgap(20);

        buttons.setBorder(new EmptyBorder(5, 5, 5, 5));
        buttons.setLayout(layout);
        buttons.setBackground(Color.decode("#6eacdf"));

        buttons.add(play);
        buttons.add(howtoMain);
        buttons.add(leaderboard);

        //Frame Assembly
        title = new JPanel();
        title.add(background);
        title.setBackground(Color.decode("#6eacdf"));

        //Add to Window
        super.removeAll();
        super.setBackground(Color.decode("#6eacdf"));
        super.add(title);
        super.add(buttons);
        super.revalidate();
        super.repaint();
    }

    //Play Screen Formation
    public void play() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel header;
        JPanel combos;
        JPanel actions;
        JPanel info;
        JPanel actionButtons;
        JPanel buttons;

        //Add header image
        header = new JPanel();
        pots.setIcon(new ImageIcon("resources\\pots.png"));
        header.add(pots);
        header.setPreferredSize(new Dimension(400, 75));
        header.setBackground(Color.decode("#6eacdf"));

        //Add Comboboxes
        GridLayout layoutCombo = new GridLayout(1, 4);
        layoutCombo.setHgap(10);

        combos = new JPanel();
        combos.setBackground(Color.decode("#6eacdf"));
        combos.setPreferredSize(new Dimension(400, 50));
        combos.setBorder(new EmptyBorder(10, 0, 15, 0));
        combos.setLayout(layoutCombo);

        combos.add(supplierCombobox);
        combos.add(buy);
        combos.add(stockCombobox);
        combos.add(select);

        //Actions
        //Layout
        actions = new JPanel();
        actions.setPreferredSize(new Dimension(275, 365));
        info = new JPanel();
        actionButtons = new JPanel();
        actions.setLayout(new BoxLayout(actions, BoxLayout.Y_AXIS));

        GridLayout infoLayout = new GridLayout(1, 3);
        infoLayout.setHgap(20);
        info.setBorder(new EmptyBorder(5, 5, 5, 5));
        GridLayout actionLayout = new GridLayout(1, 4);
        actionLayout.setHgap(10);
        actionButtons.setBorder(new EmptyBorder(5, 5, 5, 5));
        actionButtons.setLayout(actionLayout);
        
        //Sction JLabels
        info.add(bank);
        info.add(new JLabel(""));
        info.add(week);

        //Action Buttons
        actionButtons.add(sell);
        actionButtons.add(prop);
        actionButtons.add(fertilise);
        actionButtons.add(giveLight);

        actions.add(info);
        actions.add(plantName);
        actions.add(tiers);
        actions.add(ferts);
        actions.add(lights);
        actions.add(actionButtons);

        //Footer Buttons
        buttons = new JPanel();
        buttons.setBorder(new EmptyBorder(20, 275, 10, 10));
        GridLayout layout = new GridLayout(1, 3);
        layout.setHgap(20);
        buttons.setLayout(layout);
        buttons.setBackground(Color.decode("#6eacdf"));

        buttons.add(main);
        buttons.add(howtoPlay);

        //Frame Formation
        panel.add(header);
        panel.add(combos);
        panel.add(actions);
        panel.add(buttons);

        //Add to Window
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
        text.setFont(font);
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
        bpanel.setLayout(new GridLayout(1, 1));
        bpanel.setBackground(Color.decode("#6eacdf"));
        bpanel.add(back);

        //Frame assembly//
        super.removeAll();
        super.add(pots, BorderLayout.NORTH);
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
        scoresList.setFont(font);
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

        //Add back button//
        bpanel = new JPanel();
        bpanel.setBorder(new EmptyBorder(20, 475, 20, 20));
        bpanel.setLayout(new GridLayout(1, 1));
        bpanel.setBackground(Color.decode("#6eacdf"));

        bpanel.add(back);

        //Frame assembly//
        scores = new JPanel();

        scores.add(pots, BorderLayout.NORTH);
        scores.add(scoresList, BorderLayout.CENTER);
        scores.add(bpanel, BorderLayout.SOUTH);
        scores.setBackground(Color.decode("#6eacdf"));

        super.removeAll();
        super.add(pots, BorderLayout.NORTH);
        super.add(scores, BorderLayout.CENTER);
        super.add(bpanel, BorderLayout.SOUTH);
        super.revalidate();
        super.repaint();
    }

    public void addActionListener(ActionListener listener) {
        //Enter Name Menu
        login.addActionListener(listener);

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
    }
    
    //update plant names
    public void updatePlantName(String plant1, String plant2, String plant3, String plant4, String plant5) {
        supplierCombobox.removeAllItems();
        stockCombobox.removeAllItems();
        
        supplierCombobox.addItem(plant1);
        supplierCombobox.addItem(plant2);
        supplierCombobox.addItem(plant3);
        supplierCombobox.addItem(plant4);
        supplierCombobox.addItem(plant5);
        
        supplierCombobox.addItem("Fertiliser");
        supplierCombobox.addItem("Growlight");
        
        stockCombobox.addItem(plant1);
        stockCombobox.addItem(plant2);
        stockCombobox.addItem(plant3);
        stockCombobox.addItem(plant4);
        stockCombobox.addItem(plant5);
        
        super.repaint();
    }

    //update player money in play 
    public void updateBank(int money) {
        bank.setText("Bank: $" + Integer.toString(money));
        super.repaint();
    }
    
    //update week count in play
    public void updateWeek(int weekNum) {
        week.setText("Week: " + Integer.toString(weekNum));
        super.repaint();
    }

    @Override
    public void update(Observable o, Object arg) {
    }

}
