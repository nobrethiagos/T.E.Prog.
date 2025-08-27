import java.util.*;
import java.io.*;

public class Vito {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int ncases = Integer.parseInt(br.readLine());
    for(int i = 0; i < ncases; i++) {
      String[] in = br.readLine().split(" ");
      int nhouses = Integer.parseInt(in[0]);
      int[] houses = new int[nhouses];
      for(int j = 1; j <= nhouses; j++) {
        houses[j - 1] = Integer.parseInt(in[j]);
      }
      Arrays.sort(houses);
      int men = houses[nhouses/2];
      int minDist = 0;
      for(int j = 1; j <= nhouses; j++) {
        minDist += dist(men, Integer.parseInt(in[j]));
      }
      System.out.println(minDist);
    }
  }

  static int dist(int h1, int h2) {
    return h1 >= h2 ? h1 - h2 : h2 - h1;
  }
}
