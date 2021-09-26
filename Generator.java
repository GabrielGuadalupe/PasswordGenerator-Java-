// Import
import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;

public class Generator {
  // Magic numbers
  private int LEN = 10;
  private int SPEC = 2;
  private int UPPER = 2;
  private int LOWER = 2;
  private int DIG = 2;

  // Instances
  Random rand = new Random();

  //Automatic generator 
  public String gen() {
    String output = "";
    // Generate special characters
    for (int i = 0; i < SPEC; i++) {
      // Generate a special character from 3 seperate ranges of ASCII characters
      int n = 1 + (int)(Math.random() * ((3 - 1) + 1)); // Gen random num 1-3
      
      if (n == 1) {
        output += (char) (33 + (int)(Math.random() * ((47 - 33) + 1)));
      } else if (n == 2) {
        output += (char) (58 + (int)(Math.random() * ((64 - 58) + 1)));
      } else {
        output += (char) (33 + (int)(Math.random() * ((96 - 91) + 1)));
      }
    }

    // Generate uppercase characters 
    for (int i = 0; i < UPPER; i++) {
      output += (char) (65 + (int)(Math.random() * ((90 - 65) + 1)));
    }
    
    // Generate lowercase characters
    for (int i = 0; i < LOWER; i++) {
      output += (char) (97 + (int)(Math.random() * ((122 - 97) + 1)));
    }
    
    // Generate numerical characters 
    for (int i = 0; i < DIG; i++) {
      output += (char) (48 + (int)(Math.random() * ((57 - 48) + 1)));
    }

    // Generate random characters with remaining space
    for (int i = 0; i < (LEN - (SPEC + UPPER + LOWER + DIG)); i++) {
      output += (char) (33 + (int)(Math.random() * ((122 - 33) + 1)));
    }
    
    // Shuffle the characters 
    // Convert string into arraylist
    ArrayList<Character> letters = new ArrayList<Character>();
    for (int i = 0; i < LEN; i++) {
      letters.add(output.charAt(i));
    }
    // Shuffle characters in arraylist 
    Collections.shuffle(letters);
    // Convert arraylist back into output 
    output = "";
    for (int i = 0; i < letters.size(); i++) {
      output += letters.get(i);
    }
    return (output);
  }

  // Manual generator that takes desired minimum length, number of special
  // characters, number of uppercase and lowercase characters, and number of digits
  public String manGen(int len, int spec, int upper, int lower, int dig) {
    LEN = len;
    SPEC = spec;
    UPPER = upper;
    LOWER = lower;
    DIG = dig;
    return (gen());
  }
  
}
