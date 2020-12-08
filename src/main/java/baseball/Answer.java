package baseball;

import java.util.LinkedHashSet;
import utils.RandomUtils;

public class Answer {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;
    private static final int ANSWER_LENGTH = 3;


    private static int getRandom() {
        return RandomUtils.nextInt(MIN_NUM, MAX_NUM);
    }

    public static LinkedHashSet<Integer> createAnswer() {
        LinkedHashSet<Integer> answer = new LinkedHashSet<>();

        while (answer.size() < ANSWER_LENGTH) {
            answer.add(getRandom());
        }
        return answer;
    }
}