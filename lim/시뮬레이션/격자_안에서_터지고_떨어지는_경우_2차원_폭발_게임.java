package lim.시뮬레이션;

import java.util.Scanner;

public class 격자_안에서_터지고_떨어지는_경우_2차원_폭발_게임 {
    private static int n, m, k;
    private static Game game;

    public static class Game {
        private int[][] grid;

        Game(int[][] grid) {
            this.grid = grid;
        }

        void rotate() {
            int[][] newGrid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    newGrid[j][n - 1 - i] = grid[i][j];
                }
            }
            grid = newGrid;
        }

        void setZero(int col, int startAt, int endAt) {
            for (int i = startAt; i <= endAt; i++) {
                grid[i][col] = 0;
            }
        }

        boolean bomb() {
            boolean isBombed = false;
            for (int j = 0; j < n; j++) {
                int startAt = 0;
                int count = 0;
                int prevValue = -1;
                for (int i = 0; i < n; i++) {
                    if (grid[i][j] == 0) {
                        continue;
                    }

                    if (grid[i][j] != prevValue) {
                        if (count >= m) {
                            setZero(j, startAt, i - 1);
                            isBombed = true;
                        }
                        prevValue = grid[i][j];
                        startAt = i;
                        count = 1;
                    } else {
                        count++;
                    }
                }
                if (count >= m) {
                    setZero(j, startAt, n - 1);
                    isBombed = true;
                }
            }
            return isBombed;
        }

        void drop() {
            int[][] newGrid = new int[n][n];
            for (int j = 0; j < n; j++) {
                int newGridIdx = n - 1;
                for (int i = n - 1; i >= 0; i--) {
                    if (grid[i][j] == 0) {
                        continue;
                    }
                    newGrid[newGridIdx][j] = grid[i][j];
                    newGridIdx--;
                }
            }
            grid = newGrid;
        }

        void printGrid() {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    System.out.printf("%d ", grid[i][j]);
                }
                System.out.println();
            }
        }

        int count() {
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] > 0) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    private static void sol() {
        for (int i = 0; i < k; i++) {
            game.drop();
            while (game.bomb()) {
                game.drop();
            }
            game.rotate();
        }
        game.drop();
        while (game.bomb()) {
            game.drop();
        }
        System.out.println(game.count());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
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
