package lim.다익스트라;

import java.util.*;
import java.io.*;

public class Floyd_Warshall_행렬로_주어진_간선 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[][] grid;

    static void fw() {
        for (int k = 1; k < grid.length; k++) {
            for (int i = 1; i < grid.length; i++) {
                for (int j = 1; j < grid[0].length; j++) {
                    grid[i][j] = grid[i][j] | (grid[i][k] & grid[k][j]);
                }
            }
        }
    }

    static void sol() throws IOException {
        fw();
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid.length; j++) {
                bw.write(grid[i][j] + " ");
            }
            bw.write("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        grid = new int[n + 1][n + 1];
        for (int i = 1; i < grid.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (i == j) {
                    grid[i][j] = 1;
                }
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}