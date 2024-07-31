package lim.미분류;

import java.util.*;
import java.io.*;

public class 인구_이동_골드4_16234 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] visited;
    static int[][] grid, newGrid;
    static int[] drs = { 1, 0, -1, 0 };
    static int[] dcs = { 0, 1, 0, -1 };
    static LinkedList<Pos> queue = new LinkedList<>();
    static int n, l, r;
    static int answer = Integer.MAX_VALUE;

    static class Pos {
        int r, c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean inRange(Pos pos) {
        int r = pos.r, c = pos.c;
        return r >= 0 && c >= 0 && r < n && c < n;
    }

    static boolean canGo(Pos pos1, Pos pos2) {
        if (!inRange(pos1) || !inRange(pos2)) {
            return false;
        }
        int population1 = grid[pos1.r][pos1.c];
        int population2 = grid[pos2.r][pos2.c];
        int diff = Math.abs(population1 - population2);
        return l <= diff && diff <= r;
    }

    static void renewUnion(ArrayList<Pos> history, int value) {
        for (int i = 0; i < history.size(); i++) {
            Pos pos = history.get(i);
            newGrid[pos.r][pos.c] = value;
        }
    }

    static boolean bfs(int r, int c) {
        if (visited[r][c]) {
            return false;
        }
        int totalSum = 0;
        int count = 0;
        visited[r][c] = true;
        ArrayList<Pos> history = new ArrayList<>();
        queue.add(new Pos(r, c));

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            history.add(pos);
            totalSum += grid[pos.r][pos.c];
            count++;
            for (int i = 0; i < dcs.length; i++) {
                Pos newPos = new Pos(pos.r + drs[i], pos.c + dcs[i]);
                if (!canGo(pos, newPos) || visited[newPos.r][newPos.c]) {
                    continue;
                }
                visited[newPos.r][newPos.c] = true;
                queue.offer(newPos);
            }
        }

        renewUnion(history, Math.floorDiv(totalSum, count));

        if (count > 1) {
            return true;
        }
        return false;
    }

    static boolean turn() {
        boolean moved = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                moved |= bfs(i, j);
            }
        }

        int[][] tmp = grid;
        grid = newGrid;
        newGrid = tmp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newGrid[i][j] = grid[i][j];
            }
        }
        return moved;
    }

    static void sol(int n) throws IOException {
        int time = 0;
        while (time < 2001) {
            if (!turn()) {
                break;
            }
            time++;
        }

        bw.write(String.valueOf(time));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        newGrid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                newGrid[i][j] = grid[i][j];
            }
        }
        sol(n);
        br.close();
    }
}
