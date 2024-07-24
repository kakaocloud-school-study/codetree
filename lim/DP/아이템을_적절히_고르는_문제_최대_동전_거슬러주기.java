package lim.DP;

import java.util.*;
import java.io.*;

public class 아이템을_적절히_고르는_문제_최대_동전_거슬러주기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dp, arr;

    static void sol() throws IOException {
        for (int currSum = 1; currSum < dp.length; currSum++) {
            dp[currSum] = -1;
        }

        dp[0] = 0;
        for (int currSum = 0; currSum < dp.length; currSum++) {
            if (dp[currSum] == -1) {
                continue;
            }
            for (int i = 0; i < arr.length; i++) {
                int currVal = arr[i];
                int nextSum = currSum + currVal;
                if (nextSum >= dp.length) {
                    continue;
                }
                dp[nextSum] = Math.max(dp[nextSum], dp[currSum] + 1);
            }
        }

        int answer = dp[dp.length - 1];
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dp = new int[m + 1];
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
    }
}
