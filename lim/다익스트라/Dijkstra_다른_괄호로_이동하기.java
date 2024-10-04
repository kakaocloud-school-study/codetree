package lim.다익스트라;

import java.util.*;
import java.io.*;

public class Dijkstra_다른_괄호로_이동하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, a, b;
    static int[] drs = { 1, 0, -1, 0 }, dcs = { 0, 1, 0, -1 };
    static int[][] grid;

    static class Item implements Comparable<Item> {
        int r, c, dist;

        public Item(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

        @Override
        public int compareTo(Item item) {
            return this.dist - item.dist;
        }
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length;
    }

    static int getCost(int r1, int c1, int r2, int c2) {
        if (grid[r1][c1] == grid[r2][c2]) {
            return a;
        }
        return b;
    }

    static void dijkstra(int sr, int sc, int[][] dists) {
        PriorityQueue<Item> queue = new PriorityQueue<>();
        queue.offer(new Item(sr, sc, 0));
        dists[sr][sc] = 0;

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (item.dist > dists[item.r][item.c]) {
                continue;
            }

            for (int i = 0; i < drs.length; i++) {
                int nr = item.r + drs[i];
                int nc = item.c + dcs[i];
                if (!inRange(nr, nc)) {
                    continue;
                }
                int nDist = item.dist + getCost(item.r, item.c, nr, nc);
                if (nDist >= dists[nr][nc]) {
                    continue;
                }
                dists[nr][nc] = nDist;
                queue.offer(new Item(nr, nc, nDist));
            }
        }
    }

    static int getMaxDist(int[][] dists) {
        int maxDist = 0;
        for (int i = 0; i < dists.length; i++) {
            for (int j = 0; j < dists[0].length; j++) {
                if (dists[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                maxDist = Math.max(maxDist, dists[i][j]);
            }
        }
        return maxDist;
    }

    static void initDists(int[][] dists) {
        for (int i = 0; i < dists.length; i++) {
            for (int j = 0; j < dists[0].length; j++) {
                dists[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    static void sol() throws IOException {
        int maxDist = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int[][] dists = new int[grid.length][grid[0].length];
                initDists(dists);
                dijkstra(i, j, dists);
                maxDist = Math.max(maxDist, getMaxDist(dists));
            }
        }
        bw.write(maxDist + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        for (int i = 0; i < grid.length; i++) {
            String word = br.readLine();
            for (int j = 0; j < grid[0].length; j++) {
                if (word.charAt(j) == '(') {
                    grid[i][j] = 1;
                }
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}