import java.io.*;
import java.util.*;

public class HowManyPieces {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    int ncases = Integer.parseInt(br.readLine());
    while(ncases-- > 0) {
      long N = Long.parseLong(br.readLine());
      out.println((long) Math.pow(2, N - 1));
    }
    out.flush();
    out.close();
  }
}
