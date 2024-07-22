import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 1000;

    static int n;
    static long[] memo = new long[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        memo[0] = 1;
        memo[1] = 2;

        // dp[i] = dp[i - 1] * 2 + dp[i - 2] * 3 + (dp[i - 3] + dp[i - 4] + dp[i - 5] + ... dp[0]) * 2
        for (int i = 2; i <= n; i++) {
            memo[i] = (memo[i - 1] * 2 + memo[i - 2] * 3) % 1000000007;
            for (int j = i - 3; j >= 0; j--) {
                memo[i] = (memo[i] + memo[j] * 2) % 1000000007;
            }
        }

        System.out.print(memo[n]);
    }
}