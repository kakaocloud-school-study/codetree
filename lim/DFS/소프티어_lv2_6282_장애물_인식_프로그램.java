package lim.DFS;

import java.io.*;
import java.util.*;

public class 소프티어_lv2_6282_장애물_인식_프로그램 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] grid;
    static int[] drs = { 1, 0, -1, 0 };
    static int[] dcs = { 0, 1, 0, -1 };

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length;
    }

    static int dfs(int r, int c, boolean[][] visited) {
        int count = 1;
        for (int dir = 0; dir < drs.length; dir++) {
            int nR = r + drs[dir];
            int nC = c + dcs[dir];
            if (!inRange(nR, nC) || visited[nR][nC] || grid[nR][nC] == 0) {
                continue;
            }
            visited[nR][nC] = true;
            count += dfs(nR, nC, visited);
        }
        return count;
    }

    static void sol() throws IOException {
        ArrayList<Integer> counts = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] || grid[i][j] == 0) {
                    continue;
                }
                visited[i][j] = true;
                counts.add(dfs(i, j, visited));
            }
        }
        Collections.sort(counts);
        bw.write(counts.size() + "\n");
        for (int count : counts) {
            bw.write(count + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        for (int i = 0; i < grid.length; i++) {
            String line = br.readLine();
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
