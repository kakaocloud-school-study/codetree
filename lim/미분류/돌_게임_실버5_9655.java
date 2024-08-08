package lim.미분류;

import java.util.*;
import java.io.*;

public class 돌_게임_실버5_9655 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static boolean[] dp;

    static void sol() throws IOException {
        dp[1] = true;
        for (int i = 2; i < dp.length; i++) {
            if (dp[i - 1] == false) {
                dp[i] |= true;
            }
            if (i > 3 && dp[i - 3] == false) {
                dp[i] |= true;
            }
        }

        if (dp[n]) {
            bw.write("SK");
            return;
        }
        bw.write("CY");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        dp = new boolean[n + 1];
        sol();

        bw.flush();
        bw.close();
        br.close();
    }
}