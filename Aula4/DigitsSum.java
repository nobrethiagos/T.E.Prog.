import java.util.*;
import java.io.*;

public class DigitsSum {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int ncases = Integer.parseInt(br.readLine());
    while(ncases-- > 0) {
      int n = Integer.parseInt(br.readLine());
      int sum = 0;
      n++;
      while(n-- > 0) {
        if(n%10 == 9) {
          sum = n/10 + 1;
          break;
        }
      }
      System.out.println(sum);
    }
  }
}
