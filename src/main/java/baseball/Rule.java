package baseball;

import java.util.ArrayList;


public class Rule {
    private final ArrayList<Integer> answer;
    private static final int BALL_COUNT = 3;
    private int ball = 0;
    private int strike = 0;

    public Rule(ArrayList<Integer> answer) {
        this.answer = answer;
    }

    public boolean isThreeStrike() {
        return this.strike == 3;
    }

    public void judge(ArrayList<Integer> userInput) {
        this.ball = 0;
        this.strike = 0;

        for (int i = 0; i < BALL_COUNT; i++) {
            if (answer.get(i).equals(userInput.get(i))) {
                strike++;
            } else if (answer.contains(userInput.get(i))) {
                ball++;
            }
        }


        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ball != 0 && strike != 0) {
            System.out.println(ball + " 볼 " + strike + " 스트라이크");
            return;
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + " 볼");
            return;
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + " 스트라이크");
        }
    }
}
