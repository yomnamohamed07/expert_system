/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject27;

/**
 *
 * @author mahmoud
 */
public class book {
 protected   String[] books =new String[60]; int i=0;
  protected     int[] prices = new int[60]; int y=0;
   protected  String[] housepublished =new String[60]; int h =0;
   protected   String[] yearpublished =new String[60]; int u=0;
      public void addbook(string b){
         books [i]="b";
         i++;
      }
       public void addprices(int p){
         prices [i]= p;
         y++;
      }
       public void addyearpublished(string y){
         yearpublished [i]="b";
         h++;
      }
          public void addhousespublished(string h){
        housepublished [i]="b";
         u++;
      }
         public void deletebook(string b){
         books [i]=" ";
         i--;
      }   
      
       
       
}
