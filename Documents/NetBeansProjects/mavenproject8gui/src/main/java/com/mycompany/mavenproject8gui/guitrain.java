/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject8gui;

import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class guitrain extends JFrame implements ActionListener{
   
    JButton b = new JButton("admin");
    JButton h = new JButton("user");
  b.addActionListener(this);
   h.addActionListener(this);
   
    public void bb() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("welcome to the library");
        this.setVisible(true);
        this.setSize(500, 300);
        this.setLocation(500, 300);

       
          b.setBounds(40, 10, 120, 25);
        h.setBackground(Color.red);

        h.setBounds(40, 50, 150, 25);
        setLayout(null);
  
       add(b);
       add(h);
  
      public void actionperformed(ActionEvent e){
        Object b1 = null;
          if(e.getSource()==b1){
              System.out.println ("go to admin bage");
          }
      }

}

      
    }
    public static void main(String[] args) {
        guitrain gui = new guitrain();
        gui.bb(); // Call the method to display the JFrame
    }
}

  
  