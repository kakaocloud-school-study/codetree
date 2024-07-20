package lim.DP;

import java.util.*;
import java.io.*;

public class subproblem을_그대로_합치면_되는_DP_사각형_채우기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dp;

    static int func(int num) {
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10_007;
        }

        return dp[num];
    }

    static void sol(int num) throws IOException {
        dp[1] = 1;
        dp[2] = 2;
        int answer = func(num);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        dp = new int[Math.max(4, n + 1)];
        sol(n);
        br.close();
    }
}
