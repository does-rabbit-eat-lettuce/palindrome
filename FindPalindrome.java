
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FindPalindrome{

  public static void main(String[] args) {

    System.out.println(String.format(" is a palindrome"));
  
    // Takes in the first command line argument
    String filename = args[0];

    // Try/Catch block where we read in the file
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line;

      // Read the file line bye line
      while ((line = reader.readLine()) != null) {
        if (isPalindrome(line)) {
          System.out.println(String.format("\"%s\" is a palindrome", line));
        }
	else {
	    System.out.println(String.format("No, NOT a palindrome");
	}
      }
      reader.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  public static boolean isPalindrome(String line) {

    // Remove non-letters
      //  line = line.replace("[^A-Za-z0-9]", "");
    line = line.replaceAll("[^a-zA-Z]", "").toLowerCase();;
    
    System.out.println(String.format(line));

    MyStack<Character> stack = new MyStack<>();

    // Push the first half of the line to the Stack
    for (int i = 0; i < line.length() / 2; i++) {
      stack.push(line.charAt(i));
    }

    // Compare the values in the Stack with the second half of the line
    for (int i = (line.length() + 1) / 2; i < line.length(); i++) {
      if (!stack.pop().equals(line.charAt(i))) {
        return false;
      }
    }
    return true;
  }
}
