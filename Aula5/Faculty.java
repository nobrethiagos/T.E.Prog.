import java.io.*;
import java.util.*;

public class Faculty {
  public static void main(String[] args) throws IOException {
    FastReader reader = new FastReader();
    StringBuilder sb = new StringBuilder();
    int ncases = reader.nextInt();
    while (ncases-- > 0) {
      solve(reader, sb);
    }
    System.out.print(sb);
  }

  public static int f(int x, int y) {
    return (x % y) + (y % x);
  }

  public static void solve(FastReader reader, StringBuilder sb) throws IOException {
    int n = reader.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = reader.nextInt();
    }
    if(n == 0) {
      sb.append("\n");
      return;
    }
    int max = 0;
    int big = arr[0];
    for(int i = 0; i < n; i++) {
      max = Math.max(max, f(big, arr[i]));
      if(arr[i] > big) {
        if(arr[i] >= big * 2) {
          big = arr[i];
          for(int j = 0; j < i; j++) {
            max = Math.max(max, f(arr[i], arr[j]));
          }
        } else {
          big = arr[i];
          max = big;
        }
      }
      sb.append(max).append(" ");
    }
    sb.append("\n");
  }

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) { 
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
          str = br.readLine();
      } catch (IOException e) {
          e.printStackTrace();
      }
      return str;
    }
  }
}
