import java.io.*;
import java.util.*;

public class Submedians {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      int[] a = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        a[i] = Integer.parseInt(st.nextToken());
      }
      int low = 1, high = n;
      int ansV = 1, ansL = 1, ansR = 1;
      while (low <= high) {
        int mid = (low + high) / 2;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
          temp[i] = (a[i] >= mid) ? 1 : -1;
        }
        int[] p = new int[n + 1];
        p[0] = 0;
        for (int i = 1; i <= n; i++) {
          p[i] = p[i - 1] + temp[i - 1];
        }
        int minVal = 0;
        int minIndex = 0;
        boolean found = false;
        int l = -1, r = -1;
        for (int i = k; i <= n; i++) {
          if (p[i - k] < minVal) {
            minVal = p[i - k];
            minIndex = i - k;
          }
          if (p[i] - minVal >= 0) {
            found = true;
            l = minIndex + 1;
            r = i;
            break;
          }
        }
        if (found) {
          ansV = mid;
          ansL = l;
          ansR = r;
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
      pw.println(ansV + " " + ansL + " " + ansR);
    }
    pw.close();
  }
}
