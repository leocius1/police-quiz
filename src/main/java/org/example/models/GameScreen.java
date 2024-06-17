package org.example.models;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GameScreen extends JPanel {

    private GameScreen(List<MyButton> buttons) {
        for (MyButton button : buttons)
            this.add(button);
    }


    public static class GameScreenBuilder {
        List<MyButton> buttons;

         GameScreenBuilder() {
            this.buttons = new ArrayList<>();
        }

        public GameScreenBuilder builder() {
            return new GameScreenBuilder();
        }

        public GameScreenBuilder trueButton(Suspect suspect) {
            MyButton button = new MyButton(suspect.getCrime());
            buttons.add(button);
            return this;
        }

        public GameScreenBuilder falseButton(String crime) {
            MyButton button = new MyButton(crime);
            buttons.add(button);
            return this;
        }

        public GameScreen build() {
            return new GameScreen(buttons);
        }

    }
}
