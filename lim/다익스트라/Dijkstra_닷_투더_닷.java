package lim.다익스트라;

import java.util.*;
import java.io.*;

public class Dijkstra_닷_투더_닷 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, x;
    static ArrayList<ArrayList<Cost>> graph = new ArrayList<>();
    static HashSet<Integer> cValues = new HashSet<>();

    static class Cost {
        int dest, l, c;

        Cost(int dest, int l, int c) {
            this.dest = dest;
            this.l = l;
            this.c = c;
        }
    }

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

    static void dijkstra(int sNode, int lowerBoundC, int[] dists) {
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
            for (Cost cost : graph.get(item.node)) {
                int nNode = cost.dest;
                int nDist = item.dist + cost.l;
                if (dists[nNode] <= nDist || cost.c < lowerBoundC) {
                    continue;
                }
                dists[nNode] = nDist;
                queue.offer(new Item(nNode, dists[nNode]));
            }
        }
    }

    static int getMinTime(int lowerBoundC) {
        int[] dists = new int[n + 1];
        for (int i = 0; i < dists.length; i++) {
            dists[i] = Integer.MAX_VALUE;
        }
        dijkstra(1, lowerBoundC, dists);
        if (dists[n] == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return dists[n] + x / lowerBoundC;
    }

    static void sol() throws IOException {
        int minTime = Integer.MAX_VALUE;
        for (int cValue : cValues) {
            minTime = Math.min(minTime, getMinTime(cValue));
        }
        bw.write(minTime + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Cost(e, l, c));
            graph.get(e).add(new Cost(s, l, c));
            cValues.add(c);
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}