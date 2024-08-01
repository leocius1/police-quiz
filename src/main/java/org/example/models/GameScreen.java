package org.example.models;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class GameScreen extends JPanel {

    private static GameScreen gameScreenInstance;
    private final JPanel buttonsPanel;
    private final JPanel imageWithNamePanel;

    private GameScreen(List<MyButton> buttons, JLabel label, MyImage image) {
        this.buttonsPanel = new JPanel();
        this.imageWithNamePanel = new JPanel();

        updateScreen(buttons, label, image);
    }

    public static GameScreen getInstance() {
        if (gameScreenInstance == null) {
            gameScreenInstance = new GameScreen(new ArrayList<>(), null, null);
        }
        return gameScreenInstance;
    }

    public void updateScreen(List<MyButton> buttons, JLabel label, MyImage image) {
        this.removeAll();
        buttonsPanel.removeAll();
        imageWithNamePanel.removeAll();
        configureLayout();

        for (MyButton button : buttons) {
            buttonsPanel.add(button);
        }
        buttonsPanel.add(Box.createVerticalGlue());
        if (image != null) {
            imageWithNamePanel.add(image);
        }
        if (label != null) {
            imageWithNamePanel.add(label);
        }

        revalidate();
        repaint();
    }

    private void configureLayout() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalGlue());
        imageWithNamePanel.setLayout(new BoxLayout(imageWithNamePanel, BoxLayout.Y_AXIS));
        alignButtons();
        this.add(imageWithNamePanel);
        this.add(buttonsPanel);

        this.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        this.setSize(1000, 1000);
    }

    private void alignButtons() {
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel,BoxLayout.Y_AXIS));
        buttonsPanel.add(Box.createVerticalGlue());
    }

    public static class GameScreenBuilder {
        private final List<MyButton> buttons;
        private JLabel suspectName;
        private MyImage suspectPicture;
        private int score;

      public GameScreenBuilder() {
            this.buttons = new ArrayList<>();
        }


        public GameScreenBuilder trueButton(Suspect suspect, int[] score) {
            MyButton button = new MyButton(suspect.getCrime());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button.setBackground(Color.GREEN);
                    score[0]++;
                    GameScreen gameScreen = GameScreen.getInstance();
                    gameScreen.removeAll();
                    Game.prepareScreenData();
                    gameScreen.updateUI();

                }
            });
            buttons.add(button);
            return this;
        }

        public GameScreenBuilder suspectPicture(String imgUrl) {
            try {
                URL url = new URL(imgUrl);
                BufferedImage image = ImageIO.read(url);
                this.suspectPicture = new MyImage(image); // Assign to builder field
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
            return this;
        }

        public GameScreenBuilder suspectName(String name) {
            this.suspectName = new JLabel(name); // Assign to builder field
            return this;
        }

        public  GameScreenBuilder falseButton(String crime) {
            MyButton button = new MyButton(crime);
            buttons.add(button);
            return this;
        }

        public GameScreen build() {
            GameScreen gameScreen = GameScreen.getInstance();
            gameScreen.removeAll();
            gameScreen.updateScreen(buttons, suspectName, suspectPicture);
            gameScreen.revalidate();
            gameScreen.repaint();
            return gameScreen;
        }
    }
}