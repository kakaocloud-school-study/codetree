import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 200;

    static int n;
    static int[][] grid = new int[MAX_N][MAX_N];
    static int[][] nextGrid = new int[MAX_N][MAX_N];

    static boolean inBombRange(int x, int y, int centerX, int centerY, int bombRange) {
        return (x == centerX || y == centerY) && Math.abs(x - centerX) + Math.abs(y - centerY) < bombRange;
    }

    static void bomb(int x, int y) {
        int bombRange = grid[x][y];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (inBombRange(i, j, x, y, bombRange)) {
                    grid[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            int nextRow = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (grid[i][j] > 0) {
                    nextGrid[nextRow--][j] = grid[i][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = nextGrid[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bomb(r - 1, c - 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}