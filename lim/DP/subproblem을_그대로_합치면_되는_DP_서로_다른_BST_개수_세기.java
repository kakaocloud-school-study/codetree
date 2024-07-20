/*
 * dp[L][R]: 왼쪽에 L개 노드, 오른쪽에 R개 노드가 있을 때 가능한 BST 개수
 */
package lim.DP;

import java.util.*;
import java.io.*;

public class subproblem을_그대로_합치면_되는_DP_서로_다른_BST_개수_세기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] dp;

    static int func(int leftCount, int rightCount) {
        int leftTotal = 0;
        int rightTotal = 0;
        if (leftCount == 0) {
            leftTotal = 1;
        }
        if (rightCount == 0) {
            rightTotal = 1;
        }
        if (dp[leftCount][rightCount] != 0) {
            return dp[leftCount][rightCount];
        }

        for (int i = 0; i < leftCount; i++) {
            leftTotal += func(i, leftCount - 1 - i);
        }

        for (int i = 0; i < rightCount; i++) {
            rightTotal += func(i, rightCount - 1 - i);
        }

        int total = leftTotal * rightTotal;
        dp[leftCount][rightCount] = total;
        return total;
    }

    static void sol(int num) throws IOException {
        int answer = 0;
        for (int i = 0; i < num; i++) {
            answer += func(i, num - 1 - i);
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][n + 1];
        sol(n);
        br.close();
    }
}
