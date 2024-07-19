package lim.시뮬레이션;

import java.util.LinkedList;
import java.util.Scanner;

public class 격자_안에서_밀고_당기기_기울어진_직사각형의_회전 {
    private static int n, r, c, m1, m2, m3, m4, dir;
    private static int[][] grid;
    private static LinkedList<Integer> queue = new LinkedList<>();

    private static void sol() {
        for (int i = 0; i < m1; i++) {
            queue.offer(grid[r][c]);
            r--;
            c++;
        }
        for (int i = 0; i < m2; i++) {
            queue.offer(grid[r][c]);
            r--;
            c--;
        }
        for (int i = 0; i < m3; i++) {
            queue.offer(grid[r][c]);
            r++;
            c--;
        }
        for (int i = 0; i < m4; i++) {
            queue.offer(grid[r][c]);
            r++;
            c++;
        }

        if (dir == 1) {
            int first = queue.poll();
            queue.offer(first);
        } else {
            int last = queue.pollLast();
            queue.offerFirst(last);
        }

        for (int i = 0; i < m1; i++) {
            grid[r][c] = queue.poll();
            r--;
            c++;
        }
        for (int i = 0; i < m2; i++) {
            grid[r][c] = queue.poll();
            r--;
            c--;
        }
        for (int i = 0; i < m3; i++) {
            grid[r][c] = queue.poll();
            r++;
            c--;
        }
        for (int i = 0; i < m4; i++) {
            grid[r][c] = queue.poll();
            r++;
            c++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", grid[i][j]);
            }
            System.out.println();
        }
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
        r = scanner.nextInt() - 1;
        c = scanner.nextInt() - 1;
        m1 = scanner.nextInt();
        m2 = scanner.nextInt();
        m3 = scanner.nextInt();
        m4 = scanner.nextInt();
        dir = scanner.nextInt();
        sol();
        scanner.close();
    }
}
