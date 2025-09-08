import java.util.*;
import java.io.*;

public class EuclidProblem {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringBuilder sb = new StringBuilder();
    String line;
    while((line = br.readLine()) != null && !line.isEmpty()) {
      StringTokenizer st = new StringTokenizer(line);
      long a = Long.parseLong(st.nextToken());
      long b = Long.parseLong(st.nextToken());
      long[] res = extEuclid(a, b);
      sb.append(res[0])
        .append(" ")
        .append(res[1])
        .append(" ")
        .append(res[2])
        .append("\n");
    }
    pw.print(sb.toString());
    pw.flush();
    pw.close();
  }

  public static long[] extEuclid(long a, long b) {
    if(b == 0) {
      return new long[] {1, 0, a};
    }
    long[] res = extEuclid(b, a % b);
    long d = res[2];
    long x = res[1];
    long y = res[0] - (a/b)*res[1];
    return new long[] {x, y, d};
  }
}
