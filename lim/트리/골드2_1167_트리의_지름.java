package lim.트리;

import java.util.*;
import java.io.*;

public class 골드2_1167_트리의_지름 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static ArrayList<ArrayList<Item>> graph = new ArrayList<>();

    static class Item implements Comparable<Item> {
        int node, dist;

        public Item(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Item o) {
            return this.dist - o.dist;
        }
    }

    static void dijkstra(int sNode, int[] dists) {
        for (int i = 0; i < dists.length; i++) {
            dists[i] = Integer.MAX_VALUE;
        }
        dists[sNode] = 0;
        PriorityQueue<Item> queue = new PriorityQueue<>();
        queue.offer(new Item(sNode, dists[sNode]));

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (item.dist > dists[item.node]) {
                continue;
            }

            for (Item edge : graph.get(item.node)) {
                int nDist = item.dist + edge.dist;
                if (nDist >= dists[edge.node]) {
                    continue;
                }
                dists[edge.node] = nDist;
                queue.add(new Item(edge.node, nDist));
            }
        }
    }

    static void sol() throws IOException {
        int[] dists = new int[n + 1];
        dijkstra(1, dists);

        int maxDist = 0;
        int maxDistNode = 1;
        for (int node = 1; node < dists.length; node++) {
            if (dists[node] > maxDist) {
                maxDist = dists[node];
                maxDistNode = node;
            }
        }

        dijkstra(maxDistNode, dists);

        maxDist = 0;
        for (int node = 1; node < dists.length; node++) {
            maxDist = Math.max(maxDist, dists[node]);
        }

        bw.write(maxDist + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            while (e != -1) {
                int dist = Integer.parseInt(st.nextToken());
                graph.get(s).add(new Item(e, dist));
                graph.get(e).add(new Item(s, dist));

                e = Integer.parseInt(st.nextToken());
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
