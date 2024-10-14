package lim.DP;

import java.util.*;
import java.io.*;

public class 플래5_1162_도로포장 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, e, kLimit;
    static long[][] dists;
    static ArrayList<ArrayList<Cost>> graph = new ArrayList<>();

    static class Cost implements Comparable<Cost> {
        int node, kCount = 0;
        long dist;

        public Cost(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }

        public Cost(int node, long dist, int kCount) {
            this(node, dist);
            this.kCount = kCount;
        }

        @Override
        public int compareTo(Cost cost) {
            if (this.dist == cost.dist) {
                return this.kCount - cost.kCount;
            }
            return this.dist < cost.dist ? -1 : 1;
        }
    }

    static void initDists() {
        for (int i = 0; i < dists.length; i++) {
            for (int j = 0; j < dists[0].length; j++) {
                dists[i][j] = Long.MAX_VALUE;
            }
        }
    }

    static void dijkstra(int sNode) {
        PriorityQueue<Cost> queue = new PriorityQueue<>();
        queue.offer(new Cost(sNode, 0, 0));
        dists[sNode][0] = 0;

        while (!queue.isEmpty()) {
            Cost curr = queue.poll();
            if (curr.dist > dists[curr.node][curr.kCount]) {
                continue;
            }
            for (Cost nCost : graph.get(curr.node)) {
                long nDist = curr.dist + nCost.dist;
                if (nDist < dists[nCost.node][curr.kCount]) { // 포장없이 원래 다익스트라 갱신로직
                    dists[nCost.node][curr.kCount] = nDist;
                    queue.offer(new Cost(nCost.node, nDist, curr.kCount));
                }

                // 포장으로 도로비용 추가 없이 갱신. 포장 카운트+1
                if (curr.kCount < kLimit && curr.dist < dists[nCost.node][curr.kCount + 1]) {
                    dists[nCost.node][curr.kCount + 1] = curr.dist;
                    queue.offer(new Cost(nCost.node, curr.dist, curr.kCount + 1));
                }
            }
        }
    }

    static void sol() throws IOException {
        long answer = Long.MAX_VALUE;
        initDists();
        dijkstra(1);

        for (int kCount = 0; kCount < dists[0].length; kCount++) {
            answer = Math.min(answer, dists[n][kCount]);
        }

        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        kLimit = Integer.parseInt(st.nextToken());
        dists = new long[n + 1][kLimit + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Cost(e, dist));
            graph.get(e).add(new Cost(s, dist));
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}