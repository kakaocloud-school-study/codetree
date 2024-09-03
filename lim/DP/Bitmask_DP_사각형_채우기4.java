package lim.DP;

import java.util.*;
import java.io.*;

public class Bitmask_DP_사각형_채우기4 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static final int EMPTY = 0, TOP = 1, MID = 2, BOTTOM = 4;
    static int[][] dp;

    static void sol() throws IOException {
        for (int i = 0; i < dp.length - 1; i++) {
            for (int mask = 0; mask < TOP + MID + BOTTOM; mask++) {
                if (dp[i][mask] == 0) {
                    continue;
                }

                if (mask == EMPTY && i + 2 < dp.length) {
                    dp[i + 2][EMPTY] += dp[i][mask];
                    dp[i + 2][EMPTY] %= 10_007;
                    dp[i + 1][TOP] += dp[i][mask];
                    dp[i + 1][TOP] %= 10_007;
                    dp[i + 1][BOTTOM] += dp[i][mask];
                    dp[i + 1][BOTTOM] %= 10_007;
                }
                if (mask == TOP) {
                    dp[i + 1][EMPTY] += dp[i][mask];
                    dp[i + 1][EMPTY] %= 10_007;
                    dp[i + 1][MID + BOTTOM] += dp[i][mask];
                    dp[i + 1][MID + BOTTOM] %= 10_007;
                }
                if (mask == MID) {
                    dp[i + 1][TOP + BOTTOM] += dp[i][mask];
                    dp[i + 1][TOP + BOTTOM] %= 10_007;
                }
                if (mask == BOTTOM) {
                    dp[i + 1][EMPTY] += dp[i][mask];
                    dp[i + 1][EMPTY] %= 10_007;
                    dp[i + 1][TOP + MID] += dp[i][mask];
                    dp[i + 1][TOP + MID] %= 10_007;
                }
                if (mask == TOP + MID) {
                    dp[i + 1][BOTTOM] += dp[i][mask];
                    dp[i + 1][BOTTOM] %= 10_007;
                }
                if (mask == TOP + BOTTOM) {
                    dp[i + 1][MID] += dp[i][mask];
                    dp[i + 1][MID] %= 10_007;
                }
                if (mask == MID + BOTTOM) {
                    dp[i + 1][TOP] += dp[i][mask];
                    dp[i + 1][TOP] %= 10_007;
                }
            }
        }
        int answer = dp[n][0];
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][TOP + MID + BOTTOM];
        dp[0][EMPTY] = 1;
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
