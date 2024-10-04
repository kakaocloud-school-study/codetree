package lim.다익스트라;

import java.util.*;
import java.io.*;

public class Dijkstra_가장_긴_왕복_거리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, x;
    static ArrayList<ArrayList<Item>> inGraph = new ArrayList<>();
    static ArrayList<ArrayList<Item>> outGraph = new ArrayList<>();

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

    static void dijkstra(int sNode, int[] dists, ArrayList<ArrayList<Item>> graph) {
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

    static void initDists(int[] dists) {
        for (int i = 0; i < dists.length; i++) {
            dists[i] = Integer.MAX_VALUE;
        }
    }

    static void sol() throws IOException {
        int[] inDists = new int[n + 1];
        initDists(inDists);
        dijkstra(x, inDists, inGraph);
        int[] outDists = new int[n + 1];
        initDists(outDists);
        dijkstra(x, outDists, outGraph);

        int answer = 0;
        for (int node = 1; node < n + 1; node++) {
            if (inDists[node] == Integer.MAX_VALUE || outDists[node] == Integer.MAX_VALUE) {
                continue;
            }

            answer = Math.max(answer, inDists[node] + outDists[node]);
        }

        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            inGraph.add(new ArrayList<>());
            outGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            outGraph.get(s).add(new Item(e, cost));
            inGraph.get(e).add(new Item(s, cost));
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}