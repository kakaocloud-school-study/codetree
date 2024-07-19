package lim.시뮬레이션;

import java.util.HashMap;
import java.util.Scanner;

public class 격자_안에서_단일_객체를_이동_뱀은_사과를_좋아해 {
    private static int n, m, k;
    private static Game game;
    private static String[] cmds;
    private static int[] distances;

    public static class Game {
        int[][] snakeGrid;
        int[][] appleGrid;
        int[] drs = { 0, -1, 1, 0, 0 };
        int[] dcs = { 0, 0, 0, -1, 1 };
        HashMap<String, Integer> directionMapper = new HashMap<>();
        int hr = 0;
        int hc = 0;
        int tr = 0;
        int tc = 0;
        int time = 0;

        Game(int[][] snakeGrid, int[][] appleGrid) {
            this.snakeGrid = snakeGrid;
            this.appleGrid = appleGrid;
            directionMapper.put("R", 4);
            directionMapper.put("L", 3);
            directionMapper.put("U", 1);
            directionMapper.put("D", 2);
        }

        boolean inRange(int r, int c) {
            return r >= 0 && c >= 0 && r < n && c < n;
        }

        boolean isAppleNext(int direction) {
            int nr = hr + drs[direction];
            int nc = hc + dcs[direction];
            if (!inRange(nr, nc)) {
                return false;
            }
            return appleGrid[nr][nc] == 1;
        }

        void goTail() {
            int direction = snakeGrid[tr][tc];
            int nr = tr + drs[direction];
            int nc = tc + dcs[direction];
            if (inRange(nr, nc)) {
                snakeGrid[tr][tc] = 0;
                tr = nr;
                tc = nc;
            }
        }

        boolean goHead(int direction) {
            int nr = hr + drs[direction];
            int nc = hc + dcs[direction];
            if (inRange(nr, nc) && snakeGrid[nr][nc] == 0) {
                hr = nr;
                hc = nc;
                snakeGrid[hr][hc] = direction;
                appleGrid[hr][hc] = 0;
                return true;
            }
            return false;
        }

        boolean go(String cmd, int distance) {
            if (distance < 1) {
                return true;
            }
            time++;
            int direction = directionMapper.get(cmd);
            snakeGrid[hr][hc] = direction;
            boolean appleNext = isAppleNext(direction);
            if (!appleNext) {
                goTail();
            }
            if (goHead(direction) == false) {
                return false;
            }
            // System.out.printf("%d, %d, %d, %d, %d\n", hr, hc, tr, tc, time);
            return go(cmd, distance - 1);
        }

        void printTime() {
            System.out.println(time);
        }
    }

    private static void sol() {
        for (int i = 0; i < k; i++) {
            if (game.go(cmds[i], distances[i]) == false) {
                break;
            }
        }
        game.printTime();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        int[][] snakeGrid = new int[n][n];
        int[][] appleGrid = new int[n][n];
        for (int i = 0; i < m; i++) {
            appleGrid[scanner.nextInt() - 1][scanner.nextInt() - 1] = 1;
        }
        cmds = new String[k];
        distances = new int[k];
        for (int i = 0; i < k; i++) {
            cmds[i] = scanner.next();
            distances[i] = scanner.nextInt();
        }
        game = new Game(snakeGrid, appleGrid);
        sol();
        scanner.close();
    }
}
