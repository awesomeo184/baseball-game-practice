package baseball;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        BaseBallGame baseBallGame = new BaseBallGame(scanner);
        baseBallGame.play();
    }
}
