
public class GameController {
    private GameModel gameModel;
    private GameView gameView;

    public GameController(GameModel gameModel, GameView gameView) {
        this.gameModel = gameModel;
        this.gameView = gameView;
    }

    public void startGame() {
        boolean endOfGame = false;
        while (!endOfGame) {
            gameView.showMessage("Введите число:");
            int[] attempt = gameView.getUserInput();
            int[] result = gameModel.checkAttempt(attempt);
            gameView.showMessage("Результат: " + result[0] + " коров и " + result[1] + " быков.");
            if (result[1] == 4) {
                endOfGame = true;
                gameView.showMessage("Вы угадали число!");
            }
        }
    }
}
