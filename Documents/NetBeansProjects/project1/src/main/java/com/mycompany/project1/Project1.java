/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

//name :yomna mohamed fathy
//id: 202201425

package com.mycompany.project1;
import java.util.Scanner;
public class Project1 {

    public static void main(String[] args) {
      Scanner input=new Scanner (System.in);
     float x=5;
     float y=10;
     double sum = x + y ;
     System.out.println("addition is:"+sum);
     double difference;
     difference=x-y;
     System.out.println("differnce is:"+difference);
     double product=x*y;
     System.out.println("product is:"+product);
     double division= x/y;
     if(y==0){
        
           System.out.println("cant divide  by 0");
     }
     else{
        System.out.println("dividion is:"+division);
     }
   
      
    }
}
