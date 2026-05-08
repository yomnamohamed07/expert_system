/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject24;

import java.util.ArrayList;
public class dataa {
      ArrayList<normaluser> user = new   ArrayList<user> ();
        ArrayList<string> username = new   ArrayList<string> ();
        public void adduser(user s){
            user.add(s);
            username.add(s.getname());
        }
        public  int login (string phonenumber,string email){
            boolen n =-1;
            for(normaluser s: users){
                if(s.getphonenumber().matches(phonenumber)&&s.getemail().matches(email))
                
            }
        }
}
