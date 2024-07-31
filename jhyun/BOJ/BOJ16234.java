package jhyun.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16234 {
    static int n, l, r;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(simulate());
    }

    private static int simulate() {
        int days = 0;
        while (true) {
            boolean moved = false;
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            moved = true;
                        }
                    }
                }
            }

            if (!moved)
                break;
            days++;
        }
        return days;
    }

    private static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> union = new LinkedList<>();
        queue.offer(new int[]{x, y});
        union.offer(new int[]{x, y});
        visited[x][y] = true;

        int sum = map[x][y];
        int count = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (inRange(nx, ny) && !visited[nx][ny]) {
                    int diff = Math.abs(map[cur[0]][cur[1]] - map[nx][ny]);
                    if (diff >= l && diff <= r) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        union.offer(new int[]{nx, ny});
                        sum += map[nx][ny];
                        count++;
                    }
                }
            }
        }

        if (count > 1) {
            int newPopulation = sum / count;
            while (!union.isEmpty()) {
                int[] pos = union.poll();
                map[pos[0]][pos[1]] = newPopulation;
            }
            return true;
        }
        return false;
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n;
    }
}