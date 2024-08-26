import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100;
    static final int DIR_NUM = 4;

    static int n;
    static int currX, currY;
    static int[][] grid = new int[MAX_N + 1][MAX_N + 1];

    static List<Integer> visitedNums = new ArrayList<>();

    static boolean canGo(int x, int y, int currNum) {
        if (1 <= x && x <= n && 1 <= y && y <= n) {
            if (grid[x][y] > currNum) {
                return true;
            }
        }
        return false;
    }

    static boolean simulate() {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nextX = currX + dx[i];
            int nextY = currY + dy[i];

            if (canGo(nextX, nextY, grid[currX][currY])) {
                currX = nextX;
                currY = nextY;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        currX = Integer.parseInt(st.nextToken());
        currY = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visitedNums.add(grid[currX][currY]);

        while (true) {
            boolean greaterNumberExist = simulate();

            if (!greaterNumberExist) {
                break;
            }

            visitedNums.add(grid[currX][currY]);
        }

        for (int i = 0; i < visitedNums.size(); i++) {
            System.out.print(visitedNums.get(i) + " ");
        }
    }
}