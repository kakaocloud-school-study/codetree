import java.util.*;
import java.io.*;

public class Main {
    static int MAX_N = 200;
    static int[][] grid = new int[MAX_N][MAX_N];
    static int n, m;

    //가능한 모든 모양을 전부 적기
    static int[][][] shapes = new int[][][]{
            {{1, 1, 0},
                    {1, 0, 0},
                    {0, 0, 0}},

            {{1, 1, 0},
                    {0, 1, 0},
                    {0, 0, 0}},

            {{1, 0, 0},
                    {1, 1, 0},
                    {0, 0, 0}},

            {{0, 1, 0},
                    {1, 1, 0},
                    {0, 0, 0}},

            {{1, 1, 1},
                    {0, 0, 0},
                    {0, 0, 0}},

            {{1, 0, 0},
                    {1, 0, 0},
                    {1, 0, 0}}
    };

    static int getMaxSum(int x, int y) {
        int maxSum = 0;

        for (int i = 0; i < 6; i++) {
            boolean isPossible = true;
            int sum = 0;
            for (int dx = 0; dx < 3; dx++) {
                for (int dy = 0; dy < 3; dy++) {
                    if (shapes[i][dx][dy] == 0) {
                        continue;
                    }

                    if (x + dx >= n || y + dy >= m) {
                        isPossible = false;
                    } else {
                        sum += grid[x + dx][y + dy];
                    }
                }
                if (isPossible) {
                    maxSum = Math.max(sum, maxSum);
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < m; col++) {
                grid[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                ans = Math.max(ans, getMaxSum(row, col));
            }
        }

        System.out.print(ans);
    }
}