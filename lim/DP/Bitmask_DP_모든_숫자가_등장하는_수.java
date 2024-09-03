package lim.DP;

import java.util.*;
import java.io.*;

public class Bitmask_DP_모든_숫자가_등장하는_수 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static final int MAX_MASK = (1 << 10) - 1, MOD = 10_007;
    static int[][][] dp; // 인덱스, 맨앞자리 수, 마스크

    static void sol() throws IOException {
        for (int i = 0; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }
        for (int i = 1; i < dp.length - 1; i++) {
            for (int currNum = 0; currNum < 10; currNum++) {
                for (int mask = 1; mask < MAX_MASK + 1; mask++) {
                    if (dp[i][currNum][mask] == 0) {
                        continue;
                    }
                    if (currNum + 1 < 10) {
                        int newNum = currNum + 1;
                        dp[i + 1][newNum][mask | (1 << newNum)] += dp[i][currNum][mask];
                        dp[i + 1][newNum][mask | (1 << newNum)] %= MOD;
                    }
                    if (currNum - 1 >= 0) {
                        int newNum = currNum - 1;
                        dp[i + 1][newNum][mask | (1 << newNum)] += dp[i][currNum][mask];
                        dp[i + 1][newNum][mask | (1 << newNum)] %= MOD;
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 1; i < 10; i++) {
            answer += dp[n][i][MAX_MASK];
        }
        answer %= MOD;
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][10][MAX_MASK + 1];
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
