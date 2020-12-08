package baseball;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import utils.RandomUtils;

public class BaseBallGame {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;
    private static final int ANSWER_LENGTH = 3;
    private static final String RESTART = "1";
    private static final String GAME_END = "2";
    private final Scanner scanner;

    BaseBallGame(Scanner scanner) {
        this.scanner = scanner;
    }


    public void play() {
        ArrayList<Integer> answer = createAnswer();
        Rule rule = new Rule(answer);

        while (!rule.isThreeStrike()) {
            InputView inputView = new InputView(scanner);
            rule.initializeBallCount();
            rule.judge(inputView.getUserInput());
            rule.printResult();
        }

        boolean restart = askRestartOrEndGame(scanner);

        if (restart) {
            play();
        }
    }

    private boolean askRestartOrEndGame(Scanner scanner) {
        String restartOrNot = scanner.nextLine();
        if (!(restartOrNot.equals(RESTART) || restartOrNot.equals(GAME_END))) {
            throw new IllegalArgumentException();
        }
        if (restartOrNot.equals(RESTART)) {
            return true;
        }
        return false;
    }

    public ArrayList<Integer> createAnswer() {
        LinkedHashSet<Integer> answer = new LinkedHashSet<>();

        while (answer.size() < ANSWER_LENGTH) {
            answer.add(getRandom());
        }
        return new ArrayList<Integer>(answer);
    }

    private int getRandom() {
        return RandomUtils.nextInt(MIN_NUM, MAX_NUM);
    }
}
