package lim.미분류;

import java.util.*;
import java.io.*;

public class 불_골드3_4179 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int WALL = 1;
    static int ROAD = 0;
    static boolean[][] visited;
    static int[][] grid, fireGrid;
    static int[] drs = { 1, 0, -1, 0 };
    static int[] dcs = { 0, 1, 0, -1 };
    static LinkedList<Pos> queue = new LinkedList<>();
    static LinkedList<Pos> fireQueue = new LinkedList<>();
    static int n, m;
    static int answer = Integer.MAX_VALUE;

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
        return inRange(pos) && grid[pos.r][pos.c] == ROAD && pos.depth < fireGrid[pos.r][pos.c];
    }

    static boolean escaped(Pos pos) {
        int r = pos.r, c = pos.c, time = pos.depth;
        return time < fireGrid[r][c] && (r == 0 || c == 0 || r == n - 1 || c == m - 1);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            if (escaped(pos)) {
                answer = Math.min(answer, pos.depth);
                return;
            }
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

    static void fireBfs() {
        while (!fireQueue.isEmpty()) {
            Pos pos = fireQueue.poll();
            for (int i = 0; i < dcs.length; i++) {
                Pos newPos = new Pos(pos.r + drs[i], pos.c + dcs[i], pos.depth + 1);
                if (!inRange(newPos) || grid[pos.r][pos.c] == WALL
                        || fireGrid[newPos.r][newPos.c] != Integer.MAX_VALUE) {
                    continue;
                }
                fireGrid[newPos.r][newPos.c] = newPos.depth;
                fireQueue.offer(newPos);
            }
        }
    }

    static void sol(int n) throws IOException {
        fireBfs();
        bfs();
        if (answer == Integer.MAX_VALUE) {
            bw.write("IMPOSSIBLE");
        } else {
            bw.write(String.valueOf(answer + 1));
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
        fireGrid = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String[] words = st.nextToken().split("");
            for (int j = 0; j < m; j++) {
                fireGrid[i][j] = Integer.MAX_VALUE;
                String word = words[j];
                if ("#".equals(word)) {
                    grid[i][j] = WALL;
                } else if (".".equals(word)) {
                    grid[i][j] = ROAD;
                } else if ("J".equals(word)) {
                    grid[i][j] = ROAD;
                    visited[i][j] = true;
                    queue.add(new Pos(i, j, 0));
                } else if ("F".equals(word)) {
                    fireGrid[i][j] = 0;
                    fireQueue.add(new Pos(i, j, 0));
                }
            }
        }
        sol(n);
        br.close();
    }
}
