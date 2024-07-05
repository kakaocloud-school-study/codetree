package lim.시뮬레이션;

import java.util.Scanner;

/**
 * 격자_안에서_완전탐색_최고의_33위치
 */
public class 격자_안에서_완전탐색_최고의_33위치 {
    private static int n;
    private static int[][] grid;

    private static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }

    private static int get33Sum(int r, int c) {
        int total = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!inRange(r + i, c + j)) {
                    continue;
                }
                total += grid[r + i][c + j];
            }
        }
        return total;
    }

    private static void sol() {
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxValue = Math.max(maxValue, get33Sum(i, j));
            }
        }
        System.out.println(maxValue);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        sol();
        scanner.close();
    }
}