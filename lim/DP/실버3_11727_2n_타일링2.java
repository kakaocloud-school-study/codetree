package lim.DP;

import java.util.*;
import java.io.*;

public class 실버3_11727_2n_타일링2 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static final int MOD = 10_007;

    static void sol() throws IOException {
        if (n < 2) {
            bw.write("1");
            return;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % MOD;
        }
        bw.write(dp[n] + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}