// Imports
import java.util.Scanner;  // Import the Scanner class

class Main {
  public static void main(String[] args) {
    // Instances 
    Scanner input = new Scanner(System.in);
    boolean endProgram = false;
    Generator gen = new Generator();

    System.out.println("Password generator Mk 1");
    
    while (!endProgram) {
      System.out.println("\nEnter command or HELP for assistance");
      String userInput = input.nextLine().toLowerCase().trim(); // Read user input 
      
      if(userInput.equals("help") || userInput.equals("?") || userInput.equals("h")) {
          System.out.println("\nEnter \'GenMan\' to manually generate a password");
          System.out.println("Enter \'GenAuto\' to automatically generate a password");
          
      } else if (userInput.equals("quit") || userInput.equals("exit")) {
          endProgram = true;
          System.out.println("Goodbye");
          break;

      } else if (userInput.equals("genauto") || userInput.equals("autogen")) {
        System.out.println(gen.gen());
      
      } else if (userInput.equals("genman") || userInput.equals("mangen")) {
        System.out.println("\nHow long do you want the password to be?");
        int len = Integer.parseInt(input.nextLine());

        System.out.println("How many special characters do you want?");
        int spec = Integer.parseInt(input.nextLine());

        System.out.println("How many uppercase letters do you want?");
        int upper = Integer.parseInt(input.nextLine());

        System.out.println("How many lowercase characters do you want?");
        int lower = Integer.parseInt(input.nextLine());

        System.out.println("How many digits do you want?");
        int dig = Integer.parseInt(input.nextLine());

        if ((spec + upper + lower + dig) > len) {
          System.out.println("\n\nYour individual character parameters exceed the desired length selected, try again");
        } else {
          System.out.println(gen.manGen(len, spec, upper, lower, dig));
        }
      }
    }
  }
}
