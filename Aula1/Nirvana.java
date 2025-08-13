import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Nirvana {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String in = sc.nextLine();
    int nAlg = in.length();
    ArrayList<Integer> prods = new ArrayList<>();
    for(int i = 0; i < nAlg; i++) {
      prods.add(1);
      // System.out.println("i = " + i);
      for(int j = 0; j < nAlg; j++) {
        // System.out.println("j = " + j);
        if(j < i) {
          // System.out.println("1: prod = " + prods.get(i) + " * " + ((int) in.charAt(j) - '0'));
          prods.set(i, prods.get(i)*((int) in.charAt(j) - '0'));
        } else if(j == i) {
          // System.out.println("2: prod = " + prods.get(i) + " * " + (((int) in.charAt(j) - '0') - 1));
          if(((int) in.charAt(j) - '0') - 1 == 0) continue;
          prods.set(i, prods.get(i)*(((int) in.charAt(j) - '0') - 1));
        } else {
          // System.out.println("3: prod = " + prods.get(i) + " * 9");
          prods.set(i, prods.get(i)*9);
        }
        // System.out.println("res prod = " + prods.get(i));
      }
    }
    prods.add(1);
    for(int i = 0; i < nAlg; i++) {
      // System.out.println("4: prod = " + prods.get(prods.size() - 1) + " * " + ((int) in.charAt(i) - '0'));
      prods.set(prods.size() - 1, prods.get(prods.size() - 1)*((int) in.charAt(i) - '0'));
    }
    System.out.println(Collections.max(prods));
    sc.close();
  }
}
