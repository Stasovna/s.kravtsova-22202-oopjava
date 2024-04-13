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

    public int[] checkAttempt(int[] attempt) {
        int[] result = new int[2]; //0-коровы 1-быки
        boolean[] checked = new boolean[4];
        for (int i = 0; i < 4; i++) {
            if (attempt[i] == secretDigits[i]) {
                result[1]++;
                checked[i] = true;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (!checked[i]) {
                for (int j = 0; j < 4; j++) {
                    if (attempt[i] == secretDigits[j]) {
                        result[0]++;
                        break;
                    }
                }
            }
        }
        return result;
    }
}