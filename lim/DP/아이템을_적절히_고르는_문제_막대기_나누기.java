package lim.DP;

import java.util.*;
import java.io.*;

public class 아이템을_적절히_고르는_문제_막대기_나누기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dp, arr;

    static void sol() throws IOException {
        for (int currLenSum = 1; currLenSum < dp.length; currLenSum++) {
            dp[currLenSum] = -1;
        }
        for (int currLenSum = 1; currLenSum < dp.length; currLenSum++) {
            for (int currLen = 1; currLen < arr.length; currLen++) {
                int currVal = arr[currLen];
                int prevLenSum = currLenSum - currLen;
                if (prevLenSum < 0 || dp[prevLenSum] == -1) {
                    continue;
                }
                dp[currLenSum] = Math.max(dp[currLenSum], dp[prevLenSum] + currVal);
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
        dp = new int[n + 1];
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
    }
}
