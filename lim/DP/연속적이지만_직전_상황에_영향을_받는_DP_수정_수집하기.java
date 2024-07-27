package lim.DP;

import java.util.*;
import java.io.*;

public class 연속적이지만_직전_상황에_영향을_받는_DP_수정_수집하기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][][] dp;
    static int[] rewardPosByTime;
    static int n, k;

    static void sol() throws IOException {
        for (int time = 0; time <= n; time++) {
            for (int jumps = 0; jumps <= k; jumps++) {
                for (int currPos = 0; currPos < 2; currPos++) {
                    dp[currPos][jumps][time] = -1;
                }
            }
        }
        dp[0][0][0] = 0;
        for (int time = 1; time <= n; time++) {
            for (int jumps = 0; jumps <= k; jumps++) {
                for (int currPos = 0; currPos < 2; currPos++) {
                    for (int prevPos = 0; prevPos < 2; prevPos++) {
                        int reward = 0;
                        if (currPos == rewardPosByTime[time]) {
                            reward = 1;
                        }
                        if (jumps > 0 && prevPos != currPos && dp[prevPos][jumps - 1][time - 1] != -1) {
                            dp[currPos][jumps][time] = Math.max(dp[currPos][jumps][time],
                                    dp[prevPos][jumps - 1][time - 1] + reward);
                        } else if (prevPos == currPos && dp[currPos][jumps][time - 1] != -1) {
                            dp[currPos][jumps][time] = Math.max(dp[currPos][jumps][time],
                                    dp[currPos][jumps][time - 1] + reward);
                        }
                    }
                }
            }
        }

        int answer = 0;
        for (int jumps = 0; jumps <= k; jumps++) {
            for (int currPos = 0; currPos < 2; currPos++) {
                answer = Math.max(answer, dp[currPos][jumps][n]);
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[2][k + 1][n + 1];

        st = new StringTokenizer(br.readLine());
        String[] words = st.nextToken().split("");
        rewardPosByTime = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (words[i].equals("L")) {
                rewardPosByTime[i + 1] = 0;
            } else {
                rewardPosByTime[i + 1] = 1;
            }
        }
        sol();
        br.close();
    }
}