package lim.시뮬레이션;

import java.io.*;
import java.util.*;

public class 소프티어_lv2_7374_진정한_효도 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] grid;
    static int[] drs = { 1, 0 };
    static int[] dcs = { 0, 1 };

    static int calCost(int r, int c, int dir) {
        int[] arr = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            int nR = r + drs[dir] * i;
            int nC = c + dcs[dir] * i;
            arr[i] = grid[nR][nC];
        }
        Arrays.sort(arr);
        return arr[1] - arr[0] + arr[2] - arr[1];
    }

    static void sol() throws IOException {
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            minCost = Math.min(calCost(0, i, 0), minCost);
            minCost = Math.min(calCost(i, 0, 1), minCost);
        }
        bw.write(minCost + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        grid = new int[3][3];
        for (int i = 0; i < grid.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
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
