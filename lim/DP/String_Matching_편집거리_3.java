package lim.DP;

import java.util.*;
import java.io.*;

public class String_Matching_편집거리_3 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] dp;
    static String[] str1, str2;

    static void sol() throws IOException {
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (str1[i].equals(str2[j])) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 2);
                }
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
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
        String[] words = st.nextToken().split("");
        str1 = new String[words.length + 1];
        str1[0] = "";
        for (int i = 1; i <= words.length; i++) {
            str1[i] = words[i - 1];
        }
        st = new StringTokenizer(br.readLine());
        words = st.nextToken().split("");
        str2 = new String[words.length + 1];
        str2[0] = "";
        for (int i = 1; i <= words.length; i++) {
            str2[i] = words[i - 1];
        }

        dp = new int[str1.length][str2.length];
        sol();
        br.close();
    }
}
