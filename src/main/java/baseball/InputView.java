package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_GUESS_MESSAGE = "숫자를 입력하세요: ";
    private static final int VALID_LENGTH = 3;
    private final Scanner scanner;
    private final String preUserInput;

    InputView(Scanner scanner) {
        this.scanner = scanner;
        preUserInput = getInput();
        validateDigit();
        validateLength();
        validateRedundancy();
    }

    private String getInput() {
        System.out.print(INPUT_GUESS_MESSAGE);
        return scanner.nextLine();
    }

    public ArrayList<Integer> getUserInput() {
        ArrayList<Integer> userInput = new ArrayList<>();
        for (int i = 0; i < VALID_LENGTH; i++) {
            userInput.add(Character.getNumericValue(preUserInput.charAt(i)));
        }
        return userInput;
    }

    private void validateDigit() {
        try {
            Integer.parseInt(preUserInput);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLength() {
        if (preUserInput.length() != VALID_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRedundancy() {
        HashSet<Character> test = new HashSet<>();
        for (int i = 0; i < preUserInput.length(); i++) {
            test.add(preUserInput.charAt(i));
        }
        if (test.size() != VALID_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
