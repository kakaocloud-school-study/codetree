package lim.DP;

import java.util.*;
import java.io.*;

public class 연속적이지만_직전_상황에_영향을_받는_DP_숫자_퍼즐 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][][] dp; // dp[맨앞 숫자][총합][i자리 수열] = 가능한 수열 수
    static int n, m, k;

    static void sol() throws IOException {
        dp = new int[m + 1][m + 1][n + 1];
        for (int num = 1; num <= m; num++) {
            dp[num][num][1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int prevFrontNum = 1; prevFrontNum <= m; prevFrontNum++) {
                for (int frontNum = 1; frontNum <= prevFrontNum; frontNum++) {
                    for (int numSum = 0; numSum <= m; numSum++) {
                        int prevNumSum = numSum - frontNum;
                        if (prevNumSum < 0 || dp[prevFrontNum][prevNumSum][i - 1] == 0) {
                            continue;
                        }
                        dp[frontNum][numSum][i] += dp[prevFrontNum][prevNumSum][i - 1];
                    }
                }
            }
        }

        int currNumSum = m;
        int frontNum = 1;
        for (int i = n; i >= 1; i--) {
            while (dp[frontNum][currNumSum][i] < k) {
                k -= dp[frontNum][currNumSum][i];
                frontNum++;
            }

            bw.write(frontNum + " ");
            currNumSum -= frontNum;
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        sol();
        br.close();
    }
}