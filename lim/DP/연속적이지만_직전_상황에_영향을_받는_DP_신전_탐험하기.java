package lim.DP;

import java.util.*;
import java.io.*;

public class 연속적이지만_직전_상황에_영향을_받는_DP_신전_탐험하기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] dp, items;
    static int n;

    static void sol(int num) throws IOException {
        for (int i = 1; i <= n; i++) {
            for (int roomIdx = 0; roomIdx < 3; roomIdx++) {
                for (int prevRoomIdx = 0; prevRoomIdx < 3; prevRoomIdx++) {
                    if (roomIdx == prevRoomIdx) {
                        continue;
                    }
                    dp[i][roomIdx] = Math.max(dp[i][roomIdx], dp[i - 1][prevRoomIdx] + items[i][roomIdx]);
                }
            }
        }

        int answer = 0;
        for (int roomIdx = 0; roomIdx < 3; roomIdx++) {
            answer = Math.max(answer, dp[n][roomIdx]);
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][4];
        items = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                items[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol(n);
        br.close();
    }
}