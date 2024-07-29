import java.util.*;
import java.io.*;

public class Main {
    static final int INT_MIN = Integer.MIN_VALUE;
    static final int MAX_N = 50;

    static int n, m;
    static int[][] grid = new int[MAX_N][MAX_N];
    static int[][] dp = new int[MAX_N][MAX_N];

    static void init() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = INT_MIN;
            }
        }

        dp[0][0] = 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        init();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //바로 직전 위치를 (k, l)이라 했을 때 조건을 만족하는 경우에 대해 값을 갱신
                for (int k = 0; k < i; k++) {
                    for (int l = 0; l < j; l++) {
                        if (dp[k][l] == INT_MIN) {
                            continue;
                        }

                        if (grid[k][l] < grid[i][j]) {
                            dp[i][j] = Math.max(dp[i][j], dp[k][l] + 1);
                        }
                    }
                }
            }
        }

        int ans = INT_MIN;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.print(ans);
    }
}