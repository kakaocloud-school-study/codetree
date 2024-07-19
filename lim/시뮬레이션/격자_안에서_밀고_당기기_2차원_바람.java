package lim.시뮬레이션;

import java.util.LinkedList;
import java.util.Scanner;

public class 격자_안에서_밀고_당기기_2차원_바람 {
    private static int n, m, q;
    private static int[][] queries;
    private static int[][] grid;

    private static void rotate(int sr, int sc, int er, int ec) {
        LinkedList<Integer> queue = new LinkedList<>();
        int r = sr;
        int c = sc;
        for (; c < ec;) {
            queue.offer(grid[r][c]);
            c++;
        }
        for (; r < er;) {
            queue.offer(grid[r][c]);
            r++;
        }
        for (; c > sc;) {
            queue.offer(grid[r][c]);
            c--;
        }
        for (; r > sr;) {
            queue.offer(grid[r][c]);
            r--;
        }

        int last = queue.pollLast();
        queue.offerFirst(last);

        for (; c < ec;) {
            grid[r][c] = queue.poll();
            c++;
        }
        for (; r < er;) {
            grid[r][c] = queue.poll();
            r++;
        }
        for (; c > sc;) {
            grid[r][c] = queue.poll();
            c--;
        }
        for (; r > sr;) {
            grid[r][c] = queue.poll();
            r--;
        }
    }

    private static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }

    private static int getAvgAt(int r, int c) {
        int[] drs = { 0, 1, -1, 0, 0 };
        int[] dcs = { 0, 0, 0, 1, -1 };
        int count = 0;
        int valueSum = 0;
        for (int i = 0; i < drs.length; i++) {
            int nr = r + drs[i];
            int nc = c + dcs[i];
            if (!inRange(nr, nc)) {
                continue;
            }
            count++;
            valueSum += grid[nr][nc];
        }
        return Math.floorDiv(valueSum, count);
    }

    private static void replaceAllToAvg(int sr, int sc, int er, int ec) {
        int[][] newGrid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newGrid[i][j] = grid[i][j];
            }
        }

        for (int i = sr; i <= er; i++) {
            for (int j = sc; j <= ec; j++) {
                newGrid[i][j] = getAvgAt(i, j);
            }
        }
        grid = newGrid;
    }

    private static void sol() {

        for (int i = 0; i < q; i++) {
            int[] query = queries[i];
            rotate(query[0], query[1], query[2], query[3]);
            replaceAllToAvg(query[0], query[1], query[2], query[3]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%d ", grid[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        queries = new int[q][4];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 4; j++) {
                queries[i][j] = scanner.nextInt() - 1;
            }
        }
        sol();
        scanner.close();
    }
}
