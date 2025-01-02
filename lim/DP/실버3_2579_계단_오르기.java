package lim.DP;

import java.util.*;
import java.io.*;

public class 실버3_2579_계단_오르기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] points;

    static void sol() throws IOException {
        int[][] dp = new int[points.length][3];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int combo = 1; combo < dp[0].length; combo++) {
                for (int prevCombo = 0; prevCombo < dp[0].length; prevCombo++) {
                    if (i > 1 && combo == 1 && dp[i - 2][prevCombo] != -1) {
                        dp[i][combo] = Math.max(dp[i][combo], dp[i - 2][prevCombo] + points[i]);
                    }
                    if (combo == prevCombo + 1 && dp[i - 1][prevCombo] != -1) {
                        dp[i][combo] = Math.max(dp[i][combo], dp[i - 1][prevCombo] + points[i]);
                    }
                }
            }
        }

        int maxVal = 0;
        for (int combo = 1; combo < dp[0].length; combo++) {
            maxVal = Math.max(maxVal, dp[dp.length - 1][combo]);
        }
        bw.write(maxVal + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        points = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            points[i] = Integer.parseInt(br.readLine());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}