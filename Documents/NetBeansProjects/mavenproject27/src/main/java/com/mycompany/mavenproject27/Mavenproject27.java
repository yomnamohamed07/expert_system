/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject27;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mahmoud
 */
public class Mavenproject27 {
  
    static  String books;  static int i=0;
    static int[] prices = new int[60]; static int y=0;
static  String[] housepublished =new String[60]; static int h =0;
 static  String[] yearpublished =new String[60]; static  int u=0;
  static ArrayList <String> ss= new  ArrayList ();
       Iterable<String> List;
    public static void main(String[] args) {
     Scanner s = new Scanner(System.in);
      System.out.println("welcome to the library");
      System.out.println(" 1-admin,or 2-user");
      int n =s. nextInt ();
      if(n==1){
          System.out.println("enterthepassword");
             int pass =s. nextInt ();
            System.out.println("enterthe email");
             String email =s. next();
             System.out.println("you can:");
             System.out.println("1-add user");
             System.out.println("2-add auther");
             System.out.println("3-add housepublished");
             System.out.println("4-add yearpublished");
             System.out.println("5-search tje bbok");
             int v=s. nextInt ();
             if(v==5){
                    String z =s. next();
                   delete(z);
                 
             }
                     
      
          
          
          
      }

  
   
    }    public  static void addbook(String b){
        ss.add(b);
      }
 
     public static  void addprices(int p){
         prices [i]= p;
         y++;
      }
       public  static void addyearpublished(String y){
         yearpublished [i]=y;
         h++;
      }
        public  static void addhousespublished(String h){
        housepublished [i]= h;
         u++;
      }
       

            
         public static void delete (String b) {
   for(book b:b){
         String s= ss.get(i);
         if(s==b){
            System.out.println(s);
         }
            }

         }}



