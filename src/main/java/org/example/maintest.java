package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class maintest {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Display Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        try {
            URL url = new URL("https://www.police.hu/sites/default/files/koral_public_thumbnails/599781"); // Replace with your dynamic URL
            ImageIcon imageIcon = new ImageIcon(url);

            // Resize the image if necessary
            Image image = imageIcon.getImage();
            Image newImage = image.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newImage);

            // Create a label with the resized image
            JLabel imageLabel = new JLabel(imageIcon);

            // Add the image to the frame
            frame.add(imageLabel);
        } catch (IOException e) {
            e.printStackTrace();
            JLabel errorLabel = new JLabel("Failed to load image");
            frame.add(errorLabel);
        }

        // Center the frame
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);
    }

}
