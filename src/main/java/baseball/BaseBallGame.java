package baseball;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import utils.RandomUtils;

public class BaseBallGame {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;
    private static final int ANSWER_LENGTH = 3;


    private Scanner scanner;
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
