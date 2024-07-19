package lim.시뮬레이션;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class 격자_안에서_단일_객체를_이동_주사위_던지기 {
    private static int n, m;
    private static Game game;
    private static String[] queries;

    public static class Game {
        int[][] grid;
        int[] drs = { -1, 1, 0, 0 };
        int[] dcs = { 0, 0, -1, 1 };
        HashMap<String, Integer> directionMapper = new HashMap<>();
        int r;
        int c;
        LinkedList<Integer> horizontal = new LinkedList<>();
        LinkedList<Integer> vertical = new LinkedList<>();

        Game(int[][] grid, int r, int c) {
            this.grid = grid;
            this.r = r;
            this.c = c;
            horizontal.addAll(Arrays.asList(4, 6, 3));
            vertical.addAll(Arrays.asList(5, 6, 2));
            directionMapper.put("R", 3);
            directionMapper.put("L", 2);
            directionMapper.put("U", 0);
            directionMapper.put("D", 1);
            grid[r][c] = horizontal.get(1);
        }

        boolean inRange(int r, int c) {
            return r >= 0 && c >= 0 && r < n && c < n;
        }

        int rotateAndGetBottom(String cmd) {
            int bottom = horizontal.get(1);
            if (cmd.equals("R")) {
                horizontal.pollFirst();
                horizontal.offerLast(7 - bottom);
                bottom = horizontal.get(1);
                vertical.set(1, bottom);
            } else if (cmd.equals("L")) {
                horizontal.pollLast();
                horizontal.offerFirst(7 - bottom);
                bottom = horizontal.get(1);
                vertical.set(1, bottom);
            } else if (cmd.equals("D")) {
                vertical.pollFirst();
                vertical.offerLast(7 - bottom);
                bottom = vertical.get(1);
                horizontal.set(1, bottom);
            } else if (cmd.equals("U")) {
                vertical.pollLast();
                vertical.offerFirst(7 - bottom);
                bottom = vertical.get(1);
                horizontal.set(1, bottom);
            }
            return bottom;
        }

        void go(String cmd) {
            int direction = directionMapper.get(cmd);
            int nr = r + drs[direction];
            int nc = c + dcs[direction];
            if (!inRange(nr, nc)) {
                return;
            }

            r = nr;
            c = nc;
            int bottom = rotateAndGetBottom(cmd);
            grid[r][c] = bottom;
        }

        void printSum() {
            int valueSum = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    valueSum += grid[i][j];
                }
            }
            System.out.println(valueSum);
        }
    }

    private static void sol() {
        for (int i = 0; i < m; i++) {
            game.go(queries[i]);
        }
        game.printSum();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int[][] grid = new int[n][n];
        game = new Game(grid, r - 1, c - 1);
        queries = new String[m];
        for (int i = 0; i < m; i++) {
            queries[i] = scanner.next();
        }
        sol();
        scanner.close();
    }
}
