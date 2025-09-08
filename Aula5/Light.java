import java.util.*;
import java.io.*;

public class Light {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String line;
    while((line = br.readLine()) != null && !line.equals("0")) {
      long n = Long.parseLong(line);
      if(isPerSquare(n)) {
        sb.append("yes\n");
      } else {
        sb.append("no\n");
      }
    }
    System.out.print(sb.toString());
  }

  private static boolean isPerSquare(long n) {
    if(n <= 0) {
      return false;
    }
    long root = (long) Math.sqrt(n);
    return root*root == n;
  }
}
