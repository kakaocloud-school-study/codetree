import java.util.*;
import java.io.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static final int MAX_N = 100;
    static final int[] dx = new int[]{0, -1, 0, 1};
    static final int[] dy = new int[]{-1, 0, 1, 0};

    static int n, m;
    static int startX, startY;
    static int[][] board = new int[MAX_N][MAX_N];
    static int[][] colored = new int[MAX_N][MAX_N];
    static boolean[][] visited = new boolean[MAX_N][MAX_N];

    static void bfs(int d) {
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(startX, startY));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = pair.x + dx[i];
                int nextY = pair.y + dy[i];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                    if (!visited[nextX][nextY] && Math.abs(board[pair.x][pair.y] - board[nextX][nextY]) <= d) {
                        queue.add(new Pair(nextX, nextY));
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }

    static boolean reachable(int d) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        bfs(d);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((colored[i][j] > 0) && !visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                colored[i][j] = Integer.parseInt(st.nextToken());
                if (colored[i][j] > 0) {
                    startX = i;
                    startY = j;
                }
            }
        }

        int low = 0;
        int high = 1000000000;
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (reachable(mid)) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.print(ans);
    }
}