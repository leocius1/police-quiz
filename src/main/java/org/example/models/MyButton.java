package org.example.models;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {
    public MyButton(String crime) {
        this.setSize(100,100);
        this.setBackground(Color.CYAN);
        this.setText(crime);
    }
}
