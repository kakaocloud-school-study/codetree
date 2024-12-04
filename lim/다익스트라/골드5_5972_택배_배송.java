package lim.다익스트라;

import java.util.*;
import java.io.*;

public class 골드5_5972_택배_배송 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<ArrayList<Item>> graph = new ArrayList<>();

    static class Item implements Comparable<Item> {
        int dest, cost;

        Item(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Item o) {
            return this.cost - o.cost;
        }
    }

    static int dijkstra(int sNode) {
        int[] dists = new int[graph.size()];
        for (int i = 0; i < dists.length; i++) {
            dists[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Item> queue = new PriorityQueue<>();
        queue.add(new Item(sNode, 0));
        dists[sNode] = 0;

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (item.cost > dists[item.dest]) {
                continue;
            }

            for (Item nItem : graph.get(item.dest)) {
                int nNode = nItem.dest;
                int nCost = nItem.cost + item.cost;
                if (dists[nNode] <= nCost) {
                    continue;
                }
                dists[nNode] = nCost;
                queue.offer(new Item(nNode, nCost));
            }
        }
        return dists[dists.length - 1];
    }

    static void sol() throws IOException {
        bw.write(dijkstra(1) + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Item(e, cost));
            graph.get(e).add(new Item(s, cost));
        }

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
