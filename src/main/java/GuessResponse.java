public class GuessResponse {
    int cows;
    int bulls;

    public GuessResponse(int cows, int bulls) {
        this.cows = cows;
        this.bulls = bulls;
    }

    public static GuessResponse checkAttempt(int[] attempt, int[] secretDigits) {
        int cows = 0;
        int bulls = 0;
        boolean[] checked = new boolean[4];
        for (int i = 0; i < 4; i++) {
            if (attempt[i] == secretDigits[i]) {
                bulls++;
                checked[i] = true;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (!checked[i]) {
                for (int j = 0; j < 4; j++) {
                    if (attempt[i] == secretDigits[j]) {
                        cows++;
                        break;
                    }
                }
            }
        }
        return new GuessResponse(cows, bulls);
    }
}
