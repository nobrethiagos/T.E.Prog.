import java.util.*;
import java.io.*;

public class RareOrder {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    int max = 0;
    int nwords = 0;
    List<String> words = new ArrayList<>();
    while(!(line = br.readLine()).equals("#")) {
      int len = line.length();
      if(len > max) {
        max = len;
      }
      words.add(line);
      nwords++;
    }
    List<Character> alpha = new ArrayList<>();
    Queue<Integer> studies = new LinkedList<>();
    studies.add(0);
    studies.add(nwords - 1);
    int searchs = 1;
    for(int i = 0; i < max; i++) {
      while(searchs != 0) {
        int start = studies.poll();
        int end = studies.poll();
        while(words.get(start).length() <= i) {
          start++;
        }
        char temp = words.get(start).charAt(i);
        for(int j = start + 1; j <= end; j++) {
          char c = words.get(j).charAt(i);
          if(c != temp) {
            if(start < j - 1) {
              studies.add(start);
              studies.add(j - 1);
            }
            if(!alpha.contains(temp) && !alpha.contains(c)) {
              alpha.add(temp);
              alpha.add(c);
            } else if(alpha.contains(temp) && !alpha.contains(c)) {
              alpha.add(alpha.indexOf(temp) + 1, c);
            } else if(!alpha.contains(temp) && alpha.contains(c)) {
              alpha.add(alpha.indexOf(c), temp);
            } else if(alpha.indexOf(temp) + 1 > alpha.indexOf(c)) {
              alpha.remove(alpha.indexOf(c));
              alpha.add(alpha.indexOf(temp) + 1, c);
            }
            start = j;
            temp = words.get(j).charAt(i);
          } else if(j == end) {
            if(start < j) {
              studies.add(start);
              studies.add(j);
            }
            if(!alpha.contains(temp)) {
              alpha.add(temp);            
            }
          }
        }
        searchs--;
      }
      searchs = studies.size()/2;
    }
    while(alpha.size() != 0) {
      System.out.print(alpha.get(0));
      alpha.remove(0);
    }
    System.out.println();
  }
}
