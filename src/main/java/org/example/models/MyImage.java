package org.example.models;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class MyImage  extends JPanel {
    private final BufferedImage image;

    public MyImage(BufferedImage image) {
        this.image = image;
        if (image != null) {
            this.setPreferredSize(new Dimension(300, 300));
            this.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            // Center the image horizontally
            int x = (getWidth() - 300) / 2;
            g.drawImage(image, x, 20, 300, 300, this);
        }
    }
}
