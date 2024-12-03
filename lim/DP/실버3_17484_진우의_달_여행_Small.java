package lim.DP;

import java.util.*;
import java.io.*;

public class 실버3_17484_진우의_달_여행_Small {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] grid;

    static void sol() throws IOException {
        int[][][] dp = new int[grid.length][grid[0].length][3];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0][0].length; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        for (int j = 0; j < dp[0].length; j++) {
            for (int k = 0; k < dp[0][0].length; k++) {
                dp[0][j][k] = grid[0][j];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0][0].length; k++) {
                    int dj = k - 1;
                    int prevJ = j + dj;
                    if (prevJ < 0 || prevJ >= dp[0].length) {
                        continue;
                    }

                    for (int prevK = 0; prevK < dp[0][0].length; prevK++) {
                        if (dp[i - 1][prevJ][prevK] == Integer.MAX_VALUE) {
                            continue;
                        }
                        if (k == prevK) {
                            continue;
                        }
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][prevJ][prevK] + grid[i][j]);
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int j = 0; j < dp[0].length; j++) {
            for (int k = 0; k < dp[0][0].length; k++) {
                answer = Math.min(answer, dp[dp.length - 1][j][k]);
            }
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        for (int i = 0; i < grid.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}