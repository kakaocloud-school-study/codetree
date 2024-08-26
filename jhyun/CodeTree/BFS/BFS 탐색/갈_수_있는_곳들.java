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

    static int n, k;
    static int[][] grid = new int[MAX_N][MAX_N];

    static Queue<Pair> queue = new LinkedList<>();
    static boolean[][] visited = new boolean[MAX_N][MAX_N];

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    static boolean canGo(int x, int y) {
        return inRange(x, y) && grid[x][y] == 0 && !visited[x][y];
    }

    static void BFS() {
        while (!queue.isEmpty()) {
            Pair currPos = queue.poll();
            int x = currPos.x;
            int y = currPos.y;

            int[] dx = new int[]{1, -1, 0, 0};
            int[] dy = new int[]{0, 0, 1, -1};

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (canGo(newX, newY)) {
                    visited[newX][newY] = true;
                    queue.add(new Pair(newX, newY));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            queue.add(new Pair(x - 1, y - 1));
            visited[x - 1][y - 1] = true;
        }

        BFS();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    ans++;
                }
            }
        }

        System.out.print(ans);
    }
}