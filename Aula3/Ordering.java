import java.util.*;
import java.io.*;

public class Ordering {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    // System.out.println(line[0]+" "+line[1]);
    int ntasks = Integer.parseInt(line[0]);
    int npreced = Integer.parseInt(line[1]);
    line = br.readLine().split(" ");
    // System.out.println(line[0]+" "+line[1]);
    List<List<Integer>> graph = new ArrayList<>();
    for(int i = 0; i < ntasks; i++) {
      graph.add(new ArrayList<>());
    }
    int[] locks = new int[ntasks];
    int dad = Integer.parseInt(line[0]);
    int child = Integer.parseInt(line[1]);
    while(dad != 0 || child != 0) {
      // System.out.println("c = " + child + " d = " + dad);
      graph.get(dad - 1).add(child);
      locks[child - 1]++;
      line = br.readLine().split(" ");
      dad = Integer.parseInt(line[0]);
      child = Integer.parseInt(line[1]);
      // System.out.println(line[0]+" "+line[1]);
    }
    Queue<Integer> queue = new LinkedList<>();
    for(int i = 0; i < ntasks; i++) {
      if(locks[i] == 0) {
        queue.offer(i + 1);
      }
    }
    int[] result = new int[ntasks];
    int pos = 0;
    // System.out.println("g "+graph);
    // System.out.println("q " + queue);
    while(!queue.isEmpty()) {
      result[pos] = queue.poll();
      for(int v : graph.get(result[pos] - 1)) {
        // System.out.println("oi: " + v);
        locks[v - 1]--;
        if(locks[v - 1] == 0) {
          queue.offer(v);
        }
      }
      pos++;
    }
    System.out.print(result[0]);
    for(int i = 1; i < ntasks; i++) {
      System.out.print(" " + result[i]); 
    }
    System.out.println();
  }
}
