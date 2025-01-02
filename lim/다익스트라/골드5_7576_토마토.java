package lim.다익스트라;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 골드5_7576_토마토 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] grid;
    static int[] dxs = { 1, 0, -1, 0 };
    static int[] dys = { 0, 1, 0, -1 };

    static class Cost implements Comparable<Cost> {
        int x, y, dist;

        public Cost(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Cost o) {
            return this.dist - o.dist;
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }

    static void dijstra(PriorityQueue<Cost> queue, int[][] dists) {
        while (!queue.isEmpty()) {
            Cost cost = queue.poll();
            if (dists[cost.x][cost.y] < cost.dist) {
                continue;
            }
            for (int i = 0; i < dxs.length; i++) {
                int nx = cost.x + dxs[i];
                int ny = cost.y + dys[i];
                int nDist = cost.dist + 1;
                if (!inRange(nx, ny) || grid[nx][ny] == -1) {
                    continue;
                }
                if (dists[nx][ny] <= nDist) {
                    continue;
                }
                dists[nx][ny] = nDist;
                queue.offer(new Cost(nx, ny, nDist));
            }
        }
    }

    static void sol() throws IOException {
        int[][] dists = new int[grid.length][grid[0].length];
        PriorityQueue<Cost> queue = new PriorityQueue<>();

        for (int i = 0; i < dists.length; i++) {
            for (int j = 0; j < dists[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new Cost(i, j, 0));
                    continue;
                }
                dists[i][j] = Integer.MAX_VALUE;
            }
        }
        dijstra(queue, dists);

        int maxDist = 0;
        for (int i = 0; i < dists.length; i++) {
            for (int j = 0; j < dists[0].length; j++) {
                if (dists[i][j] == Integer.MAX_VALUE) {
                    if (grid[i][j] == 0) {
                        bw.write("-1");
                        return;
                    }
                    continue;
                }
                maxDist = Math.max(maxDist, dists[i][j]);
            }
        }
        bw.write(maxDist + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        grid = new int[n][m];

        for (int i = 0; i < grid.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
