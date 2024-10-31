package lim.DP;

import java.util.*;
import java.io.*;

public class 실버1_1149_RGB거리 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] rgbs;

    static void sol() throws IOException {
        int[][] dp = new int[rgbs.length][rgbs[0].length];

        for (int i = 0; i < dp.length; i++) {
            for (int color = 0; color < dp[0].length; color++) {
                dp[i][color] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = rgbs[0][0];
        dp[0][1] = rgbs[0][1];
        dp[0][2] = rgbs[0][2];

        for (int i = 1; i < dp.length; i++) {
            for (int color = 0; color < dp[0].length; color++) {
                for (int prevColor = 0; prevColor < dp[0].length; prevColor++) {
                    if (dp[i - 1][prevColor] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (prevColor == color) {
                        continue;
                    }
                    dp[i][color] = Math.min(dp[i][color], dp[i - 1][prevColor] + rgbs[i][color]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int color = 0; color < dp[0].length; color++) {
            answer = Math.min(answer, dp[dp.length - 1][color]);
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        rgbs = new int[n][3];
        for (int i = 0; i < rgbs.length; i++) {
            st = new StringTokenizer(br.readLine());
            rgbs[i][0] = Integer.parseInt(st.nextToken());
            rgbs[i][1] = Integer.parseInt(st.nextToken());
            rgbs[i][2] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}