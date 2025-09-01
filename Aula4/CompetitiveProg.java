import java.util.*;
import java.io.*;

public class CompetitiveProg {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int ncases = Integer.parseInt(br.readLine());
    while(ncases-- > 0) {
      String num = br.readLine();
      boolean hasZero = false;
      boolean isEven = false;
      boolean divThree = false;
      long sum = 0;
      for(int i = 0; i < num.length(); i++) {
        char c = num.charAt(i);
        int n = '0' - c;
        if(!hasZero && c == '0') {
          hasZero = true;
        } else { 
          if(!isEven && n%2 == 0) {
            isEven = true;
          }
          sum += n;
        }
      }
      if(sum%3 == 0) {
        divThree = true;
      }
      System.out.println((divThree && isEven && hasZero) ? "red" : "cyan");
    }
  }
}
