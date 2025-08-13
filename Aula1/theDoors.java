import java.util.Scanner;

public class theDoors {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int nDoors = sc.nextInt();
    int door, doorL = 0, doorR = 0;
    for(int i = 1; i <= nDoors; i++) {
      door = sc.nextInt();
      if(door == 0) doorL = i;
      else doorR = i;
    }
    System.out.println(Math.min(doorL, doorR));
    sc.close();
  }
}
