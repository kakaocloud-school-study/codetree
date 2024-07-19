package lim.BFS;

import java.util.*;
import java.io.*;

public class 가중치가_동일한_그래프에서의_BFS_k개의_벽_없애기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] visited;
    static int[][] grid;
    static int[] drs = { 1, 0, -1, 0 };
    static int[] dcs = { 0, 1, 0, -1 };
    static int n, k, sr, sc, er, ec;
    static ArrayList<Pos> walls = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    static class Pos {
        int r, c, depth;

        Pos(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }

        boolean inRange() {
            return r >= 0 && c >= 0 && r < n && c < n;
        }

        boolean inSafe() {
            return inRange() && grid[r][c] == 0;
        }

        boolean isVisited() {
            return visited[r][c];
        }

        void visit() {
            visited[r][c] = true;
        }

        boolean inEnd() {
            return r == er && c == ec;
        }
    }

    static void bfs(int r, int c) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }

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

    static void simulate(ArrayList<Integer> idxs) {
        for (int i : idxs) {
            Pos pos = walls.get(i);
            grid[pos.r][pos.c] = 0;
        }
        bfs(sr, sc);
        for (int i : idxs) {
            Pos pos = walls.get(i);
            grid[pos.r][pos.c] = 1;
        }
    }

    static void combinate(int sIdx, ArrayList<Integer> idxs) {
        if (idxs.size() == k) {
            simulate(idxs);
        }

        for (int i = sIdx; i < walls.size(); i++) {
            idxs.add(i);
            combinate(i + 1, idxs);
            idxs.remove(idxs.size() - 1);
        }
    }

    static void sol(int n) throws IOException {
        combinate(0, new ArrayList<>());
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
        k = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    walls.add(new Pos(i, j, 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        er = Integer.parseInt(st.nextToken()) - 1;
        ec = Integer.parseInt(st.nextToken()) - 1;

        sol(n);
        br.close();
    }
}
