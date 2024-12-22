package lim.백트래킹;

import java.util.*;
import java.io.*;

public class 실버2_2630_색종이_만들기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] grid;

    static void plus(int[] target, int[] diff) {
        target[0] += diff[0];
        target[1] += diff[1];
    }

    static int[] func(int r, int c, int len) {
        int[] counts = new int[2];
        if (len == 1) {
            counts[grid[r][c]] = 1;
            return counts;
        }

        plus(counts, func(r, c, len / 2));
        plus(counts, func(r + len / 2, c, len / 2));
        plus(counts, func(r, c + len / 2, len / 2));
        plus(counts, func(r + len / 2, c + len / 2, len / 2));

        if (counts[0] == 0) {
            counts[1] = 1;
        } else if (counts[1] == 0) {
            counts[0] = 1;
        }

        return counts;
    }

    static void sol() throws IOException {
        int[] counts = func(0, 0, n);
        bw.write(counts[0] + "\n");
        bw.write(counts[1] + "\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
