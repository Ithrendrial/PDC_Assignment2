package assignment2;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        GameView gameView = new GameView();
        GameModel gameModel = new GameModel();

        JFrame window = new JFrame("The Plant Shop");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(gameView);
        window.setSize(600, 600);
        window.setVisible(true);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        GameController controller = new GameController(gameView, gameModel, window);
        gameModel.addObserver(gameView);
    }
}
