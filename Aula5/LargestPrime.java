import java.io.*;
import java.util.*;

public class LargestPrime {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while((line = br.readLine())!= null) {
      long num = Long.parseLong(line);
      if(num == 0) {
        break;
      }
      Set<Long> distinctFactors = new HashSet<>();
      long largestPrimeFactor = -1;
      num = (long) Math.abs(num);
      if(num % 2 == 0) {
        distinctFactors.add(2L);
        largestPrimeFactor = 2;
        while(num % 2 == 0) {
          num /= 2;
        }
      }
      long limit = (long) Math.sqrt(num);
      for(long i = 3; i <= limit; i += 2) {
        if(num % i == 0) {
          distinctFactors.add(i);
          largestPrimeFactor = i;
          while(num % i == 0) {
              num /= i;
          }
          limit = (long) Math.sqrt(num);
        }
      }
      if(num > 2) {
        distinctFactors.add(num);
        largestPrimeFactor = num;
      }
      if(distinctFactors.size() < 2) {
        System.out.println(-1);
      } else {
        System.out.println(largestPrimeFactor);
      }
    }
  }
}
