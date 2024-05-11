import org.junit.jupiter.api.Test;
class GameControllerTest {
    @Test
    public void testStartGame() {
        GameModel gameModel = new GameModel();
        GameView gameView = new GameView();
        GameController gameController = new GameController(gameModel, gameView);
    }

}