import java.io.*;
import java.util.*;

public class BlackBox {
    static class FastScanner {
        private final BufferedReader br;
        private StringTokenizer st;
        FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
        int nextInt() throws IOException {
            String s = next();
            if (s == null) throw new EOFException();
            return Integer.parseInt(s);
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder overallOutput = new StringBuilder();
        int T;
        try {
            T = fs.nextInt();
        } catch (EOFException e) {
            return;
        }
        for (int t = 0; t < T; t++) {
            int M = fs.nextInt();
            int N = fs.nextInt();
            int[] numbers = new int[M];
            for (int i = 0; i < M; i++) {
                numbers[i] = fs.nextInt();
            }
            int[] gets = new int[N];
            for (int i = 0; i < N; i++) {
                gets[i] = fs.nextInt();
            }
            PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> right = new PriorityQueue<>();
            StringBuilder sb = new StringBuilder();
            int inum = 0;
            for (int i = 0; i < N; i++) {
                while (inum < gets[i]) {
                    int num = numbers[inum++];
                    if (!left.isEmpty() && num < left.peek()) {
                        left.add(num);
                        right.add(left.poll());
                    } else {
                        right.add(num);
                    }
                }
                left.add(right.poll());
                sb.append(left.peek()).append("\n");
            }
            overallOutput.append(sb);
            if (t < T - 1) overallOutput.append("\n");
        }
        System.out.print(overallOutput.toString());
    }
}
