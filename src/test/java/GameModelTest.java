import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameModelTest {
    @Test
    public void testCheckAttempt_AllCorrect() {
        GameModel game = new GameModel();
        game.setSecretDigits(new int[]{1, 2, 3, 4});
        int[] attempt = {1, 2, 3, 4};
        GuessResponse response = game.checkAttempt(attempt);
        assertEquals(4, response.bulls);
        assertEquals(0, response.cows);
    }

    @Test
    public void testCheckAttempt_NoneCorrect() {
        GameModel game = new GameModel();
        game.setSecretDigits(new int[]{1, 2, 3, 4});
        int[] attempt = {5, 6, 7, 8};
        GuessResponse response = game.checkAttempt(attempt);
        assertEquals(0, response.bulls);
        assertEquals(0, response.cows);
    }

    @Test
    public void testCheckAttempt_SomeCorrect() {
        GameModel game = new GameModel();
        game.setSecretDigits(new int[]{1, 2, 3, 4});
        int[] attempt = {1, 5, 6, 4};
        GuessResponse response = game.checkAttempt(attempt);
        assertEquals(2, response.bulls);
        assertEquals(0, response.cows);
    }
}