package lim.다익스트라;

import java.util.*;
import java.io.*;

public class Dijkstra_간선의_길이를_2배_늘리기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[][] grid, edges;

    static void dijkstra(int sNode, int[] dists) {
        HashSet<Integer> visited = new HashSet<>();
        dists[sNode] = 0;
        for (int unused = 0; unused < n; unused++) {
            int selectedNode = -1;
            for (int node = 1; node < dists.length; node++) {
                if (visited.contains(node)) {
                    continue;
                }
                if (selectedNode == -1 || dists[selectedNode] > dists[node]) {
                    selectedNode = node;
                }
            }
            visited.add(selectedNode);
            if (selectedNode == -1 || dists[selectedNode] == Integer.MAX_VALUE) {
                continue;
            }

            for (int nNode = 1; nNode < dists.length; nNode++) {
                if (grid[selectedNode][nNode] == 0) {
                    continue;
                }
                dists[nNode] = Math.min(dists[nNode], dists[selectedNode] + grid[selectedNode][nNode]);
            }
        }
    }

    static void initDists(int[] dists) {
        for (int i = 0; i < dists.length; i++) {
            dists[i] = Integer.MAX_VALUE;
        }
    }

    static void sol() throws IOException {
        int[] dists = new int[n + 1];
        initDists(dists);
        dijkstra(1, dists);
        int originDist = dists[n];
        int maxDist = 0;
        for (int[] edge : edges) {
            int s = edge[0];
            int e = edge[1];
            int cost = edge[2];

            initDists(dists);
            grid[s][e] = cost * 2;
            grid[e][s] = cost * 2;

            dijkstra(1, dists);
            if (dists[n] != Integer.MAX_VALUE && maxDist < dists[n]) {
                maxDist = dists[n];
            }

            grid[s][e] = cost;
            grid[e][s] = cost;
        }
        bw.write(Math.abs(maxDist - originDist) + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n + 1][n + 1];
        edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            grid[s][e] = cost;
            grid[e][s] = cost;
            edges[i][0] = s;
            edges[i][1] = e;
            edges[i][2] = cost;
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}