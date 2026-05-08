/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject10;

import javax.swing.*;
import java.awt.event.*;



public class LoginGUI extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JCheckBox savePasswordCheckbox;

    public LoginGUI() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(100, 20, 160, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 50, 160, 25);
        panel.add(passwordField);

        savePasswordCheckbox = new JCheckBox("Save Password");
        savePasswordCheckbox.setBounds(100, 80, 160, 25);
        panel.add(savePasswordCheckbox);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 110, 80, 25);
        //loginButton.addActionListener(this);//
        panel.add(loginButton);
    }

    /**
     *
     * @param e
     */
   /* @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            boolean savePassword = savePasswordCheckbox.isSelected();

            // Here you can implement your login logic
            // For now, let's just print the username, password, and savePassword status
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            System.out.println("Save Password: " + savePassword);
        }
    }
*/
    public static void main(String[] args) {
        
        Mavenproject10 m=new Mavenproject10();
        m.LoginGUI();
    }

  

 
}
    

