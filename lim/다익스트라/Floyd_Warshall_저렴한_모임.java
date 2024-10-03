package lim.다익스트라;

import java.util.*;
import java.io.*;

public class Floyd_Warshall_저렴한_모임 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, v1, v2, v3;
    static int[][] grid, queries;

    static void fw() {
        for (int k = 1; k < grid.length; k++) {
            for (int i = 1; i < grid.length; i++) {
                for (int j = 1; j < grid[0].length; j++) {
                    if (grid[i][k] == Integer.MAX_VALUE || grid[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    grid[i][j] = Math.min(grid[i][j], grid[i][k] + grid[k][j]);
                }
            }
        }
    }

    static void sol() throws IOException {
        fw();
        int minDist = Integer.MAX_VALUE;
        for (int stopover = 1; stopover < grid.length; stopover++) {
            if (grid[v1][stopover] == Integer.MAX_VALUE) {
                continue;
            }
            if (grid[v2][stopover] == Integer.MAX_VALUE) {
                continue;
            }
            if (grid[v3][stopover] == Integer.MAX_VALUE) {
                continue;
            }
            minDist = Math.min(minDist, grid[v1][stopover] + grid[v2][stopover] + grid[v3][stopover]);
        }
        if (minDist == Integer.MAX_VALUE) {
            minDist = -1;
        }
        bw.write(minDist + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        v3 = Integer.parseInt(st.nextToken());
        grid = new int[n + 1][n + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == j) {
                    continue;
                }
                grid[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            grid[s][e] = Math.min(grid[s][e], cost);
            grid[e][s] = grid[s][e];
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}