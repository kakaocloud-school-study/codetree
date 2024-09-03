package lim.DP;

import java.util.*;
import java.io.*;

public class 작은_구간에서_큰_구간으로_확장되는_DP_3개씩_합치기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int[][] dp;

    static int func(int s, int e) {
        if (s + 1 >= e) {
            return 0;
        }
        if (s + 2 == e) {
            dp[s][e] = arr[s] * arr[s + 1] * arr[s + 2];
            return dp[s][e];
        }
        if (dp[s][e] != 0) {
            return dp[s][e];
        }

        int minValue = Integer.MAX_VALUE;
        for (int i = s + 1; i < e; i++) {
            int subCost = func(s, i) + func(i, e);
            int cost = subCost + arr[s] * arr[i] * arr[e];
            minValue = Math.min(minValue, cost);
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
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol(n);
        br.close();
        bw.flush();
        bw.close();
    }
}
