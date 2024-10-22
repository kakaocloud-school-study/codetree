package lim.DP;

import java.util.*;
import java.io.*;

public class 골드3_7579_앱 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, reqM;
    static final int MAX_C = 10_000;
    static int[][] items;

    static void sol() throws IOException {
        int[][] dp = new int[items.length][MAX_C + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;
        dp[0][items[0][1]] = items[0][0];

        for (int i = 0; i + 1 < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] == -1) {
                    continue;
                }
                int nextM = items[i + 1][0];
                int nextC = items[i + 1][1];
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                if (j + nextC <= MAX_C) {
                    dp[i + 1][j + nextC] = Math.max(dp[i + 1][j + nextC], dp[i][j] + nextM);
                }
            }
        }

        int cMin = Integer.MAX_VALUE;
        for (int cost = 0; cost < dp[0].length; cost++) {
            if (dp[dp.length - 1][cost] >= reqM) {
                cMin = Math.min(cMin, cost);
                break;
            }
        }

        bw.write(cMin + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        reqM = Integer.parseInt(st.nextToken());
        items = new int[n][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < items.length; i++) {
            items[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < items.length; i++) {
            items[i][1] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}