package lim.DP;

import java.util.*;
import java.io.*;

public class 골드5_17070_파이프_옮기기1 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] grid;
    static final int VERTICAL = 0, DIAGONAL = 1, HORIZONTAL = 2;
    static final int[] drs = {1, 1, 0};
    static final int[] dcs = {0, 1, 1};

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length;
    }

    static void sol() throws IOException {
        int[][][] dp = new int[grid.length][grid[0].length][3];
        dp[0][1][HORIZONTAL] = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int dir = 0; dir < dp[0][0].length; dir++) {
                    if (dp[i][j][dir] == 0) {
                        continue;
                    }

                    for (int nDir = 0; nDir < dp[0][0].length; nDir++) {
                        if (Math.abs(nDir - dir) > 1) {
                            continue;
                        }

                        int nr = i + drs[nDir];
                        int nc = j + dcs[nDir];
                        if (!inRange(nr, nc) || grid[nr][nc] == 1) {
                            continue;
                        }
                        if (nDir == DIAGONAL && (grid[nr][nc - 1] == 1 || grid[nr - 1][nc] == 1)) {
                            continue;
                        }
                        dp[nr][nc][nDir] += dp[i][j][dir];
                    }
                }
            }
        }

        int answer = 0;
        if (dp[dp.length - 1][dp[0].length - 1][VERTICAL] != Integer.MAX_VALUE) {
            answer += dp[dp.length - 1][dp[0].length - 1][VERTICAL];
        }
        if (dp[dp.length - 1][dp[0].length - 1][DIAGONAL] != Integer.MAX_VALUE) {
            answer += dp[dp.length - 1][dp[0].length - 1][DIAGONAL];
        }
        if (dp[dp.length - 1][dp[0].length - 1][HORIZONTAL] != Integer.MAX_VALUE) {
            answer += dp[dp.length - 1][dp[0].length - 1][HORIZONTAL];
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
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
