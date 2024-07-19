package lim.DFS;

import java.util.*;
import java.io.*;

public class DFS_안전_지대 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] visited;
    static int[][] grid;
    static int[] drs = { 1, 0, -1, 0 };
    static int[] dcs = { 0, 1, 0, -1 };
    static int n, m;
    static int maxCount = 0;
    static int answer = 1;

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }

    static void dfs(int r, int c, int k) {
        for (int i = 0; i < drs.length; i++) {
            int nr = r + drs[i];
            int nc = c + dcs[i];
            if (!inRange(nr, nc) || visited[nr][nc] || grid[nr][nc] <= k) {
                continue;
            }
            visited[nr][nc] = true;
            dfs(nr, nc, k);
        }
    }

    static void sol(int n) throws IOException {
        for (int k = 1; k <= 100; k++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    visited[i][j] = false;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j] || grid[i][j] <= k) {
                        continue;
                    }
                    visited[i][j] = true;
                    count++;
                    dfs(i, j, k);
                }
            }
            if (maxCount < count) {
                maxCount = count;
                answer = k;
            }
        }
        bw.write(String.valueOf(answer) + " " + maxCount);
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        visited = new boolean[n][m];
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
