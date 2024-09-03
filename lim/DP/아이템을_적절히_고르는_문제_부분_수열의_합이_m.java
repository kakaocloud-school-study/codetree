package lim.DP;

import java.util.*;
import java.io.*;

public class 아이템을_적절히_고르는_문제_부분_수열의_합이_m {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dp, arr;

    static void sol() throws IOException {
        for (int currSum = dp.length - 1; currSum >= 1; currSum--) {
            dp[currSum] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < arr.length; i++) {
            int currVal = arr[i];
            for (int currSum = dp.length - 1; currSum >= 1; currSum--) {
                int prevSum = currSum - currVal;
                if (prevSum < 0 || dp[prevSum] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[currSum] = Math.min(dp[currSum], dp[prevSum] + 1);
            }
        }

        int answer = dp[dp.length - 1];
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
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
