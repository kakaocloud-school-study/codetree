package lim.DP;

import java.util.*;
import java.io.*;

public class 실버3_9461_파도반_수열 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    static void sol() throws IOException {
        if (n < 4) {
            bw.write("1\n");
            return;
        }
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }
        bw.write(dp[n] + "\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            sol();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}