import java.util.Scanner;

public class CounterfeitDollar {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    while (n > 0) {
      n--;
      String[] e1 = new String[3];
      e1[0] = scanner.next();
      e1[1] = scanner.next();
      e1[2] = scanner.next();
      String[] e2 = new String[3];
      e2[0] = scanner.next();
      e2[1] = scanner.next();
      e2[2] = scanner.next();
      String[] e3 = new String[3];
      e3[0] = scanner.next();
      e3[1] = scanner.next();
      e3[2] = scanner.next();
      for (int i = 'A'; i <= 'L'; i++) {
        char a = (char) i;
        if (isRight(e1, a, 0) && isRight(e2, a, 0) && isRight(e3, a, 0)) {
          System.out.println(a + " is the counterfeit coin and it is light.");
          break;
        } else if (isRight(e1, a, 1) && isRight(e2, a, 1) && isRight(e3, a, 1)) {
          System.out.println(a + " is the counterfeit coin and it is heavy.");
          break;
        }
      }
    }
  }

  private static boolean isRight(String[] e, char album, int i) {
    String result = "even";
    String c = String.valueOf(album);
    if (e[0].contains(c) || e[1].contains(c)) {
      if (i == 0) {
        if (e[0].contains(c)) {
          result = "down";
        } else {
          result = "up";
        }
      }
      if (i == 1) {
        if (e[0].contains(c)) {
          result = "up";
        } else {
          result = "down";
        }
      }
    }
    return e[2].equals(result);
  }
}
