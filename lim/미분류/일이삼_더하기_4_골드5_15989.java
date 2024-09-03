/*
 * 합이 n이 되는 중복조합의 경우의 수 구하기 문제
 * dp[마지막숫자][중복조합 수열 길이]: 특정 마지막 숫자를 가지는 특정 길이 오름차순 수열(1,2,3으로만 구성) 경우의 수
 * 오름차순 수열로 가정하지 않는다면 중복된 경우의수가 포함된다
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 일이삼_더하기_4_골드5_15989 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] dp;
    static final int MAX_SUM = 10_000;

    static void sol(int[] queries) throws IOException {
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][3] = 1;
        for (int currSum = 1; currSum <= MAX_SUM; currSum++) {
            for (int num = 1; num <= 3; num++) {
                if (dp[num][currSum] == 0) {
                    continue;
                }
                for (int nextNum = num; nextNum <= 3; nextNum++) {
                    int newSum = currSum + nextNum;
                    if (newSum > MAX_SUM) {
                        continue;
                    }
                    dp[nextNum][newSum] += dp[num][currSum];
                }
            }
        }

        for (int i = 0; i < queries.length; i++) {
            bw.write(dp[1][queries[i]] + dp[2][queries[i]] + dp[3][queries[i]] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        dp = new int[4][MAX_SUM + 1];
        int[] queries = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i] = Integer.parseInt(st.nextToken());
        }
        sol(queries);
        br.close();
    }
}
