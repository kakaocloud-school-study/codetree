package lim.시뮬레이션;

import java.util.Scanner;

public class 격자_안에서_완전탐색_행복한_수열의_개수 {
    private static int n;
    private static int m;
    private static int[][] grid;

    private static void sol() {
        int happyCount = 0;
        for (int i = 0; i < n; i++) {
            int count = 1;
            boolean isHappy = false;
            if (count >= m) {
                isHappy = true;
            }
            for (int j = 0; j < n - 1; j++) {
                if (grid[i][j] == grid[i][j + 1]) {
                    count++;
                } else {
                    count = 1;
                }
                if (count >= m) {
                    isHappy = true;
                }
            }
            if (isHappy) {
                happyCount++;
            }
        }
        for (int j = 0; j < n; j++) {
            int count = 1;
            boolean isHappy = false;
            if (count >= m) {
                isHappy = true;
            }
            for (int i = 0; i < n - 1; i++) {
                if (grid[i][j] == grid[i + 1][j]) {
                    count++;
                } else {
                    count = 1;
                }
                if (count >= m) {
                    isHappy = true;
                }
            }
            if (isHappy) {
                happyCount++;
            }
        }
        System.out.println(happyCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
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
