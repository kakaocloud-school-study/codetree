package lim.미분류;

import java.util.*;
import java.io.*;

public class 실버4_1018_체스판_다시_칠하기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] grid;

    static int getMinFlips(int startValue, int sR, int sC) {
        int value = startValue;
        int flipCount = 0;
        for (int i = sR; i < sR + 8; i++) {
            for (int j = sC; j < sC + 8; j++) {
                if (grid[i][j] != value) {
                    flipCount++;
                }
                value ^= 1;
            }
            value ^= 1;
        }
        return flipCount;
    }

    static void sol() throws IOException {
        int minCount = 8 * 8;
        for (int i = 0; i + 7 < grid.length; i++) {
            for (int j = 0; j + 7 < grid[0].length; j++) {
                minCount = Math.min(minCount, getMinFlips(0, i, j));
                minCount = Math.min(minCount, getMinFlips(1, i, j));
            }
        }
        bw.write(minCount + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        for (int i = 0; i < grid.length; i++) {
            String line = br.readLine();
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = line.charAt(j) == 'W' ? 0 : 1;
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
