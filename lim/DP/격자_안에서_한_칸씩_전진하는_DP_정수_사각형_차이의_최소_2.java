/*
 * dp[i][j][currMin]: 1,1에서 i,j까지 왔을 때 최소값이 currMin이고 가능한 경로상 최댓값들중 최소가 dp[i][j][currMin]
 */
package lim.DP;

import java.util.*;
import java.io.*;

public class 격자_안에서_한_칸씩_전진하는_DP_정수_사각형_차이의_최소_2 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][][] dp;
    static int[][] grid;

    static void sol() throws IOException {
        int startValue = grid[1][1];
        dp[1][1][startValue] = startValue;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                for (int currMin = 1; currMin < 101; currMin++) {
                    int currMax = dp[i][j][currMin];
                    if (currMax == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (i + 1 < grid.length) {
                        int downValue = grid[i + 1][j];
                        int newMin = Math.min(currMin, downValue);
                        int newMax = Math.max(currMax, downValue);
                        dp[i + 1][j][newMin] = Math.min(dp[i + 1][j][newMin], newMax);
                    }
                    if (j + 1 < grid.length) {
                        int rightValue = grid[i][j + 1];
                        int newMin = Math.min(currMin, rightValue);
                        int newMax = Math.max(currMax, rightValue);
                        dp[i][j + 1][newMin] = Math.min(dp[i][j + 1][newMin], newMax);
                    }
                }
            }
        }

        int minAbs = 100;
        for (int currMin = 1; currMin < 101; currMin++) {
            int currMax = dp[grid.length - 1][grid.length - 1][currMin];
            if (currMax == Integer.MAX_VALUE) {
                continue;
            }
            int abs = Math.abs(currMin - currMax);
            minAbs = Math.min(minAbs, abs);
        }
        bw.write(String.valueOf(minAbs));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][n + 1][101];
        grid = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                for (int currMin = 1; currMin < 101; currMin++) {
                    dp[i][j][currMin] = Integer.MAX_VALUE;
                }
            }
        }
        sol();
        br.close();
    }
}
