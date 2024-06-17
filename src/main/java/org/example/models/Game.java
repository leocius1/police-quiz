package org.example.models;

import java.util.List;

public class Game {

    public Game(List<Suspect> suspects, List<String> crimes) {
        logic = new GameLogic(crimes, suspects);
        frame = new GameFrame();
        loadScreen();
    }
    public static void loadScreen() {
        Suspect suspect = logic.getRandomSuspect();
        String trueCrime = suspect.getCrime();
        String falseCrime = logic.getRandomCrime();
        while (falseCrime.equals(trueCrime)) {
            falseCrime = logic.getRandomCrime();
        }
        String falseCrime2 = logic.getRandomCrime();
        while (falseCrime2.equals(trueCrime) || falseCrime2.equals(falseCrime)) {
            falseCrime2 = logic.getRandomCrime();
        }

        GameScreen gameScreen = new GameScreen.GameScreenBuilder().builder()
                .falseButton(falseCrime)
                .falseButton(falseCrime2)
                .trueButton(suspect)
                .build();
        frame.add(gameScreen);
    }


    private static GameFrame frame;
    private static GameLogic logic;

}
