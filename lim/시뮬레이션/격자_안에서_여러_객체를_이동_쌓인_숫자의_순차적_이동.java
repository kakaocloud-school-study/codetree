package lim.시뮬레이션;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class 격자_안에서_여러_객체를_이동_쌓인_숫자의_순차적_이동 {
    private static int n, m;
    private static int[] queries;
    private static Game game;

    public static class Game {
        LinkedList<Integer>[][] grid;
        int[] drs = { -1, 1, 0, 0, 1, 1, -1, -1 };
        int[] dcs = { 0, 0, -1, 1, 1, -1, 1, -1 };

        Game(LinkedList<Integer>[][] grid) {
            this.grid = grid;
        }

        boolean inRange(int r, int c) {
            return r >= 0 && c >= 0 && r < n && c < n;
        }

        int getMaxNum(LinkedList<Integer> arr) {
            int maxNum = -1;
            for (Integer num : arr) {
                maxNum = Math.max(maxNum, num);
            }
            return maxNum;
        }

        int[] findMaxAdjPos(int r, int c) {
            int[] pos = new int[2];
            int maxR = -1;
            int maxC = -1;
            int maxNum = -1;
            for (int i = 0; i < drs.length; i++) {
                int nr = r + drs[i];
                int nc = c + dcs[i];
                if (!inRange(nr, nc)) {
                    continue;
                }
                if (maxR == -1 || maxNum < getMaxNum(grid[nr][nc])) {
                    maxR = nr;
                    maxC = nc;
                    maxNum = getMaxNum(grid[maxR][maxC]);
                }
            }
            pos[0] = maxR;
            pos[1] = maxC;
            return pos;
        }

        int[] findPos(int targetNum) {
            int[] pos = new int[2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (Integer num : grid[i][j]) {
                        if (targetNum == num) {
                            pos[0] = i;
                            pos[1] = j;
                            return pos;
                        }
                    }
                }
            }
            return pos;
        }

        LinkedList<Integer> popSubStack(LinkedList<Integer> stack, int bottomNum) {
            LinkedList<Integer> newStack = new LinkedList<>();
            boolean isTarget = false;
            Iterator<Integer> it = stack.iterator();
            while (it.hasNext()) {
                int num = it.next();
                if (num == bottomNum) {
                    isTarget = true;
                }
                if (isTarget) {
                    it.remove();
                    newStack.offer(num);
                }
            }
            return newStack;
        }

        void move(int targetNum) {
            int[] targetNumPos = findPos(targetNum);
            int r = targetNumPos[0];
            int c = targetNumPos[1];
            LinkedList<Integer> stack = popSubStack(grid[r][c], targetNum);

            int[] newPos = findMaxAdjPos(r, c);
            int nr = newPos[0];
            int nc = newPos[1];
            grid[nr][nc].addAll(stack);
        }

        void printGrid() {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j].size() == 0) {
                        System.out.println("None");
                        continue;
                    }

                    Collections.reverse(grid[i][j]);
                    for (int num : grid[i][j]) {
                        System.out.printf("%d ", num);
                    }
                    System.out.println();
                }
            }
        }
    }

    private static void sol() {
        for (int q : queries) {
            game.move(q);
        }
        game.printGrid();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        @SuppressWarnings("unchecked")
        LinkedList<Integer>[][] grid = new LinkedList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                LinkedList<Integer> arr = new LinkedList<>();
                arr.offer(scanner.nextInt());
                grid[i][j] = arr;
            }
        }
        queries = new int[m];
        for (int i = 0; i < m; i++) {
            queries[i] = scanner.nextInt();
        }
        game = new Game(grid);
        sol();
        scanner.close();
    }
}
