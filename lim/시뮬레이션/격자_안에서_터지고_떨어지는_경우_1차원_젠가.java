package lim.시뮬레이션;

import java.util.Scanner;

public class 격자_안에서_터지고_떨어지는_경우_1차원_젠가 {
    private static int n;
    private static Game game;
    private static Query[] queries = new Query[2];

    public static class Game {
        private int[] blocks;

        Game(int[] blocks) {
            this.blocks = blocks;
        }

        void bomb(Query query) {
            int newSize = blocks.length - (query.endAt - query.startAt + 1);
            int[] newBlocks = new int[newSize];

            int newBlocksIdx = 0;
            for (int i = 0; i < blocks.length; i++) {
                if (query.inRange(i)) {
                    continue;
                }
                newBlocks[newBlocksIdx] = blocks[i];
                newBlocksIdx++;
            }
            blocks = newBlocks;
        }

        void printBlocks() {
            System.out.println(blocks.length);
            for (int i = 0; i < blocks.length; i++) {
                System.out.println(blocks[i]);
            }
        }
    }

    public static class Query {
        int startAt;
        int endAt;

        Query(int startAt, int endAt) {
            this.startAt = startAt;
            this.endAt = endAt;
        }

        boolean inRange(int idx) {
            return startAt <= idx && idx <= endAt;
        }
    }

    private static void sol() {
        for (int i = 0; i < queries.length; i++) {
            game.bomb(queries[i]);
        }
        game.printBlocks();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        game = new Game(arr);

        for (int i = 0; i < 2; i++) {
            Query query = new Query(scanner.nextInt() - 1, scanner.nextInt() - 1);
            queries[i] = query;
        }
        sol();
        scanner.close();
    }
}
