package lim.시뮬레이션;

import java.util.Scanner;

public class 격자_안에서_단일_객체를_이동_숫자가_더_큰_인접한_곳으로_이동 {
    private static int n;
    private static Game game;

    public static class Game {
        int[][] grid;
        int r, c;
        int[] drs = { -1, 1, 0, 0 };
        int[] dcs = { 0, 0, -1, 1 };

        Game(int[][] grid, int r, int c) {
            this.grid = grid;
            this.r = r;
            this.c = c;
        }

        boolean inRange(int r, int c) {
            return r >= 0 && c >= 0 && r < n && c < n;
        }

        boolean move() {
            for (int i = 0; i < 4; i++) {
                int nr = r + drs[i];
                int nc = c + dcs[i];
                if (!inRange(nr, nc)) {
                    continue;
                }
                if (grid[r][c] < grid[nr][nc]) {
                    r = nr;
                    c = nc;
                    return true;
                }
            }
            return false;
        }

        void printNum() {
            System.out.printf("%d ", grid[r][c]);
        }
    }

    private static void sol() {
        game.printNum();
        while (game.move()) {
            game.printNum();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        game = new Game(grid, r - 1, c - 1);
        sol();
        scanner.close();
    }
}
