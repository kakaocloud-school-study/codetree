package lim.그리디;

import java.util.*;
import java.io.*;

public class 상태_반전이_가능한_문제_0과_1로_이루어진_격자 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] drs = { 1, 0, -1, 0 }, dcs = { 0, 1, 0, -1 };
    static int[][] grid;

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length;
    }

    static void flip(int r, int c) {
        for (int i = 0; i <= r; i++) {
            for (int j = 0; j <= c; j++) {
                grid[i][j] ^= 1;
            }
        }
    }

    static void sol() throws IOException {
        int flipCount = 0;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    flip(i, j);
                    flipCount++;
                }
            }
        }
        bw.write(flipCount + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        for (int i = 0; i < grid.length; i++) {
            String[] nums = br.readLine().split("");
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = Integer.parseInt(nums[j]);
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}