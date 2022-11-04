package assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GameView extends JPanel implements Observer {
    //Reusable grids
    private GridLayout layout1x1 = new GridLayout(1, 1);
    private GridLayout layout1x2 = new GridLayout(1, 2);
    private GridLayout layout1x3 = new GridLayout(1, 3);
    private GridLayout layout1x4 = new GridLayout(1, 4);
    
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
    private JLabel warning;

    //Rules Screen Components
    private JButton back;
    private JLabel text;
    private JLabel pots;

    //Leaderboard Components
    private JLabel scoresList;

    //End Screen Components
    private JLabel endStatement;
    private JLabel youGot;
    
    //Constructor
    public GameView() {
        this.components();
        this.enterName();
    }

    //Instantiate Components
    public void components() {
        font = new Font("Courier new", Font.BOLD, 14);
        
        //Instantiate Login Screen
        login = new JButton("GO");
        name = new JLabel("Enter your name: ");
        name.setFont(font);
        enterName = new JTextField();

        //Instantiate Main Menu 
        play = new JButton("PLAY");
        howtoMain = new JButton("HOW TO PLAY");
        leaderboard = new JButton("PREVIOUS GAMES");
        
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
        bank.setFont(font);
        week.setFont(font);
        plantName = new JLabel("<html><u>You have selected:</u> ______");
        plantName.setFont(font);
        tiers = new JLabel("<html><br><br>You have:<br>"
                           + "_ plant(s) in tier 1,<br>"
                           + "_ plant(s) in tier 2, <br>" 
                           + "_ plant(s) in tier 3, <br>" 
                           + "_ plant(s) in tier 4, <br>" 
                           + "_ plant(s) in tier 5. <br><br></html>");
        tiers.setFont(font);
        ferts = new JLabel("You have _ bag(s) of fertiliser.");
        ferts.setFont(font);
        lights = new JLabel("<html>You have _ growlights.<br><br></html>");
        lights.setFont(font);
        warning = new JLabel("Filler");
        warning.setFont(font);
        warning.setForeground(Color.decode("#6eacdf"));

        //Instantiate Rules Screen
        back = new JButton("BACK");
        text = new JLabel();
        pots = new JLabel();

        //Instantiate Leaderboard
        scoresList = new JLabel();
        
        //Instantiate End Screen
        endStatement = new JLabel("Game Over!");
        endStatement.setFont(font);
        youGot = new JLabel("");
        youGot.setFont(font);
    }

    //Login Screen Formation
    public void enterName() {
        JPanel entrName;

        //Layout
        entrName = new JPanel();
        layout1x3.setHgap(20);
        entrName.setBorder(new EmptyBorder(250, 5, 5, 5));
        entrName.setLayout(layout1x3);
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

        buttons.setBorder(new EmptyBorder(5, 5, 5, 5));
        buttons.setLayout(layout1x3);
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
        JPanel comboLabels;
        JPanel combos;
        JPanel actions;
        JPanel weeklyInfo;
        JPanel stockInfo;
        JPanel actionButtons;
        JPanel buttons;
        JPanel warningPanel;

        //Add header image
        header = new JPanel();
        pots.setIcon(new ImageIcon("resources\\pots.png"));
        header.add(pots);
        header.setPreferredSize(new Dimension(400, 75));
        header.setBackground(Color.decode("#6eacdf"));

        
        //Add Comboboxes
        comboLabels = new JPanel();
        combos = new JPanel();
        layout1x4.setHgap(10);
        comboLabels.setLayout(layout1x4);
        combos.setLayout(layout1x4);
        
        comboLabels.setBackground(Color.decode("#6eacdf"));
        comboLabels.setPreferredSize(new Dimension(400, 25));
        comboLabels.setBorder(new EmptyBorder(5, 0, 0, 0));
        
        combos.setBackground(Color.decode("#6eacdf"));
        combos.setPreferredSize(new Dimension(400, 50));
        combos.setBorder(new EmptyBorder(10, 0, 5, 0));

        comboLabels.add(new JLabel("Supplier:"));
        comboLabels.add(new JLabel(""));
        comboLabels.add(new JLabel("Inventory:"));
        comboLabels.add(new JLabel(""));
        
        combos.add(supplierCombobox);
        combos.add(buy);
        combos.add(stockCombobox);
        combos.add(select);

        //Actions
        //Layout
        actions = new JPanel(); //foundation panel
        weeklyInfo = new JPanel(); //subpanel top
        stockInfo = new JPanel(); //subpanel middle
        actionButtons = new JPanel(); //subpanel bottom
        actions.setPreferredSize(new Dimension(275, 315));
        actions.setLayout(new BoxLayout(actions, BoxLayout.Y_AXIS));

        //Weekly Info
        weeklyInfo.setBorder(new EmptyBorder(5, 15, 5, 5));
        weeklyInfo.setLayout(layout1x2);
        weeklyInfo.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        bank.setHorizontalAlignment(SwingConstants.LEFT);
        week.setHorizontalAlignment(SwingConstants.LEFT);
        weeklyInfo.add(bank);
        weeklyInfo.add(week);
        
        //Stock 
        stockInfo.setLayout(new BoxLayout(stockInfo, BoxLayout.Y_AXIS));
        stockInfo.setBorder(new EmptyBorder(5, 10, 5, 5));
        stockInfo.setAlignmentX(Component.RIGHT_ALIGNMENT);
        
        stockInfo.add(plantName);
        stockInfo.add(tiers);
        stockInfo.add(ferts);
        stockInfo.add(lights);
        
        //Action Buttons
        
        actionButtons.setBorder(new EmptyBorder(5, 5, 5, 5));
        actionButtons.setLayout(layout1x4);
        
        actionButtons.add(sell);
        actionButtons.add(prop);
        actionButtons.add(fertilise);
        actionButtons.add(giveLight); 

        actions.add(weeklyInfo);
        actions.add(stockInfo);
        actions.add(actionButtons);
        
        //Warning Panel
        warningPanel = new JPanel();
        warningPanel.setBackground(Color.decode("#6eacdf"));
        warningPanel.add(warning);

        //Footer Buttons
        buttons = new JPanel();
        buttons.setBorder(new EmptyBorder(20, 275, 10, 10));
        buttons.setLayout(layout1x3);
        buttons.setBackground(Color.decode("#6eacdf"));

        buttons.add(main);
        buttons.add(howtoPlay);

        //Frame Formation
        panel.add(header);
        panel.add(comboLabels);
        panel.add(combos);
        panel.add(actions);
        panel.add(warningPanel);
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

                    If you use a growlight, which can also be bought from the<br>
                    supplier, then one of your highest tier plants (excluding those<br>
                    in the highest tier) will increase by one tier. The same rules<br>
                    apply to fertiliser, but it will increase by two tiers and<br>
                    excludes the two highest tiers.<br><br>
                    
                    If you propagate, one of your plants in the highest tier will be<br>
                    split into two plants of the previous tier.<br><br>
                     
                    Happy Plant Keeping!<br><br><br><br></html>""");

        //Add back button//
        bpanel = new JPanel();
        bpanel.setBorder(new EmptyBorder(20, 475, 20, 20));
        bpanel.setLayout(layout1x1);
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
                           <html><b><center><u>10 Previous Games</u></center><br><br>
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
        bpanel.setLayout(layout1x1);
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
    
    public void endScreen() {
        JPanel end;

        //Layout
        end = new JPanel();
        end.setBorder(new EmptyBorder(250, 5, 5, 5));
        end.setLayout(new GridLayout(2,1));
        end.setBackground(Color.decode("#6eacdf"));
        
        //Add Components
        end.add(endStatement);
        end.add(youGot);

        //Add to window
        super.removeAll();
        super.setBackground(Color.decode("#6eacdf"));
        super.add(end);
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
        sell.addActionListener(listener);
        prop.addActionListener(listener);
        fertilise.addActionListener(listener);
        giveLight.addActionListener(listener);
        main.addActionListener(listener);
        howtoPlay.addActionListener(listener);
        howtoPlay.setActionCommand("playRules");
    }
    
    //Get selected value in supplier combobox
    public Object getSupplierValue() {
        Object name = supplierCombobox.getSelectedItem();
        return name;
    }
    
    //Get selected value in stock combobox
        public Object getStockValue() {
        Object name = stockCombobox.getSelectedItem();
        return name;
    }
    
    //Update plant names in the Comboboxes
    public void updatePlantNameCombo(String plant1, String plant2, String plant3, String plant4, String plant5) {
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
    
    //Robustness Warnings//
    //Clear displayed warnings
    public void clearWarnings() {
        warning.setForeground(Color.decode("#6eacdf")); //Changing colour because setting to empty moves buttons to fill empty space
    }
    //Warning for insufficient funds
    public void noMoney() {
        warning.setText("You do not have enough money to do this.");
        warning.setForeground(Color.decode("#c30000"));
        super.repaint();
    }
    
    //Warning for no plants to act on
    public void noPlant() {
        warning.setText("You do not own this plant.");
        warning.setForeground(Color.decode("#c30000"));
        super.repaint();
    }
    
    //No Item
    public void noItem() {
        warning.setText("You do not own this item.");
        warning.setForeground(Color.decode("#c30000"));
        super.repaint();
    }
    
    //Warning for plant tier too low
    public void tooLow() {
        warning.setText("You cannot propagate a tier 1 plant.");
        warning.setForeground(Color.decode("#c30000"));
        super.repaint();
    }
        
    //Warning for plant tier too high
    public void tooHigh() {
        warning.setText("Your plant's tier is too high to complete this action.");
        warning.setForeground(Color.decode("#c30000"));
        super.repaint();
    }
    
    //Update plant name when selected
    public void updatePlantName(String plant) {
        plantName.setText("<html><u>You have selected:</u> <b>" + plant);
        super.repaint();
    }
    
    //Update plant info
    public void updatePlantInfo(String plant, int t1, int t2, int t3, int t4, int t5) {
        tiers.setText("<html>You have:<br>"
                    + t1 + " plant(s) in tier 1,<br>"
                    + t2 + " plant(s) in tier 2, <br>" 
                    + t3 + " plant(s) in tier 3, <br>" 
                    + t4 + " plant(s) in tier 4, <br>" 
                    + t5 + " plant(s) in tier 5. <br><br></html>");

        super.repaint();
    }
    
    //Update item info 
    public void updateItemInfo(int fertiliser, int growlights) {
        ferts.setText("You have " + fertiliser + " bag(s) of fertiliser.");
        lights.setText("<html>You have " + growlights + " growlight(s).<br><br></html>");
        super.repaint();  
    }
    
    //Update player money in play 
    public void updateBank(int money) {
        bank.setText("Bank: $" + Integer.toString(money));
        super.repaint();
    }
    
    //Update week count in play
    public void updateWeek(int weekNum) {
        week.setText("Week: " + Integer.toString(weekNum));
        super.repaint();
    }
    
    //Previous Games Display
    public void displayScores(String[] scores) {
        
        scoresList.setText("<html><b><center><u>Ten Most Recent Games</u></center><br><br>"
                   + "1. " + scores[0] + "<br><br>"
                   + "2. " + scores[1] + "<br><br>"
                   + "3. " + scores[2] + "<br><br>"
                   + "4. " + scores[3] + "<br><br>"
                   + "5. " + scores[4] + "<br><br>"
                   + "6. " + scores[5] + "<br><br>"
                   + "7. " + scores[6] + "<br><br>"
                   + "8. " + scores[7] + "<br><br>"
                   + "9. " + scores[8] + "<br><br>"
                   + "10. " + scores[9] + "<br></html>");
        super.repaint();
    }
    
    //End Screen Score
    public void getScore(int score) {
        youGot.setText("Your final balance was: $" + Integer.toString(score));
        super.repaint();
    }

    @Override
    public void update(Observable o, Object arg) {
    }

}
