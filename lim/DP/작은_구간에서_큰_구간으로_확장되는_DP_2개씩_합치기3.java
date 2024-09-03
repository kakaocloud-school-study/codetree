package lim.DP;

import java.util.*;
import java.io.*;

public class 작은_구간에서_큰_구간으로_확장되는_DP_2개씩_합치기3 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr, preSum;
    static int[][] dp;

    static int sumRange(int s, int e) {
        if (s == 0) {
            return preSum[e];
        }
        return preSum[e] - preSum[s - 1];
    }

    static int func(int s, int e) {
        if (s == e) {
            return 0;
        }
        if (dp[s][e] != 0) {
            return dp[s][e];
        }

        int minValue = Integer.MAX_VALUE;
        for (int i = s; i < e; i++) {
            minValue = Math.min(minValue, func(s, i) + func(i + 1, e) + sumRange(s, i) + sumRange(i + 1, e));
        }
        dp[s][e] = minValue;
        return dp[s][e];
    }

    static void sol(int num) throws IOException {
        bw.write(func(0, arr.length - 1) + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        dp = new int[n][n];
        arr = new int[n];
        preSum = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        preSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }
        sol(n);
        br.close();
        bw.flush();
        bw.close();
    }
}
