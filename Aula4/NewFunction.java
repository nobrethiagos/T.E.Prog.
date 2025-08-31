import java.util.*;
import java.io.*;

public class NewFunction {
    static final int MAX = 1000000;
    static int[] spf = new int[MAX + 1];
    
    static void precomputeSpf() {
        for (int i = 1; i <= MAX; i++) {
            spf[i] = i;
        }
        for (int i = 2; i * i <= MAX; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= MAX; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        precomputeSpf();
        
        // Usar BufferedReader para entrada mais rápida
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        if (k == 1) {
            System.out.println("Yes");
            return;
        }
        
        // Usar HashMap para armazenar apenas os primos relevantes de k
        Map<Integer, Integer> kPrimes = new HashMap<>();
        int temp = k;
        while (temp > 1) {
            int p = spf[temp];
            int count = 0;
            while (temp % p == 0) {
                count++;
                temp /= p;
            }
            kPrimes.put(p, count);
        }
        
        // HashMap para armazenar o máximo expoente encontrado
        Map<Integer, Integer> maxExp = new HashMap<>();
        
        // Para cada número do array, fatorar apenas considerando primos de k
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            
            // Para cada primo de k, verificar quantas vezes divide num
            for (int prime : kPrimes.keySet()) {
                if (num % prime == 0) {
                    int count = 0;
                    while (num % prime == 0) {
                        count++;
                        num /= prime;
                    }
                    maxExp.put(prime, Math.max(maxExp.getOrDefault(prime, 0), count));
                }
            }
        }
        
        // Verificar se todos os primos de k têm expoente suficiente
        for (Map.Entry<Integer, Integer> entry : kPrimes.entrySet()) {
            if (maxExp.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                System.out.println("No");
                return;
            }
        }
        
        System.out.println("Yes");
    }
}
