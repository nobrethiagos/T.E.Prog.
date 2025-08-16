import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Palindromes {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(sc.hasNextLine()) {
      String word = sc.nextLine();
      int start = 0, end = word.length() - 1;
      StringBuilder paliMir = new StringBuilder("11");
      Map<Character, Character> rev = new HashMap<>();
      rev.put('A', 'A');
      rev.put('E', '3');
      rev.put('H', 'H');
      rev.put('I', 'I');
      rev.put('J', 'L');
      rev.put('L', 'J');
      rev.put('M', 'M');
      rev.put('O', 'O');
      rev.put('S', '2');
      rev.put('T', 'T');
      rev.put('U', 'U');
      rev.put('V', 'V');
      rev.put('W', 'W');
      rev.put('X', 'X');
      rev.put('Y', 'Y');
      rev.put('Z', '5');
      rev.put('1', '1');
      rev.put('2', 'S');
      rev.put('3', 'E');
      rev.put('5', 'Z');
      rev.put('8', '8');
      while(end - start > -1) {
        char charS = word.charAt(start), charE = word.charAt(end);
        if(paliMir.charAt(0) == '1' && charS != charE) {
          paliMir.setCharAt(0, '0');
        }
        if(paliMir.charAt(1) == '1' && (rev.get(charS) == null || rev.get(charS) != charE)) {
          paliMir.setCharAt(1, '0');
        }
        start++;
        end--;
        if(paliMir.equals("00")) {
          break;
        }
      }
      switch(paliMir.toString()) {
        case "00":
          System.out.println(word + " -- is not a palindrome.");
          break;
        case "10":
          System.out.println(word + " -- is a regular palindrome."); 
          break;
        case "01":
          System.out.println(word + " -- is a mirrored string.");
          break;
        case "11":
          System.out.println(word + " -- is a mirrored palindrome.");
      }
      System.out.println();
    }
    sc.close();
  }
}
