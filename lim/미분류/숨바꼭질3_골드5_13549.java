package lim.미분류;

import java.util.*;
import java.io.*;

public class 숨바꼭질3_골드5_13549 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int src, dest;
    static int[] dists;

    static class Item {
        int node, dist;

        Item(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    static void dijkstra() {
        PriorityQueue<Item> queue = new PriorityQueue<>((it1, it2) -> it1.dist - it2.dist);
        queue.offer(new Item(src, 0));
        dists[src] = 0;

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (item.dist > dists[item.node]) {
                continue;
            }

            int nextNode = item.node;
            while (nextNode < dists.length) {
                if (dists[nextNode] > dists[item.node]) {
                    dists[nextNode] = dists[item.node];
                    queue.offer(new Item(nextNode, dists[nextNode]));
                }
                if (nextNode + 1 < dists.length && dists[nextNode + 1] > dists[item.node] + 1) {
                    dists[nextNode + 1] = dists[item.node] + 1;
                    queue.offer(new Item(nextNode + 1, dists[nextNode + 1]));
                }
                if (nextNode - 1 >= 0 && dists[nextNode - 1] > dists[item.node] + 1) {
                    dists[nextNode - 1] = dists[item.node] + 1;
                    queue.offer(new Item(nextNode - 1, dists[nextNode - 1]));
                }
                if (nextNode == 0) {
                    break;
                }
                nextNode <<= 1;
            }
        }
    }

    static void sol() throws IOException {
        dijkstra();
        bw.write(dists[dest] + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        src = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());

        dists = new int[100_001];

        for (int i = 0; i < dists.length; i++) {
            dists[i] = Integer.MAX_VALUE;
        }

        sol();

        bw.flush();
        bw.close();
        br.close();
    }
}