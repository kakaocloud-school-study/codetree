import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100;
    static final int DIR_N = 2;

    static int n, m;
    static int[][] grid = new int[MAX_N][MAX_N];
    static int[][] visited = new int[MAX_N][MAX_N];

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    static boolean canGo(int x, int y) {
        if (!inRange(x, y)) {
            return false;
        }
        if (visited[x][y] == 1 || grid[x][y] == 0) {
            return false;
        }
        return true;
    }

    static void DFS(int x, int y) {
        int[] dx = new int[]{1, 0};
        int[] dy = new int[]{0, 1};

        for (int i = 0; i < DIR_N; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (canGo(newX, newY)) {
                visited[newX][newY] = 1;
                DFS(newX, newY);
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
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0] = 1;
        DFS(0, 0);

        System.out.println(visited[n - 1][m - 1]);
    }
}