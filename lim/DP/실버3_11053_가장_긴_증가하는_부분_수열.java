package lim.DP;

import java.util.*;
import java.io.*;

public class 실버3_11053_가장_긴_증가하는_부분_수열 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;

    static void sol() throws IOException {
        int[] dp = new int[arr.length];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] >= arr[i]) {
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int answer = 0;
        for (int len : dp) {
            answer = Math.max(answer, len);
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}