package lim.다익스트라;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 골드5_7569_토마토 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][][] cube;
    static int[] dxs = { 1, 0, 0, -1, 0, 0 };
    static int[] dys = { 0, 1, 0, 0, -1, 0 };
    static int[] dzs = { 0, 0, 1, 0, 0, -1 };

    static class Cost implements Comparable<Cost> {
        int x, y, z, dist;

        public Cost(int x, int y, int z, int dist) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.dist = dist;
        }

        @Override
        public int compareTo(Cost o) {
            return this.dist - o.dist;
        }
    }

    static boolean inRange(int x, int y, int z) {
        return x >= 0 && y >= 0 && z >= 0 && x < cube.length && y < cube[0].length && z < cube[0][0].length;
    }

    static void dijstra(PriorityQueue<Cost> queue, int[][][] dists) {
        while (!queue.isEmpty()) {
            Cost cost = queue.poll();
            if (dists[cost.x][cost.y][cost.z] < cost.dist) {
                continue;
            }
            for (int i = 0; i < dxs.length; i++) {
                int nx = cost.x + dxs[i];
                int ny = cost.y + dys[i];
                int nz = cost.z + dzs[i];
                int nDist = cost.dist + 1;
                if (!inRange(nx, ny, nz) || cube[nx][ny][nz] == -1) {
                    continue;
                }
                if (dists[nx][ny][nz] <= nDist) {
                    continue;
                }
                dists[nx][ny][nz] = nDist;
                queue.offer(new Cost(nx, ny, nz, nDist));
            }
        }
    }

    static void sol() throws IOException {
        int[][][] dists = new int[cube.length][cube[0].length][cube[0][0].length];
        PriorityQueue<Cost> queue = new PriorityQueue<>();

        for (int i = 0; i < dists.length; i++) {
            for (int j = 0; j < dists[0].length; j++) {
                for (int k = 0; k < dists[0][0].length; k++) {
                    if (cube[i][j][k] == 1) {
                        queue.offer(new Cost(i, j, k, 0));
                        continue;
                    }
                    dists[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        dijstra(queue, dists);

        int maxDist = 0;
        for (int i = 0; i < dists.length; i++) {
            for (int j = 0; j < dists[0].length; j++) {
                for (int k = 0; k < dists[0][0].length; k++) {
                    if (dists[i][j][k] == Integer.MAX_VALUE) {
                        if (cube[i][j][k] == 0) {
                            bw.write("-1");
                            return;
                        }
                        continue;
                    }
                    maxDist = Math.max(maxDist, dists[i][j][k]);
                }
            }
        }
        bw.write(maxDist + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        cube = new int[h][n][m];

        for (int i = 0; i < cube.length; i++) {
            for (int j = 0; j < cube[0].length; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < cube[0][0].length; k++) {
                    cube[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
