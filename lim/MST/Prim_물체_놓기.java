package lim.MST;

import java.util.*;
import java.io.*;

public class Prim_물체_놓기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] dists;
    static int[][] grid;

    static int prim(int sNode) {
        for (int i = 0; i < dists.length; i++) {
            dists[i] = Integer.MAX_VALUE;
        }

        boolean[] visited = new boolean[n + 1];
        dists[sNode] = 0;
        int totalCost = 0;

        for (int unused = 0; unused < n + 1; unused++) {
            int minCostNode = -1;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    continue;
                }
                if (minCostNode == -1 || dists[minCostNode] > dists[i]) {
                    minCostNode = i;
                }
            }
            visited[minCostNode] = true;
            totalCost += dists[minCostNode];

            for (int i = 1; i < visited.length; i++) {
                if (grid[minCostNode][i] == 0) {
                    continue;
                }

                if (dists[i] > grid[minCostNode][i]) {
                    dists[i] = grid[minCostNode][i];
                }
            }
        }
        return totalCost;
    }

    static void sol() throws IOException {
        int answer = prim(0);
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        dists = new int[n + 1];
        grid = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            grid[0][i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sol();

        bw.flush();
        bw.close();
        br.close();
    }
}