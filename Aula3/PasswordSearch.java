import java.util.*;
import java.io.*;

public class PasswordSearch {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Queue<String> words = new LinkedList<>();
    Queue<Integer> Ns = new LinkedList<>();
    String preline;
    while((preline = br.readLine()) != null && !preline.isEmpty()) {
      String[] in = preline.split(" ");
      if(in.length < 2) {
        continue;
      }
      words.add(in[1]);
      Ns.add(Integer.parseInt(in[0]));
    }
    while(!words.isEmpty()) {
      int N = Ns.poll();
      String line = words.poll();
      Map<String, Integer> pattern = new HashMap<>();
      int max = 0;
      int keyPos = 0;
      for(int i = 0; i <= line.length() - N; i++) {
        String testKey = line.substring(i, i + N);
        int count = pattern.getOrDefault(testKey, 0) + 1;
        pattern.put(testKey, count);
        if(count > max) {
          max = count;
          keyPos = i;
        }
      }
      System.out.println(line.substring(keyPos, keyPos + N));
    }
  }
}
