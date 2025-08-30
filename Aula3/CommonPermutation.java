import java.util.*;
import java.io.*;

public class CommonPermutation {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Queue<String> lines = new LinkedList<>();
    int ncomp = 0;
    do {
      lines.add(br.readLine());
      lines.add(br.readLine());
      ncomp++;
    } while(br.ready());
    for(int index = 0; index < ncomp; index++) {
      String line1 = lines.poll();
      String preline2 = lines.poll();
      StringBuilder line2 = new StringBuilder();
      line2.append(preline2);
      PriorityQueue<Character> queue = new PriorityQueue<>();
      for(int i = 0; i < line1.length(); i++) {
        for(int j = 0; j < line2.length(); j++) {
          if(line1.charAt(i) == line2.charAt(j)) {
            queue.add(line1.charAt(i));
            line2.deleteCharAt(j);
            break;
          }
        }
      }
      while(queue.size() > 0) {
        System.out.print(queue.poll());
      }
      System.out.println();
    }
  }
}
