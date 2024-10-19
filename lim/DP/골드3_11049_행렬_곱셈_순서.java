package lim.DP;

import java.util.*;
import java.io.*;

public class 골드3_11049_행렬_곱셈_순서 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] items, dp;

    static int func(int sIdx, int eIdx) {
        if (sIdx == eIdx) {
            return 0;
        }
        if (dp[sIdx][eIdx] != 0) {
            return dp[sIdx][eIdx];
        }

        int minCount = Integer.MAX_VALUE;

        for (int i = sIdx; i < eIdx; i++) {
            int newCount = func(sIdx, i) + func(i + 1, eIdx) + items[sIdx][0] * items[i][1] * items[eIdx][1];
            minCount = Math.min(minCount, newCount);
        }

        dp[sIdx][eIdx] = minCount;
        return minCount;
    }

    static void sol() throws IOException {
        dp = new int[items.length][items.length];

        int answer = func(0, items.length - 1);

        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        items = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}