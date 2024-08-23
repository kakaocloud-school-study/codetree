package lim.DP;

import java.util.*;
import java.io.*;

public class Bitonic_Cycle_두_사람과_카드 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static long[][] dp;
    static int[] nums;

    static void sol() throws IOException {
        for (int i = 0; i < dp.length - 1; i++) {
            for (int j = 0; j < dp[0].length - 1; j++) {
                if (dp[i][j] == Long.MAX_VALUE) {
                    continue;
                }
                int nextIdx = Math.max(i, j) + 1;
                int iNum = nums[i];
                int jNum = nums[j];
                int nextNum = nums[nextIdx];

                if (i == 0) {
                    dp[nextIdx][j] = Math.min(dp[nextIdx][j], dp[i][j]);
                } else {
                    dp[nextIdx][j] = Math.min(dp[nextIdx][j], dp[i][j] + Math.abs(nextNum - iNum));
                }

                if (j == 0) {
                    dp[i][nextIdx] = Math.min(dp[i][nextIdx], dp[i][j]);
                } else {
                    dp[i][nextIdx] = Math.min(dp[i][nextIdx], dp[i][j] + Math.abs(nextNum - jNum));
                }
            }
        }
        long answer = Long.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            answer = Math.min(answer, dp[i][n]);
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dp = new long[n + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Long.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        nums = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
    }
}
