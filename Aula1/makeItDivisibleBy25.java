import java.util.Scanner;

public class makeItDivisibleBy25 {
  /*public static StringBuilder clearZeroes(StringBuilder numString) {
    while(numString.charAt(0) == '0' && numString.length() > 1) numString.deleteCharAt(0);
    return numString;
  }*/ 

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int nTestCases = Integer.parseInt(sc.nextLine());
    int size, remotions, twoSevenPositionEnd, twoSevenPositionBegin, zeroPositionEnd, zeroPositionBegin;
    for(int test = 0; test < nTestCases; test++) {
      StringBuilder numString = new StringBuilder(sc.nextLine());
      remotions = 0;
      twoSevenPositionEnd = -1;
      twoSevenPositionBegin = -1;
      zeroPositionEnd = -1;
      zeroPositionBegin = -1;
      size = numString.length();
      while(true) {
        //clearZeroes(numString);
        if(size == 1) {
          if(numString.charAt(0) != 0) remotions++;
          System.out.println(remotions);
          break;
        }
        if(numString.charAt(size - 1) != '0' && numString.charAt(size - 1) != '5') {
          size--;
          remotions++;
          continue;
        }
        for(int i = size - 1; i >= 0; i--) {
          if(numString.charAt(i) == '0') {
            if(zeroPositionEnd == -1) zeroPositionEnd = i;
            else if(zeroPositionBegin == -1) zeroPositionBegin = i;
          } else if(numString.charAt(i) == '5') {
            if(zeroPositionEnd != -1) zeroPositionBegin = i;
            else if(twoSevenPositionEnd == -1) twoSevenPositionEnd = i;
          } else if((numString.charAt(i) == '2' || numString.charAt(i) == '7') && twoSevenPositionEnd != -1) twoSevenPositionBegin = i;
          if(zeroPositionBegin != -1 || twoSevenPositionBegin != -1) break;
        }
        if(zeroPositionBegin == -1 && twoSevenPositionBegin == -1) {
          if(zeroPositionEnd != -1) remotions += size - 1;
          else remotions += size;
        } else if(zeroPositionBegin != -1) remotions += zeroPositionEnd - zeroPositionBegin - 1 + size - 1 - zeroPositionEnd;
        else remotions += twoSevenPositionEnd - twoSevenPositionBegin - 1 + size - 1 - twoSevenPositionEnd;
        System.out.println(remotions); 
        break;
      }
    }
  }
}
