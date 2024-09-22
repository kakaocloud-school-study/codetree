package lim.누적합;

import java.util.*;
import java.io.*;

public class Prefix_Sum_정수_n개의_합3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, k;
    static int[][] grid, presumGrid;

    static void sol() throws IOException {
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid.length; j++) {
                presumGrid[i][j] = presumGrid[i][j - 1] + grid[i][j];
            }
        }
        for (int j = 1; j < grid.length; j++) {
            for (int i = 1; i < grid.length; i++) {
                presumGrid[i][j] += presumGrid[i - 1][j];
            }
        }

        int valueMax = 0;
        for (int i = 1; i + k - 1 < grid.length; i++) {
            for (int j = 1; j + k - 1 < grid.length; j++) {
                int valueSum = 0;
                valueSum += presumGrid[i + k - 1][j + k - 1];
                valueSum -= presumGrid[i - 1][j + k - 1];
                valueSum -= presumGrid[i + k - 1][j - 1];
                valueSum += presumGrid[i - 1][j - 1];
                valueMax = Math.max(valueMax, valueSum);
            }
        }
        bw.write(valueMax + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new int[n + 1][n + 1];
        presumGrid = new int[n + 1][n + 1];
        for (int i = 1; i < grid.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < grid.length; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
