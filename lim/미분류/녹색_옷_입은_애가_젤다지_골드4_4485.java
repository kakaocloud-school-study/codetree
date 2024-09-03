/*
 * 그냥 다익스트라
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 녹색_옷_입은_애가_젤다지_골드4_4485 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] grid, dists;
    static int[] drs = { 1, 0, -1, 0 };
    static int[] dcs = { 0, 1, 0, -1 };
    static PriorityQueue<Pos> queue = new PriorityQueue<>((p1, p2) -> p1.dist - p2.dist);
    static int n;

    static class Pos {
        int r, c, dist;

        Pos(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }

    static void dijkstra(int destR, int destC) {
        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            if (pos.dist > dists[pos.r][pos.c]) {
                continue;
            }
            for (int i = 0; i < dcs.length; i++) {
                int nr = pos.r + drs[i];
                int nc = pos.c + dcs[i];
                if (!inRange(nr, nc)) {
                    continue;
                }
                int nDist = pos.dist + grid[nr][nc];

                if (nDist >= dists[nr][nc]) {
                    continue;
                }

                dists[nr][nc] = nDist;
                Pos newPos = new Pos(nr, nc, nDist);
                queue.offer(newPos);
            }
        }
    }

    static void sol(int caseNum) throws IOException {
        dists[0][0] = grid[0][0];
        queue.offer(new Pos(0, 0, grid[0][0]));
        dijkstra(n - 1, n - 1);

        bw.write("Problem " + caseNum + ": " + dists[n - 1][n - 1] + "\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        int caseNum = 1;
        while (n > 0) {
            queue.clear();
            grid = new int[n][n];
            dists = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                    dists[i][j] = Integer.MAX_VALUE;
                }
            }

            sol(caseNum++);

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
        }
        br.close();
        bw.flush();
        bw.close();
    }
}