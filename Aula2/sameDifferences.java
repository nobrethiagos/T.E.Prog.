import java.util.*;

public class sameDifferences {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int ncases = sc.nextInt();
    int value, dif, temp;
    long res;
    for(int i = 0; i < ncases; i++) {
      res = 0;
      int nvalues = sc.nextInt();
      Map<Integer, Integer> seq = new HashMap<>();
      for(int j = 1; j <= nvalues; j++) {
        value = sc.nextInt();
        dif = value - j;
        if(!seq.containsKey(dif)) {
          seq.put(dif, 0);
        } else {
          seq.put(dif, seq.get(dif) + 1);
        }
      }
      for(int j : seq.values()) {
        res += (long) j*(j + 1)/2;
      }
      System.out.println(res);
    }
    sc.close();
  }
}
