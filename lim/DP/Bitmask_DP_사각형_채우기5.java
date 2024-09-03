/*
 * 뇌절 진짜
 */
package lim.DP;

import java.util.*;
import java.io.*;

public class Bitmask_DP_사각형_채우기5 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static final int MOD = 10_007;
    static int[][][][][] dp;

    static void sol() throws IOException {
        for (int i = 0; i <= n; i++) {
            dp[i + 1][1][0][0][1] += dp[i][0][0][0][0];
            dp[i + 1][1][0][0][1] %= MOD;
            dp[i + 1][1][1][0][0] += dp[i][0][0][0][0];
            dp[i + 1][1][1][0][0] %= MOD;
            dp[i + 1][0][0][1][1] += dp[i][0][0][0][0];
            dp[i + 1][0][0][1][1] %= MOD;
            dp[i + 1][0][0][0][0] += dp[i][0][0][0][0];
            dp[i + 1][0][0][0][0] %= MOD;
            dp[i + 1][1][1][1][1] += dp[i][0][0][0][0];
            dp[i + 1][1][1][1][1] %= MOD;

            dp[i + 1][1][0][0][0] += dp[i][0][0][0][1];
            dp[i + 1][1][0][0][0] %= MOD;
            dp[i + 1][0][0][1][0] += dp[i][0][0][0][1];
            dp[i + 1][0][0][1][0] %= MOD;
            dp[i + 1][1][1][1][0] += dp[i][0][0][0][1];
            dp[i + 1][1][1][1][0] %= MOD;

            dp[i + 1][0][0][0][1] += dp[i][0][0][1][0];
            dp[i + 1][0][0][0][1] %= MOD;
            dp[i + 1][1][1][0][1] += dp[i][0][0][1][0];
            dp[i + 1][1][1][0][1] %= MOD;

            dp[i + 1][1][0][0][0] += dp[i][0][1][0][0];
            dp[i + 1][1][0][0][0] %= MOD;
            dp[i + 1][1][0][1][1] += dp[i][0][1][0][0];
            dp[i + 1][1][0][1][1] %= MOD;

            dp[i + 1][0][0][0][1] += dp[i][1][0][0][0];
            dp[i + 1][0][0][0][1] %= MOD;
            dp[i + 1][0][1][0][0] += dp[i][1][0][0][0];
            dp[i + 1][0][1][0][0] %= MOD;
            dp[i + 1][0][1][1][1] += dp[i][1][0][0][0];
            dp[i + 1][0][1][1][1] %= MOD;

            dp[i + 1][0][0][0][0] += dp[i][0][0][1][1];
            dp[i + 1][0][0][0][0] %= MOD;
            dp[i + 1][1][1][0][0] += dp[i][0][0][1][1];
            dp[i + 1][1][1][0][0] %= MOD;

            dp[i + 1][1][0][1][0] += dp[i][0][1][0][1];
            dp[i + 1][1][0][1][0] %= MOD;

            dp[i + 1][1][0][0][1] += dp[i][0][1][1][0];
            dp[i + 1][1][0][0][1] %= MOD;

            dp[i + 1][0][1][1][0] += dp[i][1][0][0][1];
            dp[i + 1][0][1][1][0] %= MOD;
            dp[i + 1][0][0][0][0] += dp[i][1][0][0][1];
            dp[i + 1][0][0][0][0] %= MOD;

            dp[i + 1][0][1][0][1] += dp[i][1][0][1][0];
            dp[i + 1][0][1][0][1] %= MOD;

            dp[i + 1][0][0][1][1] += dp[i][1][1][0][0];
            dp[i + 1][0][0][1][1] %= MOD;
            dp[i + 1][0][0][0][0] += dp[i][1][1][0][0];
            dp[i + 1][0][0][0][0] %= MOD;

            dp[i + 1][1][0][0][0] += dp[i][0][1][1][1];
            dp[i + 1][1][0][0][0] %= MOD;

            dp[i + 1][0][1][0][0] += dp[i][1][0][1][1];
            dp[i + 1][0][1][0][0] %= MOD;

            dp[i + 1][0][0][1][0] += dp[i][1][1][0][1];
            dp[i + 1][0][0][1][0] %= MOD;

            dp[i + 1][0][0][0][1] += dp[i][1][1][1][0];
            dp[i + 1][0][0][0][1] %= MOD;

            dp[i + 1][0][0][0][0] += dp[i][1][1][1][1];
            dp[i + 1][0][0][0][0] %= MOD;
        }
        int answer = dp[n + 1][0][0][0][0];
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dp = new int[n + 2][2][2][2][2];
        dp[1][0][0][0][0] = 1;
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
