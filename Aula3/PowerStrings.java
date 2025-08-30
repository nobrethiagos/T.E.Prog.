import java.io.*;

public class PowerStrings {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    String line;
    while (!(line = br.readLine()).equals(".")) {
      int len = line.length();
      int[] pi = new int[len];
      computePrefixFunction(line, pi);
      int candidate = len - pi[len - 1];
      if (len%candidate == 0) {
        pw.println(len/candidate);
      } else {
        pw.println(1);
      }
    }
    pw.close();
  }

  private static void computePrefixFunction(String s, int[] pi) {
    int n = s.length();
    pi[0] = 0;
    int k = 0;
    for (int i = 1; i < n; i++) {
      while (k > 0 && s.charAt(k) != s.charAt(i)) {
        k = pi[k - 1];
      }
      if (s.charAt(k) == s.charAt(i)) {
        k++;
      }
      pi[i] = k;
    }
  }
}
