package lim.시뮬레이션;

import java.util.Scanner;

public class 격자_안에서_완전탐색_금_채굴하기 {
    private static int n;
    private static int m;
    private static int[][] grid;

    private static int calculateCost(int dist) {
        return dist * dist + (dist + 1) * (dist + 1);
    }

    private static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }

    private static int getGoldsAtDistance(int r, int c, int dist) {
        int[] drs = { 1, 1, -1, -1 };
        int[] dcs = { 1, -1, -1, 1 };
        r -= dist;
        int golds = 0;
        for (int direction = 0; direction < 4; direction++) {
            for (int i = 0; i < dist; i++) {
                if (!inRange(r, c)) {
                    r += drs[direction];
                    c += dcs[direction];
                    continue;
                }
                golds += grid[r][c];
                r += drs[direction];
                c += dcs[direction];
            }
        }
        return golds;
    }

    private static int getMaxGoldsAt(int r, int c) {
        int maxTotalGolds = 0;
        int totalGolds = 0;
        for (int dist = 0; dist < 2 * n; dist++) {
            int golds = grid[r][c];
            if (dist > 0) {
                golds = getGoldsAtDistance(r, c, dist);
            }
            int cost = calculateCost(dist);
            totalGolds += golds;
            if (cost <= totalGolds * m) {
                maxTotalGolds = Math.max(totalGolds, maxTotalGolds);
            }
        }
        return maxTotalGolds;
    }

    private static void sol() {
        int maxGolds = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int golds = getMaxGoldsAt(i, j);
                maxGolds = Math.max(maxGolds, golds);
            }
        }
        System.out.println(maxGolds);
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
