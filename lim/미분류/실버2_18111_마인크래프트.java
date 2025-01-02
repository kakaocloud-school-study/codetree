package lim.미분류;

import java.util.*;
import java.io.*;

public class 실버2_18111_마인크래프트 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int blockLimit;
    static int[][] grid;

    static int cal(int goal) {
        int totalCost = 0;
        int blockCount = blockLimit;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > goal) {
                    totalCost += (grid[i][j] - goal) * 2;
                    blockCount += grid[i][j] - goal;
                } else if (grid[i][j] < goal) {
                    totalCost += goal - grid[i][j];
                    blockCount -= goal - grid[i][j];
                }
            }
        }

        if (blockCount < 0) {
            return Integer.MAX_VALUE;
        }
        return totalCost;
    }

    static void sol() throws IOException {
        int minCost = Integer.MAX_VALUE;
        int height = 0;
        for (int i = 256; i >= 0; i--) {
            int cost = cal(i);
            if (minCost > cost) {
                minCost = cost;
                height = i;
            }
        }
        bw.write(minCost + " " + height);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        blockLimit = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        for (int i = 0; i < grid.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
