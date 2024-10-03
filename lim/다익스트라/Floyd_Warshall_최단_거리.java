package lim.다익스트라;

import java.util.*;
import java.io.*;

public class Floyd_Warshall_최단_거리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
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
        for (int[] query : queries) {
            bw.write(grid[query[0]][query[1]] + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n + 1][n + 1];
        queries = new int[m][2];
        for (int i = 1; i < grid.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                ;
            }
        }
        for (int i = 0; i < m; i++) {
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