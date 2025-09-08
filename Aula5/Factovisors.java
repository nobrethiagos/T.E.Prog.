import java.util.*;
import java.io.*;

public class Factovisors {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    String line;
    boolean res;
    while((line = br.readLine()) != null && !line.isEmpty()) {
      StringTokenizer st = new StringTokenizer(line);
      long a = Long.parseLong(st.nextToken());
      long b = Long.parseLong(st.nextToken());
      if(solve(a, b)) {
        pw.println(b + " divides " + a + "!");
      } else {
        pw.println(b + " does not divide " + a + "!");
      }
    }
    pw.flush();
    pw.close();
  }

  private static boolean solve(long a, long b) {
    if(b == 0) {
      return false;
    }
    if(b == 1) {
      return true;
    }
    if(a == 0) {
      return (b == 1);
    }
    long temp = b;
    for(long i = 2; i*i <= temp; i++) {
      if(temp%i == 0) {
        int iCounterB = 0;
        while(temp%i == 0) {
          iCounterB++;
          temp /= i;
        }
        long iCounterA = 0;
        long j = i;
        while(j <= a) {
          iCounterA += a/j;
          if(j > a/i) {
            break;
          }
          j *= i;
        }
        if(iCounterA < iCounterB) {
          return false;
        }
      }
    }
    if(temp > 1) {
      if(temp > a) {
        return false;
      }
    }
    return true;
  }
}
