package lim.다익스트라;

import java.util.*;
import java.io.*;

public class Dijkstra_가장_오래_걸리는_학생2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] dists;
    static HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();

    static class Item implements Comparable<Item> {
        int node, dist;

        public Item(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Item item) {
            return this.dist - item.dist;
        }
    }

    static void dijkstra(int sNode) {
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
            for (Map.Entry<Integer, Integer> e : graph.get(item.node).entrySet()) {
                int nNode = e.getKey();
                int cost = e.getValue();
                if (dists[nNode] <= item.dist + cost) {
                    continue;
                }
                dists[nNode] = item.dist + cost;
                queue.offer(new Item(nNode, dists[nNode]));
            }
        }
    }

    static void sol() throws IOException {
        dijkstra(n - 1);
        int maxDist = 0;
        for (int i = 0; i < dists.length; i++) {
            if (dists[i] == Integer.MAX_VALUE) {
                continue;
            }
            maxDist = Math.max(maxDist, dists[i]);
        }
        bw.write(maxDist + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dists = new int[n];
        for (int i = 0; i < dists.length; i++) {
            dists[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            HashMap<Integer, Integer> costByNode = graph.getOrDefault(e, new HashMap<>());
            costByNode.put(s, cost);
            graph.put(e, costByNode);
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}