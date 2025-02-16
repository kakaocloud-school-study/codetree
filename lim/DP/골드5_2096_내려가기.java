package lim.DP;

import java.util.*;
import java.io.*;

public class 골드5_2096_내려가기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] items;

    static void sol() throws IOException {
        int[][][] dp = new int[items.length][items[0].length][2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j][0] = Integer.MIN_VALUE;
                dp[i][j][1] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i][0] = items[0][i];
            dp[0][i][1] = items[0][i];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int prevJ = j - 1; prevJ <= j + 1; prevJ++) {
                    if (prevJ < 0 || prevJ >= dp[0].length) {
                        continue;
                    }
                    dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][prevJ][0] + items[i][j]);
                    dp[i][j][1] = Math.min(dp[i][j][1], dp[i - 1][prevJ][1] + items[i][j]);
                }
            }
        }

        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < dp[0].length; i++) {
            maxValue = Math.max(maxValue, dp[dp.length - 1][i][0]);
            minValue = Math.min(minValue, dp[dp.length - 1][i][1]);
        }
        bw.write(maxValue + " " + minValue);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        items = new int[n][3];
        for (int i = 0; i < items.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < items[0].length; j++) {
                items[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}