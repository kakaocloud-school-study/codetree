package lim.다익스트라;

import java.util.*;
import java.io.*;

public class Dijkstra_가장_가까운_거리의_최댓값 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, aNode, bNode, cNode;
    static int[][] distsFrom;
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

    static void dijkstra(int sNode, int[] dists) {
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
        dijkstra(aNode, distsFrom[0]);
        dijkstra(bNode, distsFrom[1]);
        dijkstra(cNode, distsFrom[2]);
        int maxMinDist = 0;
        for (int i = 1; i < distsFrom[0].length; i++) {
            int minDist = Integer.MAX_VALUE;
            minDist = Math.min(minDist, distsFrom[0][i]);
            minDist = Math.min(minDist, distsFrom[1][i]);
            minDist = Math.min(minDist, distsFrom[2][i]);

            maxMinDist = Math.max(maxMinDist, minDist);
        }
        bw.write(maxMinDist + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        distsFrom = new int[3][n + 1];
        for (int i = 0; i < distsFrom[0].length; i++) {
            distsFrom[0][i] = Integer.MAX_VALUE;
            distsFrom[1][i] = Integer.MAX_VALUE;
            distsFrom[2][i] = Integer.MAX_VALUE;
        }
        st = new StringTokenizer(br.readLine());
        aNode = Integer.parseInt(st.nextToken());
        bNode = Integer.parseInt(st.nextToken());
        cNode = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            HashMap<Integer, Integer> costByNode = graph.getOrDefault(s, new HashMap<>());
            int oldCost = costByNode.getOrDefault(e, cost);
            costByNode.put(e, Math.min(oldCost, cost));
            graph.put(s, costByNode);

            costByNode = graph.getOrDefault(e, new HashMap<>());
            oldCost = costByNode.getOrDefault(s, cost);
            costByNode.put(s, Math.min(oldCost, cost));
            graph.put(e, costByNode);
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}