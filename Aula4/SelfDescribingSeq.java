import java.util.Scanner;

public class Main {
  static final int MAX = 1000000;
  static long[] save = new long[MAX];
  static int ind = 0;

  public static void preGenerate() {
    save[1] = 1;
    save[2] = 2;
    save[3] = 4;
    save[4] = 6;
    save[5] = 9;
    save[6] = 12;
    save[7] = 16;
    ind = 7;
    int indicator = 4;
    int cnt;
    while (save[ind - 1] <= 2000000000) {
      cnt = (int) (save[indicator + 1] - save[indicator]);
      while (cnt > 0 && save[ind - 1] <= 2000000000) {
        save[ind] = save[ind - 1] + indicator;
        ind++;
        cnt--;
      }
      indicator++;
    }
  }

  public static void main(String[] args) {
    preGenerate();
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()) {
      int n = sc.nextInt();
      if (n == 0) break;
      for (int i = 1; i < ind; i++) {
        if (n < save[i]) {
          System.out.println(i - 1);
          break;
        }
      }
    }
    sc.close();
  }
}
