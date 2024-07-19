package lim.BFS;

import java.util.*;
import java.io.*;

public class 가중치가_동일한_그래프에서의_BFS_최소_경로로_탈출_하기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] visited;
    static int[][] grid;
    static int[] drs = { 1, 0, -1, 0 };
    static int[] dcs = { 0, 1, 0, -1 };
    static int n, m;
    static int answer = Integer.MAX_VALUE;

    static class Pos {
        int r, c, depth;

        Pos(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }

        boolean inRange() {
            return r >= 0 && c >= 0 && r < n && c < m;
        }

        boolean inSafe() {
            return inRange() && grid[r][c] == 1;
        }

        boolean isVisited() {
            return visited[r][c];
        }

        void visit() {
            visited[r][c] = true;
        }

        boolean inEnd() {
            return r == n - 1 && c == m - 1;
        }
    }

    static void bfs(int r, int c) throws IOException {
        LinkedList<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(r, c, 0));
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            if (pos.inEnd()) {
                answer = Math.min(answer, pos.depth);
            }
            for (int i = 0; i < dcs.length; i++) {
                Pos newPos = new Pos(pos.r + drs[i], pos.c + dcs[i], pos.depth + 1);
                if (!newPos.inSafe() || newPos.isVisited()) {
                    continue;
                }
                newPos.visit();
                queue.offer(newPos);
            }
        }
    }

    static void sol(int n) throws IOException {
        bfs(0, 0);
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
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
