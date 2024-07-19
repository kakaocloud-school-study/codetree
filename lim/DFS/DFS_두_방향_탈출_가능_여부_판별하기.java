package lim.DFS;

import java.util.*;
import java.io.*;

public class DFS_두_방향_탈출_가능_여부_판별하기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] visited;
    static int[][] grid;
    static int[] drs = { 1, 0 };
    static int[] dcs = { 0, 1 };
    static int n, m;
    static int answer = 0;

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }

    static void dfs(int r, int c) throws IOException {
        if (r == n - 1 && c == m - 1) {
            answer = 1;
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nr = r + drs[i];
            int nc = c + dcs[i];
            if (!inRange(nr, nc) || visited[nr][nc] == 1 || grid[nr][nc] == 0) {
                continue;
            }
            visited[nr][nc] = 1;
            dfs(nr, nc);
        }
    }

    static void sol(int n) throws IOException {
        dfs(0, 0);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol(n);
        br.close();
    }
}
