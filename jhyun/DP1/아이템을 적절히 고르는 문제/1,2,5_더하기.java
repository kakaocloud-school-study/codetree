import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 1000;

    static int n;

    static int[] dp = new int[MAX_N + 1];
    static int[] nums = new int[]{1, 2, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                if (i >= nums[j]) {
                    dp[i] = (dp[i] + dp[i - nums[j]]) % 10007;
                }
            }
        }

        System.out.print(dp[n]);
    }
}