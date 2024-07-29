import java.util.*;
import java.io.*;


public class Main {
    static final int DIR_NUM = 4;
    static final int MAX_N = 100;

    static int n, m, r, c;
    static int[][] grid = new int[MAX_N][MAX_N];
    static int[][] nextGrid = new int[MAX_N][MAX_N];

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    static void expand(int x, int y, int dist) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i] * dist;
            int ny = y + dy[i] * dist;

            if (inRange(nx, ny)) {
                nextGrid[nx][ny] = 1;
            }
        }

    }

    static void simulate(int dist) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nextGrid[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    expand(i, j, dist);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nextGrid[i][j] > 0) {
                    grid[i][j] = 1;
                }
            }

        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        grid[r - 1][c - 1] = 1;

        int dist = 1;
        while (m-- > 0) {
            simulate(dist);
            dist *= 2;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += grid[i][j];
            }
        }

        System.out.print(ans);
    }
}