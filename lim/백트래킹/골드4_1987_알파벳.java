package lim.백트래킹;

import java.util.*;
import java.io.*;

public class 골드4_1987_알파벳 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] grid;
    static int[] drs = { 1, 0, -1, 0 };
    static int[] dcs = { 0, 1, 0, -1 };

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length;
    }

    static int dfs(int r, int c, int depth, boolean[] visited) {
        int maxDepth = depth + 1;
        for (int dir = 0; dir < drs.length; dir++) {
            int nr = r + drs[dir];
            int nc = c + dcs[dir];
            if (!inRange(nr, nc) || visited[grid[nr][nc] - 'A']) {
                continue;
            }
            visited[grid[nr][nc] - 'A'] = true;
            maxDepth = Math.max(maxDepth, dfs(nr, nc, depth + 1, visited));
            visited[grid[nr][nc] - 'A'] = false;
        }
        return maxDepth;
    }

    static void sol() throws IOException {
        boolean[] visited = new boolean['Z' - 'A' + 1];
        visited[grid[0][0] - 'A'] = true;
        bw.write(dfs(0, 0, 0, visited) + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        grid = new char[r][c];
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
