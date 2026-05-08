/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject14;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author mahmoud
 */

public class Mavenproject14 extends JFrame {
     JLabel label1 = new JLabel("Place 1:");
        JLabel label2 = new JLabel("Place 2:");
        JLabel label3 = new JLabel("Place 3:");
        JLabel label4 = new JLabel("Place 4:");
        JLabel label5 = new JLabel("Place 5:");

        // Create text fields for each place
        JTextField textField1 = new JTextField(20);
        JTextField textField2 = new JTextField(20);
        JTextField textField3 = new JTextField(20);
        JTextField textField4 = new JTextField(20);
        JTextField textField5 = new JTextField(20);
    public Mavenproject14() {
        super("Search Places");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create labels
   

        // Add key listeners to text fields
        textField1.addKeyListener((KeyListener) new EnterKeyListener(textField1));
        textField2.addKeyListener(new EnterKeyListener(textField2));
        textField3.addKeyListener(new EnterKeyListener(textField3));
        textField4.addKeyListener(new EnterKeyListener(textField4));
        textField5.addKeyListener(new EnterKeyListener(textField5));

        // Add labels and text fields to the frame
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(label4);
        panel.add(textField4);
        panel.add(label5);
        panel.add(textField5);

        // Add panel to the frame
        add(panel);

        // Set frame size and make it visible
        setSize(400, 200);
        setVisible(true);
    }

    // Custom KeyListener to handle Enter key events
    class EnterKeyListener implements KeyListener {
        private JTextField textField;

        public EnterKeyListener(JTextField textField) {
            this.textField = textField;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                String place = textField.getText();
                JOptionPane.showMessageDialog(null, "Searching for: " + place);
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SearchPlacesGUI();
        });
    }
}
   
