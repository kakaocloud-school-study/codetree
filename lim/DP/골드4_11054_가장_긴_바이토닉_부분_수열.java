package lim.DP;

import java.util.*;
import java.io.*;

public class 골드4_11054_가장_긴_바이토닉_부분_수열 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;

    static void sol() throws IOException {
        int[][] dp = new int[arr.length][2];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
                if (arr[j] > arr[i]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
            }
        }

        int valueMax = 1;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                valueMax = Math.max(valueMax, dp[i][j]);
            }
        }

        bw.write(valueMax + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}