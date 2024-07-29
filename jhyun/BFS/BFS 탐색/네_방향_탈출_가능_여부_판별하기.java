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

    static int n, m;
    static int[][] arr = new int[MAX_N][MAX_N];
    static boolean[][] visited = new boolean[MAX_N][MAX_N];
    static Queue<Pair> queue = new LinkedList<>();

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    static boolean canGo(int x, int y) {
        return inRange(x, y) && arr[x][y] == 1 && !visited[x][y];
    }

    static void BFS() {
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
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue.add(new Pair(0, 0));
        visited[0][0] = true;

        BFS();

        int answer = visited[n - 1][m - 1] ? 1 : 0;
        System.out.println(answer);
    }
}