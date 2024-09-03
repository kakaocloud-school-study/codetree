package lim.DP;

import java.util.*;
import java.io.*;

public class 작은_구간에서_큰_구간으로_확장되는_DP_인접한_두_수와_차 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int[][][] dp;

    static void sol(int num) throws IOException {
        for (int i = 0; i < arr.length; i++) {
            dp[i][i][arr[i]] = 0;
        }
        for (int gap = 1; gap < arr.length; gap++) {
            for (int i = 0; i + gap < arr.length; i++) {
                int j = i + gap;
                for (int k = i; k < j; k++) {
                    for (int left = 0; left < 11; left++) {
                        if (dp[i][k][left] == Integer.MIN_VALUE) {
                            continue;
                        }
                        int leftScore = dp[i][k][left];
                        for (int right = 0; right < 11; right++) {
                            if (dp[k + 1][j][right] == Integer.MIN_VALUE) {
                                continue;
                            }
                            int rightScore = dp[k + 1][j][right];

                            int diff = Math.abs(left - right);
                            dp[i][j][diff] = Math.max(dp[i][j][diff], leftScore + rightScore + right + left);
                        }
                    }
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < 11; i++) {
            answer = Math.max(answer, dp[0][arr.length - 1][i]);
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        dp = new int[n][n][11];
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0][0].length; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        sol(n);
        br.close();
        bw.flush();
        bw.close();
    }
}
