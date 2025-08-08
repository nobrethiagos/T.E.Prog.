import java.util.Scanner;
import java.util.ArrayList;

public class saveMoreMices {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int nTestCases =  sc.nextInt();
    int distance, nRats, catPosition, ratMax, saved;
    for(int i = 0; i < nTestCases; i++) {
      distance = sc.nextInt();
      catPosition = 0;
      ratMax = 0;
      saved = 0;
      nRats = sc.nextInt();
      ArrayList<Integer> positions = new ArrayList<>();
      for(int j = 0; j < nRats; j++) {
        positions.add(sc.nextInt());
        if(positions.get(j) > positions.get(ratMax)) ratMax = j;
      }
      while(positions.get(ratMax) > catPosition) {
        catPosition += distance - positions.get(ratMax);
        positions.remove(ratMax);
        saved++;
        nRats--;
        ratMax = 0;
        for(int k = 0; k < nRats; k++) {
          if(positions.get(k) > positions.get(ratMax)) ratMax = k;
        }
      }
      System.out.println(saved);
    }
    sc.close();
  }
}
