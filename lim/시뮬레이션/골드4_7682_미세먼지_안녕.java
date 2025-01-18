package lim.시뮬레이션;

import java.util.*;
import java.io.*;

public class 골드4_7682_미세먼지_안녕 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] grid;
    static int[] drs = { 0, -1, 0, 1 };
    static int[] dcs = { 1, 0, -1, 0 };
    static int upperR, lowerR, time;

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length;
    }

    static void spread(int r, int c, int[][] newGrid) {
        int subunit = grid[r][c] / 5;
        newGrid[r][c] += grid[r][c];
        for (int dir = 0; dir < drs.length; dir++) {
            int nR = r + drs[dir];
            int nC = c + dcs[dir];
            if (!inRange(nR, nC) || grid[nR][nC] == -1) {
                continue;
            }
            newGrid[nR][nC] += subunit;
            newGrid[r][c] -= subunit;
        }
    }

    static void spread() {
        int[][] newGrid = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1) {
                    newGrid[i][j] = grid[i][j];
                    continue;
                }
                spread(i, j, newGrid);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = newGrid[i][j];
            }
        }
    }

    static void rotate(int rotatation) {
        LinkedList<Integer> queue = new LinkedList<>();
        int dir = 0;
        int r = upperR + drs[dir], c = dcs[dir];
        if (rotatation == -1) {
            r++;
        }
        while (grid[r][c] != -1) {
            queue.offer(grid[r][c]);
            int nR = r + drs[dir];
            int nC = c + dcs[dir];
            if (!inRange(nR, nC)) {
                dir = (dir + 4 + rotatation) % drs.length;
                nR = r + drs[dir];
                nC = c + dcs[dir];
            }
            r = nR;
            c = nC;
        }

        queue.pollLast();
        queue.offerFirst(0);
        dir = 0;
        r = upperR + drs[dir];
        c = dcs[dir];
        if (rotatation == -1) {
            r++;
        }
        while (grid[r][c] != -1) {
            grid[r][c] = queue.poll();
            int nR = r + drs[dir];
            int nC = c + dcs[dir];
            if (!inRange(nR, nC)) {
                dir = (dir + 4 + rotatation) % drs.length;
                nR = r + drs[dir];
                nC = c + dcs[dir];
            }
            r = nR;
            c = nC;
        }
    }

    static void sol() throws IOException {
        while (time-- > 0) {
            spread();
            rotate(1);
            rotate(-1);
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1) {
                    continue;
                }
                count += grid[i][j];
            }
        }
        bw.write(count + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        for (int i = 0; i < grid.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == -1) {
                upperR = i;
                lowerR = i + 1;
                break;
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
