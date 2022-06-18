
package castelinogohilculminating;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;


public class HRManager extends Employee
{
    
    public HRManager()
    {
        super();
    }
    

    @Override
   public void menu()
   {
       Scanner scanN = new Scanner(System.in);
       super.menu();
       int userInput = 0;
       
       do{
           try{
       String fileName = "day.txt";
       
            System.out.println("Welcome, here is a list of all your "
                                + "employees \n");
             System.out.format("\n%-17s%-33s%-25s%-27s\n" , "Name", 
                             " Hourly", "Address", "ID");
                     for (int j = 0; j < 80; j++) 
                     {
                         System.out.print("~");
                         
                     }
                     System.out.println(" ");
             
            printing(fileName);       
            fileName = "night.txt";
            printing(fileName);
            
            do
            {
            System.out.println("\n\nWhat would you like to do from here: \n"
                    + "1. Add Employees"
                    + "\n2. Close the Program");
            userInput = scanN.nextInt();
            
            if(userInput != 1 && userInput != 2)
                    System.out.println("You need to type a 1 or a 2");
            }while(userInput != 1 && userInput != 2);
            
            
            switch(userInput)
            {
                case 1:
                {
                    add();
                }                
                default:
                {
                    break;
                }
            }
       }catch(InputMismatchException e)
               {
                   System.out.println("You typed in a string! Please type in "
                           + "1 or 2");
                   scanN.nextLine();
               }
       }while(userInput !=2);
   }

   public void printing(String printing)
   {
       
       String read;
       try
       {
             File nf = new File(printing);
             Scanner scanS = new Scanner(nf);
             
       while(scanS.hasNext())
            {
                read = scanS.nextLine();
                String[] token = read.split("\\s{2,}+");
                System.out.format("\n%-20s%-21s%-33s%-27s\n" , token[0],token[1]
                        ,token[2],token[3]);
            }
       
        scanS.close();
       }catch(IOException e)
       {
           System.out.println("Error");
       }  
   }
   
   
   public void add()
   {
      boolean flag = true;
      Scanner scanN = new Scanner(System.in);
      do{
       try
       {
           String fileName = null;
           String nme,address, id;
           int hourly;
           Scanner scanS = new Scanner(System.in);
           
           
           System.out.println("Which shift would you like to make changes to?"
                    + "\n1. Day Shift"
                    + "\n2. Night Shift");
            int change = scanN.nextInt();
            
            if (change == 1)
            {
               fileName = "day.txt";
            }
            else if (change == 2)
            {
                fileName = "night.txt";
            }
            
            FileWriter fw = new FileWriter(fileName, true);
            PrintWriter pw = new PrintWriter(fw);
            
            System.out.println("Type in their Name:");
            nme = scanS.nextLine();
            
            System.out.println("Type in their hourly");
            hourly = scanN.nextInt();
            flag = false;
            
            System.out.println("Type in their address");
            address = scanS.nextLine();
            
            System.out.println("Type in their employee id");
            id = scanS.nextLine();
            
            
            pw.format("\n%-28s%-21s%-33s%-27s",nme,hourly,address,id);
            pw.close();
            fw.close();
            
       }catch(IOException e)
       {
           System.out.println("Error");
       }
       catch(InputMismatchException e)
       {
            System.out.println("Sorry, that is not an integer");
            scanN.nextInt();
       }
      }while(flag);
   }
   
}
