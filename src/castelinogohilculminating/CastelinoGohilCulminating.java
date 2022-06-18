package castelinogohilculminating;

/**
 * *
 * Importing nessecary scanners, which include IOExceptions, Scanners and file
 * readers.
 */
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CastelinoGohilCulminating {

    public static void main(String[] args) {

        //Innitializing variables. Note that the object is not defined at this
        //moment as we dont know if the user is an employee,manager, Hr manager. 
        Employee user;
        int i = 0;

        //Connecting my program to open the file containing all the passwords
        File nfpass = new File("Password.txt");

        //Creating a string that stores the saved passwords from the file. 
        String[] savedPasswords = new String[3];

        try {
            //Connect scanR to the file so I can pick up data. 
            Scanner scanR = new Scanner(nfpass);

            /*.As long as the password file has lines, read it, tokenize it with 
            * key to split being white space larger than 2. Store that second
            * piece of data in an array called saved passwords. 
             */
            while (scanR.hasNext()) {
                String read = scanR.nextLine();
                String[] token = read.split("\\s{2,}+");
                savedPasswords[i] = token[1];
                i++;
            }
            /**
             * Run the authentication method and the menu method. Note that all
             * the classes have a menu method but are overriden such that that
             * role only sees options available to them.
             */

            user = Authentication(savedPasswords);
            user.menu();

            // Catch statement to solve any issue with file not found, or reading
            //issues. 
        } catch (IOException e) {
            //print error 
            System.out.println("error");

        }

    }//end of main 

    /**
     * Employee Authentication Method. Stores the users response, compares it to
     * saved passwords and assigns a nessecary role.
     *
     * @param savedPasswords
     * @return
     */
    public static Employee Authentication(String[] savedPasswords) {

        int userInput = 0;
        boolean flag = false;
        do {
            try {
                //Innitialize Scanners and variables here
                Scanner scanS = new Scanner(System.in);
                Scanner scanN = new Scanner(System.in);
                String attempt;
                int fails = 0;

                //Greating message and a list of options the user can select from. 
                do {
                    System.out.println("Welcome to ManageS and Thank you for choising our "
                            + "program");

                    System.out.println("Please select which role");
                    System.out.println("1. Manager"
                            + "\n2. Contractor");
                    userInput = scanN.nextInt();//records their input

                    if (userInput != 1 && userInput != 2) {
                        System.out.println("Please input a 1 or a 2.");
                    }
                } while (userInput != 1 && userInput != 2);

                //using a switch for each of the possible outcomes 
                switch (userInput) {
                    case 1: {
                        //using a do while loop to let the user input their password
                        do {
                            //asking the user to input their password 
                            System.out.println("\nPlease enter your 6 digit code");
                            //storing their answer 
                            attempt = scanS.nextLine();
                            flag = false;

                            //using an if statement to determine which manager 
                            //logged in 
                            if (attempt.equals(savedPasswords[0])) {
                                System.out.println("Welcome, you are day manager");

                                //since manager is true it is the day manager. The
                                //bolean true or false indicates day or night
                                //managers.
                                return new Manager(true);
                            } /**
                             * if the password matches the one in the file for
                             * position 1 then they user is set to be the night
                             * manager
                             */
                            else if (attempt.equals(savedPasswords[1])) {
                                return new Manager(false);
                            } /**
                             * if the password matches the one in the file for
                             * position 2 then they user is set to be the HR
                             * manager
                             */
                            else if (attempt.equals(savedPasswords[2])) {
                                return new HRManager();
                            } // if the user inputs the wrong password 
                            else {
                                System.out.println("Wrong passsword");
                                fails++;  //increase the counter of fails
                            }

                        } while (fails < 3); //lets the user type in the password 
                        //3 times 

                        /**
                         * if the password is entered incorrectly 3 times then
                         * the user is set to be a contractor
                         */
                        if (fails == 3) {
                            System.out.println("Incorrect password, pre designating"
                                    + " you to contractor");
                            return new Contractors();//user becomes contarctor 
                        }
                    }
                    break;

                    //user choses to be a contractor 
                    case 2: {
                        System.out.println("You are a contractor");
                        flag = true;
                        break;
                    }

                    //if any other number is input
                    default: {
                        System.out.println("There was an error. Please "
                                + "contact admin");
                        break;
                    }
                }//end of switch
            } catch (InputMismatchException e) {
                System.out.println("Input a intiger, you typed in a string");
            }
        }while (flag == false);

        return new Contractors();
    }//end of Employee Authentication
}//end of class

