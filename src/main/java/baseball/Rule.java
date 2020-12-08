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
        return strike == 3;
    }

    public void initializeBallCount() {
        strike = 0;
        ball = 0;
    }

    public void judge(ArrayList<Integer> userInput) {

        for (int i = 0; i < BALL_COUNT; i++) {
            if (answer.get(i).equals(userInput.get(i))) {
                strike++;
            } else if (answer.contains(userInput.get(i))) {
                ball++;
            }
        }
    }

    public void printResult() {
        if (isNothing()) {
            System.out.println("낫싱");
            return;
        }
        if (isThreeStrike()) {
            System.out.println("승리했습니다. 재시작은 1, 게임 종료는 2를 입력하세요: ");
            return;
        }
        System.out.println(ball + " 볼 " + strike + " 스트라이크");

    }

    private boolean isNothing() {
        return ball == 0 && strike == 0;
    }

}
