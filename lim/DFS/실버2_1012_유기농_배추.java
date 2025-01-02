package lim.DFS;

import java.util.*;
import java.io.*;

public class 실버2_1012_유기농_배추 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] drs = { 1, 0, -1, 0 }, dcs = { 0, 1, 0, -1 };
    static int[][] grid;

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length;
    }

    static void dfs(int r, int c, boolean[][] visited) {
        visited[r][c] = true;
        for (int dir = 0; dir < drs.length; dir++) {
            int nr = r + drs[dir];
            int nc = c + dcs[dir];
            if (!inRange(nr, nc) || grid[nr][nc] == 0 || visited[nr][nc]) {
                continue;
            }
            dfs(nr, nc, visited);
        }
    }

    static void sol() throws IOException {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] || grid[i][j] == 0) {
                    continue;
                }
                dfs(i, j, visited);
                count++;
            }
        }
        bw.write(count + "\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            grid = new int[n][m];
            for (int j = 0; j < count; j++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                grid[r][c] = 1;
            }
            sol();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
