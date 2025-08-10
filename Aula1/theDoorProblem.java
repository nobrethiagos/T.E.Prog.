import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class theDoorProblem {
  static class parSwitches {
    int s1, s2;
    public parSwitches(int s1, int s2) {
      this.s1 = s1;
      this.s2 = s2;
    }
  }
  
  static class DSU {
    int[] parent;
    DSU(int n) {
      parent = new int[n];
      for (int i = 0; i < n; i++) parent[i] = i;
    }
    int find(int x) {
    if (parent[x] != x) parent[x] = find(parent[x]);
      return parent[x];
    }
    void union(int a, int b) {
      a = find(a);
      b = find(b);
      if (a != b) parent[a] = b;
    }
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int nRooms = sc.nextInt();
    int nSwitches = sc.nextInt();
    int[] doorsSit = new int[nRooms];
    Map<Integer, parSwitches> controle = new HashMap<>();
    for (int room = 1; room <= nRooms; room++) {
      doorsSit[room - 1] = sc.nextInt();
      controle.put(room, new parSwitches(0, 0));
    }
    for (int switchNow = 1; switchNow <= nSwitches; switchNow++) {
      int pwr = sc.nextInt();
      for (int j = 0; j < pwr; j++) {
        int door = sc.nextInt();
        parSwitches par = controle.get(door);
        if (par.s1 == 0) par.s1 = switchNow;
        else par.s2 = switchNow;
      }
    }
    DSU dsu = new DSU(2 * nSwitches + 2);
    for (int room = 1; room <= nRooms; room++) {
      parSwitches par = controle.get(room);
      int a = par.s1;
      int b = par.s2;
      if (doorsSit[room - 1] == 1) {
        dsu.union(a, b);
        dsu.union(a + nSwitches, b + nSwitches);
      } else {
        dsu.union(a, b + nSwitches);
        dsu.union(a + nSwitches, b);
      }
    }
    String possible = "YES";
    for (int i = 1; i <= nSwitches; i++) {
      if (dsu.find(i) == dsu.find(i + nSwitches)) {
        possible = "NO";
        break;
      }
    }
    System.out.println(possible);
    sc.close();
  }
}
