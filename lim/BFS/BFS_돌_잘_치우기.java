package lim.BFS;

import java.util.*;
import java.io.*;

public class BFS_돌_잘_치우기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] grid;
    static boolean[][] visited;
    static ArrayList<Pos> stones = new ArrayList<>();
    static Pos[] startPoints;
    static LinkedList<Pos> queue = new LinkedList<>();
    static int[] drs = { 1, 0, -1, 0 };
    static int[] dcs = { 0, 1, 0, -1 };
    static int n, m;
    static int answer = 0;

    static class Pos {
        int r, c, cost;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            for (int i = 0; i < dcs.length; i++) {
                int nr = pos.r + drs[i];
                int nc = pos.c + dcs[i];
                if (!inRange(nr, nc) || visited[nr][nc] || grid[nr][nc] == 1) {
                    continue;
                }
                visited[nr][nc] = true;
                Pos newPos = new Pos(nr, nc);
                queue.offer(newPos);
            }
        }
    }

    static int countVisits() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    static void combinate(int idx, ArrayList<Integer> arr) {
        if (idx == (int) stones.size() || m == 0) {
            if (arr.size() != m) {
                return;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    visited[i][j] = false;
                }
            }
            for (int i : arr) {
                Pos stone = stones.get(i);
                grid[stone.r][stone.c] = 0;
            }
            for (Pos pos : startPoints) {
                queue.offer(pos);
                visited[pos.r][pos.c] = true;
            }
            bfs();
            int count = countVisits();
            answer = Math.max(answer, count);
            for (int i : arr) {
                Pos stone = stones.get(i);
                grid[stone.r][stone.c] = 1;
            }
            return;
        }
        combinate(idx + 1, arr);
        arr.add(idx);
        combinate(idx + 1, arr);
        arr.remove(arr.size() - 1);
    }

    static void sol() throws IOException {
        combinate(0, new ArrayList<>());
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    stones.add(new Pos(i, j));
                }
            }
        }
        startPoints = new Pos[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            Pos pos = new Pos(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
            startPoints[i] = pos;
        }
        visited = new boolean[n][n];
        sol();
        br.close();
    }
}
