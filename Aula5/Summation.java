import java.io.*;
import java.util.*;

public class Summation {
  
  private static final int MAX_N = 10000000;
  private static boolean[] isPrime = new boolean[MAX_N + 1];

  public static void main(String[] args) throws IOException {
    sieve();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while((line = reader.readLine())!= null &&!line.isEmpty()) {
      int n = Integer.parseInt(line);
      solve(n);
    }
  }

  private static void sieve() {
    Arrays.fill(isPrime, true);
    isPrime[0] = false;
    isPrime[1] = false;
    for(int p = 2; p * p <= MAX_N; p++) {
      if(isPrime[p]) {
        for(int i = p * p; i <= MAX_N; i += p) {
          isPrime[i] = false;
        }
      }
    }
  }

  private static void solve(int n) {
    if(n < 8) {
      System.out.println("Impossible.");
      return;
    }
    int p1, p2, target;
    if(n % 2 == 0) {
      p1 = 2;
      p2 = 2;
      target = n - 4;
    } else {
      p1 = 2;
      p2 = 3;
      target = n - 5;
    }
    for(int p3 = 2; p3 <= target; p3++) {
      if(isPrime[p3]) {
        int p4 = target - p3;
        if(isPrime[p4]) {
          System.out.println(p1 + " " + p2 + " " + p3 + " " + p4);
          return;
        }
      }
    }
  }
}
