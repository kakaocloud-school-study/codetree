import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 45;

    static int n;
    static int[] memo = new int[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        memo[1] = 1;
        memo[2] = 1;

        if (n >= 3) {
            for (int i = 3; i <= n; i++) {
                memo[i] = memo[i - 1] + memo[i - 2];
            }
        }

        System.out.print(memo[n]);
    }
}