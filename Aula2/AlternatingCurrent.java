import java.util.Scanner;
import java.util.Stack;

public class AlternatingCurrent {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String order = sc.nextLine();
    Stack<Character> emb = new Stack<>();
    for(int i = 0; i < order.length(); i++) {
      char pol = order.charAt(i);
      if(!emb.isEmpty() && emb.peek() == pol) {
        emb.pop();
      } else {
        emb.push(pol);
      }
    }
    System.out.println(emb.isEmpty() ? "Yes" : "No");
    sc.close();
  }
}
