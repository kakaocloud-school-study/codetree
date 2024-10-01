package lim.다익스트라;

import java.util.*;
import java.io.*;

public class Dijkstra_빽_투더_블랙_닷2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, aNode, bNode;
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
        int[] aDists = new int[n + 1];
        initDists(aDists);
        dijkstra(aNode, aDists);
        int[] bDists = new int[n + 1];
        initDists(bDists);
        dijkstra(bNode, bDists);

        int answer = Integer.MAX_VALUE;
        for (int node = 1; node < n + 1; node++) {
            if (node == aNode || node == bNode) {
                continue;
            }
            if (aDists[node] == Integer.MAX_VALUE || bDists[node] == Integer.MAX_VALUE
                    || aDists[bNode] == Integer.MAX_VALUE) {
                continue;
            }

            answer = Math.min(answer, aDists[bNode] + aDists[node] + bDists[node]);
        }
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }

        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        aNode = Integer.parseInt(st.nextToken());
        bNode = Integer.parseInt(st.nextToken());

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