package lim.BFS;

import java.util.*;
import java.io.*;

public class 가중치가_동일한_그래프에서의_BFS_나이트 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] visited;
    static int[] drs = { -2, -1, +1, +2, +2, +1, -1, -2 };
    static int[] dcs = { +1, +2, +2, +1, -1, -2, -2, -1 };
    static int n, m, sr, sc, er, ec;
    static int answer = Integer.MAX_VALUE;

    static class Pos {
        int r, c, depth;

        Pos(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }

        boolean inRange() {
            return r >= 0 && c >= 0 && r < n && c < n;
        }

        boolean isVisited() {
            return visited[r][c];
        }

        void visit() {
            visited[r][c] = true;
        }

        boolean inEnd() {
            return r == er && c == ec;
        }
    }

    static void bfs(int r, int c) throws IOException {
        LinkedList<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(r, c, 0));
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            if (pos.inEnd()) {
                answer = Math.min(answer, pos.depth);
            }
            for (int i = 0; i < dcs.length; i++) {
                Pos newPos = new Pos(pos.r + drs[i], pos.c + dcs[i], pos.depth + 1);
                if (!newPos.inRange() || newPos.isVisited()) {
                    continue;
                }
                newPos.visit();
                queue.offer(newPos);
            }
        }
    }

    static void sol() throws IOException {
        bfs(sr, sc);
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n][n];
        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;
        er = Integer.parseInt(st.nextToken()) - 1;
        ec = Integer.parseInt(st.nextToken()) - 1;

        sol();
        br.close();
    }
}
