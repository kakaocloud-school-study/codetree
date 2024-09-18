package lim.전처리;

import java.util.*;
import java.io.*;

public class 전처리_균일하게_나누기2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static final int MAX_VALUE = 1000;
    static int[][] grid, yPresumByX;

    static void sol() throws IOException {
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                yPresumByX[i][j] = yPresumByX[i][j - 1] + grid[i][j];
            }
        }

        int minM = Integer.MAX_VALUE;
        for (int j = 2; j < grid[0].length; j += 2) {
            int downL = 0, downR = 0;
            for (int i = 2; i < grid.length; i += 2) {
                downL += yPresumByX[i - 1][j];
                downR += yPresumByX[i - 1][MAX_VALUE] - yPresumByX[i - 1][j];
            }

            int upL = 0, upR = 0;
            for (int i = 2; i < grid.length; i += 2) {
                downL -= yPresumByX[i - 1][j];
                downR -= yPresumByX[i - 1][MAX_VALUE] - yPresumByX[i - 1][j];
                upL += yPresumByX[i - 1][j];
                upR += yPresumByX[i - 1][MAX_VALUE] - yPresumByX[i - 1][j];

                int m = Math.max(upL, upR);
                m = Math.max(m, downR);
                m = Math.max(m, downL);

                minM = Math.min(minM, m);
            }
        }
        bw.write(minM + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        grid = new int[MAX_VALUE + 1][MAX_VALUE + 1];
        yPresumByX = new int[MAX_VALUE + 1][MAX_VALUE + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            grid[x][y]++;
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
