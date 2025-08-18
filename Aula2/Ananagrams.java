import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class Ananagrams {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<String> words = new ArrayList<>();
    Map<String, Integer> count = new HashMap<>();
    String line;
    while(!(line = br.readLine()).equals("#")) {
      String[] splitWords = line.split(" ");
      for (String word : splitWords) {
        words.add(word);
        String sorted = sortString(word.toLowerCase());
        count.put(sorted, count.getOrDefault(sorted, 0) + 1);
      }
    }
    List<String> ananagrams = new ArrayList<>();
    for(String word : words) {
      String sorted = sortString(word.toLowerCase());
      if(count.get(sorted) == 1) {
        ananagrams.add(word);
      }
    }
    Collections.sort(ananagrams);
    for(String ananagram : ananagrams) {
      System.out.println(ananagram);
    }
  }

  private static String sortString(String lowerWord) {
    char[] letters = lowerWord.toCharArray();
    Arrays.sort(letters);
    return new String(letters);
  }
}
