package lim.누적합;

import java.util.*;
import java.io.*;

public class Prefix_Sum_구간에_속한_문자의_개수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, k;
    static int[][][] grid, presumGrid;
    static int[][] queries;
    static String[] words;

    static void sol() throws IOException {
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                for (int ch = 0; ch < grid[0][0].length; ch++) {
                    presumGrid[i][j][ch] = presumGrid[i][j - 1][ch] + grid[i][j][ch];
                }
            }
        }
        for (int j = 1; j < grid[0].length; j++) {
            for (int i = 1; i < grid.length; i++) {
                for (int ch = 0; ch < grid[0][0].length; ch++) {
                    presumGrid[i][j][ch] += presumGrid[i - 1][j][ch];
                }
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int r1 = queries[i][0];
            int c1 = queries[i][1];
            int r2 = queries[i][2];
            int c2 = queries[i][3];
            for (int ch = 0; ch < 3; ch++) {
                int count = 0;
                count += presumGrid[r2][c2][ch];
                count -= presumGrid[r1 - 1][c2][ch];
                count -= presumGrid[r2][c1 - 1][ch];
                count += presumGrid[r1 - 1][c1 - 1][ch];

                bw.write(count + " ");
            }
            bw.write("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        words = new String[n];
        grid = new int[n + 1][m + 1][3];
        presumGrid = new int[n + 1][m + 1][3];
        queries = new int[k][4];
        for (int i = 1; i < grid.length; i++) {
            String word = br.readLine();
            for (int j = 1; j < grid[0].length; j++) {
                char ch = word.charAt(j - 1);
                grid[i][j][ch - 'a'] = 1;
            }
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken());
            queries[i][2] = Integer.parseInt(st.nextToken());
            queries[i][3] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
