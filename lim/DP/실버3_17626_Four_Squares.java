/*
 * dp[i] = n: 숫자 i를 만드는데 필요한 최소 원소 수 n. i = a1^2 + ... + an^2 (n <= 4)
 * dp[i] = dp[j*j] + dp[i - j*j]
 * dp[i] 하나를 갱신하기 위해 !!sqrt(i)번 순회!! 필요 i번이라고 착각하면 안 됨
 */
package lim.DP;

import java.util.*;
import java.io.*;

public class 실버3_17626_Four_Squares {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    static void sol() throws IOException {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            if (((int) Math.pow((int) Math.sqrt(i), 2)) == i) {
                dp[i] = 1;
                continue;
            }
            for (int j = 1; j * j < i; j++) {
                int num1 = j * j, num2 = i - num1;
                dp[i] = Math.min(dp[i], dp[num1] + dp[num2]);
            }
        }
        bw.write(dp[n] + "\n");
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