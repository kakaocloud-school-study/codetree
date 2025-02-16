package lim.그리디;

import java.util.*;
import java.io.*;

public class 실버4_2839_설탕_배달 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    static void sol() throws IOException {
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        int[] units = { 3, 5 };
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            for (int unit : units) {
                if (i + unit < dp.length) {
                    dp[i + unit] = Math.min(dp[i + unit], dp[i] + 1);
                }
            }
        }

        if (dp[n] == Integer.MAX_VALUE) {
            bw.write("-1");
            return;
        }
        bw.write(dp[n] + "");
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
