/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Scanner ;
public class Project {

    public static void main(String[] args) {
        System.out.println("welcome to the library");
        System.out.println("1.admin or 2.user");
        Scanner s =new Scanner(System.in);
        int n =s.nextInt();
      admin g = new admin();
        if(n==1){
            g.login();
        }
        else{
            b.adminlogin();
        }
      
        ArrayList<String> cars = new ArrayList<String>();
           cars.add("Volvo");    cars.add("Volvo");
        
    }
   
  class admin extends books {
        public void adminlogin(){
            System.out.println("enter the [password");
           
                 int password = s.nextInt();
                  System.out.println("enter the [password");
           
                 int email = s.nextInt();
                 
        }
        public void addbooks(){
            thetotal ++;
        }
    }
  
   class user extends books {
        public void adminlogin(){
            System.out.println("enter the [password");
           
                 int password = s.nextInt();
                  System.out.println("enter the [password");
           
                 int email = s.nextInt();
                 
        }
        public void addbooks(){

            thetotal ++;
        }
    }
  
     class  books {
              ArrayList<String> booksname = new ArrayList<String>();
 
                ArrayList<String> author = new ArrayList<String>();
        
         
                ArrayList<String> yearpublished= new ArrayList<String>();
       
                ArrayList<String> housepublished= new ArrayList<String>();
          booksname.add("hhhh");
  
        
    }
  
  
  
  
  
  
  
}
