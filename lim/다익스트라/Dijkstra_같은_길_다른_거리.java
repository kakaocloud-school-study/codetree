package lim.다익스트라;

import java.util.*;
import java.io.*;

public class Dijkstra_같은_길_다른_거리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] aDists, bDists, alertCounts;
    static ArrayList<ArrayList<Item>> aGraph = new ArrayList<>();
    static ArrayList<ArrayList<Item>> bGraph = new ArrayList<>();
    static ArrayList<ArrayList<Item>> graph = new ArrayList<>();

    static class Item implements Comparable<Item> {
        int node, dist, aCost = Integer.MAX_VALUE, bCost = Integer.MAX_VALUE;

        public Item(int node, int dist, int aCost, int bCost) {
            this(node, dist);
            this.aCost = aCost;
            this.bCost = bCost;
        }

        public Item(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Item item) {
            return this.dist - item.dist;
        }
    }

    static void dijkstra(int sNode, ArrayList<ArrayList<Item>> graph, int[] dists) {
        PriorityQueue<Item> queue = new PriorityQueue<>();
        queue.offer(new Item(sNode, 0));
        dists[sNode] = 0;

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (item.dist > dists[item.node]) {
                continue;
            }

            if (graph.get(item.node) == null) {
                continue;
            }
            for (Item cost : graph.get(item.node)) {
                int nNode = cost.node;
                int nDist = item.dist + cost.dist;
                if (dists[nNode] <= nDist) {
                    continue;
                }
                dists[nNode] = nDist;
                queue.offer(new Item(nNode, dists[nNode]));
            }
        }
    }

    static void dijkstra() {
        PriorityQueue<Item> queue = new PriorityQueue<>();
        queue.offer(new Item(1, 0));
        alertCounts[1] = 0;

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (item.dist > alertCounts[item.node]) {
                continue;
            }

            int aMinDist = Integer.MAX_VALUE, bMinDist = Integer.MAX_VALUE;
            for (Item cost : graph.get(item.node)) {
                aMinDist = Math.min(aMinDist, aDists[cost.node] + cost.aCost);
                bMinDist = Math.min(bMinDist, bDists[cost.node] + cost.bCost);
            }

            for (Item cost : graph.get(item.node)) {
                int nNode = cost.node;
                int aDist = aDists[nNode] + cost.aCost;
                int bDist = bDists[nNode] + cost.bCost;

                int nCount = item.dist;
                if (aDist != aMinDist) {
                    nCount++;
                }
                if (bDist != bMinDist) {
                    nCount++;
                }

                if (alertCounts[nNode] <= nCount) {
                    continue;
                }
                alertCounts[nNode] = nCount;
                queue.offer(new Item(nNode, nCount));
            }
        }
    }

    static void sol() throws IOException {
        dijkstra(n, aGraph, aDists);
        dijkstra(n, bGraph, bDists);
        dijkstra();
        bw.write(alertCounts[n] + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        aDists = new int[n + 1];
        bDists = new int[n + 1];
        alertCounts = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            aGraph.add(new ArrayList<>());
            bGraph.add(new ArrayList<>());
            graph.add(new ArrayList<>());
            aDists[i] = Integer.MAX_VALUE;
            bDists[i] = Integer.MAX_VALUE;
            alertCounts[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int aCost = Integer.parseInt(st.nextToken());
            int bCost = Integer.parseInt(st.nextToken());
            aGraph.get(e).add(new Item(s, aCost));
            bGraph.get(e).add(new Item(s, bCost));
            graph.get(s).add(new Item(e, 0, aCost, bCost));
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}