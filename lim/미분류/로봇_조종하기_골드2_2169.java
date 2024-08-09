package lim.미분류;

import java.util.*;
import java.io.*;

public class 로봇_조종하기_골드2_2169 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int FROM_LEFT = 0, FROM_RIGHT = 1;
    static int[][] grid;
    static int[][][] dp;

    static void sol() throws IOException {
        dp[1][1][FROM_LEFT] = grid[1][1];
        for (int i = 2; i <= m; i++) {
            dp[1][i][FROM_LEFT] = dp[1][i - 1][FROM_LEFT] + grid[1][i];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j - 1][FROM_LEFT] != Integer.MIN_VALUE) {
                    dp[i][j][FROM_LEFT] = Math.max(dp[i][j][FROM_LEFT], dp[i][j - 1][FROM_LEFT] + grid[i][j]);
                }
                if (dp[i - 1][j][FROM_LEFT] != Integer.MIN_VALUE) {
                    dp[i][j][FROM_LEFT] = Math.max(dp[i][j][FROM_LEFT], dp[i - 1][j][FROM_LEFT] + grid[i][j]);
                }
                if (dp[i - 1][j][FROM_RIGHT] != Integer.MIN_VALUE) {
                    dp[i][j][FROM_LEFT] = Math.max(dp[i][j][FROM_LEFT], dp[i - 1][j][FROM_RIGHT] + grid[i][j]);
                }
            }
            for (int j = m; j >= 0; j--) {
                if (dp[i][j + 1][FROM_RIGHT] != Integer.MIN_VALUE) {
                    dp[i][j][FROM_RIGHT] = Math.max(dp[i][j][FROM_RIGHT], dp[i][j + 1][FROM_RIGHT] + grid[i][j]);
                }
                if (dp[i - 1][j][FROM_LEFT] != Integer.MIN_VALUE) {
                    dp[i][j][FROM_RIGHT] = Math.max(dp[i][j][FROM_RIGHT], dp[i - 1][j][FROM_LEFT] + grid[i][j]);
                }
                if (dp[i - 1][j][FROM_RIGHT] != Integer.MIN_VALUE) {
                    dp[i][j][FROM_RIGHT] = Math.max(dp[i][j][FROM_RIGHT], dp[i - 1][j][FROM_RIGHT] + grid[i][j]);
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        answer = Math.max(answer, dp[n][m][FROM_LEFT]);
        answer = Math.max(answer, dp[n][m][FROM_RIGHT]);
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n + 2][m + 2];
        dp = new int[n + 2][m + 2][2];
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                dp[i][j][FROM_LEFT] = Integer.MIN_VALUE;
                dp[i][j][FROM_RIGHT] = Integer.MIN_VALUE;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m + 1; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sol();

        bw.flush();
        bw.close();
        br.close();
    }
}