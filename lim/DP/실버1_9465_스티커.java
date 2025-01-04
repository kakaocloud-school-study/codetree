package lim.DP;

import java.util.*;
import java.io.*;

public class 실버1_9465_스티커 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] items;
    private static final int UP = 0, DOWN = 1, NONE = 2;

    static void sol() throws IOException {
        int[][] dp = new int[items.length][3];
        dp[0][UP] = items[0][UP];
        dp[0][DOWN] = items[0][DOWN];
        for (int i = 1; i < dp.length; i++) {
            dp[i][NONE] = Math.max(dp[i - 1][NONE], Math.max(dp[i - 1][UP], dp[i - 1][DOWN]));
            dp[i][UP] = Math.max(dp[i - 1][NONE], dp[i - 1][DOWN]) + items[i][UP];
            dp[i][DOWN] = Math.max(dp[i - 1][NONE], dp[i - 1][UP]) + items[i][DOWN];
        }
        bw.write(Math.max(dp[dp.length - 1][NONE], Math.max(dp[dp.length - 1][UP], dp[dp.length - 1][DOWN])) + "\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            items = new int[n][2];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < items.length; i++) {
                items[i][UP] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < items.length; i++) {
                items[i][DOWN] = Integer.parseInt(st.nextToken());
            }
            sol();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}