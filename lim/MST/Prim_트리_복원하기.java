package lim.MST;

import java.util.*;
import java.io.*;

public class Prim_트리_복원하기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] dists, parents;
    static int[][] grid;
    static ArrayList<Edge> edges = new ArrayList<>();

    static class Edge {
        int node1, node2, cost;

        Edge(int node1, int node2, int cost) {
            if (node1 > node2) {
                int tmp = node1;
                node1 = node2;
                node2 = tmp;
            }
            this.node1 = node1;
            this.node2 = node2;
            this.cost = cost;
        }
    }

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
            if (parents[minCostNode] > 0) {
                edges.add(new Edge(minCostNode, parents[minCostNode], dists[minCostNode]));
            }

            for (int i = 1; i < visited.length; i++) {
                if (grid[minCostNode][i] == 0) {
                    continue;
                }

                if (dists[i] > grid[minCostNode][i] && !visited[i]) {
                    dists[i] = grid[minCostNode][i];
                    parents[i] = minCostNode;
                }
            }
        }
        return totalCost;
    }

    static void sol() throws IOException {
        prim(1);
        edges.sort((e1, e2) -> {
            if (e1.node1 == e2.node1) {
                return e1.node2 - e2.node2;
            }
            return e1.node1 - e2.node1;
        });
        for (Edge e : edges) {
            bw.write(e.node1 + " " + e.node2 + " " + e.cost + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        dists = new int[n + 1];
        parents = new int[n + 1];
        grid = new int[n + 1][n + 1];

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