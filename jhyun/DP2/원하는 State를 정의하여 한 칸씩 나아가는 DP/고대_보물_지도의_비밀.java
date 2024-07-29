import java.util.*;
import java.io.*;

public class Main {
    static final int MAXN = 100005;
    static final int INF = -1000000009;

    static int n, k;
    static int[] arr = new int[MAXN];
    static int[][] dp = new int[MAXN][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = INF;
        for (int i = 1; i <= n; i++) {
            // arr[i]가 0 이상인 경우
            if (arr[i] >= 0) {
                for (int j = 0; j <= k; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j] + arr[i], dp[i][j]);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            // arr[i]가 음수인 경우
            else {
                for (int j = 1; j <= k; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + arr[i], dp[i][j]);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }

        System.out.println(ans);
    }
}