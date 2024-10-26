package lim.DP;

import java.util.*;
import java.io.*;

public class 골드1_2098_외판원_순회 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] grid;

    static boolean isMasked(int mask, int node) {
        return (mask & (1 << node)) > 0;
    }

    static int travel() {
        int[][] dp = new int[n][1 << n];
        for (int i = 0; i < dp.length; i++) {
            for (int mask = 0; mask < dp[0].length; mask++) {
                dp[i][mask] = Integer.MAX_VALUE;
            }
        }

        dp[0][1 << 0] = 0;

        for (int times = 0; times < dp.length; times++) {
            for (int node = 0; node < dp.length; node++) {
                for (int mask = 0; mask < dp[0].length; mask++) {
                    if (!isMasked(mask, node)) {
                        continue;
                    }
                    if (dp[node][mask] == Integer.MAX_VALUE) {
                        continue;
                    }
                    for (int nextNode = 0; nextNode < dp.length; nextNode++) {
                        if (isMasked(mask, nextNode)) {
                            continue;
                        }
                        if (grid[node][nextNode] == 0) {
                            continue;
                        }
                        dp[nextNode][mask | (1 << nextNode)] = Math.min(dp[nextNode][mask | (1 << nextNode)],
                                dp[node][mask] + grid[node][nextNode]);
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int node = 0; node < dp.length; node++) {
            if (node == 0) {
                continue;
            }
            if (grid[node][0] == 0) {
                continue;
            }
            if (dp[node][dp[0].length - 1] == Integer.MAX_VALUE) {
                continue;
            }
            answer = Math.min(answer, dp[node][dp[0].length - 1] + grid[node][0]);
        }
        return answer;
    }

    static void sol() throws IOException {
        bw.write(travel() + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        for (int i = 0; i < grid.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}