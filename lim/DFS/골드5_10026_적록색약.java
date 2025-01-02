package lim.DFS;

import java.util.*;
import java.io.*;

public class 골드5_10026_적록색약 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] drs = { 1, 0, -1, 0 }, dcs = { 0, 1, 0, -1 };
    static char[][] grid;

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length;
    }

    static void dfs(int r, int c, boolean[][] visited, HashSet<Character> targets) {
        visited[r][c] = true;
        for (int dir = 0; dir < drs.length; dir++) {
            int nr = r + drs[dir];
            int nc = c + dcs[dir];
            if (!inRange(nr, nc) || !targets.contains(grid[nr][nc]) || visited[nr][nc]) {
                continue;
            }
            dfs(nr, nc, visited, targets);
        }
    }

    static void sol() throws IOException {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j]) {
                    continue;
                }
                HashSet<Character> targets = new HashSet<>(List.of(grid[i][j]));
                dfs(i, j, visited, targets);
                count++;
            }
        }
        bw.write(count + " ");

        visited = new boolean[grid.length][grid[0].length];
        count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j]) {
                    continue;
                }

                HashSet<Character> targets = new HashSet<>();
                if (grid[i][j] == 'B') {
                    targets.add(grid[i][j]);
                } else {
                    targets.addAll(List.of('R', 'G'));
                }
                dfs(i, j, visited, targets);
                count++;
            }
        }
        bw.write(count + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        grid = new char[n][n];
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
