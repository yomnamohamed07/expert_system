/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
// name: yomna mohamed fathy
//id:2092201425
package com.mycompany.mavenproject11;

/**
 *
 * @author mahmoud
 */import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Mavenproject11 {

 


    
            public void run() {
                JFrame frame = new JFrame("تسجيل الدخول للمسؤول");
                frame.setSize(100, 100);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);

                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(3, 1));

                JLabel usernameLabel = new JLabel("اسم المستخدم:");
                JLabel passwordLabel = new JLabel("كلمة المرور:");

                JTextField usernameField = new JTextField();
                JPasswordField passwordField = new JPasswordField();

                JButton loginButton = new JButton("تسجيل الدخول");
                loginButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username = usernameField.getText();
                        String password = new String(passwordField.getPassword());
                        // قم بفحص بيانات تسجيل الدخول للمسؤول هنا
                        if (username.equals("admin") && password.equals("password")) {
                            JOptionPane.showMessageDialog(null, "تسجيل الدخول ناجح!");
                        } else {
                            JOptionPane.showMessageDialog(null, "اسم المستخدم أو كلمة المرور غير صحيحة", "خطأ", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                panel.add(usernameLabel);
                panel.add(usernameField);
                panel.add(passwordLabel);
                panel.add(passwordField);
                panel.add(loginButton);

                frame.add(panel);
                frame.setVisible(true);
            }
        
    public static void main(String[] args) {
       Mavenproject11 m1 = new  Mavenproject11() ;
       m1.run();
    }
}
   