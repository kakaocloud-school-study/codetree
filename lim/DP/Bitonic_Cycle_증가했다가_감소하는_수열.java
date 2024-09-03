package lim.DP;

import java.util.*;
import java.io.*;

public class Bitonic_Cycle_증가했다가_감소하는_수열 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static long[][][] dp;
    static int[] nums;

    static void sol() throws IOException {
        for (int i = 0; i < dp.length - 1; i++) {
            for (int j = 0; j <= i; j++) {
                for (int k = 0; k <= i; k++) {
                    if (dp[i][j][k] == 0) {
                        continue;
                    }
                    int nextIdx = i + 1;
                    int jNum = nums[j];
                    int kNum = nums[k];
                    int nextNum = nums[nextIdx];

                    if (jNum < nextNum) {
                        dp[nextIdx][nextIdx][k] += dp[i][j][k];
                        dp[nextIdx][nextIdx][k] %= 10_007;
                    }
                    if (kNum < nextNum) {
                        dp[nextIdx][j][nextIdx] += dp[i][j][k];
                        dp[nextIdx][j][nextIdx] %= 10_007;
                    }
                    dp[nextIdx][j][k] += dp[i][j][k];
                    dp[nextIdx][j][k] %= 10_007;
                }
            }
        }
        long answer = 0;
        for (int j = 0; j < dp[0].length; j++) {
            if (dp[n - 1][j][n - 1] == 0) {
                continue;
            }
            if (nums[j] < nums[n - 1]) {
                answer += dp[n - 1][j][n - 1];
                answer %= 10_007;
            }
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dp = new long[n][n][n];
        dp[0][0][0] = 1;
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
    }
}
