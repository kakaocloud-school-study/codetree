package lim.DP;

import java.util.*;
import java.io.*;

public class 원하는_State를_정의하여_한_칸씩_나아가는_DP_게임_스튜디오에서_살아남기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[][][] dp;

    static void sol() throws IOException {
        long answer = 0;

        dp[0][0][0] = 1;

        for (int i = 1; i < dp[0][0].length; i++) {
            for (int bCombo = 0; bCombo < dp.length; bCombo++) {
                for (int tTotal = 0; tTotal < dp[0].length; tTotal++) {
                    // 현재 G인 경우
                    if (bCombo == 0) {
                        dp[bCombo][tTotal][i] += dp[0][tTotal][i - 1] + dp[1][tTotal][i - 1] + dp[2][tTotal][i - 1];
                    }
                    // 현재 B인 경우
                    if (bCombo > 0) {
                        dp[bCombo][tTotal][i] += dp[bCombo - 1][tTotal][i - 1];
                    }
                    // 현재 T인 경우
                    if (tTotal > 0 && bCombo == 0) {
                        dp[bCombo][tTotal][i] += dp[0][tTotal - 1][i - 1] + dp[1][tTotal - 1][i - 1]
                                + dp[2][tTotal - 1][i - 1];
                    }
                    dp[bCombo][tTotal][i] %= 1_000_000_007;
                }
            }
        }

        for (int bCombo = 0; bCombo < dp.length; bCombo++) {
            for (int tTotal = 0; tTotal < dp[0].length; tTotal++) {
                answer += dp[bCombo][tTotal][dp[0][0].length - 1];
                answer %= 1_000_000_007;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        dp = new long[3][3][n + 1];
        sol();
        br.close();
    }
}