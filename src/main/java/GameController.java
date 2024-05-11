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
            GuessResponse result = gameModel.checkAttempt(attempt);
            gameView.showMessage("Результат: " + result.cows + " коров и " + result.bulls + " быков.");
            if (result.bulls == 4) {
                endOfGame = true;
                gameView.showMessage("Вы угадали число!");
            }
        }
    }
}
