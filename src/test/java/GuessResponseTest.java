import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessResponseTest {
    @Test
    public void testCheckAttempt() {
        GuessResponse response = GuessResponse.checkAttempt(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4});
        // Проверяем, что при правильной попытке все быки
        assertEquals(4, response.bulls);
        assertEquals(0, response.cows);
        response = GuessResponse.checkAttempt(new int[]{5, 6, 7, 8}, new int[]{1, 2, 3, 4});
        // Проверяем, что при неправильной попытке нет быков и коров
        assertEquals(0, response.bulls);
        assertEquals(0, response.cows);
    }

}