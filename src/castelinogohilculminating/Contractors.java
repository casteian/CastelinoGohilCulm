
package castelinogohilculminating;

import java.io.*;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;



public class Contractors extends Employee
{
    
    public Contractors()
    {
        super();
    }
    

    @Override
   public void menu()
   {
       super.menu();
       //initilizing scanners
       Scanner scanS = new Scanner (System.in);
       String day = "day.txt";
       String night = "night.txt";
       
       //The code below deals with determining the length of the array.
       int lengthDay = length(day);
       int lengthNight = length(night);
       
       //creatign an array to store the day and night employees
       String [] dayEmps;
       String [] nightEmps;
       dayEmps = store(day,lengthDay);
       nightEmps = store(night,lengthNight);
       
       
       System.out.println("Please Enter Your Name: ");
       String namecon = scanS.nextLine();//asking the user to enter name 
       

       //
        int lineday = checking(dayEmps,namecon);
        int linenight = checking(nightEmps,namecon);
        
        
        if (lineday >= 0) 
        {
            print(day,lineday);
        }
        
        else if(linenight >= 0)
        {
            print(night,linenight);
        }
        
        else if(lineday <0 && linenight <0)
        {
            System.out.println("You arent an employee");
        }

   }//end of menu 
   
   
   public static int checking(String shift[], String namecon)
   {  
   
       int line = 0;
       
     
       for (int i = 0; i < shift.length; i++) 
       { 
           if (namecon.equalsIgnoreCase(shift[i])) 
                 {
                     System.out.println("Welcome " + namecon);
                     System.out.println("Printing out your info :) "
                             + "\n");
                     System.out.format("\n%-15s%-21s%-22s%-27s\n" , "Name", 
                             " Hourly", "Address", "ID");
                     for (int j = 0; j < 65; j++) 
                     {
                         System.out.print("~");
                         
                     }
                     System.out.println(" ");
                     return line;
                     
                 }
           line++;
       }

       
       line = -1;
       return line;
       
   }
   
   public static int length(String fileName)
   {
         int n =0; 
         File nf = new File(fileName);
         //create i count
         try
         {
                Scanner scanF = new Scanner(nf);

                while(scanF.hasNext())
                {
                    scanF.nextLine();
                    n++;
                   
                }
            scanF.close();
         }
         catch(IOException e) 
         {
             System.out.println("error");
         }
      
         return n;
   }//end of length 
   
   public static String[] store(String fileName,int n)
   {
       int i = 0;
       File nf = new File(fileName);
       String[] empNames = new String[n];
        
       try
       {
           Scanner scanS = new Scanner(nf);
           
           while(scanS.hasNext())
           {
               String line = scanS.nextLine();
               String[] token2 = line.split("\\s");
               empNames [i] = token2[0];
               i++;
           }
           
       }catch(IOException e) 
       {
           System.out.println("Error!");
       }
       
       return empNames; 
   }
   
   public void print(String fileName, int lineNumber)
   {
       
       File nf = new File(fileName);
       int count = 0;
       String line, keep;
       try
       {
           Scanner scanS = new Scanner(nf);
           
           while(scanS.hasNext())
           {
               if(count == lineNumber)
               {
                    line = scanS.nextLine();
                    System.out.println(line);          
               }
                else
               {
                    keep = scanS.nextLine();
               }
             count++;        
           }   
           scanS.close();
           
       }catch(IOException e) 
       {
           System.out.println("Error!");
       }
       }//end of print 
   
   }
   
   
   
   
