import java.util.*;
import java.io.*;

public class Main {
    static final int INT_MIN = Integer.MIN_VALUE;
    static final int MAX_N = 100;
    static final int MAX_M = 10000;

    static int n, m;
    static int[] coin = new int[MAX_N + 1];
    static int[] dp = new int[MAX_M + 1];

    static void init() {
        for (int i = 0; i <= m; i++) {
            dp[i] = INT_MIN;
        }

        dp[0] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }
        init();

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i >= coin[j]) {
                    if (dp[i - coin[j]] == INT_MIN) {
                        continue;
                    }
                    dp[i] = Math.max(dp[i], dp[i - coin[j]] + 1);
                }
            }
        }

        int ans = dp[m];
        if (ans == INT_MIN) {
            ans = -1;
        }
        System.out.print(ans);
    }
}