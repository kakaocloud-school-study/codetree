/*
 * 아이디어1, 탐색하면서 벽을 부쉈는지 여부를 기록하고 부순상태에서 또 벽을 만나면 탐색중단
 * 아이디어2, visited 상태를 미방문, 벽안뿌방문, 벽뿌방문 세 개로 나눈다. 
 * 같은 거리라면 벽안뿌 상태에서 방문한 걸 살리는게 유리하므로 벽안뿌 상태가 덮어쓰기 우선된다.
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 벽_부수고_이동하기_골드3_2206 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int WALL = 1, ROAD = 0, NOT_VISITED = 0, BROKEN_VISITED = 1, VISITED = 2;
    static int[][] grid, visited;
    static int[] drs = { 1, 0, -1, 0 };
    static int[] dcs = { 0, 1, 0, -1 };
    static LinkedList<Pos> queue = new LinkedList<>();
    static int n, m, answer = -1;

    static class Pos {
        int r, c, dist;
        boolean broken;

        Pos(int r, int c, int dist, boolean broken) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.broken = broken;
        }
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }

    static void bfs(int destR, int destC) {
        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            if (pos.r == destR && pos.c == destC) {
                answer = pos.dist;
                return;
            }
            for (int i = 0; i < dcs.length; i++) {
                int nr = pos.r + drs[i];
                int nc = pos.c + dcs[i];
                int nDist = pos.dist + 1;
                boolean nBroken = pos.broken;
                if (!inRange(nr, nc)) {
                    continue;
                }
                if (visited[nr][nc] == VISITED) {
                    continue;
                }
                if (visited[nr][nc] == BROKEN_VISITED && pos.broken) {
                    continue;
                }
                if (grid[nr][nc] == WALL && pos.broken) {
                    continue;
                }
                if (grid[nr][nc] == WALL) {
                    nBroken = true;
                }

                Pos newPos = new Pos(nr, nc, nDist, nBroken);
                if (nBroken) {
                    visited[nr][nc] = BROKEN_VISITED;
                } else {
                    visited[nr][nc] = VISITED;
                }
                queue.offer(newPos);
            }
        }
    }

    static void sol(int n) throws IOException {
        queue.offer(new Pos(0, 0, 1, false));
        visited[0][0] = VISITED;
        bfs(n - 1, m - 1);

        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }
        sol(n);
        br.close();
        bw.flush();
        bw.close();
    }
}

// 5 3
// 000
// 110
// 100
// 111
// 000