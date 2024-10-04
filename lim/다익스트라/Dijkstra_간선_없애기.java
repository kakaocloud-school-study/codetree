package lim.다익스트라;

import java.util.*;
import java.io.*;

public class Dijkstra_간선_없애기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] dists;
    static ArrayList<HashSet<Integer>> path = new ArrayList<>();
    static ArrayList<ArrayList<Item>> graph = new ArrayList<>();

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
            path.add(new HashSet<>());
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
            for (Item cost : graph.get(item.node)) {
                int nNode = cost.node;
                int nDist = item.dist + cost.dist;
                if (dists[nNode] < nDist) {
                    continue;
                }
                if (dists[nNode] > nDist) {
                    path.get(nNode).clear();
                }
                path.get(nNode).add(item.node);
                dists[nNode] = nDist;
                queue.offer(new Item(nNode, dists[nNode]));
            }
        }
    }

    static void sol() throws IOException {
        dijkstra(1);
        int answer = 0;
        int node = n;
        while (node > 1) {
            if (path.get(node).size() > 1) {
                break;
            }
            node = path.get(node).iterator().next();
            answer++;
        }

        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dists = new int[n + 1];

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