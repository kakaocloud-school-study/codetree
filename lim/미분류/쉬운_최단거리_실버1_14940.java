package lim.미분류;

import java.util.*;
import java.io.*;

public class 쉬운_최단거리_실버1_14940 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int WALL = 0;
    static int ROAD = 1;
    static boolean[][] visited;
    static int[][] grid, distGrid;
    static int[] drs = { 1, 0, -1, 0 };
    static int[] dcs = { 0, 1, 0, -1 };
    static LinkedList<Pos> queue = new LinkedList<>();
    static int n, m;

    static class Pos {
        int r, c, depth;

        Pos(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }

    static boolean inRange(Pos pos) {
        int r = pos.r, c = pos.c;
        return r >= 0 && c >= 0 && r < n && c < m;
    }

    static boolean canGo(Pos pos) {
        return inRange(pos) && grid[pos.r][pos.c] == ROAD;
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            distGrid[pos.r][pos.c] = pos.depth;
            for (int i = 0; i < dcs.length; i++) {
                Pos newPos = new Pos(pos.r + drs[i], pos.c + dcs[i], pos.depth + 1);
                if (!canGo(newPos) || visited[newPos.r][newPos.c]) {
                    continue;
                }
                visited[newPos.r][newPos.c] = true;
                queue.offer(newPos);
            }
        }
    }

    static void sol() throws IOException {
        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(distGrid[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        distGrid = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                distGrid[i][j] = -1;
                if (grid[i][j] == 2) {
                    queue.add(new Pos(i, j, 0));
                    visited[i][j] = true;
                    distGrid[i][j] = 0;
                }
                if (grid[i][j] == WALL) {
                    distGrid[i][j] = WALL;
                }
            }
        }
        sol();
        br.close();
    }
}
