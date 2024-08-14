package lim.미분류;

import java.util.*;
import java.io.*;

public class 지름길_실버1_1446 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, d;
    static final int MAX_POS = 10_000;
    static int[] dists;
    static ArrayList<HashMap<Integer, Integer>> graph = new ArrayList<>();

    static class Item {
        int node, dist;

        Item(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    static void dijkstra() {
        for (int i = 0; i < dists.length; i++) {
            dists[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Item> queue = new PriorityQueue<>((it1, it2) -> it1.dist - it2.dist);
        queue.offer(new Item(0, 0));
        dists[0] = 0;

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (item.dist > dists[item.node]) {
                continue;
            }
            for (Map.Entry<Integer, Integer> e : graph.get(item.node).entrySet()) {
                int nextNode = e.getKey();
                int cost = e.getValue();
                if (item.dist + cost > dists[nextNode]) {
                    continue;
                }
                dists[nextNode] = item.dist + cost;
                queue.add(new Item(nextNode, dists[nextNode]));
            }
        }
    }

    static void sol() throws IOException {
        dijkstra();
        bw.write(dists[d] + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        dists = new int[MAX_POS + 1];

        for (int i = 0; i < MAX_POS; i++) {
            graph.add(new HashMap<>());
        }

        ArrayList<Integer> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            int oldCost = graph.get(s).getOrDefault(e, cost);
            graph.get(s).put(e, Math.min(oldCost, cost));
            nodes.add(s);
            nodes.add(e);
        }

        nodes.add(0);
        nodes.add(d);
        nodes.sort(Comparator.naturalOrder());
        int prev = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            int node = nodes.get(i);
            if (node == prev) {
                continue;
            }

            int oldCost = graph.get(prev).getOrDefault(node, node - prev);
            graph.get(prev).put(node, Math.min(oldCost, node - prev));
            prev = node;
        }

        sol();

        bw.flush();
        bw.close();
        br.close();
    }
}