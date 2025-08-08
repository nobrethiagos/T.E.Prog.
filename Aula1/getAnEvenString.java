import java.util.Scanner;
import java.util.ArrayList;

public class getAnEvenString {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int nTestCases = Integer.parseInt(sc.nextLine());
    int remotions;
    int position;
    int newStart;
    ArrayList<Character> letters = new ArrayList<>();
    ArrayList<String> sequences = new ArrayList<>();
    for(int i = 0; i < nTestCases; i++) {
      sequences.add(sc.nextLine());
    }
    for(String sequenceNow : sequences) {
      remotions = 0;
      for(int positionStart = 0; positionStart < sequenceNow.length(); positionStart++) {
        position = positionStart + 1;
        letters.add(sequenceNow.charAt(positionStart));
        while(true) {
          if(positionStart == sequenceNow.length() - 1) {
            remotions++;
            //System.out.println("Cheguei final com o positionStart. +1 Remotion -> remotions = " + remotions);
            break;
          }
          if(letters.contains(sequenceNow.charAt(position))) {
            newStart = letters.indexOf(sequenceNow.charAt(position));
            remotions += newStart - positionStart + (position - 1) - newStart;
            positionStart = position;
            //System.out.println("Encontrei um par. remotions = " + remotions);
            break;
          }
          if(position == sequenceNow.length() - 1) {
            remotions += position - positionStart + 1;
            positionStart = position;
            //System.out.println("Nao tem mais pares nessa string. remotions = " + remotions);
            break;

          }
          letters.add(sequenceNow.charAt(position));
          position++;
          //System.out.println("Nao achei par, incrementando position.");
        }
        letters.clear();
      }
      System.out.println(remotions);
    }
    sc.close();
  }
}

