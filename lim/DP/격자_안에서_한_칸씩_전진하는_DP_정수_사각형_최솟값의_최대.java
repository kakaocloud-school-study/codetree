package lim.DP;

import java.util.*;
import java.io.*;

public class 격자_안에서_한_칸씩_전진하는_DP_정수_사각형_최솟값의_최대 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] dp;

    static void sol() throws IOException {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                int candidate = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (candidate == 0) {
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j], candidate);
            }
        }
        bw.write(String.valueOf(dp[dp.length - 1][dp.length - 1]));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol();
        br.close();
    }
}
