package lim.미분류;

import java.util.*;
import java.io.*;

public class 골드2_16565_N포커 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static final int CARD_TYPES = 13, TOTAL_CARDS = CARD_TYPES * 4, MOD = 10_007;

    static class Comb {
        long[][] comb;

        Comb(int maxNum) {
            comb = new long[maxNum + 1][maxNum + 1];

            for (int i = 0; i < comb.length; i++) {
                comb[i][0] = 1;
                for (int j = 1; j <= i; j++) {
                    comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
                }
            }
        }

        long cal(int n, int k) {
            return comb[n][k] % MOD;
        }
    }

    static void sol() throws IOException {
        Comb comb = new Comb(TOTAL_CARDS);
        int maxFCount = n / 4;
        long[] dp = new long[maxFCount + 2];

        for (int fCount = maxFCount; fCount > 0; fCount--) {
            int fourCards = fCount * 4;
            int nonFourCards = TOTAL_CARDS - fourCards;
            int bonus = n - fourCards;
            dp[fCount] = comb.cal(CARD_TYPES, fCount) * comb.cal(nonFourCards, bonus) - dp[fCount + 1];
            if (dp[fCount] < 0) {
                dp[fCount] += MOD;
            }
            dp[fCount] %= MOD;
        }

        bw.write(dp[1] + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}