/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject24;


import java.util.Scanner;
public class Mavenproject24 {

    public static void main(String[] args) {
        System.out.println("welcome to library ");
        System.out.println("login or new user");
        Scanner s =new Scanner(System.in);
        int n= s.nextInt();
         if (n==1)
        {
          login();}
        else if(n==2){
        newuser();}
        else
        System.out.println("error");
        }
    }
         private static void login ()
                {
                  System.out.println("enter your phone number ");
                string phonenumber= s.next();
                 System.out.println("enter your email ");
                string email = s.next();
                    
                }
         
        
          private static void newuser ()
                {
                            System.out.println("enter your name ");
                string name = s.next();
                  System.out.println("enter your phone number ");
                string phonenumber= s.next();
                 System.out.println("enter your email ");
                string email = s.next();
                  System.out.println("admin or user");
                int nn=s.nextInt();
                if(nn==1)
                {
                    user admin =new admin(name,email,phonenumber)  ;
                }
                else{
                    user normaluser =new normaluser(name,email,phonenumber)  ;
                }
                }
    }

