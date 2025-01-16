package lim.백트래킹;

import java.util.*;
import java.io.*;

public class 골드4_14502_연구소 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] grid;
    static int[] drs = { 1, 0, -1, 0 };
    static int[] dcs = { 0, 1, 0, -1 };
    static final int EMPTY = 0, WALL = 1, VIRUS = 2;

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length;
    }

    static void dfs(int r, int c, boolean[][] visited) {
        for (int dir = 0; dir < drs.length; dir++) {
            int nr = r + drs[dir];
            int nc = c + dcs[dir];
            if (!inRange(nr, nc) || visited[nr][nc] || grid[nr][nc] == WALL) {
                continue;
            }
            visited[nr][nc] = true;
            dfs(nr, nc, visited);
        }
    }

    static int count() {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == VIRUS && !visited[i][j]) {
                    dfs(i, j, visited);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == EMPTY && !visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    static int func(int selectedCount) {
        if (selectedCount == 3) {
            return count();
        }
        int maxCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != EMPTY) {
                    continue;
                }
                grid[i][j] = WALL;
                maxCount = Math.max(maxCount, func(selectedCount + 1));
                grid[i][j] = EMPTY;
            }
        }
        return maxCount;
    }

    static void sol() throws IOException {
        bw.write(func(0) + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        grid = new int[r][c];
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
