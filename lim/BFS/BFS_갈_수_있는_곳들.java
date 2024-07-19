package lim.BFS;

import java.util.*;
import java.io.*;

public class BFS_갈_수_있는_곳들 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] visited;
    static int[][] grid;
    static int[] drs = { 1, 0, -1, 0 };
    static int[] dcs = { 0, 1, 0, -1 };
    static int n, m;
    static int answer = 0;

    static class Pos {
        int r, c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

        boolean inRange() {
            return r >= 0 && c >= 0 && r < n && c < n;
        }

        boolean canGo() {
            return inRange() && grid[r][c] == 0;
        }

        boolean isVisited() {
            return visited[r][c];
        }

        void visit() {
            visited[r][c] = true;
        }
    }

    static void bfs(Pos pos) {
        LinkedList<Pos> queue = new LinkedList<>();
        queue.offer(pos);
        pos.visit();

        while (!queue.isEmpty()) {
            pos = queue.poll();
            for (int i = 0; i < dcs.length; i++) {
                Pos newPos = new Pos(pos.r + drs[i], pos.c + dcs[i]);
                if (!newPos.canGo() || newPos.isVisited()) {
                    continue;
                }
                newPos.visit();
                queue.offer(newPos);
            }
        }
    }

    static void countVisits() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    answer++;
                }
            }
        }
    }

    static void sol(Pos[] startPoints) throws IOException {
        for (Pos pos : startPoints) {
            bfs(pos);
        }
        countVisits();
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Pos[] startPoints = new Pos[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            Pos pos = new Pos(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
            startPoints[i] = pos;
        }
        sol(startPoints);
        br.close();
    }
}
