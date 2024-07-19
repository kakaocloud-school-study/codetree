package lim.백트래킹;

import java.util.*;

public class K개_중_하나를_N번_선택하기_Conditional_방향에_맞춰_최대로_움직이기 {
    static int[][] numGrid, dirGrid;
    static int[] drs = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dcs = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int n;

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }

    static int func(int r, int c, int count) {
        int maxCount = count;
        for (int dist = 1; dist < n; dist++) {
            int direction = dirGrid[r][c];
            int nr = r + drs[direction] * dist;
            int nc = c + dcs[direction] * dist;
            if (!inRange(nr, nc)) {
                break;
            }
            if (numGrid[r][c] >= numGrid[nr][nc]) {
                continue;
            }
            maxCount = Math.max(maxCount, func(nr, nc, count + 1));
        }
        return maxCount;
    }

    static void sol(int r, int c) {
        int count = func(r, c, 0);
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        numGrid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                numGrid[i][j] = scanner.nextInt();
            }
        }
        dirGrid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dirGrid[i][j] = scanner.nextInt() - 1;
            }
        }
        int r = scanner.nextInt() - 1;
        int c = scanner.nextInt() - 1;
        sol(r, c);
        scanner.close();
    }
}