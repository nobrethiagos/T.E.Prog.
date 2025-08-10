import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class VladAndCandies {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int nTestCases = sc.nextInt();
    int nTypes;
    int candy;
    for(int test = 0; test < nTestCases; test++) {
      nTypes = sc.nextInt();
      int max1 = 0, max2 = 0, size = 0;
      for(int type = 0; type < nTypes; type++) {
        candy = sc.nextInt();
        if(candy > max1) {
          max2 = max1;
          max1 = candy;
        } else if(candy > max2) max2 = candy;
        size++;
      }
      if(size == 1) {
        if(max1 <= 1) System.out.println("YES");       
        else System.out.println("NO"); 
      } else {
        if(max1 <= max2 + 1) System.out.println("YES");
        else System.out.println("NO");
      }
    }
    sc.close();
  }
}
