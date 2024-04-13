import java.util.Scanner;

public class GameView {
    private Scanner scanner;

    public GameView() {
        scanner = new Scanner(System.in);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public int[] getUserInput() {
        int[] input = new int[4];
        String userInput = scanner.nextLine();
        if (userInput.length() != 4) {
            showMessage("Вам нужно ввести 4 цифры.");
            return getUserInput();
        }
        try {
            for (int i = 0; i < 4; i++) {
                input[i] = Integer.parseInt(userInput.substring(i, i + 1));
            }
        } catch (NumberFormatException e) {
            showMessage("Неправильный ввод. Введите четыре цифры.");
            return getUserInput();
        }
        return input;
    }
}