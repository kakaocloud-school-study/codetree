package lim.그리디;

import java.util.*;
import java.io.*;

public class 상태_반전이_가능한_문제_상하좌우_반전시키기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] drs = { 1, 0, -1, 0 }, dcs = { 0, 1, 0, -1 };
    static int[][] grid;

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length;
    }

    static void flip(int r, int c) {
        grid[r][c] ^= 1;
        for (int i = 0; i < drs.length; i++) {
            int nr = r + drs[i];
            int nc = c + dcs[i];
            if (!inRange(nr, nc)) {
                continue;
            }
            grid[nr][nc] ^= 1;
        }
    }

    static void sol() throws IOException {
        int flipCount = 0;
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i - 1][j] == 0) {
                    flip(i, j);
                    flipCount++;
                }
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[grid.length - 1][i] == 0) {
                bw.write("-1");
                return;
            }
        }
        bw.write(flipCount + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
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