import java.util.*;
import java.io.*;

public class MakeEqualMod {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int ncases = Integer.parseInt(br.readLine());
    StringTokenizer st;
    while(ncases-- > 0) {
      boolean isOne = false;
      boolean conseq = false;
      int n = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      int[] arr = new int[n];
      for(int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(arr);
      for(int i = 0; i < n; i++) {
        if(arr[i] == 1) {
          isOne = true;
        }
        if(i < n - 1 && arr[i] + 1 == arr[i + 1]) {
          conseq = true;
        }
      }
      System.out.println((isOne && conseq) ? "NO" : "YES");
    }
  }
}
