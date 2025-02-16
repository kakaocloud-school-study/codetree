package lim.BFS;

import java.util.*;
import java.io.*;

public class 골드4_14938_서강그라운드 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int range;
    static ArrayList<Integer> itemCountByNode = new ArrayList<>();
    static ArrayList<ArrayList<Item>> graph = new ArrayList<>();

    static class Item implements Comparable<Item> {
        int node, dist;

        Item(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Item o) {
            return this.dist - o.dist;
        }
    }

    static int bfs(int sNode) {
        int[] dists = new int[graph.size()];
        for (int i = 0; i < dists.length; i++) {
            dists[i] = Integer.MAX_VALUE;
        }

        dists[sNode] = 0;
        PriorityQueue<Item> queue = new PriorityQueue<>(List.of(new Item(sNode, 0)));
        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (dists[item.node] < item.dist) {
                continue;
            }

            for (Item nextItem : graph.get(item.node)) {
                int nextNode = nextItem.node;
                int nextDist = nextItem.dist + item.dist;
                if (nextDist > range || dists[nextNode] <= nextDist || nextDist > range) {
                    continue;
                }
                dists[nextNode] = nextDist;
                queue.offer(new Item(nextNode, nextDist));
            }
        }

        int count = 0;
        for (int node = 1; node < dists.length; node++) {
            if (dists[node] == Integer.MAX_VALUE) {
                continue;
            }
            count += itemCountByNode.get(node);
        }
        return count;
    }

    static void sol() throws IOException {
        int maxCount = 0;
        for (int node = 1; node < graph.size(); node++) {
            maxCount = Math.max(maxCount, bfs(node));
        }
        bw.write(maxCount + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        range = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        itemCountByNode.add(-1);
        for (int i = 0; i < n; i++) {
            itemCountByNode.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph.get(nodeA).add(new Item(nodeB, dist));
            graph.get(nodeB).add(new Item(nodeA, dist));
        }

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
