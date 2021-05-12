import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class Calculator {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("List of operations: add subtract multiply divide alphabetize");

        System.out.println("Enter an operation.");
        String operation = (sc.nextLine()).toLowerCase();

        switch(operation)
        {
            case "add": {
                System.out.println("Enter two intgers: ");
                String[] integers = (sc.nextLine()).trim().split("\\s");
                try
                {
                    int int1 = Integer.parseInt(integers[0]);
                    int int2 = Integer.parseInt(integers[1]);
                    int result = int1 + int2;
                    System.out.println("Answer: " + result);
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Invalid input entered. Terminating...");
                }
            }
            break;

            case "subtract": {
                System.out.println("Enter two intgers: ");
                String[] integers = (sc.nextLine()).trim().split("\\s");
                try
                {
                    int int1 = Integer.parseInt(integers[0]);
                    int int2 = Integer.parseInt(integers[1]);
                    int result = int1 - int2;
                    System.out.println("Answer: " + result);
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Invalid input entered. Terminating...");
                }
            }
            break;

            case "multiply": {
                System.out.println("Enter two intgers: ");
                String[] doubles = (sc.nextLine()).trim().split("\\s");
                try
                {
                    double db1 = Double.parseDouble(doubles[0]);
                    double db2 = Double.parseDouble(doubles[1]);
                    double result = db1 * db2;
                    System.out.printf("Answer: %5.2f%n \n", result);
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Invalid input entered. Terminating...");
                }
            }
            break;

            case "divide": {
                System.out.println("Enter two intgers: ");
                String[] doubles = (sc.nextLine()).trim().split("\\s");
                try
                {
                    double db1 = Double.parseDouble(doubles[0]);
                    double db2 = Double.parseDouble(doubles[1]);
                    if(db2!=0 || db2!=0.0)
                    {
                        double result = db1 / db2;
                        System.out.printf("Answer: %5.2f%n \n", result);
                    }
                    else
                    {
                        System.out.println("Invalid input entered. Terminating...");
                        break;
                    }
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Invalid input entered. Terminating...");
                }
            }
            break;

            case "alphabetize": {
                String[] words = (sc.nextLine()).trim().split("\\s");
                String word1 = words[0];
                String word2 = words[1];
                if(word1.compareTo(word2) > 0)
                {
                    System.out.println(word1 + " comes before " + word2 + " alphabetically.");
                }
                else if(word1.compareTo(word2) < 0)
                {
                    System.out.println(word2 + " comes before " + word1 + " alphabetically.");
                }
                else
                {
                    System.out.println("Chicken or Egg.");
                }
            }
            break;
        }
    }
}
