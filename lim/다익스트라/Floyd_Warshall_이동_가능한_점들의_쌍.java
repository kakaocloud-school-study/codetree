package lim.다익스트라;

import java.util.*;
import java.io.*;

public class Floyd_Warshall_이동_가능한_점들의_쌍 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, p, q;
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
        int count = 0;
        long totalDist = 0;
        for (int[] query : queries) {
            int s = query[0];
            int e = query[1];
            int minDist = Integer.MAX_VALUE;
            for (int stopover = 1; stopover < p + 1; stopover++) {
                if (grid[s][stopover] == Integer.MAX_VALUE || grid[stopover][e] == Integer.MAX_VALUE) {
                    continue;
                }
                minDist = Math.min(minDist, grid[s][stopover] + grid[stopover][e]);
            }
            if (minDist == Integer.MAX_VALUE) {
                continue;
            }
            count++;
            totalDist += minDist;
        }
        bw.write(count + "\n" + totalDist);
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        grid = new int[n + 1][n + 1];
        queries = new int[q][2];
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
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}