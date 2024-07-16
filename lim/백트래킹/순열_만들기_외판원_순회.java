package lim.백트래킹;

import java.util.*;
import java.io.*;

public class 순열_만들기_외판원_순회 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashSet<Integer> selected = new HashSet<>();
    static int[][] grid;
    static int minCost = Integer.MAX_VALUE;

    static void func(int currStop, int m, int currCost) throws IOException {
        if (m == 0) {
            if (grid[currStop][0] != 0) {
                minCost = Math.min(minCost, currCost + grid[currStop][0]);
            }
            return;
        }

        for (int j = 0; j < grid.length; j++) {
            if (selected.contains(j) || grid[currStop][j] == 0) {
                continue;
            }
            selected.add(j);
            func(j, m - 1, currCost + grid[currStop][j]);
            selected.remove(j);
        }
    }

    static void sol(int n) throws IOException {
        selected.add(0);
        func(0, n - 1, 0);
        bw.write(String.valueOf(minCost));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol(n);
        br.close();
    }
}
