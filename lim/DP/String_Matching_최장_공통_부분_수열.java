package lim.DP;

import java.util.*;
import java.io.*;

public class String_Matching_최장_공통_부분_수열 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] dp;
    static String[] str1, str2;

    static void sol() throws IOException {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (str1[i].equals(str2[j])) {
                    int prev = 0;
                    if (i > 0 && j > 0) {
                        prev = dp[i - 1][j - 1];
                    }
                    dp[i][j] = Math.max(dp[i][j], prev + 1);
                }
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
            }
        }
        int answer = dp[dp.length - 1][dp[0].length - 1];
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        str1 = st.nextToken().split("");
        st = new StringTokenizer(br.readLine());
        str2 = st.nextToken().split("");
        dp = new int[str1.length][str2.length];
        sol();
        br.close();
    }
}
