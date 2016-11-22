import java.util.*;

public class Sieve {

    public static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n+1];

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i*i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }

    public static List<Integer> primeSequence(int n) {
        boolean[] isPrime = sieve(n);
        List<Integer> seq = new ArrayList<>();

        isPrime[n] = isPrime[1] = true;  // ensures sequence begins with n and ends with 1

        for (int i = n; i >= 1; i--) {
            if (isPrime[i]) {
                seq.add(i);
            }
        }

        return seq;
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        List<Integer> seq = primeSequence(n);
        for (int i : seq) {
            System.out.println(i);
        }
    }
}