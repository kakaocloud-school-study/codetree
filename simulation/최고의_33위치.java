import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 20;
    static int[][] grid = new int[MAX_N][MAX_N];

    static int getNumOfGold(int rowS, int colS, int maxRow, int maxCol) {
        int numOfGold = 0;

        for (int row = rowS; row <= maxRow; row++) {
            for (int col = colS; col <= maxCol; col++) {
                numOfGold += grid[row][col];
            }
        }

        return numOfGold;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int maxGold = 0;

        for (int row = 0; row < n; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < n; col++) {
                grid[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row + 2 >= n || col + 2 >= n) {
                    continue;
                }

                int numOfGold = getNumOfGold(row, col, row + 2, col + 2);
                maxGold = Math.max(maxGold, numOfGold);
            }
        }

        System.out.println(maxGold);
    }
}