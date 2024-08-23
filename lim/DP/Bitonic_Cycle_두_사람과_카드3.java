/*
 * dp[i][j][k][l]: i, j 번 카드까지 두사람이 각각 골랐고 k번 카드까지 버렸고 l번 카드를 버렸을 때 점수합 최소
 */
package lim.DP;

import java.util.*;
import java.io.*;

public class Bitonic_Cycle_두_사람과_카드3 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static long[][][][] dp;
    static int[] nums;

    static void sol() throws IOException {
        for (int i = 0; i < dp.length - 1; i++) {
            for (int j = 0; j < dp[0].length - 1; j++) {
                for (int k = 0; k < dp[0][0].length - 1; k++) {
                    for (int l = 0; l < dp[0][0][0].length; l++) {
                        if (dp[i][j][k][l] == Long.MAX_VALUE) {
                            continue;
                        }
                        int nextIdx = Math.max(Math.max(i, j), k) + 1;
                        int iNum = nums[i];
                        int jNum = nums[j];
                        int nextNum = nums[nextIdx];

                        if (i == 0) {
                            dp[nextIdx][j][k][l] = Math.min(dp[nextIdx][j][k][l], dp[i][j][k][l]);
                        } else {
                            dp[nextIdx][j][k][l] = Math.min(dp[nextIdx][j][k][l],
                                    dp[i][j][k][l] + Math.abs(nextNum - iNum));
                        }

                        if (j == 0) {
                            dp[i][nextIdx][k][l] = Math.min(dp[i][nextIdx][k][l], dp[i][j][k][l]);
                        } else {
                            dp[i][nextIdx][k][l] = Math.min(dp[i][nextIdx][k][l],
                                    dp[i][j][k][l] + Math.abs(nextNum - jNum));
                        }

                        if (l < m) {
                            dp[i][j][nextIdx][l + 1] = Math.min(dp[i][j][nextIdx][l + 1], dp[i][j][k][l]);
                        }
                    }
                }
            }
        }
        long answer = Long.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0][0].length; k++) {
                    if (i != n && j != n && k != n) {
                        continue;
                    }
                    for (int l = 0; l < m + 1; l++) {
                        answer = Math.min(answer, dp[i][j][k][l]);
                    }
                }
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
        m = Integer.parseInt(st.nextToken());
        dp = new long[n + 1][n + 1][n + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0][0].length; k++) {
                    for (int l = 0; l < dp[0][0][0].length; l++) {
                        dp[i][j][k][l] = Long.MAX_VALUE;
                    }
                }
            }
        }
        dp[0][0][0][0] = 0;
        nums = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
    }
}
