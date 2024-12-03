package lim.DP;

import java.util.*;
import java.io.*;

public class 골드5_9251_LCS {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String word1, word2;

    static void sol() throws IOException {
        int[][] dp = new int[word1.length()][word2.length()];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    if (i > 0 && j > 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                    } else {
                        dp[i][j] = Math.max(dp[i][j], 1);
                    }

                }
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
            }
        }
        bw.write(dp[dp.length - 1][dp[0].length - 1] + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        word1 = st.nextToken();
        st = new StringTokenizer(br.readLine());
        word2 = st.nextToken();
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}