import java.util.*;
import java.io.*;

public class LeftDown {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int ncases = Integer.parseInt(br.readLine());
    while(ncases-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      long a = Long.parseLong(st.nextToken());
      long b = Long.parseLong(st.nextToken());
      long k = Long.parseLong(st.nextToken());
      long gcd = Euclid(a, b);
      if(a/gcd <= k && b/gcd <= k) {
        System.out.println(1);
      } else {
        System.out.println(2);
      }
    }
  }

  private static long Euclid(long a, long b) {
    while(b != 0) {
      long temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }
}
