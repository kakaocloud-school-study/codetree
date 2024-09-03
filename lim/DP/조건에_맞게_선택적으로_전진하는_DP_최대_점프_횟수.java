package lim.DP;

import java.util.*;
import java.io.*;

public class 조건에_맞게_선택적으로_전진하는_DP_최대_점프_횟수 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dp, arr;

    static void sol() throws IOException {
        for (int i = 1; i < dp.length; i++) {
            dp[i] = -1;
            for (int j = 0; j < i; j++) {
                if (j + arr[j] < i || dp[j] == -1) {
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int answer = 0;
        for (int num : dp) {
            // bw.write(String.valueOf(num) + " ");
            answer = Math.max(num, answer);
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        dp = new int[n];
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
    }
}
