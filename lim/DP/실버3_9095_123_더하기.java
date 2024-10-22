package lim.DP;

import java.util.*;
import java.io.*;

public class 실버3_9095_123_더하기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int MAX_NUM = 10;
    static int[] queries;

    static void sol() throws IOException {
        int[] dp = new int[MAX_NUM + 1];
        dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 0) {
                continue;
            }
            for (int num = 1; num < 4; num++) {
                if (i + num > MAX_NUM) {
                    continue;
                }
                dp[i + num] += dp[i];
            }
        }

        for (int num : queries) {
            bw.write(dp[num] + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        queries = new int[n];
        for (int i = 0; i < queries.length; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}