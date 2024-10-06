/*
 * 가장 긴 오름차순 배열을 찾는다
 * 그 배열 사이사이에 나머지 원소를 끼워넣어 재배열 하는 것이 최적의 이동
 * 즉, 답은 "n - 오름차순배열길이"
 * 길이는 DP로 구한다
 * dp[i]: i번 원소로 끝나는 배열중 최대 길이
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 줄세우기_골드4_2631 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;

    static void sol() throws IOException {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int maxAscLen = 1;
        for (int i = 0; i < dp.length; i++) {
            maxAscLen = Math.max(maxAscLen, dp[i]);
        }
        bw.write(n - maxAscLen + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
