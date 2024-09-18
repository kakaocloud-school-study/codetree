package lim.이진탐색;

import java.util.*;
import java.io.*;

public class Parametric_Search_높이_차를_최소화_하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] drs = { 1, 0, -1, 0 }, dcs = { 0, 1, 0, -1 };
    static int[][] grid;
    static boolean[][] visited;

    static class Tuple {
        int r, c;

        Tuple(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }

    static boolean canGo(int nr, int nc, int minVal, int maxVal) {
        if (!inRange(nr, nc)) {
            return false;
        }
        return minVal <= grid[nr][nc] && grid[nr][nc] <= maxVal;
    }

    static boolean bfs(int r, int c, int minVal, int maxVal) {
        LinkedList<Tuple> queue = new LinkedList<>();
        visited = new boolean[n][m];
        queue.offer(new Tuple(r, c));
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            if (tuple.r == n - 1 && tuple.c == m - 1) {
                return true;
            }

            for (int i = 0; i < dcs.length; i++) {
                int nr = tuple.r + drs[i];
                int nc = tuple.c + dcs[i];
                if (!canGo(nr, nc, minVal, maxVal) || visited[nr][nc]) {
                    continue;
                }
                queue.add(new Tuple(nr, nc));
                visited[nr][nc] = true;
            }
        }

        return false;
    }

    static boolean check(int maxDiff) {
        for (int minVal = 0; minVal + maxDiff <= 500; minVal++) {
            int maxVal = minVal + maxDiff;
            if (!canGo(0, 0, minVal, maxVal)) {
                continue;
            }
            if (bfs(0, 0, minVal, maxVal)) {
                return true;
            }
        }
        return false;
    }

    static void sol() throws IOException {
        int left = 0, right = 500;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
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
