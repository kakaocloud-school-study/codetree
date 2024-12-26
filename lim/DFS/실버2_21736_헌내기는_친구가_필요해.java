package lim.DFS;

import java.util.*;
import java.io.*;

public class 실버2_21736_헌내기는_친구가_필요해 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] drs = { 1, 0, -1, 0 }, dcs = { 0, 1, 0, -1 };
    static char[][] grid;

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length;
    }

    static int dfs(int r, int c, boolean[][] visited) {
        visited[r][c] = true;
        int count = 0;
        if (grid[r][c] == 'P') {
            count++;
        }
        for (int dir = 0; dir < drs.length; dir++) {
            int nr = r + drs[dir];
            int nc = c + dcs[dir];
            if (!inRange(nr, nc) || grid[nr][nc] == 'X' || visited[nr][nc]) {
                continue;
            }
            count += dfs(nr, nc, visited);
        }
        return count;
    }

    static void sol() throws IOException {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 'I') {
                    continue;
                }
                int count = dfs(i, j, visited);
                if (count == 0) {
                    bw.write("TT");
                } else {
                    bw.write(count + "");
                }
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        grid = new char[n][m];
        for (int i = 0; i < grid.length; i++) {
            String line = br.readLine();
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
