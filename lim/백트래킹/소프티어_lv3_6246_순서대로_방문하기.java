package lim.백트래킹;

import java.io.*;
import java.util.*;

public class 소프티어_lv3_6246_순서대로_방문하기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] grid;
    static int[][] dests;
    static int[] drs = { 1, 0, -1, 0 };
    static int[] dcs = { 0, 1, 0, -1 };

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length;
    }

    static int func(int r, int c, int destIdx, boolean[][] visited) {
        int nDestIdx = destIdx;
        if (r == dests[destIdx][0] && c == dests[destIdx][1]) {
            nDestIdx++;
        }
        if (nDestIdx == dests.length) {
            return 1;
        }
        visited[r][c] = true;
        int count = 0;
        for (int dir = 0; dir < drs.length; dir++) {
            int nR = r + drs[dir];
            int nC = c + dcs[dir];
            if (!inRange(nR, nC) || visited[nR][nC] || grid[nR][nC] == 1) {
                continue;
            }
            count += func(nR, nC, nDestIdx, visited);
        }
        visited[r][c] = false;
        return count;
    }

    static void sol() throws IOException {
        int count = func(dests[0][0], dests[0][1], 0, new boolean[grid.length][grid[0].length]);
        bw.write(count + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        for (int i = 0; i < grid.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dests = new int[m][2];
        for (int i = 0; i < dests.length; i++) {
            st = new StringTokenizer(br.readLine());
            dests[i][0] = Integer.parseInt(st.nextToken()) - 1;
            dests[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
