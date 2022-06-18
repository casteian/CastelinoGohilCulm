package castelinogohilculminating;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager extends Employee {

    boolean state;

    public Manager(boolean st) {
        super();
        state = st;
    }

    public Manager(int e, int s, String n, String a, String sh, double pph,
            int hw, boolean st) {
        super(e, s, n, a, sh, pph, hw);
        state = st;
    }

    @Override
    public void menu() {
        String open = "";
        int userInput = 0;
        Scanner scanN = new Scanner(System.in);

        do {
            try {
                if (state == true) {
                    System.out.println("Hello" + name + "you are listed as the "
                            + "day manager. Printing your list of Employees \n");
                    open = "day.txt";
                } else if (state == false) {
                    System.out.println("Hello " + name + " you are listed as the "
                            + "night manager. Printing your list of Employees \n");
                    open = "night.txt";
                }

                File myfile;
                myfile = new File(open);
                Scanner scanR = new Scanner(myfile);

                while (scanR.hasNext()) {
                    String read = scanR.nextLine();
                    System.out.println(read);
                }

                scanR.close();

                do {
                    System.out.println("\nWhat would you like to do?"
                            + "\n1. Alter Employee data"
                            + "\n2. Check inventory"
                            + "\n3. Exit");
                    userInput = scanN.nextInt();

                    if (userInput != 1 && userInput != 2 && userInput != 3) 
                    {
                        System.out.println("You need to type a 1 or a 2 or 3");
                    }
                } while (userInput != 1 && userInput != 2 && userInput != 3);

            } catch (IOException e) {
                System.out.println("error");
            } catch (InputMismatchException e) {
                System.out.println("You typed in a string! Please type in "
                        + "1 or 2");
                scanN.nextLine();
            }
        } while (userInput != 3);

    }

}
