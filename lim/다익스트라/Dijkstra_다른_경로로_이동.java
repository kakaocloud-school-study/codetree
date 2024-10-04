package lim.다익스트라;

import java.util.*;
import java.io.*;

public class Dijkstra_다른_경로로_이동 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] dists, path;
    static HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
    static ArrayList<HashSet<Integer>> used = new ArrayList<>();

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

    static void initDijkstra() {
        for (int i = 0; i < dists.length; i++) {
            dists[i] = Integer.MAX_VALUE;
            path[i] = Integer.MAX_VALUE;
        }
    }

    static void dijkstra(int sNode) {
        initDijkstra();
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
                if (used.get(item.node).contains(nNode)) {
                    continue;
                }
                if (dists[nNode] < item.dist + cost) {
                    continue;
                } else if (dists[nNode] == item.dist + cost && item.node > path[nNode]) {
                    continue;
                }
                dists[nNode] = item.dist + cost;
                path[nNode] = item.node;
                queue.offer(new Item(nNode, dists[nNode]));
            }
        }
    }

    static void sol() throws IOException {
        dijkstra(n);

        int node = 1;
        while (node != Integer.MAX_VALUE) {
            if (path[node] < n + 1) {
                used.get(node).add(path[node]);
                used.get(path[node]).add(node);
            }
            node = path[node];
        }

        dijkstra(n);

        if (dists[1] == Integer.MAX_VALUE) {
            bw.write("-1");
            return;
        }
        bw.write(dists[1] + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dists = new int[n + 1];
        path = new int[n + 1];
        for (int i = 0; i < dists.length; i++) {
            used.add(new HashSet<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            HashMap<Integer, Integer> costByNode = graph.getOrDefault(s, new HashMap<>());
            costByNode.put(e, cost);
            graph.put(s, costByNode);

            costByNode = graph.getOrDefault(e, new HashMap<>());
            costByNode.put(s, cost);
            graph.put(e, costByNode);
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}