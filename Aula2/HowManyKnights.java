import java.util.*;

public class HowManyKnights {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(true) {
      int s1 = sc.nextInt();
      int s2 = sc.nextInt();
      if(s1 == 0 && s2 == 0) break;
      boolean swap = false;
      if(s1 > s2) {
        swap = true;
        int tmp = s1;
        s1 = s2;
        s2 = tmp;
      }
      int res;
      if(s1 == 1) {
        res = s2; 
      } else if (s1 == 2) {
        res = (s2 / 4) * 4 + Math.min(2, s2 % 4) * 2;
      } else {
        res = (s1 * s2 + 1) / 2; 
      }
      System.out.println(res + " knights may be placed on a " + (swap ? s2 : s1) + " row " + (swap ? s1 : s2) + " column board.");
    }
    sc.close();
  }
}
