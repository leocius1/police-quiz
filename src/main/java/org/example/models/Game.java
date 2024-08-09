package org.example.models;

import java.util.List;

public class Game {

    public Game(List<Suspect> suspects, List<String> crimes) {
        logic = new GameLogic(crimes, suspects);
        frame = new GameFrame();
        startGame();
    }

    public static GameFrame getFrame() {
        return frame;
    }

    public static void setFrame(GameFrame frame) {
        Game.frame = frame;
    }

    public static GameLogic getLogic() {
        return logic;
    }

    public static void setLogic(GameLogic logic) {
        Game.logic = logic;
    }

    public static int[] getScore() {
        return score;
    }

    public static void setScore(int[] score) {
        Game.score = score;
    }

    public static void startGame() {
        
        Suspect suspect = logic.getRandomSuspect();
        String trueCrime = suspect.getCrime();
        String falseCrime = logic.getRandomCrime();
        String imageUrl = suspect.getImgUrl();
        String suspectName = suspect.getFirstName() + " " + suspect.getSurName();
        logic.removeSuspect(suspect);

        while (falseCrime.equals(trueCrime)) {
            falseCrime = logic.getRandomCrime();
        }
        String falseCrime2 = logic.getRandomCrime();
        while (falseCrime2.equals(trueCrime) || falseCrime2.equals(falseCrime)) {
            falseCrime2 = logic.getRandomCrime();
        }


        GameScreen gameScreen = new GameScreen.GameScreenBuilder()
                .falseButton(falseCrime)
                .falseButton(falseCrime2)
                .trueButton(suspect, score)
                .suspectPicture(imageUrl)
                .suspectName(suspectName)
                .score(score[0])
                .build();

        frame.add(gameScreen);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }




    private static GameFrame frame;
    private static GameLogic logic;
    private static GameScreen screen;
    private static int[] score = {0};
}
