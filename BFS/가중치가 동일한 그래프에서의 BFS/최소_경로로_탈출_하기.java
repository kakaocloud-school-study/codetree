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
    static final int INT_MAX = Integer.MAX_VALUE;
    static final int MAX_N = 100;
    static final int MAX_M = 100;

    static int n, m;
    static int[][] step = new int[MAX_N][MAX_M];
    static int[][] grid = new int[MAX_N][MAX_M];
    static boolean[][] visited = new boolean[MAX_N][MAX_M];
    static Queue<Pair> queue = new LinkedList<>();

    static int ans = INT_MAX;

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    static boolean canGo(int x, int y) {
        return inRange(x, y) && grid[x][y] == 1 && !visited[x][y];
    }

    static void push(int x, int y, int s) {
        queue.add(new Pair(x, y));
        visited[x][y] = true;
        step[x][y] = s;
    }

    static void findMin() {
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int x = curr.x;
            int y = curr.y;

            int[] dx = new int[]{0, 1, 0, -1};
            int[] dy = new int[]{1, 0, -1, 0};

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (canGo(newX, newY)) {
                    push(newX, newY, step[x][y] + 1);
                }
            }
        }

        if (visited[n - 1][m - 1]) {
            ans = step[n - 1][m - 1];
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        push(0, 0, 0);
        findMin();

        if (ans == INT_MAX) {
            ans = -1;
        }

        System.out.println(ans);
    }
}