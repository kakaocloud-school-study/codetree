import java.util.*;
import java.io.*;

public class Main {
    static final int INT_MIN = Integer.MIN_VALUE;
    static final int MAX_N = 100_000;

    static int n;
    static int[] arr = new int[MAX_N + 1];
    static int[] dp = new int[MAX_N + 1];

    static void init() {
        for (int i = 1; i <= n; i++) {
            dp[i] = INT_MIN;
        }
        dp[1] = arr[1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init();

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }

        int ans = INT_MIN;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.print(ans);
    }
}