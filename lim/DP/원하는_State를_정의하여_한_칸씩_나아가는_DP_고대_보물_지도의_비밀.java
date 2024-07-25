package lim.DP;

import java.util.*;
import java.io.*;

public class 원하는_State를_정의하여_한_칸씩_나아가는_DP_고대_보물_지도의_비밀 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int k;
    static int[] arr;
    static int[][] dp;

    static void sol() throws IOException {
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < dp[0].length; i++) {
            for (int negs = 0; negs < dp.length; negs++) {
                dp[negs][i] = Integer.MIN_VALUE;
            }
        }

        dp[0][0] = 0;

        for (int i = 1; i < dp[0].length; i++) {
            for (int negs = 0; negs < dp.length; negs++) {
                int prevNegs = negs;
                if (arr[i] < 0) {
                    prevNegs--;
                }
                if (prevNegs < 0 || dp[prevNegs][i - 1] == Integer.MIN_VALUE) {
                    continue;
                }

                dp[negs][i] = Math.max(dp[negs][i], dp[prevNegs][i - 1] + arr[i]);
                dp[Math.abs(prevNegs - negs)][i] = Math.max(dp[Math.abs(prevNegs - negs)][i], arr[i]);
            }
        }

        for (int i = 1; i < dp[0].length; i++) {
            for (int negs = 0; negs < dp.length; negs++) {
                answer = Math.max(dp[negs][i], answer);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[k + 1][n + 1];
        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
    }
}
