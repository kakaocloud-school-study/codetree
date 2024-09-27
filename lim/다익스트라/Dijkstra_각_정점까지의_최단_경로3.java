package lim.다익스트라;

import java.util.*;
import java.io.*;

public class Dijkstra_각_정점까지의_최단_경로3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] dists;
    static int[][] grid;

    static void dijkstra(int sNode) {
        HashSet<Integer> visited = new HashSet<>();
        dists[sNode] = 0;
        for (int unused = 0; unused < n; unused++) {
            int selectedNode = -1;
            for (int node = 0; node < dists.length; node++) {
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

            for (int nNode = 0; nNode < dists.length; nNode++) {
                if (grid[selectedNode][nNode] == 0) {
                    continue;
                }
                dists[nNode] = Math.min(dists[nNode], dists[selectedNode] + grid[selectedNode][nNode]);
            }
        }
    }

    static void sol() throws IOException {
        dijkstra(0);
        for (int i = 1; i < dists.length; i++) {
            if (dists[i] == Integer.MAX_VALUE) {
                bw.write("-1\n");
                continue;
            }
            bw.write(dists[i] + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dists = new int[n];
        for (int i = 0; i < dists.length; i++) {
            dists[i] = Integer.MAX_VALUE;
        }
        grid = new int[n][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            grid[s][e] = cost;
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}