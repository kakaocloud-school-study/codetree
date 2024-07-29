import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 1005;

    static int n;
    static int[] coin = new int[MAX_N];
    static int[][] dp = new int[MAX_N][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }

        dp[1][1] = coin[1];

        dp[2][0] = coin[2];
        dp[2][2] = coin[1] + coin[2];

        for (int i = 3; i <= n; i++) {
            for (int j = 0; j <= 3; j++) {
                if (dp[i - 2][j] != 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 2][j] + coin[i]);
                }
                if (j > 0 && dp[i - 1][j - 1] != 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + coin[i]);
                }
            }
        }

        int ans = 0;
        for (int j = 0; j <= 3; j++) {
            ans = Math.max(ans, dp[n][j]);
        }

        System.out.println(ans);
    }
}