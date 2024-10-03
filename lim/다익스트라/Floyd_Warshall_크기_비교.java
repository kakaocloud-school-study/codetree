package lim.다익스트라;

import java.util.*;
import java.io.*;

public class Floyd_Warshall_크기_비교 {
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
            int count = 0;
            for (int j = 1; j < grid.length; j++) {
                if (grid[i][j] == 0 && grid[j][i] == 0) {
                    count++;
                }
            }
            bw.write(count + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n + 1][n + 1];
        for (int i = 1; i < grid.length; i++) {
            grid[i][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            grid[s][e] = 1;
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}