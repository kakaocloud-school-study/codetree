package lim.누적합;

import java.util.*;
import java.io.*;

public class Prefix_Sum_최대_직사각형_합 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] grid, presumArrs;
    static int[][][] dp;

    static void sol() throws IOException {
        for (int i = 1; i < dp.length; i++) {
            for (int left = 1; left < dp[0].length; left++) {
                for (int right = 1; right < dp[0][0].length; right++) {
                    dp[i][left][right] = Integer.MIN_VALUE;
                }
            }
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid.length; j++) {
                presumArrs[i][j] = presumArrs[i][j - 1] + grid[i][j];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int left = 1; left < dp[0].length; left++) {
                for (int right = left; right < dp[0][0].length; right++) {
                    int preSum = presumArrs[i][right] - presumArrs[i][left - 1];
                    if (dp[i - 1][left][right] < 0) {
                        dp[i][left][right] = preSum;
                    } else {
                        dp[i][left][right] = preSum + dp[i - 1][left][right];
                    }
                }
            }
        }
        int valueMax = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            for (int left = 1; left < dp[0].length; left++) {
                for (int right = 1; right < dp[0][0].length; right++) {
                    valueMax = Math.max(valueMax, dp[i][left][right]);
                }
            }
        }
        bw.write(valueMax + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        grid = new int[n + 1][n + 1];
        presumArrs = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1][n + 1];
        for (int i = 1; i < grid.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < grid.length; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
