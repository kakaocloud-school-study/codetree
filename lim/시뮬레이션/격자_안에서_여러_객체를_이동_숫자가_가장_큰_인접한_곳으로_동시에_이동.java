package lim.시뮬레이션;

import java.util.Scanner;

public class 격자_안에서_여러_객체를_이동_숫자가_가장_큰_인접한_곳으로_동시에_이동 {
    private static int n, t;
    private static Game game;

    public static class Game {
        int[][] numGrid;
        int[][] ballGrid;
        int[] drs = { -1, 1, 0, 0 };
        int[] dcs = { 0, 0, -1, 1 };

        Game(int[][] numGrid, int[][] ballGrid) {
            this.numGrid = numGrid;
            this.ballGrid = ballGrid;
        }

        boolean inRange(int r, int c) {
            return r >= 0 && c >= 0 && r < n && c < n;
        }

        void move(int[][] newBallGrid, int r, int c) {
            int maxR = -1;
            int maxC = -1;
            for (int i = 0; i < 4; i++) {
                int nr = r + drs[i];
                int nc = c + dcs[i];
                if (!inRange(nr, nc)) {
                    continue;
                }
                if (maxR == -1 || numGrid[maxR][maxC] < numGrid[nr][nc]) {
                    maxR = nr;
                    maxC = nc;
                }
            }
            newBallGrid[maxR][maxC]++;
        }

        void moveAll() {
            int[][] newBallGrid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (ballGrid[i][j] == 0) {
                        continue;
                    }
                    move(newBallGrid, i, j);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (newBallGrid[i][j] > 1) {
                        newBallGrid[i][j] = 0;
                    }
                }
            }
            ballGrid = newBallGrid;
        }

        void printBallCount() {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (ballGrid[i][j] == 1) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void sol() {
        while (t-- > 0) {
            game.moveAll();
        }
        game.printBallCount();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        t = scanner.nextInt();
        int[][] numGrid = new int[n][n];
        int[][] ballGrid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                numGrid[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            ballGrid[r - 1][c - 1] = 1;
        }
        game = new Game(numGrid, ballGrid);
        sol();
        scanner.close();
    }
}
