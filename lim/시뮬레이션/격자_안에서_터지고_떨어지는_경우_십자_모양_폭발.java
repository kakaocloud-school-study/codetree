package lim.시뮬레이션;

import java.util.Scanner;

public class 격자_안에서_터지고_떨어지는_경우_십자_모양_폭발 {
    private static int n, r, c;
    private static Game game;

    public static class Game {
        private int[][] grid;

        Game(int[][] grid) {
            this.grid = grid;
        }

        boolean inRange(int bombR, int bombC, int r, int c) {
            int dist = grid[bombR][bombC];
            if (bombR == r && Math.abs(c - bombC) < dist) {
                return true;
            }
            if (bombC == c && Math.abs(r - bombR) < dist) {
                return true;
            }
            return false;
        }

        void bomb(int r, int c) {
            int[][] newGrid = new int[n][n];
            for (int j = 0; j < n; j++) {
                int newGridIdx = n - 1;
                for (int i = n - 1; i >= 0; i--) {
                    if (inRange(r, c, i, j)) {
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
    }

    private static void sol() {
        game.bomb(r, c);
        game.printGrid();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        game = new Game(grid);
        r = scanner.nextInt() - 1;
        c = scanner.nextInt() - 1;
        sol();
        scanner.close();
    }
}
