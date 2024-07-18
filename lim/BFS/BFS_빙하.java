package lim.BFS;

import java.util.*;
import java.io.*;

public class BFS_빙하 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] grid;
    static boolean[][] visited;
    static HashSet<Pos> meltPoints = new HashSet<>();
    static LinkedList<Pos> queue = new LinkedList<>();
    static int[] drs = { 1, 0, -1, 0 };
    static int[] dcs = { 0, 1, 0, -1 };
    static int n, m;
    static int time = 0;
    static int lastMeltSize = 0;

    static class Pos {
        int r, c, cost;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public boolean equals(Object pos) {
            return r == ((Pos) pos).r && c == ((Pos) pos).c;
        }

        public int hashCode() {
            return r * 1000 + c;
        }
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            for (int i = 0; i < dcs.length; i++) {
                int nr = pos.r + drs[i];
                int nc = pos.c + dcs[i];
                if (!inRange(nr, nc) || visited[nr][nc]) {
                    continue;
                }
                if (grid[nr][nc] == 1) {
                    meltPoints.add(new Pos(nr, nc));
                    continue;
                }
                visited[nr][nc] = true;
                Pos newPos = new Pos(nr, nc);
                queue.offer(newPos);
            }
        }
    }

    static int turn() {
        bfs();
        queue.addAll(meltPoints);
        for (Pos pos : meltPoints) {
            grid[pos.r][pos.c] = 0;
        }
        int meltSize = meltPoints.size();
        meltPoints.clear();
        return meltSize;
    }

    static void sol() throws IOException {
        queue.add(new Pos(0, 0));
        visited[0][0] = true;

        while (true) {
            int meltSize = turn();
            if (meltSize == 0) {
                break;
            }
            lastMeltSize = meltSize;
            time++;
        }

        bw.write(time + " " + lastMeltSize);
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][m];
        sol();
        br.close();
    }
}
