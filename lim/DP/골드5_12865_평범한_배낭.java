package lim.DP;

import java.util.*;
import java.io.*;

public class 골드5_12865_평범한_배낭 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, wLimit;
    static int[][] items;

    static void sol() throws IOException {
        int[][] dp = new int[items.length][wLimit + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;
        if (items[0][0] <= wLimit) {
            dp[0][items[0][0]] = items[0][1];
        }

        for (int i = 0; i + 1 < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] == -1) {
                    continue;
                }
                int nextWeight = items[i + 1][0];
                int nextValue = items[i + 1][1];
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                if (j + nextWeight <= wLimit) {
                    dp[i + 1][j + nextWeight] = Math.max(dp[i + 1][j + nextWeight], dp[i][j] + nextValue);
                }
            }
        }

        int valueMax = 0;
        for (int weight = 0; weight < dp[0].length; weight++) {
            valueMax = Math.max(valueMax, dp[dp.length - 1][weight]);
        }

        bw.write(valueMax + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        wLimit = Integer.parseInt(st.nextToken());
        items = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}