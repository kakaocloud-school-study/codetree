package lim.시뮬레이션;

import java.util.Scanner;

public class 격자_안에서_단일_객체를_이동_떨어지는_1자_블록 {
    private static int n;
    private static Game game;

    public static class Game {
        int[][] grid;
        int startAt;
        int endAt;

        Game(int[][] grid, int startAt, int endAt) {
            this.grid = grid;
            this.startAt = startAt;
            this.endAt = endAt;
        }

        boolean possible(int row) {
            for (int i = startAt; i <= endAt; i++) {
                if (grid[row][i] > 0) {
                    return false;
                }
            }
            return true;
        }

        void drop() {
            int lastRow = 0;
            for (int i = 1; i < n; i++) {
                if (!possible(i)) {
                    break;
                }
                lastRow = i;
            }
            for (int i = startAt; i <= endAt; i++) {
                grid[lastRow][i] = 1;
            }
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
        game.drop();
        game.printGrid();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        game = new Game(grid, k - 1, k - 2 + m);
        sol();
        scanner.close();
    }
}
