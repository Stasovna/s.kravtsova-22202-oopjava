import java.util.Random;

public class GameModel {
    private int[] secretDigits;

    public GameModel() {
        generateNumber();
    }

    private void generateNumber() {
        Random random = new Random();
        secretDigits = new int[4];
        boolean[] used = new boolean[10];
        for (int i = 0; i < 4; i++) {
            int digit;
            do {
                digit = random.nextInt(10);
            } while (used[digit]);
            secretDigits[i] = digit;
            used[digit] = true;
        }
    }

    public GuessResponse checkAttempt(int[] attempt) {
        return GuessResponse.checkAttempt(attempt, secretDigits);
    }
    public void setSecretDigits(int[] digits) {
        this.secretDigits = digits;
    }
}