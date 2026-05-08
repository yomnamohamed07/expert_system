/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author mahmoud
 */
public class Mavenproject9 extends JFrame {

   JLabel l1 =new JLabel ("User name");
   JLabel l2 =new JLabel ("PASSWORD");
   JButton USERNAME=new JButton("USERNAME");
   JButton PASSWORD=new JButton("PASSWORD");
   JTextfeild t1 =new   JTextfeild();
   JTextfeild t2 =new   JTextfeild();
public void login() {
     
   
    l1.setBounds(30,15, 100,30); 
    l2.setBounds(30,50, 100,30);    
     
    USERNAME.setBounds(110, 15, 200, 30);
    PASSWORD.setBounds(110, 50, 200, 30);

    
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);//using no layout managers  
    this.setVisible(true);//making the frame visible 
    this.setLocation(500,300);  
    add(l1);add(l2);
    add(USERNAME);
    add(PASSWORD);
    add(t1);
    add(t2);
    /*
    login_but.addActionListener(new ActionListener() {
     
        public void actionPerformed(ActionEvent e){ 
 
        String username = F_user.getText(); //Store username entered by the user in the variable "username"
        String password = F_pass.getText(); //Store password entered by the user in the variable "password"
}
        if(username.equals(" "))  //If username is null
        {
 System.out.println("please enter the username");
            return null;
}
        else if(password.equals("")) / //If password is null
        {
        System.out.println("please enter the password");
            return null;
        }
        
          
              
    
    String admin = rs.getString("ADMIN"); 
               
    f.add(F_pass); //add password
    f.add(login_but);//adding button in JFrame  
    f.add(F_user);  //add user
    f.add(l1);  // add label1 i.e. for username
    f.add(l2); // add label2 i.e. for password
     
   

  */

}
    public static void main(String[] args) {
         Mavenproject9 m =new  Mavenproject9 ();
         m.login();
    

       

    }  

    private void add(JTextfeild t1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }