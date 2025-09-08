import java.io.*;
import java.util.*;

public class SimpleRepetition {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int ncases = Integer.parseInt(br.readLine());
    while(ncases-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      StringBuilder sb = new StringBuilder();
      long num = Long.parseLong(st.nextToken());
      int rep = Integer.parseInt(st.nextToken());
      if(num > 1 && rep > 1) {
        System.out.println("NO");
      } else if(rep == 1) {
        System.out.println(isPrime(num));
      } else if(num == 1) {
        System.out.println(rep == 2 ? "YES" : "NO");
      }
    }
  }

  private static String isPrime(long n) {
    if(n <= 1) {
      return "NO";
    }
    if(n == 2){
      return "YES";
    }
    if(n%2 == 0) {
      return "NO";
    }
    for(long i = 3; i*i <= n; i += 2) {
      if(n%i == 0) {
        return "NO";
      }
    }
    return "YES";
  }
}
