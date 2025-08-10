import java.util.Scanner;
import java.util.ArrayList;

public class minority {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int nTestCases = Integer.parseInt(sc.nextLine());
    int n0, n1, remotions, size;
    ArrayList<String> sequences = new ArrayList<>();
    for(int test = 0; test < nTestCases; test++) sequences.add(sc.nextLine());
    for(String sequence : sequences) {
      n0 = 0;
      n1 = 0;
      remotions = 0;
      size = sequence.length();
      for(int letterPos = 0; letterPos < size; letterPos++) {
        if(sequence.charAt(letterPos) == '0') n0++;
        else n1++;
      }
      if(size > 2) {
        if(n0 == n1) n0--;
        remotions = Math.min(n0, n1);
      }
      System.out.println(remotions);
    }
  }
}
