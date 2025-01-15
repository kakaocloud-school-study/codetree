package lim.다익스트라;

import java.util.*;
import java.io.*;

public class 골드4_12851_숨바꼭질2 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int aNode, bNode;
    static int[] dists, dp;

    static class Cost implements Comparable<Cost> {
        int node, dist;

        public Cost(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Cost cost) {
            return this.dist - cost.dist;
        }
    }

    static void initDists() {
        for (int i = 0; i < dists.length; i++) {
            dists[i] = Integer.MAX_VALUE;
        }
    }

    static void dijkstra(int sNode) {
        PriorityQueue<Cost> queue = new PriorityQueue<>();
        queue.offer(new Cost(sNode, 0));
        dists[sNode] = 0;
        dp[sNode] = 1;

        while (!queue.isEmpty()) {
            Cost curr = queue.poll();
            if (curr.dist > dists[curr.node]) {
                continue;
            }

            for (int nextNode : List.of(curr.node - 1, curr.node + 1, curr.node * 2)) {
                if (nextNode < 0 || dists.length <= nextNode) {
                    continue;
                }
                int nDist = curr.dist + 1;
                if (nDist > dists[nextNode]) {
                    continue;
                } else if (nDist == dists[nextNode]) {
                    dp[nextNode] += dp[curr.node];
                    continue;
                }
                dists[nextNode] = nDist;
                dp[nextNode] = dp[curr.node];
                queue.offer(new Cost(nextNode, nDist));
            }
        }
    }

    static void sol() throws IOException {
        initDists();
        dijkstra(aNode);
        bw.write(dists[bNode] + "\n");
        bw.write(dp[bNode] + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        aNode = Integer.parseInt(st.nextToken());
        bNode = Integer.parseInt(st.nextToken());
        dists = new int[200_000];
        dp = new int[200_000];
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}