package lim.시뮬레이션;

import java.util.Scanner;

public class 격자_안에서_여러_객체를_이동_숫자의_순차적_이동 {
    private static int n, m;
    private static Game game;

    public static class Game {
        int[][] grid;
        int[] drs = { -1, 1, 0, 0, 1, 1, -1, -1 };
        int[] dcs = { 0, 0, -1, 1, 1, -1, 1, -1 };

        Game(int[][] grid) {
            this.grid = grid;
        }

        boolean inRange(int r, int c) {
            return r >= 0 && c >= 0 && r < n && c < n;
        }

        void move(int r, int c) {
            int maxR = -1;
            int maxC = -1;
            for (int i = 0; i < drs.length; i++) {
                int nr = r + drs[i];
                int nc = c + dcs[i];
                if (!inRange(nr, nc)) {
                    continue;
                }
                if (maxR == -1 || grid[maxR][maxC] < grid[nr][nc]) {
                    maxR = nr;
                    maxC = nc;
                }
            }
            int tmp = grid[maxR][maxC];
            grid[maxR][maxC] = grid[r][c];
            grid[r][c] = tmp;
        }

        int[] find(int num) {
            int[] pos = new int[2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == num) {
                        pos[0] = i;
                        pos[1] = j;
                        return pos;
                    }
                }
            }
            return pos;
        }

        void moveAll() {
            for (int k = 1; k < n * n + 1; k++) {
                int[] pos = find(k);
                move(pos[0], pos[1]);
            }
        }

        void printGrid() {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%d ", grid[i][j]);
                }
                System.out.println();
            }
        }
    }

    private static void sol() {
        while (m-- > 0) {
            game.moveAll();
        }
        game.printGrid();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        game = new Game(grid);
        sol();
        scanner.close();
    }
}
