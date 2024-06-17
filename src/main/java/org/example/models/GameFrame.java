package org.example.models;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame() throws HeadlessException {
        this.setTitle("Police Quiz");
        this.setSize(840,840);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.CYAN);
    }

}
