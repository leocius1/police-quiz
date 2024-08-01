package org.example.models;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame() throws HeadlessException {

        super("Wanted suspect quiz");
        pack();
        this.setTitle("Police Quiz");
        this.setSize(2000, 2000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.CYAN);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
