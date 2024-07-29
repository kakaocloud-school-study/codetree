import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 50;
    static final int MAX_M = 50;
    static final int DIR_N = 4;
    static final int MAX_HEIGHT = 100;

    static int n, m;
    static int[][] grid = new int[MAX_N][MAX_M];
    static boolean[][] visited = new boolean[MAX_N][MAX_M];
    static int zoneNum;

    static void initializeVisited() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = false;
            }
        }
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    static boolean canGo(int x, int y, int k) {
        if (!inRange(x, y)) {
            return false;
        }
        if (visited[x][y] || grid[x][y] <= k) {
            return false;
        }
        return true;
    }

    static void DFS(int x, int y, int k) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        for (int dir = 0; dir < DIR_N; dir++) {
            int newX = x + dx[dir];
            int newY = y + dy[dir];

            if (canGo(newX, newY, k)) {
                visited[newX][newY] = true;
                DFS(newX, newY, k);
            }
        }
    }

    static void getZoneNum(int k) {
        zoneNum = 0;
        initializeVisited();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canGo(i, j, k)) {
                    visited[i][j] = true;
                    zoneNum++;

                    DFS(i, j, k);
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
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxZoneNum = -1;
        int answerK = 0;

        for (int k = 1; k <= MAX_HEIGHT; k++) {
            getZoneNum(k);

            if (zoneNum > maxZoneNum) {
                maxZoneNum = zoneNum;
                answerK = k;
            }
        }

        System.out.print(answerK + " " + maxZoneNum);
    }
}