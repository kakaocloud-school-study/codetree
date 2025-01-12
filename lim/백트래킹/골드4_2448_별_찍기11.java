package lim.백트래킹;

import java.util.*;
import java.io.*;

public class 골드4_2448_별_찍기11 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] grid;

    static void func(int size, int sR, int sC) {
        if (size == 3) {
            grid[sR][sC] = ' ';
            grid[sR][sC + 1] = ' ';
            grid[sR][sC + 2] = '*';
            grid[sR][sC + 3] = ' ';
            grid[sR][sC + 4] = ' ';

            grid[sR + 1][sC] = ' ';
            grid[sR + 1][sC + 1] = '*';
            grid[sR + 1][sC + 2] = ' ';
            grid[sR + 1][sC + 3] = '*';
            grid[sR + 1][sC + 4] = ' ';

            grid[sR + 2][sC] = '*';
            grid[sR + 2][sC + 1] = '*';
            grid[sR + 2][sC + 2] = '*';
            grid[sR + 2][sC + 3] = '*';
            grid[sR + 2][sC + 4] = '*';
            return;
        }

        func(size / 2, sR, sC + size / 2);
        func(size / 2, sR + size / 2, sC);
        func(size / 2, sR + size / 2, sC + size);
    }

    static void sol() throws IOException {
        func(grid.length, 0, 0);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                bw.write(grid[i][j]);
            }
            bw.write("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        grid = new char[n][2 * n - 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = ' ';
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
