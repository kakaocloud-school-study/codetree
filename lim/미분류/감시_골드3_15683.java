package lim.미분류;

import java.util.*;
import java.io.*;

public class 감시_골드3_15683 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ROAD = 0, FRONT = 1, BACK = 2, RIGHT = 3, SIDE = 4, ALL = 5, WALL = 6, WATCHED = 7;
    static int[][] grid, tmpGrid;
    static ArrayList<Pos> cctvs = new ArrayList<>();
    static int[] drs = { 1, 0, -1, 0 };
    static int[] dcs = { 0, -1, 0, 1 };
    static int n, m, answer = Integer.MAX_VALUE;

    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }

    static void watch(int direction, int r, int c) {
        int dr = drs[direction];
        int dc = dcs[direction];
        while (inRange(r, c)) {
            if (tmpGrid[r][c] == WALL) {
                return;
            }
            if (tmpGrid[r][c] == ROAD) {
                tmpGrid[r][c] = WATCHED;
            }
            r += dr;
            c += dc;
        }
    }

    static void renewMin(ArrayList<Integer> selectedDirs) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                tmpGrid[i][j] = grid[i][j];
            }
        }

        for (int i = 0; i < selectedDirs.size(); i++) {
            int direction = selectedDirs.get(i);
            Pos pos = cctvs.get(i);
            int cctvType = grid[pos.r][pos.c];

            watch(direction, pos.r, pos.c);
            if (cctvType == BACK || cctvType == ALL) {
                watch((direction + 2) % 4, pos.r, pos.c);
            }
            if (cctvType == RIGHT || cctvType == SIDE || cctvType == ALL) {
                watch((direction + 1) % 4, pos.r, pos.c);
            }
            if (cctvType == SIDE || cctvType == ALL) {
                watch((direction + 3) % 4, pos.r, pos.c);
            }
        }

        int count = 0;
        for (int i = 0; i < tmpGrid.length; i++) {
            for (int j = 0; j < tmpGrid[0].length; j++) {
                if (tmpGrid[i][j] == ROAD) {
                    count++;
                }
            }
        }
        answer = Math.min(answer, count);
    }

    static void func(ArrayList<Integer> selectedDirs) {
        if (selectedDirs.size() == cctvs.size()) {
            renewMin(selectedDirs);
            return;
        }
        for (int i = 0; i < 4; i++) {
            selectedDirs.add(i);
            func(selectedDirs);
            selectedDirs.remove(selectedDirs.size() - 1);
        }
    }

    static void sol() throws IOException {
        func(new ArrayList<>());
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        tmpGrid = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] > ROAD && grid[i][j] < WALL) {
                    cctvs.add(new Pos(i, j));
                }
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
