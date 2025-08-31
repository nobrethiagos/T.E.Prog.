import java.io.*;
import java.util.*;

public class InterestingFunction {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    int t = Integer.parseInt(br.readLine());
    while(t-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      long l = Long.parseLong(st.nextToken());
      long r = Long.parseLong(st.nextToken());
      long result = solve(l, r);
      out.println(result);
    }
    out.flush();
    out.close();
  }

  private static long solve(long l, long r) {
    long totalChanges = 0;
    long divisor = 1;
    while(divisor <= r) {
      totalChanges += (r / divisor) - (l / divisor);
      divisor *= 10;
    }
    return totalChanges;
  }

  private static long solveAlternative(long l, long r) {
    long sum = 0;
    for (long pow10 = 1; pow10 <= r; pow10 *= 10) {
      sum += (r / pow10) - (l / pow10);
    }
    return sum;
  }
}
