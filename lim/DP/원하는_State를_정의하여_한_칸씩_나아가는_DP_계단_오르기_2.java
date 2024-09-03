package lim.DP;

import java.util.*;
import java.io.*;

public class 원하는_State를_정의하여_한_칸씩_나아가는_DP_계단_오르기_2 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int[][] dp;

    static void sol() throws IOException {
        int answer = 0;

        for (int i = 0; i < dp[0].length; i++) {
            for (int oneSteps = 0; oneSteps < dp.length; oneSteps++) {
                dp[oneSteps][i] = -1;
            }
        }

        dp[0][0] = 0;

        for (int i = 1; i < dp[0].length; i++) {
            for (int oneSteps = 0; oneSteps + 1 < dp.length; oneSteps++) {
                if (dp[oneSteps][i - 1] == -1) {
                    continue;
                }
                dp[oneSteps + 1][i] = Math.max(dp[oneSteps + 1][i], dp[oneSteps][i - 1] + arr[i]);
            }
            if (i - 2 < 0) {
                continue;
            }
            for (int oneSteps = 0; oneSteps < dp.length; oneSteps++) {
                if (dp[oneSteps][i - 2] == -1) {
                    continue;
                }
                dp[oneSteps][i] = Math.max(dp[oneSteps][i], dp[oneSteps][i - 2] + arr[i]);
            }
        }
        for (int oneSteps = 0; oneSteps < dp.length; oneSteps++) {
            answer = Math.max(dp[oneSteps][dp[0].length - 1], answer);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        dp = new int[4][n + 1];
        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
    }
}
