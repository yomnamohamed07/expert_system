/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject24;

/**
 *
 * @author mahmoud
 */
public class user {
   protected string name;
    protected string email;
     protected string  phonenumber;
     public  user (){}
     public user (string name){
         this.name = name ;
     }
         public user (string name,string email, string phonenumber){
         
         this.name = name ;
          this.name = phonenumber ;
          this.email =email;
     }
     public string getphonenumber(){
         return phonenumber;
     }
       public string getemail(){
         return email;
     }
        public string getname(){
         return name;
     }
}
