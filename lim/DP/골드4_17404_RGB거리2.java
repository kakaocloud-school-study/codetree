package lim.DP;

import java.util.*;
import java.io.*;

public class 골드4_17404_RGB거리2 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static final int R = 0, G = 1, B = 2;
    static int[][] costs;

    static int getMinCost(int initColor) {
        int[][] dp = new int[costs.length][3];
        for (int i = 0; i < dp.length; i++) {
            for (int color = 0; color < dp[0].length; color++) {
                dp[i][color] = Integer.MAX_VALUE;
            }
        }
        dp[0][initColor] = costs[0][initColor];
        for (int i = 1; i < dp.length; i++) {
            for (int color = 0; color < dp[0].length; color++) {
                if (i == dp.length - 1 && color == initColor) {
                    continue;
                }
                for (int prevColor = 0; prevColor < dp[0].length; prevColor++) {
                    if (color == prevColor || dp[i - 1][prevColor] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[i][color] = Math.min(dp[i][color], dp[i - 1][prevColor] + costs[i][color]);
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int color = 0; color < dp[0].length; color++) {
            minCost = Math.min(minCost, dp[dp.length - 1][color]);
        }
        return minCost;
    }

    static void sol() throws IOException {
        int minCost = Integer.MAX_VALUE;
        for (int color = 0; color < costs[0].length; color++) {
            minCost = Math.min(minCost, getMinCost(color));
        }
        bw.write(minCost + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        costs = new int[n][3];
        for (int i = 0; i < costs.length; i++) {
            st = new StringTokenizer(br.readLine());
            costs[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()) };
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}