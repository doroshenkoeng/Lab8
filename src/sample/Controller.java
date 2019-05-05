package sample;
import javafx.scene.control.Label;

/**This class handles the event when a user presses the play button.*/
public class Controller {
    public void playGame(Label label, int cardsNumber) {
        Player player1 = new Player(cardsNumber);
        Player player2 = new Player(cardsNumber);
        CardGame game = new CardGame(player1, player2);
        game.startGame();
        int result = game.getResult();
        if (result == 1) {
            label.setText("First player won!");
        } else if (result == 2) {
            label.setText("Second player won!");
        } else {
            label.setText("Nobody won!");
        }
    }
}
