import java.util.*;
import java.io.*;

class Cell implements Comparable<Cell> {
    int num, x, y;

    public Cell(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }

    // num 기준 오름차순 정렬
    @Override
    public int compareTo(Cell c) {
        return this.num - c.num;
    }
}

public class Main {
    static final int MAX_N = 500;

    static int n;
    static int[][] grid = new int[MAX_N][MAX_N];
    static int[][] dp = new int[MAX_N][MAX_N];

    static List<Cell> cells = new ArrayList<>();
    static int ans = 0;

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells.add(new Cell(grid[i][j], i, j));
            }
        }

        Collections.sort(cells);

        //처음 DP 값들 1로 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1;
            }
        }

        for (int i = 0; i < cells.size(); i++) {
            int x = cells.get(i).x;
            int y = cells.get(i).y;
            int[] dx = new int[]{-1, 1, 0, 0};
            int[] dy = new int[]{0, 0, -1, 1};

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (inRange(nx, ny) && grid[nx][ny] > grid[x][y]) {
                    dp[nx][ny] = Math.max(dp[nx][ny], dp[x][y] + 1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.print(ans);
    }
}