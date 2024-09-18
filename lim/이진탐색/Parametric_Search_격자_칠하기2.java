package lim.이진탐색;

import java.util.*;
import java.io.*;

public class Parametric_Search_격자_칠하기2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
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
        return r >= 0 && c >= 0 && r < n && c < n;
    }

    static boolean canGo(int r, int c, int nr, int nc, int maxDiff) {
        if (!inRange(nr, nc)) {
            return false;
        }
        int diff = Math.abs(grid[r][c] - grid[nr][nc]);
        return diff <= maxDiff;
    }

    static int bfs(int r, int c, int maxDiff) {
        int count = 0;
        LinkedList<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(r, c));
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            count++;

            for (int i = 0; i < dcs.length; i++) {
                int nr = tuple.r + drs[i];
                int nc = tuple.c + dcs[i];
                if (!canGo(tuple.r, tuple.c, nr, nc, maxDiff) || visited[nr][nc]) {
                    continue;
                }
                queue.add(new Tuple(nr, nc));
                visited[nr][nc] = true;
            }
        }

        return count;
    }

    static boolean check(int maxDiff) {
        visited = new boolean[n][n];
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j]) {
                    continue;
                }
                maxArea = Math.max(maxArea, bfs(i, j, maxDiff));
            }
        }
        return maxArea >= Math.round(n * n / 2);
    }

    static void sol() throws IOException {
        int left = 0, right = 1_000_000;
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
        grid = new int[n][n];
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
