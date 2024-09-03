package lim.미분류;

import java.util.*;
import java.io.*;

public class 파티_골드3_1238 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, dest;
    static int[] inDists, outDists;
    static ArrayList<HashMap<Integer, Integer>> outGraph = new ArrayList<>(), inGraph = new ArrayList<>();

    static class Item {
        int node, dist;

        Item(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    static void dijkstra(ArrayList<HashMap<Integer, Integer>> graph, int[] dists) {
        PriorityQueue<Item> queue = new PriorityQueue<>((it1, it2) -> it1.dist - it2.dist);
        queue.offer(new Item(dest, 0));
        dists[dest] = 0;

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (item.dist > dists[item.node]) {
                continue;
            }

            for (Map.Entry<Integer, Integer> e : graph.get(item.node).entrySet()) {
                int nextNode = e.getKey();
                int cost = e.getValue();
                if (dists[nextNode] > dists[item.node] + cost) {
                    dists[nextNode] = dists[item.node] + cost;
                    queue.offer(new Item(nextNode, dists[nextNode]));
                }
            }
        }
    }

    static void sol() throws IOException {
        dijkstra(inGraph, inDists);
        dijkstra(outGraph, outDists);

        int maxDist = Integer.MIN_VALUE;
        for (int node = 1; node < inDists.length; node++) {
            maxDist = Math.max(maxDist, inDists[node] + outDists[node]);
        }
        bw.write(maxDist + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());

        inDists = new int[n + 1];
        outDists = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            inDists[i] = Integer.MAX_VALUE;
            outDists[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n + 1; i++) {
            outGraph.add(new HashMap<>());
            inGraph.add(new HashMap<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            outGraph.get(s).put(e, cost);
            inGraph.get(e).put(s, cost);
        }

        sol();

        bw.flush();
        bw.close();
        br.close();
    }
}